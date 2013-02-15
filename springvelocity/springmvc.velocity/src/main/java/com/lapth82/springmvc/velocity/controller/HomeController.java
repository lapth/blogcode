package com.lapth82.springmvc.velocity.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
		
		User user1 = new User();
		user1.setName("lapth82");
		user1.setTitle("blogger");
		
		User user2 = new User();
		user2.setName("user2");
		user2.setTitle("blogger");
		
		List<User> lstUser = new ArrayList<User>();
		lstUser.add(user1);
		lstUser.add(user2);
		
		Map<String, List<User>> model = new HashMap<String, List<User>>();
		model.put("users", lstUser);
		
		return new ModelAndView("home", model);
	}
}
