package com.example.demo.topicapi;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	//When spring create an instance of class Course Service
	// it injects topic repository with the auto wired annotation
	@Autowired
	private TopicRepository topicRepository;
	
			
	public List<Topic> getAllTopics(){
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}

	
	public Optional<Topic> getTopic(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		 return topicRepository.findById(id);	}
	
	public Topic addTopic(Topic topic) {
		topicRepository.save(topic);
		return topic;
	}
	
	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
	}


	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}
}
