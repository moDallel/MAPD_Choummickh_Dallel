package PetriNetwork;

public class EnteringArc extends Arc {
	
	public EnteringArc(int weight, Place place, Transition transition) {
		super(weight, place, transition);
	}
	
	public boolean isEnteringArc() {
		return true;
	}
	
	public boolean isZero() {
		return false;
	}

	public boolean isEmptying() {
		return false;
	}
	
	public void execute() {
		super.getPlace().removeTokens(super.getWeight());		
	}
	
	public String toString() {
		String res =  " : arc simple entrant de poids "+this.getWeight()+" (place avec "+this.getPlace().getTokensNumber()+" jetons vers transition) \n";
		return res;
	}

	public boolean isActive() {
		
		return ( super.getPlace().currentNbTokensBiggerThan(super.getWeight())) ;
	}
}
