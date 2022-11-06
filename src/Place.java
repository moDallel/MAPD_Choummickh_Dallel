import java.util.LinkedList;

public class Place {
	private int tokensNumber;
	private LinkedList<Arc> arcsList ; 
	
	public Place(int nbTokens) {
		if (nbTokens < 0 ) {
			this.tokensNumber = 0;
		}
		else {
			this.tokensNumber = nbTokens;
		}
		this.arcsList = new LinkedList<Arc>();
	}
	
	public void setTokensNumber(int nbTokens) {
		this.tokensNumber = nbTokens;
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
	
	public void incrementTokens() {
		this.tokensNumber ++ ;
	}
	
	public void decrementTokens() {
		if (this.tokensNumber > 0) {
			this.tokensNumber -- ;
		}
	}

	public int getTokensNumber() {
		// TODO Auto-generated method stub
		return this.tokensNumber;
	}

	public LinkedList<Arc> getArcsList() {
		// TODO Auto-generated method stub
		return this.arcsList;
	}

	public void addTokens(int nbTokens) {
		if (nbTokens <= 0  ) {
			System.out.println(" nbTokens to add must be bigger than 0 !!! ");
		}
		else {
			this.tokensNumber += nbTokens;
		}
	}
	
	public void removeTokens(int nbTokens) {
		if (nbTokens <= 0  ) {
			System.out.println(" nbTokens to remove must be bigger than 0 !!! ");
		}
		else if ( nbTokens > this.tokensNumber) {
			System.out.println(" nbTokens to remove must be less than the current tokens number !!! Tokens number will be set to zero ! ");
			this.tokensNumber = 0;
		}
		else {
			this.tokensNumber -= nbTokens;
		}
	}

}
