package elements;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {



        Heap heap = new Heap();
        heap.insertar(10,50);
        heap.insertar(10,89);
        heap.insertar(10,100);
        heap.insertar(10,10);

        System.out.println("Elemento mayor en max heap: " + heap.primero().prioridad); //es el head de la max-heap




        ColaPrioridad cola = new ColaPrioridad();
        cola.InicializarCola();

        // Acolar algunos elementos
        cola.AcolarPrioridad(100, 3);
        cola.AcolarPrioridad(30, 5);
        cola.AcolarPrioridad(300, 1);
        cola.AcolarPrioridad(50, 10);

        System.out.println("Primero en cola de prioridad : " + cola.Primero());
        System.out.println("Prioridad del primero: " + cola.Prioridad());

        ArrayList<Elemento> ordenados = cola.Ordenar();

        System.out.println("\nElementos ordenados de mayor a menor:");
        for (Elemento e : ordenados) {
            System.out.println(e.valor);
        }

        System.out.println("Primero: " + cola.Primero());
        System.out.println("Prioridad del primero: " + cola.Prioridad());


        cola.Desacolar();


        System.out.println("Después de desacolar:");
        System.out.println("Nuevo primero: " + cola.Primero());
        System.out.println("Prioridad: " + cola.Prioridad());


        while (!cola.ColaVacia()) {
            System.out.println("Desacolando: " + cola.Primero() + " (Prioridad: " + cola.Prioridad() + ")");
            cola.Desacolar();
        }

        System.out.println("¿La cola está vacía? " + cola.ColaVacia());

    }
}
