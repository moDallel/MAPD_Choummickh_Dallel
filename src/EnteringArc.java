public class EnteringArc extends Arc {
	
	public EnteringArc(int weight, Place place, Transition transition) {
		super(weight, place, transition);
		// TODO Auto-generated constructor stub
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
		int newCurrentTokens = super.getPlace().getTokensNumber() - super.getWeight();
		super.getPlace().setTokensNumber(newCurrentTokens);		
	}



	public Transition getTransition() {
		// TODO Auto-generated method stub
		return super.getTransition();
	}

}