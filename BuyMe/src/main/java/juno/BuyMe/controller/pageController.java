package juno.BuyMe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class pageController {
	
	@RequestMapping(value= {"/"})
	public ModelAndView hitterPage() {
		ModelAndView modelAndView = new ModelAndView("page");
		modelAndView.addObject("hitMessage","Hit Done");
		return modelAndView;
	}
	
}
