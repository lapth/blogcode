package com.lapth82.springmvc.form.taglib.selectt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lapth82.springmvc.form.taglib.selectt.bean.Option;
import com.lapth82.springmvc.form.taglib.selectt.bean.User;

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

		/* We use a list of Option instead of Map */
		List<Option> lstSkill = new ArrayList<Option>();
		
		lstSkill.add(new Option("1", "Java"));
		lstSkill.add(new Option("2", "C#"));
		lstSkill.add(new Option("3", "PHP"));
		lstSkill.add(new Option("4", "C++"));
		
		ModelAndView modelView = new ModelAndView("modifyUser");
		modelView.addObject("lstSkill", lstSkill);
		modelView.addObject("user", this.user);
		
		return modelView;
	}

	@RequestMapping(value = "/modifyUser", method = RequestMethod.POST)
	public ModelAndView updateUser(@ModelAttribute("user") User user) {
		// do some thing here, e.g: update database, ...
		
		return new ModelAndView("viewUser", "user", user);
	}
}
