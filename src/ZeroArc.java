public class ZeroArc extends EnteringArc {
	
	public ZeroArc(Place place, Transition transition) {
		super(0, place, transition);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isZero() {
		return true;
	}
	
	public boolean isActive() {
		if (super.getPlace().isEmpty() == true ) {
			return true;
		}
		else {
			return false;
		}
	}
	

}