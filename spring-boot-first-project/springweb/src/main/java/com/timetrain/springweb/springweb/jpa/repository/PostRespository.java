package com.timetrain.springweb.springweb.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.timetrain.springweb.springweb.dto.Post;

@Repository
public interface PostRespository extends JpaRepository<Post, Integer>{
	
	
}
