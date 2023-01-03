package org.pneditor.petrinet.models.CHOUMMIKH_DALLEL.src.PetriNetwork;

/**
 * @author CHOUMMIKH Meriam
 * @author DALLEL Mohammed
 */

public class Arc {
	
	private int weight;
	private Place place;
	private Transition transition;
	
	/**
	 * The constructor takes as input int, Place and Transition. It allows us to create a new Arc
	 * @param weight the weight of the Arc
	 * @param place the Place source/destination of the Arc
	 * @param transition the Transition source/destination of the Arc
	 */
	
	public Arc(int weight, Place place, Transition transition) {
		int w ;
		if ( weight <= 0 ) {
			System.out.println("weight must be >= 1 !!! this arc Weigth will be set to the default value 1 ! ");
			w = 1 ;
		}
		else {
			w = weight ;
		}
		this.weight = w;
		this.place = place;
		this.transition = transition;
	}
	
	/**
	 * This method allows us to set the weight of the Arc
	 * @param int newWeight
	 */
	public void setWeight(int newWeight) {
		if (newWeight <= 0 ) {
			System.out.println("weight must be >= 1 !!! this arc Weigth will be set to the default value 1 ! ");
			this.weight = 1;
		}
		else {
			this.weight = newWeight;
		}
	}
	
	/**
	 * @return the Place source/destination of the Arc
	 */
	public Place getPlace() {
		return this.place;
	}
	
	/**
	 * @return the weight of the Arc
	 */
	public int getWeight() {
		return this.weight;
	}
	
	/**
	 * @return the Transition source/destination of the Arc
	 */
	public Transition getTransition() {
		return this.transition;
	}

	/**
	 * @return true if the Transition is the destination of the Arc, false otherwise
	 */
	public boolean isEnteringArc() {
		return false;
	}
	
	/**
	 * @return true if the Transition is the source of the Arc, false otherwise
	 */
	public boolean isExitingArc() {
		return false;
	}
	
	/**
	 * @return true if the Arc is active, false otherwise
	 */
	public boolean isActive() {
		
		return ( place.currentNbTokensBiggerThan(weight)) ;
	}

}
