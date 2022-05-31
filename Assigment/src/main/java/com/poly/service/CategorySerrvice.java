package com.poly.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.poly.model.CategoryDTO;

public interface CategorySerrvice {
	 List<CategoryDTO> getPage(Pageable pageable);
	 List<CategoryDTO> getAll();
	 List<CategoryDTO> getByName(String name);
	 int getTotalPage();
	 CategoryDTO save(CategoryDTO categoryDTO);
	 void delete(Integer id);
}
