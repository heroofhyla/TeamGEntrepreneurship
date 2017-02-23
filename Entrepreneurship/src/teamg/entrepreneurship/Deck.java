package teamg.entrepreneurship;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A singleton that stores Consequence Cards and serves them in a random order.
 * @author Michael Stroud
 *
 */
public class Deck{
	private List<ConsequenceCard> cards;
	private Random rand = new Random();
	private static Deck deck;
	private Deck(){
		cards = new ArrayList<ConsequenceCard>();
	}
	
	public void addAll(List<ConsequenceCard> cards) {
		this.cards.addAll(cards);
	}

	public ConsequenceCard draw() {
		return cards.remove(rand.nextInt(cards.size()));
	}
	
	public static Deck getInstance(){
		if (deck == null){
			deck = new Deck();
		}
		return deck;
	}

}
