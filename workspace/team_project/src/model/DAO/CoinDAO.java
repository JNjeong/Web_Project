package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.common.JDBCUtil;

public class CoinDAO {
	/* DB연결에 사용할 객체들 선언 */
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	   
	/* DB에서 사용될 sql구문 정의 */
	String sql_insert = "";
	String sql_select = "";
	
	public boolean CoinInsert() {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_insert);
			//TODO
		} catch (SQLException e) {
			System.out.println("CoinDAO에서 insert구문 실행중 에러 발생!");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	
	public boolean CoinSelet() {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_select);
			//TODO
		} catch (SQLException e) {
			System.out.println("CoinDAO에서 select구문 실행중 에러 발생!");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	
}
