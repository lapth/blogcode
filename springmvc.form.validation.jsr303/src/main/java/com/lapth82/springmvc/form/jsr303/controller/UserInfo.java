package com.lapth82.springmvc.form.jsr303.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lapth82.springmvc.form.jsr303.bean.User;

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

		ModelAndView modelView = new ModelAndView("modifyUser");
		modelView.addObject("user", this.user);
		
		return modelView;
	}

	@RequestMapping(value = "/modifyUser", method = RequestMethod.POST)
	public ModelAndView updateUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			// show errors
			return new ModelAndView("modifyUser", "user", user);
		} else {
			// success
			return new ModelAndView("viewUser", "user", user);
		}	
	}
}
