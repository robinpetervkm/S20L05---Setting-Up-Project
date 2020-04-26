package com.norha.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.norha.spring.DAO.AppDAOImpl;
import com.norha.spring.model.User;

@Controller
public class HomeController {

	@RequestMapping("/")
	public ModelAndView getHome() {
		ModelAndView modelAndView = new ModelAndView("index");
		List<User> listUsers = new ArrayList<User>();
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"/com/norha/spring/DAO/SpringDAO-config.xml");
		AppDAOImpl dao = applicationContext.getBean("DAOBean", AppDAOImpl.class);
		listUsers = dao.listUsers();
		modelAndView.addObject("users", listUsers);
		applicationContext.close();
		return modelAndView;
	}

}
