package cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.tree;

import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.list.List;

public interface Node<T> {
	
	/**
	 * Añade un hijo a un nodo
	 * @param child el nodo a insertar
	 */
	void addChild(Node<T> child);
	
	/**
	 * Añade un hijo a un nodo, en una posicion especifica entre sus hermanos
	 * @param index posicion entre los hermanos
	 * @param child el nodo a insertar
	 */
	void addChildAt(int index, Node<T> child);
	
	/**
	 * Remueve un hijo del nodo
	 */
	void removeChildren();
	
	/**
	 * Remueve un hijo especifico entre los hermanos
	 * @param index el nodo a remover
	 * @return el nodo removido
	 */
	Node<T> removeChildAt(int index);
	
	/**
	 * Retorna el dato que esta en un nodo
	 * @return el dato que esta en un nodo
	 */
	T getData();
	
	/**
	 * Inserta un dato a un nodo especifico
	 * @param data el dato a insertar
	 */
	void setData(T data);
	
	/**
	 * Retorna el padre de un nodo
	 * @return el padre de un nodo
	 */
	Node<T> getParent();
	
	/**
	 * Le asigna a un nodo un padre
	 * @param parent el padre a insertar
	 */
	void setParent(Node<T> parent);
	
	/**
	 * Retorna una lista con todos los hijos de un nodo
	 * @return una lista con todos los hijos de un nodo
	 */
	List<Node<T>> getChildren();
	
	/**
	 * Asigna todos los nodos de la lista como hijos de un nodo
	 * @param children la lista de hijos a asignar
	 */
	void setChildren(List<Node<T>> children);
	
	/**
	 * Retorna el hijo especifico entre los hijos de un nodo
	 * @param index la posicion del hijo
	 * @return el hijo especifico entre los hijos de un nodo
	 */
	Node<T> getChildAt(int index);

}
