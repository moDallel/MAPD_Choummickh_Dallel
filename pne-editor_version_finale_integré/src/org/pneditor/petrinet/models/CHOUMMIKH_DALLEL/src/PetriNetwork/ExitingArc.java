package org.pneditor.petrinet.models.CHOUMMIKH_DALLEL.src.PetriNetwork;

/**
 * @author CHOUMMIKH Meriam
 * @author DALLEL Mohammed
 */

public class ExitingArc extends Arc {
	
	/**
	 * The constructor takes as input int, Place and Transition as this class inherits from the class Arc
	 * @param weight the weight of the Arc
	 * @param place the Place destination of the Arc
	 * @param transition the Transition source of the Arc
	 */
	public ExitingArc(int weight, Place place, Transition transition) {
		super(weight, place, transition);
	}
	
	/**
	 * @return true 
	 */
	public boolean isExitingArc() {
		return true;
	}
	
	/**
	 * @return the description the ExitingArc
	 */
	public String toString() {
		String res =  " : arc simple sortant de poids "+this.getWeight()+" (transition vers place avec "+this.getPlace().getTokensNumber()+" jetons) \n";
		return res;
	}

	/**
	 * this method is used in order to add tokens to the Place destination when it's active and 
	 * the associated Transition is firable
	 */
	public void execute() {
			super.getPlace().addTokens(super.getWeight());
	}
	
}
