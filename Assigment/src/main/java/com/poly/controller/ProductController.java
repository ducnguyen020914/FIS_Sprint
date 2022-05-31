package com.poly.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.poly.entity.Product;
import com.poly.model.CategoryDTO;
import com.poly.model.ProductDTO;
import com.poly.service.CategorySerrvice;
import com.poly.service.ProductService;
import com.poly.utils.UploadFileUtil;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
	@Autowired
	private ProductService service;
	@Autowired
	private CategorySerrvice cateService;
	@Autowired
	private UploadFileUtil uploadFile;
      @GetMapping("/index")
      public String index(Model model,
    		  @RequestParam("fiel") Optional<String> fiel,
    		  @RequestParam("direction") Optional<String> direction,
    		  @RequestParam("page") Optional<Integer> page) {
    	  String fielParam = fiel.isPresent() ? fiel.get() : "id";
    	  Integer pageParam = page.isPresent() ? page.get() - 1 : 0;
    	 Sort sort = (!direction.isPresent() || direction.get().equals("asc")) ? 
    			 Sort.by(Direction.ASC, fielParam) : Sort.by(Direction.DESC, fielParam);
    	 Pageable pageable = PageRequest.of(pageParam, 5, sort);
    	 List<ProductDTO> list = this.service.getpage(pageable);
    	 int pagecount = this.service.pagetotal();
    	 model.addAttribute("pagecount",pagecount);
    	 model.addAttribute("items",list);
    	  model.addAttribute("view","/WEB-INF/View/Amin/QLSP.jsp");
    	  return "Amin/index";
      }
      @GetMapping("/findByid")
      public String index(Model model,@RequestParam("name") String name
    		) {
    	  List<ProductDTO> list = this.service.getName(name);
    	 int pagecount = this.service.pagetotal();
    	 model.addAttribute("pagecount",pagecount);
    	 model.addAttribute("items",list);
    	  model.addAttribute("view","/WEB-INF/View/Amin/QLSP.jsp");
    	  return "Amin/index";
      }
      @GetMapping("/create")
      public String create(Model model,@ModelAttribute("productDTO") ProductDTO product
    		) {
    	  List<CategoryDTO> list = this.cateService.getAll();
    	model.addAttribute("categories",list);
    	  model.addAttribute("view","/WEB-INF/View/Amin/QLSPForm.jsp");
    	  return "Amin/index";
      }
      @PostMapping("/store")
      public String store(Model model,
    		 @Valid @ModelAttribute("productDTO") ProductDTO productdto,@RequestParam("image") MultipartFile file
    		) {

    	  
//    	  System.out.println(file.getOriginalFilename());
//    	  if(result.hasErrors()) {
//    		  
//    		  System.out.println(result.getAllErrors());
//    		  model.addAttribute("view","/WEB-INF/View/Amin/QLSPForm.jsp");
//        	  return "Amin/index";
//    	  }else {
//    		  productdto.setImage(file.getOriginalFilename().toString());
  		 this.uploadFile.UploadFile(file);
//    		  this.service.save(productdto);
//    		  
//    	  }
    	  return "redirect:/product/index";
      }
}
