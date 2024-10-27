Nom et Prénom : N'Dri Chris Elphryd Sehi, Classe : L2 A MIAGE
https://github.com/Chris225-ivory/Autoparc

Application de gestion de parc automobile pour une entreprise de location
L'application nous permet de gérer la location de véhicules pour une entreprise. Elle permet d enregistrer des véhicules et aussi les clients. Les clients enregistrer peuvent louer des véhicules disponible, retourner des véhicules qu ils ont deja louer, et lister les véhicules disponibles ou loués. L'application assure une tres bonne gestion de l'état de chaque véhicule soit elle sont disponible ou elles sont loués.  Le client peut reserver le véhicule le jour qu'il veut et de la retourner quand il veut en fonction des information qu'il aura inscrit dans l'application.

Fonctionnalités principales:
1-Ajouter des véhicules : Ajouter des véhicules (voitures et camions) au parc automobile.
2-Ajouter des clients : Ajouter des clients avec leurs informations et permis.
3-Louer un véhicule : louer un véhicule à un client pour une période donnée.
4-Retourner un véhicule : Gérer le retour d'un véhicule loué.
5-Lister les véhicules disponibles : Afficher la liste des véhicules actuellement disponibles.
6-Lister les véhicules loués : Afficher la liste des véhicules actuellement loués.

Structure du projet:
•Vehicule (classe abstraite) : Elle dispose des attributs communs tels que la marque, le modèle, l'année de mise en service, et le kilométrage.
•Voiture et Camion (classes dérivées) : Hérite de la classe Vehicule et implémente l'interface Louable.
•Louable (interface) : Définit les méthode louer() et retourner() pour gérer le changement de statut des véhicules.
•ParcAutomobile : cette classe gère l'ajout de véhicules et de clients et la gestion des locations.
•Client : Classe représentant un client avec son numéro de permis et ses informations de location.
•ContratDeLocation : représente un contrat entre un client et un véhicule, en fonction de la durée de la location.
•Exceptions : VehiculeIndisponibleException et ClientNonAutoriseException pour gérer les erreurs spécifiques.
