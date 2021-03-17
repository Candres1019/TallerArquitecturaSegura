package co.edu.escuelaing.edu.securesparklife.services;

public interface AppServices {

    void loadPlataformUsers(String usuarios);

    Boolean getLogin(String user, String password);

    Boolean compararPassword(String passwordReal, String passwordEnviado);

}
