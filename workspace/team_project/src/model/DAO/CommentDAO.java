package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.VO.BoardVO;
import model.VO.CommentVO;
import model.common.JDBCUtil;

public class CommentDAO {
	/* DB연결에 사용할 객체들 선언 */
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	/* DB에서 사용될 sql구문 정의 */
	String sql_selectAll = "";
	String sql_insert = "";
	String sql_update = "";
	String sql_delete = "";

	public ArrayList<CommentVO> CmtSelectAll(BoardVO boardvo) {
		ArrayList<CommentVO> arrcmt = new ArrayList<CommentVO>();
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_selectAll);
			//TODO
			
		} catch (SQLException e) {
			System.out.println("CommentDAO에서 selectAll구문 실행중 에러 발생!");
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return arrcmt;
	}
	
	public boolean CmtInsert(CommentVO commentvo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_insert);
			//TODO
			
		} catch (SQLException e) {
			System.out.println("CommentDAO에서 insert구문 실행중 에러 발생!");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	
	public boolean CmtUpdate(CommentVO commentvo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_update);
			//TODO
			
		} catch (SQLException e) {
			System.out.println("CommentDAO에서 update구문 실행중 에러 발생!");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	
	public boolean CmtDelete(CommentVO commentvo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_delete);
			//TODO
			
		} catch (SQLException e) {
			System.out.println("CommentDAO에서 delete구문 실행중 에러 발생!");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
}
