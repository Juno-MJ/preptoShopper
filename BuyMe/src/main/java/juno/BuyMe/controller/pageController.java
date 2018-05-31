package juno.BuyMe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import juno.BuyMeBackEnd.DAO.ElectronicCategoryDAO;
import juno.BuyMeBackEnd.DTO.ElectronicCategory;

@Controller
public class pageController {
	
	@Autowired
	private ElectronicCategoryDAO electronicCategoryDAO;
	
	@RequestMapping(value= {"/"})
	public ModelAndView hitterPage() {
		ModelAndView modelAndView = new ModelAndView("page");
		modelAndView.addObject("title","preptoShopper");
		modelAndView.addObject("userClicksHome",true);
		modelAndView.addObject("electronicCategories",electronicCategoryDAO.listCategories());
		return modelAndView;
	}
	
	@RequestMapping(value= {"/show/all/products"})
	public ModelAndView listAllProducts() {
		ModelAndView modelAndView = new ModelAndView("page");
		modelAndView.addObject("title","All Products");
		modelAndView.addObject("userClicksViewProducts",true);
		//another reason to keep this..bcz of sidebar..it will be loaded again once this page 
		//is clicked...[under listproducts.jsp]
		modelAndView.addObject("electronicCategories",electronicCategoryDAO.listCategories());
		return modelAndView;
	}
	
	@RequestMapping(value= {"/show/category/{id}/products"})
	public ModelAndView listSpecificProducts(@PathVariable("id") int id) {
		ModelAndView modelAndView = new ModelAndView("page");
		ElectronicCategory category = electronicCategoryDAO.getCategory(id);
		modelAndView.addObject("userClicksSpecificCategory",true);
		modelAndView.addObject("electronicCategories",electronicCategoryDAO.listCategories());
		modelAndView.addObject("chosenCategory",category);
		modelAndView.addObject("title",category.getCategoryName());
		System.out.println(category.getCategoryName());
		return modelAndView;
	}
	
	@RequestMapping(value= {"/about"})
	public ModelAndView hitabout() {
		ModelAndView modelAndView = new ModelAndView("page");
		modelAndView.addObject("title","About Us");
		modelAndView.addObject("userClicksAbout",true);
		return modelAndView;
	}
	
	
	@RequestMapping(value= {"/contact"})
	public ModelAndView hitcontact() {
		ModelAndView modelAndView = new ModelAndView("page");
		modelAndView.addObject("title","Contact");
		modelAndView.addObject("userClicksContact",true);
		return modelAndView;
	}
	
	
	
	@RequestMapping(value="/testingRP")
	public ModelAndView requestParamDemo(@RequestParam(value="greeting",required=false) String greetMsg) {
		if(greetMsg==null) {
			greetMsg="This is a default msg";
		}
		ModelAndView modelAndView = new ModelAndView("page");
		modelAndView.addObject("hitMessage",greetMsg);
		return modelAndView;
	}
	
	@RequestMapping(value="/testingPathVar/{greeting}")
	public ModelAndView pathVariableDemo(@PathVariable(value="greeting",required=false) String greetMsg) {
		if(greetMsg==null) {
			greetMsg="This is a default msg";
		}
		ModelAndView modelAndView = new ModelAndView("page");
		modelAndView.addObject("hitMessage",greetMsg);
		return modelAndView;
	}
	
}
