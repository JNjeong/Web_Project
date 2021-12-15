package model.comment;

public class CommentVO {
	private int cmtcode;
	private int cmtbrdcode;
	private int cmtusercode;
	private String cmtwriter;
	private String cmtcontent;
	
	public int getCmtcode() {
		return cmtcode;
	}
	public void setCmtcode(int cmtcode) {
		this.cmtcode = cmtcode;
	}
	public int getCmdtrdcode() {
		return cmtbrdcode;
	}
	public void setCmtbrdcode(int cmtbrdcode) {
		this.cmtbrdcode = cmtbrdcode;
	}
	public int getCmtusercode() {
		return cmtusercode;
	}
	public void setCmtusercode(int cmtusercode) {
		this.cmtusercode = cmtusercode;
	}
	public String getCmtwriter() {
		return cmtwriter;
	}
	public void setCmtwriter(String cmtwriter) {
		this.cmtwriter = cmtwriter;
	}
	public String getCmtcontent() {
		return cmtcontent;
	}
	public void setCmtcontent(String cmtcontent) {
		this.cmtcontent = cmtcontent;
	}
	@Override
	public String toString() {
		return "CommentVO [cmtcode=" + cmtcode + ", cmdbrdcode=" + cmtbrdcode + ", cmtusercode=" + cmtusercode
				+ ", cmtwriter=" + cmtwriter + ", cmtcontent=" + cmtcontent + "]";
	}
	
	
}
