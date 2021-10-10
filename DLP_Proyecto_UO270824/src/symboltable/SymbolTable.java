package symboltable;

import java.util.*;
import ast.Definition;

public class SymbolTable {
	
	private int scope=0; //Representa el scope / ámbito más alto posible (el actual)
	private List<Map<String,Definition>> table; //Lista de Maps. Hay uno por cada ámbito

	public SymbolTable()  {
		//Se inicializa la lista de maps
		this.table = new ArrayList<Map<String, Definition>>();

		//Se crea el primer map para el ámbito 0
		this.table.add(new HashMap<String, Definition>());
	}

	/**
	 * Crea una nueva tabla representando un nuevo ámbito y la mete
	 * en la lista de maps.
	 * */
	public void set() {
		table.add(new HashMap<String, Definition>());
		scope++;
	}

	/**
	 * Elimina el último map de la lista, eliminando así un ámbito.
	 * */
	public void reset() {
		table.remove(scope);
		scope--;
	}

	/**
	 * Inserta una nueva definición en el ámbito correspondiente.
	 * Devuelve true si se ha insertado con éxito o
	 * false en caso de que ya hubiera sido insertada.
	 * */
	public boolean insert(Definition definition) {
		String nombre = definition.getName();
		if(table.get(scope).containsKey(nombre)) {
			return false;
		}
		else {
			table.get(scope).put(nombre, definition);
			return true;
		}
	}

	/**
	 * Busca el identificador en todos los maps de la lista.
	 * Empezamos a buscar desde el map que representa el ámbito más alto y
	 * acabamos con el ámbito más bajo (recorremos los ámbitos de forma descendente).
	 * Devolvemos la definicion correspondiente al identificador si se ha encontrado.
	 * Devolvemos null si no se ha encontado nada.
	 * */
	public Definition find(String id) {
		for(int i = scope; i >= 0; i--) {
			if(table.get(i).containsKey(id)) {
				return table.get(i).get(id);
			}
		}
		return null;
	}

	/**
	 * Busca el identificador en el map correspondiente al scope / ámbito actual.
	 * */
	public Definition findInCurrentScope(String id) {
		return table.get(scope).get(id);
	}

	/**
	 * Devuelve el entero que representa al scope / ámbito actual.
	 * */
	public int getScope() {
		return scope;
	}

	public List<Map<String, Definition>> getTable() {
		return table;
	}
}
