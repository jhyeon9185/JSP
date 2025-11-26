package com.controller.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.controller.dto.ProductVO;

import util.DBManager;

public class ProductDAO {

    private static ProductDAO instance = new ProductDAO();
    private ProductDAO() {}
    public static ProductDAO getInstance() { return instance; }

    public List<ProductVO> selectAllProducts() {
        List<ProductVO> list = new ArrayList<>();
        
        String sql = "SELECT * FROM product ORDER BY num DESC";
        
        try (Connection con = DBManager.getConnection();
        		
             PreparedStatement pstmt = con.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
        	
            while (rs.next()) {
            	
                ProductVO vo = new ProductVO();
                vo.setNum(rs.getInt("num"));
                vo.setName(rs.getString("name"));
                vo.setPrice(rs.getInt("price"));
                vo.setDescription(rs.getString("description"));
                vo.setPictureurl(rs.getString("pictureurl"));
                list.add(vo);
                
            }
            
        } catch (Exception e) { e.printStackTrace(); }
        
        return list;
    }

    public ProductVO selectOneByNum(int num) {
    	
        ProductVO vo = null;
        
        String sql = "SELECT * FROM product WHERE num=?";
        
        try (Connection con = DBManager.getConnection();
        		
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, num);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                	
                    vo = new ProductVO();
                    vo.setNum(rs.getInt("num"));
                    vo.setName(rs.getString("name"));
                    vo.setPrice(rs.getInt("price"));
                    vo.setDescription(rs.getString("description"));
                    vo.setPictureurl(rs.getString("pictureurl"));
                    
                }
            }
            
        } catch (Exception e) { e.printStackTrace(); }
        return vo;
    }

    public void insertProduct(ProductVO vo) {
    	
        String sql = "INSERT INTO product(name, price, description, pictureurl) VALUES(?,?,?,?)";
        
        try (Connection con = DBManager.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
        	
            pstmt.setString(1, vo.getName());
            pstmt.setInt(2, vo.getPrice());
            pstmt.setString(3, vo.getDescription());
            pstmt.setString(4, vo.getPictureurl());
            pstmt.executeUpdate();
            
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void updateProduct(ProductVO vo) {
    	
        String sql = "UPDATE product SET name=?, price=?, description=?, pictureurl=? WHERE num=?";
        
        try (
        	Connection con = DBManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)) {
        	
            pstmt.setString(1, vo.getName());
            pstmt.setInt(2, vo.getPrice());
            pstmt.setString(3, vo.getDescription());
            pstmt.setString(4, vo.getPictureurl());
            pstmt.setInt(5, vo.getNum());
            
            pstmt.executeUpdate();
            
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void deleteProduct(int num) {
    	
        String sql = "DELETE FROM product WHERE num=?";
        try (
        		
        	Connection con = DBManager.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)) {
        	
            pstmt.setInt(1, num);
            
            pstmt.executeUpdate();
            
        } catch (Exception e) { e.printStackTrace(); }
    }
}
