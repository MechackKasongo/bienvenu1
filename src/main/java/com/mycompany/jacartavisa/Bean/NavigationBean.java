/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jacartavisa.Bean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.IOException;

/**
 *
 * @author Orman
 */
@Named(value = "navigationController")
@RequestScoped
public class NavigationBean {
    
    public void ajouterLieu(){
        try{ 
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("lieu.xhtml");
        }catch (IOException e){

            e.printStackTrace();
        }
    }
    public void voirApropos(){
            try{ 
                FacesContext.getCurrentInstance().getExternalContext()
                        .redirect("pages/a_propos.xhtml");
            }catch (IOException e){
                
                e.printStackTrace();
        }
    }
}
