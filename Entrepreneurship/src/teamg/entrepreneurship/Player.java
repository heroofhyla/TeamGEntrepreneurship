package teamg.entrepreneurship;

/**
 * A singleton that tracks the player's name, board position, and money.
 * @author Michael Stroud
 *
 */
public class Player {
	private int position;
	private int money;
	private String name;
	private static Player player;
	private Player(){
		position = 0;
		money = 0;
		name = "Player";
	}
	
	public int getPosition(){
		return position;
	}
	
	public void setPosition(int position){
		this.position = position;
	}
	
	public void addPosition(int delta){
		this.position += delta;
	}
	
	public int getMoney(){
		return money;
	}
	
	public void setMoney(int money){
		this.money = money;
	}
	
	public void addMoney(int delta){
		this.money += delta;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public static Player getInstance(){
		if (player != null){
			player = new Player();
		}
		return player;
	}
}
