package com.poly.model;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

	private Integer id;

	private String name;
	
	private MultipartFile  image;

	private int price;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createDate;
	@Min(value = 0)
	private int quantity;
	private CategoryDTO category;

}
