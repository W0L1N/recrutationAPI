package com.kacwol.recrutationAPI.jobApplication;

import com.kacwol.recrutationAPI.jobApplication.data.JobApplication;
import com.kacwol.recrutationAPI.jobApplication.data.JobApplicationDto;
import com.kacwol.recrutationAPI.jobApplication.data.JobApplicationState;
import com.kacwol.recrutationAPI.jobApplication.service.JobApplicationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobApplication")
@Secured({"ROLE_ADMIN","ROLE_HR"})
public class JobApplicationController {

    private JobApplicationServiceImpl jobApplicationService;

    @Autowired
    public JobApplicationController(JobApplicationServiceImpl jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }

    @GetMapping("{id}")
    public JobApplicationDto getJobApplicationById(@PathVariable Long id){
        return jobApplicationService.getApplicationById(id);
    }

    @GetMapping
    public List<JobApplication> getAllApplications(@RequestParam Long advertId){
        return jobApplicationService.getAllJobApplicationsByAdvertisement(advertId);
    }

    @PatchMapping
    public void changeApplicationState(@RequestParam Long id,@RequestParam JobApplicationState jobApplicationState){
        jobApplicationService.changeApplicationState(id,jobApplicationState);
    }
}
