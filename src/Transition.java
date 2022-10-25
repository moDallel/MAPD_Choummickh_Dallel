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
			Place myPlace = entArc.getPlace();
			int weight = entArc.getWeight(); 
			if (!myPlace.currentNbTokensBiggerThan(weight)){
				return false ;
			}
		}
		return true;
	}
	
	public void fire() {
		if (this.isFirable() == false) {
			return;
		}
		else {
			for (ExitingArc exArc : this.exitingArcList) {
				exArc.excute();
			}
		}
		
	}
}
