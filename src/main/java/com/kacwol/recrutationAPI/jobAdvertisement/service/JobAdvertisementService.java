package com.kacwol.recrutationAPI.jobAdvertisement.service;

import com.kacwol.recrutationAPI.jobAdvertisement.data.JobAdvertisement;
import com.kacwol.recrutationAPI.jobAdvertisement.data.JobAdvertisementCreateDto;
import com.kacwol.recrutationAPI.jobAdvertisement.data.JobAdvertisementReturnDto;

import java.util.List;

public interface JobAdvertisementService {

    void addAdvertisement(JobAdvertisementCreateDto jobAdvertisementDto);

    void deleteAdvertisementById(Long id);

    JobAdvertisementReturnDto getAdvertisementById(Long id);

    List<JobAdvertisement> getAllAdvertisements();

    List<JobAdvertisement> getAllAdvertisementsByPlace(String place);

    JobAdvertisement getAdvertisementEntityById(Long id);
}
