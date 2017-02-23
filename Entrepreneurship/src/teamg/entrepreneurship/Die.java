package teamg.entrepreneurship;

import java.util.Random;

/**
 * Provides simple random number generation for a six-sided die
 * @author Michael Stroud
 *
 */
public class Die{
	private static Random rand;
	static{
		rand = new Random();
	}

	public static int roll() {		
		return rand.nextInt(6) + 1;
	}

}
