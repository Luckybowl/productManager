package com.primeton.ranxing.productapi.entity;

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

	/**
	 * 构造函数
	 * 
	 * @param productId
	 *            - 商品ID
	 * @param productName
	 *            -商品名字
	 * @param productDesc
	 *            -商品描述
	 * @param productPrice
	 *            -商品价格
	 * @param productTotal
	 *            -商品总量
	 * @param productRest
	 *            -商品剩余
	 * @param productRebate
	 *            -商品折扣
	 * @param productClickCounts
	 *            -商品点击量
	 * @param productPicturePath
	 *            -商品图片路径
	 */
	public Product(long productId, String productName, String productDesc, float productPrice, int productTotal,
			int productRest, float productRebate, long productClickCounts, String productPicturePath) {
		this(productName, productDesc, productPrice, productTotal, productRest, productRebate, productClickCounts,
				productPicturePath);
		this.productId = productId;
	}

	/**
	 * 构造函数
	 * 
	 * @param productName
	 * @param productDesc
	 * @param productPrice
	 * @param productTotal
	 * @param productRest
	 * @param productRebate
	 * @param productClickCounts
	 * @param productPicturePath
	 */
	public Product(String productName, String productDesc, float productPrice, int productTotal, int productRest,
			float productRebate, long productClickCounts, String productPicturePath) {
		super();
		this.productName = productName;
		this.productDesc = productDesc;
		this.productPrice = productPrice;
		this.productTotal = productTotal;
		this.productRest = productRest;
		this.productRebate = productRebate;
		this.productClickCounts = productClickCounts;
		this.productPicturePath = productPicturePath;
	}

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

}
