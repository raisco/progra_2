package elements;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {



        Heap heap = new Heap();
        heap.insertar(new Elemento(50 ));
        heap.insertar(new Elemento(89));
        heap.insertar(new Elemento(100));
        heap.insertar(new Elemento(44));

        System.out.println("Elemento con mayor prioridad: " + heap.primero().prioridad);




        ColaPrioridad cola = new ColaPrioridad();
        cola.InicializarCola();

        // Acolar algunos elementos
        cola.AcolarPrioridad(100, 3);
        cola.AcolarPrioridad(200, 5);
        cola.AcolarPrioridad(300, 1);
        cola.AcolarPrioridad(400, 10);

        ArrayList<Elemento> ordenados = cola.Ordenar();

        System.out.println("\nElementos ordenados de mayor a menor:");
        for (Elemento e : ordenados) {
            System.out.println(e.valor);
        }

        System.out.println("Primero: " + cola.Primero()); // Esperamos 400
        System.out.println("Prioridad del primero: " + cola.Prioridad()); // Esperamos 10


        cola.Desacolar();


        System.out.println("Después de desacolar:");
        System.out.println("Nuevo primero: " + cola.Primero()); // Esperamos 200
        System.out.println("Prioridad: " + cola.Prioridad()); // Esperamos 5


        while (!cola.ColaVacia()) {
            System.out.println("Desacolando: " + cola.Primero() + " (Prioridad: " + cola.Prioridad() + ")");
            cola.Desacolar();
        }

        System.out.println("¿La cola está vacía? " + cola.ColaVacia());

    }
}
