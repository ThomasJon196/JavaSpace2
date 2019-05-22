
public class DBEVL<T> implements DBIF<T>{
	int size;
	Element pFirst, pLast;
	
	class Element{
		T element;
		Element pNext, pPrev;
		
		Element(T element) {
			this.element = element;
			pNext = null;
			pPrev = null;
		}
	}
	
	public DBEVL() {
		size = 0;
		pFirst = null;
		pLast = null;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void appendLast(T tier) {
		if(isEmpty()) {
			pFirst = new Element(tier);
			pLast = pFirst;
			size++;
		} else {
			pLast.pNext = new Element(tier);
			pLast.pNext.pPrev = pLast;
			pLast = pLast.pNext;
			size++;
		}
		
	}	
	
	public T removeLast() {
		T returnElement = null;
		if(!isEmpty()) {
			if(size == 1) {
				returnElement = pFirst.element;
				pFirst = null;
				size--;
			} else {
				returnElement = pLast.element;
				pLast = pLast.pPrev;
				pLast.pNext = null;
				size--;
			}
		}
		return returnElement;
	}

	public boolean insert(T tier, int index) {
		if(index-1 > size) return false;
		Element current = pFirst;
		if(size > 1) {
			for(int i=1; i<index-1; i++) {
				current = current.pNext;
			}
		}
		if(index == 1) {
			Element temp = pFirst;
			pFirst = new Element(tier);
			pFirst.pNext = temp;
			pFirst.pNext.pPrev = pFirst;		
		} else {
			Element newTemp = new Element(tier);
			newTemp.pNext = current.pNext;
			newTemp.pPrev = current;
			current.pNext = newTemp;
		}
		
		
		return true;
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
	
}
