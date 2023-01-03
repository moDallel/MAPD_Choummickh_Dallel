package org.pneditor.petrinet.adapters.CHOUMMIKH_DALLEL;

/**
 * This class PlaceAdapter is created in order to adapt the class Place that exists in our model to the AbstractPlace class
 * from PNEditor. 
 * @author CHOUMMIKH Meriam
 * @author DALLEL Mohammed
 */

import org.pneditor.petrinet.AbstractPlace;
import org.pneditor.petrinet.models.CHOUMMIKH_DALLEL.src.PetriNetwork.Place;

public class PlaceAdapter extends AbstractPlace {
	
	private Place place;
	
	/**
	 * The constructor takes as input Place and String. Place is the attribute that needs to be adapted.
	 * PlaceAdapter inherits from AbstractPlace in which there's a constructor that takes String as input
	 * That's why the constructor bellow calls the super() constructor
	 * @param label String
	 * @param place Place to be adapted
	 */

	public PlaceAdapter(String label, Place place) {
		super(label);
		this.place  = place;
	}
	
	/**
	 * This method is used in order to add 1 token in Place
	 */

	@Override
	public void addToken() {
		this.place.addTokens(1);
	}
	
	/**
	 * This method is used in order to remove 1 token in Place
	 */

	@Override
	public void removeToken() {
		this.place.removeTokens(1);	
	}
	
	/**
	 * @return the number of tokens in Place
	 */

	@Override
	public int getTokens() {
		return this.place.getTokensNumber();
	}
	
	/**
	 * This method is used to set the number of tokens in Place
	 * @param tokens the desired number of tokens
	 */

	@Override
	public void setTokens(int tokens) {
		this.place.setTokensNumber(tokens);
	}
	
	/**
	 * @return the Place
	 */
	
	public Place getPlace() {
		return this.place;
	}

}
