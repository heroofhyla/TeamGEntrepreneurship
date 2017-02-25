package teamg.entrepreneurship;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ManagementPhase implements Phase{
	
	Scanner userIn = new Scanner(System.in);
	private Space firstSpace;

	public ManagementPhase(){

		//board generation
		Space currentSpace = Space.createNoEffectSpace();
		firstSpace = currentSpace;
		currentSpace = buildSpaceChain(Die.roll() + 8, currentSpace);
		currentSpace.setNextSpaces(Arrays.asList(new Space[]{
				buildSpaceChain(Die.roll()+5,Space.createNoEffectSpace()),
				buildSpaceChain(Die.roll()+5,Space.createLargeProfitSpace()),
		}));
		List<Space> tails = currentSpace.getTails();
		currentSpace = mergeSpaceChains(Space.createNoEffectSpace(), tails);
		currentSpace = buildSpaceChain(Die.roll()+5, currentSpace);
		
		Player.getInstance().setPosition(firstSpace);
	}
	
	/**
	 * Generates a chain of spaces, of random types
	 * @param length Number of spaces in the chain
	 * @param firstSpace Reference to first space in chain
	 * @return Reference to last space in chain
	 */
	private Space buildSpaceChain(int length, Space initialSpace){
		Space currentSpace = initialSpace;
		for (int i = 0; i < length; i++){
			int type = Die.roll();
			Space nextSpace;
			switch (type){
			case 1:
				nextSpace = Space.createLargeLossSpace();
				break;
			case 2:
				nextSpace = Space.createSmallLossSpace();
				break;
			case 3:
				nextSpace = Space.createLargeProfitSpace();
				break;
			case 4:
				nextSpace = Space.createSmallProfitSpace();
				break;
			default:
				nextSpace = Space.createNoEffectSpace();
				break;
			}
			currentSpace.setNextSpaces(Arrays.asList(new Space[]{nextSpace}));
			currentSpace = nextSpace;
		}
		return currentSpace;
	}
	/**
	 * 
	 * @param mergePoint The Space that all other spaces merge to
	 * @param spaces One or more Spaces that should have their next Space set to mergePoint
	 * @return the mergePoint
	 */
	private Space mergeSpaceChains(Space mergePoint, List<Space> spaces){
		for (Space space: spaces){
			space.setNextSpaces(Arrays.asList(new Space[]{mergePoint}));
		}
		return mergePoint;
	}
	
	private Phase nextPhase;
	@Override
	public Phase getNextPhase() {
		return nextPhase;
	}

	@Override
	public void setNextPhase(Phase nextPhase) {
		this.nextPhase = nextPhase;
	}

	@Override
	public void process() {
		boolean done = false;
		System.out.println("Business Management");
		System.out.println("In this phase you will actually run your company. \n"
		                  +"For the purposes of simulation, the phase is modeled after a board game. \n"
		                  + "Each turn, you will draw a Consequence Card, and then roll to move.\n"
		                  + "The consequence card will have an effect such as immediately causing\n"
		                  + "you to gain or lose money, or adjusting your money multiplier for the \n"
		                  + "turn. As you move around the board, each space you TOUCH (not simply end \n"
		                  + "your turn on) will trigger, potentially causing you to gain or lose\n"
		                  + "money.");
		System.out.println();
		System.out.println("Press ENTER to begin.");
		userIn.nextLine();
		while (!done){
			System.out.println("Turn start.");
			Player.getInstance().setGainModifier(1);
			Player.getInstance().setLossModifier(1);
			System.out.println("Press ENTER to draw.");
			userIn.nextLine();
			System.out.println("Drew a card:");
			Deck.getInstance().draw().activate();
			System.out.print("Current money: $");
			System.out.println(Player.getInstance().getMoney());
			System.out.println("Press ENTER to roll.");
			userIn.nextLine();
			System.out.print("Rolling...");
			int roll = Die.roll();
			System.out.println(roll);
			System.out.println("Press ENTER to begin moving.");
			userIn.nextLine();
			while (roll > 0 && !done){
				if (Player.getInstance().branchCount() == 0){
					System.out.println("Reached the end of the board.");
					done = true;
				}else if (Player.getInstance().branchCount() == 1){
					System.out.println("Took a step.");
					Player.getInstance().step(0);
					Player.getInstance().getPosition().activate();
					roll--;
				}else{
					System.out.println("Branch. What way will you go next?");
					System.out.print("<");
					for (int i = 0; i < Player.getInstance().branchCount(); i++){
						System.out.print(i+1);
						if (i < Player.getInstance().branchCount()-1){
							System.out.print(", ");
						}
					}
					System.out.println(">");
					int choice = userIn.nextInt() - 1;
					userIn.nextLine();//flush input
					Player.getInstance().step(choice);
					Player.getInstance().getPosition().activate();
					roll--;
				}
			}
		}
	}

}
