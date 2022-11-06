public class ExitingArc extends Arc {
	
	public ExitingArc(int weight, Place place, Transition transition) {
		super(weight, place, transition);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isExitingArc() {
		return true;
	}

	public void execute() {
			super.getPlace().addTokens(super.getWeight());
	}
	
}