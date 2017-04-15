package com.rxing.boot.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 商品类型实体类
 * @author wxh
 * 2017年4月15日
 */
@Entity
@Table(name="category")
public class Category implements Serializable{

	/**
	 * 默认构造函数
	 */
	public Category(){}
	
	/**
	 * 构造函数
	 * @param categoryId --类型ID
	 * @param categoryName --类型名
	 * @param categoryParentId --父类型
	 */
	public Category(long categoryId, String categoryName, long categoryParentId) {
		this(categoryName, categoryParentId);
		this.categoryId = categoryId;
	}
	/**
	 * 构造函数
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
	 * @param categoryId the categoryId to set
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
	 * @param categoryName the categoryName to set
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
	 * @param categoryParentId the categoryParentId to set
	 */
	public void setCategoryParentId(long categoryParentId) {
		this.categoryParentId = categoryParentId;
	}
	@Id
	private long categoryId;
	private String categoryName;
	private long categoryParentId;
	
	private static final long serialVersionUID = -2989210136764919785L;
}
