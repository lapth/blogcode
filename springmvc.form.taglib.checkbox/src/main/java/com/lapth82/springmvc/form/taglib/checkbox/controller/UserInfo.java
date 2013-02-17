package com.lapth82.springmvc.form.taglib.checkbox.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lapth82.springmvc.form.taglib.checkbox.bean.User;

@Controller
public class UserInfo {

	@Autowired
	private User user;

	@RequestMapping(value = "/viewUser", method = RequestMethod.GET)
	public ModelAndView viewUser() {

		return new ModelAndView("viewUser", "user", this.user);
	}

	@RequestMapping(value = "/modifyUser", method = RequestMethod.GET)
	public ModelAndView modifyUser() {

		Map<String, String> lstHobby = new HashMap<String, String>();
		lstHobby.put("1", "Music");
		lstHobby.put("2", "Game");
		lstHobby.put("3", "Reading");

		ModelAndView modelView = new ModelAndView("modifyUser");
		modelView.addObject("lstHobby", lstHobby);
		modelView.addObject("user", this.user);
		
		return modelView;
	}

	@RequestMapping(value = "/modifyUser", method = RequestMethod.POST)
	public ModelAndView updateUser(@ModelAttribute("user") User user) {
		// do some thing here, e.g: update database, ...
		
		return new ModelAndView("viewUser", "user", user);
	}
}
