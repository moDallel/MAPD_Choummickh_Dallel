package org.pneditor.petrinet.models.CHOUMMIKH_DALLEL.src.PetriNetwork;

/**
 * @author CHOUMMIKH Meriam
 * @author DALLEL Mohammed
 */

public class EnteringArc extends Arc {
	
	/**
	 * The constructor takes as input int, Place and Transition as this class inherits from the class Arc
	 * @param weight the weight of the Arc
	 * @param place the Place source of the Arc
	 * @param transition the Transition destination of the Arc
	 */
	
	public EnteringArc(int weight, Place place, Transition transition) {
		super(weight, place, transition);
	}
	
	/**
	 * @return true 
	 */
	public boolean isEnteringArc() {
		return true;
	}
	
	/**
	 * @return false as the EnteringArc is a regular Arc and not a ZeroArc
	 */
	public boolean isZero() {
		return false;
	}

	/**
	 * @return false as the EnteringArc is a regular Arc and not an EmptyingArc
	 */
	public boolean isEmptying() {
		return false;
	}
	
	/**
	 * this method is used in order to remove tokens from the Place source when it's active and
	 * the associated Transition is firable
	 */
	public void execute() {
		super.getPlace().removeTokens(super.getWeight());		
	}
	
	
	/**
	 * @return the description the EnteringArc
	 */
	public String toString() {
		String res =  " : arc simple entrant de poids "+this.getWeight()+" (place avec "+this.getPlace().getTokensNumber()+" jetons vers transition) \n";
		return res;
	}

	/**
	 * @return true if the EnteringArc is active, false otherwise
	 */
	public boolean isActive() {
		
		return ( super.getPlace().currentNbTokensBiggerThan(super.getWeight())) ;
	}
}
