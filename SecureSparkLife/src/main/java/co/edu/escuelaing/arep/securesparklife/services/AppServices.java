package co.edu.escuelaing.arep.securesparklife.services;

public interface AppServices {

    Boolean getLogin(String user, String password);

    Boolean compararPassword(String passwordReal, String passwordEnviado);

}