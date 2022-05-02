package com.kacwol.recrutationAPI.jobAdvertisement.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class JobAdvertisementReturnDto {

    private String title;

    private String description;

    private String place;

    private LocalDateTime addedDate;
}
