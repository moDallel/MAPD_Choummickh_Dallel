package PetriNetwork;

public class ExitingArc extends Arc {
	
	public ExitingArc(int weight, Place place, Transition transition) {
		super(weight, place, transition);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isExitingArc() {
		return true;
	}
	
	public String toString() {
		String res =  " : arc simple sortant de poids "+this.getWeight()+" (transition vers place avec "+this.getPlace().getTokensNumber()+" jetons) \n";
		return res;
	}

	public void execute() {
			super.getPlace().addTokens(super.getWeight());
	}
	
}
