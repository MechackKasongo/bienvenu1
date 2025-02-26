package Beans;

import entities.Utilisateur;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import services.UtilisateurService;

@Named
@SessionScoped
public class ProfilBean implements Serializable {

    private Utilisateur utilisateur;
    private String newPassword;

    @EJB
    private UtilisateurService utilisateurService;

    @PostConstruct
    public void init() {
        // Simuler l'utilisateur connecté (normalement récupéré depuis la session)
        utilisateur = utilisateurService.getUtilisateurConnecte();
    }

    public void modifierProfil() {
        if (utilisateur != null) {
            if (newPassword != null && !newPassword.isEmpty()) {
                utilisateur.setPassword(hashPassword(newPassword)); // Hacher le mot de passe
            }
            utilisateurService.mettreAJourUtilisateur(utilisateur);
            newPassword = null; // Réinitialiser le champ après modification
        }
    }

    public String deconnecter() {
        utilisateur = null; // Supprimer l'utilisateur de la session
        return "login?faces-redirect=true"; // Rediriger vers la page de connexion
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Getters et Setters
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
