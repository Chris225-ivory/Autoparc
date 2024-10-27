import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ContratDeLocation {
    protected Client client;
    protected Vehicule vehicule;
    protected LocalDate dateDebut;
    protected LocalDate dateFin;
    protected double prixTotal;

    public ContratDeLocation(Client client, Vehicule vehicule, LocalDate dateDebut, LocalDate dateFin) {
        this.client = client;
        this.vehicule = vehicule;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prixTotal = calculerPrixTotal();
    }

    public double calculerPrixTotal() {
        long joursLoue = ChronoUnit.DAYS.between(dateDebut, dateFin);
        return joursLoue * vehicule.calculerPrixLocation();
    }

    public Client getClient() {

        return client;
    }

    public Vehicule getVehicule() {

        return vehicule;
    }

    public LocalDate getDateDebut() {

        return dateDebut;
    }

    public LocalDate getDateFin() {

        return dateFin;
    }

    public double getPrixTotal() {

        return prixTotal;
    }

    @Override
    public String toString() {
        return "ContratDeLocation [Client: " + client.getNumeroPermis() + ", Véhicule: " + vehicule.getImmatriculation() +
                ", Date de début: " + dateDebut + ", Date de fin: " + dateFin + ", Prix total: " + prixTotal + " fcfa]";
    }
}
