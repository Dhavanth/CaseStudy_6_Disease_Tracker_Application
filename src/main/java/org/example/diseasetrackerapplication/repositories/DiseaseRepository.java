package org.example.diseasetrackerapplication.repositories;

import org.example.diseasetrackerapplication.models.Disease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DiseaseRepository extends JpaRepository<Disease, Long> {

    Optional<Disease> findByName(String diseaseName);
}
