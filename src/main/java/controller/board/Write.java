package controller.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import domain.Attach;
import domain.Board;
import domain.Member;
import domain.dto.Criteria;
import lombok.extern.slf4j.Slf4j;
import service.BoardService;
import util.AlertUtil;
import util.ParamUtil;

@Slf4j
@WebServlet("/board/write")
public class Write extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//============= 세션 체크
		//session 내의 member attr 조회 후 null일 경우 *비로그인 상태로 접근
		Criteria cri = Criteria.init(req);
		if(req.getSession().getAttribute("member") == null) {
			AlertUtil.alert("로그인 후 글 작성해주세요", "/member/login?" + cri.getQs2(), req, resp, true);
			return;
		}
		String mode = req.getParameter("mode"); //답변하기 폼 조건문을 위한 값 전달
		req.setAttribute("mode", mode);
		req.setAttribute("cri", cri);
		req.getRequestDispatcher("/WEB-INF/views/board/write.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//============= 세션 체크
		Criteria cri = Criteria.init(req);
		if(req.getSession().getAttribute("member") == null) {
			AlertUtil.alert("로그인 후 글 작성해주세요", "/member/login?" + cri.getQs2(), req, resp, true);
			return;
		}
    	

		// 첨부파일 내용 수집
		String encodedStr = req.getParameter("encodedStr"); //현재 문자열
		Type type = new TypeToken<List<Attach>>() {}.getType(); 
		List<Attach> list = new Gson().fromJson(encodedStr, type);
		if(list == null) {
			list = new ArrayList<Attach>();
		}
		log.info("{}", list);
		
		// 파라미터 수집
		Board board = ParamUtil.get(req, Board.class);
		board.setAttachs(list);
		
		// board 인스턴스 생성
		log.info("{}", board);
		
		// 서비스 호출
		new BoardService().write(board);
		
		// 리디렉션 (board / list)
		AlertUtil.alert("글이 등록되었습니다", "/board/list?categoryId=" + cri.getCategoryId() + "&amount=" + cri.getAmount(), req, resp);
	}
}
