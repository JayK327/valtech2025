package com.valtech.practisespringbootrest.repo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.practisespringbootrest.model.JobPost;

//Want to fetch data from somewhere, maybe database or some other server.
@Repository
public interface JobRepository extends JpaRepository<JobPost, Integer>{
	
	List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile,String postDesc);
	}
//List<JobPost> jobs=new ArrayList<>(Arrays.asList(
//		new JobPost(1,"Java Developer","Must",4,Arrays.asList("Java")),
//		new JobPost(2,"Machine Learning Engineer","Must",5,Arrays.asList("Python","Numpy","pandas")),
//		new JobPost(3,"Frontend Developer","Must",2,Arrays.asList("Html","CSS","JS")),
//		new JobPost(4,"Mobile App Developer","Must",5,Arrays.asList("Flutter"))
//		));
//
//public List<JobPost> getAllJobs(){
//	return jobs;
//}
//public void addJob(JobPost job) {
//	jobs.add(job);
//	System.out.println(jobs);
//}
//public JobPost getJob(int postId) {
//	for(JobPost job:jobs) {
//		if(job.getPostId()==postId) {
//			return job;
//		}
//	}
//	return null;
//}
//public void updateJob(JobPost jobPost) {
//	for(JobPost jobPost1:jobs) {
//		if(jobPost1.getPostId()==jobPost.getPostId()) {
//			jobPost1.setPostProfile(jobPost.getPostProfile());
//			jobPost1.setPostDesc(jobPost.getPostDesc());
//			jobPost1.setReqExperience(jobPost.getReqExperience());
//			jobPost1.setPostTechStack(jobPost.getPostTechStack());
//		}
//}
//}
//public void deleteJob(int postId) {
//	for(JobPost job:jobs) {
//		if(job.getPostId()==postId) {
//			jobs.remove(job);
//		}
//	}
//}