package teamg.entrepreneurship;

import java.util.Arrays;

public class Game {
	public static void main(String[] args){
		ChoicePhase resourcingPhase = new ChoicePhase("Resourcing", "In this phase you will lorem ipsum.",Arrays.asList(new Choice[]{
				new Choice("Seek Investors", "You have found some investors. They give you $10000 with which to start your company.", 
						Arrays.asList(new ConsequenceCard[]{
								new ConsequenceCard("Bossy Investor", "An investor sabotages you because you didn't listen to his advice. Lose $200.",()->{
									Player.getInstance().addMoney(-200);
								}),
								new ConsequenceCard("Helpful Advice", "An investor sees you making a common mistake, and corrects the problem. Gain $500.",()->{
									Player.getInstance().addMoney(500);
								})
						}), ()->{
							Player.getInstance().setMoney(10000);
						}),
				new Choice("Take Out a Loan", "The bank offers you a $20000 loan.",	
						Arrays.asList(new ConsequenceCard[]{
								new ConsequenceCard("Loan Payment Due", "You pay back $200 on your loan.",()->{
									Player.getInstance().addMoney(-200);
								})
						}),()->{
							Player.getInstance().setMoney(20000);
						})
				
		}));
		
		System.out.println(resourcingPhase.getName());
		System.out.println(resourcingPhase.getDescription());
		System.out.println("Choices:");
		for(Choice c: resourcingPhase.getChoices()){
			System.out.println(" * " + c.getName());
		}
		System.out.print(">> ");
		resourcingPhase.getChoices().get(0).activate();
		System.out.println("Drawing...");
		Deck.getInstance().draw().activate();
		System.out.println("Drawing...");
		Deck.getInstance().draw().activate();
	}
}
