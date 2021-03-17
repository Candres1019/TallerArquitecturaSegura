package co.edu.escuelaing.edu.securesparklife.persistence;

import co.edu.escuelaing.edu.securesparklife.entities.User;

import java.util.ArrayList;

public interface UsersPesistence {

    ArrayList<User> loadPlataformUsers(String usuarios);

}
