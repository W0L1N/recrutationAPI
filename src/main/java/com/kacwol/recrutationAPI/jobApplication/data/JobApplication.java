package com.kacwol.recrutationAPI.jobApplication.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kacwol.recrutationAPI.jobAdvertisement.data.JobAdvertisement;
import com.kacwol.recrutationAPI.user.data.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastName;

    private String description;

    private String address;

    private String phoneNumber;

    private JobApplicationState applicationState;

    @ManyToOne
    @JsonIgnore
    private User user;

    @ManyToOne
    private JobAdvertisement jobAdvertisement;

    public JobApplication(JobApplicationCreateDto dto,User user,JobAdvertisement jobAdvertisement){
        this.name = dto.getName();
        this.lastName = dto.getLastName();
        this.description = dto.getDescription();
        this.address = dto.getAddress();
        this.phoneNumber = dto.getPhoneNumber();
        this.applicationState = JobApplicationState.UNCHECKED;
        this.user = user;
        this.jobAdvertisement=jobAdvertisement;
    }

    public void changeApplicationState(JobApplicationState applicationState){
        this.applicationState = applicationState;
    }

}
