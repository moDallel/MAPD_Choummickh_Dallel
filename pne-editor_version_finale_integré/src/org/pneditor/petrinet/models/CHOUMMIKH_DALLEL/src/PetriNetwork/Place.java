package org.pneditor.petrinet.models.CHOUMMIKH_DALLEL.src.PetriNetwork;
/**
 * @author CHOUMMIKH Meriam
 * @author DALLEL Mohammed
 */

import java.util.LinkedList;

public class Place {
	private int tokensNumber;
	private LinkedList<Arc> arcsList ; 
	
	/**
	 * The constructor takes as an input int. It allows us to create an instance Place with a number of tokens
	 * @param nbTokens the desired number of tokens
	 */
	
	public Place(int nbTokens) {
		if (nbTokens < 0 ) {
			System.out.println(" nbTokens to add must be bigger than 0 !!! tokensNumber will be set to the default value zero ! ");
			this.tokensNumber = 0;
		}
		else {
			this.tokensNumber = nbTokens;
		}
		this.arcsList = new LinkedList<Arc>();
	}
	
	/**
	 * @return the number of tokens (the attribute tokensNumber)
	 */
	
	public int getTokensNumber() {
		return this.tokensNumber;
	}
	
	/**
	 * this method allows us to set a new number of tokens in the Place
	 * @param int nbTokens the new desired number of tokens
	 */
	
	public void setTokensNumber(int nbTokens) {
		if (nbTokens < 0 ) {
			System.out.println(" nbTokens to add must be bigger than 0 !!! tokensNumber will be set to the default value zero ! ");
			this.tokensNumber = 0;
		}
		else {
			this.tokensNumber = nbTokens;
		}
	}
	/**
	 * This method allows us to compare the Place's tokensNumber with a weight of an arc
	 * We will need this method in the PetriNetwork class and Transition class
	 * @param arcWeight an int
	 * @return true if the number of tokens is bigger than the inpu, false otherwise
	 */
	public boolean currentNbTokensBiggerThan(int arcWeight) {
		return (this.tokensNumber >= arcWeight);
	}
	
	/**
	 * @return true if the number of tokens is null, false otherwise
	 */
	
	public boolean isEmpty() {
		return this.tokensNumber == 0;
	}
	
	/**
	 * this method allows us to add an arc in the list of arcs associated to the Place
	 */
	
	public void addArc(Arc arc) {
		this.arcsList.add(arc);
	}
	
	/**
	 * this method allows us to remove an arc from the list of arcs associated to the Place
	 */
	
	public boolean removeArc(Arc arc) {
		return this.arcsList.remove(arc);
	}
	
	/**
	 * @return the list of arcs associated to the Place
	 */

	public LinkedList<Arc> getArcsList() {
		return this.arcsList;
	}
	
	/**
	 * this method allows us to add a number of tokens in the Place
	 * @param int nbTokens the desired number of tokens
	 */

	public void addTokens(int nbTokens) {
		if (nbTokens < 0  ) {
			System.out.println(" nbTokens to add must be bigger than 0 !!! The absolute value will be taken in consideration ! ");
			this.tokensNumber += Math.abs(nbTokens);
		}
		else {
			this.tokensNumber += nbTokens;
		}
	}
	
	/**
	 * this method allows us to remove a number of tokens from the Place
	 * @param int nbTokens the desired number of tokens
	 */
	
	public void removeTokens(int nbTokens) {
		if (nbTokens < 0  ) {
			System.out.println(" nbTokens to remove must be bigger than 0 !!! The absolute value will be taken in consideration !  ");
			this.removeTokens(Math.abs(nbTokens));
		}
		else if ( nbTokens > this.tokensNumber) {
			System.out.println(" nbTokens to remove must be smaller than the current tokens number !!! Tokens number will be set to zero ! ");
			this.tokensNumber = 0;
		}
		else {
			this.tokensNumber -= nbTokens;
		}
	}
	
	/**
	 * @return the description the Place and its caracteristics (Number of tokens, entering arcs, exiting arcs...)
	 */
	
	public String toString() {
		String res = "";
		int nbEnteringArc = 0;
	    int nbExitingArc = 0;
	    int nbZeroArc = 0;
	    int nbEmptyingArc = 0;
	    int nbSimpleEnteringArc = 0;
		for (Arc arc : this.arcsList ) {
				if (arc.isEnteringArc() == true ) {
					nbEnteringArc++;
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
				else {
					nbExitingArc++;
				}
		}
		res += " : "+"place avec "+this.getTokensNumber()+" jetons, "+nbEnteringArc+" arc(s) entrant(s) dont " + nbSimpleEnteringArc +  " simple(s), "+ nbZeroArc +" zéro arc(s), " + nbEmptyingArc +" arc(s) videur(s) et "+ nbExitingArc +" arc(s) simple(s) sortant(s) \n";
		return res;
	}

}
