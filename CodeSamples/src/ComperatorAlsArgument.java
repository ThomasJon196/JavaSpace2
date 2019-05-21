//import java.util.*;

public class ComperatorAlsArgument {

	public static <T extends Comparable> void printLess(T c1, T c2) {
		System.out.println(c1.compareTo(c2) < 0 ? c1 : c2);
	}
	
	public static void main(String[] args) {
		Integer i = new Integer(42);
		Double d = new Double(47.11);
		printLess(i, d);
	}
}