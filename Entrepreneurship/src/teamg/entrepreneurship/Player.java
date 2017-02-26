package teamg.entrepreneurship;

/**
 * A singleton that tracks the player's name, board position, and money.
 * @author Michael Stroud
 *
 */
public class Player {
	private int money;
	private String name;
	private double gainModifier = 1.0;
	private double lossModifier = 1.0;
	private Space position = null;
	private static Player player;
	private Player(){
		money = 0;
		name = "Player";
	}
	
	public int getMoney(){
		return money;
	}
	
	public void setMoney(int money){
		this.money = money;
	}
	
	public void addMoney(int delta){
		if (delta > 0){
			delta *= gainModifier;
			this.money += delta;
			System.out.println("Gained $" + delta + " (current money: $" + money + ")");
		}else{
			delta *= lossModifier;
			this.money += delta;
			System.out.println("Lost $" + -1*delta + " (current money: $" + money + ")");
		}
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public double getGainModifier(){
		return gainModifier;
	}
	
	
	public void setGainModifier(double gainModifier){
		this.gainModifier = gainModifier;
	}
	
	public void addGainModifier(double delta){
		this.gainModifier += delta;
	}
	public double getLossModifier(){
		return lossModifier;
	}
	
	public void setLossModifier(double lossModifier){
		this.lossModifier = lossModifier;
	}
	
	public void addLossModifier(double lossModifier){
		this.lossModifier += lossModifier;
	}
	
	public Space getPosition(){
		return position;
	}
	
	public void setPosition(Space position){
		this.position = position;
	}
	
	public int branchCount(){
		return this.position.getNextSpaces().size();
	}
	public void step(int branch){
		position = position.getNextSpaces().get(branch);
	}
	
	public static Player getInstance(){
		if (player == null){
			player = new Player();
		}
		return player;
	}
}
