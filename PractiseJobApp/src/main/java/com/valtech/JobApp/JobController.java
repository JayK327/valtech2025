package com.valtech.JobApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.service.annotation.GetExchange;

import com.valtech.JobApp.model.JobPost;
import com.valtech.JobApp.service.JobService;

@Controller
public class JobController {
	@Autowired
	private JobService service;
	@GetMapping({"/","home"})
	public String home() {
		return "home";
	}
	
	@GetMapping("addjob")
	public String addJob() {
		return "addjob";
	}
	
	@PostMapping("handleForm")
	public String handleJob(JobPost jobPost) {
		//jobPost:DTO(Data transfer object):They're getting transferred between different layers okay.
		service.addJob(jobPost);
		return "success";
	}
	
	@GetMapping("viewalljobs")
	public String viewJobs(Model m) {
		List<JobPost> jobs=service.getAllJobs();
		m.addAttribute("jobPosts",jobs);
		return "viewalljobs";
	}
}
