package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.VO.UserVO;
import model.common.JDBCUtil;

public class UserDAO {
	/* DB연결에 사용할 객체들 선언 */
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	   
	/* DB에서 사용될 sql구문 정의 */
	String sql_insert = "";
	String sql_update = "";
	String sql_delete = "";
	String sql_selectOne = "";
	String sql_userIdChk = "";
	

	
	public boolean UserInsert(UserVO uservo, boolean userIdChkResult) {
		if(userIdChkResult) {
			conn = JDBCUtil.connect();
			try {
				pstmt = conn.prepareStatement(sql_insert);
				//TODO
				
			} catch (SQLException e) {
				System.out.println("UserDAO에서 insert구문 실행중 에러 발생!");
				e.printStackTrace();
				return false;
			} finally {
				JDBCUtil.disconnect(pstmt, conn);
			}
			return true;
		}
		else {
			System.out.println("아이디 중복검사 결과가 false이므로 회원가입 실패!");
			return false;
		}
	}
	
	public boolean UserUpdate(UserVO uservo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_update);
			//TODO
			
		} catch (SQLException e) {
			System.out.println("UserDAO에서 update구문 실행중 에러 발생!");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	
	public boolean UserDelete(UserVO uservo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_delete);
			//TODO
			
		} catch (SQLException e) {
			System.out.println("UserDAO에서 delete구문 실행중 에러 발생!");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	
	public UserVO UserSelectOne(UserVO uservo) {
		UserVO vo = null;
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_insert);
			//TODO
			
		} catch (SQLException e) {
			System.out.println("UserDAO에서 delete구문 실행중 에러 발생!");
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return vo;
	}
	
	public boolean UserIdChk(UserVO uservo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_userIdChk);
			//TODO
			
		} catch (SQLException e) {
			System.out.println("UserDAO에서 userIdChk구문 실행중 에러 발생!");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
}
