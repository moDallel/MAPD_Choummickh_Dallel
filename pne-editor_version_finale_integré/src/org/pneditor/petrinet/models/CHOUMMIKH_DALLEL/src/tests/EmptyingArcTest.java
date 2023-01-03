package org.pneditor.petrinet.models.CHOUMMIKH_DALLEL.src.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import org.pneditor.petrinet.models.CHOUMMIKH_DALLEL.src.PetriNetwork.*;

class EmptyingArcTest {
	
	Transition t;
	Place p;
	EmptyingArc a;
	
	@BeforeEach
	void setUp() {
		t = new Transition();
		p = new Place(3); 
		a = new EmptyingArc(p,t); // Active EmptyingArc since his place has a non null tokens number.
	}
	
	@Order(1)
	@Test
	void testEmptyingArc() {
		assertNotNull(a);
		assertTrue(a instanceof EmptyingArc);
	}
	
	@Order(1)
	@Test
	void testIsEmptying() {
		assertTrue(a.isEmptying());
	}

	@Order(1)
	@Test
	void testExecute() {
		assertEquals(3,p.getTokensNumber());
		a.execute();
		assertEquals(0,p.getTokensNumber());
	}

	@Order(1)
	@Test
	void testIsActive() {
		assertTrue(a.isActive());
		// non active Emptying Arc
		Place p1 = new Place(0);
		EmptyingArc a1 = new EmptyingArc(p1,t);
		assertFalse(a1.isActive());
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

}
