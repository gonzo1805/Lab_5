package cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Tree;

import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.list.*;

public class NodeImpl<T> implements Node<T> {

	Node<T> padre;
	LinkedList<Node<T>> hijos;
	T dato;

	public NodeImpl() {
		hijos = new LinkedList();
	}

	public NodeImpl(T contenido, Node<T> pa) {
		hijos = new LinkedList();
		dato = contenido;
		padre = pa;
	}

	@Override
	public void addChild(Node<T> child) {
		this.hijos.add(child);
	}

	@Override
	public void addChildAt(int index, Node<T> child) {
		if (index > this.hijos.size()) {
			this.hijos.add(child);
		}
		this.hijos.add(child, index);
	}

	@Override
	public void removeChildren() {
		this.hijos.remove(hijos.size());
	}

	@Override
	public Node<T> removeChildAt(int index) {
		if (index > this.hijos.size()) {
			index = this.hijos.size();
		}
		Node<T> retorno = this.hijos.get(index);
		this.hijos.remove(index);
		return retorno;
	}

	@Override
	public T getData() {
		return this.dato;
	}

	@Override
	public void setData(T data) {
		this.dato = data;
	}

	@Override
	public Node<T> getParent() {
		return this.padre;
	}

	@Override
	public void setParent(Node<T> parent) {
		this.padre = parent;
	}

	@Override
	public List<Node<T>> getChildren() {
		if (this.hijos.size() == 0) return null;
		return this.hijos;
	}

	@Override
	public void setChildren(List<Node<T>> children) {
		for (int i = 0; i < children.size(); i++) {
			this.addChild(children.get(i));
		}
	}

	@Override
	public Node<T> getChildAt(int index) {
		if (index > this.hijos.size())
			return null;
		else
			return this.hijos.get(index);
	}

}
