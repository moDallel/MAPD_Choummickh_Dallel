import java.util.LinkedList;

public class Transition {
	
	private LinkedList<ExitingArc> exitingArcList; 
	private LinkedList<EnteringArc> enteringArcList; 
	
	public Transition() {
		this.enteringArcList = new LinkedList<EnteringArc>();
		this.exitingArcList = new LinkedList<ExitingArc>();
	}
	
	public void addExitingArc(ExitingArc exArc) {
		this.exitingArcList.add(exArc);
	}
	
	public void addEntringArc(EnteringArc entArc) {
		this.enteringArcList.add(entArc);
	}
	
	public void removeExitingArc(ExitingArc exArc) {
		this.exitingArcList.remove(exArc);
	}
	
	public void removeEntringArc(EnteringArc entArc) {
		this.enteringArcList.remove(entArc);
	}
	
	public boolean isFirable() {
		for (EnteringArc entArc : this.enteringArcList) {
			if (! entArc.isActive()){
				return false ;
			}
		}
		return true;
	}
	
	public void fire() {
		if (this.isFirable() == false) {
			System.out.println("this transition is not firable");
		}
		else {
			for (ExitingArc exArc : this.exitingArcList) {
				exArc.execute();
			}
			for (EnteringArc entArc : this.enteringArcList) {
					entArc.execute();
			}
		}
		
	}
	
	public boolean exist(boolean direction, Place p ) {
		// true --> entringArc and false --> exitingArc  
		if (direction) {
			for (EnteringArc entArc : this.enteringArcList) {
				if (entArc.getPlace() == p) {
					return true;
				}
			}
		}
		else {
			for (ExitingArc exArc : this.exitingArcList) {
				if (exArc.getPlace() == p) {
					return true;
				}
			}
			
		}
		return false; 
	}

	public LinkedList<EnteringArc> getEnteringArcList() {
		return this.enteringArcList;
	}

	public LinkedList<ExitingArc> getExitingArcList() {
		return this.exitingArcList;
	}
}
