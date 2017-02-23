package teamg.entrepreneurship;

public class ConsequenceCard{
	private String name;
	private String description;
	private Runnable effect;

	public ConsequenceCard(String name, String description, Runnable effect){
		this.name = name;
		this.description = description;
		this.effect = effect;
	}
	
	public String getName(){
		return name;
	}
	
	public String getDescription(){
		return description;
	}
	
	public void activate(){
		System.out.println(name);
		System.out.println(description);
		effect.run();
	}

}
