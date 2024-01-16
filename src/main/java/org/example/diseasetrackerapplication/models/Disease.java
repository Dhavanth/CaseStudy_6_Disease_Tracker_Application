package org.example.diseasetrackerapplication.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Disease extends BaseModel {
    private String name;
    private String diseaseType;
    private String transmissibleStatus;
    private String transmissionType;


    public Disease(String name,
                   String diseaseType,
                   String transmissibleStatus,
                   String transmissionType
                   ) {
        this.name = name;
        this.diseaseType = diseaseType;
        this.transmissibleStatus = transmissibleStatus;
        this.transmissionType = transmissionType;

    }

    public Disease() {

    }
}
