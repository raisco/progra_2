package elements;

import java.util.ArrayList;

public class ColaPrioridad implements InterfazColaPrioridad {

    private Heap heap;


    public void InicializarCola() {
        heap = new Heap();
    }

    public void AcolarPrioridad(int valor, int prioridad) {
        heap.insertar(valor, prioridad);
    }

    public void Desacolar() {
            heap.extraerMax();

    }

    public boolean ColaVacia() {
        return heap.estaVacio();
    }

    public int Primero() {
        if (!heap.estaVacio()) {
            return heap.primero().valor;
        }
        return -1;
    }

    public int Prioridad() {
        if (!heap.estaVacio()) {
            return heap.primero().prioridad;
        }
        return -1;
    }


    public ArrayList<Elemento> Ordenar() {
        return heap.heapSort();
    }
}
