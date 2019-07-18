import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.Stack;
import java.util.Iterator;

public class TestKlasse {
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		
		TestKlasse x = new TestKlasse();
		
		Integer[] intFeld = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		A<Integer> feld = x.new A(intFeld);
		for(Integer e : feld) {
			System.out.println(e);
		}
		
	}
	
	public class A<T> implements Iterable<T>{
		private T[] array;

		A(T[] array){
			this.array = array;
		}
		
		public Iterator<T> iterator() {
			return  new SkipIterator<T>();
		}
		
		class InnerIter<E> implements Iterator<E>{
			
			int pos;
			int max;
			InnerIter(){
				pos = 0;
				max = array.length;
			}
			
			public E next() {
				if(hasNext())
				return (E)array[pos++];
				return null;
			}
			
			public boolean hasNext() {
				return pos < max;
			}
		}
		
		class SkipIterator<E> extends InnerIter<E>{
			SkipIterator() {
				pos = 1;
			}
			public E next() {				
				if(hasNext()) {
					E temp = (E)array[pos];
					pos += 2;
					return temp;}
				return null;
			}
			public boolean hasNext() {
				return pos < max;
			}
		}
	}
	//class B extends A{};
    //class C extends A{};
	//class D extends C{};
	//class E{};
	
	public static <T> T f(T x, T y) {return null;};
	public static <T> T g(T[] x,T[] y) {return null;};
	public static <T> T[] h(T x, T[] y) { return null;}
}

