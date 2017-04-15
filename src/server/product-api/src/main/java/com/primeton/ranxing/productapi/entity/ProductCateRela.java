package com.primeton.ranxing.productapi.entity;


/**
 * 商品类型关系实体类
 * 
 * @author 王肖辉 2017年4月15日
 */

public class ProductCateRela  {

	/**
	 * 默认构造函数
	 */
	public ProductCateRela() {
	}

	/**
	 * 构造函数
	 * 
	 * @param productId
	 *            --商品ID
	 * @param categoryId
	 *            --类别ID
	 */
	public ProductCateRela(long productId, long categoryId) {
		super();
		this.productId = productId;
		this.categoryId = categoryId;
	}

	/**
	 * @return the productId
	 */
	public long getProductId() {
		return productId;
	}

	/**
	 * @param productId
	 *            the productId to set
	 */
	public void setProductId(long productId) {
		this.productId = productId;
	}

	/**
	 * @return the categoryId
	 */
	public long getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId
	 *            the categoryId to set
	 */
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	private long productId;
	private long categoryId;

}
