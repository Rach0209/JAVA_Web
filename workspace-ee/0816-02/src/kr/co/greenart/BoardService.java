package kr.co.greenart;

import java.sql.SQLException;
import java.util.List;

public class BoardService {
	// MVC패턴 연습.
	// 서비스 내용들
	// 게시글 보기 서비스.
	// 게시글 적기 서비스.
	// 게시글 수정 서비스.
	// 게시글 하나 내용 보기 서비스.
	
	private BoardDAO dao;
	
	public BoardService(BoardDAO dao) {
		this.dao = dao;
	}


	// 목록<게시글> 게시글목록보기서비스
	public List<BoardArticle> 게시글목록보기서비스() {
		// 필요한 로직을 포함하는 문장들!~! (트랜잭션 제어 등)
		try {
			return dao.게시글목록가져오기(); // 결과 반환
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("데이터를 읽을 수 없습니다."); // 간단하게 런타임 예외 발생시키기로 테스트함.
			// 재시도 로직 추가 가능~
		}
	}
}
