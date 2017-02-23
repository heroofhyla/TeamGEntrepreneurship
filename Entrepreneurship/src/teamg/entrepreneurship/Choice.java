package teamg.entrepreneurship;

import java.util.List;

public class Choice {
	private String name;
	private String description;
	
	private List<ConsequenceCard> cards;
	private Runnable immediateConsequence;
	public Choice(String name, String description, List<ConsequenceCard> cards, Runnable immediateConsequence){
		this.name = name;
		this.description = description;
		this.cards = cards;
		this.immediateConsequence = immediateConsequence;
	}
	
	public void activate(){
		System.out.println(name);
		System.out.println(description);
		Deck.getInstance().addAll(cards);
		immediateConsequence.run();
	}
	
	public String getName(){
		return name;
	}
	
	public String getDescription(){
		return description;
	}

}
