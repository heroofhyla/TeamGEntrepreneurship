package teamg.entrepreneurship;

import java.util.List;
import java.util.Scanner;

public class ChoicePhase implements Phase{
	Scanner scanner = new Scanner(System.in);
	private String name;
	private String description;
	private List<Choice> choices;
	private Phase nextPhase;
	
	public ChoicePhase(String name, String description, List<Choice> choices){
		this.name = name;
		this.description = description;
		this.choices = choices;
	}
	
	public String getName(){
		return name;
	}
	
	public String getDescription(){
		return description;
	}
	
	public List<Choice> getChoices(){
		return choices;
	}

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
		System.out.println(name);
		System.out.println(description);
		System.out.println();
		System.out.println("Available choices:");
		for (int i = 0; i < choices.size(); i++){
			System.out.println((i+1) + ") " + choices.get(i).getName());
		}
		System.out.print(">>");
		System.out.flush();
		int choice = scanner.nextInt();
		scanner.nextLine();//clear input buffer
		choices.get(choice-1).activate();
		System.out.println();//Provide space
	}
}
