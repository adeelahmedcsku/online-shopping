package net.kzn.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

@Controller
public class PageController {

	@Autowired
	private CategoryDAO CategoryDAO;
	
	@RequestMapping(value= {"/","/home","/index"})
	
	public ModelAndView index()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "Home");
		//passing the list of categories
		mv.addObject("categories", CategoryDAO.list());
		mv.addObject("userClickHome", "true");
		return 	mv;
	}
	
	
@RequestMapping(value= "/show/all/products")
	
	public ModelAndView showAllProducts()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "All Products");
		mv.addObject("categories", CategoryDAO.list());
		mv.addObject("userClickAllProducts", "true");
		return 	mv;
	}

@RequestMapping(value= "/show/category/{id}/products")

public ModelAndView showCategoryProducts(@PathVariable("id") int id)
{
	ModelAndView mv=new ModelAndView("page");

	//get the category by id
	
	Category category=null;
	category=CategoryDAO.get(id);
	mv.addObject("title", category.getName());
	mv.addObject("categories", CategoryDAO.list());

	mv.addObject("category", category);
	
	mv.addObject("userClickCategoryProducts", "true");
	
	return 	mv;
}


	@RequestMapping(value= {"/about"})
	
	public ModelAndView about()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", "true");
		return 	mv;
	}
	
@RequestMapping(value= {"/contact"})
	
	public ModelAndView contact()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", "true");
		return 	mv;
	}
	
	/*@RequestMapping(value="/test")
	public ModelAndView test(@RequestParam("greeting") String greeting)
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;
	}*/
	
	
	/*@RequestMapping(value="/test/{greeting}")
	public ModelAndView test(@PathVariable("greeting") String greeting)
	{
		if (greeting==null) {
			greeting="Hello there";
		}
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;
	}*/
}
