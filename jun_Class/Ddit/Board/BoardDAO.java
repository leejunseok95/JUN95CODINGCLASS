package dao;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;
import vo.BoardLhVO;
import vo.BoardVO;
import vo.MemberVO;

public class BoardDAO implements BoardImplement{
	private BoardDAO() {}
	private static BoardDAO instance;
	
	public static BoardDAO getBoardDAO() {
		if (instance == null) {
			instance = new BoardDAO();
		}
		return instance;
	}
	
	private JDBCUtil util = JDBCUtil.getInstance();

	@Override
	public int registerBoard(BoardVO boardVO) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO BOARD(BOARD_IDX, BOARD_TITLE, BOARD_CONTENT");
		sql.append(", BOARD_ANON, MEM_ID)");
		sql.append("VALUES(?, ?, ?, ?, ?)");
		
		List<Object> list = new ArrayList<Object>();
		list.add(boardVO.getBoardIDX());
		list.add(boardVO.getBoardTitle());
		list.add(boardVO.getBoardContent());
		list.add(boardVO.getBoardAnon());
		list.add(boardVO.getMemId());
		
		return util.update(sql.toString(), list);
	}
	
	@Override
	public MemberVO checkBoardAuthor(BoardVO boardVO) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT M.MEM_NM ");
		sql.append("  FROM MEMBER M, BOARD B ");
		sql.append(" WHERE M.MEM_ID = B.MEM_ID ");
		sql.append("   AND B.BOARD_IDX = ?");
		
		List<Object> list = new ArrayList<Object>();
		list.add(boardVO.getBoardIDX());
		
		MemberVO memberVO = new MemberVO(util.selectOne(sql.toString(),list).get("MEM_NM")+"");
		
		return memberVO;
	}

	@Override
	public int modifyBoard(BoardVO boardVO) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE BOARD");
		sql.append("   SET BOARD_TITLE = ?,");
		sql.append("   	   BOARD_CONTENT = ?,");
		sql.append("   	   BOARD_ANON = ?  ");
		sql.append(" WHERE MEM_ID = ?");
		sql.append("   AND BOARD_IDX = ?");
		
		List<Object> list = new ArrayList<Object>();
		list.add(boardVO.getBoardTitle());
		list.add(boardVO.getBoardContent());
		list.add(boardVO.getBoardAnon());
		list.add(boardVO.getMemId());
		list.add(boardVO.getBoardIDX());
		
		return util.update(sql.toString(), list);
	}

	@Override
	public int deleteCommentInBoard(BoardVO boardVO) {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM COMMENT WHERE BOARD_IDX = ?");
		
		List<Object> list = new ArrayList<Object>();
		list.add(boardVO.getBoardIDX());
		
		return util.update(sql.toString(), list);
	}
	
	@Override
	public int deleteBoardLHInBoard(BoardVO boardVO) {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM BOARD_LH WHERE BOARD_IDX = ?");
		
		List<Object> list = new ArrayList<Object>();
		list.add(boardVO.getBoardIDX());
		
		return util.update(sql.toString(), list);
	}
	
	@Override
	public int deleteBoard(BoardVO boardVO) {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM BOARD WHERE BOARD_IDX = ?");
		
		List<Object> list = new ArrayList<Object>();
		list.add(boardVO.getBoardIDX());
		
		return util.update(sql.toString(), list);
	}

	@Override
	public List<BoardVO> printOutBoard() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT BOARD_IDX , BOARD_TITLE , BOARD_CONTENT,");
		sql.append(" 		BOARD_DATE, BOARD_ANON, BOARD_LIKE,");
		sql.append(" 		BOARD_HATE, MEM_ID");
		sql.append("   FROM BOARD");
		
		List<Map<String, Object>> map = util.selectList(sql.toString());
		List<BoardVO> boardList = new ArrayList<>();
		
		for (int i = 0; i < map.size(); i++) {
			BoardVO boardVO = new BoardVO();
			boardVO.setBoardIDX(Integer.parseInt(map.get(i).get("BOARD_IDX").toString()));
			boardVO.setBoardTitle((map.get(i).get("BOARD_TITLE").toString()));
			boardVO.setBoardContent(map.get(i).get("BOARD_CONTENT").toString());
			boardVO.setBoardDate(map.get(i).get("BOARD_DATE").toString());
			boardVO.setBoardAnon(map.get(i).get("BOARD_ANON").toString());
			boardVO.setBoardLike(Integer.parseInt(map.get(i).get("BOARD_LIKE").toString()));
			boardVO.setBoardHate(Integer.parseInt(map.get(i).get("BOARD_HATE").toString()));
			boardVO.setMemId(map.get(i).get("MEM_ID").toString());
			boardList.add(boardVO);
		}
		
		return boardList;
		
//		String url = "jdbc:mariadb://adg0807.cafe24.com:3306/adg0807";
//		String user = "adg0807";
//		String password = "dAegeun1!";
//		
//		try {
//			Class.forName("org.mariadb.jdbc.Driver");
//			
//			Connection con = DriverManager.getConnection(url, user, password);
//			
//			PreparedStatement ps = con.prepareStatement(sql.toString());
//			
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next()) {
//				if(!(rs.getObject("BOARD_TITLE") instanceof String)) {
//					System.out.println(rs.getString("BOARD_TITLE"));
//				}
//			}
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//		}
//		
//		return null;
	}

	@Override
	public int anoymousBoard(BoardVO boardVO) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE BOARD ");
		sql.append("   SET BOARD_ANON = 'y'");
		sql.append(" WHERE BOARD_IDX = ?");
		
		List<Object> list = new ArrayList<Object>();
		list.add(boardVO.getBoardIDX());
		
		return util.update(sql.toString(), list);
	}
	
	@Override
	public int realNameBoard(BoardVO boardVO) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE BOARD ");
		sql.append("   SET BOARD_ANON = 'n'");
		sql.append(" WHERE BOARD_IDX = ?");
		
		List<Object> list = new ArrayList<Object>();
		list.add(boardVO.getBoardIDX());
		
		return util.update(sql.toString(), list);
	}

	@Override
	public BoardLhVO checkLikeHateOnBoard(BoardLhVO boardLhVO) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT LH");
		sql.append("  FROM BOARD_LH");
		sql.append(" WHERE MEM_ID = ?");
		sql.append("   AND BOARD_IDX = ?");
		
		List<Object> list = new ArrayList<Object>();
		list.add(boardLhVO.getMemId());
		list.add(boardLhVO.getBoardIDX());
		
		String boardLikeNum = util.selectOne(sql.toString(),list).get("LH").toString();
		boardLhVO.setBoardLH(boardLikeNum);
		
		return boardLhVO;
	}
	
	@Override
	public int likeBoard(BoardVO boardVO) {
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE BOARD ");
		sql.append("   SET BOARD_LIKE = BOARD_LIKE+1");
		sql.append(" WHERE BOARD_IDX = ?");
		
		List<Object> list = new ArrayList<Object>();
		list.add(boardVO.getBoardIDX());
		
		return util.update(sql.toString(), list);
	}
	
	@Override
	public int cancelLikeBoard(BoardVO boardVO) {
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE BOARD ");
		sql.append("   SET BOARD_LIKE = BOARD_LIKE-1");
		sql.append(" WHERE BOARD_IDX = ?");
		
		List<Object> list = new ArrayList<Object>();
		list.add(boardVO.getBoardIDX());
		
		return util.update(sql.toString(), list);
	}

	@Override
	public int hateBoard(BoardVO boardVO) {
		StringBuilder sql = new StringBuilder();
		sql.append("  UPDATE BOARD ");
		sql.append("   SET BOARD_HATE = BOARD_HATE+1");
		sql.append(" WHERE BOARD_IDX = ?");
		
		List<Object> list = new ArrayList<Object>();
		list.add(boardVO.getBoardIDX());
		
		return util.update(sql.toString(), list);
	}

	@Override
	public int cancelHateBoard(BoardVO boardVO) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE BOARD ");
		sql.append("   SET BOARD_HATE = BOARD_HATE-1");
		sql.append(" WHERE BOARD_IDX = ?");
		
		List<Object> list = new ArrayList<Object>();
		list.add(boardVO.getBoardIDX());
		
		return util.update(sql.toString(), list);
	}
	
	@Override
	public int makeLHtoNBoardLH(BoardLhVO boardLhVO) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE BOARD_LH");
		sql.append("    SET LH = ?");
		sql.append("  WHERE MEM_ID =?");
		sql.append("    AND BOARD_IDX = ?");
		
		List<Object> list = new ArrayList<Object>();		
		list.add(boardLhVO.getBoardLH());
		list.add(boardLhVO.getMemId());
		list.add(boardLhVO.getBoardIDX());
		
		return util.update(sql.toString(), list);
	}

	@Override
	public BoardVO printCountLikeBoard(BoardVO boardVO) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT BOARD_LIKE ");
		sql.append("   FROM BOARD");
		sql.append("  WHERE BOARD_IDX = ?");
		
		List<Object> list = new ArrayList<Object>();
		list.add(boardVO.getBoardIDX());
		
		int boardLikeNum = Integer.parseInt(util.selectOne(sql.toString(),list).get("BOARD_LIKE").toString());
		boardVO.setBoardLike(boardLikeNum);
		
		return boardVO;
	}

	@Override
	public BoardVO printCountHateBoard(BoardVO boardVO) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT BOARD_HATE ");
		sql.append("   FROM BOARD");
		sql.append("  WHERE BOARD_IDX = ?");
		
		List<Object> list = new ArrayList<Object>();
		list.add(boardVO.getBoardIDX());
		
		int boardLikeNum = Integer.parseInt(util.selectOne(sql.toString(),list).get("BOARD_HATE").toString());
		boardVO.setBoardHate(boardLikeNum);
		
		return boardVO;
	}
}
