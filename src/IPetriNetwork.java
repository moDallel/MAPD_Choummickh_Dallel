import java.util.LinkedList;

public interface IPetriNetwork {
	
	public LinkedList<Transition> firableTransitions();
	
	public boolean fire(Transition t);
	
	/**
	 * Adds the place.
	 *
	 * @param nbTokens number of tokens >= 0 
	 * @return null
	 */
	public void addPlace(int nbTokens);
	
	public void addTransition();
	public void addEnteringArc(int weight, Place p, Transition t);
	public void addExitingArc(int weight, Place p, Transition t);
	public void addZeroArc(Place p, Transition t);
	public void addEmptyingArc(Place p, Transition t);
	public boolean removeArc(Arc a);
	public boolean removeTransition(Transition t);
	public boolean removePlace(Place p);
	public void setTokensNumber(Place p, int nbTokens);
	public void setPoidsArc(Arc a, int weight);

}
