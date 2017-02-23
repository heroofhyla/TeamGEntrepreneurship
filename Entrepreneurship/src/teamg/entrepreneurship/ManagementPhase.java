package teamg.entrepreneurship;

public class ManagementPhase implements Phase{

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
		for (int i = 0; i < 3; i++){
			System.out.println("Turn start.");
			Player.getInstance().setGainModifier(1);
			Player.getInstance().setLossModifier(1);
			System.out.print("Current money: $");
			System.out.println(Player.getInstance().getMoney());
			System.out.println("Drew a card:");
			Deck.getInstance().draw().activate();
		}
	}

}
