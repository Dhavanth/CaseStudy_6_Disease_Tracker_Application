package org.example.diseasetrackerapplication.repositories;

import org.example.diseasetrackerapplication.models.Disease;
import org.example.diseasetrackerapplication.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

    Long countAllByIsCured(Boolean isCured);

    Optional<Person> findByPersonId(String personId);

    Long countAllByIsFatal(Boolean isFatal);

    Long countAllByDisease(Disease disease);

    Long countAllByDiseaseAndIsCured(Disease disease, Boolean isCured);

    Long countAllByDiseaseAndIsFatal(Disease disease, Boolean isFatal);
    Set<String> getAllCountryNames();

    Set<String> getAllProvinceNamesByCountryName(String countryName);


    Long countAllByDiseaseAndCountryName(Disease disease, String countryName);

    Long countAllByDiseaseAndCountryNameAndIsCured(Disease disease, String countryName, Boolean isCured);

    Long countAllByDiseaseAndCountryNameAndIsFatal(Disease disease, String countryName, Boolean isFatal);

    Long countAllByDiseaseAndCountryNameAndProvinceName(Disease disease, String countryName, String provinceName);

    Long countAllByDiseaseAndCountryNameAndProvinceNameAndIsCured(Disease disease, String countryName, String provinceName, Boolean isCured);

    Long countAllByDiseaseAndCountryNameAndProvinceNameAndIsFatal(Disease disease, String countryName, String provinceName, Boolean isFatal);

    List<Person> findAllByDisease(Disease disease);

    List<Person> findAllByDiseaseAndIsCured(Disease disease, Boolean isCured);

    List<Person> findAllByDiseaseAndIsFatal(Disease disease, Boolean isFatal);
}
