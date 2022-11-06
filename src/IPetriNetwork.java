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
	
	/**
	 * Adds the transition.
	 *
	 */
	public void addTransition();
	
	
	public void addEnteringArc(int weight, Place p, Transition t);
	public void addExitingArc(int weight, Place p, Transition t);
	public void addZeroArc(Place p, Transition t);
	public void addEmptyingArc(Place p, Transition t);
	public void removeArc(Arc a);
	public void removeTransition(Transition t);
	public void removePlace(Place p);
	public void addTokens(Place p, int nbTokens);
	public void removeTokens(Place p, int nbTokens);
	public void setPoidsArc(Arc a, int weight);

}
