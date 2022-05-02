package com.kacwol.recrutationAPI.jobAdvertisement.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class JobAdvertisementCreateDto {

    private String title;

    private String description;

    private String place;

}
