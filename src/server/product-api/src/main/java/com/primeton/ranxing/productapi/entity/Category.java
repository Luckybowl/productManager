package com.primeton.ranxing.productapi.entity;

import java.io.Serializable;

public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 默认构造函数
	 */
	public Category() {
	}

	/**
	 * 构造函数
	 * 
	 * @param categoryId
	 *            --类型ID
	 * @param categoryName
	 *            --类型名
	 * @param categoryParentId
	 *            --父类型
	 */
	public Category(long categoryId, String categoryName, long categoryParentId) {
		this(categoryName, categoryParentId);
		this.categoryId = categoryId;
	}

	/**
	 * 构造函数
	 * 
	 * @param categoryName
	 * @param categoryParentId
	 */
	public Category(String categoryName, long categoryParentId) {
		super();
		this.categoryName = categoryName;
		this.categoryParentId = categoryParentId;
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

	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName
	 *            the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * @return the categoryParentId
	 */
	public long getCategoryParentId() {
		return categoryParentId;
	}

	/**
	 * @param categoryParentId
	 *            the categoryParentId to set
	 */
	public void setCategoryParentId(long categoryParentId) {
		this.categoryParentId = categoryParentId;
	}

	private long categoryId;
	private String categoryName;
	private long categoryParentId;

}
