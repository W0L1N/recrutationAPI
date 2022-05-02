package com.kacwol.recrutationAPI.jobApplication.service;

import com.kacwol.recrutationAPI.jobApplication.data.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JobApplicationRepo extends JpaRepository<JobApplication,Long> {
    List<JobApplication> findAllByJobAdvertisementId(Long id);
    List<JobApplication> findAllByUserId(Long id);
    Optional<JobApplication> findByIdAndUserId(Long id,Long userId);
}
