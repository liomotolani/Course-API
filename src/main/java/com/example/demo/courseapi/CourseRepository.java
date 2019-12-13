package com.example.demo.courseapi;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//Data service interface
public interface CourseRepository  extends CrudRepository<Course,String> {
	
	public List<Course> findByTopicId(String topicId);
	 
	
	

}
