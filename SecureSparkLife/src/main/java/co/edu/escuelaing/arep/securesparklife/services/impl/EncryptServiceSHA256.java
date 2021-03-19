package co.edu.escuelaing.arep.securesparklife.services.impl;

import co.edu.escuelaing.arep.securesparklife.services.EncryptService;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EncryptServiceSHA256 implements EncryptService {

    private static final EncryptServiceSHA256 _instance = new EncryptServiceSHA256();

    public EncryptServiceSHA256() {
        //Constructor Vacio
    }

    public static EncryptServiceSHA256 getInstance() {
        return _instance;
    }

    @Override
    public String encryptPassword(String password) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA256");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(EncryptServiceSHA256.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        byte[] hash = messageDigest.digest(password.getBytes());
        StringBuilder stringBuffer = new StringBuilder();

        for (byte b : hash) {
            stringBuffer.append(String.format("%02x", b));
        }

        return stringBuffer.toString();
    }

}
