package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import PetriNetwork.EmptyingArc;
import PetriNetwork.EnteringArc;
import PetriNetwork.ExitingArc;
import PetriNetwork.Place;
import PetriNetwork.Transition;
import PetriNetwork.ZeroArc;

class TransitionTest {
	Transition t ;
	Transition tSimpleNonFirable; // place----->transition 
	Place pSource3;
	Place pSource1;
	Place placeSourceEmpty;
	Place placeDes1;
	Place placeDes3;
	Place placeDesEmpty;
	Place placeMixte5;
	EnteringArc entArc1;
	EnteringArc entArc2;
	EnteringArc entArc3;
	ExitingArc exArc1;
	ExitingArc exArc2;
	ExitingArc exArc3;
	
	@BeforeEach
	void setUp() {
		t = new Transition();
		tSimpleNonFirable = new Transition();
		pSource3 = new Place(3);
		pSource1 = new Place(1);
		placeSourceEmpty = new Place(0);
		placeDes1 = new Place(1);
		placeDes3 = new Place(3);
		placeDesEmpty = new Place(3);
		placeMixte5 = new Place(5);
		entArc1 = new EnteringArc(5,pSource1,t);
		entArc2 = new EnteringArc(1,pSource3,t);
		entArc3 = new EnteringArc(1,placeSourceEmpty,t);

		exArc3 = new ExitingArc(1,placeDesEmpty,t);
		tSimpleNonFirable.addEntringArc(entArc1); 
	}
	
	@Order(1)
	@Test
	void testTransition() {
		Transition t1 = new Transition();
		assertNotNull(t1);
		assertTrue(t1 instanceof Transition);
	}
	
	@Order(1)
	@Test
	void testGetEnteringArcList() {
		assertEquals(0, t.getEnteringArcList().size());
	}

	@Order(1)
	@Test
	void testGetExitingArcList() {
		assertEquals(0, t.getExitingArcList().size());
	}
	
	@Order(1)
	@Test
	void testAddEntringArc() {
		// add entering arc
		assertEquals(0, t.getEnteringArcList().size());
		t.addEntringArc(entArc1);
		assertEquals(1, t.getEnteringArcList().size());
		// add zero arc
		ZeroArc zArc = new ZeroArc(pSource3,t);
		t.addEntringArc(zArc);
		assertEquals(2, t.getEnteringArcList().size());
		// add emptying arc
		EmptyingArc empArc = new EmptyingArc(placeSourceEmpty,t);
		t.addEntringArc(empArc);
		assertEquals(3, t.getEnteringArcList().size());
	}

	@Order(1)
	@Test
	void testAddExitingArc() {
		assertEquals(0, t.getExitingArcList().size());
		t.addExitingArc(exArc1);
		assertEquals(1, t.getExitingArcList().size());
	}

	@Order(1)
	@Test
	void testRemoveExitingArc() {
		assertEquals(0, t.getEnteringArcList().size());
		t.addEntringArc(entArc1);
		assertEquals(1, t.getEnteringArcList().size());
		t.removeEntringArc(entArc1);
		assertEquals(0, t.getEnteringArcList().size());
	}
	
	@Order(1)
	@Test
	void testRemoveEntringArc() {
		assertEquals(0, t.getExitingArcList().size());
		t.addExitingArc(exArc1);
		assertEquals(1, t.getExitingArcList().size());
		t.removeExitingArc(exArc1);
		assertEquals(0, t.getExitingArcList().size());
	}
	
	@Order(2)
	@Test
	void testExist() {
		t.addEntringArc(entArc1);
		t.addEntringArc(entArc3);
		assertFalse(t.exist(true,pSource3));
		assertTrue(t.exist(true,pSource1));
		assertTrue(t.exist(true,placeSourceEmpty));
		assertFalse(t.exist(false,pSource1));
		assertFalse(t.exist(false,placeSourceEmpty));
		exArc1 = new ExitingArc(1,placeDes1,t);
		exArc2 = new ExitingArc(1,placeDes3,t);
		t.addExitingArc(exArc1);
		t.addExitingArc(exArc2);
		assertFalse(t.exist(true,placeDes1));
		assertFalse(t.exist(true,placeDes3));
		assertFalse(t.exist(true,placeDesEmpty));
		assertTrue(t.exist(false,placeDes1));
		assertTrue(t.exist(false,placeDes3));
		assertFalse(t.exist(false,placeDesEmpty));
		
	}

	@Order(2)
	@Test
	void testIsFirable() {
		// Transition without any entering arc 
		assertTrue(t.isFirable());
		// Transition with only one entering arc
		Place pSource = new Place(3);
		Transition tSimpleNonFirable = new Transition();
		EnteringArc entArcNonActif = new EnteringArc(5,pSource,tSimpleNonFirable);
		tSimpleNonFirable.addEntringArc(entArcNonActif);
		assertFalse(tSimpleNonFirable.isFirable());
		Transition tSimpleFirable = new Transition();
		EnteringArc entArcActif = new EnteringArc(2,pSource,tSimpleFirable); // weight < place tokens
		tSimpleFirable.addEntringArc(entArcActif);
		assertTrue(tSimpleFirable.isFirable());
		// Transition with inactive ZeroArc
		Transition tNonFirable = new Transition();
		ZeroArc zArc = new ZeroArc(pSource3,tNonFirable);
		tNonFirable.addEntringArc(zArc);
		assertFalse(tNonFirable.isFirable());
		// Transition with active ZeroArc
		Transition tFirable = new Transition();
		ZeroArc zArc2 = new ZeroArc(placeSourceEmpty,tFirable);
		tFirable.addEntringArc(zArc2);
		assertTrue(tFirable.isFirable());
		// Transition with active EmptyingArc
		Transition tFirable2 = new Transition();
		EmptyingArc empArc = new EmptyingArc(pSource3,tFirable2);
		tFirable2.addEntringArc(empArc);
		assertTrue(tFirable2.isFirable());
		// Transition with inactive EmptyingArc
		Transition tNonFirable2 = new Transition();
		EmptyingArc empArc2 = new EmptyingArc(placeSourceEmpty,tNonFirable2);
		tNonFirable2.addEntringArc(empArc2);
		assertFalse(tNonFirable2.isFirable());
		// transition with multiple entering arc (one of which is non actif)
		Transition tMultipleNonFirable = new Transition();
		EmptyingArc empArc3 = new EmptyingArc(pSource3,tMultipleNonFirable);
		tMultipleNonFirable.addEntringArc(empArc3);
		ZeroArc zArc3 = new ZeroArc(placeSourceEmpty,tMultipleNonFirable);
		tMultipleNonFirable.addEntringArc(zArc3);
		EnteringArc entArcNonActif2 = new EnteringArc(7,pSource,tMultipleNonFirable); // weight < place tokens this arc is not actif and should make the transition infirable
		tMultipleNonFirable.addEntringArc(entArcNonActif2);
		assertFalse(tMultipleNonFirable.isFirable());
		// transition with multiple entering arc (all actif)
		Transition tMultipleFirable = new Transition();
		EmptyingArc empArc4 = new EmptyingArc(pSource3,tMultipleFirable);
		tMultipleFirable.addEntringArc(empArc4);
		ZeroArc zArc4 = new ZeroArc(placeSourceEmpty,tMultipleFirable);
		tMultipleFirable.addEntringArc(zArc4);
		EnteringArc entArcActif4 = new EnteringArc(1,pSource,tMultipleFirable);
		tMultipleFirable.addEntringArc(entArcActif4);
		assertTrue(tMultipleFirable.isFirable());
	}

	@Order(2)
	@Test
	void testFire() {
		// fire an unfirable transition
		Place pSource = new Place(5);
		Transition tMultipleNonFirable = new Transition();
		EmptyingArc empArc3 = new EmptyingArc(pSource3,tMultipleNonFirable);
		tMultipleNonFirable.addEntringArc(empArc3);
		ZeroArc zArc3 = new ZeroArc(placeSourceEmpty,tMultipleNonFirable);
		tMultipleNonFirable.addEntringArc(zArc3);
		EnteringArc entArcNonActif2 = new EnteringArc(7,pSource,tMultipleNonFirable); // weight < place tokens this arc is not actif and should make the transition infirable
		tMultipleNonFirable.addEntringArc(entArcNonActif2);
		exArc1 = new ExitingArc(1,placeDes1,tMultipleNonFirable);
		tMultipleNonFirable.addExitingArc(exArc1);
		exArc2 = new ExitingArc(1,placeDes3,tMultipleNonFirable);
		tMultipleNonFirable.addExitingArc(exArc2);
		assertFalse(tMultipleNonFirable.isFirable());
		tMultipleNonFirable.fire();
		// add error caption
		// fire a firable transition with ZeroArc, EmptyingArc, 2*EnteringArc and 2*Exiting Arc
		Transition tMultipleFirable = new Transition();
		EmptyingArc empArc4 = new EmptyingArc(pSource3,tMultipleFirable);
		tMultipleFirable.addEntringArc(empArc4);
		ZeroArc zArc4 = new ZeroArc(placeSourceEmpty,tMultipleFirable);
		tMultipleFirable.addEntringArc(zArc4);
		EnteringArc entArcActif4 = new EnteringArc(1,pSource,tMultipleFirable);
		tMultipleFirable.addEntringArc(entArcActif4);
		EnteringArc entArcActif5 = new EnteringArc(1,pSource1,tMultipleFirable);
		tMultipleFirable.addEntringArc(entArcActif5);
		ExitingArc exArc3 = new ExitingArc(7,placeDes1,tMultipleFirable);
		tMultipleFirable.addExitingArc(exArc3);
		ExitingArc exArc4 = new ExitingArc(4,placeDes3,tMultipleFirable);
		tMultipleFirable.addExitingArc(exArc4);
		assertTrue(tMultipleFirable.isFirable());
		tMultipleFirable.fire();
		assertEquals(0,pSource3.getTokensNumber());
		assertEquals(0,placeSourceEmpty.getTokensNumber());
		assertEquals(4,pSource.getTokensNumber());
		assertEquals(0,pSource1.getTokensNumber());
		assertEquals(8,placeDes1.getTokensNumber());
		assertEquals(7,placeDes3.getTokensNumber());
		
		
		
	}





}
