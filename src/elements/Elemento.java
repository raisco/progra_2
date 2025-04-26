package elements;

public class Elemento {
    int valor;
    int prioridad;

    public Elemento(int valor, int prioridad) {
        this.valor = valor;
        this.prioridad = prioridad;
    }

    public Elemento(int prioridad){
        this.prioridad = prioridad;
    }
}
