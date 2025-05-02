package con_nodos;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ColaPrioridad cola = new ColaPrioridad();
        cola.InicializarCola();

        // Acolar elementos
        cola.AcolarPrioridad(10, 3);
        cola.AcolarPrioridad(20, 5);
        cola.AcolarPrioridad(30, 1);
        cola.AcolarPrioridad(40, 4);
        cola.AcolarPrioridad(100, 3);
        cola.AcolarPrioridad(30, 5);
        cola.AcolarPrioridad(300, 1);
        cola.AcolarPrioridad(50, 10);


        // Mostrar primero y su prioridad
        System.out.println("Primero en cola de prioridad: " + cola.Primero());
        System.out.println("Prioridad del primero: " + cola.Prioridad());

        // Desacolar
        cola.Desacolar();
        System.out.println("\nDespués de desacolar:");
        System.out.println("Primero: " + cola.Primero());
        System.out.println("Prioridad: " + cola.Prioridad());

        // Segundo desacolar
        cola.Desacolar();
        System.out.println("\nDespués de otra desacolación:");
        System.out.println("Primero: " + cola.Primero());
        System.out.println("Prioridad: " + cola.Prioridad());

        // Mostrar ordenado por prioridad descendente
        System.out.println("\nElementos ordenados por prioridad (mayor a menor)d:");
        ArrayList<Nodo> ordenados = cola.Ordenar();
        for (Nodo n : ordenados) {
            System.out.println("Valor: " + n.valor + ", Prioridad: " + n.prioridad);
        }

        //vaciar cola
        System.out.println("\nVaciando cola:");
        System.out.println("¿La cola está vacía? " + cola.ColaVacia());
        while (!cola.ColaVacia()) {
            System.out.println("Desacolando: " + cola.Primero() + " (Prioridad: " + cola.Prioridad() + ")");
            cola.Desacolar();
        }

        System.out.println("¿La cola está vacía? " + cola.ColaVacia());

    }
}
