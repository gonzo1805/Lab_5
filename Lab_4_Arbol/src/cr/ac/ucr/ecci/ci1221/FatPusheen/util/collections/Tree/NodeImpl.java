package cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Tree;

import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.list.*;

public class NodeImpl<T> implements Node<T> {

	Node<T> padre;
	List<Node<T>> hijos;
	T dato;

	public NodeImpl(T contenido, NodeImpl<T> pa) {
		if (pa == null) {
			this.dato = contenido;
		} else if (pa != null) {
			this.dato = contenido;
			this.padre = pa;
			pa.addChild(this);
		}
	}

	@Override
	public void addChild(Node<T> child) {
		if (this.hijos == null)
			this.hijos = new LinkedList();
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
		if (this.hijos == null)
			return null;
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
