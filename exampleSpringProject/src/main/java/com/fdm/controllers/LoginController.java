package com.fdm.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fdm.entity.User;

@Controller
@RequestMapping(value = "login")
public class LoginController {

	@RequestMapping(method = RequestMethod.GET)
	public String loadLoginPage(HttpSession session, User User) {
		if (session.getAttribute("activeUser") == null) {

			return "login";
		} else {
			return "home";
		}

	}

}
