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
	List<ConsequenceCard> cards;
	Random rand = new Random();
	Deck deck;
	private Deck(){
		cards = new ArrayList<ConsequenceCard>();
	}
	
	public void add(ConsequenceCard card) {
		cards.add(card);
	}

	public ConsequenceCard draw() {
		return cards.remove(rand.nextInt(cards.size()));
	}
	
	public Deck getInstance(){
		if (deck == null){
			deck = new Deck();
		}
		return deck;
	}

}
