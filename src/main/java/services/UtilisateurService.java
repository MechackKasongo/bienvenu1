package services;

import entities.Utilisateur;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class UtilisateurService {

    @PersistenceContext
    private EntityManager em;

    public Utilisateur getUtilisateurConnecte() {
        // Normalement, récupérer l'utilisateur depuis la session
        return em.find(Utilisateur.class, 1L); // Simuler un utilisateur avec ID=1
    }

    public void mettreAJourUtilisateur(Utilisateur utilisateur) {
        em.merge(utilisateur);
    }
}
