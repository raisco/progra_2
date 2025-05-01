package con_nodos;

import elements.Elemento;

import java.util.ArrayList;

public interface InterfazColaPrioridad {
	void InicializarCola();
	void AcolarPrioridad (int x, int prioridad);
	void Desacolar ();
	boolean ColaVacia();
	int Primero();
	int Prioridad();
	ArrayList<Nodo> Ordenar();
}
