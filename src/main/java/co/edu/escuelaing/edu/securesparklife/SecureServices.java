package co.edu.escuelaing.edu.securesparklife;

import static spark.Spark.*;

/**
 * Clase SecureServices
 *
 * @author Andres Mateo Calderon Ortega
 */
public class SecureServices {

    /**
     * Método Main de la clase SecureServices
     *
     * @param args - args
     */
    public static void main(String[] args) {
        // API: secure(keystoreFilePath, keystorePassword, truststoreFilePath,truststorePassword);
        secure("keystores/ecikeystore.p12", "123456", null, null);
        port(getPort());
        System.out.println("Aplicación ejecutada por el puerto: " + getPort());
        staticFiles.location("/public");
        get("/helloservice", (req, res) -> "Hello from secure service");
        /*get("/", (request, response) -> {
            response.type("text/html");
            response.redirect("index.html");
            return null;
        });*/
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
