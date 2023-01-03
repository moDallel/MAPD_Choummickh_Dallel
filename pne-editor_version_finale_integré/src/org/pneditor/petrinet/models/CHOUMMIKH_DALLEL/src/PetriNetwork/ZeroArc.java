package org.pneditor.petrinet.models.CHOUMMIKH_DALLEL.src.PetriNetwork;

/**
 * @author CHOUMMIKH Meriam
 * @author DALLEL Mohammed
 */

public class ZeroArc extends EnteringArc {
	
	/**
	 * The constructor takes as input Place and Transition. As this class inherits from the class EnteringArc, it
	 * calls super()
	 * @param place the Place source of the Arc
	 * @param transition the Transition destination of the Arc
	 */
	
	public ZeroArc(Place place, Transition transition) {
		super(1, place, transition);
	}
	
	/**
	 * @return true (Checking if the arc is a ZeroArc) 
	 */
	public boolean isZero() {
		return true;
	}
	
	/**
	 * @return true if the ZeroArc is active, false otherwise
	 */
	public boolean isActive() {
		return(super.getPlace().isEmpty());
	}
	
	/**
	 * @return the description of the ZeroArc
	 */
	public String toString() {
		String res =  " : zéro arc"+" (place avec "+this.getPlace().getTokensNumber()+" jetons vers transition) \n";
		return res;
	}
	
	/**
	 * this method is used in order save the number of tokens of the Place source when it's active
	 * and the associated Transition is firable 
	 */
	public void execute() {
		super.getPlace().removeTokens(0);		
	}
}
