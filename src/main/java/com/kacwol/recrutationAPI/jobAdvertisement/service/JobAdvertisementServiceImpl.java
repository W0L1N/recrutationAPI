package com.kacwol.recrutationAPI.jobAdvertisement.service;

import com.kacwol.recrutationAPI.jobAdvertisement.data.JobAdvertisement;
import com.kacwol.recrutationAPI.jobAdvertisement.data.JobAdvertisementCreateDto;
import com.kacwol.recrutationAPI.jobAdvertisement.data.JobAdvertisementNotFoundException;
import com.kacwol.recrutationAPI.jobAdvertisement.data.JobAdvertisementReturnDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertisementServiceImpl implements JobAdvertisementService {

    private final JobAdvertisementRepo jobAdvertisementRepo;
    private final JobAdvertisementMapper mapper;

    @Autowired
    public JobAdvertisementServiceImpl(JobAdvertisementRepo jobAdvertisementRepo, JobAdvertisementMapper mapper) {
        this.jobAdvertisementRepo = jobAdvertisementRepo;
        this.mapper = mapper;
    }

    @Override
    public void addAdvertisement(JobAdvertisementCreateDto jobAdvertisementDto) {
        JobAdvertisement jobAdvertisement = mapper.toEntity(jobAdvertisementDto);
        jobAdvertisementRepo.save(jobAdvertisement);
    }

    @Override
    public JobAdvertisementReturnDto getAdvertisementById(Long id) {
        JobAdvertisement entity = jobAdvertisementRepo.findById(id).orElseThrow(JobAdvertisementNotFoundException::new);
        return mapper.toReturnDto(entity);
    }

    @Override
    public void deleteAdvertisementById(Long id) {
        jobAdvertisementRepo.deleteById(id);
    }

    @Override
    public List<JobAdvertisement> getAllAdvertisements() {
        return jobAdvertisementRepo.findAll();
    }

    @Override
    public List<JobAdvertisement> getAllAdvertisementsByPlace(String place) {
        return jobAdvertisementRepo.findAllByPlace(place);
    }

    @Override
    public JobAdvertisement getAdvertisementEntityById(Long id) {
        return jobAdvertisementRepo.findById(id).orElseThrow(JobAdvertisementNotFoundException::new);
    }
}
