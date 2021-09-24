package com.kh.product.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.product.model.dao.ProductDAO;
import com.kh.product.model.exception.ProductException;
import com.kh.product.model.vo.ProductIO;

public class ProductService {

	public ArrayList<ProductIO> selectAll() throws ProductException {
		Connection conn = getConnection();
		ArrayList<ProductIO> list = new ProductDAO().selectAll(conn);
		return list;
	}
	public int insertProduct(ProductIO p) throws ProductException {
		Connection conn = getConnection();
		int result = new ProductDAO().insertProduct(conn,p);
		if(result >0)
		{
			commit(conn);
		}
		else
			rollback(conn);
		return result;
	}
	public int updateProduct(ProductIO p,String id) throws ProductException {
		Connection conn = getConnection();
		int result = new ProductDAO().updateProduct(conn,p,id);
		if(result >0)
		{
			commit(conn);
		}
		else
			rollback(conn);
		return result;
	}
	public int deleteProduct(String id) throws ProductException {
		Connection conn = getConnection();
		int result = new ProductDAO().deleteProduct(conn,id);
		if(result >0)
		{
			commit(conn);
		}
		else
			rollback(conn);
		return result;
	}
	public ProductIO searchProduct(String pName) throws ProductException {
		Connection conn = getConnection();
		ProductIO p = new ProductDAO().searchProduct(conn,pName);
		return p;
	}
	
	public ArrayList<ProductIO> IOselectAll() throws ProductException {
		Connection conn = getConnection();
		ArrayList<ProductIO> list = new ProductDAO().IOselectAll(conn);
		return list;
	}

	public ArrayList<ProductIO> IOselectInput() throws ProductException {
		Connection conn = getConnection();
		ArrayList<ProductIO> list = new ProductDAO().IOselectInput(conn);
		return list;
	}
	public ArrayList<ProductIO> IOselectOutput() throws ProductException {
		Connection conn = getConnection();
		ArrayList<ProductIO> list = new ProductDAO().IOselectOutput(conn);
		return list;
	}
	public int IOinsertProduct(ProductIO p) throws ProductException {
		Connection conn = getConnection();
		int result = new ProductDAO().IOinsertProduct(conn,p);
		if(result >0)
		{
			commit(conn);
		}
		else
			rollback(conn);
		return result;
	}
	public int IOdeleteProduct(ProductIO p) throws ProductException {
		Connection conn = getConnection();
		int result = new ProductDAO().IOdeleteProduct(conn,p);
		if(result >0)
		{
			commit(conn);
		}
		else
			rollback(conn);
		return result;
	}
	
	
	

	

	

}
