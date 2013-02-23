package com.lapth82.springmvc.form.multirow.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.lapth82.springmvc.form.multirow.bean.Option;
import com.lapth82.springmvc.form.multirow.bean.User;
import com.lapth82.springmvc.form.multirow.bean.UserForm;
import com.lapth82.springmvc.form.multirow.validator.UserValidator;

@Controller
@SessionAttributes({"lstHobby", "lstCountry"})
public class UserInfo {
	
	@Autowired
	@Qualifier("userValidator")
	private UserValidator validator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		if (this.validator.supports(binder.getTarget().getClass())) {
			binder.setValidator(this.validator);
		}
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String defaultView() {
		return "redirect:/viewUser";
	}
	
	@RequestMapping(value = "/viewUser", method = RequestMethod.GET)
	public String viewUser(ModelMap modelMap) {
		
		List<Option> lstHobby = new ArrayList<Option>();
		lstHobby.add(new Option("1", "Music"));
		lstHobby.add(new Option("2", "Game"));
		lstHobby.add(new Option("3", "Reading"));

		List<Option> lstCountry = new ArrayList<Option>();
		lstCountry.add(new Option("1", "US"));
		lstCountry.add(new Option("2", "French"));
		lstCountry.add(new Option("3", "VietNam"));
		
		ArrayList<User> lstUser = new ArrayList<User>();
		lstUser.add(new User());
		lstUser.add(new User());
		
		UserForm users = new UserForm();
		users.setLstUser(lstUser);
		
		modelMap.put("lstHobby", lstHobby);
		modelMap.put("lstCountry", lstCountry);
		modelMap.put("users", users);
		
		return "modifyUser";
	}

	@RequestMapping(value = "/modifyUser", method = RequestMethod.POST)
	public ModelAndView updateUser(@ModelAttribute("users") UserForm userForm, BindingResult bindingResult) {
		validator.validate(userForm, bindingResult);
		
		if (bindingResult.hasErrors()) {
			// show errors
			return new ModelAndView("modifyUser");
		} else {
			// success
			return new ModelAndView("viewUser");
		}
	}
}
