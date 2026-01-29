package com.porfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.porfolio.model.Contact;
import com.porfolio.service.ContactService;

@Controller
public class ContactController {
	@Autowired
	ContactService us;

	@GetMapping(value = "/")
	public ModelAndView viewPage(ModelAndView m) {
		m.setViewName("index");
		return m;
	}

	@PostMapping("/")
	public String handleContact(@RequestParam String name, @RequestParam String email, @RequestParam String msg,
			@RequestParam(required = false) String sendbtn, ModelAndView m, RedirectAttributes redirectAttributes) {
		if ("Send Message".equalsIgnoreCase(sendbtn)) {
				us.saveQueryAndSendEmail(name, email, msg);
		}
		redirectAttributes.addFlashAttribute("success", "Email sent successfully!");
		return "redirect:/";
	}
}
