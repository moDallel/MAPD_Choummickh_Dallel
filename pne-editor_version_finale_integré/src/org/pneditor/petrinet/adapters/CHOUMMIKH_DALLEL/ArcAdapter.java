package org.pneditor.petrinet.adapters.CHOUMMIKH_DALLEL;

/**
 * This class ArcAdapter is created in order to adapt the class Arc that exists in our model to the AbstractArc class
 * from PNEditor. The classes : EnteringArc and ExitingArc don't need to be adapted because they inherit from the 
 * Arc class.
 * @author CHOUMMIKH Meriam
 * @author DALLEL Mohammed
 */

import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.AbstractPlace;
import org.pneditor.petrinet.AbstractTransition;
import org.pneditor.petrinet.ResetArcMultiplicityException;
import org.pneditor.petrinet.models.CHOUMMIKH_DALLEL.src.PetriNetwork.*;


public class ArcAdapter extends AbstractArc{
	
	private AbstractPlace place;
	private AbstractTransition transition;
	private Arc arc;
	
	/**
	 * 
	 * @param place an instance from AbstractPlace
	 * @param transition an instance from AbstractTransition
	 * @param arc an instance from Arc 
	 * The constructor takes the Arc instance in order to adapt some methods from the Arc class to the PNEditor model
	 * The other instances from the AbstractPlace and AbstractTransition are used in order to return them and use 
	 * them in PetriNetAdapter's methods.
	 */
	
	public ArcAdapter(AbstractPlace place, AbstractTransition transition, Arc arc) {
		this.place = place;
		this.transition = transition;
		this.arc = arc;
	}
	
	/**
	 * @return the AbstractPlace if Arc is an EnteringArc 
	 * @return the AbstractTransition if Arc is an ExitingArc
	 * @return null otherwise
	 */
	@Override
	public AbstractNode getSource() {
		if (this.arc instanceof EnteringArc) {
			return this.place;
		} else if (this.arc instanceof ExitingArc) {
			return this.transition;
		}
		return null;
	}
	
	/**
	 * @return the AbstractPlace if Arc is an ExitingArc 
	 * @return the AbstractTransition if Arc is an EnteringArc
	 * @return null otherwise
	 */

	@Override
	public AbstractNode getDestination() {
		if (this.arc instanceof EnteringArc) {
			return this.transition;
		} else if (this.arc instanceof ExitingArc) {
			return this.place;
		}
		return null;
	}
	
	/**
	 * @return true if the Arc is an Emptying arc and false otherwise
	 */

	@Override
	public boolean isReset() {
		if (this.arc instanceof EmptyingArc) {
			return true;
		}
		return false;
	}
	
	/**
	 * @return true if the Arc is a regular one (Not an EmpytingArc nor a ZeroArc) 
	 * and false otherwise
	 */

	@Override
	public boolean isRegular() {
		if (this.arc instanceof EmptyingArc || this.arc instanceof ZeroArc) {
			return false;
		}
		return true;
	}
	
	/**
	 * @return true is the Arc is a ZeroArc
	 * and false otherwise
	 */

	@Override
	public boolean isInhibitory() {
		if (this.arc instanceof ZeroArc) {
			return true;
		}
		return false;
	}
	
	/**
	 * @return the weight of the Arc 
	 * using the method getWeight() of the Arc class
	 */

	@Override
	public int getMultiplicity() throws ResetArcMultiplicityException {
		return this.arc.getWeight();
	}
	
	/**
	 * This method is used to set the weight of the Arc
	 * @param multiplicity is the desired new weight of the Arc
	 */

	@Override
	public void setMultiplicity(int multiplicity) throws ResetArcMultiplicityException {
		this.arc.setWeight(multiplicity);
	}
	
	/**
	 * @return the Arc
	 */
	
	public Arc getArc() {
		return this.arc;
	}

}
