package com.example.crudApiStarter.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.TomcatPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudApiStarter.entity.User;
import com.example.crudApiStarter.repository.UserRepository;
import com.example.crudApiStarter.service.UserService;

@RequestMapping("/user")
@RestController
public class CrudCntroller {

	@Autowired
	private UserService userService;
	
	//@RequestMapping("/all")
	@GetMapping("/all")
	public List<User> info() {
		return userService.getAllUsers();
	}
	
	//@RequestMapping(method = RequestMethod.GET, value="/{id}")
	@GetMapping("/{id}")
	public Optional<User> getUser(@PathVariable String id) {
		return userService.getUser(id);
	}
	
	//@RequestMapping(method = RequestMethod.GET)
	@GetMapping()
	public List<User> getUserByName(@RequestParam("name") String name) {
		return userService.getUserByName(name);
	}
	
	//@RequestMapping(method = RequestMethod.POST)
	@PostMapping()
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	//@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	@PutMapping("/{id}")
	public void updateUser(@RequestBody User user,@PathVariable String id) {
		userService.updateUser(id, user);
	}
	
	//@RequestMapping(method = RequestMethod.DELETE,value = "/{id}")
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
	}
	
	
	
}
