package com.kacwol.recrutationAPI.jobApplication.service;

import com.kacwol.recrutationAPI.jobApplication.data.JobApplication;
import com.kacwol.recrutationAPI.jobApplication.data.JobApplicationCreateDto;
import com.kacwol.recrutationAPI.jobApplication.data.JobApplicationDto;
import com.kacwol.recrutationAPI.jobApplication.data.JobApplicationState;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface JobApplicationService {
    void changeApplicationState(Long id,JobApplicationState applicationState);
    void sendApplication(Long advertId, JobApplicationCreateDto dto, Authentication authentication);
    JobApplicationDto getApplicationById(Long id);
    List<JobApplication> getAllJobApplicationsByAdvertisement(Long id);
    List<JobApplication> getAllJobApplicationsByUser(String name);
    JobApplicationDto getApplicationByIdAndUserId(Long id,Authentication authentication);
}
