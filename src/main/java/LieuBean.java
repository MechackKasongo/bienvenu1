import com.mycompany.jacartavisa.business.LieuEntrepriseBean;
import entities.Lieu;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named(value = "lieuBean")
@RequestScoped
public class LieuBean implements Serializable{
    
    private String nom;
    private String description;
    private double longitude;
    private double latitude;
    private List<Lieu> lieux = new ArrayList<>();

    @Inject
    private LieuEntrepriseBean lieuEntrepriseBean;
    
    private Lieu lieu;

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public List<Lieu> getLieux() { return lieuEntrepriseBean.listerTousLesLieux(); }

    public void ajouterLieu() {
        if (nom != null && !nom.isEmpty() && description != null && !description.isEmpty()) {
            lieuEntrepriseBean.ajouterLieuEntreprise(nom, description, latitude, longitude);
        }
    }
        public void modifierLieu() {
        if (lieu != null) {
            lieuEntrepriseBean.modifierLieu(lieu);
            resetFields();
        }
    }

    public void supprimerLieu(Lieu lieu) {
        if (lieu != null) {
            lieuEntrepriseBean.supprimerLieu(lieu.getId());
        }
    }
    
    private void resetFields() {
        nom = null;
        description = null;
        latitude = 0;
        longitude = 0;
        lieu = null; // Réinitialiser le lieu
    }
    
    public void selectLieu(Lieu lieu) {
        this.lieu = lieu;
        this.nom = lieu.getNom();
        this.description = lieu.getDescription();
        this.latitude = lieu.getLatitude();
        this.longitude = lieu.getLongitude();
    }
}
