package com.amey.spring_boot_rest.service;
import com.amey.spring_boot_rest.model.JobPost;
import com.amey.spring_boot_rest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
	@Autowired
	public JobRepo repo;
	
	
	
	//method to return all JobPosts
	public List<JobPost> returnAllJobPosts() {
		return repo.returnAllJobPosts();

		
	}
	
	
	
	

	// ***************************************************************************


	
	
	
	// method to add a jobPost
	public void addJobPost(JobPost jobPost) {
		 repo.addJobPost(jobPost);
	
	}


	public JobPost getJob(int postId) {
		return repo.getJob(postId);
	}

	public void updateJobPost(JobPost jobPost) {
		repo.updateJob(jobPost);
	}

	public void deleteJobPost(int postId) {
		repo.deleteJob(postId);
	}
}
