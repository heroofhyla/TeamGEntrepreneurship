package teamg.entrepreneurship;

import java.util.Random;

public class Die{
	private static Random rand;
	static{
		rand = new Random();
	}

	public static int roll() {		
		return rand.nextInt(6) + 1;
	}

}
