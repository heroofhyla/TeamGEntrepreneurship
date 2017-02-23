package teamg.entrepreneurship;

public class Game {
	public static void main(String[] args){
		Player.getInstance().setMoney(2000);
		System.out.println("You have $" + Player.getInstance().getMoney());
		
		ConsequenceCard c = new ConsequenceCard("Bad Luck", "You lost $500 for no reason.", ()->{
			Player.getInstance().addMoney(-500);
		});
		
		c.activate();
		
		System.out.println("You have $" + Player.getInstance().getMoney());
	}
}
