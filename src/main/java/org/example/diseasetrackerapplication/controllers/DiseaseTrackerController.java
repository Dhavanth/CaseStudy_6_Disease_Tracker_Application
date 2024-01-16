package org.example.diseasetrackerapplication.controllers;

import org.example.diseasetrackerapplication.models.Person;
import org.example.diseasetrackerapplication.repositories.DiseaseRepository;
import org.example.diseasetrackerapplication.repositories.PersonRepository;
import org.example.diseasetrackerapplication.services.DiseaseTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DiseaseTrackerController {

    //@Autowired
    private final DiseaseTrackerService diseaseTrackerService;

    @Autowired
    public DiseaseTrackerController(DiseaseTrackerService diseaseTrackerService) {
        this.diseaseTrackerService = diseaseTrackerService;
    }

    public void registerDisease(String diseaseName,
                                String diseaseType,
                                String transmissibleStatus,
                                String transmissionType){
        diseaseTrackerService.registerDisease(diseaseName,
                diseaseType,
                transmissibleStatus,
                transmissionType);
    }

    public void reportDisease(String diseaseName,
                              String personId,
                              String countryName,
                              String provinceName,
                              String cityName){
        diseaseTrackerService.reportDisease(diseaseName,
                personId,
                countryName,
                provinceName,
                cityName);
    }

    public void cured(String diseaseName, String personId){
        diseaseTrackerService.cured(diseaseName, personId);
    }

    public void registerFatality(String diseaseName, String personId){
        diseaseTrackerService.registerFatality(diseaseName, personId);
    }

    public void showWorldSummary(){
        diseaseTrackerService.showWorldSummary();
    }

    public void showWorldSummaryByDisease(){
        diseaseTrackerService.showWorldSummaryByDisease();
    }

    public void showCountrySummary(String diseaseName){
        diseaseTrackerService.showCountrySummary(diseaseName);
    }

    public void showProvinceSummary(String countryName, String diseaseName){
        diseaseTrackerService.showProvinceSummary(countryName, diseaseName);
    }

    public void showDetailsToAdmin(){
        diseaseTrackerService.showDetailsToAdmin();
    }
}
