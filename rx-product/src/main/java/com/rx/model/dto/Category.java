package com.rx.model.dto;

/**
 * 商品类型实体�?
 * @author wxh
 * 2017�?4�?15�?
 */
public class Category {
	
	private long categoryId;
	private String categoryName;
	private long categoryParentId;
	
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public long getCategoryParentId() {
		return categoryParentId;
	}
	public void setCategoryParentId(long categoryParentId) {
		this.categoryParentId = categoryParentId;
	}
	
}
