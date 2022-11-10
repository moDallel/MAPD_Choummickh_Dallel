package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import PetriNetwork.ExitingArc;
import PetriNetwork.Place;
import PetriNetwork.Transition;

class ExitingArcTest {
	
	Transition t;
	Place p;
	ExitingArc a;
	
	@BeforeEach
	void setUp() {
		t = new Transition();
		p = new Place(3); 
		a = new ExitingArc(2,p,t);
		
	}

	@Order(1)
	@Test
	void testExitingArc() {
		assertNotNull(a);
		assertTrue(a instanceof ExitingArc);
	}
	
	@Order(1)	
	@Test
	void testIsExitingArc() {
		assertTrue(a.isExitingArc());
	}
	
	@Order(1)
	@Test
	void testIsEnteringArc() {
		assertFalse(a.isEnteringArc());
	}
	
	@Order(1)
	@Test
	void testExecute() {
		assertEquals(3,p.getTokensNumber());
		a.execute();
		assertEquals(5,p.getTokensNumber());
	}

}
