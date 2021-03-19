package co.edu.escuelaing.arep.securesparklife.services;

import co.edu.escuelaing.arep.securesparklife.entities.User;

public interface AppService {

    User loadPlataformUser();

    String encryptPassword(String password);

}
