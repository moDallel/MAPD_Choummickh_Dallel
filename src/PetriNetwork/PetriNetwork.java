package PetriNetwork;

import java.util.LinkedList;

import exceptions.*;


public class PetriNetwork implements IPetriNetwork {
	private LinkedList<Transition> transitionsList ;
	private LinkedList<Place> placesList ;
	private LinkedList<Arc> arcsList;
	
	public PetriNetwork() {
		this.arcsList = new LinkedList<Arc>();
		this.placesList = new LinkedList<Place>();
		this.transitionsList = new LinkedList<Transition>();
	}
	@Override
	public LinkedList<Transition> firableTransitions() {
		LinkedList<Transition> firableTransitions = new LinkedList<Transition>() ;
		for ( Transition t : transitionsList ) {
			if (t.isFirable()) {
				firableTransitions.add(t);
			}
		}
		return firableTransitions;
	}

	@Override
	public void fire(Transition t) throws NullObjectException,NotFirableTransitionException {
		if (t==null) {
			throw new NullObjectException("The transition doesn't have to be a null object !");
		}
		else if (!t.isFirable()) {
			throw new NotFirableTransitionException("The given transition is not firable");
		}
		else{
			t.fire();
		}
	}

	@Override
	public void addPlace(int nbTokens) {
			Place p = new Place(nbTokens);
			placesList.add(p);
	}

	@Override
	public void addTransition() {
		Transition t = new Transition();
		transitionsList.add(t);

	}

	@Override
	public void addEnteringArc(int weight, Place p, Transition t) throws NullObjectException,ExistantArcException {
		if ( p != null && t != null  ) {
			if ( ! t.exist(true, p) ) {
				EnteringArc entArc = new EnteringArc(weight, p, t);
				this.arcsList.add(entArc);
				p.addArc(entArc);
				t.addEntringArc(entArc);
			}
			else {
				throw new ExistantArcException("this arc is already existing!") ;
			}

		}
		else {
			throw new NullObjectException(" Argument place or transition is null ! ");
		}
	}
	
	public void addEnteringArc(Place p, Transition t) throws NullObjectException,ExistantArcException {
		this.addEnteringArc(1, p, t);
	}

	@Override
	public void addExitingArc(int weight, Place p, Transition t) throws NullObjectException,ExistantArcException {
		if ( p != null && t != null  ) {
			if ( ! t.exist(false, p) ) {
				ExitingArc exArc = new ExitingArc(weight, p, t);
				this.arcsList.add(exArc);
				p.addArc(exArc);
				t.addExitingArc(exArc);
			}
			else {
				throw new ExistantArcException("this arc is already existing!") ;
			}

		}
		else {
			throw new NullObjectException(" Argument place or transition is null ! ");
		}
	}
	
	public void addExitingArc(Place p, Transition t) throws NullObjectException,ExistantArcException {
		this.addExitingArc(1, p, t);
	}

	@Override
	public void addZeroArc(Place p, Transition t) throws NullObjectException,ExistantArcException{
		if ( p != null && t != null  ) {
			if ( ! t.exist(true, p) ) {
				ZeroArc zeroArc = new ZeroArc(p, t);
				this.arcsList.add(zeroArc);
				p.addArc(zeroArc);
				t.addEntringArc(zeroArc);
			}
			else {
				throw new ExistantArcException("this arc is already existing!") ;
			}

		}
		else {
			throw new NullObjectException(" Argument place or transition is null ! ");
		}
	}



	@Override
	public void addEmptyingArc(Place p, Transition t) throws NullObjectException,ExistantArcException {
		if ( p != null && t != null  ) {
			if ( ! t.exist(true, p) ) {
				EmptyingArc emptyingArc = new EmptyingArc(p, t);
				this.arcsList.add(emptyingArc);
				p.addArc(emptyingArc);
				t.addEntringArc(emptyingArc);
			}
			else {
				throw new ExistantArcException("this arc is already existing!") ;
			}

		}
		else {
			throw new NullObjectException(" Argument place or transition is null ! ");
		}
	}


	@Override
	public void removeArc(Arc a) throws NullObjectException {
		if (a != null ) {
				Place p = a.getPlace();
				Transition t = a.getTransition();
				p.removeArc(a);
				if (a.isEnteringArc() ) {
					t.removeEntringArc((EnteringArc)a);
				}
				else {
					t.removeExitingArc((ExitingArc)a);
				}
				this.arcsList.remove(a);
		}
		else {
			throw new NullObjectException(" Argument arc is null ! ");
		}

	}

	@Override
	public void removeTransition(Transition t) throws NullObjectException {
		if (t != null ) {
				LinkedList<EnteringArc> entArcsList = t.getEnteringArcList();
				for ( Arc arc : entArcsList ) {
					this.removeArc(arc);
				}
				LinkedList<ExitingArc> exArcsList = t.getExitingArcList();
				for ( Arc arc : exArcsList ) {
					this.removeArc(arc);
				}
				this.transitionsList.remove(t);
		}
		else {
			throw new NullObjectException(" Argument transition is null ! ");
		}

	}

	@Override
	public void removePlace(Place p) throws NullObjectException {
		if (p != null ) {
				LinkedList<Arc> arcsList = p.getArcsList();
				for ( Arc arc : arcsList ) {
					this.removeArc(arc);
				}
				this.placesList.remove(p);
		}
		else {
			throw new NullObjectException(" Argument place is null ! ");
		}

	}

	@Override
	public void addTokens(Place p, int nbTokens) throws InexistantPlaceException,NullObjectException {
		if (p != null ) {
			if (this.placesList.contains(p)) {
				p.addTokens(nbTokens);
			}
			else {
				throw new InexistantPlaceException(" This place does not exist in the arc list ! ");
			}
		}
		else {
			throw new NullObjectException(" Argument place is null ! ");
		}

	}
	
	@Override
	public void removeTokens(Place p, int nbTokens) throws InexistantPlaceException,NullObjectException {
		if (p != null ) {
			if (this.placesList.contains(p)) {
				p.removeTokens(nbTokens);
			}
			else {
				throw new InexistantPlaceException(" This place does not exist in the arc list ! ");
			}
		}
		else {
			throw new NullObjectException(" Argument place is null ! ");
		}
		
	}

	@Override
	public void setArcWeight(Arc a, int weight) throws InexistantArcException,NullObjectException,NoAttributeWeightException {
		if (a != null ) {
			if (this.arcsList.contains(a)) {
				if (a instanceof ZeroArc || a instanceof EmptyingArc) {
					throw new NoAttributeWeightException(" ZeroArc/EmtyingArc has no attribute weight ! ");
				}
				else {
					a.setWeight(weight);
				}
			}
			else {
				throw new InexistantArcException(" This arc does not exist in the arc list !!! ");
			}
		}
		else {
			throw new NullObjectException(" Argument arc is null !!! ");
		}

	}
	
	public String toString() {
		String res = "";
		res += "Réseau de Petri \n";
		res += placesList.size() + " " +"place(s) \n";
		res += transitionsList.size() + " "+"transition(s) \n";
		res += arcsList.size() + " "+"arc(s) \n" ;
		res += "--------------------------------------- \n";
		res += "Liste des places : \n";
		for (int i = 0; i < placesList.size(); i++) {
			Place place = placesList.get(i);
			res += (i+1) + place.toString();
		}
		res += "--------------------------------------- \n";
		res += "Liste des transitions : \n" ;
		for (int i = 0; i < transitionsList.size(); i++) {
			Transition transition = transitionsList.get(i);
			res += (i+1)+ transition.toString();
		}
		res += "--------------------------------------- \n";
		res += "Liste des arcs : \n" ;
		for (int i = 0; i < arcsList.size(); i++) {
			Arc arc = arcsList.get(i);
			res += (i+1) + arc.toString();
		}
		return res;
	}
	
	// those methodes are used for tests.
	public LinkedList<Transition> getTransitionsList() {
		return this.transitionsList;
	}
	
	public LinkedList<Arc> getArcsList() {
		return this.arcsList;
	}
	
	public LinkedList<Place> getPlacesList() {
		return this.placesList;
	}
	
}
