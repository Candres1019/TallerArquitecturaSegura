package co.edu.escuelaing.arep.securesparklife.entities;

/**
 * Clase User
 *
 * @author Andres Mateo Caldero Ortega
 */
public class User {

    private String username;
    private String mail;
    private String password;

    /**
     * Constructor vacio de la clase User
     */
    public User() {
        //Constructor vacio
    }

    /**
     * Constructor con parámetros de la clase User
     *
     * @param username - usuario
     * @param mail     - email del usuario
     * @param password - contraseña
     */
    public User(String username, String mail, String password) {
        this.username = username;
        this.mail = mail;
        this.password = password;
    }


    /**
     * Método get del atributo username
     *
     * @return - username
     */
    public String getUsername() {

        return username;
    }

    /**
     * Método set del atributo username
     *
     * @param username - nombre nuevo del usuario
     */
    public void setUsername(String username) {

        this.username = username;
    }

    /**
     * Método get del atributo mail
     *
     * @return - correo
     */
    public String getMail() {

        return mail;
    }

    /**
     * Método set del atributo correo
     *
     * @param username - correo nuevo del usuario
     */
    public void setMail(String mail) {

        this.mail = mail;
    }

    /**
     * Método get del atributo password
     *
     * @return - password
     */
    public String getPassword() {

        return password;
    }

    /**
     * Método set del atributo password
     *
     * @param username - password nuevo del usuario
     */
    public void setPassword(String password) {

        this.password = password;
    }

}
