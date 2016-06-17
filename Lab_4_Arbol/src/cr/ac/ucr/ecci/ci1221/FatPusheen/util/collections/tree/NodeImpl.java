package cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.tree;

import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.list.*;

/**
 * Cabe destacar que la naturaleza de la ListaEnlazada hace que los datos sean
 * ingresados de la manera [1, n] y no [0, n-1]
 * 
 * @author Gonzalo
 *
 * @param <T>
 *            Cualquier cosa ingresada
 */

public class NodeImpl<T> implements Node<T> {

	/**
	 * Atributos de la clase (de cada nodo):
	 * 
	 * @param Padre:
	 *            El padre del nodo creado, si es null es la raiz.
	 * @param Hijos:
	 *            La lista de hijos del nodo.
	 * @param Dato:
	 *            El dato que se le inserto al nodo.
	 */
	Node<T> padre;
	List<Node<T>> hijos;
	T dato;

	/**
	 * Constructor de la clase, inicializa tanto los nodos como la raiz. Si
	 * padre es null entonces es una raiz, de lo contrario es un nodo. La lista
	 * de hijos no es inicializada con el nodo para ahorro de espacio.
	 * 
	 * @param contenido
	 *            Lo que contiene el nodo
	 * @param padre
	 *            El padre del nuevo nodo
	 */
	public NodeImpl(T contenido, NodeImpl<T> padre) {
		if (padre == null) {// Raiz
			this.dato = contenido;
		} else if (padre != null) {// Nodo
			this.dato = contenido;
			this.padre = padre;
			padre.addChild(this);// Se le agrega a la lista del padre
		}
	}

	/**
	 * Añade un hijo a un nodo
	 * 
	 * @param child
	 *            el nodo a insertar
	 */
	@Override
	public void addChild(Node<T> child) {
		if (this.hijos == null)// Si no tiene hijos
			this.hijos = new LinkedList<Node<T>>();// Inicia lista
		this.hijos.add(child);
	}

	/**
	 * Añade un hijo a un nodo, en una posicion especifica entre sus hermanos
	 * 
	 * @param index
	 *            posicion entre los hermanos
	 * @param child
	 *            el nodo a insertar
	 */
	@Override
	public void addChildAt(int index, Node<T> child) {
		this.hijos.add(child, index);// Si index pasa el tamaño de la lista
										// el programa se cae
	}

	/**
	 * Remueve un hijo del nodo
	 */
	@Override
	public void removeChildren() {
		this.hijos.remove(hijos.size());// El ultimo a la derecha, siempre
	}

	/**
	 * Remueve un hijo especifico entre los hermanos
	 * 
	 * @param index
	 *            el nodo a remover
	 * @return el nodo removido
	 */
	@Override
	public Node<T> removeChildAt(int index) {
		Node<T> retorno = this.hijos.get(index);
		this.hijos.remove(index);// Si index es mas grande que la lista, el
									// programa se cae
		return retorno;
	}

	/**
	 * Retorna el dato que esta en un nodo
	 * 
	 * @return el dato que esta en un nodo
	 */
	@Override
	public T getData() {
		return this.dato;
	}

	/**
	 * Inserta un dato a un nodo especifico
	 * 
	 * @param data
	 *            el dato a insertar
	 */
	@Override
	public void setData(T data) {
		this.dato = data;
	}

	/**
	 * Retorna el padre de un nodo
	 * 
	 * @return el padre de un nodo
	 */
	@Override
	public Node<T> getParent() {
		return this.padre;
	}

	/**
	 * Le asigna a un nodo un padre
	 * 
	 * @param parent
	 *            el padre a insertar
	 */
	@Override
	public void setParent(Node<T> parent) {
		this.padre = parent;
	}

	/**
	 * Retorna una lista con todos los hijos de un nodo
	 * 
	 * @return una lista con todos los hijos de un nodo
	 */
	@Override
	public List<Node<T>> getChildren() {
		if (this.hijos == null)// Sin hijos
			return null;
		return this.hijos;
	}

	/**
	 * Asigna todos los nodos de la lista como hijos de un nodo
	 * 
	 * @param children
	 *            la lista de hijos a asignar
	 */
	@Override
	public void setChildren(List<Node<T>> children) {
		for (int i = 1; i <= children.size(); i++) {
			this.addChild(children.get(i));// Siempre a la derecha del anterior
		}
	}

	/**
	 * Retorna el hijo especifico entre los hijos de un nodo
	 * 
	 * @param index
	 *            la posicion del hijo
	 * @return el hijo especifico entre los hijos de un nodo
	 */
	@Override
	public Node<T> getChildAt(int index) {
		return this.hijos.get(index);// Retorna una excepcion si index no existe
										// en la
										// lista de hijos
	}

}
