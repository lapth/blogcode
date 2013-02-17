package com.lapth82.springmvc.form.taglib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lapth82.springmvc.form.taglib.bean.User;
import com.lapth82.springmvc.form.taglib.validator.UserValidator;

@Controller
public class UserInfo {

	@Autowired
	private User user;

	@Autowired
	@Qualifier("userValidator")
	private UserValidator validator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(this.validator);
	}
	
	@RequestMapping(value = "/modifyUser", method = RequestMethod.POST)
	public ModelAndView updateUser(@ModelAttribute("user") User user, BindingResult bindingResult) {
		validator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {
			// show errors
			return new ModelAndView("modifyUser", "user", user);
		} else {
			// success
			return new ModelAndView("viewUser", "user", user);
		}	
	}
	
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
}
