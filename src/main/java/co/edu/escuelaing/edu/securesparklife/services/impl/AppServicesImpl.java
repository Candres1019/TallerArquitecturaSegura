package co.edu.escuelaing.edu.securesparklife.services.impl;

import co.edu.escuelaing.edu.securesparklife.entities.User;
import co.edu.escuelaing.edu.securesparklife.persistence.UsersPesistence;
import co.edu.escuelaing.edu.securesparklife.persistence.impl.UsersPersistenceMock;
import co.edu.escuelaing.edu.securesparklife.services.AppServices;

import java.util.HashMap;

public class AppServicesImpl implements AppServices {

    private static final AppServicesImpl _instance = new AppServicesImpl();
    private static final HashMap<String, User> usernameHashMap = new HashMap<>();
    private static final HashMap<String, User> mailHashMap = new HashMap<>();
    private static final UsersPesistence usersPersistence = new UsersPersistenceMock();

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
