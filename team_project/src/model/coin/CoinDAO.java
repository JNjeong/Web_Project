package model.coin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JDBCUtil;

public class CoinDAO {
	/* DB연결에 사용할 객체들 선언 */
	Connection conn;
	PreparedStatement pstmt;
	   
	/* DB에서 사용될 sql구문 정의 */
	String sql_insert = "INSERT INTO TB_COIN VALUES(?, ?, ?, ?, ?, ?, ?)";
	String sql_select = "SELECT * FROM TB_COIN";
	
	public boolean CoinInsert(CoinVO coinvo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_insert);
			pstmt.setString(1, coinvo.getMarketname());
			pstmt.setInt(2, coinvo.getCoinpricekor());
			pstmt.setInt(3, coinvo.getCoinpriceeng());
			pstmt.setInt(4, coinvo.getCoinrate());
			pstmt.setDouble(5, coinvo.getCoinratepct());
			pstmt.setDouble(6, coinvo.getCoinpremium());
			pstmt.setInt(7, coinvo.getCoindeal());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("CoinDAO에서 insert구문 실행중 에러 발생!");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return true;
	}
	
	public ArrayList<CoinVO> CoinSelet() {
		ArrayList<CoinVO> arrcoin = new ArrayList<CoinVO>();
		CoinVO vo = null;
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_select);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new CoinVO();
				vo.setMarketname(rs.getString("MARKETNAME"));
				vo.setCoinpricekor(rs.getInt("COINPRICEKOR"));
				vo.setCoinpriceeng(rs.getInt("COINPRICEENG"));
				vo.setCoinrate(rs.getInt("COINRATE"));
				vo.setCoinratepct(rs.getDouble("COINRATEPCT"));
				vo.setCoinpremium(rs.getDouble("COINPREMIUM"));
				vo.setCoindeal(rs.getInt("COINDEAL"));
				
				arrcoin.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("CoinDAO에서 select구문 실행중 에러 발생!");
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return arrcoin;
	}
	
	//CoinUpdate() 미예정
}
