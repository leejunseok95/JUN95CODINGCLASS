package vo;

import java.util.Objects;

public class BoardVO {
	private int boardIDX;
	private String boardTitle;
	private String boardContent;
	private String boardDate;
	private String boardAnon;
	private int boardLike;
	private int boardHate;
	private String memId;
	
	
	public BoardVO(int boardIDX, String boardTitle, String boardContent, String boardDate, String boardAnon,
			int boardLike, int boardHate, String memId) {
		super();
		this.boardIDX = boardIDX;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
		this.boardAnon = boardAnon;
		this.boardLike = boardLike;
		this.boardHate = boardHate;
		this.memId = memId;
	}
	public BoardVO() {
	}
	public BoardVO(String memId) {
		this.memId = memId;
	}

	public int getBoardIDX() {
		return boardIDX;
	}

	public void setBoardIDX(int boardIDX) {
		this.boardIDX = boardIDX;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}

	public String getBoardAnon() {
		return boardAnon;
	}

	public void setBoardAnon(String boardAnon) {
		this.boardAnon = boardAnon;
	}

	public int getBoardLike() {
		return boardLike;
	}

	public void setBoardLike(int boardLike) {
		this.boardLike = boardLike;
	}

	public int getBoardHate() {
		return boardHate;
	}

	public void setBoardHate(int boardHate) {
		this.boardHate = boardHate;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(boardAnon, boardContent, boardDate, boardHate, boardIDX, boardLike, boardTitle, memId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardVO other = (BoardVO) obj;
		return Objects.equals(boardAnon, other.boardAnon) && Objects.equals(boardContent, other.boardContent)
				&& Objects.equals(boardDate, other.boardDate) && Objects.equals(boardHate, other.boardHate)
				&& boardIDX == other.boardIDX && Objects.equals(boardLike, other.boardLike)
				&& Objects.equals(boardTitle, other.boardTitle) && Objects.equals(memId, other.memId);
	}

	@Override
	public String toString() {
		return "BoardVo [boardIDX=" + boardIDX + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardDate=" + boardDate + ", boardAnon=" + boardAnon + ", boardLike=" + boardLike + ", boardHate="
				+ boardHate + ", memId=" + memId + "]";
	}
}
