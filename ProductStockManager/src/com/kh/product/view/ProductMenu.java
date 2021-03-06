package com.kh.product.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.kh.product.controller.ProductController;
import com.kh.product.model.dao.ProductDAO;
import com.kh.product.model.vo.ProductIO;

public class ProductMenu {
	private static Scanner sc = new Scanner(System.in);
	private ProductController pc = new ProductController();
	private ProductDAO pd = new ProductDAO();
	
	public void mainMenu()
	{
		do {
			System.out.println("\n***************상품관리프로그램***************");
			System.out.println("1. 전체 조회");	
			System.out.println("2. 상품 추가");
			System.out.println("3. 상품 수정");
			System.out.println("4. 상품 삭제");
			System.out.println("5. 상품 검색");
			System.out.println("6. 상품 입출고 메뉴");
			System.out.println("9. 프로그램 끝내기");
			System.out.println("번호 선택 : ");
			
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				pc.selectAll();
				break;
			case 2:
				pc.insertProduct(inputProduct());
				break;
			case 3:
				
				pc.updateProduct(updateProduct(),inputProductID());
				break;
			case 4:
				pc.deleteProduct(inputProductID());
				break;
			case 5:
				pc.searchProduct(inputpName());
				break;
			case 6:
				IOMenu();
				break;			
			case 9:
				System.out.println("정말로 끝내시겠습니까? (y/n)");
				sc.nextLine();
				char end = sc.nextLine().charAt(0);
				if (end =='y')
				{
					//mc.exitProgram();
					return;
				}
					
				break;
			default:
				System.out.println("번호를 잘못 입력하셨습니다.");
			}
			
		}while(true);
	}
	
	public void IOMenu()
	{
		System.out.println("=====입출고 메뉴 =====");
		System.out.println("1. 전체 입출고 내역 조회");
		System.out.println("2. 입고 내역만 조회");
		System.out.println("3. 출고 내역만 조회");
		System.out.println("4. 상품 입고");
		System.out.println("5. 상품 출고 ");
		int num = sc.nextInt();
		switch(num){
		case 1:
			pc.IOselectAll();
			break;
		case 2:
			pc.IOselectInput();
			break;
		case 3:
			pc.IOselectOutput();
			break;
		case 4:
			pc.IOinsertProduct(inputIdAmount());
			break;
		case 5:
			pc.IOdeleteProduct(inputIdAmount());
			break;
		default :
			System.out.println("번호 잘못 입력 이전 메뉴로 돌아갑니다.");
			return;
		}
		
	}
	

	private ProductIO inputProduct() {
		ProductIO p = new ProductIO();
		System.out.println("새로운 상품 정보를 입력하세요");
		System.out.println("상품ID");
		p.setProductId(sc.next());
		System.out.println("상품명");
		p.setpName(sc.next());
		System.out.println("가격");
		p.setPrice(sc.nextInt());
		sc.nextLine();
		System.out.println("부가설명");
		p.setDescription(sc.next());
		System.out.println("재고수량");
		p.setAmount(sc.nextInt());
		return p;
	}
	private ProductIO updateProduct() {
		ProductIO p = new ProductIO();
		System.out.println("수정할 상품 정보를 입력하세요");
		System.out.println("가격");
		p.setPrice(sc.nextInt());
		sc.nextLine();
		System.out.println("부가설명");
		p.setDescription(sc.next());
		return p;
	}
	private String inputProductID() {
		
		System.out.println("상품 아이디 입력 : ");
		return sc.next();
	}
	private String inputpName() {
		System.out.println("상품명 입력 : ");
		return sc.next();
	}
	private ProductIO inputIdAmount() {
		ProductIO p = new ProductIO();
		System.out.println("상품 아이디 입력 : ");
		p.setProductId(sc.next());
		System.out.println("상품 수량 입력 : ");
		p.setAmount(sc.nextInt());
		return p;
	}


	
	public void displayProductList(List<ProductIO> list) {
		System.out.println("==========================상품 리스트==========================");
		System.out.println("상품ID\t\t상품명\t가격\t부가설명\t재고수량");
		for(ProductIO p :list)
			System.out.println(p.product_stock_info());
		
	}

	public void displayProduct(ProductIO p)
	{
		System.out.println("==========================상품 정보==========================");
		System.out.println("상품ID\t\t상품명\t가격\t부가설명\t재고수량");
		System.out.println(p.product_stock_info());
	}
	public void displayIOProductList(ArrayList<ProductIO> list) {
		System.out.println("==========================입출고 리스트==========================");
		System.out.println("입출고번호\t상품ID\t상품명\t입출고일\t\t입출고수량\t입출고상태");
		for(ProductIO p :list)
			System.out.println(p.product_io_info());
	}
	public void displayIProduct(ArrayList<ProductIO> list) {
		System.out.println("==========================입고 리스트==========================");
		System.out.println("입출고번호\t상품ID\t상품명\t입출고일\t\t입출고수량\t입출고상태");
		for(ProductIO p :list)
			System.out.println(p.product_io_info());
	}
	public void displayOProduct(ArrayList<ProductIO> list) {
		System.out.println("==========================출고 리스트==========================");
		System.out.println("입출고번호\t상품ID\t상품명\t입출고일\t\t입출고수량\t입출고상태");
		for(ProductIO p :list)
			System.out.println(p.product_io_info());
	}
	public void displayNoData() {
		System.out.println("조회된 데이터가 없습니다.");
		
	}
	public void displaySuccess(String message) {
		System.out.println("서비스 요청 결과 : "+message);
		
	}
	public void displayError(String message) {
		System.out.println("서비스 요청 처리 실패 : "+message);
		
	}

	

	
	

}
