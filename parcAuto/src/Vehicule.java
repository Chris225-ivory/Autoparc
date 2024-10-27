import java.time.LocalDate;

abstract class Vehicule {
    protected String immatriculation ;
    protected String marque ;
    protected String modele;
    protected int annee ;
    protected int kilometrage;
    protected String statut; // disponible ... louée

    public Vehicule(String immatriculation, String marque, String modele, int annee, int kilometrage){
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
        this.kilometrage = kilometrage;
        this.statut = "disponible";
    }
    public String getImmatriculation() {

        return immatriculation;
    }
    public String getMarque() {

        return marque;
    }
    public String getModele() {

        return modele;
    }
    public int getAnneeMiseEnService() {

        return annee;
    }
    public double getKilometrage() {

        return kilometrage;
    }
    public String getStatut() {

        return statut;
    }

    public void setStatut(String statut) {

        this.statut = statut;
    }
    public abstract double calculerPrixLocation();

    public abstract void louer(Client client) throws VehiculeIndisponibleException, ClientNonAutoriseException;

    public abstract void retourner(Client client);
    @Override
    public String toString(){
        return "Véhicule (Immatriculation: " + immatriculation + ", Marque: " + marque + ", Modèle: " + modele + ", Année: " + annee + ", Kilométrage: " + kilometrage + ", Statut: " + statut + ")";
    }
}
class Voiture extends Vehicule implements Louable {
    protected int nbrePlace;
    protected String typeCaburant;

    public Voiture(String immatriculation, String marque, String modele, int annee, int kilometrage, int nbrePlace, String typeCaburant) {
        super(immatriculation, marque, modele, annee, kilometrage);
        this.nbrePlace = nbrePlace;
        this.typeCaburant = typeCaburant;
    }

    @Override
    public double calculerPrixLocation() {
        int age = LocalDate.now().getYear() - getAnneeMiseEnService();
        double prixDeBase = 50;
        double supplement = (age > 5 ? 20 : 10) + (getKilometrage() > 100000 ? 15 : 0);
        return prixDeBase + supplement;
    }


    @Override
    public void louer(Client client) throws VehiculeIndisponibleException, ClientNonAutoriseException {
        if (getStatut().equals("loué")) {
            throw new VehiculeIndisponibleException("Cette voiture est déjà louée.");
        }
        setStatut("loué");
        client.ajLocation(this);
        System.out.println("Statut après location : " + getStatut());
    }

    @Override
    public void retourner(Client client) {
        setStatut("disponible");
        client.supLocation(this);
        System.out.println("Le véhicule a été retourné avec succès.");
    }
}


class Camion extends Vehicule implements Louable {
    protected double capaciteChargement;
    protected int nbreEssieuux;

    public Camion(String immatriculation, String marque, String modele, int annee, int kilometrage, double capaciteChargement, int nbreEssieuux) {
        super(immatriculation, marque, modele, annee, kilometrage);
        this.capaciteChargement = capaciteChargement;
        this.nbreEssieuux = nbreEssieuux;
    }

    @Override
    public double calculerPrixLocation() {
        return 0;
    }

    @Override
    public void louer(Client client) throws VehiculeIndisponibleException, ClientNonAutoriseException {
        if (getStatut().equals("loué")) {
            throw new VehiculeIndisponibleException("Ce camion est déjà loué.");
        }
        if (!client.getNumeroPermis().startsWith("C")) {
            throw new ClientNonAutoriseException("Client non autorisé à louer un camion.");
        }
        setStatut("loué");
        client.ajLocation(this);
        System.out.println("Statut après location : " + getStatut());
    }

    @Override
    public void retourner(Client client) {
        setStatut("disponible");
        client.supLocation(this);
        System.out.println("Le véhicule a été retourné avec succès.");
    }
}
