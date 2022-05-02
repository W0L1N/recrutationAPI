package com.kacwol.recrutationAPI.jobApplication;

import com.kacwol.recrutationAPI.jobApplication.data.JobApplication;
import com.kacwol.recrutationAPI.jobApplication.data.JobApplicationCreateDto;
import com.kacwol.recrutationAPI.jobApplication.data.JobApplicationDto;
import com.kacwol.recrutationAPI.jobApplication.service.JobApplicationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
@Secured("ROLE_USER")
public class UserJobApplicationController {

    private JobApplicationServiceImpl jobApplicationService;

    @Autowired
    public UserJobApplicationController(JobApplicationServiceImpl jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }

    @GetMapping
    public List<JobApplication> getAllApplications(Authentication authentication){
        return jobApplicationService.getAllJobApplicationsByUser(authentication.getName());
    }
    @PostMapping
    public void sendApplication(@RequestParam Long advertId, @RequestBody JobApplicationCreateDto jobApplicationCreateDto,Authentication authentication){
        jobApplicationService.sendApplication(advertId,jobApplicationCreateDto,authentication);
    }
    @GetMapping("{id}")
    public JobApplicationDto getApplication(@PathVariable Long id,Authentication authentication){
        return jobApplicationService.getApplicationByIdAndUserId(id, authentication);
    }

}
