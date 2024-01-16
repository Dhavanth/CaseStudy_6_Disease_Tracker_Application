package org.example.diseasetrackerapplication.services;

import org.example.diseasetrackerapplication.exceptions.DiseaseNotFoundException;
import org.example.diseasetrackerapplication.exceptions.PersonNotFoundException;
import org.example.diseasetrackerapplication.models.Disease;
import org.example.diseasetrackerapplication.models.Person;
import org.example.diseasetrackerapplication.repositories.DiseaseRepository;
import org.example.diseasetrackerapplication.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DiseaseTrackerService {

    private final DiseaseRepository diseaseRepository;
    private final PersonRepository personRepository;

    @Autowired
    public DiseaseTrackerService(DiseaseRepository diseaseRepository,
                                 PersonRepository personRepository) {
        this.diseaseRepository = diseaseRepository;
        this.personRepository = personRepository;
    }

    public void registerDisease(String diseaseName,
                                String diseaseType,
                                String transmissibleStatus,
                                String transmissionType) {
        Disease disease = new Disease(diseaseName,
                diseaseType,
                transmissibleStatus,
                transmissionType);

        diseaseRepository.save(disease);
        System.out.println("Disease registered successfully.");
    }

    public void reportDisease(String diseaseName,
                              String personId,
                              String countryName,
                              String provinceName,
                              String cityName) {
        Optional<Disease> optionalDisease = diseaseRepository.findByName(diseaseName);
        if (optionalDisease.isPresent()) {
            Disease disease = optionalDisease.get();
            Person person = new Person();
            person.setDisease(disease);
            person.setPersonId(personId);
            person.setCountryName(countryName);
            person.setProvinceName(provinceName);
            person.setCityName(cityName);
            person.setIsCured(false);
            personRepository.save(person);
            System.out.println("Disease reported successfully.");
        } else {
            throw new DiseaseNotFoundException("Disease not found. Please add the disease to the repo.");
        }

    }

    public void cured(String diseaseName, String personId) {
        Optional<Person> optionalPerson = personRepository.findByPersonId(personId);
        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            person.setIsCured(true);
            personRepository.save(person);
            System.out.println("Cured registered successfully.");
        } else {
            throw new PersonNotFoundException("Invalid Person details");
        }
    }

    public void registerFatality(String diseaseName, String personId) {
        Optional<Person> optionalPerson = personRepository.findByPersonId(personId);
        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            person.setIsFatal(true);
            personRepository.save(person);
            System.out.println("Fatality registered successfully.");
        } else {
            throw new PersonNotFoundException("Invalid Person details");
        }

    }

    public void showWorldSummary() {
        System.out.println("World Summary");
        System.out.println("==============");
        long totalCases = personRepository.count();
        System.out.println("Total cases: " + totalCases);
        long curedCases = personRepository.countAllByIsCured(true);
        System.out.println("Total cured cases: " + curedCases);
        long fatalCases = personRepository.countAllByIsFatal(true);
        System.out.println("Total fatal cases: " + fatalCases);
        System.out.println("Total active cases: " + (totalCases - curedCases - fatalCases));
        System.out.println("==============");
    }

    public void showWorldSummaryByDisease() {
        System.out.println("World Summary by Disease");
        System.out.println("==============");
        List<Disease> diseases = diseaseRepository.findAll();
        for (Disease disease : diseases) {
            System.out.println("Disease: " + disease.getName());
            long totalCases = personRepository.countAllByDisease(disease);
            System.out.println("Total cases: " + totalCases);
            long curedCases = personRepository.countAllByDiseaseAndIsCured(disease, true);
            System.out.println("Total cured cases: " + curedCases);
            long fatalCases = personRepository.countAllByDiseaseAndIsFatal(disease, true);
            System.out.println("Total fatal cases: " + fatalCases);
            System.out.println("Total active cases: " + (totalCases - curedCases - fatalCases));
            System.out.println("==============");
        }

    }

    public void showCountrySummary(String diseaseName) {
        Set<String> countryNames = personRepository.getAllCountryNames();
        for (String countryName : countryNames) {
            System.out.println("Country: " + countryName);
            System.out.println("==============");
            Optional<Disease> optionalDisease = diseaseRepository.findByName(diseaseName);
            if (optionalDisease.isPresent()) {
                Disease disease = optionalDisease.get();
                long totalCases = personRepository.countAllByDiseaseAndCountryName(disease, countryName);
                System.out.println("Total cases: " + totalCases);
                long curedCases = personRepository.countAllByDiseaseAndCountryNameAndIsCured(disease, countryName, true);
                System.out.println("Total cured cases: " + curedCases);
                long fatalCases = personRepository.countAllByDiseaseAndCountryNameAndIsFatal(disease, countryName, true);
                System.out.println("Total fatal cases: " + fatalCases);
                System.out.println("Total active cases: " + (totalCases - curedCases - fatalCases));
                System.out.println("==============");
            } else {
                throw new DiseaseNotFoundException("Disease not found. Please add the disease to the repo.");
            }
        }
    }

    public void showProvinceSummary(String countryName, String diseaseName) {
        Set<String> provinceNames = personRepository.getAllProvinceNamesByCountryName(countryName);
        for (String provinceName : provinceNames) {
            System.out.println("Province: " + provinceName);
            System.out.println("==============");
            Optional<Disease> optionalDisease = diseaseRepository.findByName(diseaseName);
            if (optionalDisease.isPresent()) {
                Disease disease = optionalDisease.get();
                long totalCases = personRepository.countAllByDiseaseAndCountryNameAndProvinceName(disease, countryName, provinceName);
                System.out.println("Total cases: " + totalCases);
                long curedCases = personRepository.countAllByDiseaseAndCountryNameAndProvinceNameAndIsCured(disease, countryName, provinceName, true);
                System.out.println("Total cured cases: " + curedCases);
                long fatalCases = personRepository.countAllByDiseaseAndCountryNameAndProvinceNameAndIsFatal(disease, countryName, provinceName, true);
                System.out.println("Total fatal cases: " + fatalCases);
                System.out.println("Total active cases: " + (totalCases - curedCases - fatalCases));
                System.out.println("==============");
            } else {
                throw new DiseaseNotFoundException("Disease not found. Please add the disease to the repo.");
            }
        }

    }

    public void showDetailsToAdmin() {
        Optional<List<Disease>> optionalDiseases = Optional.of(diseaseRepository.findAll());
        List<Disease> diseases = optionalDiseases.get();
        for (Disease disease : diseases) {
            System.out.println("Disease: " + disease.getName());
            System.out.println("==============");
            //Total Persons who reported the Disease
            List<Person> persons = personRepository.findAllByDisease(disease);
            int totalCount = persons.size();
            System.out.println("Total cases: " + totalCount);
            System.out.println(persons.toString());

            //Total Persons who are cured
            List<Person> curedPersons = personRepository.findAllByDiseaseAndIsCured(disease, true);
            int curedCount = curedPersons.size();
            System.out.println("Total cured cases: " + curedCount);
            System.out.println(curedPersons.toString());

            //Total Persons who are fatal
            List<Person> fatalPersons = personRepository.findAllByDiseaseAndIsFatal(disease, true);
            int fatalCount = fatalPersons.size();
            System.out.println("Total fatal cases: " + fatalCount);
            System.out.println(fatalPersons.toString());

            //Total Persons who are active
            int activeCount = totalCount - curedCount - fatalCount;
            System.out.println("Total active cases: " + activeCount);
            System.out.println("==============");

        }

    }

}
