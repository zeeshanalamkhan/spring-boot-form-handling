package com.zeeshan.form.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.zeeshan.form.model.User;
import com.zeeshan.form.repository.UserRepository;

@Controller
public class FormController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/")
	public String home() {

		return "index";
	}

	@GetMapping("/register")
	public String showForm(Model model, User user) {

		model.addAttribute("user", user);

		List<String> professionList = Arrays.asList("Developer", "Designer", "Tester");
		model.addAttribute("professionList", professionList);
		return "register_form";
	}

	@PostMapping("/register")
	public String submitForm(@Valid @ModelAttribute("user") User user, BindingResult result) {

		if (result.hasErrors()) {
			return "register_form";
		}
		userRepository.save(user);
		return "register_success";
	}

	@GetMapping("/register/{id}")
	public String findById(Model model, @PathVariable Long id) {

		User user = userRepository.findById(id).get();
		model.addAttribute("user", user);
		return "register_success";
	}
}
