package co.edu.escuelaing.edu.securesparklife;

import co.edu.escuelaing.edu.securesparklife.persistence.UsersPesistence;
import co.edu.escuelaing.edu.securesparklife.persistence.impl.UsersPersistenceMock;
import co.edu.escuelaing.edu.securesparklife.services.AppServices;
import co.edu.escuelaing.edu.securesparklife.services.impl.AppServicesImpl;
import co.edu.escuelaing.edu.securesparklife.services.impl.EncryptServiceSHA256;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import spark.Request;
import spark.Response;

import static spark.Spark.*;

/**
 * Clase SecureServices
 *
 * @author Andres Mateo Calderon Ortega
 */
public class SecureServices {

    private static Boolean logged = false;
    private static final AppServices appServices = new AppServicesImpl();

    /**
     * Método Main de la clase SecureServices
     *
     * @param args - args
     */
    public static void main(String[] args) {
        /*admin@1019"*/
        /*candres@1019"*/
        // API: secure(keystoreFilePath, keystorePassword, truststoreFilePath,truststorePassword);
        secure("keystores/ecikeystore.p12", "123456", null, null);

        port(getPort());

        staticFiles.location("/public");

        AppServicesImpl.getInstance().loadUsers();

        get("/admin", ((request, response) -> {
            if (!logged){
                return "Fcita no pueda utilizar el servicio prro";
            }else{
                return "Listo pa mandar al otro servicio";
            }
        }));

        post("/loginUser", ((request, response) -> {
            return tryLogin(request.body());
        }));
    }

    private static Boolean tryLogin(String cadena) {
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = (JsonObject) parser.parse(cadena);
        Boolean pudo = appServices.getLogin(jsonObject.get("user").getAsString(), jsonObject.get("password").getAsString());
        logged = pudo;
        return logged;
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
