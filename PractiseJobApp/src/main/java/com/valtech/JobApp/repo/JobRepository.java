package com.valtech.JobApp.repo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.valtech.JobApp.model.JobPost;

//Want to fetch data from somewhere, maybe database or some other server.
@Repository
public class JobRepository {
	
	List<JobPost> jobs=new ArrayList<>(Arrays.asList(
			new JobPost(1,"Java Developer","Must",4,Arrays.asList("Java")),
			new JobPost(2,"Machine Learning Engineer","Must",5,Arrays.asList("Python","Numpy","pandas")),
			new JobPost(3,"Frontend Developer","Must",2,Arrays.asList("Html","CSS","JS")),
			new JobPost(4,"Mobile App Developer","Must",5,Arrays.asList("Flutter"))
			));
	
	public List<JobPost> getAllJobs(){
		return jobs;
	}
	public void addJob(JobPost job) {
		jobs.add(job);
		System.out.println(jobs);
	}
}
