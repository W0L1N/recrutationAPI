package com.kacwol.recrutationAPI.jobApplication.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class JobApplicationCreateDto {
    private String name;

    private String lastName;

    private String address;

    private String phoneNumber;

    private String description;
}
