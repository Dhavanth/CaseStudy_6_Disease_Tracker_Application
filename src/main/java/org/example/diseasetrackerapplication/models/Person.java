package org.example.diseasetrackerapplication.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Person extends BaseModel{

    @ManyToOne
    @JoinColumn(name = "disease_id")
    private Disease disease;
    private String personId;
    private String countryName;
    private String provinceName;
    private String cityName;
    private Boolean isCured;
    private Boolean isFatal;

    Person(Disease disease, String personId,
                  String countryName, String provinceName,
                    String cityName, Boolean isCured) {
        this.disease = disease;
        this.personId = personId;
        this.countryName = countryName;
        this.provinceName = provinceName;
        this.cityName = cityName;

    }

    public Person() {

    }
}
