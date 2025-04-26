package elements;

import java.util.ArrayList;

public class Heap {

    private ArrayList<Elemento> heap;

    public Heap() {
        heap = new ArrayList<>();
    }

    public void heapifyUp(int indice) {
        int padre = (indice - 1) / 2;
        if (indice > 0 && heap.get(indice).prioridad > heap.get(padre).prioridad) {
            Elemento temp = heap.get(indice);
            heap.set(indice, heap.get(padre));
            heap.set(padre, temp);
            heapifyUp(padre);
        }
    }


    public void heapifyDown(int indice) {
        int izquierda = 2 * indice + 1;
        int derecha = 2 * indice + 2;
        int mayor = indice;

        if (izquierda < heap.size() && heap.get(izquierda).prioridad > heap.get(mayor).prioridad) {
            mayor = izquierda;
        }
        if (derecha < heap.size() && heap.get(derecha).prioridad > heap.get(mayor).prioridad) {
            mayor = derecha;
        }

        if (mayor != indice) {
            Elemento temp = heap.get(indice);
            heap.set(indice, heap.get(mayor));
            heap.set(mayor, temp);
            heapifyDown(mayor);
        }
    }


    public void insertar(Elemento elemento) {
        heap.add(elemento);
        heapifyUp(heap.size() - 1);
    }

    public boolean eliminar(Elemento elemento) {
        if (!heap.isEmpty()) {
            int index = heap.indexOf(elemento);
            if (index != -1) {
                Elemento ultimo = heap.remove(heap.size() - 1);
                if (index < heap.size()) {
                    heap.set(index, ultimo);
                    heapifyDown(index);
                    heapifyUp(index);
                }
                return true;
            }
        }
        return false;
    }


    public boolean esVacia() {
        return heap.isEmpty();
    }


    public Elemento primero() {
        if (!heap.isEmpty()) {
            return heap.get(0);
        }
        return null;
    }

    public ArrayList<Elemento> heapSort() {
        ArrayList<Elemento> resultado = new ArrayList<>();
        Heap copia = new Heap();


        for (Elemento e : this.heap) {
            copia.insertar(new Elemento(e.valor, e.prioridad));
        }

        while (!copia.esVacia()) {
            Elemento max = copia.primero();
            resultado.add(max);
            copia.eliminar(max);
        }

        return resultado;
    }




}

