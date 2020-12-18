package com.example.demo;

import java.util.LinkedHashMap;

public class Student {

    private String firstName;
    private String lastName;
    private LinkedHashMap<String,String> country;
    private String selectedCountry;
    private String favoriteLanguage;
    private String OS[];
    public String getSelectedCountry() {
        return selectedCountry;
    }

    public void setSelectedCountry(String selectedCountry) {
        this.selectedCountry = selectedCountry;
    }


    public Student(){

        country = new LinkedHashMap<>();

        country.put("BR","Brazil");
        country.put("FR","France");
        country.put("IR","IRAN");
        country.put("UAS","AMERICA");
        country.put("DE","Germany");


    }

    public LinkedHashMap<String, String> getCountry() {
        return country;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public String[] getOS() {
        return OS;
    }

    public void setOS(String[] OS) {
        this.OS = OS;
    }
}
