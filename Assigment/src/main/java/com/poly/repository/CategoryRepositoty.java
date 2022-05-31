package com.poly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.entity.Category;
public interface CategoryRepositoty extends JpaRepository<Category, Integer> {
  @Query("select c from Category c where c.name like %:name%")
   public List<Category> findByName(@Param("name") String name);
  

}
