class VehiculeIndisponibleException extends Exception {
    public VehiculeIndisponibleException(String message) {
        super(message);
    }
}

class ClientNonAutoriseException extends Exception {
    public ClientNonAutoriseException(String message) {

        super(message);
    }
}
