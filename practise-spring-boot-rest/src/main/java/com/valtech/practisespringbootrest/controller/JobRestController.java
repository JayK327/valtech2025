package com.valtech.practisespringbootrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.valtech.practisespringbootrest.model.JobPost;
import com.valtech.practisespringbootrest.service.JobService;


//By default it thinks we returning a view name but if we want to send data we use @ResponseBody
//Alternate to treat return object as data we use @RestController
//@Controller 
@RestController
public class JobRestController {
	@Autowired
	public JobService service;
	
	@GetMapping(path="jobPosts",produces= {"application/json"})//also consume in post mapping.
//	@ResponseBody
	public List<JobPost> getAllJobs() {
		return service.getAllJobs();
	}
	
	@GetMapping("jobPost/{postId}")
	public JobPost getJob(@PathVariable("postId") int postId) {
		return service.getJob(postId);
	}
	
	@PostMapping("jobPost")
	public JobPost addJob(@RequestBody JobPost jobPost){
		service.addJob(jobPost);
		return service.getJob(jobPost.getPostId());
	}
	
	@PutMapping("jobPost")
	public JobPost updateJob(@RequestBody JobPost jobPost){
		service.updateJob(jobPost);
		return service.getJob(jobPost.getPostId());
	}
	@DeleteMapping("jobPost/{postId}")
	public String deleteJob(@PathVariable("postId") int postId) {
		service.deleteJob(postId);
		return "Deleted";
	}
	@GetMapping("load")
	public String loadData() {
		service.load();
		return "success";
	}
	@GetMapping("jobPosts/keyword/{keyword}")
	public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
		return service.search(keyword);
	}
	
	
}
