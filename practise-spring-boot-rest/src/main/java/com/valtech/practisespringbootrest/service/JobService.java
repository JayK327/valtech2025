package com.valtech.practisespringbootrest.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.practisespringbootrest.model.JobPost;
import com.valtech.practisespringbootrest.repo.JobRepository;
//job of service is to do any processing.
@Service
public class JobService {
	@Autowired
	private JobRepository repo;

	public void addJob(JobPost jobPost) {
//		repo.addJob(jobPost);
		repo.save(jobPost);
	}
	
	public List<JobPost> getAllJobs(){
//		return repo.getAllJobs();
		return repo.findAll();
	}
	
	public JobPost getJob(int postId) {
		return repo.findById(postId).orElse(new JobPost());
	}
	public void updateJob(JobPost jobPost) {
		repo.save(jobPost);
	}
	public void deleteJob(int postId) {
		repo.deleteById(postId);
	}
	
	public List<JobPost> search(String keyword){
		return repo.findByPostProfileContainingOrPostDescContaining(keyword,keyword);
	}

	public void load() {
		List<JobPost> jobs=new ArrayList<>(Arrays.asList(
		new JobPost(1,"Java Developer","Must",4,Arrays.asList("Java")),
		new JobPost(2,"Machine Learning Engineer","Must",5,Arrays.asList("Python","Numpy","pandas")),
		new JobPost(3,"Frontend Developer","Must",2,Arrays.asList("Html","CSS","JS")),
		new JobPost(4,"Mobile App Developer","Must",5,Arrays.asList("Flutter"))
		));
		repo.saveAll(jobs);
	}


}
