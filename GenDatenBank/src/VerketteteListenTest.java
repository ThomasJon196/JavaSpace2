
public class VerketteteListenTest {
	public static void main(String[] args) {
		DBEVL<Tier> evlDB = new DBEVL<>();
		
		evlDB.appendLast(new Igel(10, 10));
		evlDB.appendLast(new Katze(20, 20));
		evlDB.appendLast(new Katze(30, 30));
		evlDB.insert(new Igel(40, 40), 4);
		
		System.out.println(evlDB.removeLast());
		System.out.println(evlDB.pFirst.pNext.pNext.element);
	}
}
