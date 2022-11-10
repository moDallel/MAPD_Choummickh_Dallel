package PetriNetwork;

import java.util.LinkedList;

import exceptions.*;

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
	public void fire(Transition t) throws NullObjectException,NotFirableTransitionException;
	
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
	public void addEnteringArc(int weight, Place p, Transition t) throws NullObjectException,ExistantArcException;
	
	/**
	 * Adds an entering arc  
	 * @param p the place source of the arc
	 * @param t the transition destination of the arc
	 * weight is set to the default value 1
	 * 
	 */
	public void addEnteringArc(Place p, Transition t) throws NullObjectException,ExistantArcException ;
	
	/**
	 * Adds an exiting arc
	 * @param weight integer >= 1  
	 * @param p the place destination of the arc
	 * @param t the source of the arc
	 * 
	 */
	public void addExitingArc(int weight, Place p, Transition t) throws NullObjectException,ExistantArcException;
	
	/**
	 * Adds an exiting arc
	 * @param p the place destination of the arc
	 * @param t the source of the arc
	 * weight is set to the default value 1
	 * 
	 */
	public void addExitingArc(Place p, Transition t) throws NullObjectException,ExistantArcException;

	/**
	 * Adds a zero arc 
	 * @param p the place source of the arc
	 * @param t the transition destination of the arc
	 * 
	 */
	public void addZeroArc(Place p, Transition t) throws NullObjectException,ExistantArcException;
	
	/**
	 * Adds an emptying arc 
	 * @param p the place source of the arc
	 * @param t the transition destination of the arc
	 * 
	 */
	public void addEmptyingArc(Place p, Transition t) throws NullObjectException,ExistantArcException;
	
	/**
	 * REMOVEs Arc.
	 * @param a the arc to remove
	 * 
	 */
	public void removeArc(Arc a) throws NullObjectException;
	
	/**
	 * REMOVEs transition.
	 * @param t the transition to remove
	 * 
	 */
	public void removeTransition(Transition t) throws NullObjectException;
	
	/**
	 * REMOVEs place.
	 * @param p the place to remove
	 * 
	 */
	public void removePlace(Place p) throws NullObjectException;
	
	/**
	 * ADDs tokens to a selected place.
	 * @param p the place to add in 
	 * @param nbTokens number of tokens to add > 0
	 * 
	 */
	public void addTokens(Place p, int nbTokens) throws InexistantPlaceException,NullObjectException;
	
	/**
	 * removes tokens to a selected place.
	 * @param p the place to remove from.
	 * @param nbTokens number of tokens to remove( 0 < nbTokens <= current tokens number ) 
	 * 
	 */
	public void removeTokens(Place p, int nbTokens) throws InexistantPlaceException,NullObjectException;
	
	/**
	 * SET the weight of the Arc
	 * @param a the arc to modify
	 * @param weight the new weight -- weight >= 1
	 * 
	 */
	public void setArcWeight(Arc a, int weight) throws InexistantArcException,NullObjectException,NoAttributeWeightException;

}
