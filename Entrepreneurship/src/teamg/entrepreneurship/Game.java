package teamg.entrepreneurship;

import java.util.Arrays;

public class Game {
	static Phase discoveryPhase = new ChoicePhase("Discovery", "In this phase you will determine your business's niche.",Arrays.asList(new Choice[]{
			new Choice("Seek Expert Advice", "Expert advice will help you avoid classic mistakes.",
					Arrays.asList(new ConsequenceCard[]{
							new ConsequenceCard("Nothing New", "Your product isn't new or exciting. Gain 10% less money than usual this turn.",()->{
								Player.getInstance().addGainModifier(-0.1);
							}),
							new ConsequenceCard("I know a guy.", "Thanks to your expert advice, you save some money. Lose 10% less money than usual this turn.",()->{
								Player.getInstance().addLossModifier(-0.1);
							})
					}),()->{
						//nothing
					}),
			new Choice("Customer Surveys", "Customer surveys will help you find the best product for your market.",
					Arrays.asList(new ConsequenceCard[]{
							
					}),()->{
						
					}),
			new Choice("Gut Instinct", "Following your gut will help you make a prdouct you're passionate about.",
					Arrays.asList(new ConsequenceCard[]{
							
					}),()->{
						
					})
	}));
	static Phase resourcingPhase = new ChoicePhase("Resourcing", "In this phase you will choose how to fund your business.",Arrays.asList(new Choice[]{
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
							}),
							new ConsequenceCard("Interest", "Lose an extra 10% whenever you lose money this turn.",()->{
								Player.getInstance().addLossModifier(0.1);
							})
					}),()->{
						Player.getInstance().setMoney(20000);
					}),
			new Choice("Pay out of Pocket", "You fund your venture out of your own pocket. You only have $5000.",
					Arrays.asList(new ConsequenceCard[]{
							new ConsequenceCard("Car Payment", "You wind up having to take $500 from the company to pay a car payment.",()->{
								Player.getInstance().addMoney(-500);
							}),
							new ConsequenceCard("Birthday Cash", "Your mom gives you $50 for your birthday. Nice!",()->{
								Player.getInstance().addMoney(50);
							})
					}),()->{
						Player.getInstance().setMoney(5000);
					}
			)
			
	}));
	
	static Phase managementPhase = new ManagementPhase();
	static{
		discoveryPhase.setNextPhase(resourcingPhase);
		resourcingPhase.setNextPhase(managementPhase);
		
	}
	public static void main(String[] args){
		
		Phase currentPhase = discoveryPhase;
		
		boolean gameOver = false;
		while(!gameOver){
			currentPhase.process();
			if (currentPhase.getNextPhase() == null){
				gameOver = true;
			}else{
				currentPhase = currentPhase.getNextPhase();
			}
		}
	}
}
