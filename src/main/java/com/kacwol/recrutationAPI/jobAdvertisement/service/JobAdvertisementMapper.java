package com.kacwol.recrutationAPI.jobAdvertisement.service;

import com.kacwol.recrutationAPI.jobAdvertisement.data.JobAdvertisement;
import com.kacwol.recrutationAPI.jobAdvertisement.data.JobAdvertisementCreateDto;
import com.kacwol.recrutationAPI.jobAdvertisement.data.JobAdvertisementReturnDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
public class JobAdvertisementMapper {

    public JobAdvertisement toEntity(JobAdvertisementCreateDto dto){
        return new JobAdvertisement(null,dto.getTitle(),dto.getDescription(),dto.getPlace(),LocalDateTime.now());
    }
    public JobAdvertisementCreateDto toCreateDto(JobAdvertisement entity){
        return new JobAdvertisementCreateDto(entity.getTitle(), entity.getDescription(), entity.getPlace());
    }
    public JobAdvertisementReturnDto toReturnDto(JobAdvertisement entity){
        return new JobAdvertisementReturnDto(entity.getTitle(), entity.getDescription(), entity.getPlace(), entity.getAddedDate());
    }
}
