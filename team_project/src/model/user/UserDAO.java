package model.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.common.JDBCUtil;

public class UserDAO {
	/* DB연결에 사용할 객체들 선언 */
	Connection conn;
	PreparedStatement pstmt;
	   
	/* DB에서 사용될 sql구문 정의 */
	String sql_insert = "INSERT INTO TB_USERINFO VALUES(USERSEQ.NEXTVAL, ?, ?, ?, ?, ?)";
	String sql_update = "UPDATE TB_USERINFO SET USERPW=?, USERNAME=?, USERPHONE=?, USEREMAIL=? WHERE USERCODE=?";
	String sql_delete = "DELETE FROM TB_USERINFO WHERE USERCODE=?";
	String sql_selectOne = "SELECT * FROM TB_USERINFO WHERE USERCODE=?";
	String sql_userIdChk = "SELECT USERID FROM TB_USERINFO";
	

	
	public boolean UserInsert(UserVO uservo, boolean userIdChkResult) {
		if(userIdChkResult) {
			conn = JDBCUtil.connect();
			try {
				pstmt = conn.prepareStatement(sql_insert);
				pstmt.setString(1, uservo.getUserid());
				pstmt.setString(2, uservo.getUserpw());
				pstmt.setString(3, uservo.getUsername());
				pstmt.setString(4, uservo.getUserphone());
				pstmt.setString(5, (uservo.getUseremail()!=null?uservo.getUseremail():""));
				
				pstmt.executeUpdate();	
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
			pstmt.setString(1, uservo.getUserpw());
			pstmt.setString(2, uservo.getUsername());
			pstmt.setString(3, uservo.getUserphone());
			pstmt.setString(4, uservo.getUseremail());
			pstmt.setInt(5, uservo.getUsercode());
			pstmt.executeUpdate();
			
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
			pstmt.setInt(1, uservo.getUsercode());
			pstmt.executeUpdate();
			
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
			pstmt = conn.prepareStatement(sql_selectOne);
			pstmt.setInt(1, uservo.getUsercode());
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			vo = new UserVO();
			vo.setUsercode(rs.getInt("USERCODE"));
			vo.setUserid(rs.getString("USERID"));
			vo.setUserpw(rs.getString("USERPW"));
			vo.setUsername(rs.getString("USERNAME"));
			vo.setUserphone(rs.getString("USERPHONE"));
			vo.setUseremail(rs.getString("USEREMAIL"));
			
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
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				if(rs.getString("USERID").equals(uservo.getUserid())) return false;
			}
			
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
