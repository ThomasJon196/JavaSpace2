import java.util.List;
import java.util.LinkedList;

public class Klassenhirarschie {
	class A{}
	class B{}
	class C extends B{};
	class D extends B{};
	class E extends D{};
	
	<T> T m1(T[] a, List<? extends T> f) {return null;}
	<T> T m2(List<? extends T> f1, List<? super T> f2) {return null;}
	
	public static void main(String[] args) {
		Klassenhirarschie x = new Klassenhirarschie();
		
		x.m1(new E[3], new LinkedList<C>());
		
		x.m2(new LinkedList<B>(), new LinkedList<B>());
	}
}
