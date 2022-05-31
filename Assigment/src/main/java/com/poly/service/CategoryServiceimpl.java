package com.poly.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.poly.entity.Category;
import com.poly.mapper.CategoryMapper;
import com.poly.model.CategoryDTO;
import com.poly.repository.CategoryRepositoty;
@Service
public class CategoryServiceimpl implements CategorySerrvice {
    @Autowired
    private CategoryRepositoty repository;
    @Autowired 
    private CategoryMapper mapper;
	@Override
	public List<CategoryDTO> getPage(Pageable pageable) {
		Page<Category> pageData = repository.findAll(pageable);	
		return pageData.getContent().stream().map(t -> mapper.convertToDTO(t)).collect(Collectors.toList());
	}

	@Override
	public List<CategoryDTO> getAll() {
		List<Category> list  = this.repository.findAll();
		return list.stream().map(t -> mapper.convertToDTO(t) ).collect(Collectors.toList());
	}

	@Override
	public List<CategoryDTO> getByName(String name) {
		List<Category> list = this.repository.findByName(name);
		return list.stream().map(t -> mapper.convertToDTO(t)).collect(Collectors.toList()); 
	}

	@Override
	public int getTotalPage() {
		double pagecount =  Math.ceil((double)this.repository.count()/5);
		return  (int)pagecount;
	}

	@Override
	public CategoryDTO save(CategoryDTO categoryDTO) {
		Category c = this.mapper.convertToEntity(categoryDTO);
		System.out.println(c.getId() + "  " + categoryDTO.getId());
		 this.repository.save(c);
		return mapper.convertToDTO(c);
	}

	@Override
	public void delete(Integer id) {
		this.repository.deleteById(id);
		
	}
	
 
}
