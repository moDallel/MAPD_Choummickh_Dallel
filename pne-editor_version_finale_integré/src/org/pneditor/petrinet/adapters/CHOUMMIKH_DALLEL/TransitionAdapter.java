package org.pneditor.petrinet.adapters.CHOUMMIKH_DALLEL;

/**
 * This class TransitionAdapter is created in order to adapt the class Transition that exists in our model to the AbstractTransition
 * class from PNEditor. 
 * @author CHOUMMIKH Meriam
 * @author DALLEL Mohammed
 */

import org.pneditor.petrinet.AbstractTransition;
import org.pneditor.petrinet.models.CHOUMMIKH_DALLEL.src.PetriNetwork.Transition;

public class TransitionAdapter extends AbstractTransition {
	
	private Transition transition;
	
	/**
	 * The constructor takes as input Transition and String. Transition is the attribute that needs to be adapted.
	 * TransitionAdapter inherit from AbstractTransition in which there's a constructor that takes String as input
	 * That's why the constructor bellow calls the super() constructor
	 * @param label String
	 * @param transition Transition to be adapted
	 */

	public TransitionAdapter(String label, Transition transition) {
		super(label);
		this.transition = transition;
	}
	
	/**
	 * @return the Transition
	 */
	
	public Transition getTransition() {
		return this.transition;
	}

}
