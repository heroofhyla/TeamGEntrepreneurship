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
							}),
							new ConsequenceCard("Survey", "Your company has recieved numerous surveys and have implemented the best ideas with positive feedback. Gain $1000.",()->{
								Player.getInstance().addMoney(1000);
							}),
							new ConsequenceCard("Survey", "Your company has recieved numerous surveys and have implemented the best ideas with negative feedback. Lose $1000.",()->{
								Player.getInstance().addMoney(-1000);
							})
					}), ()->{
						Player.getInstance().setMoney(5000);
					}),
			new Choice("Advertising is key", "The idea of selling and promoting your product isn't new and of course it isn't free, Lose 2% of income to fund Advertising Dept.",	
					Arrays.asList(new ConsequenceCard[]{
							new ConsequenceCard("In Demand", "Successful advertisment has led to your product being constantly sold out, Gain $3,000.",()->{
								Player.getInstance().addMoney(3000);
							}),
							new ConsequenceCard("Slow Sales", "Your attempts at advertising has backfired and as a result lose $2,000 .",()->{
								Player.getInstance().addMoney(-2000);
							}),
							new ConsequenceCard("In Demand", "Unsuccessful advertisment has led to your product not being sold and stores not ordering, Lose $3,000.",()->{
								Player.getInstance().addMoney(-3000);
							}),
							new ConsequenceCard("Sales Up", "Your sales are skyrocketing and hitting new records. Gain $2,000 .",()->{
								Player.getInstance().addMoney(2000);
							})
					}),()->{
						Player.getInstance().addLossModifier(.02);
					}),
			new Choice("A penny saved is a penny earned", "Money not spent is money that is in one's pocket. Gain $5,000",
					Arrays.asList(new ConsequenceCard[]{
							new ConsequenceCard("Needed Upgrades", "You have been able to upgrad your equipment with no extra cost since with your savings. Your profits increase 5%.",()->{
								Player.getInstance().addGainModifier(.05);
							}),
							new ConsequenceCard("Repair Cost", "Repairs are becoming more increasing and a financial burden as well. Lose $1,500",()->{
								Player.getInstance().addMoney(-1500);
							}),
							new ConsequenceCard("Cheapskate", "Your business has took a toll on employee and customer satisfaction due to your need to hold out on anything requiring money. Lose 15%.",()->{
								Player.getInstance().addLossModifier(.15);
							}),
							new ConsequenceCard("Market Crash", "The market crashes and all that cash you saved loses value. Lose 25%",()->{
								double result = Player.getInstance().getMoney()*.75;
								Player.getInstance().setMoney((int)result);
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
							}),
							new ConsequenceCard("Impressive Proposal", "Your idea is impressive and has caught the eye of many investors allowing you to gain their trust and most importantly their financial backing. Gain $15000.",()->{
								Player.getInstance().addMoney(15000);
							}),
							new ConsequenceCard("Silent Ears", "Your idea is not unique enough and has given most investors doubts about giving you financial backings. Get a bank loan of $5,000 with -5%.",()->{
								Player.getInstance().addMoney(-5000);
								Player.getInstance().addLossModifier(.05);
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
							}),
							new ConsequenceCard("Bad Credit", "Lose an extra 25%.",()->{
								Player.getInstance().addLossModifier(.25);
							}),
							new ConsequenceCard("Excellent Credit", "Secure an interest rate of 4% whenever you lose money this turn.",()->{
								Player.getInstance().addGainModifier(0.04);
							})
					}),()->{
						Player.getInstance().setMoney(20000);
					}),
			new Choice("Pay out of Pocket", "You fund your venture out of your own pocket. You only have $5000.",
					Arrays.asList(new ConsequenceCard[]{
//							new ConsequenceCard("Car Payment", "You wind up having to take $500 from the company to pay a car payment.",()->{
//								Player.getInstance().addMoney(-500);
//							}),
//							new ConsequenceCard("Birthday Cash", "Your mom gives you $50 for your birthday. Nice!",()->{
//								Player.getInstance().addMoney(50);
//							}),
							randEvents()
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

	static ConsequenceCard randEvents()
	{
		ConsequenceCard consequence;
		Player effect = Player.getInstance();
		int roll = Die.roll();
		
		switch(roll){
			
			case 1 :	consequence = 
						new ConsequenceCard("Car Payment", "You wind up having to take $500 from the company to pay a car payment.",()->effect.addMoney(500));
						break;
			case 2 :	consequence = 
						new ConsequenceCard("Pay Day", "Its pay day, collect $1500.",()->effect.addMoney(1500));
						break;
			case 3 :	consequence = 
						new ConsequenceCard("Broken Main", "Unfortunate events, pay $1,500 to repairs.",()->effect.addMoney(1500));
						break;
			case 4 :	consequence = 
						new ConsequenceCard("Law Suits", "Dang, you just got a lawsuit. Pay $1,500 to settle.",()->effect.addMoney(-1500));
						break;
			default :	consequence = 
						new ConsequenceCard("Business as Usual", "Usual business of the day recieve a payment of $500.",()->effect.addMoney(500));
						break; 
		}
		
		return consequence;
		
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
