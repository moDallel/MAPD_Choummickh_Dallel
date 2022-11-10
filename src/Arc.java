package PetriNetwork;

public class Arc {
	
	private int weight;
	private Place place;
	private Transition transition;
	
	public Arc(int weight, Place place, Transition transition) {
		int w ;
		if ( weight <= 0 ) {
			System.out.println("weight must be >= 1 !!! this arc Weigth will be set to the default value 1 ! ");
			w = 1 ;
		}
		else {
			w = weight ;
		}
		this.weight = w;
		this.place = place;
		this.transition = transition;
	}

	public void setWeight(int newWeight) {
		if (newWeight <= 0 ) {
			System.out.println("weight must be >= 1 !!! this arc Weigth will be set to the default value 1 ! ");
			this.weight = 1;
		}
		else {
			this.weight = newWeight;
		}
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
