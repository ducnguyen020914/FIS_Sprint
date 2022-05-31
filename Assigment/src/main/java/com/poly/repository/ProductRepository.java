package com.poly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
   @Query("Select p from Product p where p.name like %:name%")
   public List<Product> getByName(@Param("name") String name);
}
