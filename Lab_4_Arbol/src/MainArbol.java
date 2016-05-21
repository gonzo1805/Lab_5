import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.list.LinkedList;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Tree.Tree;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Tree.TreeImpl;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Tree.Node;
import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.Tree.NodeImpl;

public class MainArbol {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String args[]){
		Tree<Node<Integer>> arbol = new TreeImpl(new NodeImpl(1, null));
		//NodeImpl<Integer> raiz2 = arbol.getRoot();
		System.out.println(arbol.getRoot().getData());
		Node<Integer> nodo1 = new NodeImpl(2, (NodeImpl) arbol.getRoot());
		System.out.println(arbol.exists(nodo1));
	}
}
