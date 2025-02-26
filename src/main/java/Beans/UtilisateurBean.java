/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

import com.mycompany.jacartavisa.business.UtilisateurEntrepriseBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 *
 * @author HP
 */
@Named(value="utilisateurBean")
@RequestScoped
public class UtilisateurBean {
    
    @NotBlank(message = "Le nom d'utilisateur est obligatoire")
    @Size(min = 3, max = 50, message = "Le nom d'utilisateur doit avoir entre 3 et"
            + " 50 caractères")
    private String username;
    
    
    @NotBlank(message = "L'email est obligatoire")
    @Email(message = "L'email doit être valide")
    private String email;
    
    @NotBlank(message = "Le mot de passe est obligatoire")
    @Size(min = 8, message = "Le mot de passe doit contenir au moins 8 caractères")
     @Pattern(
        regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,}$",
        message = "Le mot de passe doit contenir au moins une majuscule, un chiffre et un caractère spécial"
    )
    private String password;
    
    @NotBlank(message = "Veuillez confirmer votre mot de passe")
    private String confirmPassword;

    
      

    private String description;
    
    
    @Inject
    private UtilisateurEntrepriseBean utilisateurEntrepriseBean;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    
    
    
    public void ajouterUtilisateur() {
        FacesContext context = FacesContext.getCurrentInstance();
        
        // Vérifier si les mots de passe correspondent
        if (!password.equals(confirmPassword)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Les mots de passe ne correspondent pas", null));
            return;
        }
        if(utilisateurEntrepriseBean.TrouverUtilisateurParUsername(username)== null && 
                utilisateurEntrepriseBean.trouverUtilisateurParEmail(email)== null ){
            
            utilisateurEntrepriseBean.ajouterUtilisateurEntreprise(username, email, password, description);
             // Ajout du message de succès si le mot de passe respecte les critères
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Utilisateur ajouté avec succès", null));
        }else{
             // Ajout du message de succès si le mot de passe respecte les critères
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Utilisateur existe déjà", null));
        }
        
        
        
        
         System.out.println("Utilisateur ajouté : " + username + " - " + email);
       
        // Réinitialisation des champs
        username = "";
        email = "";
        password = "";
        description = "";
    
    }
}
