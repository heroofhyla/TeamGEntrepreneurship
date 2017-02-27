package teamg.entrepreneurship;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Game {
	static Phase discoveryPhase;
	static Phase developmentPhase;
	static Phase resourcingPhase;
	static Phase harvestingPhase;
	static Phase beginPhase = new BeginPhase();
	static Phase managementPhase = new ManagementPhase();
	
	static{
		//Phase generation
		//In the final game, we wouldn't hard-code these in Java; we would define them in external text files (YAML format probably)
		discoveryPhase = new ChoicePhase("Discovery", "In this phase you will determine your business's niche.",Arrays.asList(new Choice[]{
			new Choice("Seek Expert Advice", "Expert advice will help you avoid classic mistakes.",
					Arrays.asList(new ConsequenceCard[]{
							new ConsequenceCard("Nothing New", "Your product isn't new or exciting. Gain 10% less money than usual this turn.",()->{
								Player.getInstance().addGainModifier(-0.1);
							}),
							new ConsequenceCard("Do this, not that.","Experience from the expert's past mistakes saves you time and money. Gain $1,000",()->{
								Player.getInstance().addMoney(1000);
							}),
							new ConsequenceCard("I know a guy.", "Thanks to your expert advice, you save some money. Lose 10% less money than usual this turn.",()->{
								Player.getInstance().addLossModifier(-0.1);
							}),
							new ConsequenceCard("Fool me twice.", "Expert advice leads to making the same mistakes they did. Lose $500",()->{
								Player.getInstance().addMoney(-500);
							}),
							new ConsequenceCard("Scam-Artist.", "Even the best get scammed. Lose $1,000.",()->{
								Player.getInstance().addMoney(-1000);
							}),
							new ConsequenceCard("I would've never thought of that.", "Expert produces great ideas. Gain $1,000.",()->{
								Player.getInstance().addMoney(1000);
							}),
							new ConsequenceCard("Communication is key.", "Expert is slow to respond, slowing the whole process. Gain 5% less money this turn.",()->{
								Player.getInstance().addGainModifier(-0.05);
							}),
							new ConsequenceCard("Partner.", "The best help can also become a great partner in your company, your profit increases. Gain 5%.",()->{
								Player.getInstance().addGainModifier(.05);
							})
					}),()->{
						//nothing
					}),
			new Choice("Customer Surveys", "Customer surveys will help you find the best product for your market. Cost to create survey $250",
					Arrays.asList(new ConsequenceCard[]{
							new ConsequenceCard("Survey", "Your company has recieved numerous surveys and have implemented the best ideas with positive feedback. Gain $1000.",()->{
								Player.getInstance().addMoney(1000);
							}),
							new ConsequenceCard("Price is right", "Surveys give insightful data on price point. Gain 10% increase profits this turn.",()->{
								Player.getInstance().addGainModifier(0.1);
							}),
							new ConsequenceCard("Expectation vs Reality", "Surveys are all talk. Gain 5% less profits this turn.",()->{
								Player.getInstance().addGainModifier(-0.05);
							}),
							new ConsequenceCard("Survey", "Your company has recieved numerous surveys and have implemented the best ideas with negative feedback. Lose $1000.",()->{
								Player.getInstance().addMoney(-1000);
							}),new ConsequenceCard("Wrong demographic", "Those chosen for the survey are not one who will use the product. Lose $1000.",()->{
								Player.getInstance().addMoney(-1000);
							}),
							new ConsequenceCard("Web Surveys", "Your surveys have been taken on multiple websites that has been implemented with positive results. Gain $1000.",()->{
								Player.getInstance().addMoney(1000);
							}),
							new ConsequenceCard("Hello fellow kids", "Your surveys reveal important features users want. Gain $500.",()->{
								Player.getInstance().addMoney(500);
							}),
							new ConsequenceCard("Web Surveys", "While having surveys on multiple website it still requires funds. Lose $500.",()->{
								Player.getInstance().addMoney(-500);
							})					
					}),()->{
						//Do Nothing					
					}),
			new Choice("Gut Instinct", "Following your gut will help you make a prdouct you're passionate about.",
					Arrays.asList(new ConsequenceCard[]{
							
					}),()->{
						
					})
	}));
		developmentPhase = new ChoicePhase("Business Plan", "In this phase you will choose what your business plan will be.",Arrays.asList(new Choice[]{
			new Choice("The customer is always right", "In this phase you will decide on what business plan you will you choice and how it will affect your customers experience. You recieve an added bonus of $3,500.", 
					Arrays.asList(new ConsequenceCard[]{
							new ConsequenceCard("Customer Satisfaction", "Overal customers are satisfied with your company since you pay attention to concerns and issues. Gain $500.",()->{
								Player.getInstance().addMoney(500);
							}),
							new ConsequenceCard("Continues Inprovements", "You continously make improvements but your customers are never happy, Lose $750.",()->{
								Player.getInstance().addMoney(-750);
							}),
							new ConsequenceCard("Positive Feedback", "Feedback has been given on the companies satisfaction rating with an overall positive result. Gain $1000.",()->{
								Player.getInstance().addMoney(1000);
							}),
							new ConsequenceCard("Negative Feedback", "Feedback has been given on the companies satisfaction rating with an overall negative result. Lose $1000.",()->{
								Player.getInstance().addMoney(-1000);
							})
					}), ()->{
						//Do Nothing
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
						Player.getInstance().addLossModifier(-.02);
					}),
			new Choice("A penny saved is a penny earned", "Money not spent is money that is in one's pocket. Gain $5,000",
					Arrays.asList(new ConsequenceCard[]{
							new ConsequenceCard("Needed Upgrades", "You have been able to upgrade your equipment with no extra cost since with your savings. Your profits increase 5%.",()->{
								Player.getInstance().addGainModifier(.05);
							}),
							new ConsequenceCard("Repair Cost", "Repairs are becoming more increasing and a financial burden as well. Lose $1,500",()->{
								Player.getInstance().addMoney(-1500);
							}),
							new ConsequenceCard("Cheapskate", "Your business has took a toll on employee and customer satisfaction due to your need to hold out on anything requiring money. \nLose 15% extra whenever you lose money this turn.",()->{
								Player.getInstance().addLossModifier(.15);
							}),
							new ConsequenceCard("Market Crash", "The market crashes and all that cash you saved loses value. Lose 25% of all assets",()->{
								double result = Player.getInstance().getMoney()*.75;
								Player.getInstance().setMoney((int)result);
							})
					}),()->{
						Player.getInstance().addMoney(5000);
					})
			
	}));
		resourcingPhase = new ChoicePhase("Resourcing", "In this phase you will choose how to fund your business.",Arrays.asList(new Choice[]{
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
						Player.getInstance().addMoney(10000);
					}),
			new Choice("Take Out a Loan", "The bank offers you a $20000 loan at 7% APR",	
					Arrays.asList(new ConsequenceCard[]{
							new ConsequenceCard("Loan Payment Due", "You pay back $200 on your loan.",()->{
								Player.getInstance().addMoney(-200);
							}),
							new ConsequenceCard("Interest", "Lose an extra 10% whenever you lose money this turn.",()->{
								Player.getInstance().addLossModifier(0.1);
							}),
							new ConsequenceCard("Bad Credit", "Lose an extra 25% whenever you lose money this turn..",()->{
								Player.getInstance().addLossModifier(.25);
							}),
							new ConsequenceCard("Excellent Credit", "Lose 4% less whenever you lose money this turn.",()->{
								Player.getInstance().addLossModifier(-0.04);
							})
					}),()->{
						Player.getInstance().addMoney(20000);
						Player.getInstance().addLossModifier(.07);				
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
						Player.getInstance().addMoney(5000);
					})
	}));
	
		harvestingPhase = new ChoicePhase("Harvesting", "You have been developing your business for a while, and you're itching for a change.",Arrays.asList(new Choice[]{
			new Choice("Grow your business", "You decide to develop a new product in order to grow your business.", Arrays.asList(new ConsequenceCard[]{
					}), ()->{
						//nothing
					}),
			new Choice("Cash Out (This will end the game)", "You decide that you want to move on with your life.",	
					Arrays.asList(new ConsequenceCard[]{
					}),()->{
						signalGameEnd();
					}),
	}));
		
		beginPhase.setNextPhase(discoveryPhase);
		discoveryPhase.setNextPhase(developmentPhase);
		developmentPhase.setNextPhase(resourcingPhase);		
		resourcingPhase.setNextPhase(managementPhase);
		managementPhase.setNextPhase(harvestingPhase);
		harvestingPhase.setNextPhase(discoveryPhase);
		//call random events
		randEvents();
	}
	

	//Method for creating and adding random events to deck.
	private static void randEvents(){
		//variables
		List<ConsequenceCard> consequence = new ArrayList<ConsequenceCard>();
		Player effect = Player.getInstance();

		//Create random events
		consequence.add(new ConsequenceCard("Car Payment", "You wind up having to take $500 from the company to pay a car payment.",()->effect.addMoney(500)));
		consequence.add(new ConsequenceCard("Pay Day", "Its pay day, collect $1500.",()->effect.addMoney(1500)));
		consequence.add(new ConsequenceCard("Broken Main", "Unfortunate events, pay $1,500 to repairs.",()->effect.addMoney(1500)));
		consequence.add(new ConsequenceCard("Law Suits", "Dang, you just got a lawsuit. Pay $2,500 to settle.",()->effect.addMoney(-2500)));
		consequence.add(new ConsequenceCard("Hire Employee", "Hiring a new employee isn't cheap. Lose $2,500",()->effect.addMoney(-2500)));
		consequence.add(new ConsequenceCard("Business as Usual", "Usual business of the day recieve a bonus payment of $500.",()->effect.addMoney(500)));
		
		//add to deck
		Deck.getInstance().addAll(consequence);
	}
	
	public static void signalGameEnd(){
		System.out.println("You finish your entrepreneurial adventure with $" + Player.getInstance().getMoney());
		System.exit(0);
	}
	
	public static void main(String[] args){
		
		Phase currentPhase = beginPhase;
		
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
