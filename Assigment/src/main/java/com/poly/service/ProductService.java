package com.poly.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import com.poly.model.ProductDTO;

public interface ProductService {
    List<ProductDTO> getpage(Pageable pageable);
    int pagetotal();
    List<ProductDTO> getName(String name);
    ProductDTO save(ProductDTO productdto);
}
