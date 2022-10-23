package com.robin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileController {
	
	@RequestMapping(path="/index", method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(path="/index2", method=RequestMethod.GET)
	public ModelAndView index2(ModelAndView model) {
		model.addObject("name", "Robin");
		model.setViewName("index2");
		return model;
	}
	
	@RequestMapping(path="/index3", method=RequestMethod.GET)
	public String index3(Model model) {
		model.addAttribute("name", "Robin");
		return "index2";
	}
	
	@RequestMapping(path="/index4", method=RequestMethod.GET)
	public ModelAndView index4(ModelAndView model) {
		model.addObject("name", "Robin");
		model.setViewName("index4");
		return model;
	}
}
