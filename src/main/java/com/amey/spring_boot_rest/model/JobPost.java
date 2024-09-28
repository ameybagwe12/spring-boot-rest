package com.amey.spring_boot_rest.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data // HENCE NO NEED TO CREATE GETTERS AND SETTERS
@AllArgsConstructor
@Component
@NoArgsConstructor // NO NEED TO CREATE CONSTRUCTOR
@Entity
public class JobPost {
    @Id
    private int postId;
    private int reqExperience;
    private String postProfile;
    private String postDesc;
    private List<String> postTechStack;

    public int getPostId() {
        return postId;
    }

    public List<String> getPostTechStack() {
        return postTechStack;
    }

    public JobPost(int postId, String postDesc, String postProfile, int reqExperience, List<String> postTechStack) {
        this.postId = postId;
        this.postTechStack = postTechStack;
        this.postDesc = postDesc;
        this.postProfile = postProfile;
        this.reqExperience = reqExperience;
    }

    public void setPostTechStack(List<String> postTechStack) {
        this.postTechStack = postTechStack;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getReqExperience() {
        return reqExperience;
    }

    public void setReqExperience(int reqExperience) {
        this.reqExperience = reqExperience;
    }

    public String getPostProfile() {
        return postProfile;
    }

    public void setPostProfile(String postProfile) {
        this.postProfile = postProfile;
    }

    public String getPostDesc() {
        return postDesc;
    }

    public void setPostDesc(String postDesc) {
        this.postDesc = postDesc;
    }
}
