package con_nodos;

import java.util.ArrayList;

public class ColaPrioridad implements InterfazColaPrioridad {
    private Heap heap;

    @Override
    public void InicializarCola() {
        heap = new Heap();
    }

    @Override
    public void AcolarPrioridad(int valor, int prioridad) {
        heap.insertar(valor, prioridad);
    }

    @Override
    public void Desacolar() {
        heap.extraerMax();
    }

    @Override
    public boolean ColaVacia() {
        return heap.estaVacio();
    }

    @Override
    public int Primero() {
        if (!heap.estaVacio()) {
            return heap.primero().valor;
        }
        return -1;
    }

    @Override
    public int Prioridad() {
        if (!heap.estaVacio()) {
            return heap.primero().prioridad;
        }
        return -1;
    }

    @Override
    public ArrayList<Nodo> Ordenar() {
        return heap.heapSort();
    }


}
