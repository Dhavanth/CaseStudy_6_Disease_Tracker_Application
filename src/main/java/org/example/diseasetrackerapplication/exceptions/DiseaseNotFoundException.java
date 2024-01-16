package org.example.diseasetrackerapplication.exceptions;

public class DiseaseNotFoundException extends RuntimeException{
    public DiseaseNotFoundException(String message) {
        super(message);
    }
}
