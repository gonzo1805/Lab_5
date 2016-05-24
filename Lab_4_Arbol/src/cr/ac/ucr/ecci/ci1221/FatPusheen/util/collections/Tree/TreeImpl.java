package cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Tree;

import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.list.LinkedList;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.list.List;

/**
 * Cabe destacar que por la naturaleza de la ListaEnlazada hace que los datos
 * sean ingresados de la manera [1, n] y no [0, n-1]
 * 
 * @author Gonzalo
 *
 * @param <T>
 *            Tipo de dato a usar
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class TreeImpl<T> implements Tree<T> {

	/**
	 * Atributos de la clase
	 * 
	 * @param raiz
	 *            La raiz del arbol
	 */
	Node<T> raiz;

	/**
	 * Constructor del arbol
	 * 
	 * @param padreDeTodo
	 *            El nodo que sera la raiz y primer nodo del nuevo arbol
	 */
	public TreeImpl(Node<T> padreDeTodo) {
		raiz = padreDeTodo;
	}

	/**
	 * Dice si el arbol esta vacio
	 * 
	 * @return un boolean que denota si el arbol esta vacio
	 */
	@Override
	public boolean isEmpty() {
		return getNumberOfNodes() == 0;
	}

	/**
	 * Retorna la raiz del arbol
	 * 
	 * @return la raiz del arbol
	 */
	@Override
	public Node<T> getRoot() {
		return raiz;
	}

	/**
	 * Retorna si el valor existe o no dentro del arbol
	 * 
	 * @param key
	 *            el valor a buscar en el arbol
	 * @return si existe o no en el arbol
	 */
	@Override
	public boolean exists(T key) {
		return existsRec(raiz, key);
	}

	/**
	 * Metodo recursivo para el exist, recorre todo el arbol en busca del nodo o
	 * dato deseado
	 * 
	 * @param nodo
	 *            la raiz del arbol
	 * @param key
	 *            el dato o nodo que se quiere buscar
	 * @return si existe o no el nodo o dato en el arbol
	 */
	public boolean existsRec(Node<T> nodo, T key) {
		if (nodo.getData().equals(key)) {// Si existe el nodo en el arbol
			return true;
		} else if (nodo.getChildren() != null) {// Si tiene hijos
			List<Node<T>> lista = nodo.getChildren();// Los hijos
			boolean comprobacion = false;
			for (int i = 1; i <= lista.size(); i++) {
				comprobacion = existsRec(lista.get(i), key);// Recursividad
				if (comprobacion == true) // Se encontro
					return true;
			}
		}
		return false; // No se encontro
	}

	/**
	 * Retorna la cantidad de nodos en el arbol
	 * 
	 * @return la cantidad de nodos en el arbol
	 */
	@Override
	public int getNumberOfNodes() {
		int contador = 0;// Contador para el recursivo
		return getNumberOfNodesRec(contador, raiz);
	}

	/**
	 * Metodo recursivo de getNumberOfNodes, recorre todo el arbol contando la
	 * cantidad de nodos que hay en el
	 * 
	 * @param contador
	 *            la cantidad de nodos en el arbol, inicializado en el llamado
	 *            al metodo recursivo
	 * @param nodo
	 *            la raiz del arbol
	 * @return la cantidad de nodos en el arbol
	 */
	public int getNumberOfNodesRec(int contador, Node<T> nodo) {
		contador++;// Si este metodo entra es porque entro a un nodo por lo que
					// se suma 1
		if (nodo.getChildren() != null) {// Si tiene hijos
			List<Node<T>> lista = nodo.getChildren();// Hijos
			for (int i = 1; i <= lista.size(); i++) {
				contador = getNumberOfNodesRec(contador, lista.get(i));// Recursividad
			}
		}
		return contador;
	}

	/**
	 * Retorna la cantidad de hijos que tiene un nodo en el arbol
	 * 
	 * @param node
	 *            el nodo que se quiere estudiar
	 * @return la cantidad de hijos que tiene un nodo en el arbol
	 */
	@Override
	public int getNumberOfDescendants(Node<T> node) {
		if (node.getChildren() != null) {// Si tiene hijos
			return (node.getChildren()).size();// El tamaño de la lista de hijos
		}
		return 0; // Si no tiene entonces 0
	}

	/**
	 * Retorna una lista con todos los datos del arbol en Pre-Orden
	 * 
	 * @return una lista con todos los datos del arbol en Pre-Orden
	 */
	@Override
	public List<Node<T>> getPreOrderTraversal() {
		List<Node<T>> lista = new LinkedList();// La lista para el recursivo
		return auxiliarRecorridoPre(raiz, lista);
	}

	/**
	 * Metodo recursivo del PreOrden, inserta en la lista el nodo y luego visita
	 * sus hijos
	 * 
	 * @param nodo
	 *            la raiz del arbol
	 * @param lista
	 *            la lista donde se guardan las cosas
	 * @return la lista con todos los datos ordenados en forma de PreOrden
	 */
	public List<Node<T>> auxiliarRecorridoPre(Node<T> nodo, List<Node<T>> lista) {
		lista.add(nodo);// Inserta en la lista
		if (nodo.getChildren() != null) {// Si tiene hijo
			List<Node<T>> hijos = nodo.getChildren();// Hijos
			for (int i = 1; i <= hijos.size(); i++) {
				auxiliarRecorridoPre(hijos.get(i), lista);// Recursividad
			}
		}
		return lista;// Retorna lista
	}

	/**
	 * Retorna una lista con todos los datos del arbol en In-Orden
	 * 
	 * @return una lista con todos los datos del arbol en In-Orden
	 */
	@Override
	public List<Node<T>> getInOrderTraversal() {
		List<Node<T>> lista = new LinkedList();// Lista para el recursivo
		lista = auxiliarRecorridoIn(raiz, lista, raiz);
		return lista;
	}

	/**
	 * 
	 * @param nodo
	 * @param lista
	 * @param raiz
	 * @return
	 */
	public List<Node<T>> auxiliarRecorridoIn(Node<T> nodo, List<Node<T>> lista, Node<T> raiz) {
		lista.add(nodo);
		if (nodo.getChildren() != null) {
			List<Node<T>> hijos = nodo.getChildren();
			for (int i = 1; i <= hijos.size(); i++) {
				auxiliarRecorridoIn(hijos.get(i), lista, raiz);
			}
		}
		return lista;
	}

	/**
	 * Retorna una lista con todos los datos del arbol en Post-Orden
	 * 
	 * @return una lista con todos los datos del arbol en Post-Orden
	 */
	@Override
	public List<Node<T>> getPostOrderTraversal() {
		List<Node<T>> lista = new LinkedList();// Lista para el recursivo
		return auxiliarRecorridoPost(raiz, lista);
	}

	/**
	 * Metodo recursivo para el recorrido PostOrden, recorre el arbol entrando a
	 * los hijos, cuando esta retornando datos, inserta los nodos en la lista
	 * 
	 * @param nodo
	 *            la raiz del arbol
	 * @param lista
	 *            la lista donde se guardan las cosas
	 * @return la lista con todos los datos ordenados en forma de PostOrden
	 */
	public List<Node<T>> auxiliarRecorridoPost(Node<T> nodo, List<Node<T>> lista) {
		if (nodo.getChildren() != null) {// Si tiene hijos
			List<Node<T>> hijos = nodo.getChildren();// Hijos
			for (int i = 1; i <= hijos.size(); i++) {
				auxiliarRecorridoPost(hijos.get(i), lista);// Recursividad
			}
		}
		lista.add(nodo);// Añade a la lista
		return lista;// Devuelve lista
	}

	/**
	 * Retorna el camino desde la raiz hasta la hoja mas lejana
	 * 
	 * @return el camino desde la raiz hasta la hoja mas lejana
	 */
	@Override
	public List<Node<T>> getLongestPathFromRootToAnyLeaf() {
		List<Node<T>> camino = new LinkedList();// La lista que se retornara
		int prof = 1;// La profundidad actual
		Node<T> ret = null;// El nodo mas profundo
		ret = LongestPathRec(raiz, prof, ret);// Metodo
												// auxiliar que
												// busca el nodo
												// mas profundo
		return completaCamino(ret, camino);// Metodo auxiliar que crea el camino
											// hacia el nodo mas profundo
	}

	/**
	 * Metodo auxiliar que toma el nodo ret enviado por parametro y crea el
	 * camino, en una lista, desde la raiz hasta el
	 * 
	 * @param ret
	 *            el nodo que se le quiere crear el camino
	 * @param camino
	 *            el camino de la raiz hasta ret
	 * @return una lista con el camino completo desde la raiz hasta ret
	 */
	public List<Node<T>> completaCamino(Node<T> ret, List<Node<T>> camino) {
		boolean comp = true;// Comprobacion
		camino.add(ret);// Añadimos el nodo al camino
		while (comp) {
			if (ret.getParent() != null) {// Mientras no sea la raiz
				camino.add(ret.getParent(), 1);// Añade al inicio de la lista
				ret = ret.getParent();// Hace que el padre sea el nuevo nodo
			} else if (ret.getParent() == null) {// Si es la raiz
				comp = false;// Cancela
			}
		}
		return camino;
	}

	/**
	 * Metodo recursivo auxiliar para getLongestPathFromRootToAnyLeaf que
	 * recursivamente va por todos los nodos viendo cual coincide con
	 * getMaxDepth, a la primer coincidencia retorna ese nodo para sacarle el
	 * camino
	 * 
	 * @param nodo
	 *            la raiz y por donde va la recursividad
	 * @param prof
	 *            la profundidad actual del puntero
	 * @param ret
	 *            el nodo mas profundo
	 * @return el nodo mas profundo
	 */
	public Node<T> LongestPathRec(Node<T> nodo, int prof, Node<T> ret) {
		if (nodo.getChildren() != null) {// Si tiene hijos
			prof++;// Aumenta la profundidad
			if (prof == this.getMaxDepth()) {// Si es el mas profundo
				ret = nodo.getChildren().get(1);// Asigna ret como el mas
												// profundo
				return ret;// Retorna
			}
			List<Node<T>> hijos = nodo.getChildren();// Hijos
			for (int i = 1; i <= hijos.size(); i++) {
				ret = LongestPathRec(hijos.get(i), prof, ret);// Recursividad
																// del metodo
			}
		}
		return ret;
	}

	/**
	 * Retorna la altura de la hoja mas profunda en el arbol
	 * 
	 * @return la altura de la hoja mas profunda en el arbol
	 */
	@Override
	public int getMaxDepth() {
		int profundidad = 1;// Profundidad inicial, como es la raiz es 1
		return getMaxDepthRec(raiz, profundidad, profundidad);
	}

	/**
	 * Metodo auxiliar recursivo para getMaxDepth, busca por toda la lista
	 * buscando el nivel mas profundo en el arbol
	 * 
	 * @param nodo
	 *            la raiz y el nodo por el que va la recursividad
	 * @param profundidad
	 *            la profundidad por donde va el metodo
	 * @param profundidadMax
	 *            la profundidad mas alta hasta el momento
	 * @return un int que es el nivel de profundidad del arbol
	 */
	public int getMaxDepthRec(Node<T> nodo, int profundidad, int profundidadMax) {
		if (nodo.getChildren() != null) {// Si tiene hijos
			profundidad++;// Aumenta la profundidad al entrar a los hijos
			if (profundidad > profundidadMax)// Si es la mas alta
				profundidadMax = profundidad;
			List<Node<T>> hijos = nodo.getChildren();// Hijos
			for (int i = 1; i <= hijos.size(); i++) {
				profundidadMax = getMaxDepthRec(hijos.get(i), profundidad, profundidadMax);// Recursividad
																							// del
																							// metodo
			}
		}
		return profundidadMax;
	}

	/**
	 * Retorna una lista con todos los caminos desde la raiz a cada una de las
	 * hojas
	 * 
	 * @return una lista con todos los caminos desde la raiz a cada una de las
	 *         hojas
	 */
	@Override
	public List<List<Node<T>>> getPathsFromRootToAnyLeaf() {
		List<Node<T>> listaHojas = new LinkedList();// Lista con todas las hojas
													// del arbol
		listaHojas = listaHojas(raiz, listaHojas);// Hojas
		List<List<Node<T>>> listaFinal = new LinkedList();// Lista con todos los
															// caminos de la
															// raiz a las hojas
		for (int i = 1; i <= listaHojas.size(); i++) {
			List<Node<T>> lista = new LinkedList();
			listaFinal.add(completaCamino(listaHojas.get(i), lista));// Crea
																		// los
																		// caminos
		}
		return listaFinal;
	}

	/**
	 * Metodo auxiliar recursivo para getPathsFromRootToAnyLeaf que crea una
	 * lista con todas las hojas que tiene el arbol
	 * 
	 * @param nodo
	 *            raiz y por donde va la recursividad del metodo
	 * @param lista
	 *            la lista con las hojas
	 * @return la lista con las hojas
	 */
	public List<Node<T>> listaHojas(Node<T> nodo, List<Node<T>> lista) {
		if (nodo.getChildren() != null) {// Si tiene hijos
			List<Node<T>> hijos = nodo.getChildren();// Hijos
			for (int i = 1; i <= hijos.size(); i++) {
				lista = listaHojas(hijos.get(i), lista);// Recursividad del
														// metodo
			}
		} else if (nodo.getChildren() == null) {// Si es hoja
			lista.add(nodo);// Añade a la lista
		}
		return lista;
	}
}
