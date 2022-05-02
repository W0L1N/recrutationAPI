package com.kacwol.recrutationAPI.jobAdvertisement;

import com.kacwol.recrutationAPI.jobAdvertisement.data.JobAdvertisement;
import com.kacwol.recrutationAPI.jobAdvertisement.data.JobAdvertisementCreateDto;
import com.kacwol.recrutationAPI.jobAdvertisement.data.JobAdvertisementReturnDto;
import com.kacwol.recrutationAPI.jobAdvertisement.service.JobAdvertisementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/advert")
@Secured({"ROLE_ADMIN","ROLE_HR"})
public class JobAdvertisementController {

    private final JobAdvertisementServiceImpl service;

    @Autowired
    public JobAdvertisementController(JobAdvertisementServiceImpl service) {
        this.service = service;
    }


    @GetMapping("{id}")
    @Secured({"ROLE_USER"})
    public JobAdvertisementReturnDto getAdvertisementById(@PathVariable Long id){
        return service.getAdvertisementById(id);
    }

    @GetMapping("/byplace")
    @Secured({"ROLE_USER"})
    public List<JobAdvertisement> getAllAdvertisementsByPlace(@RequestBody String place){
        return service.getAllAdvertisementsByPlace(place);
    }

    @GetMapping
    @Secured({"ROLE_USER"})
    public List<JobAdvertisement> getAllAdvertisements(){
        return service.getAllAdvertisements();
    }

    @PostMapping
    public void addAdvertisement(@RequestBody JobAdvertisementCreateDto dto){
        service.addAdvertisement(dto);
    }

    @DeleteMapping
    public void deleteAdvertisementById(@PathVariable Long id){
        service.deleteAdvertisementById(id);
    }
}

