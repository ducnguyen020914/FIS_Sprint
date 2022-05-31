package com.poly.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.poly.entity.Product;
import com.poly.mapper.ProductMapper;
import com.poly.model.ProductDTO;
import com.poly.repository.ProductRepository;

@Service
public class ProductServiceIML  implements ProductService{
	@Autowired
	private ProductRepository repository;
	@Autowired
	private ProductMapper mapper;
	@Override
	public List<ProductDTO> getpage(Pageable pageable) {
		  Page<Product> data =  this.repository.findAll(pageable);
		return data.getContent().stream().map(t -> mapper.convertToDTO(t)).collect(Collectors.toList());
	}
	@Override
	public int pagetotal() {
		int pagecount = (int)Math.ceil((double) this.repository.count()/5);
		return pagecount;
	}
	@Override
	public List<ProductDTO> getName(String name) {
		List<Product> list = this.repository.getByName(name);
		return list.stream().map(t -> mapper.convertToDTO(t) ).collect(Collectors.toList());
	}
	@Override
	public ProductDTO save(ProductDTO productdto) {
		Product product = this.mapper.convertToEntity(productdto);
	product = repository.save(product);
		return mapper.convertToDTO(product);
	}

}
