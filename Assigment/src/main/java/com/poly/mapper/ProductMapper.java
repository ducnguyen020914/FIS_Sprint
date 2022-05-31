package com.poly.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.entity.Product;
import com.poly.model.ProductDTO;

@Service
public class ProductMapper {
      
	@Autowired
	private ModelMapper mapper;
	
	public Product convertToEntity(ProductDTO dto) {
		Product p = mapper.map(dto, Product.class);
		return p;
	}
	public ProductDTO convertToDTO(Product p) {
		ProductDTO dto = mapper.map(p, ProductDTO.class);
		return dto;
	}
}
