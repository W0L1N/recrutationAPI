package com.kacwol.recrutationAPI.jobApplication.service;

import com.kacwol.recrutationAPI.jobAdvertisement.data.JobAdvertisement;
import com.kacwol.recrutationAPI.jobApplication.data.JobApplication;
import com.kacwol.recrutationAPI.jobApplication.data.JobApplicationCreateDto;
import com.kacwol.recrutationAPI.jobApplication.data.JobApplicationDto;
import com.kacwol.recrutationAPI.user.data.User;
import org.springframework.stereotype.Component;

@Component
public class JobApplicationMapper {

    public JobApplication toEntity(JobApplicationCreateDto dto, User user, JobAdvertisement jobAdvertisement){
        return new JobApplication(dto,user,jobAdvertisement);
    }
    public JobApplicationDto toDto(JobApplication jobApplication){
        return new JobApplicationDto(jobApplication);
    }
}
