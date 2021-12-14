package model.VO;

public class BoardVO {
	private int brdcode;
	private int brdusercode;
	private String brdtitle;
	private String brdwriter;
	private String brdcontent;
	private String brddate;
	private int brdvisited;
	private int brdlike;
	private int brddislike;
	
	public int getBrdcode() {
		return brdcode;
	}
	public void setBrdcode(int brdcode) {
		this.brdcode = brdcode;
	}
	public int getBrdusercode() {
		return brdusercode;
	}
	public void setBrdusercode(int brdusercode) {
		this.brdusercode = brdusercode;
	}
	public String getBrdtitle() {
		return brdtitle;
	}
	public void setBrdtitle(String brdtitle) {
		this.brdtitle = brdtitle;
	}
	public String getBrdwriter() {
		return brdwriter;
	}
	public void setBrdwriter(String brdwriter) {
		this.brdwriter = brdwriter;
	}
	public String getBrdcontent() {
		return brdcontent;
	}
	public void setBrdcontent(String brdcontent) {
		this.brdcontent = brdcontent;
	}
	public String getBrddate() {
		return brddate;
	}
	public void setBrddate(String brddate) {
		this.brddate = brddate;
	}
	public int getBrdvisited() {
		return brdvisited;
	}
	public void setBrdvisited(int brdvisited) {
		this.brdvisited = brdvisited;
	}
	public int getBrdlike() {
		return brdlike;
	}
	public void setBrdlike(int brdlike) {
		this.brdlike = brdlike;
	}
	public int getBrddislike() {
		return brddislike;
	}
	public void setBrddislike(int brddislike) {
		this.brddislike = brddislike;
	}
	@Override
	public String toString() {
		return "BoardVO [brdcode=" + brdcode + ", brdusercode=" + brdusercode + ", brdtitle=" + brdtitle
				+ ", brdwriter=" + brdwriter + ", brdcontent=" + brdcontent + ", brddate=" + brddate + ", brdvisited="
				+ brdvisited + ", brdlike=" + brdlike + ", brddislike=" + brddislike + "]";
	}
	
	
}
