package com.kh.product.controller;

import java.util.ArrayList;

import com.kh.product.model.exception.ProductException;
import com.kh.product.model.vo.ProductIO;
import com.kh.product.service.ProductService;
import com.kh.product.view.ProductMenu;

public class ProductController {
	public void selectAll() {
		ProductMenu menu = new ProductMenu();
		ArrayList<ProductIO> list;
		try {
			list = new ProductService().selectAll();
			if(!list.isEmpty())
				menu.displayProductList(list);
			else
				menu.displayNoData();
		} catch (ProductException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void insertProduct(ProductIO p) {
		int result;
		try {
			result = new ProductService().insertProduct(p);
			if(result >0)
			{
				new ProductMenu().displaySuccess("상품 추가 성공");
			}
				
		} catch (ProductException e) {
			new ProductMenu().displayError("상품 추가 실패");
			
			System.out.println(e.getMessage());
		}
		
	}
	public void updateProduct(ProductIO p, String id) {
		int result;
		try {
			result = new ProductService().updateProduct(p,id);
			if(result >0)
			{
				new ProductMenu().displaySuccess("상품 수정 성공");
			}
				
		} catch (ProductException e) {
			new ProductMenu().displayError("상품 수정 실패");
			
			System.out.println(e.getMessage());
		}
		
	}
	public void deleteProduct(String id) {
		int result;
		try {
			result = new ProductService().deleteProduct(id);
			if(result >0)
			{
				new ProductMenu().displaySuccess("상품 삭제 성공");
			}
				
		} catch (ProductException e) {
			new ProductMenu().displayError("상품 삭제 실패");
			
			System.out.println(e.getMessage());
		}
		
	}
	public void searchProduct(String pName) {
		ProductMenu menu = new ProductMenu();
		ProductIO p;
		try {
			p = new ProductService().searchProduct(pName);
			if(p!=null)
				menu.displayProduct(p);
			else
				menu.displayNoData();
		} catch (ProductException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void IOselectAll() {
		ProductMenu menu = new ProductMenu();
		ArrayList<ProductIO> list;
		try {
			list = new ProductService().IOselectAll();
			if(!list.isEmpty())
				menu.displayIOProductList(list);
			else
				menu.displayNoData();
		} catch (ProductException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void IOselectInput() {
		ProductMenu menu = new ProductMenu();
		ArrayList<ProductIO> list;
		try {
			list = new ProductService().IOselectInput();
			if(!list.isEmpty())
				menu.displayIProduct(list);
			else
				menu.displayNoData();
		} catch (ProductException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void IOselectOutput() {
		ProductMenu menu = new ProductMenu();
		ArrayList<ProductIO> list;
		try {
			list = new ProductService().IOselectOutput();
			if(!list.isEmpty())
				menu.displayOProduct(list);
			else
				menu.displayNoData();
		} catch (ProductException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void IOinsertProduct(ProductIO p) {
		int result;
		try {
			result = new ProductService().IOinsertProduct(p);
			if(result >0)
			{
				new ProductMenu().displaySuccess("상품 입고 성공");
			}
				
		} catch (ProductException e) {
			new ProductMenu().displayError("상품 입고 실패");
			
			System.out.println(e.getMessage());
		}
		
	}
	public void IOdeleteProduct(ProductIO p) {
		int result;
		try {
			result = new ProductService().IOdeleteProduct(p);
			if(result >0)
			{
				new ProductMenu().displaySuccess("상품 출고 성공");
			}
				
		} catch (ProductException e) {
			new ProductMenu().displayError("상품 출고 실패");
			
			System.out.println(e.getMessage());
		}
		
	}
	
	
	


	

	

}
