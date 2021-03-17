package co.edu.escuelaing.edu.securesparklife.persistence.impl;

import co.edu.escuelaing.edu.securesparklife.entities.User;
import co.edu.escuelaing.edu.securesparklife.persistence.UsersPesistence;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;

public class UsersPersistenceMock implements UsersPesistence {

    private ArrayList<User> userArrayList = new ArrayList<>();

    @Override
    public ArrayList<User> loadPlataformUsers(String usuarios) {
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = (JsonObject) parser.parse(usuarios);
        JsonArray jsonElements = jsonObject.getAsJsonArray("usuarios");
        for (int i=0; i < jsonElements.size(); i++){
            JsonObject tempJson = jsonElements.get(i).getAsJsonObject();
            //String username, String mail, String password
            User user = new User(tempJson.get("username").toString(), tempJson.get("mail").toString(), tempJson.get("password").toString());
            userArrayList.add(user);
        }
        return userArrayList;
    }

}