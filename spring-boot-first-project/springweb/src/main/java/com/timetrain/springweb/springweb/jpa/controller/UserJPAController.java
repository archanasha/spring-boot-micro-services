package com.timetrain.springweb.springweb.jpa.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.timetrain.springweb.springweb.dto.Post;
import com.timetrain.springweb.springweb.dto.User;
import com.timetrain.springweb.springweb.exception.UserNotFoundException;
import com.timetrain.springweb.springweb.jpa.repository.PostRespository;
import com.timetrain.springweb.springweb.jpa.repository.UserRespository;

@RestController
public class UserJPAController {
	
	
	@Autowired
	private UserRespository userRespository;
	
	@Autowired
	private PostRespository postRespository;
	
	@GetMapping(path = "/jpa/users")
	public List<User> getAllUsers () {
		return userRespository.findAll();
	}
	
	@GetMapping(path = "/jpa/users/{id}")
	public User getUser (@PathVariable int id) {
		Optional<User> user = userRespository.findById(id);
		
		if(!user.isPresent())
			throw new UserNotFoundException("id: "+ id);
		
		  return user.get();
	 
	}
	
	@PostMapping(path="/jpa/users")
	public ResponseEntity<String> addUser(@RequestBody User user) {
		User createdUser = userRespository.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(
				createdUser.getId()).toUri();
		return ResponseEntity.created(location).build(); 
	}
	
	@PostMapping(path="/jpa/users/{id}/post")
	public ResponseEntity<String> addPost(@PathVariable int id, @RequestBody Post post) {
		Optional<User> user = userRespository.findById(id);
		
		if(!user.isPresent())
			throw new UserNotFoundException("id: "+ id);
		
		post.setUser(user.get());
		
		Post createdPost = postRespository.save(post);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(
				createdPost.getId()).toUri();
		return ResponseEntity.created(location).build(); 
	}
	
	@DeleteMapping(path = "/jpa/users/{id}")
	public void deleteUser (@PathVariable int id) {
	 userRespository.deleteById(id);
	}

}
