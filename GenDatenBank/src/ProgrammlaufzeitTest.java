
public class ProgrammlaufzeitTest {
	public static void main(String[] args) {
		final long programStartTime = System.currentTimeMillis();
		
		Igel[] igelfeld = new Igel[10_000_000];
		for(int i=0; i<10_000_000; i++) {
			igelfeld[i] = new Igel(10, 10);
		}
		
		//--------------------------------------------------------------------//
		// DBFeldFix
		
		final long startTimeFix = System.currentTimeMillis();
		
		DB<Tier> dbfeld = new DBFeldFix<>(10_000_000);
		for(int i=0; i<10_000_000; i++) {
			dbfeld.appendLast(igelfeld[i]);
		}
		while(!dbfeld.isEmpty()) {
			dbfeld.removeLast();
		}
		
		final long endTimeFix = System.currentTimeMillis();
		System.out.println("Programmlaufzeit für FeldFix: " + (endTimeFix-startTimeFix) + " ms");
		
		//--------------------------------------------------------------------//
		// dynamische Datenbank
		
		final long startTimeDyn = System.currentTimeMillis();
		
		DBFeldDyn<Tier> dbDyn = new DBFeldDyn<>();
		for(int i=0; i<1000000; i++) {
			dbDyn.appendLast(igelfeld[i]);
		}
		for(int i=0; i<1000000; i++) {
			dbDyn.removeLast();
		}
		
		final long endTimeDyn = System.currentTimeMillis();
		System.out.println("Programmlaufzeit für DBFeldDyn: " + (endTimeDyn-startTimeDyn) + " ms");
		
		//--------------------------------------------------------------------//
		// Stack
		final long startTimeStack = System.currentTimeMillis();
		
		DBStack<Tier> dbStack = new DBStack<>();
		for(int i=0; i<10_000_000; i++) {
			dbStack.appendLast(igelfeld[i]);
		}
		while(!dbDyn.isEmpty()) {
			dbStack.removeLast();
		}
		
		final long endTimeStack = System.currentTimeMillis();
		System.out.println("Programmlaufzeit für DBStack: " + (endTimeStack-startTimeStack) + " ms");
		
		
		final long programEndTime = System.currentTimeMillis();
		System.out.println("Finish...Time: " + (programEndTime-programStartTime) + " ms");
	}
}
