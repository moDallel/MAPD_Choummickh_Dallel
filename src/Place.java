import java.util.LinkedList;

public class Place {
	private int tokensNumber;
	private LinkedList<Arc> arcsList ; 
	
	public Place(int nbTokens) {
		this.tokensNumber = nbTokens;
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
}
