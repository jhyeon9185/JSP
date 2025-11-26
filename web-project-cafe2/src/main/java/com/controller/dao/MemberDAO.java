package com.controller.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.controller.dto.MemberVO;

import util.DBManager;


public class MemberDAO {
	
	private static MemberDAO instance = new MemberDAO();
	
	private MemberDAO() {}
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	public boolean userCheck(String userid, String password) {
		
		boolean result = false;
		
		String sql = "select password from users where userid =?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("password") != null & rs.getString("password").equals(password)) {
					result = true;
				}
			}
			
			
		}catch(Exception e) {
			e.printStackTrace(); 
			
		}finally {
			DBManager.close(con, pstmt, rs);	
		}
		
		return result;
		
	}
	
	public MemberVO getMember(String userid) {
		
		MemberVO vo = new MemberVO();
		
		String sql = "select * from users where userid = ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			
			rs = pstmt.executeQuery();
				
			if(rs.next()) {
	
				vo.setName(rs.getString("name"));
				vo.setUserid(rs.getString("userid"));
				vo.setPwd(rs.getString("password"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
				
			}else {
				System.out.println("❗ getMember: 사용자 정보 조회 실패 (userid=" + userid + ")");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
		return vo;
	}

	public void updateMember(MemberVO vo) {
		
		String sql = "UPDATE users SET name=?, email=?, password=?, phone=? WHERE userid=?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, vo.getName());
		    pstmt.setString(2, vo.getEmail());
		    pstmt.setString(3, vo.getPwd());
		    pstmt.setString(4, vo.getPhone());
		    pstmt.setString(5, vo.getUserid());
		    
			pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			DBManager.close(con, pstmt);
		}
		
		
	}

	public int confirmID(String userid) {

		int result = -1;
		
		String sql = "select userid from users where userid = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				result =1;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt, rs);
		}
		
		return result;
	}

	public void insertMember(MemberVO vo) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO users (name, userid, password, email, phone, admin)"
				+ "VALUES(?, ?, ?, ?, ?, ?)";
		
		try {
			
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getUserid());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getPhone());
			pstmt.setInt(6, vo.getAdmin());
			
			pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(con, pstmt);
		}
		
	}
	
}
