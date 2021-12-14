package model.VO;

public class CommentVO {
	private int cmtcode;
	private int cmdbrdcode;
	private int cmtusercode;
	private String cmtwriter;
	private String cmtcontent;
	
	public int getCmtcode() {
		return cmtcode;
	}
	public void setCmtcode(int cmtcode) {
		this.cmtcode = cmtcode;
	}
	public int getCmdbrdcode() {
		return cmdbrdcode;
	}
	public void setCmdbrdcode(int cmdbrdcode) {
		this.cmdbrdcode = cmdbrdcode;
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
		return "CommentVO [cmtcode=" + cmtcode + ", cmdbrdcode=" + cmdbrdcode + ", cmtusercode=" + cmtusercode
				+ ", cmtwriter=" + cmtwriter + ", cmtcontent=" + cmtcontent + "]";
	}
	
	
}
