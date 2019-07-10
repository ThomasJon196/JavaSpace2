import java.util.*;

public class DBFeldMain {
	
	public static void main(String[] args) {
		
		Tier[] tierfeld = {new Igel(20, 20), new Amsel(30, 30), new Katze(10, 10), null};
		
		DBTiere<Tier> tierDB = new DBTiere<>(tierfeld);
		tierDB.appendLast(new Amsel(10, 10));
		
		System.out.println("Dickster Igel: " + DBTiere.maxWeightnonit(tierDB));
		
		/*Iterator it = tierDB.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().toString());
		}
		*/
		
		// oder
		/* Schleife über erweitertes for
		for(Tier tier : tierDB)
			System.out.println(tier.toString());
		
		System.out.println(DBFeldFix.maxWeight(tierDB));
		System.out.println(DBFeldFix.maxWeight2(tierDB));
		*/
		System.out.println("Größtes Tier: " + DBUtil.min(tierDB).size());
		System.out.println("1.Tier: " + tierDB.get(1));
		tierDB.sort(new ComparatorSize<Tier>());
		System.out.println("1.Tier nach sortieren: " +  tierDB.get(1));
		
		
		DBIF<Tier> tierDB2 = new DBStack<>(); // Nur Sugriff auf die Methoden die auch in DBIF deklariert wurden!
		DBStack<Tier> tierDB3 = new DBStack<>();
		
		DBFeldFix.printAll(tierDB);
	}
}
