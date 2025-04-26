package elements;

import java.util.ArrayList;

public class ColaPrioridad implements InterfazColaPrioridad {

    private Heap heap;


    public void InicializarCola() {
        heap = new Heap();
    }

    public void AcolarPrioridad(int valor, int prioridad) {
        Elemento elemento = new Elemento(valor, prioridad);
        heap.insertar(elemento);
    }

    public void Desacolar() {
        if (!heap.esVacia()) {
            heap.eliminar(heap.primero());
        }
    }

    public boolean ColaVacia() {
        return heap.esVacia();
    }

    public int Primero() {
        if (!heap.esVacia()) {
            return heap.primero().valor;
        }
        return -1;
    }

    public int Prioridad() {
        if (!heap.esVacia()) {
            return heap.primero().prioridad;
        }
        return -1;
    }


    public ArrayList<Elemento> Ordenar() {
        return heap.heapSort();
    }
}
