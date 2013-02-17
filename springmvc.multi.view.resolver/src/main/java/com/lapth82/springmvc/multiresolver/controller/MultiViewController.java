package com.lapth82.springmvc.multiresolver.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lapth82.springmvc.multiresolver.model.User;

@Controller
public class MultiViewController {
	
	@RequestMapping("/fromjsp")
	public ModelAndView fromJSP() {
		return new ModelAndView("fromjsp");
	}
	
	@RequestMapping("/fromvm")
	public ModelAndView fromVM() {

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
