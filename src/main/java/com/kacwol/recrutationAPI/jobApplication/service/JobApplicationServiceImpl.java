package com.kacwol.recrutationAPI.jobApplication.service;

import com.kacwol.recrutationAPI.jobAdvertisement.data.JobAdvertisement;
import com.kacwol.recrutationAPI.jobAdvertisement.service.JobAdvertisementServiceImpl;
import com.kacwol.recrutationAPI.jobApplication.data.*;
import com.kacwol.recrutationAPI.user.data.User;
import com.kacwol.recrutationAPI.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {

    private final JobApplicationRepo applicationRepo;
    private final JobApplicationMapper mapper;
    private final JobAdvertisementServiceImpl advertisementService;
    private final UserServiceImpl userService;

    @Autowired
    public JobApplicationServiceImpl(JobApplicationRepo applicationRepo, JobApplicationMapper mapper, JobAdvertisementServiceImpl advertisementService, UserServiceImpl userService) {
        this.applicationRepo = applicationRepo;
        this.mapper = mapper;
        this.advertisementService = advertisementService;
        this.userService = userService;
    }

    @Override
    public void sendApplication(Long advertId, JobApplicationCreateDto dto, Authentication authentication) {
        User user = userService.getUserByName(authentication.getName());
        JobAdvertisement advertisement =advertisementService.getAdvertisementEntityById(advertId);
        JobApplication jobApplication = mapper.toEntity(dto,user,advertisement);
        applicationRepo.save(jobApplication);
    }

    @Override
    public void changeApplicationState(Long id, JobApplicationState applicationState) {
        JobApplication application = applicationRepo.findById(id).orElseThrow(()-> new JobApplicationNotFoundException());
        application.changeApplicationState(applicationState);
        applicationRepo.save(application);
    }

    @Override
    public JobApplicationDto getApplicationById(Long id) {
        JobApplication application = applicationRepo.findById(id).orElseThrow(()-> new JobApplicationNotFoundException());
        return mapper.toDto(application);
    }

    @Override
    public List<JobApplication> getAllJobApplicationsByAdvertisement(Long id) {
        return applicationRepo.findAllByJobAdvertisementId(id);
    }

    @Override
    public List<JobApplication> getAllJobApplicationsByUser(String name) {
        User user = userService.getUserByName(name);
        return applicationRepo.findAllByUserId(user.getId());
    }

    @Override
    public JobApplicationDto getApplicationByIdAndUserId(Long id, Authentication authentication) {
        User user = userService.getUserByName(authentication.getName());
        JobApplication application = applicationRepo.findByIdAndUserId(id, user.getId()).orElseThrow(() -> new JobApplicationNotFoundException());
        return mapper.toDto(application);
    }
}
