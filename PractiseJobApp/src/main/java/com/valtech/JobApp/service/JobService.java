package com.valtech.JobApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.JobApp.model.JobPost;
import com.valtech.JobApp.repo.JobRepository;
//job of service is to do any processing.
@Service
public class JobService {
	@Autowired
	private JobRepository repo;
	public void addJob(JobPost jobPost) {
		repo.addJob(jobPost);
	}
	
	public List<JobPost> getAllJobs(){
		return repo.getAllJobs();
	}
}
