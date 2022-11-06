import java.util.LinkedList;

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
	public void fire(Transition t) {
		t.fire();
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
	public void addEnteringArc(int weight, Place p, Transition t) {
		if ( p != null && t != null  ) {
			if ( ! t.exist(true, p) ) {
				EnteringArc entArc = new EnteringArc(weight, p, t);
				this.arcsList.add(entArc);
				p.addArc(entArc);
				t.addEntringArc(entArc);
			}
			else {
				System.out.println(" This arc already exist !!! ");
			}

		}
		else {
			System.out.println(" Argument place or transition is null !!! ");
		}
	}

	@Override
	public void addExitingArc(int weight, Place p, Transition t) {
		if ( p != null && t != null  ) {
			if ( ! t.exist(false, p) ) {
				ExitingArc exArc = new ExitingArc(weight, p, t);
				this.arcsList.add(exArc);
				p.addArc(exArc);
				t.addExitingArc(exArc);
			}
			else {
				System.out.println(" This arc already exist !!! ");
			}

		}
		else {
			System.out.println(" Argument place or transition is null !!! ");
		}
	}

	@Override
	public void addZeroArc(Place p, Transition t) {
		if ( p != null && t != null  ) {
			if ( ! t.exist(true, p) ) {
				ZeroArc zeroArc = new ZeroArc(p, t);
				this.arcsList.add(zeroArc);
				p.addArc(zeroArc);
				t.addEntringArc(zeroArc);
			}
			else {
				System.out.println(" This arc already exist !!! ");
			}

		}
		else {
			System.out.println(" Argument place or transition is null !!! ");
		}
	}



	@Override
	public void addEmptyingArc(Place p, Transition t) {
		if ( p != null && t != null  ) {
			if ( ! t.exist(true, p) ) {
				EmptyingArc emptyingArc = new EmptyingArc(p, t);
				this.arcsList.add(emptyingArc);
				p.addArc(emptyingArc);
				t.addEntringArc(emptyingArc);
			}
			else {
				System.out.println(" This arc already exist !!! ");
			}

		}
		else {
			System.out.println(" Argument place or transition is null !!! ");
		}
	}


	@Override
	public void removeArc(Arc a) {
		if (a != null ) {
			if (this.arcsList.contains(a)) {
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
				System.out.println(" This arc does not exist in the arc list !!! ");
			}
		}
		else {
			System.out.println(" Argument arc is null !!! ");
		}

	}

	@Override
	public void removeTransition(Transition t) {
		if (t != null ) {
			if (this.transitionsList.contains(t)) {
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
				System.out.println(" This transition does not exist in the arc list !!! ");
			}
		}
		else {
			System.out.println(" Argument transition is null !!! ");
		}

	}

	@Override
	public void removePlace(Place p) {
		if (p != null ) {
			if (this.placesList.contains(p)) {
				LinkedList<Arc> arcsList = p.getArcsList();
				for ( Arc arc : arcsList ) {
					this.removeArc(arc);
				}
				this.placesList.remove(p);
			}
			else {
				System.out.println(" This place does not exist in the arc list !!! ");
			}
		}
		else {
			System.out.println(" Argument place is null !!! ");
		}

	}

	@Override
	public void addTokens(Place p, int nbTokens) {
		if (p != null ) {
			if (this.placesList.contains(p)) {
				p.addTokens(nbTokens);
			}
			else {
				System.out.println(" This place does not exist in the arc list !!! ");
			}
		}
		else {
			System.out.println(" Argument place is null !!! ");
		}

	}
	
	@Override
	public void removeTokens(Place p, int nbTokens) {
		if (p != null ) {
			if (this.placesList.contains(p)) {
				p.removeTokens(nbTokens);
			}
			else {
				System.out.println(" This place does not exist in the arc list !!! ");
			}
		}
		else {
			System.out.println(" Argument place is null !!! ");
		}
		
	}

	@Override
	public void setArcWeight(Arc a, int weight) {
		if (a != null ) {
			if (this.arcsList.contains(a)) {
				if (a instanceof ZeroArc || a instanceof EmptyingArc) {
					System.out.println(" ZeroArc/EmtyingArc has no attribute weight !!! ");
				}
				else {
					a.setWeight(weight);
				}
			}
			else {
				System.out.println(" This arc does not exist in the arc list !!! ");
			}
		}
		else {
			System.out.println(" Argument arc is null !!! ");
		}

	}
	
	public String toString() {
		System.out.println("arcsList");
		System.out.println(this.arcsList);
		System.out.println("placesList");
		System.out.println(this.placesList);
		System.out.println("transitionsList");
		System.out.println(this.transitionsList);
		System.out.println("----------------------------");
		return this.arcsList.toString();

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PetriNetwork myPetriNetwork = new PetriNetwork() ;
		myPetriNetwork.addPlace(3);
		myPetriNetwork.addPlace(1);
		myPetriNetwork.addTransition();
		myPetriNetwork.addEnteringArc(1, myPetriNetwork.placesList.get(0), myPetriNetwork.transitionsList.get(0));
		System.out.println(myPetriNetwork.arcsList.get(0).getPlace() == myPetriNetwork.placesList.get(0) );
		System.out.println(myPetriNetwork.arcsList.get(0) instanceof EnteringArc);
		myPetriNetwork.addExitingArc(2, myPetriNetwork.placesList.get(1), myPetriNetwork.transitionsList.get(0));
		System.out.println("arcsList");
		System.out.println(myPetriNetwork.arcsList);
		System.out.println("placesList");
		System.out.println(myPetriNetwork.placesList);
		System.out.println("transitionsList");
		System.out.println(myPetriNetwork.transitionsList);
		System.out.println("----------------------------");
		LinkedList<Transition> fT = myPetriNetwork.firableTransitions();
		System.out.println(fT.toString());
		fT.get(0).fire();
		System.out.println(myPetriNetwork.placesList.get(0).getTokensNumber());
		System.out.println(myPetriNetwork.placesList.get(1).getTokensNumber());
		myPetriNetwork.placesList.get(0).setTokensNumber(6);
		System.out.println(myPetriNetwork.placesList.get(0).getTokensNumber());
		System.out.println(myPetriNetwork.placesList.get(1).getTokensNumber());
		myPetriNetwork.arcsList.get(0).setWeight(2);
		System.out.println(myPetriNetwork.arcsList.get(0).getWeight());
		fT = myPetriNetwork.firableTransitions();
		System.out.println(fT.toString());
		fT.get(0).fire();
		System.out.println(myPetriNetwork.placesList.get(0).getTokensNumber());
		System.out.println(myPetriNetwork.placesList.get(1).getTokensNumber());
		fT = myPetriNetwork.firableTransitions();
		System.out.println(fT.toString());
		fT.get(0).fire();
		System.out.println(myPetriNetwork.placesList.get(0).getTokensNumber());
		System.out.println(myPetriNetwork.placesList.get(1).getTokensNumber());
		fT = myPetriNetwork.firableTransitions();
		System.out.println(fT.toString());
		myPetriNetwork.transitionsList.get(0).fire();
		System.out.println(myPetriNetwork.placesList.get(0).getTokensNumber());
		System.out.println(myPetriNetwork.placesList.get(1).getTokensNumber());
		myPetriNetwork.removePlace(myPetriNetwork.placesList.get(0));
		System.out.println("arcsList");
		System.out.println(myPetriNetwork.arcsList);
		System.out.println("placesList");
		System.out.println(myPetriNetwork.placesList);
		System.out.println("transitionsList");
		System.out.println(myPetriNetwork.transitionsList);
		System.out.println("----------------------------");
		myPetriNetwork.removeArc(myPetriNetwork.arcsList.get(0));
		System.out.println("arcsList");
		System.out.println(myPetriNetwork.arcsList);
		System.out.println("placesList");
		System.out.println(myPetriNetwork.placesList);
		System.out.println("transitionsList");
		System.out.println(myPetriNetwork.transitionsList);
		System.out.println("----------------------------");
		myPetriNetwork.addExitingArc(4, myPetriNetwork.placesList.get(0), myPetriNetwork.transitionsList.get(0));
		System.out.println("arcsList");
		System.out.println(myPetriNetwork.arcsList);
		System.out.println("placesList");
		System.out.println(myPetriNetwork.placesList);
		System.out.println("transitionsList");
		System.out.println(myPetriNetwork.transitionsList);
		System.out.println("----------------------------");
		myPetriNetwork.removeTransition(myPetriNetwork.transitionsList.get(0));
		System.out.println("arcsList");
		System.out.println(myPetriNetwork.arcsList);
		System.out.println("placesList");
		System.out.println(myPetriNetwork.placesList);
		System.out.println("transitionsList");
		System.out.println(myPetriNetwork.transitionsList);
		System.out.println("----------------------------");
		myPetriNetwork.removePlace(myPetriNetwork.placesList.get(0));
		System.out.println("arcsList");
		System.out.println(myPetriNetwork.arcsList);
		System.out.println("placesList");
		System.out.println(myPetriNetwork.placesList);
		System.out.println("transitionsList");
		System.out.println(myPetriNetwork.transitionsList);
		System.out.println("----------------------------");
	}


}
