public class EmptyingArc extends EnteringArc {
	

	public EmptyingArc(Place place, Transition transition) {
		super(0, place, transition);
		// TODO Auto-generated constructor stub
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

	public void execute() {
		
		if ( isActive() == true ) {
			super.getPlace().setTokensNumber(0);
		}
	}
	
}
