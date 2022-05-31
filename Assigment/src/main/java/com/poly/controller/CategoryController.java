package com.poly.controller;


import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.Category;
import com.poly.mapper.CategoryMapper;
import com.poly.model.CategoryDTO;
import com.poly.service.CategorySerrvice;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {
	@Autowired
	private CategorySerrvice categoryService;
	@Autowired
	private HttpSession session;
	@Autowired
	private CategoryMapper mapper;

	@GetMapping("/index")
	public String getIndex(Model model, @RequestParam("direction") Optional<String> direction,@ModelAttribute("categoryDTO") CategoryDTO categoryDTO,
			@RequestParam("fiel") Optional<String> fiel, @RequestParam("page") Optional<Integer> page) {
		String fielEntity = fiel.isPresent() ? fiel.get() : "id";
		Integer pageParam = page.isPresent() ? page.get() - 1 : 0;
		Sort sort = (!direction.isPresent() || direction.get().equals("asc")) ? Sort.by(Direction.ASC, fielEntity)
				: Sort.by(Direction.DESC, fielEntity);
		Pageable pageable = PageRequest.of(pageParam, 5, sort);
		List<CategoryDTO> list = categoryService.getPage(pageable);
		int pagecount = this.categoryService.getTotalPage();

		model.addAttribute("categories", list);
		model.addAttribute("pagecount", pagecount);
		model.addAttribute("view", "/WEB-INF/View/Amin/QLTL.jsp");
		return "/Amin/index";
	}

	@GetMapping("/indexFind")
	public String getFindId(Model model, @RequestParam("name") String name,@ModelAttribute("categoryDTO") CategoryDTO categoryDTO) {
		List<CategoryDTO> list = categoryService.getByName(name);
		int pagecount = this.categoryService.getTotalPage();
		model.addAttribute("categories", list);
		model.addAttribute("pagecount", pagecount);
		model.addAttribute("view", "/WEB-INF/View/Amin/QLTL.jsp");
		return "/Amin/index";
	}
	@GetMapping("/create")
	public String getCreate(Model model,@ModelAttribute("categoryDTO") CategoryDTO categoryDTO) {
		session.setAttribute("save","store");
		model.addAttribute("view", "/WEB-INF/View/Amin/QLTLForm.jsp");
		return "/Amin/index";
	}
	@PostMapping("/store")
	public String save(Model model,
			@Valid @ModelAttribute("categoryDTO") CategoryDTO categoryDTO,
			BindingResult result
			) {
		if(result.hasErrors()) {
			model.addAttribute("view", "/WEB-INF/View/Amin/QLTLForm.jsp");
			return "/Amin/index";
		}else {
			this.categoryService.save(categoryDTO);
			return "redirect:/category/index";
		}
		
		
	}
	@GetMapping("/edit/{id}")
	public String edit(Model model,@PathVariable("id") Category category) {
		CategoryDTO dto = mapper.convertToDTO(category);
		model.addAttribute("categoryDTO",dto);
		session.setAttribute("save","update");
		model.addAttribute("view", "/WEB-INF/View/Amin/QLTLForm.jsp");
		return "/Amin/index";
	}
	@PostMapping("/update")
	public String update(Model model,
			@Valid @ModelAttribute("categoryDTO") CategoryDTO categoryDTO,
			BindingResult result
			) {
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
			model.addAttribute("view", "/WEB-INF/View/Amin/QLTLForm.jsp");
			return "/Amin/index";
		}else {
			this.categoryService.save(categoryDTO);
			return "redirect:/category/index";
		}
		
		
	}
	@GetMapping("/delete/{category_id}")
	public String delete(Model model,@PathVariable("category_id") Integer id) {
		this.categoryService.delete(id);
		return "redirect:/category/index";
	}
	
}
