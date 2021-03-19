package co.edu.escuelaing.arep.securesparklife;

import co.edu.escuelaing.arep.securesparklife.services.AppServices;
import co.edu.escuelaing.arep.securesparklife.services.impl.AppServicesImpl;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import static spark.Spark.*;

/**
 * Clase SecureServices
 * java $JAVA_OPTS -cp target/classes:target/dependency/* co.edu.escuelaing.arep.securesparklife.SecureServices
 *
 * @author Andres Mateo Calderon Ortega
 */
public class SecureServices {

    private static final AppServices appServices = new AppServicesImpl();
    private static Boolean logged = false;

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

        AppServicesImpl.getInstance().loadUsers();

        get("/admin", ((request, response) -> {
            if (!logged) {
                return "Fcita no pueda utilizar el servicio prro";
            } else {
                return "Listo pa mandar al otro servicio";
            }
        }));

        post("/loginUser", ((request, response) -> {
            JsonParser parser = new JsonParser();
            JsonObject jsonObject = (JsonObject) parser.parse(request.body());
            return tryLogin(jsonObject.get("user").getAsString(), jsonObject.get("password").getAsString());
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
        Boolean pudo = appServices.getLogin(user, pass);
        logged = pudo;
        return logged;
    }

    private static Boolean logOut(String usuario) {
        logged = false;
        return true;
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
