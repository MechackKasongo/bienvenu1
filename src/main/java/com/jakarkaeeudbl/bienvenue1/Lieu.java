/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jakarkaeeudbl.bienvenue1;
import java.io.Serializable;
/**
 *
 * @author mechack-kasongo
 */


public class Lieu implements Serializable {
    private String nom;
    private String description;
    private double latitude;
    private double longitude;

    // Constructeurs
    public Lieu() {}

    public Lieu(String nom, String description, double latitude, double longitude) {
        this.nom = nom;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getters et Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
