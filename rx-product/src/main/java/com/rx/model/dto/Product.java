package com.rx.model.dto;

/**
 * ÂïÜÂìÅÂÆû‰ΩìÁ±?
 * @author wxh
 * 2017Âπ?4Êú?14Êó?
 */
public class Product {
	
	private long productId;
	private String productName;
	private String productDesc;
	private float productPrice;
	private int productTotal;
	private int productRest;
	private float productRebate;
	private long productClickCounts;
	private String productPicturePath;
	private Category category;
	
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductTotal() {
		return productTotal;
	}
	public void setProductTotal(int productTotal) {
		this.productTotal = productTotal;
	}
	public int getProductRest() {
		return productRest;
	}
	public void setProductRest(int productRest) {
		this.productRest = productRest;
	}
	public float getProductRebate() {
		return productRebate;
	}
	public void setProductRebate(float productRebate) {
		this.productRebate = productRebate;
	}
	public long getProductClickCounts() {
		return productClickCounts;
	}
	public void setProductClickCounts(long productClickCounts) {
		this.productClickCounts = productClickCounts;
	}
	public String getProductPicturePath() {
		return productPicturePath;
	}
	public void setProductPicturePath(String productPicturePath) {
		this.productPicturePath = productPicturePath;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
}
