package PetriNetwork;

public class ZeroArc extends EnteringArc {
	
	public ZeroArc(Place place, Transition transition) {
		super(1, place, transition);
	}
	
	public boolean isZero() {
		return true;
	}
	
	public boolean isActive() {
		return(super.getPlace().isEmpty());
	}
	
	public String toString() {
		String res =  " : zéro arc"+" (place avec "+this.getPlace().getTokensNumber()+" jetons vers transition) \n";
		return res;
	}
	
	public void execute() {
		super.getPlace().removeTokens(0);		
	}
}
