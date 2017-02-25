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
	static Phase developmentPhase = new ChoicePhase("Business Plan", "In this phase you will choose what your business plan will be.",Arrays.asList(new Choice[]{
			new Choice("The customer is always right", "In this phase you will decide on what business plan you will you choice and how it will affect your customers experience. You recieve an added bonus of $5,000.", 
					Arrays.asList(new ConsequenceCard[]{
							new ConsequenceCard("Customer Satisfaction", "Overal customers are satisfied with your company since you pay attention to concerns and issues. Gain $500.",()->{
								Player.getInstance().addMoney(500);
							}),
							new ConsequenceCard("Continues Inprovements", "You continously make improvements but your customers are never happy, Lose $750.",()->{
								Player.getInstance().addMoney(-750);
							})
					}), ()->{
						Player.getInstance().setMoney(5000);
					}),
			new Choice("Advertising is key", "The idea of selling and promoting your product isn't new and of course it isn't free, Lose 2% of income to fund Advertising Dept.",	
					Arrays.asList(new ConsequenceCard[]{
							new ConsequenceCard("In Demand", "Successfule advertisment has led to your product being constantly sold out, Gain $3,000.",()->{
								Player.getInstance().addMoney(3000);
							}),
							new ConsequenceCard("Slow Sales", "Your attempts at advertising has backfired and as a result lose $2,000 .",()->{
								Player.getInstance().addMoney(-2000);
							})
					}),()->{
						Player.getInstance().addGainModifier(.02);
					}),
			new Choice("A penny saved is a penny earned", "Money not spent is money that is in one's pocket.",
					Arrays.asList(new ConsequenceCard[]{
							new ConsequenceCard("Needed Upgrades", "You have been able to upgrad your equipment with no extra cost since with your savings. Your profits increase 5%.",()->{
								Player.getInstance().addMoney(-500);
							}),
							new ConsequenceCard("Birthday Cash", "Your mom gives you $50 for your birthday. Nice!",()->{
								Player.getInstance().addGainModifier(.05);
							})
					}),()->{
						Player.getInstance().setMoney(5000);
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
					})
			
	}));
	
	
	static Phase managementPhase = new ManagementPhase();
	static{
		discoveryPhase.setNextPhase(developmentPhase);
		developmentPhase.setNextPhase(resourcingPhase);		
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
