package com.rxing.boot.dao;

import org.springframework.data.repository.CrudRepository;

import com.rxing.boot.entity.Category;

public interface ICategoryDao extends CrudRepository<Category, Long>{

}
