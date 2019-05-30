import java.util.Comparator;
import java.util.Iterator;

public class DBBinBaum<T extends Comparable> extends DB<T> {
	Node root;
	
	private class Node{
		T element;
		Node left;
		Node right;
		
		Node(T element){
			this.element = element;
			left = null;
			right = null;
		}
	}
	
	public DBBinBaum() {
		root = null;
	}
	
	@Override
	public void appendLast(T tier) {
		addRecursive(root, tier);
	}
	
	void addRecursive(Node n, T tier) {
		if(root == null) {
			root = new Node(tier);
			return;
		}
		
	}

	@Override
	public T removeLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T get(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void swap(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sort(Comparator<T> c) {
		// TODO Auto-generated method stub
		
	}
	
}
