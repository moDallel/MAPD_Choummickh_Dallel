package org.pneditor.petrinet.models.CHOUMMIKH_DALLEL.src.PetriNetwork;

/**
 * @author CHOUMMIKH Meriam
 * @author DALLEL Mohammed
 */

import java.util.LinkedList;

public class Transition {
	
	private LinkedList<ExitingArc> exitingArcList; 
	private LinkedList<EnteringArc> enteringArcList; 
	
	/**
	 * The constructor doesn't take any input. It allows us to create a new Transition
	 * with no arc
	 */
	
	public Transition() {
		this.enteringArcList = new LinkedList<EnteringArc>();
		this.exitingArcList = new LinkedList<ExitingArc>();
	}
	
	/**
	 * This method is used in order to add a new exiting arc from the Transition 
	 * @param exArc an ExitingArc 
	 */
	
	public void addExitingArc(ExitingArc exArc) {
		this.exitingArcList.add(exArc);
	}
	
	/**
	 * This method is used in order to add a new entering arc to the Transition 
	 * @param entArc an EnteringArc 
	 */
	
	public void addEntringArc(EnteringArc entArc) {
		this.enteringArcList.add(entArc);
	}
	
	/**
	 * This method is used in order to remove an exiting arc from the Transition 
	 * @param exArc an ExitingArc 
	 */
	
	public void removeExitingArc(ExitingArc exArc) {
		this.exitingArcList.remove(exArc);
	}
	
	/**
	 * This method is used in order to remove an entering arc from the Transition 
	 * @param entArc an EenteringgArc 
	 */
	
	public void removeEntringArc(EnteringArc entArc) {
		this.enteringArcList.remove(entArc);
	}
	
	/**
	 * This method is used in order to check if the Transition is firable or not 
	 * @return true if the Transition is firable, false otherwise
	 */
	
	public boolean isFirable() {
		for (EnteringArc entArc : this.enteringArcList) {
			if (! entArc.isActive()){
				return false ;
			}
		}
		return true;
	}
	
	/**
	 * This method is used in order to fire the Transition
	 */
	
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
	
	/**
	 * This method is used in order to check if there's an entering arc or an exiting arc associated to the Transition
	 * @param boolean direction (true --> enteringArc, false --> exitingArc) 
	 * @param Place p
	 * @return true if there's an arc (the nature of the arc depends on the value of direction), false otherwise
	 */
	
	public boolean exist(boolean direction, Place p ) { 
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
	
	/**
	 * @return the description the Transition and its caracteristics
	 */
	
	public String toString() {
		String res = "";
	    int nbZeroArc = 0;
	    int nbEmptyingArc = 0;
	    int nbSimpleEnteringArc = 0;
		for (Arc arc : this.enteringArcList ) {
					if (((EnteringArc)arc).isZero()) {
						nbZeroArc++;
					}
					else if (((EnteringArc)arc).isEmptying()) {
						nbEmptyingArc++;
					}
					else {
						nbSimpleEnteringArc++;
					}
		}
		res += " : "+"transition, "+this.enteringArcList.size()+" arc(s) entrant(s) dont " + nbSimpleEnteringArc + " simple(s), "+ nbZeroArc + " zéro arc(s), " + nbEmptyingArc +" arc(s) videur(s) et " +this.exitingArcList.size()+" arc(s) sortant(s) \n";
		return res;
	}
	
	/**
	 * @return the list of the Entering arcs associated to the Transition
	 */

	public LinkedList<EnteringArc> getEnteringArcList() {
		return this.enteringArcList;
	}
	
	/**
	 * @return the list of the exiting arcs associated to the Transition
	 */

	public LinkedList<ExitingArc> getExitingArcList() {
		return this.exitingArcList;
	}
	
}
