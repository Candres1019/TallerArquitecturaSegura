package co.edu.escuelaing.arep.securesparklife.services.impl;

import co.edu.escuelaing.arep.securesparklife.entities.User;
import co.edu.escuelaing.arep.securesparklife.services.AppService;
import org.apache.commons.codec.digest.DigestUtils;

public class AppServiceImpl implements AppService {

    /*admin@1019"*/
    private static final User userAdmin = new User("admin", "admin@admin.com", "7d64e1eeca3f4f28fc0db624f1abaec1ea94dfbaf56feca44bbfee5b4fb27ff7");

    @Override
    public User loadPlataformUser() {
        return userAdmin;
    }

    @Override
    public String encryptPassword(String password) {
        return DigestUtils.sha256Hex(password);
    }

}
