import java.util.Scanner;
import java.time.LocalDate;

public class MenuInteractif {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ParcAutomobile parc = new ParcAutomobile();
        boolean continuer = true;

        while (continuer){
            System.out.println(" Menu de Gestion de Location de Véhicules ");
            System.out.println("1. Ajouter un nouveau véhicule");
            System.out.println("2. Ajouter un nouveau client");
            System.out.println("3. Louer un véhicule");
            System.out.println("4. Retourner un véhicule");
            System.out.println("5. Lister les véhicules disponibles");
            System.out.println("6. Lister les véhicules loués");
            System.out.println("7. Quitter");

            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1 -> ajVehicule(scanner, parc);
                case 2 -> ajClient(scanner, parc);
                case 3 -> louerVehichule(scanner, parc);
                case 4 -> retournerVehicule(scanner, parc);
                case 5 -> listerVehiculeDisponible(parc);
                case 6 -> listerVehiculeLoue(parc);
                case 7 -> {
                    continuer = false;
                    System.out.println("Au revoir");
                }
                default -> System.out.println("Choix invalide. Veuillez reesayer svp");
            }
        }
        scanner.close();
    }
    protected static void ajVehicule (Scanner scanner, ParcAutomobile parc){
        System.out.println("Entrez le type de véhicule (voiture/camion) : ");
        String type = scanner.nextLine();

        if (!type.equalsIgnoreCase("voiture") && !type.equalsIgnoreCase("camion")) {
            System.out.println("Type de véhicule inconnu.");
            return; // Quitter la méthode si le type de véhicule est inconnu
        }
        System.out.println("Entrez l'immatriculation ");
        String immatriculation = scanner.nextLine();
        System.out.println("Entrez la marque : ");
        String marque = scanner.nextLine();
        System.out.println("Entrez le modele : ");
        String modele = scanner.nextLine();
        System.out.println("l'annee : ");
        int annee = scanner.nextInt();
        System.out.println("Nombre de kilometre : ");
        int kilometrage = scanner.nextInt();

        if (type.equalsIgnoreCase("voiture")){
            System.out.println("Entrez le nombre de places svp : ");
            int places = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Entrez le type de caburant");
            String carburant = scanner.nextLine();
            Voiture voiture = new Voiture(immatriculation, marque, modele, annee, kilometrage, places, carburant);
            parc.ajVehicule(voiture);
        } else if (type.equalsIgnoreCase("camion")) {
           System.out.println("Entrez la capaciter de chargement : ");
           double capacite = scanner.nextDouble();
           System.out.println("Nombre essieux : ");
           int essieux = scanner.nextInt();
           Camion camion = new Camion(immatriculation, marque, modele, annee, kilometrage,capacite,essieux );
           parc.ajVehicule(camion);
        }
    }
    protected static void ajClient (Scanner scanner, ParcAutomobile parc){
        System.out.println("Entrez le nom : ");
        String nom = scanner.nextLine();
        System.out.println("Entrer le prenom");
        String prenom = scanner.nextLine();
        System.out.println("Entrer le numero de permis : ");
        String numeroPermis = scanner.nextLine();
        System.out.println("Entrer le numero de telephone : ");
        int numeroTelephone = scanner.nextInt();
        Client client = new Client(nom, prenom, numeroPermis, numeroTelephone);
        parc.ajClient(client);
    }
    protected static void louerVehichule(Scanner scanner, ParcAutomobile parc) {
        System.out.println("Entrer le numéro de permis : ");
        String numeroPermis = scanner.nextLine();
        System.out.println("Entrer l'immatriculation du véhicule : ");
        String immatriculation = scanner.nextLine();
        System.out.println("Entrer la date de début (AAAA-MM-JJ) : ");
        LocalDate dateDebut = LocalDate.parse(scanner.nextLine());
        System.out.println("Entrer la date de fin (AAAA-MM-JJ) : ");
        LocalDate dateFin = LocalDate.parse(scanner.nextLine());

        try {
            parc.louerVehicule(numeroPermis, immatriculation, dateDebut, dateFin);
        } catch (VehiculeIndisponibleException | ClientNonAutoriseException e) {
            System.out.println(e.getMessage());
        }
    }

   protected static void retournerVehicule (Scanner scanner, ParcAutomobile parc){
        System.out.println("Entrer l'imatriculation du véhicule : ");
        String immatriculation = scanner.nextLine();
        parc.retournerVehicule(immatriculation);
   }
   protected static void listerVehiculeDisponible (ParcAutomobile parc){

        parc.listerVehiculeDisponible();
   }
   protected  static void listerVehiculeLoue( ParcAutomobile parc){

        parc.listerVehiculeLoue();
    }
}
