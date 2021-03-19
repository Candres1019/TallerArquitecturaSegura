package co.edu.escuelaing.arep.securesparklife.services;

import co.edu.escuelaing.arep.securesparklife.entities.User;

/**
 * Interfaz AppService
 *
 * @author Andres Mateo Calderon Ortega
 */
public interface AppService {

    /**
     * Método encargado de cargar al usuario de la plataforma
     *
     * @return - Usuario de la plataforma
     */
    User loadPlataformUser();

    /**
     * Método encargado de encriptar un password
     *
     * @param password - password a encriptar
     * @return - password encriptado
     */
    String encryptPassword(String password);

}
