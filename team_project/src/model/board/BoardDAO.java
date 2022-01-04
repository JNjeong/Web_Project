package model.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JDBCUtil;
import model.user.UserVO;

public class BoardDAO {
	/* DB연결에 사용할 객체들 선언 */
	Connection conn;
	PreparedStatement pstmt;
	   
	/* DB에서 사용될 sql구문 정의 */
	String sql_insert = "INSERT INTO TB_BOARD (BRDCODE, BRDUSERCODE, BRDTITLE, BRDWRITER, BRDCONTENT) VALUES(BRDSEQ.NEXTVAL, ?, ?, ?, ?)";
	String sql_selectOne = "SELECT BRDCODE, BRDUSERCODE, BRDTITLE, BRDWRITER, BRDCONTENT, TO_CHAR(BRDDATE, 'YYYYMMDD') BRDDATE, BRDVISITED, BRDLIKE, BRDDISLIKE FROM TB_BOARD WHERE BRDCODE=?";
	String sql_update = "UPDATE TB_BOARD SET BRDTITLE=?, BRDCONTENT=? WHERE BRDCODE=?";
	String sql_delete = "DELETE FROM TB_BOARD WHERE BRDCODE=?";
	String sql_selectAll = "SELECT BRDCODE, BRDUSERCODE, BRDTITLE, BRDWRITER, BRDCONTENT, TO_CHAR(BRDDATE, 'YYYY/MM/DD') BRDDATE, BRDVISITED, BRDLIKE, BRDDISLIKE FROM TB_BOARD ORDER BY BRDCODE DESC";
	String sql_like = "UPDATE TB_BOARD SET BRDLIKE = BRDLIKE+1 WHERE BRDCODE=?";
	String sql_dislike = "UPDATE TB_BOARD SET BRDDISLIKE=BRDDISLIKE+1 WHERE BRDCODE=?";
	String sql_selectFiltered = "SELECT BRDCODE, BRDUSERCODE, BRDTITLE, BRDWRITER, BRDCONTENT, TO_CHAR(BRDDATE, 'YYYY/MM/DD') BRDDATE, BRDVISITED, BRDLIKE, BRDDISLIKE FROM TB_BOARD WHERE";
	String sql_selectLikeFiltered = "SELECT * FROM (SELECT BRDCODE, BRDUSERCODE, BRDTITLE, BRDWRITER, BRDCONTENT, TO_CHAR(BRDDATE, 'YYYY/MM/DD') AS BRDDATE, BRDVISITED, BRDLIKE, BRDDISLIKE FROM TB_BOARD WHERE BRDLIKE>0 ORDER BY BRDLIKE DESC) WHERE ROWNUM <= 8";
	String sql_visited = "UPDATE TB_BOARD SET BRDVISITED=BRDVISITED+1 WHERE BRDCODE=?";
	
	public boolean BrdInsert(BoardVO boardvo, UserVO uservo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_insert);
			pstmt.setInt(1, uservo.getUsercode());
			pstmt.setString(2, boardvo.getBrdtitle());
			pstmt.setString(3, boardvo.getBrdwriter());
			pstmt.setString(4, boardvo.getBrdcontent());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("BoardDAO에서 insert구문 실행중 에러 발생!");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	
	public boolean BrdUpdate(BoardVO boardvo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_update);
			pstmt.setString(1, boardvo.getBrdtitle());
			pstmt.setString(2, boardvo.getBrdcontent());
			pstmt.setInt(3, boardvo.getBrdcode());
			pstmt.executeUpdate();			
		} catch (SQLException e) {
			System.out.println("BoardDAO에서 update구문 실행중 에러 발생!");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	
	public boolean BrdDelete(BoardVO boardvo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_delete);
			pstmt.setInt(1, boardvo.getBrdcode());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("BoardDAO에서 delete구문 실행중 에러 발생!");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	
	public ArrayList<BoardVO> BrdSelectAll() {
		ArrayList<BoardVO> arrboard = new ArrayList<BoardVO>();
		BoardVO vo = null;
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_selectAll);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new BoardVO();
				vo.setBrdcode(rs.getInt("BRDCODE"));
				vo.setBrdusercode(rs.getInt("BRDUSERCODE"));
				vo.setBrdtitle(rs.getString("BRDTITLE"));
				vo.setBrdwriter(rs.getString("BRDWRITER"));
				vo.setBrdcontent(rs.getString("BRDCONTENT"));
				vo.setBrddate(rs.getString("BRDDATE"));
				vo.setBrdvisited(rs.getInt("BRDVISITED"));
				vo.setBrdlike(rs.getInt("BRDLIKE"));
				vo.setBrddislike(rs.getInt("BRDDISLIKE"));
				arrboard.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("BoardDAO에서 selectAll구문 실행중 에러 발생!");
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return arrboard;
	}
	
	public BoardVO BrdSelectOne(BoardVO boardvo) {
		BoardVO vo = null;
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_selectOne);
			pstmt.setInt(1, boardvo.getBrdcode());
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			vo = new BoardVO();
			vo.setBrdcode(rs.getInt("BRDCODE"));
			vo.setBrdusercode(rs.getInt("BRDUSERCODE"));
			vo.setBrdtitle(rs.getString("BRDTITLE"));
			vo.setBrdwriter(rs.getString("BRDWRITER"));
			vo.setBrdcontent(rs.getString("BRDCONTENT"));
			vo.setBrddate(rs.getString("BRDDATE"));
			vo.setBrdvisited(rs.getInt("BRDVISITED"));
			vo.setBrdlike(rs.getInt("BRDLIKE"));
			vo.setBrddislike(rs.getInt("BRDDISLIKE"));
		} catch (SQLException e) {
			System.out.println("BoardDAO에서 selectOne구문 실행중 에러 발생!");
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return vo;
	}
	
	public boolean BrdLike(BoardVO boardvo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_like);
			pstmt.setInt(1, boardvo.getBrdcode());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("BoardDAO에서 like구문 실행중 에러 발생!");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	
	public boolean BrdDislike(BoardVO boardvo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_dislike);
			pstmt.setInt(1, boardvo.getBrdcode());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("BoardDAO에서 dislike구문 실행중 에러 발생!");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	
	public boolean BrdVisited(BoardVO boardvo) {
		conn=JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_visited);
			pstmt.setInt(1, boardvo.getBrdcode());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("BoardDAO에서 visited구문 실행중 에러 발생!");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	
	public ArrayList<BoardVO> BrdSearchFilter(String type, String result) {
		ArrayList<BoardVO> arrboard = new ArrayList<BoardVO>();
		BoardVO vo = null;
		conn = JDBCUtil.connect();
		try {			
			pstmt = conn.prepareStatement(sql_selectFiltered +" "+type+" "+ "LIKE '%" +result+ "%'");
			ResultSet rs = pstmt.executeQuery();			
			while(rs.next()) {
				vo = new BoardVO();
				vo.setBrdcode(rs.getInt("BRDCODE"));
				vo.setBrdusercode(rs.getInt("BRDUSERCODE"));
				vo.setBrdtitle(rs.getString("BRDTITLE"));
				vo.setBrdwriter(rs.getString("BRDWRITER"));
				vo.setBrdcontent(rs.getString("BRDCONTENT"));
				vo.setBrddate(rs.getString("BRDDATE"));
				vo.setBrdvisited(rs.getInt("BRDVISITED"));
				vo.setBrdlike(rs.getInt("BRDLIKE"));
				vo.setBrddislike(rs.getInt("BRDDISLIKE"));
				
				arrboard.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("BoardDAO에서 BrdSearchFilter구문 실행중 에러 발생!");
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return arrboard;
	}
	
	public ArrayList<BoardVO> BrdLikeFilter() {
		ArrayList<BoardVO> arrboard = new ArrayList<BoardVO>();
		BoardVO vo = null;
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_selectLikeFiltered);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new BoardVO();
				vo.setBrdcode(rs.getInt("BRDCODE"));
				vo.setBrdusercode(rs.getInt("BRDUSERCODE"));
				vo.setBrdtitle(rs.getString("BRDTITLE"));
				vo.setBrdwriter(rs.getString("BRDWRITER"));
				vo.setBrdcontent(rs.getString("BRDCONTENT"));
				vo.setBrddate(rs.getString("BRDDATE"));
				vo.setBrdvisited(rs.getInt("BRDVISITED"));
				vo.setBrdlike(rs.getInt("BRDLIKE"));
				vo.setBrddislike(rs.getInt("BRDDISLIKE"));
				
				arrboard.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("BoardDAO에서 BrdLikeFilter구문 실행중 에러 발생!");
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return arrboard;
	}
}
