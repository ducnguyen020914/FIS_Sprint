package com.poly.model;


import java.util.List;

import javax.validation.constraints.NotBlank;

import com.poly.entity.Product;

import lombok.Data;

@Data
public class CategoryDTO {
	
	private Integer id;
	@NotBlank
	private String name;
	
    private String note;
    
    private List<Product> products;
}
