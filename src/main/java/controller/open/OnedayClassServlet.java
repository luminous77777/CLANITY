package controller.open;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Member;
import domain.dto.Criteria;
import domain.en.MemberRole;
import domain.onedayClass.OnedayClass;
import lombok.extern.slf4j.Slf4j;
import service.ClassService;
import util.AlertUtil;
import util.ParamUtil;

@Slf4j
@WebServlet("/openClassRegister/open")
public class OnedayClassServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//  불러오기
		req.getRequestDispatcher("/WEB-INF/views/openClassRegister/open.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// 세션 체크 먼저 하고 
		Object obj = req.getSession().getAttribute("member");
		if(obj == null || !(obj instanceof Member)) {
			log.info("{멤버 상태}", obj);
			// 비로그인상태
			AlertUtil.redirectAlert("로그인 후 이용해 주세요","/index","red",req,resp);
			return;
		}
		Member member = (Member) obj;
		if(member.getRole() == MemberRole.MEMBER) {
			// 평회원 사유
			AlertUtil.redirectAlert("비즈니스 회원 인증 후 이용해 주세요","/index","red",req,resp);
			return;
		}
//		글번호나 qetQs사용시 필요 이거 어떻게 사용할지 보기
		Criteria cri = Criteria.initUrl(req);
		// 서비스 등록
		ClassService classService = new ClassService();
		
		 OnedayClass onedayClass = ParamUtil.get(req, OnedayClass.class);
		 onedayClass.setBusinessId(member.getMemberId());
	
		// 3. 그 후 insert 진행
		 // 상태 기본값 트루로 진행(이거 나중에 바꾸기)
	      onedayClass.setStatus(true);
	      
//	      log.info("제목: {}", onedayClass.getTitle());
	      
//	      log.info("카테고리 ID: {}", onedayClass.getCategoryId());

//	      등록
	     classService.register(onedayClass);
//	     log.info("클래스:{}", onedayClass);

//		log.info("classId: {}, url: {}", onedayClass.getClassId(), onedayClass.getUrl());

//	     등록 후에 url 등록은 (이거 enroll 쪽에 jsp있음)
		 String url = "/classDetailedPage?classId=" + onedayClass.getClassId() + "&openId=" + onedayClass.getOpenId();
		 onedayClass.setUrl(url);
		 classService.updateUrlLink(onedayClass);

//		 log.info("URl : {}", url );
//		 추가하기
		AlertUtil.alert("클래스 개설 신청이 완료되었습니다.", url , req, resp);
	}

}
