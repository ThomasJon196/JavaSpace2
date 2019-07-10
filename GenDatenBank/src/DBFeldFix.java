import java.util.*;

public class DBFeldFix<T> extends DB<T>{
	// Class variables
	private T[] db;
	
	public DBFeldFix(int dbSize) {
		db = (T[])new Tier[dbSize];
		size = 0;
	}
	
	public DBFeldFix(T[] db) {
		this.db = db;
		size = 0;
		for(int i=0; i<db.length; i++) {
			if(db[i] != null) {
				size++;
			}
		}
	}

	// Create another Igel object at the end of the array.
	// If its empty create a new one.
	public void appendLast(T ob) {
		if(size >= db.length) {
			throw new IndexOutOfBoundsException();
		} else {
			db[size] = ob;
		}
		size++;	
	}
	
	public T removeLast() {

		if(isEmpty()) {
			throw new IndexOutOfBoundsException();	
		} else {
			T returnIgel = db[size-1];
			db[size-1] = null;
			size--;
			return returnIgel;
		}
	}
	
	public T get(int i) {
		if(i <= size) {
			return db[i-1];
		} else {
			throw new IndexOutOfBoundsException();
		}
	}
	
	public void swap(int x, int y) {
		
			T temp = db[x-1];
			db[x-1] = db[y-1];
			db[y-1] = temp;
		
	}
	
	public void sort(Comparator<T> c) {
		
	}
	
	// Vergleichen!!
	public static<T> T maxWeightnonit(DBFeldFix<T> dbFeld) {
		T gesuchtesTier = null;
		DBFeldFix<T> tempDB = new DBFeldFix<>(dbFeld.db.clone());
		
		T current;
		int wFirst, wCurrent;
		while(!tempDB.isEmpty()) {
			current = tempDB.removeLast();
			if(gesuchtesTier == null) {
				gesuchtesTier = current;
			} else {
				wFirst= Integer.valueOf(gesuchtesTier.toString());
				wCurrent = Integer.valueOf(current.toString());
				if(wCurrent > wFirst) {
					gesuchtesTier = current;
				}
			}
		}
		return gesuchtesTier;
	}
	
	
	public static<T> T maxWeight(DBFeldFix<T> db1) {
		Iterator<T> it = db1.iterator();
		T dickstes = null;
		while(it.hasNext()) {
			if(dickstes == null) {
				dickstes = it.next();
			} else {
				T next = it.next();
				int weightOld = Integer.valueOf(dickstes.toString());
				int weightNew = Integer.valueOf(next.toString());
				if(weightOld < weightNew) {
					dickstes = next; 
				}		
			}
		}
		return dickstes;
	}
	
	public static<T> T maxWeight2(DBFeldFix<T> db1) {
		Iterator<T> it = db1.iterator();
		T dickstes = null;
		for(T e : db1) {
			if(dickstes == null) {
				dickstes = e;
			} else {
				int w1 = Integer.valueOf(dickstes.toString());
				int w2 = Integer.valueOf(e.toString());
				if(w2 > w1) {
					dickstes = e;
				}
			}
		}
		
		return dickstes;
	}
	
	public Iterator<T> iterator() {
		return new InnerIter<T>();
	}
	
	class InnerIter<E> implements Iterator<E>{
		int itCounter;
		int endPos;
		
		InnerIter () {
			itCounter = 0;
			endPos = size;
		}
		
		InnerIter (int start) {
			itCounter = start;
		}
		
		InnerIter (int start, int end) {
			if(start < end) {
				itCounter = start;
				endPos = end;
			} else {
				itCounter = end;
				endPos = start;
			}
		}
		
		public boolean hasNext() {
			if(itCounter >= size) {
				return false;
			}
			return true;
		}
		
		public E next() {
			return (E)db[itCounter++];
		}
		
		public E nextBack() {
			return (E)db[size-(itCounter++)];
		}
	}
	
	public static<E> void printAll(Iterable<E> list) {
		for(E ele : list) {
			System.out.println(ele);
		}
	}
}
