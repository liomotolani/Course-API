package com.example.demo.topicapi;

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




@RestController
public class TopicController {
	
	//When spring create an instance of CourseController it injects 
	// topic service
	@Autowired
	TopicService topicService;

	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	@GetMapping("/topic/{id}")
	public Optional<Topic> getTopic(@PathVariable String id) {
		return  (Optional<Topic>) topicService.getTopic(id);
	}
	
	@PostMapping("/topic")
	public Topic addTopic(@RequestBody Topic topic) {
		return topicService.addTopic(topic);
		
		
	}
	
	@PutMapping("/topic/{id}")
	public Topic updateTopic(@RequestBody Topic topic,@PathVariable String id) {
		topicService.updateTopic(id,topic);
		return topic;
		
	}
	
	@DeleteMapping("/topic/{id}")
	public Topic deleteTopic(@RequestBody Topic topic,@PathVariable String id) {
		topicService.deleteTopic(id);
		return topic;
	}
}
