import java.time.LocalDate;
import java.util.ArrayList;

public class ParcAutomobile {
    protected ArrayList<Vehicule> vehicules;
    protected ArrayList<Client> clients;

    public ParcAutomobile() {
        this.vehicules = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    public void ajVehicule(Vehicule vehicule) {

        vehicules.add(vehicule);
    }

    public void ajClient(Client client) {

        clients.add(client);
    }

    public void louerVehicule(String numeroPermis, String immatriculation, LocalDate dateDebut, LocalDate dateFin)
            throws VehiculeIndisponibleException, ClientNonAutoriseException {
        Client client = trouverClient(numeroPermis);
        Vehicule vehicule = trouverVehicule(immatriculation);

        if (client != null && vehicule instanceof Louable) {
            // utilisation de louable
            ((Louable) vehicule).louer(client);

            ContratDeLocation contrat = new ContratDeLocation(client, vehicule, dateDebut, dateFin);
            client.ajouterContrat(contrat);
            System.out.println("Contrat de location créé avec succès.");
        } else {
            System.out.println("Client ou véhicule introuvable, ou véhicule non louable.");
        }
    }

    public void retournerVehicule(String immatriculation) {
        Vehicule vehicule = trouverVehicule(immatriculation);

        if (vehicule instanceof Louable) {
            for (Client client : clients) {
                if (client.getLocationEnCours().contains(vehicule)) {
                    ((Louable) vehicule).retourner(client);
                    break;
                }
            }
        } else {
            System.out.println("Véhicule introuvable ou non louable.");
        }
    }

    public void listerVehiculeDisponible() {
        boolean found = false;
        for (Vehicule vehicule : vehicules) {
            if (vehicule.getStatut().equals("disponible")) {
                System.out.println("Marque : " + vehicule.getMarque() + ", Modèle : " + vehicule.getModele() + ", Année : " + vehicule.getAnneeMiseEnService() + ", Kilométrage : " + vehicule.getKilometrage() + ", Statut : " + vehicule.getStatut());
                found = true;
            }
            if (!found) {
                System.out.println("Aucun véhicule disponible.");
            }
        }
    }

    public void listerVehiculeLoue() {
        for (Vehicule vehicule : vehicules) {
            if (vehicule.getStatut().equals("loué")) {
                System.out.println(vehicule);
            }
        }
    }

    protected Client trouverClient(String numeroPermis) {
        for (Client client : clients) {
            if (client.getNumeroPermis().equals(numeroPermis)) {
                return client;
            }
        }
        return null;
    }

    protected Vehicule trouverVehicule(String immatriculation) {
        for (Vehicule vehicule : vehicules) {
            if (vehicule.getImmatriculation().equals(immatriculation)) {
                return vehicule;
            }
        }
        return null;
    }


}
