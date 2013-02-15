package com.lapth82.springmvc.velocity.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lapth82.springmvc.velocity.model.User;

@Controller
public class HomeController {

	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		
		User user = new User();
		user.setName("lapth82");
		user.setTitle("blogger");
		
		Map<String, User> model = new HashMap<String, User>();
		model.put("user", user);
		
		return new ModelAndView("home", model);
	}
}
