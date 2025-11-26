package com.saeyan.controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.saeyan.controller.dto.MemberVO;
import com.saeyan.util.DBmanager;

public class MemberDAO {
	
	private static MemberDAO instance = new MemberDAO();
	
	private MemberDAO () {}
	
	public static MemberDAO getInstance() {
		return instance;
	}

	public boolean getuserchek(String userid, String pwd) {
		
		boolean result = false;
		
		String sql = "select password from users where userid=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBmanager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("password") != null && rs.getString("password").equals(pwd)){
					result = true;
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBmanager.close(con, pstmt, rs);
			
		}
		
		return result;
	}

	public MemberVO getMember(String userid) {
		
		MemberVO vo = new MemberVO();
		String sql = "select * from users where userid=?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			con = DBmanager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				vo.setName(rs.getString("name"));
				vo.setUserid(rs.getString("userid"));
				vo.setPwd(rs.getString("password"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
				vo.setAdmin(rs.getInt("admin"));
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBmanager.close(con, pstmt, rs);
			
		}
		
		
		return vo;
	}
	
		
}// end class
