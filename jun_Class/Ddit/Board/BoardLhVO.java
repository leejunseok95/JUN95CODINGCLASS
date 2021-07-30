package vo;

import java.util.Objects;

public class BoardLhVO {
	private String LH;
	private String memId;
	private int boardIDX;
	
	public BoardLhVO(String LH, String memId, int boardIDX) {
		super();
		this.LH = LH;
		this.memId = memId;
		this.boardIDX = boardIDX;
	}
	public BoardLhVO() {
	}
	
	public BoardLhVO(String LH) {
		this.LH = LH;
	}

	public String getBoardLH() {
		return LH;
	}

	public void setBoardLH(String LH) {
		this.LH = LH;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public int getBoardIDX() {
		return boardIDX;
	}

	public void setBoardIDX(int boardIDX) {
		this.boardIDX = boardIDX;
	}

	@Override
	public int hashCode() {
		return Objects.hash(boardIDX, LH, memId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardLhVO other = (BoardLhVO) obj;
		return boardIDX == other.boardIDX && Objects.equals(LH, other.LH)
				&& Objects.equals(memId, other.memId);
	}

	@Override
	public String toString() {
		return "BoardLhVO [boardLH=" + LH + ", memId=" + memId + ", boardIDX=" + boardIDX + "]";
	}
}
