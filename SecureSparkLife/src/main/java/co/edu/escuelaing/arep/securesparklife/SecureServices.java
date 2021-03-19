package co.edu.escuelaing.arep.securesparklife;

import co.edu.escuelaing.arep.securesparklife.entities.User;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static spark.Spark.*;

/**
 * Clase SecureServices
 * java $JAVA_OPTS -cp target/classes:target/dependency/* co.edu.escuelaing.arep.securesparklife.SecureServices
 *
 * @author Andres Mateo Calderon Ortega
 */
public class SecureServices {

    private static Boolean logged = false;
    private static final User userAdmin = new User("admin", "admin@admin.com", "7d64e1eeca3f4f28fc0db624f1abaec1ea94dfbaf56feca44bbfee5b4fb27ff7");

    /**
     * Método Main de la clase SecureServices
     *
     * @param args - args
     */
    public static void main(String[] args) {
        /*admin@1019"*/
        /*candres@1019"*/
        // API: secure(keystoreFilePath, keystorePassword, truststoreFilePath,truststorePassword);
        secure("keystores/securelifestore.p12", "123456", "keystores/SecureTrustStore", "654321");

        port(getPort());

        staticFiles.location("/public");

        options("/*",
                (request, response) -> {

                    String accessControlRequestHeaders = request
                            .headers("Access-Control-Request-Headers");
                    if (accessControlRequestHeaders != null) {
                        response.header("Access-Control-Allow-Headers",
                                accessControlRequestHeaders);
                    }

                    String accessControlRequestMethod = request
                            .headers("Access-Control-Request-Method");
                    if (accessControlRequestMethod != null) {
                        response.header("Access-Control-Allow-Methods",
                                accessControlRequestMethod);
                    }

                    return "OK";
                });

        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

        System.out.println("Corriendo por el puerto: " + getPort());

        init();

        get("/admin", ((request, response) -> {
            if (!logged) {
                return "Fcita no pueda utilizar el servicio prro";
            } else {
                return "Listo pa mandar al otro servicio";
            }
        }));

        post("/loginUser", ((request, response) -> {
            response.status(200);
            JsonParser parser = new JsonParser();
            JsonObject jsonObject = (JsonObject) parser.parse(request.body());
            Boolean resultado = tryLogin(jsonObject.get("user").getAsString(), jsonObject.get("password").getAsString());
            System.out.println(resultado);
            return resultado;
        }));

        post("/logoutUser", ((request, response) -> {
            return logOut(request.body());
        }));

        get("/admin/*", ((request, response) -> {
            if (logged) {
                response.redirect("/admin/calculator.html");
                return true;
            } else {
                return "Debe loggearse primero para utilizar el servicio";
            }
        }));

        get("/logged/status", ((request, response) -> {
            return logged;
        }));

    }

    private static Boolean tryLogin(String user, String pass) {
        String passwd = encryptPassword(pass);
        System.out.println(passwd);
        System.out.println(userAdmin.getPassword());
        System.out.println(passwd.equals(userAdmin.getPassword()));
        System.out.println(user.equals(userAdmin.getUsername()));
        Boolean pudo = user.equals(userAdmin.getUsername()) && passwd.equals(userAdmin.getPassword());
        logged = pudo;
        System.out.println(logged);
        return logged;
    }

    private static Boolean logOut(String usuario) {
        logged = false;
        return true;
    }

    public static String encryptPassword(String password) {
        return DigestUtils.sha256Hex(password);
    }

    /**
     * Retorna el puerto por el que debería correr el servidor, creado para evitar errores en un ambiente de
     * despliegue no local
     *
     * @return - puerto.
     */
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000;
    }

}
