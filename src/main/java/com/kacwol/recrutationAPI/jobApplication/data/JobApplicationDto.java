package com.kacwol.recrutationAPI.jobApplication.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class JobApplicationDto {

    private String name;

    private String lastName;

    private String address;

    private String phoneNumber;

    private String description;

    private Long jobAdvertisementId;

    public JobApplicationDto(JobApplication jobApplication) {
        this.name = jobApplication.getName();
        this.lastName = jobApplication.getLastName();
        this.address = jobApplication.getAddress();
        this.phoneNumber = jobApplication.getAddress();
        this.description = jobApplication.getDescription();
        this.jobAdvertisementId = jobApplication.getJobAdvertisement().getId();
    }
}
