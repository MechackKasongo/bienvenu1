/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jakarkaeeudbl.bienvenue1;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.IOException;

//import jakarta.faces.context.FacesContext;
/**
 *
 * @author mechack-kasongo
 */
@Named("NaviggationController")
@RequestScoped
public class NavigationBean {
    public void voirApropos(){
        try {
           FacesContext.getCurrentInstance().getExternalContext().redirect("a_propos.xhtml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
