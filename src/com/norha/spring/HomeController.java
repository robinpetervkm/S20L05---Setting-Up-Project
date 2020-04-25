package com.norha.spring;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/")
	public ModelAndView getHome() {
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}

}
