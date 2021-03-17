package co.edu.escuelaing.edu.securesparklife.services.impl;

import co.edu.escuelaing.edu.securesparklife.entities.User;
import co.edu.escuelaing.edu.securesparklife.persistence.impl.UsersPersistenceMock;
import co.edu.escuelaing.edu.securesparklife.services.AppServices;

import java.util.ArrayList;
import java.util.HashMap;

public class AppServicesImpl implements AppServices {

    private static final AppServicesImpl _instance = new AppServicesImpl();
    private static Integer vecesCargado = 0;
    private static final HashMap<String, User> usernameHashMap = new HashMap<>();
    private static final HashMap<String, User> mailHashMap = new HashMap<>();

    public AppServicesImpl() {
        //Constructor Vacio
    }

    public AppServicesImpl getInstance() {
        return _instance;
    }

    @Override
    public void loadPlataformUsers(String usuarios) {
        if (vecesCargado == 0) {
            vecesCargado++;
            UsersPersistenceMock usersPersistenceMock = new UsersPersistenceMock();
            ArrayList<User> userArrayList = usersPersistenceMock.loadPlataformUsers(usuarios);
            for (User user : userArrayList) {
                usernameHashMap.put(user.getUsername(), user);
                mailHashMap.put(user.getMail(), user);
            }
        }
    }

    @Override
    public Boolean getLogin(String user, String password) {
        System.out.println(user);
        System.out.println(usernameHashMap.get(user));
        if (usernameHashMap.containsKey(user)) {
            System.out.println(EncryptServiceSHA256.getInstance().encryptPassword(password));
            System.out.println(usernameHashMap.get(user).getPassword());
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
