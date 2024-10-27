import java.util.ArrayList;

public class Client {
    protected String nom;
    protected ArrayList<ContratDeLocation> contrats;
    protected String prenom;
    protected String numeroPermis;
    protected int numeroTelephone;
    protected ArrayList<Vehicule> locationEnCours;

    public Client (String nom, String prenom, String numeroPermis, int numeroTelephone){
        this.nom = nom;
        this.prenom = prenom;
        this.numeroPermis = numeroPermis;
        this.numeroTelephone = numeroTelephone;
        this.locationEnCours = new ArrayList<>();
        this.contrats = new ArrayList<>();
    }
    public void ajLocation (Vehicule vehicule){

        locationEnCours.add(vehicule);
    }
    public void supLocation (Vehicule vehicule){

        locationEnCours.remove(vehicule);
    }
    public String getNumeroPermis(){

        return numeroPermis;
    }
    public ArrayList<Vehicule> getLocationEnCours() {

        return locationEnCours;
    }
    public void ajouterContrat(ContratDeLocation contrat) {

        this.contrats.add(contrat);
    }
    public ArrayList<ContratDeLocation> getContrats() {

        return contrats;
    }
}
