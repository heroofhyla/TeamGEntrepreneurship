package teamg.entrepreneurship;

import java.awt.Color;
import java.util.List;

public class Space {
	private List<Space> nextSpaces;
	private Runnable effect;
	private Color color;
	
	public Space (List<Space> nextSpaces, Runnable effect){
		this.setNextSpaces(nextSpaces);
		this.effect = effect;
	}
	
	public List<Space> getNextSpaces() {
		return nextSpaces;
	}
	
	public void setNextSpaces(List<Space> nextSpaces) {
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
}

