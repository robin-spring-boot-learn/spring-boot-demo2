package com.robin.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
	
	@RequestMapping("/v1/save_user")
	public Map<String, Object> pageUser(@RequestBody User user){
		Map<String, Object> map = new HashMap<>();
		map.put("code", 200);
		map.put("msg", "success");
		map.put("data", user);
		return map;
	}
	
	@GetMapping("/v1/get_header")
	public Map<String, Object> getHeader(
			@RequestHeader("access_token") String accessToken){
		Map<String, Object> map = new HashMap<>();
		map.put("code", 200);
		map.put("msg", "success");
		map.put("accessToken", accessToken);
		return map;
	}
	
	@GetMapping("/v1/auto_insert")
	public Map<String, Object> getUser(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<>();
		map.put("code", 200);
		map.put("msg", "success");
		String accessToken = request.getHeader("access_token");
		map.put("requestAccessToken", accessToken);
		response.setHeader("response_access_token", accessToken);
		return map;
	}
	
	@PostMapping("/v1/create_user")
	public Object createUser(@RequestBody User user) {
		Map<String, Object> map = new HashMap<>();
		map.put("code", 200);
		map.put("msg", "create success");
		map.put("data", user);
		return map;
	}

	@PatchMapping("/v1/update_user")
	public Object updateUser(@RequestBody User user) {
		Map<String, Object> map = new HashMap<>();
		map.put("code", 200);
		map.put("msg", "update success");
		map.put("data", user);
		return map;
	}
	@PutMapping("/v1/update_user2")
	public Object updateUser2(@RequestBody User user) {
		Map<String, Object> map = new HashMap<>();
		map.put("code", 200);
		map.put("msg", "update2 success");
		map.put("data", user);
		return map;
	}
	
	@DeleteMapping("/v1/delete_user")
	public Object updateUser(long id) {
		Map<String, Object> map = new HashMap<>();
		map.put("code", 200);
		map.put("msg", "update success");
		map.put("data", id);
		return map;
	}
	
	@DeleteMapping("/v1/test_jackson")
	public Object testJackson(long id) {
		Map<String, Object> map = new HashMap<>();
		map.put("code", 200);
		map.put("msg", "update success");
		map.put("data", id);
		return map;
	}
}
