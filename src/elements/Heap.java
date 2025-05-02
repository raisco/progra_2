package elements;

import java.util.ArrayList;

public class Heap {

    private ArrayList<Elemento> heap;

    public Heap() {
        heap = new ArrayList<>();
    }

    public void insertar(int valor, int prioridad) {
        Elemento elemento=new Elemento(valor,prioridad);
        heap.add(elemento);
        heapifyUp(heap.size() - 1);
    }

    public void extraerMax() { //elimina maximo elemento
        if (!heap.isEmpty()){
            Elemento max = heap.getFirst();
            Elemento ultimo = heap.removeLast();

            if (!heap.isEmpty()) {
                heap.set(0, ultimo);
                heapifyDown(0);
            }
        }


    }

    public boolean estaVacio() {
        return heap.isEmpty();
    }


    public Elemento primero() {
        if (!heap.isEmpty()) {
            return heap.getFirst();
        }
        return null;
    }

    private void swap(int i, int j) {
        Elemento temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void heapifyUp(int indice) {
        int padre = (indice - 1) / 2;
        if (indice > 0 && heap.get(indice).prioridad > heap.get(padre).prioridad) {
            swap(indice, padre);
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
            swap(indice, mayor);
            heapifyDown(mayor);
        }
    }



    //metodo extra
    public ArrayList<Elemento> heapSort() {
        ArrayList<Elemento> resultado = new ArrayList<>();
        Heap copia = new Heap();


        for (Elemento e : this.heap) {
            copia.insertar(e.valor, e.prioridad);
        }

        while (!copia.estaVacio()) {
            Elemento max = copia.primero();
            resultado.add(max);
            copia.extraerMax();
        }

        return resultado;
    }




}

