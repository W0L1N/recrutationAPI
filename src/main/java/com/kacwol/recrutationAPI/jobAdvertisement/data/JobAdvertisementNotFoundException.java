package com.kacwol.recrutationAPI.jobAdvertisement.data;

public class JobAdvertisementNotFoundException extends RuntimeException{

    public JobAdvertisementNotFoundException() {
        super("Advertisement not found.");
    }
}
