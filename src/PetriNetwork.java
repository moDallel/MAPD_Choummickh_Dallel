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
	public boolean fire(Transition t) {
		if ( t.isFirable() ) {
			LinkedList<EnteringArc> myEnteringArc = t.getEnteringArcList();
			LinkedList<ExitingArc> myExitingArc = t.getExitingArcList();
			for ( EnteringArc a : myEnteringArc ) {
				a.execute();
			}
			for ( ExitingArc a : myExitingArc ) {
				a.execute();
			}
			return true;
		}
		else {
			return false;
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
	public void addEnteringArc(int weight, Place p, Transition t) {
		EnteringArc entArc = new EnteringArc(weight, p, t);
		this.arcsList.add(entArc);
		p.addArc(entArc);
		t.addEntringArc(entArc);
	}

	@Override
	public void addExitingArc(int weight, Place p, Transition t) {
		ExitingArc exArc = new ExitingArc(weight, p, t);
		this.arcsList.add(exArc);
		p.addArc(exArc);
		t.addExitingArc(exArc);
	}

	@Override
	public void addZeroArc(Place p, Transition t) {
		ZeroArc zeroArc = new ZeroArc(p, t);
		this.arcsList.add(zeroArc);
		p.addArc(zeroArc);
		t.addEntringArc(zeroArc);

	}

	@Override
	public void addEmptyingArc(Place p, Transition t) {
		EmptyingArc emptyingArc = new EmptyingArc(p, t);
		this.arcsList.add(emptyingArc);
		p.addArc(emptyingArc);
		t.addEntringArc(emptyingArc);

	}

	@Override
	public boolean removeArc(Arc a) {
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
		return false;
	}

	@Override
	public boolean removeTransition(Transition t) {
		LinkedList<EnteringArc> entArcsList = t.getEnteringArcList();
		for ( Arc arc : entArcsList ) {
			this.removeArc(arc);
		}
		LinkedList<ExitingArc> exArcsList = t.getExitingArcList();
		for ( Arc arc : exArcsList ) {
			this.removeArc(arc);
		}
		this.transitionsList.remove(t);
		return false;
	}

	@Override
	public boolean removePlace(Place p) {
		LinkedList<Arc> arcsList = p.getArcsList();
		for ( Arc arc : arcsList ) {
			this.removeArc(arc);
		}
		this.placesList.remove(p);
		return false;
	}

	@Override
	public void setTokensNumber(Place p, int nbTokens) {
		p.setTokensNumber(nbTokens);
	}

	@Override
	public void setPoidsArc(Arc a, int weight) {
		a.setWeight(weight);
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
