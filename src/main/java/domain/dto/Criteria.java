package domain.dto;

import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class Criteria { // 페이징 처리 + 검색 조건 전달
//페이지 숫자
	private int page = 1; // 현재 페이지 번호 (기본값 1)
	private int amount = 20; // 한 페이지당 게시글 수 (기본값 10)
	private Long categoryId = 1L; // 카테고리 번호
	private String type = ""; // 검색조건 (Title, Content)
	private String keyword = ""; // 검색어
	
//	추가하기(클래스아이디랑 오픈 아이디)
	private Long classId;
	private Long openId;




	
	// 페이지, 게시글 개수, 카테고리 번호로 Cri 재설정
	public Criteria(int page, int amount, Long categoryId) {
		this.page = page;
		this.amount = amount;
		this.categoryId = categoryId;
	}

	// DB LIMIT SQL용 offset 설정
	public int getOffset() {
		int offset = amount * (page - 1);
		return offset;
	}

	// 검색용 타입분석 "TC" -> "T","C"
	public String[] getTypes() {
		String[] arr = null;
		if (type != null && !type.equals("")) {
			arr = type.split("");
		}
		return arr;
	}

	public static Criteria init(HttpServletRequest req) {
		Criteria cri = new Criteria();
		try {
			cri.categoryId = Long.parseLong(req.getParameter("categoryId"));
			cri.page = Integer.parseInt(req.getParameter("page"));
			cri.amount = Integer.parseInt(req.getParameter("amount"));
			cri.type = req.getParameter("type");
			cri.keyword = URLDecoder.decode(req.getParameter("keyword"), "utf-8");
		} catch (Exception e) {
		}
		return cri;
	}
	// 카테고리 뺀 버전(카테고리 목록에서 사용 중)
	public static Criteria initList(HttpServletRequest req) {
		Criteria cri = new Criteria();
		try {
			cri.page = Integer.parseInt(req.getParameter("page"));
			cri.amount = Integer.parseInt(req.getParameter("amount"));
			cri.type = req.getParameter("type");
			cri.keyword = URLDecoder.decode(req.getParameter("keyword"), "utf-8");
		} catch (Exception e) {
		}
		return cri;
	}


	// 검색어 쿼리스트링으로 url에 담아서 가져가기
	public String getQs() {
		String[] strs = { "categoryId=" + categoryId, "amount=" + amount, "type=" + type, "keyword=" + keyword };

		String str = String.join("&", strs);
		return str;

	}

	public String getQs2() {
		return getQs() + "&page=" + page;
	}

	// 카테고리 목록에 필요한 QS임시로 만들어 두었습니다!
	public String getQs3() {
		String[] strs = { "amount=" + amount };

		String str = String.join("&", strs);
		return str;
	}
	// 상세페이지 아이디 조회 QS임시로 만들어 두었습니다! (나중에 수정 예정)
	public String getQsClass() {
		String[] strs = { "classId=" + classId,  "openId=" + openId };

		String str = String.join("&", strs);
		return str;
	}
	//  클래스 상세 페이지 url
	public static Criteria initUrl(HttpServletRequest req) {
		Criteria cri = new Criteria();
		try {
			cri.classId =  Long.parseLong(req.getParameter("classId"));
			cri.openId =  Long.parseLong(req.getParameter("openId"));

		} catch (Exception e) {
		}
		return cri;
	}
}