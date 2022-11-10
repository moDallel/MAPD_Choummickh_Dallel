package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import PetriNetwork.EnteringArc;
import PetriNetwork.Place;
import PetriNetwork.Transition;

class EnteringArcTest {
	
	Transition t;
	Place p;
	EnteringArc a;
	
	@BeforeEach
	void setUp() {
		t = new Transition();
		p = new Place(3); 
		a = new EnteringArc(2,p,t);
		
	}
	
	@Order(1)
	@Test
	void testEnteringArc() {
		assertNotNull(a);
		assertTrue(a instanceof EnteringArc);
	}

	@Order(1)
	@Test
	void testIsEnteringArc() {
		assertTrue(a.isEnteringArc());
	}
	
	@Order(1)
	@Test
	void testIsZero() {
		assertFalse(a.isZero());
	}

	@Order(1)
	@Test
	void testIsEmptying() {
		assertFalse(a.isEmptying());
	}
	
	@Order(1)
	@Test
	void testIsExitingArc() {
		assertFalse(a.isExitingArc());
	}
	
	@Order(1)
	@Test
	void testIsActive() {
		// active entering arc ( place tokens > arc weight )
		assertTrue(a.isActive());
		// active entering arc ( place tokens = arc weight )
		Place p2 = new Place(5);
		EnteringArc a2 = new EnteringArc(5,p2,t);
		assertTrue(a2.isActive());
		// non active entering arc ( place tokens < arc weight )
		Place p1 = new Place(2);
		EnteringArc a1 = new EnteringArc(7,p1,t);
		assertFalse(a1.isActive());
			
	}

	@Order(1)
	@Test
	void testExecute() {
		assertEquals(3,p.getTokensNumber());
		a.execute();
		assertEquals(1,p.getTokensNumber());
		
	}



}
