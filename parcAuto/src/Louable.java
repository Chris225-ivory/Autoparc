interface Louable {
    void louer (Client client) throws VehiculeIndisponibleException, ClientNonAutoriseException;
    void retourner (Client client);
}
