package co.edu.escuelaing.arep.securesparkcalculator;

import co.edu.escuelaing.arep.securesparkcalculator.util.LinkedListImp;
import co.edu.escuelaing.arep.securesparkcalculator.util.Node;

/**
 * Aplicacion de la calculadora estadistica, haciendo uso de una lista enlazada
 * implementada desde cero.
 * @author Andres Mateo Calderón Ortega
 */
public class CalculadoraEstadistica {

    private LinkedListImp datos;
    private Double media;
    private Double desviacionEstandar;

    /**
     * Constructor de la clase CalculadoraEstadistica
     */
    public CalculadoraEstadistica(){}

    /**
     * Constructor de la clase CalculadoraEstadistica
     * @param datos - Lista enlazada de los datos que se utilizaran para calcular la media y la desviacion estandar
     */
    public CalculadoraEstadistica (LinkedListImp datos){
        this.datos = datos;
    }

    /**
     * Metodo para calcular la media.
     * @return Media de los datos guardados en la lista enlazada
     */
    public Double calcularMedia(){
        media = 0.0;
        Node head = datos.getHead();
        for(int i=0; i<datos.size(); i++){
            media = media + head.getDatos();
            head = head.getNext();
        }
        media = media / datos.size();
        media = Math.round(media * 100.0)/100.0;
        return media;
    }

    /**
     * Metodo para calcular la desviacion Estandar.
     * @return Desviacion Estandar de los datos guardados en la lista enlazada
     */
    public Double calcularDesviacionEstandar(){
        double restaCuadradosTemp, suma, division;
        desviacionEstandar = 0.0;
        suma = 0.0;
        calcularMedia();
        Node head = datos.getHead();
        for(int i=0; i<datos.size(); i++){
            restaCuadradosTemp = Math.pow((head.getDatos() - media), 2);
            suma = suma + restaCuadradosTemp;
            head = head.getNext();
        }
        division = suma / (datos.size() - 1);
        desviacionEstandar = Math.sqrt(division);
        desviacionEstandar = Math.round(desviacionEstandar * 100.0)/100.0;
        return desviacionEstandar;
    }

    /**
     * Metodo getter de la variable datos
     * @return - LinkedListImp de datos
     */
    public LinkedListImp getDatos() {
        return datos;
    }

    /**
     * Metodo setter de la variable datos
     * @param datos - Lista de datos de tipo LinkedListImp
     */
    public void setDatos(LinkedListImp datos) {
        this.datos = datos;
    }

    /**
     * Metodo para convertir una cadena a una lista enlazada de Double
     * @param datosString - Cadena de datos a convertir
     */
    public void stringToLinkedList(String datosString){
        System.out.println(datosString.substring(1,datosString.length()-1));
        this.datos = new LinkedListImp();
        String [] dataString = datosString.substring(1,datosString.length()-1).split(",");
        System.out.println(datosString);
        for (String dato : dataString) {
            System.out.println(dato);
            this.datos.add(Double.valueOf(dato));
        }
    }

}
