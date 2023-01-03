package org.pneditor.petrinet.models.CHOUMMIKH_DALLEL.src.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import org.pneditor.petrinet.models.CHOUMMIKH_DALLEL.src.PetriNetwork.*;

class ZeroArcTest {
	
	Transition t;
	Place p;
	ZeroArc a;
	
	@BeforeEach
	void setUp() {
		t = new Transition();
		p = new Place(0); 
		a = new ZeroArc(p,t); // Active ZeroArc since his place has 0 tokens
		
	}
	
	@Order(1)
	@Test
	void testZeroArc() {
		assertNotNull(a);
		assertTrue(a instanceof ZeroArc);
	}
	
	@Order(1)
	@Test
	void testIsZero() {
		assertTrue(a.isZero());
	}

	@Order(1)
	@Test
	void testExecute() {
		assertEquals(0,p.getTokensNumber());
		a.execute();
		assertEquals(0,p.getTokensNumber());
	}

	@Order(1)
	@Test
	void testIsActive() {
		assertTrue(a.isActive());
		// non active Zero Arc
		Place p1 = new Place(4);
		ZeroArc a1 = new ZeroArc(p1,t);
		assertFalse(a1.isActive());
	}

	@Order(1)
	@Test
	void testIsEnteringArc() {
		assertTrue(a.isEnteringArc());
	}

	@Order(1)
	@Test
	void testIsEmptying() {
		assertFalse(a.isEmptying());
	}

}
