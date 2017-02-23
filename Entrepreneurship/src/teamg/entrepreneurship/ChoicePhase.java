package teamg.entrepreneurship;

import java.util.List;

public class ChoicePhase {
	private String name;
	private String description;
	private List<Choice> choices;
	
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
}
