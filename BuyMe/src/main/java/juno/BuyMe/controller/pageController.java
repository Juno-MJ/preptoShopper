package juno.BuyMe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class pageController {
	
	@RequestMapping(value= {"/"})
	public ModelAndView hitterPage() {
		ModelAndView modelAndView = new ModelAndView("page");
		modelAndView.addObject("hitMessage","Hit Done");
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
