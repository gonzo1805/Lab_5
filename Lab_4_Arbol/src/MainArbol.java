import cr.ac.ucr.ecci.ci1221.FatPusheen.util.collections.list.LinkedList;

public class MainArbol {
	public static void main(String args[]){
		LinkedList<Integer> lista = new LinkedList<>();
		lista.add(5);
		lista.add(2);
		lista.add(4);
		lista.add(3);
		for (int i=1; i<=lista.size(); i++){
			System.out.print(lista.get(i));
		}
		lista.remove(lista.size());
		lista.add(6, 5);
		System.out.println();
		System.out.println(lista.get(4));
		for (int i=1; i<=lista.size(); i++){
			System.out.print(lista.get(i));
		}
	}
}
