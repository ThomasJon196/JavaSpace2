
public class DBTier2<T extends Tier> extends DBBinBaum{
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
	
	//-------------------------------------------------
	// Binary Tree Methods
		
		public boolean add(T element) {
			Node temp = root;
			int diff = 0;
			while(temp != null) {
				diff = temp.element.compareTo(element);
				if(diff == 0) {
					return false;
				}else if(diff > 0) {
					temp = temp.left;
				}else if(diff < 0) {
					temp = temp.right;
				}
			}
			if(temp == null) {
				root = new Node(element);
			}else{
				if(diff > 0) {
					temp.left = new Node(element);
				}else {
					temp.right = new Node(element);
				}
			}
			return true;
		}
		
		public boolean remove(T element) {
			// TODO
			return false;
		}
		
		public boolean search(T element) {
			// TODO
			return false;
		}
		
	//-------------------------------------------------
}

