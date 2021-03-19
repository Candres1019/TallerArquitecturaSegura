package co.edu.escuelaing.arep.securesparkcalculator.util;

public class Node {
    Double datos;
    Node next;

    public Node(Double datos) {
        this.datos = datos;
        next = null;
    }

    public Double getDatos() {
        return datos;
    }

    public void setDatos(Double datos) {
        this.datos = datos;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
