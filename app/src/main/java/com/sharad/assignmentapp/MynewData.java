package com.sharad.assignmentapp;

import java.io.Serializable;

public class MynewData implements Serializable {

    private String countryName;
    private String countryRegion;
    private String countrySubRegion;
    private String countryCapital;
    private String countryPopulation;
    private String countryBorders;
    private String countryLanguage;
    private String countryFlag;

    public MynewData(String countryName, String countryRegion, String countrySubRegion, String countryCapital, String countryPopulation, String countryBorders, String countryLanguage, String countryFlag) {
        this.countryName = countryName;
        this.countryRegion = countryRegion;
        this.countrySubRegion = countrySubRegion;
        this.countryCapital = countryCapital;
        this.countryPopulation = countryPopulation;
        this.countryBorders = countryBorders;
        this.countryLanguage = countryLanguage;
        this.countryFlag = countryFlag;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCountryRegion() {
        return countryRegion;
    }

    public String getCountrySubRegion() {
        return countrySubRegion;
    }

    public String getCountryCapital() {
        return countryCapital;
    }

    public String getCountryPopulation() {
        return countryPopulation;
    }

    public String getCountryBorders() {
        return countryBorders;
    }

    public String getCountryLanguage() {
        return countryLanguage;
    }

    public String getCountryFlag() {
        return countryFlag;
    }
}
