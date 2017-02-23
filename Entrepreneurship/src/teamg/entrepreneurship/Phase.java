package teamg.entrepreneurship;

public interface Phase {
	public Phase getNextPhase();
	public void setNextPhase(Phase nextPhase);
	public void process();
}
