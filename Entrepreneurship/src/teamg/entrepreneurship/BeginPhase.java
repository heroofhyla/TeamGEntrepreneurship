package teamg.entrepreneurship;

import java.util.Scanner;

public class BeginPhase implements Phase{
	Scanner userIn = new Scanner(System.in);
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
		System.out.println("Entrepreneurship Simulator");
		System.out.println("SER315 Spring A Team G Project");
		System.out.println("Press ENTER to begin.");
		userIn.nextLine();
	}

}
