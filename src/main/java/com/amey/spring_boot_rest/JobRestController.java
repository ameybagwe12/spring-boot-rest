package com.amey.spring_boot_rest;

import com.amey.spring_boot_rest.model.JobPost;
import com.amey.spring_boot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @Controller
@RestController // OR ELSE USE REST CONTROLLER RATHER THAN RES-BODY ANNOTATION AND REMOVING COMPONENT
// CORS POLICY ANNOTATION
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    @Autowired
    private JobService service;

    // WILL ONLY RETURN JSON DATA
    @GetMapping(path = "jobPosts", produces = {"application/json"})
    // @ResponseBody // FOR SENDING RESPONSE BODY AND NOT RETURNING VIEW/PAGE
    public List<JobPost> getAllJobs() {
        return service.returnAllJobPosts();
    }

    // DYNAMIC VALUE PARAMS(URI)
    @GetMapping("/jobPost/{postId}")
    // Path Variable(TARGET VAR) (REQ PARAM)
    public JobPost getJob(@PathVariable("postId") int postId) {
        // System.out.println(service.returnAllJobPosts().get(postId-1));
        // ALTERNATE METHOD
        // return service.returnAllJobPosts().get(postId-1);
         return service.getJob(postId);
    }

    @PostMapping("/jobPost")
    // REQUEST BODY FOR POST REQUEST
    // RETURN FOR CONFIRMATION
    public JobPost addJob(@RequestBody JobPost jobPost) {
        service.addJobPost(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    // UPDATE REQUEST
    @PutMapping("/jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost) {
        service.updateJobPost(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    // DELETE REQUEST
    @DeleteMapping("/jobPost/{postId}")
    public String deleteJob(@PathVariable int postId) {
        service.deleteJobPost(postId);
        return "Deleted";
    }
}
