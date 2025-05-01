package con_nodos;

public class Nodo {
    int valor;
    int prioridad;
    Nodo izq, der, padre;

    public Nodo(int valor, int prioridad) {
        this.valor = valor;
        this.prioridad = prioridad;
    }
}
