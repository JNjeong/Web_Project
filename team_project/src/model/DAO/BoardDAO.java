package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.VO.BoardVO;
import model.common.JDBCUtil;

public class BoardDAO {
	/* DB연결에 사용할 객체들 선언 */
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	   
	/* DB에서 사용될 sql구문 정의 */
	String sql_insert = "";
	String sql_selectOne = "";
	String sql_update = "";
	String sql_delete = "";
	String sql_selectAll = "";
	String sql_selectFiltered = "";
	String sql_selectLikeFiltered = "";
	
	public boolean BrdInsert(BoardVO boardvo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_insert);
			//TODO
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
			pstmt = conn.prepareStatement(sql_insert);
			//TODO
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
			pstmt = conn.prepareStatement(sql_insert);
			//TODO
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
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_insert);
			//TODO
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
			pstmt = conn.prepareStatement(sql_insert);
			//TODO
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
			pstmt = conn.prepareStatement(sql_insert);
			//TODO
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
			pstmt = conn.prepareStatement(sql_insert);
			//TODO
		} catch (SQLException e) {
			System.out.println("BoardDAO에서 dislike구문 실행중 에러 발생!");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	
	public ArrayList<BoardVO> BrdSearchFilter(String type, String result) {
		ArrayList<BoardVO> arrboard = new ArrayList<BoardVO>();
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_insert);
			//TODO
		} catch (SQLException e) {
			System.out.println("BoardDAO에서 insert구문 실행중 에러 발생!");
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return arrboard;
	}
	
	public ArrayList<BoardVO> BrdLikeFilter() {
		ArrayList<BoardVO> arrboard = new ArrayList<BoardVO>();
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_insert);
			//TODO
		} catch (SQLException e) {
			System.out.println("BoardDAO에서 insert구문 실행중 에러 발생!");
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return arrboard;
	}
}
