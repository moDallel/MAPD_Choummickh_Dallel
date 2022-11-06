import java.util.LinkedList;

public interface IPetriNetwork {
	
	/**
	 * get firableTransitions.
	 *
	 * @return a linkedList of the firable transitions 
	 */
	public LinkedList<Transition> firableTransitions();
	
	/**
	 * fire.
	 *
	 * @param t the transition to fire 
	 */
	public void fire(Transition t);
	
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
	
	/**
	 * Adds an entering arc
	 * @param weight integer >= 1  
	 * @param p the place source of the arc
	 * @param t the transition destination of the arc
	 * 
	 */
	public void addEnteringArc(int weight, Place p, Transition t);
	
	/**
	 * Adds an exiting arc
	 * @param weight integer >= 1  
	 * @param p the place destination of the arc
	 * @param t the source of the arc
	 * 
	 */
	public void addExitingArc(int weight, Place p, Transition t);
	
	/**
	 * Adds a zero arc 
	 * @param p the place source of the arc
	 * @param t the transition destination of the arc
	 * 
	 */
	public void addZeroArc(Place p, Transition t);
	
	/**
	 * Adds an emptying arc 
	 * @param p the place source of the arc
	 * @param t the transition destination of the arc
	 * 
	 */
	public void addEmptyingArc(Place p, Transition t);
	
	/**
	 * REMOVEs Arc.
	 * @param a the arc to remove
	 * 
	 */
	public void removeArc(Arc a);
	
	/**
	 * REMOVEs transition.
	 * @param t the transition to remove
	 * 
	 */
	public void removeTransition(Transition t);
	
	/**
	 * REMOVEs place.
	 * @param p the place to remove
	 * 
	 */
	public void removePlace(Place p);
	
	/**
	 * ADDs tokens to a selected place.
	 * @param p the place to add in 
	 * @param nbTokens number of tokens to add > 0
	 * 
	 */
	public void addTokens(Place p, int nbTokens);
	
	/**
	 * removes tokens to a selected place.
	 * @param p the place to remove from.
	 * @param nbTokens number of tokens to remove( 0 < nbTokens <= current tokens number ) 
	 * 
	 */
	public void removeTokens(Place p, int nbTokens);
	
	/**
	 * SET the weight of the Arc
	 * @param a the arc to modify
	 * @param weight the new weight -- weight >= 1
	 * 
	 */
	public void setArcWeight(Arc a, int weight);

}
