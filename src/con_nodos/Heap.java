package con_nodos;

import java.util.ArrayList;

public class Heap {

    private Nodo raiz;
    private ArrayList<Nodo> nodos;

    public Heap(){
        nodos=new ArrayList<>();
        raiz=null ;
    }

    public void insertar(int valor, int prioridad) {
        Nodo nuevo = new Nodo(valor, prioridad);
        nodos.add(nuevo);

        if (nodos.size() == 1) {
            raiz = nuevo;
            return;
        }

        int index = nodos.size() - 1;
        int padreIndex = (index - 1) / 2;
        Nodo padre = nodos.get(padreIndex);
        nuevo.padre = padre;

        if (padre.izq == null) {
            padre.izq = nuevo;
        } else {
            padre.der = nuevo;
        }

        heapifyUp(nuevo);
    }

    public void extraerMax() { //elimina maximo nodo
        if (nodos.isEmpty()) return;

        Nodo ultimo = nodos.getLast();

        if (nodos.size() == 1) {
            nodos.removeFirst();
            raiz = null;
            return;
        }

        raiz.valor = ultimo.valor;
        raiz.prioridad = ultimo.prioridad;

        Nodo padre = ultimo.padre;
        if (padre != null) {
            if (padre.izq == ultimo) padre.izq = null;
            else padre.der = null;
        }

        nodos.removeLast();
        heapifyDown(raiz);

    }

    public boolean estaVacio() {
        return (null==raiz);
    }

    public Nodo primero() {
        return raiz;
    }


    private void swap(Nodo a, Nodo b) {
        int tempVal = a.valor;
        int tempPrio = a.prioridad;
        a.valor = b.valor;
        a.prioridad = b.prioridad;
        b.valor = tempVal;
        b.prioridad = tempPrio;
    }

    private void heapifyUp(Nodo nodo) {
        while (nodo.padre != null && nodo.prioridad > nodo.padre.prioridad) {
            swap(nodo, nodo.padre);
            nodo = nodo.padre;
        }
    }


    private void heapifyDown(Nodo nodo) {
        while (true) {
            Nodo mayor = nodo;

            if (nodo.izq != null && nodo.izq.prioridad > mayor.prioridad)
                mayor = nodo.izq;

            if (nodo.der != null && nodo.der.prioridad > mayor.prioridad)
                mayor = nodo.der;

            if (mayor != nodo) {
                swap(nodo, mayor);
                nodo = mayor;
            } else {
                break;
            }
        }
    }


    //metodo extra
    public ArrayList<Nodo> heapSort() {
        Heap copia = new Heap();

        for (Nodo nodo : this.nodos) {
            copia.insertar(nodo.valor, nodo.prioridad);
        }

        ArrayList<Nodo> resultado = new ArrayList<>();

        while (!copia.estaVacio()) {
            Nodo max = copia.primero();
            resultado.add(new Nodo(max.valor, max.prioridad));
            copia.extraerMax();
        }

        return resultado;
    }


}
