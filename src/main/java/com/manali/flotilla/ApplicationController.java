package com.manali.flotilla;




import org.slf4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import com.manali.flotilla.models.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ApplicationController {
	
	private static Logger logger = (Logger) org.slf4j.LoggerFactory.getLogger(ApplicationController.class);
	
	@GetMapping("/login")
	public String gologin() {
		return "login";
	}
	
	@GetMapping("/register")
	public String signup() {
		return "register";
	}
	
	private User getPrincipal() {
		User user=null;
		if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User) {
			user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		return user;
	}

	@GetMapping("/logout")
	public String gologout() {
		return "login";
	}
	
	@GetMapping("/index")
	public String goHome(Model model) {
		User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		log.info("User: ");
		return "index";
	}
}
