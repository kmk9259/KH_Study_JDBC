package com.kh.product.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.product.model.exception.ProductException;
import com.kh.product.model.vo.ProductIO;

public class ProductDAO {
	private Properties prop = null;
	
	public ProductDAO() {
		try {
			prop = new Properties();
			prop.load(new FileReader("resources/query.properties"));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public ArrayList<ProductIO> selectAll(Connection conn) throws ProductException {
		ArrayList<ProductIO> list = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectAll");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			list = new ArrayList<ProductIO>();
			while (rset.next())// 값이 있으면 true
			{
				ProductIO p = new ProductIO();
				
				p.setProductId(rset.getString("PRODUCT_ID"));
				p.setpName(rset.getString("P_NAME"));
				p.setPrice(rset.getInt("PRICE"));
				p.setDescription(rset.getString("DESCRIPTION"));
				p.setAmount(rset.getInt("STOCK"));

				list.add(p);
			}
		} catch (Exception e) {
			//e.printStackTrace();
			throw new ProductException("selectAll에러 : "+e.getMessage());

		} finally {
			close(rset);
			close(stmt);
		}
		return list;
	}
	public int insertProduct(Connection conn, ProductIO p) throws ProductException {
		int result = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("insertProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);

			conn.setAutoCommit(false);

			
			pstmt.setString(1, p.getProductId());
			pstmt.setString(2, p.getpName());
			pstmt.setInt(3, p.getPrice());
			pstmt.setString(4, p.getDescription());
			pstmt.setInt(5, p.getAmount());
			
			result = pstmt.executeUpdate(); // 처리한 행의 갯수리턴

			
		} catch (Exception e) {
			throw new ProductException("insertProduct에러 : "+e.getMessage());
		} finally {
			close(pstmt);
		}

		return result;
	}
	public int updateProduct(Connection conn, ProductIO p,String id) throws ProductException {
		int result = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("updateProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);

			conn.setAutoCommit(false);

			pstmt.setInt(1, p.getPrice());
			pstmt.setString(2, p.getDescription());
			pstmt.setString(3, id);
			
			result = pstmt.executeUpdate(); // 처리한 행의 갯수리턴

			
		} catch (Exception e) {
			throw new ProductException("updateProduct에러 : "+e.getMessage());
		} finally {
			close(pstmt);
		}

		return result;
	}
	public int deleteProduct(Connection conn, String id) throws ProductException {
		int result = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("deleteProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);

			conn.setAutoCommit(false);

			pstmt.setString(1, id);
			
			result = pstmt.executeUpdate(); // 처리한 행의 갯수리턴

			
		} catch (Exception e) {
			throw new ProductException("deleteProduct에러 : "+e.getMessage());
		} finally {
			close(pstmt);
		}

		return result;
	}
	public ProductIO searchProduct(Connection conn, String pName) throws ProductException {
	
		ProductIO p=null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("searchProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pName);
			rset = pstmt.executeQuery();
			
			if (rset.next())// 값이 있으면 true
			{
				p = new ProductIO();
				
				p.setProductId(rset.getString("PRODUCT_ID"));
				p.setpName(rset.getString("P_NAME"));
				p.setPrice(rset.getInt("PRICE"));
				p.setDescription(rset.getString("DESCRIPTION"));
				p.setAmount(rset.getInt("STOCK"));

			}
		} catch (Exception e) {
			//e.printStackTrace();
			throw new ProductException("selectAll에러 : "+e.getMessage());

		} finally {
			close(rset);
			close(pstmt);
		}
		return p;
	}
	//=======================입출고메뉴=======================
	public ArrayList<ProductIO> IOselectAll(Connection conn) throws ProductException {
		ArrayList<ProductIO> list = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("IOselectAll");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			list = new ArrayList<ProductIO>();
			while (rset.next())// 값이 있으면 true
			{
				ProductIO p = new ProductIO();
				
				p.setIoNum(rset.getInt("IO_NUM"));
				p.setProductId(rset.getString("PRODUCT_ID"));
				p.setpName(rset.getString("P_NAME"));
				p.setIoDate(rset.getDate("IO_DATE"));
				p.setAmount(rset.getInt("AMOUNT"));
				p.setStatus(rset.getString("STATUS"));

				list.add(p);
			}
		} catch (Exception e) {
			//e.printStackTrace();
			throw new ProductException("IOselectAll에러 : "+e.getMessage());

		} finally {
			close(rset);
			close(stmt);
		}
		return list;
	}

	public ArrayList<ProductIO> IOselectInput(Connection conn) throws ProductException {
		ArrayList<ProductIO> list = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("IOselectInput");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			list = new ArrayList<ProductIO>();
			while (rset.next())// 값이 있으면 true
			{
				ProductIO p = new ProductIO();
				
				p.setIoNum(rset.getInt("IO_NUM"));
				p.setProductId(rset.getString("PRODUCT_ID"));
				p.setpName(rset.getString("P_NAME"));
				p.setIoDate(rset.getDate("IO_DATE"));
				p.setAmount(rset.getInt("AMOUNT"));
				p.setStatus(rset.getString("STATUS"));

				list.add(p);
			}
		} catch (Exception e) {
			//e.printStackTrace();
			throw new ProductException("selectone에러 : "+e.getMessage());

		} finally {
			close(rset);
			close(stmt);
		}
		return list;
	}

	public ArrayList<ProductIO> IOselectOutput(Connection conn) throws ProductException {
		ArrayList<ProductIO> list = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("IOselectOutput");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			list = new ArrayList<ProductIO>();
			while (rset.next())// 값이 있으면 true
			{
				ProductIO p = new ProductIO();
				
				p.setIoNum(rset.getInt("IO_NUM"));
				p.setProductId(rset.getString("PRODUCT_ID"));
				p.setpName(rset.getString("P_NAME"));
				p.setIoDate(rset.getDate("IO_DATE"));
				p.setAmount(rset.getInt("AMOUNT"));
				p.setStatus(rset.getString("STATUS"));

				list.add(p);
			}
		} catch (Exception e) {
			//e.printStackTrace();
			throw new ProductException("IOselectOutput에러 : "+e.getMessage());

		} finally {
			close(rset);
			close(stmt);
		}
		return list;
	}

	public int IOinsertProduct(Connection conn, ProductIO p) throws ProductException {
		int result = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("IOinsertProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);

			conn.setAutoCommit(false);

			
			pstmt.setString(1, p.getProductId());
			pstmt.setInt(2, p.getAmount());
			
			result = pstmt.executeUpdate(); // 처리한 행의 갯수리턴

			
		} catch (Exception e) {
			throw new ProductException("IOinsertProduct에러 : "+e.getMessage());
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int IOdeleteProduct(Connection conn, ProductIO p) throws ProductException {
		int result = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("IOdeleteProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);

			conn.setAutoCommit(false);

			
			pstmt.setString(1, p.getProductId());
			pstmt.setInt(2, p.getAmount());
			
			result = pstmt.executeUpdate(); // 처리한 행의 갯수리턴

			
		} catch (Exception e) {
			throw new ProductException("IOdeleteProduct에러 : "+e.getMessage());
		} finally {
			close(pstmt);
		}

		return result;
	}

	

	

	

	

	

}
