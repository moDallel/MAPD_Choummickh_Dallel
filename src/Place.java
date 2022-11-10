package PetriNetwork;

import java.util.LinkedList;

public class Place {
	private int tokensNumber;
	private LinkedList<Arc> arcsList ; 
	
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
	
	public int getTokensNumber() {
		return this.tokensNumber;
	}
	
	public void setTokensNumber(int nbTokens) {
		if (nbTokens < 0 ) {
			System.out.println(" nbTokens to add must be bigger than 0 !!! tokensNumber will be set to the default value zero ! ");
			this.tokensNumber = 0;
		}
		else {
			this.tokensNumber = nbTokens;
		}
	}
	
	public boolean currentNbTokensBiggerThan(int arcWeight) {
		return (this.tokensNumber >= arcWeight);
	}
	
	public boolean isEmpty() {
		return this.tokensNumber == 0;
	}
	
	public void addArc(Arc arc) {
		this.arcsList.add(arc);
	}
	
	public boolean removeArc(Arc arc) {
		return this.arcsList.remove(arc);
	}

	public LinkedList<Arc> getArcsList() {
		return this.arcsList;
	}

	public void addTokens(int nbTokens) {
		if (nbTokens < 0  ) {
			System.out.println(" nbTokens to add must be bigger than 0 !!! The absolute value will be taken in consideration ! ");
			this.tokensNumber += Math.abs(nbTokens);
		}
		else {
			this.tokensNumber += nbTokens;
		}
	}
	
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
