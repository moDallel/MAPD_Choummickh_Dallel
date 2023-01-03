package org.pneditor.petrinet.adapters.CHOUMMIKH_DALLEL;

/**
 * This class PetriNetAdapter is created in order to adapt the class PetriNetwork that exists in our model to the PetriNetInterface
 * abstract class from PNEditor. 
 * @author CHOUMMIKH Meriam
 * @author DALLEL Mohammed
 */


import java.util.LinkedList;

import org.pneditor.petrinet.AbstractArc;
import org.pneditor.petrinet.AbstractNode;
import org.pneditor.petrinet.AbstractPlace;
import org.pneditor.petrinet.AbstractTransition;
import org.pneditor.petrinet.PetriNetInterface;
import org.pneditor.petrinet.ResetArcMultiplicityException;
import org.pneditor.petrinet.UnimplementedCaseException;
import org.pneditor.petrinet.models.CHOUMMIKH_DALLEL.src.PetriNetwork.*;
import org.pneditor.petrinet.models.CHOUMMIKH_DALLEL.src.exceptions.ExistantArcException;
import org.pneditor.petrinet.models.CHOUMMIKH_DALLEL.src.exceptions.NotFirableTransitionException;
import org.pneditor.petrinet.models.CHOUMMIKH_DALLEL.src.exceptions.NullObjectException;


public class PetriNetAdapter extends PetriNetInterface {
	
	private PetriNetwork petriNet;
	private int PlaceId = 0;
	private int TransitionId = 0;
	
	/**
	 * The constructor only allows us to create a new Petri Network.
	 */
	
	public PetriNetAdapter() {
		this.petriNet = new PetriNetwork();
	}
	
	/**
	 * This method is used to create an empty place (0 token)
	 * labeled with its id ("P_id").
	 * @return the adapted version of the place
	 */

	@Override
	public AbstractPlace addPlace() {
		petriNet.addPlace(0);
		Place p = petriNet.getPlacesList().getLast();
		PlaceAdapter place = new PlaceAdapter("P_"+PlaceId, p);
		PlaceId ++;
		return place;
		
	}
	
	/**
	 * This method is used to create a transition (0 token)
	 * labeled with its id ("T_id").
	 * @return the adapted version of the transition
	 */

	@Override
	public AbstractTransition addTransition() {
		petriNet.addTransition();
		Transition t = petriNet.getTransitionsList().getLast();
		TransitionAdapter transition = new TransitionAdapter("T_"+TransitionId, t);
		TransitionId ++;
		return transition;
	}
	
	/**
	 * This method is used to add a regular Arc.
	 * @return the adapted version of the Arc.
	 * @param source AbstractNode (apparent type), source of the Arc.
	 * @param destination AbstractNode (apparent type), destination of the Arc.
	 */

	@Override
	public AbstractArc addRegularArc(AbstractNode source, AbstractNode destination) throws UnimplementedCaseException {
		if (source instanceof PlaceAdapter && destination instanceof PlaceAdapter || source instanceof TransitionAdapter && destination instanceof TransitionAdapter) {
			throw new UnimplementedCaseException("Unaccepted case");
		}
		else if (source instanceof PlaceAdapter && destination instanceof TransitionAdapter) {
			PlaceAdapter p = (PlaceAdapter) source;
			TransitionAdapter t = (TransitionAdapter) destination;
			try {
				petriNet.addEnteringArc(p.getPlace(), t.getTransition());
				Arc arc = petriNet.getArcsList().getLast();
				ArcAdapter a = new ArcAdapter(p,t,arc);
				return a;
			} catch (NullObjectException | ExistantArcException e) {
				e.printStackTrace();
			}
		}
		else if (source instanceof TransitionAdapter && destination instanceof PlaceAdapter) {
			PlaceAdapter p = (PlaceAdapter) destination;
			TransitionAdapter t = (TransitionAdapter) source;
			try {
				petriNet.addExitingArc(p.getPlace(), t.getTransition());
				Arc arc = petriNet.getArcsList().getLast();
				ArcAdapter a = new ArcAdapter(p,t,arc);
				return a;
			} catch (NullObjectException | ExistantArcException e) {
				e.printStackTrace();
			}
		}
		return null;
		
	}
	
	/**
	 * This method is used to add an inhibitory Arc (ZeroArc).
	 * @return the adapted version of the ZeroArc.
	 * @param place AbstractPlace (apparent type), source of the Arc.
	 * @param transition AbstractTransition (apparent type), destination of the Arc.
	 */


	@Override
	public AbstractArc addInhibitoryArc(AbstractPlace place, AbstractTransition transition)
			throws UnimplementedCaseException {
		Place p = ((PlaceAdapter) place).getPlace();
		Transition t = ((TransitionAdapter) transition).getTransition();
		try {
			petriNet.addZeroArc(p, t);
			Arc arc = petriNet.getArcsList().getLast();
			ArcAdapter a = new ArcAdapter(place, transition, arc);
			return a;
		} catch (NullObjectException | ExistantArcException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * This method is used to add a reset Arc (EmptyingArc).
	 * @return the adapted version of the EmptyingArc.
	 * @param place AbstractPlace (apparent type), source of the Arc.
	 * @param transition AbstractTransition (apparent type), destination of the Arc.
	 */


	@Override
	public AbstractArc addResetArc(AbstractPlace place, AbstractTransition transition)
			throws UnimplementedCaseException {
		Place p = ((PlaceAdapter) place).getPlace();
		Transition t = ((TransitionAdapter) transition).getTransition();
		try {
			petriNet.addEmptyingArc(p, t);
			Arc arc = petriNet.getArcsList().getLast();
			ArcAdapter a = new ArcAdapter(place, transition, arc);
			return a;
			
		} catch (NullObjectException | ExistantArcException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * This method is used in order to remove a place from PNEditor
	 * @param place AbstractPlace (apparent type)
	 */

	@Override
	public void removePlace(AbstractPlace place) {
		Place p = ((PlaceAdapter) place).getPlace();
		try {
			petriNet.removePlace(p);
		} catch (NullObjectException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * This method is used in order to remove a transition from PNEditor
	 * @param transition AbstractTransition (apparent type)
	 */

	@Override
	public void removeTransition(AbstractTransition transition) {
		Transition t = ((TransitionAdapter) transition).getTransition();
		try {
			petriNet.removeTransition(t);
		} catch (NullObjectException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * This method is used in order to remove an arc from PNEditor
	 * @param arc AbstractArc (apparent type)
	 */

	@Override
	public void removeArc(AbstractArc arc) {
		Arc a = ((ArcAdapter) arc).getArc();
		try {
			petriNet.removeArc(a);
		} catch (NullObjectException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @param transition AbstractTransition (apparent type)
	 * @return true if the transition if firable, false otherwise
	 */

	@Override
	public boolean isEnabled(AbstractTransition transition) throws ResetArcMultiplicityException {
		Transition t = ((TransitionAdapter) transition).getTransition();
		LinkedList<Transition> firableT = petriNet.firableTransitions();
		return firableT.contains(t);
	}
	
	/**
	 * This method is used in order to fire a transition (using the method fire()
	 * from PetriNetwork class).
	 * @param transition AbstractTransition (apparent type)
	 */

	@Override
	public void fire(AbstractTransition transition) throws ResetArcMultiplicityException {
		Transition t = ((TransitionAdapter) transition).getTransition();
		try {
			petriNet.fire(t);
		} catch (NullObjectException | NotFirableTransitionException e) {
			e.printStackTrace();
		}
	}
	

}
