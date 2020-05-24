package com.timetrain.springweb.springweb.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.timetrain.springweb.springweb.dto.User;

@Component
public class UserDAOService {
	
	private static List<User> users = new ArrayList<>();
	
	private static int userIdCount = 3;
	
	static {
//		users.add(new User(1, "John", new Date()));
//		users.add(new User(2, "Mack", new Date()));
//		users.add(new User(3, "Amy", new Date()));
	}

	public List<User> findAll() {
		return users;
	}
	
	public User save(User user) {
		if (user.getId() == null) {
			user.setId((++userIdCount));
		}
		users.add(user);
		return user;
	}
	
	public User findUser(int id) {
		for (User user: users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	public int deleteUser(int id) {
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return id;
			}
		}
		return -1;
	}

}
