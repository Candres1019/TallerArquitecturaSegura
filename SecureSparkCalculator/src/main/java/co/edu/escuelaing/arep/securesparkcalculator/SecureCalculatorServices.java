package co.edu.escuelaing.arep.securesparkcalculator;

import com.google.gson.Gson;
import spark.Filter;

import static spark.Spark.*;

public class SecureCalculatorServices {

    /**
     * Método Main de la clase SecureServices
     * java $JAVA_OPTS -cp target/classes:target/dependency/* co.edu.escuelaing.arep.securesparkcalculator.SecureCalculatorServices
     * @param args - args
     */
    public static void main(String[] args) {
        // API: secure(keystoreFilePath, keystorePassword, truststoreFilePath,truststorePassword);
        //secure("keystores/calculatorkeystore.p12", "123456", "keystores/calculatorTrustStore", "654321");

        port(getPort());

        System.out.println("Corriendo por el puerto: " + getPort());

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

        post("/calculator", (request, response) ->{
            System.out.println("hola desde calculator prro");
            response.type("application/json");
            CalculadoraEstadistica calculadoraEstadistica = new CalculadoraEstadistica();
            System.out.println(request.body());
            calculadoraEstadistica.stringToLinkedList(request.body());
            double media = calculadoraEstadistica.calcularMedia();
            double desviacionEstandar = calculadoraEstadistica.calcularDesviacionEstandar();
            return new Gson().toJson("{\"media\": \""+media+"\", \"desviacionEstandar\": \""+desviacionEstandar+"\"}") ;
        });

        get("/helloservice", (request, response) -> "HOLA PUTITO");
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
        return 5001;
    }

}
