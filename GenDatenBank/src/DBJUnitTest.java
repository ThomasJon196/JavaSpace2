import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.Iterator;

class DBJUnitTest {

	@Test // Testet die DB auf Gleichheit vor und nach der Iteration
	void test1() {
		Igel[] igelfeld = new Igel[100];
		for(int i=0; i<10; i++) {
			igelfeld[i] = new Igel(i+5, i+10);
		}
		DBTiere<? extends Tier> igelDB = new DBTiere<>(igelfeld);
		
		
		int count = 0;
		for(Tier e : igelDB) {
			assertEquals(e, igelfeld[count++], "DB Objects are not equal!");
		}
		
		Iterator<? extends Tier> it = igelDB.iterator();
		/* Iteration without the extended for loop and from back to front
		while(it.hasNext()) {
			System.out.println(it.next().toString());
		}
		
		*/ // Assert the the db didnt chage after iteration
		//assertEquals(igelfeld, igelDB.db, "DB was changed after iteration!");
	}
	
	@Test
	void test2() { // Testen auf die sortierdauer bei 500 Objekten
		
		Tier[] tierfeld = new Tier[500];
		DBTiere<Tier> tierDB = new DBTiere<>(tierfeld);
		int size, weight;
		Igel igelTemp;
		
		System.out.println("First 5 Objects:\n");
		for(int i=0; i<500; i++) {
			size = (int)(Math.random() * 50) + 10;
			weight = (int)(Math.random() * 100) + 20;
			igelTemp = new Igel(size, weight);
			tierDB.appendLast(igelTemp);
		}
		Iterator<Tier> tierIter = tierDB.iterator();
		for(int i=0; i<5; i++) {
			igelTemp = (Igel)tierIter.next();
			System.out.println("Size: "+igelTemp.size()+", Weight: "+igelTemp.weight());
		}
		System.out.println("After sorting: \n");
		
		final long startTime = System.currentTimeMillis();
		tierDB.sort(new ComparatorSize<>());
		final long endTime = System.currentTimeMillis();
		
		tierIter = tierDB.iterator();
		for(int i=0; i<5; i++) {
			igelTemp = (Igel)tierIter.next();
			System.out.println("Size: "+igelTemp.size()+", Weight: "+igelTemp.weight());
		}
		System.out.println("Sort Time(in ms): " + (endTime-startTime));
		
	}

}
