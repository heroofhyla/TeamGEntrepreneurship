package teamg.entrepreneurship;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Space {
	public static final Color YELLOW = new Color(255,255,0);
	public static final Color DARK_RED = new Color(128,0,0);
	public static final Color BRIGHT_RED = new Color(255,0,0);
	public static final Color DARK_GREEN = new Color(0,128,0);
	public static final Color BRIGHT_GREEN = new Color(0,255,0);
	
	private List<Space> nextSpaces;
	private Runnable effect;
	private Color color;
	
	public Space (Color color, List<Space> nextSpaces, Runnable effect){
		this.color = color;
		this.setNextSpaces(nextSpaces);
		this.effect = effect;
	}
	
	public List<Space> getNextSpaces() {
		return nextSpaces;
	}
	
	public void setNextSpaces(List<Space> nextSpaces) {
		if (nextSpaces == null){
			nextSpaces = new ArrayList<Space>();
		}
		this.nextSpaces = nextSpaces;
	}
	public void activate(){
		effect.run();
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public List<Space> getTails(){
		return getTails(new ArrayList<Space>(nextSpaces));
	}
	
	private List<Space> getTails(List<Space> currentPositions){
		
		boolean done = true;
		ListIterator<Space> iter = currentPositions.listIterator();
		while(iter.hasNext()){
			Space space = iter.next();
			if (space.nextSpaces.size() > 0){
				done = false;
				for (Space newSpace: space.nextSpaces){
					iter.add(newSpace);
				}
				iter.remove();
			}
		}
		if (done){
			return currentPositions;
		}
		return getTails(currentPositions);
	}
	public static Space createNoEffectSpace(){
		return new Space(YELLOW,null,() -> System.out.println("No effect."));
	}
	
	public static Space createSmallProfitSpace(){
		return new Space(DARK_GREEN,null,() -> {
			Player.getInstance().addMoney(200);
			});
	}
	
	public static Space createLargeProfitSpace(){
		return new Space(BRIGHT_GREEN,null,() -> {
			Player.getInstance().addMoney(500);
			});
	}
	
	public static Space createSmallLossSpace(){
		return new Space(DARK_RED,null,() -> {
			Player.getInstance().addMoney(-200);
			});
	}
	
	public static Space createLargeLossSpace(){
		return new Space(BRIGHT_RED,null,() -> {
			Player.getInstance().addMoney(-500);
			});
	}
}

