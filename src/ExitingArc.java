public class ExitingArc extends Arc {
	
	public ExitingArc(int weight, Place place, Transition transition) {
		super(weight, place, transition);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isExitingArc() {
		return true;
	}

	public void execute() {

			int n = super.getPlace().getTokensNumber();
			super.getPlace().setTokensNumber(super.getWeight() + n);
	}
	
}