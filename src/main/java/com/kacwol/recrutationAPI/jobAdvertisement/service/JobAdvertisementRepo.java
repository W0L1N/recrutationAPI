package com.kacwol.recrutationAPI.jobAdvertisement.service;

import com.kacwol.recrutationAPI.jobAdvertisement.data.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobAdvertisementRepo extends JpaRepository<JobAdvertisement,Long> {
    List<JobAdvertisement> findAllByPlace(String place);
}
