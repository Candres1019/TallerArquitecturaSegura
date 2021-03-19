package co.edu.escuelaing.arep.securesparklife.persistence;

import co.edu.escuelaing.arep.securesparklife.entities.User;

import java.util.ArrayList;

public interface UsersPesistence {

    ArrayList<User> loadPlataformUsers();

}
