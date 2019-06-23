
public class BaumAVL<T extends Comparable<T>> {
	
	private Node root;
	
	private class Node {
		private Node left;
		private Node right;
		private int balance;
		private T element;
		
		public Node(T element) {
			this.element = element;
			left = null;
			right = null;
			balance = Math.max(height(left), height(right));
		}
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	private int height(Node n) {
		return n == null ? 0 : 1 + Math.max(height(n.left), height(n.right));
	}
	
	public int height() {
		return height(root);
	}
	
	public boolean contains(T element) {
		return containsRec(root, element);
	}
	
	private boolean containsRec(Node current, T element) {
		if(current == null) {
			return false;
		}
		if(current.element.compareTo(element) == 0) {
			return true;
		}else if(current.element.compareTo(element) > 0) {
			return containsRec(current.left, element);
		}else {
			return containsRec(current.right, element);
		}
	}
	
	public boolean add(T element) {
		if(isEmpty()) {
			root = new Node(element);
			return true;
		}
		
		Node current = root;
		Node mother = null;
		int diff = 0;
		while(current != null) {
			mother = current;
			diff = current.element.compareTo(element);
			if(diff == 0) return false;
			if(diff > 0) current = current.left;
			else 		 current = current.right;
		}
		
		if(diff > 0) mother.left = new Node(element);
		else		 mother.right = new Node(element);
		
		
		checkIfBalanced(element);
		return true;
		
	}
	
	private void checkIfBalanced(T element){
		Node current = root;
		while(current != null) {
			if(Math.abs(current.balance) > 1) {
				balanceTree(current);
			}else {
				current = current.element.compareTo(element) > 0 ?
							current.left :
								current.right;
			}
		}
	}
	
	private void balanceTree(Node current) {
		
	}
	
	private void balanceLL(Node current) {
		
	}
	
	public static void main(String args[]) {
		BaumAVL avltree = new BaumAVL();
		System.out.println(avltree.height());
	}
}
