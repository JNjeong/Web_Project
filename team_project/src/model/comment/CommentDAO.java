package model.comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.board.BoardVO;
import model.common.JDBCUtil;
import model.user.UserVO;

public class CommentDAO {
	/* DB연결에 사용할 객체들 선언 */
	Connection conn;
	PreparedStatement pstmt;
	
	/* DB에서 사용될 sql구문 정의 */
	String sql_selectAll = "SELECT * FROM TB_COMMENT WHERE BRDCODE=?";
	String sql_insert = "INSERT INTO TB_COMMENT VALUES(CMTSEQ.NEXTVAL, ?, ?, ?, ?)";
	String sql_update = "UPDATE TB_COMMENT SET CMTCONTENT=? WHERE CMTCODE=?";
	String sql_delete = "DELETE FROM TB_COMMENT WHERE CMTCODE=?";

	public ArrayList<CommentVO> CmtSelectAll(BoardVO boardvo) {
		ArrayList<CommentVO> arrcmt = new ArrayList<CommentVO>();
		CommentVO vo = null;
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_selectAll);
			pstmt.setInt(1, boardvo.getBrdcode());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new CommentVO();
				vo.setCmtcode(rs.getInt("CMTCODE"));
				vo.setCmtbrdcode(rs.getInt("CMTBRDCODE"));
				vo.setCmtusercode(rs.getInt("CMTUSERCODE"));
				vo.setCmtwriter(rs.getString("CMTWRITER"));
				vo.setCmtcontent(rs.getString("CMTCONTENT"));
				
				arrcmt.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("CommentDAO에서 selectAll구문 실행중 에러 발생!");
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.disconnect(pstmt, conn);
		}
		return arrcmt;
	}
	
	public boolean CmtInsert(CommentVO commentvo, BoardVO boardvo, UserVO uservo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(sql_insert);
			pstmt.setInt(1, boardvo.getBrdcode());
			pstmt.setInt(2, uservo.getUsercode());
			pstmt.setString(3, commentvo.getCmtwriter());
			pstmt.setString(4, commentvo.getCmtcontent());
			pstmt.executeUpdate();
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
			pstmt.setString(1, commentvo.getCmtcontent());
			pstmt.setInt(2, commentvo.getCmtcode());
			pstmt.executeUpdate();
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
			pstmt.setInt(1, commentvo.getCmdtrdcode());
			pstmt.executeUpdate();
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
