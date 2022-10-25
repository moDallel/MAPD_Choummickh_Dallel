import java.util.LinkedList;

public class PetriNetwork implements IPetriNetwork {
	private LinkedList<Transition> transitionsList ;
	private LinkedList<Arc> arcsList ;
	private LinkedList<Place> placessList ;
	private LinkedList<EnteringArc> enteringArcList;
	private LinkedList<ExitingArc> exitingArcList;
	
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
				Place myPlace = a.getPlace() ;
				myPlace.setTokensNumber(myPlace.getTokensNumber() - a.getWeight());
			}
			for ( ExitingArc a : myExitingArc ) {
				Place myPlace = a.getPlace() ;
				myPlace.setTokensNumber(myPlace.getTokensNumber() + a.getWeight());
			}
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void addPlace(int nbTokens) {
		// TODO Auto-generated method stub
		Place p = new Place(nbTokens);
		placessList.add(p);

	}

	@Override
	public void addTransition() {
		// TODO Auto-generated method stub
		Transition t = new Transition();
		transitionsList.add(t);

	}

	@Override
	public void addEnteringArc(int weight, Place p, Transition t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addExitingArc(int weight, Place p, Transition t) {
		// TODO Auto-generated method stub
	}

	@Override
	public void addZeroArc(Place p, Transition t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addEmptyingArc(Place p, Transition t) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean removeArc(Arc a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeTransition(Transition t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removePlace(Place p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setTokensNumber(Place p, int nbTokens) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPoidsArc(Arc a, int weight) {
		// TODO Auto-generated method stub

	}

}
