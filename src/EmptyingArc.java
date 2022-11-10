package PetriNetwork;

public class EmptyingArc extends EnteringArc {

	public EmptyingArc(Place place, Transition transition) {
		super(1, place, transition);
	}
	
	public boolean isEmptying() {
		return true;
	}
	
	public boolean isActive() {
		
		if (super.getPlace().isEmpty() == true ) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public String toString() {
		String res =  " : arc videur"+" (place avec "+this.getPlace().getTokensNumber()+" jetons vers transition) \n";
		return res;
	}

	public void execute() {
		
		if ( isActive() == true ) {
			super.getPlace().setTokensNumber(0);
		}
	}
	
}
