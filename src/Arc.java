public class Arc {
	
	private int weight = 1; //valeur de l'arc qui vaut 1 par défaut
	private Place place;
	private Transition transition;
	
	public Arc(int weight, Place place, Transition transition) {
		this.weight = weight;
		this.place = place;
		this.transition = transition;
	}

	public void setWeight(int neWeight) {
		this.weight = neWeight;
	}
	
	public Place getPlace() {
		return this.place;
	}
	
	public int getWeight() {
		return this.weight;
	}

	public Transition getTransition() {
		return this.transition;
	}

	public boolean isEnteringArc() {
		return false;
	}
	
	public boolean isExitingArc() {
		return false;
	}
	
}