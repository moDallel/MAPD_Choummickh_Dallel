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
	void addPlace(int nbTokens);
	void addTransition();
	void addEnteringArc(int weight, Place p, Transition t);
	void addExitingArc(int weight, Place p, Transition t);
	void addZeroArc(Place p, Transition t);
	void addEmptyingArc(Place p, Transition t);
	boolean removeArc(Arc a);
	boolean removeTransition(Transition t);
	boolean removePlace(Place p);
	void setTokensNumber(Place p, int nbTokens);
	void setPoidsArc(Arc a, int weight);

}
