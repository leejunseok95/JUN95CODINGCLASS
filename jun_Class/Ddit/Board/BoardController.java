package controller;

//import java.sql.SQLException;
import java.util.List;

import dao.BoardDAO;
import vo.BoardLhVO;
import vo.BoardVO;
import vo.MemberVO;

public class BoardController {
	private BoardController() {
	}

	private static BoardController instance;

	public static BoardController getBoardController() {
		if (instance == null) {
			instance = new BoardController();
		}
		return instance;
	}
	
	BoardDAO boardDao = BoardDAO.getBoardDAO();

	public int controllerRegisterBoard(BoardVO boardVO) {
		return boardDao.registerBoard(boardVO);
	}

	public int controllerModifyBoard(BoardVO boardVO) {
		return boardDao.modifyBoard(boardVO);
	}

	public int controllerDeleteBoard(BoardVO boardVO) {
		// 2.해당 게시판에 댓글이 있다면 삭제
		boardDao.deleteCommentInBoard(boardVO);
		// 3. BOARD_LH 관계도 있어서 그것도 같이 삭제
		boardDao.deleteBoardLHInBoard(boardVO);
		// 4.댓글이 없다면 게시판 삭제
		return boardDao.deleteBoard(boardVO);
	}

	public List<BoardVO> controllerPrintBoard(){
		return boardDao.printOutBoard();
	}

	public MemberVO controllerCheckAuthorBoard(BoardVO boardVO) {
		return boardDao.checkBoardAuthor(boardVO);
	}

	public int controllerUseAnon(BoardVO boardVO) {
		if (boardVO.getBoardContent().equals("y") || boardVO.getBoardContent().equals("Y")) {
			return boardDao.anoymousBoard(boardVO);			
		} else {			
			return boardDao.realNameBoard(boardVO);
		}
	}

	//같은 아이디를 가진 사람은 두번 못 누르게 해야한다.
	public int pressLikeOrHateBoard(BoardVO boardVO, MemberVO memberVO, BoardLhVO boardLhVO) {
		//만약 좋아요가 눌러진 상황이면 다시 눌렀을 때 취소하면서 n으로 바꾸고, 싫어요를 눌렀으면 좋아요가 취소되면서 싫어요가 증가
		if (boardDao.checkLikeHateOnBoard(boardLhVO).getBoardLH().equals("l") || boardDao.checkLikeHateOnBoard(boardLhVO).getBoardLH().equals("L")) {
			if (boardLhVO.getBoardLH().equals("h") || boardLhVO.getBoardLH().equals("H")) {
				boardLhVO.setBoardLH("h");
				boardDao.makeLHtoNBoardLH(boardLhVO);
				
				return boardDao.hateBoard(boardVO);
			}			
			
			boardLhVO.setBoardLH("n");
			boardDao.makeLHtoNBoardLH(boardLhVO);
			return boardDao.cancelLikeBoard(boardVO);
			
		} else if(boardDao.checkLikeHateOnBoard(boardLhVO).getBoardLH().equals("h") ||	boardDao.checkLikeHateOnBoard(boardLhVO).getBoardLH().equals("H")){
			if (boardLhVO.getBoardLH().equals("l") || boardLhVO.getBoardLH().equals("L")) {
				boardLhVO.setBoardLH("l");
				boardDao.makeLHtoNBoardLH(boardLhVO);
				
				return boardDao.likeBoard(boardVO);
			}
				
			boardLhVO.setBoardLH("n");
			boardDao.makeLHtoNBoardLH(boardLhVO);
			return boardDao.cancelHateBoard(boardVO);
			
		} else {
			boardLhVO.setBoardLH("n");
			return boardDao.makeLHtoNBoardLH(boardLhVO);
		}
	}
	
//	public int pressLikeBoard(BoardVO boardVO, MemberVO memberVO) {
//		if (boardDao.checkLikeHateOnBoard(boardVO, memberVO).equals("l") ||	boardDao.checkLikeHateOnBoard(boardVO, memberVO).equals("L")) {
//			return boardDao.cancelLikeBoard(boardVO);			
//		} else {
//			
//			return boardDao.likeBoard(boardVO);
//		}
//	}
//
//	public int pressHateBoard(BoardVO boardVO, MemberVO memberVO) {
//		if (boardDao.checkLikeHateOnBoard(boardVO, memberVO).equals("h") ||	boardDao.checkLikeHateOnBoard(boardVO, memberVO).equals("H")) {
//			return boardDao.cancelHateBoard(boardVO);
//		} else {
//			return boardDao.hateBoard(boardVO);
//		}
//	}

	public BoardVO controllerPrintLikeBoardNum(BoardVO boardVO) {
		return boardDao.printCountLikeBoard(boardVO);
	}

	public BoardVO controllerPrintHateBoardNum(BoardVO boardVO) {
		 return boardDao.printCountHateBoard(boardVO);
		
	}

}
