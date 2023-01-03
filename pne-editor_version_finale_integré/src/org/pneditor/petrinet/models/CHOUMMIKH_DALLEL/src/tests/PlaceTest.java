package org.pneditor.petrinet.models.CHOUMMIKH_DALLEL.src.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.pneditor.petrinet.models.CHOUMMIKH_DALLEL.src.PetriNetwork.*;

class PlaceTest {
	
	Place placePos;
	Place placeNeg;
	Arc a ;
	Transition t ;
	
	@BeforeEach
	void setUp() {
		
		placePos = new Place(3);  // Constructor with positive integer as argument
		placeNeg = new Place(-5); // Constructor with negative integer as argument
		t = new Transition();
		a = new Arc(1,placePos,t);
		
	}

	@Test
	void testPlace() {
		assertTrue(placePos instanceof Place);
		assertNotNull(placePos);
		assertTrue(placeNeg instanceof Place);
		assertNotNull(placeNeg);
	}

	@Test
	void testGetTokensNumber() {
		assertEquals(3, placePos.getTokensNumber());
		assertEquals(0, placeNeg.getTokensNumber());
	}
	
	@Test
	void testSetTokensNumber() {
		placePos.setTokensNumber(4); // setTokensNumber with positive integer as argument
		assertEquals(4, placePos.getTokensNumber());
		placePos.setTokensNumber(-7); // setTokensNumber with negative integer as argument
		assertEquals(0, placePos.getTokensNumber());
		
	}

	@Test
	void testCurrentNbTokensBiggerThan() {
		boolean test1 = placePos.currentNbTokensBiggerThan(2);
		boolean test2 = placePos.currentNbTokensBiggerThan(5);
		boolean test3 = placePos.currentNbTokensBiggerThan(3);
		assertTrue(test1);
		assertFalse(test2);	
		assertTrue(test3);
	}

	@Test
	void testIsEmpty() {
		boolean test = placePos.isEmpty();
		assertFalse(test);
		placePos = new Place(0);
		assertTrue(placePos.isEmpty());
	}
	
	@Test
	void testGetArcsList() {
		assertEquals(0, placePos.getArcsList().size());
	}

	@Test
	void testAddArc() {
		assertEquals(0, placePos.getArcsList().size());
		placePos.addArc(a);
		assertEquals(1, placePos.getArcsList().size());
	}
	
	@Test
	void testRemoveArc() {
		assertEquals(0, placePos.getArcsList().size());
		placePos.addArc(a);
		assertEquals(1, placePos.getArcsList().size());
		placePos.removeArc(a);
		assertEquals(0, placePos.getArcsList().size());
	}
	
	@Test
	void testAddTokens() {
		placePos.addTokens(4); // addTokens with positive integer as argument
		assertEquals(7, placePos.getTokensNumber());
		placePos.addTokens(-2); // addTokens with negative integer as argument
		assertEquals(9, placePos.getTokensNumber());
	}

	@Test
	void testRemoveTokens() {
		placePos.removeTokens(2); // removeTokens with positive integer as argument smaller than current tokens number
		assertEquals(1, placePos.getTokensNumber());
		placePos.removeTokens(9); // removeTokens with positive integer as argument bigger than current tokens number
		assertEquals(0, placePos.getTokensNumber());
		placePos.setTokensNumber(4);
		placePos.removeTokens(-2); // removeTokens with negative integer as argument which the absolute value is smaller than current tokens number
		assertEquals(2, placePos.getTokensNumber());
		placePos.removeTokens(-3); // removeTokens with negative integer as argument which the absolute value is bigger than current tokens number
		assertEquals(0, placePos.getTokensNumber());
	}

}
