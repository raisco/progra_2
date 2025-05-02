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
        Nodo max = heap.primero();
        if (max == null) {
            return -1;
        };
        return max.valor;
    }

    @Override
    public int Prioridad() {
        Nodo max = heap.primero();
        if (max == null) {
            return -1;
        };
        return max.prioridad;
    }

    @Override
    public ArrayList<Nodo> Ordenar() {
        return heap.heapSort();
    }


}
