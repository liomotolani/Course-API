package com.example.demo.courseapi;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.topicapi.Topic;




@RestController
public class CourseController {
	
	//When spring create an instance of CourseController it injects 
	// topic service
	@Autowired
	CourseService courseService;

	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseService.getAllCourses(id);
	}
	
	@GetMapping("/topics/{topicid}/course/{id}")
	public Optional<Course> getCourse(@PathVariable String id) {
		return  (Optional<Course>) courseService.getCourse(id);
	}
	
	@PostMapping("/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {	
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);	
		
	}
	
	@PutMapping("/topic/{topicid}/course/{id}")
	public void updateCourse(@RequestBody Course course,@PathVariable String topicid,@PathVariable String id) {
		course.setTopic(new Topic(topicid,"",""));
		courseService.updateCourse(course);
	
		
	}
	
	@DeleteMapping("/topic/{topicid}/course/{id}")
	public void deleteCourse(@RequestBody Course course,@PathVariable String id) {
		courseService.deleteCourse(id);
		
	}
}
