/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.jakarkaeeudbl.bienvenue1;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("lieuBean")
@SessionScoped
public class LieuBean implements Serializable {
    private Lieu lieu = new Lieu();
    private List<Lieu> listeLieux = new ArrayList<>();

    public Lieu getLieu() {
        return lieu;
    }

    public List<Lieu> getListeLieux() {
        return listeLieux;
    }

    public void ajouterLieu() {
        // Vérification que tous les champs sont bien remplis
        if (lieu.getNom() != null && !lieu.getNom().isEmpty()) {
            listeLieux.add(new Lieu(lieu.getNom(), lieu.getDescription(), lieu.getLatitude(), lieu.getLongitude()));
            lieu = new Lieu(); // Réinitialisation après l'ajout
        }
    }
}


