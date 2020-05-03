package com.norha.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.norha.spring.DAO.AppDAOImpl;
import com.norha.spring.config.AppConfig;
import com.norha.spring.model.User;

@Controller
public class HomeController {

	@RequestMapping("/")
	public ModelAndView getHome() {
		ModelAndView modelAndView = new ModelAndView("index");
		List<User> listUsers = new ArrayList<User>();

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AppDAOImpl dao = context.getBean("DAOBean", AppDAOImpl.class);
		listUsers = dao.listUsers();
		modelAndView.addObject("users", listUsers);
		context.close();
		return modelAndView;
	}

	@RequestMapping("/addUser")
	public String addUser(Model model, User user) {
		model.addAttribute("User", user);

		if (user.getName() == null && user.getEmail() == null)
			return "addUser";
		else {
			AnnotationConfigApplicationContext context = 
					new AnnotationConfigApplicationContext(AppConfig.class);
			AppDAOImpl dao = context.getBean("DAOBean", AppDAOImpl.class);
			dao.addUser(user);
			context.close();
			return "forward:/";
		}
	}
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
	@RequestMapping("/user")
	public ModelAndView user() {
		ModelAndView modelAndView = new ModelAndView("user");
		return modelAndView;
	}
	@RequestMapping("/admin")
	public ModelAndView admin() {
		ModelAndView modelAndView = new ModelAndView("admin");
		return modelAndView;
	}
	@RequestMapping("/403")
	public ModelAndView page403() {
		ModelAndView modelAndView = new ModelAndView("403");
		return modelAndView;
	}

}
