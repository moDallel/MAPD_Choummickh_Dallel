package org.pneditor.petrinet.models.CHOUMMIKH_DALLEL.src.PetriNetwork;

/**
 * @author CHOUMMIKH Meriam
 * @author DALLEL Mohammed
 */

public class EmptyingArc extends EnteringArc {
	
	/**
	 * The constructor takes as input Place and Transition. As this class inherits from the class EnteringArc, it
	 * calls super()
	 * @param place the Place source of the Arc
	 * @param transition the Transition destination of the Arc
	 */
	public EmptyingArc(Place place, Transition transition) {
		super(1, place, transition);
	}
	
	/**
	 * @return true (Checking if the arc is an EmptyingArc) 
	 */
	public boolean isEmptying() {
		return true;
	}
	
	/**
	 * @return true if the EmptyingArc is active, false otherwise
	 */
	public boolean isActive() {
		
		if (super.getPlace().isEmpty() == true ) {
			return false;
		}
		else {
			return true;
		}
	}
	
	/**
	 * @return the description of the EmpytingArc
	 */
	public String toString() {
		String res =  " : arc videur"+" (place avec "+this.getPlace().getTokensNumber()+" jetons vers transition) \n";
		return res;
	}

	/**
	 * this method is used in order to remove all the tokens from the Place source when it's active
	 * and the associated Transition is firable 
	 */
	public void execute() {
		
		if ( isActive() == true ) {
			super.getPlace().setTokensNumber(0);
		}
	}
	
}
