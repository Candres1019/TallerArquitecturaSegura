package co.edu.escuelaing.arep.securesparklife.services.impl;

import co.edu.escuelaing.arep.securesparklife.persistence.UsersPesistence;
import co.edu.escuelaing.arep.securesparklife.persistence.impl.UsersPersistenceMock;
import co.edu.escuelaing.arep.securesparklife.entities.User;
import co.edu.escuelaing.arep.securesparklife.services.AppServices;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class AppServicesImpl implements AppServices {

    private static final AppServicesImpl _instance = new AppServicesImpl();
    private static final HashMap<String, User> usernameHashMap = new HashMap<>();
    private static final HashMap<String, User> mailHashMap = new HashMap<>();
    private static final UsersPesistence usersPersistence = new UsersPersistenceMock();
    private static final String path = "http://localhost:";
    private static final String port = "5001";
    private static final String solicitud = "/calculator";

    public AppServicesImpl() {
        //Método vacio
    }

    public void loadUsers(){
        for (User user : usersPersistence.loadPlataformUsers()){
            usernameHashMap.put(user.getUsername(), user);
            mailHashMap.put(user.getMail(), user);
        }
    }

    public static AppServicesImpl getInstance() {
        return _instance;
    }

    @Override
    public Boolean getLogin(String user, String password) {
        if (usernameHashMap.containsKey(user)) {
            return compararPassword(usernameHashMap.get(user).getPassword(), password);
        } else if (mailHashMap.containsKey(user)) {
            return compararPassword(mailHashMap.get(user).getPassword(), password);
        } else {
            return false;
        }
    }

    @Override
    public Boolean compararPassword(String passwordReal, String passwordEnviado) {
        return EncryptServiceSHA256.getInstance().encryptPassword(passwordEnviado).equals(passwordReal);
    }

}
