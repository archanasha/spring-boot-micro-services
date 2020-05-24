package com.timetrain.springweb.springweb.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.timetrain.springweb.springweb.dto.User;
import com.timetrain.springweb.springweb.exception.UserNotFoundException;
import com.timetrain.springweb.springweb.service.UserDAOService;

@RestController
public class UserController {
	
	@Autowired
	private UserDAOService userDAOService;
	
	@GetMapping(path = "/users")
	public List<User> getAllUsers () {
		return userDAOService.findAll();
	}
	
	@GetMapping(path = "/users/{id}")
	public User getUser (@PathVariable int id) {
		User user = userDAOService.findUser(id);
		
		if(user == null)
			throw new UserNotFoundException("id: "+ id);
		
		  return user;
	 
	}
	
//	@SuppressWarnings("deprecation")
//	@GetMapping(path = "/users/{id}")
//	public EntityModel<User> getUser (@PathVariable int id) {
//		User user = userDAOService.findUser(id);
//		
//		if(user == null)
//			throw new UserNotFoundException("id: "+ id);
//		
//		//HATEOAS
//		
//		  return new EntityModel<User>(user,
//				    linkTo(methodOn(this.getClass()).getAllUsers()).withSelfRel());
//	 
//	}
	
	@PostMapping(path="/users")
	public ResponseEntity<String> addUser(@RequestBody User user) {
		User createdUser = userDAOService.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(
				createdUser.getId()).toUri();
		return ResponseEntity.created(location).build(); 
	}
	
	@DeleteMapping(path = "/users/{id}")
	public int deleteUser (@PathVariable int id) {
		int deletedId = userDAOService.deleteUser(id);
		
		if(deletedId == -1)
			throw new UserNotFoundException("id: "+ id);
		
		return deletedId;
	}

}
