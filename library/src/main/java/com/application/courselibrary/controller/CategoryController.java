package com.application.courselibrary.controller;

import com.application.courselibrary.entity.Category;
import com.application.courselibrary.service.CategoryService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public String findAllCategories(Model model) {
        model.addAttribute("categories", categoryService.findAllCategories());
//        <td th:text="${category.name}"></td>
//        <tr th:each="category : ${categories}">
//        <td th:text="${category.id}"></td>
        return "categories";
    }

    @GetMapping("/remove-category/{id}")
    public String deleteCategory(@PathVariable Long id, Model model) {
        categoryService.deleteCategory(id);
        model.addAttribute("categories", categoryService.findAllCategories());
        return "categories";
    }

    @GetMapping("update-category/{id}")
    public String updateCategory(@PathVariable Long id, Model model) {
    	
    	model.addAttribute("category", categoryService.findCategoryById(id));
    	
        return "update-category";
    }

    @PostMapping("/update-category/{id}")
  	public String saveCategory(@PathVariable Long id, @ModelAttribute("category") Category cat, BindingResult bindingResult, Model model) {
    	
    	System.out.printf("CATeGORY: " + cat.getName());
    	
        if (bindingResult.hasErrors()) {
            return "update-category";
        }
        
        categoryService.updateCategory(cat);
        model.addAttribute("categories", categoryService.findAllCategories());
        return "redirect:/categories";
    }

    @GetMapping("/add-category")
    public String showCreateCategory(Category category, Model theModel) {
    	
    	// create model attribute to bind form data
    	Category theCategory = new Category();
    	
    	// set employee as a model attribute to pre-populate the form
    	theModel.addAttribute("category", theCategory);
        return "add-category";
    }

    @PostMapping("/save-category")
    public String saveCategory(@ModelAttribute("category") Category cat, BindingResult bindingResult, Model model){
    	System.out.printf("CATeGoRY: " + cat.getName());
        if(bindingResult.hasErrors())
            return "add-categories";
        categoryService.createCategory(cat);
        model.addAttribute("categories", categoryService.findAllCategories());
        return "redirect:/categories";
    }

}
