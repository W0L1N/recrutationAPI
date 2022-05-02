package com.kacwol.recrutationAPI.jobApplication.data;

public class JobApplicationNotFoundException extends RuntimeException{

    public JobApplicationNotFoundException() {
        super("Job application not found.");
    }
}
