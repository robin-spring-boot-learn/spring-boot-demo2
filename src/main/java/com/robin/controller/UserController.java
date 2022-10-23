package com.robin.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.robin.entity.User;
import com.robin.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//@RequestMapping(value="/user", method=RequestMethod.GET)
	@GetMapping(path="/user")
	public User getUser(@RequestParam(value="id", required=true, defaultValue="111") long id) {
		return userService.getUser(id);
	}
	
	@RequestMapping(value="/result", method=RequestMethod.GET)
	public Map<String, Object> getResult(long id){
		Map<String, Object> map = new HashMap<>();
		map.put("code", 200);
		map.put("msg", "success");
		map.put("data", userService.getUser(id));
		return map;
	}
	@GetMapping("/v1/page_user/{from}/{size}")
	public Map<String, Object> pageUser2(
			@PathVariable(value="from", required=true) int from, 
			@PathVariable(value="size", required=true) int size){
		
		return pageUser(from, size);
	}
	
	@GetMapping("/v1/page_user")
	public Map<String, Object> pageUser(
			@RequestParam(value="from", required=true, defaultValue="10") int from, 
			@RequestParam(value="size", required=true, defaultValue="10") int size){
		Map<String, Object> map = new HashMap<>();
		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("list", new User[]{userService.getUser(11)});
		dataMap.put("from", from);
		dataMap.put("size", size);
		map.put("code", 200);
		map.put("msg", "success");
		map.put("data", dataMap);
		return map;
	}
}
