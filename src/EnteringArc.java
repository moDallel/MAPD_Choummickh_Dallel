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

	public boolean isActive() {
		
		return ( super.getPlace().currentNbTokensBiggerThan(super.getWeight())) ;
	}
}