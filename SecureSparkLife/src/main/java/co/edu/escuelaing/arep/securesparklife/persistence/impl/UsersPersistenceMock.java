package co.edu.escuelaing.arep.securesparklife.persistence.impl;

import co.edu.escuelaing.arep.securesparklife.entities.User;
import co.edu.escuelaing.arep.securesparklife.persistence.UsersPesistence;

import java.util.ArrayList;

public class UsersPersistenceMock implements UsersPesistence {

    private final ArrayList<User> userArrayList = new ArrayList<>();

    @Override
    public ArrayList<User> loadPlataformUsers() {

        User userAdmin = new User("admin", "admin@admin.com", "7d64e1eeca3f4f28fc0db624f1abaec1ea94dfbaf56feca44bbfee5b4fb27ff7");
        User userUser = new User("candres1019", "andres.calderon-o@mail.escuelaing.edu.co", "f873139c0d0ffcea24e71b34384e352ff59ba93426cf9050b97382036629b3d4");

        userArrayList.add(userAdmin);
        userArrayList.add(userUser);

        return userArrayList;
    }

}
