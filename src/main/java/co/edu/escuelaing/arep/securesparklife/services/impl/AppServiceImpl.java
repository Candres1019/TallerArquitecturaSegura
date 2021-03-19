package co.edu.escuelaing.arep.securesparklife.services.impl;

import co.edu.escuelaing.arep.securesparklife.entities.User;
import co.edu.escuelaing.arep.securesparklife.services.AppService;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * Clase AppServiceImpl
 *
 * @author Andres Mateo Calderon Ortega
 */
public class AppServiceImpl implements AppService {

    private static final User userAdmin = new User("admin", "admin@admin.com", "7d64e1eeca3f4f28fc0db624f1abaec1ea94dfbaf56feca44bbfee5b4fb27ff7");

    /**
     * Método encargado de cargar al usuario de la plataforma
     *
     * @return - Usuario de la plataforma
     */
    @Override
    public User loadPlataformUser() {

        return userAdmin;
    }

    /**
     * Método encargado de encriptar un password con la función SHA256
     *
     * @param password - password a encriptar
     * @return - password encriptado
     */
    @Override
    public String encryptPassword(String password) {

        return DigestUtils.sha256Hex(password);
    }

}
