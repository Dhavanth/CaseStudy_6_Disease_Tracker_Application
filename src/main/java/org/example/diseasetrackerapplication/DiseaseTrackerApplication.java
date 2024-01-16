package org.example.diseasetrackerapplication;

import org.example.diseasetrackerapplication.controllers.DiseaseTrackerController;
import org.example.diseasetrackerapplication.repositories.DiseaseRepository;
import org.example.diseasetrackerapplication.repositories.PersonRepository;
import org.example.diseasetrackerapplication.services.DiseaseTrackerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiseaseTrackerApplication {

    static DiseaseRepository diseaseRepository;
    static PersonRepository personRepository;

    DiseaseTrackerService diseaseTrackerService;

    public static void main(String[] args) {

        SpringApplication.run(DiseaseTrackerApplication.class, args);

//        DiseaseTrackerService diseaseTrackerService = new DiseaseTrackerService(diseaseRepository, personRepository);
//
//
//        DiseaseTrackerController diseaseTrackerController = new DiseaseTrackerController(diseaseTrackerService,
//                diseaseRepository,
//                personRepository);
//        diseaseTrackerController.registerDisease("COVID-19", "Virus", "Transmissible", "Airborne");
//        diseaseTrackerController.registerDisease("Spanish-Flu", "Virus", "Transmissible", "Airborne");
//        diseaseTrackerController.registerDisease("TYPHOID", "Bacterial", "Transmissible", "Waterborne");
//        diseaseTrackerController.registerDisease("MALARIA", "Parasitic", "Transmissible", "Airborne");
//
//        diseaseTrackerController.reportDisease("COVID-19", "P1", "India", "Maharashtra", "Pune");
//        diseaseTrackerController.reportDisease("COVID-19", "P2", "India", "Maharashtra", "Pune");
//        diseaseTrackerController.reportDisease("COVID-19", "P3", "India", "Gujarat", "Vadodara");
//        diseaseTrackerController.reportDisease("COVID-19", "P4", "China", "Hubei", "Wuhan");
//        diseaseTrackerController.reportDisease("COVID-19", "P5", "China", "Hubei", "Wuhan");
//        diseaseTrackerController.reportDisease("COVID-19", "P6", "China", "Hubei", "Wuhan");
//        diseaseTrackerController.reportDisease("Spanish-Flu", "P7", "China", "Hunan", "Chang sa");
//        diseaseTrackerController.reportDisease("Spanish-Flu", "P8", "China", "Hunan", "Chang sa");
//        diseaseTrackerController.reportDisease("Spanish-Flu", "P9", "USA", "California", "LosAngeles");
//        diseaseTrackerController.reportDisease("TYPHOID", "P10", "USA", "California", "SanDiego");
//
//        diseaseTrackerController.showWorldSummary();
//
//        diseaseTrackerController.showWorldSummaryByDisease();
//
//        diseaseTrackerController.showCountrySummary("COVID-19");
//        diseaseTrackerController.showCountrySummary("Spanish-Flu");
//        diseaseTrackerController.showCountrySummary("TYPHOID");
//
//        diseaseTrackerController.cured("COVID-19", "P3");
//
//        diseaseTrackerController.showCountrySummary("COVID-19");
//
//        diseaseTrackerController.registerFatality("COVID-19", "P5");
//
//        diseaseTrackerController.showProvinceSummary("India", "COVID-19");
//        diseaseTrackerController.showProvinceSummary("China", "COVID-19");
//        diseaseTrackerController.showProvinceSummary("USA", "TYPHOID");
//
//        diseaseTrackerController.showDetailsToAdmin();



    }

}
