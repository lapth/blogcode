package com.lapth82.springmvc.form.taglib.radio.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lapth82.springmvc.form.taglib.radio.bean.User;

@Controller
public class UserInfo {

	@Autowired
	private User user;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String defaultView() {

		return "redirect:/viewUser";
	}
	
	@RequestMapping(value = "/viewUser", method = RequestMethod.GET)
	public ModelAndView viewUser() {

		return new ModelAndView("viewUser", "user", this.user);
	}

	@RequestMapping(value = "/modifyUser", method = RequestMethod.GET)
	public ModelAndView modifyUser() {

		Map<String, String> lstSkin = new HashMap<String, String>();
		lstSkin.put("1", "White");
		lstSkin.put("2", "Black");
		lstSkin.put("3", "Brown");
		lstSkin.put("4", "Orange");
		
		ModelAndView modelView = new ModelAndView("modifyUser");
		modelView.addObject("lstSkin", lstSkin);
		modelView.addObject("user", this.user);
		
		return modelView;
	}

	@RequestMapping(value = "/modifyUser", method = RequestMethod.POST)
	public ModelAndView updateUser(@ModelAttribute("user") User user) {
		// do some thing here, e.g: update database, ...
		
		return new ModelAndView("viewUser", "user", user);
	}
}
