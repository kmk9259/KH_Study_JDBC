package com.kh.product.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class ProductIO implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private int ioNum;
	private String productId;
	private String pName;
	private Date ioDate;
	private int amount;//stock
	private String status;
	
	private int price;
	private String description;
	
	public ProductIO() {
		// TODO Auto-generated constructor stub
	}

	public ProductIO(int ioNum, String productId, String pName, Date ioDate, int amount, String status, int price,
			String description) {
		super();
		this.ioNum = ioNum;
		this.productId = productId;
		this.pName = pName;
		this.ioDate = ioDate;
		this.amount = amount;
		this.status = status;
		this.price = price;
		this.description = description;
	}

	public int getIoNum() {
		return ioNum;
	}

	public void setIoNum(int ioNum) {
		this.ioNum = ioNum;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public Date getIoDate() {
		return ioDate;
	}

	public void setIoDate(Date ioDate) {
		this.ioDate = ioDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String product_stock_info() {
		return  productId+"\t" + pName+"\t" +  price+"\t"+  description+"\t" + amount;
		
	}
	public String product_io_info() {
		return  ioNum+"\t" + productId+"\t" + pName+"\t" +  ioDate+"\t"+  amount+"\t" + status ;
	}
	
	

}
