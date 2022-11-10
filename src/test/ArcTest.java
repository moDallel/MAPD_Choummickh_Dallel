package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import PetriNetwork.Arc;
import PetriNetwork.Place;
import PetriNetwork.Transition;

class ArcTest {
	
	Transition t;
	Place p;
	Arc a;
	
	@BeforeEach
	void setUp() {
		t = new Transition();
		p = new Place(3); 
		a = new Arc(2,p,t);
		
	}

	@Order(1)
	@Test
	void testArc() {
		// constructor with weight <= 1
		Arc a1 = new Arc(-7,p,t);
		assertEquals(1,a1.getWeight());
		assertNotNull(a1);
		assertTrue(a1 instanceof Arc);
		
		// constructor with weight >= 1
		Arc a2 = new Arc(7,p,t);
		assertEquals(7,a2.getWeight());
		assertNotNull(a2);
		assertTrue(a2 instanceof Arc);
		
	}
	
	@Order(1)
	@Test
	void testGetWeight() {
		assertEquals(2,a.getWeight());
	}

	@Order(1)
	@Test
	void testSetWeight() {
		// SetWeight with argument newWeight <= 1
		a.setWeight(0);
		assertEquals(1,a.getWeight());
		// SetWeight with argument newWeight >= 1
		a.setWeight(4);
		assertEquals(4,a.getWeight());
	}
	
	@Order(1)
	@Test
	void testGetPlace() {
		assertEquals(p,a.getPlace());
	}

	@Order(1)
	@Test
	void testGetTransition() {
		assertEquals(t,a.getTransition());
	}

	@Order(1)
	@Test
	void testIsEnteringArc() {
		assertFalse(a.isEnteringArc());
	}

	@Order(1)
	@Test
	void testIsExitingArc() {
		assertFalse(a.isExitingArc());
	}

}
