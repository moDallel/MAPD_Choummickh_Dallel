package org.pneditor.petrinet.models.CHOUMMIKH_DALLEL.src.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import org.pneditor.petrinet.models.CHOUMMIKH_DALLEL.src.PetriNetwork.*;
import org.pneditor.petrinet.models.CHOUMMIKH_DALLEL.src.exceptions.*;



class PetriNetworkTest {
	
	PetriNetwork pn ;
	Transition t;
	Place p;
	
	@BeforeEach
	void setUp() {
		pn = new PetriNetwork();
		t = new Transition();
		p = new Place(0);
		
	}
	
	@Order(1)
	@Test
	void testPetriNetwork() {
		assertNotNull(pn);
		assertTrue(pn instanceof PetriNetwork);
		assertEquals(0,pn.getArcsList().size());
		assertEquals(0,pn.getPlacesList().size());
		assertEquals(0,pn.getTransitionsList().size());
	}
	
	@Test
	void testAddPlace() {
		pn.addPlace(3);
		pn.addPlace(0);
		pn.addPlace(-7);
		assertEquals(3,pn.getPlacesList().size());
	}

	@Test
	void testAddTransition() {
		pn.addTransition();
		pn.addTransition();
		assertEquals(2,pn.getTransitionsList().size());
	}

	@Test
	void testAddEnteringArcIntPlaceTransition() throws NullObjectException, ExistantArcException {
		// null argument
		NullObjectException thrown1 = Assertions.assertThrows(NullObjectException.class, () -> {
	           pn.addEnteringArc(4, null, t);
	    });
		Assertions.assertEquals(" Argument place or transition is null ! ", thrown1.getMessage());
		
		NullObjectException thrown2 = Assertions.assertThrows(NullObjectException.class, () -> {
	           pn.addEnteringArc(4, p, null);
	    });
		Assertions.assertEquals(" Argument place or transition is null ! ", thrown2.getMessage());
		
		// normal use 
		pn.addEnteringArc(4, p, t);
		assertEquals(1,pn.getArcsList().size());
		
		// arc already exist
		ExistantArcException thrown3 = Assertions.assertThrows(ExistantArcException.class, () -> {
	           pn.addEnteringArc(2, p, t);
	    });
		Assertions.assertEquals("this arc is already existing!", thrown3.getMessage());
		
		assertEquals(1,pn.getArcsList().size());
	}

	@Test
	void testAddEnteringArcPlaceTransition() throws NullObjectException, ExistantArcException {
		// this method is not tested since it calls only the previous method AddEnteringArcIntPlaceTransition()
		pn.addEnteringArc(p, t);
		assertEquals(1,pn.getArcsList().size());
	}

	@Test
	void testAddExitingArcIntPlaceTransition() throws NullObjectException, ExistantArcException {
		// null argument
		NullObjectException thrown1 = Assertions.assertThrows(NullObjectException.class, () -> {
	           pn.addExitingArc(0, null, t);
	    });
		Assertions.assertEquals(" Argument place or transition is null ! ", thrown1.getMessage());
		
		NullObjectException thrown2 = Assertions.assertThrows(NullObjectException.class, () -> {
	           pn.addExitingArc(4, p, null);
	    });
		Assertions.assertEquals(" Argument place or transition is null ! ", thrown2.getMessage());
		
		// normal use 
		pn.addExitingArc(4, p, t);
		assertEquals(1,pn.getArcsList().size());
		
		// arc already exist
		ExistantArcException thrown3 = Assertions.assertThrows(ExistantArcException.class, () -> {
	           pn.addExitingArc(2, p, t);
	    });
		Assertions.assertEquals("this arc is already existing!", thrown3.getMessage());
		
		assertEquals(1,pn.getArcsList().size());
	}

	@Test
	void testAddExitingArcPlaceTransition() throws NullObjectException, ExistantArcException {
		// this method is not tested since it calls only the previous method AddEnteringArcIntPlaceTransition()
		pn.addExitingArc(p, t);
		assertEquals(1,pn.getArcsList().size());
	}

	@Test
	void testAddZeroArc() throws NullObjectException, ExistantArcException {
		// null argument
		NullObjectException thrown1 = Assertions.assertThrows(NullObjectException.class, () -> {
	           pn.addZeroArc(null, t);
	    });
		Assertions.assertEquals(" Argument place or transition is null ! ", thrown1.getMessage());
		
		NullObjectException thrown2 = Assertions.assertThrows(NullObjectException.class, () -> {
	           pn.addZeroArc(p, null);
	    });
		Assertions.assertEquals(" Argument place or transition is null ! ", thrown2.getMessage());
		
		// normal use 
		pn.addZeroArc(p, t);
		assertEquals(1,pn.getArcsList().size());
		
		// arc already exist
		ExistantArcException thrown3 = Assertions.assertThrows(ExistantArcException.class, () -> {
	           pn.addZeroArc(p, t);
	    });
		Assertions.assertEquals("this arc is already existing!", thrown3.getMessage());
		
		assertEquals(1,pn.getArcsList().size());
	}

	@Test
	void testAddEmptyingArc() throws NullObjectException, ExistantArcException {
		// null argument
		NullObjectException thrown1 = Assertions.assertThrows(NullObjectException.class, () -> {
	           pn.addEmptyingArc(null, t);
	    });
		Assertions.assertEquals(" Argument place or transition is null ! ", thrown1.getMessage());
		
		NullObjectException thrown2 = Assertions.assertThrows(NullObjectException.class, () -> {
	           pn.addEmptyingArc(p, null);
	    });
		Assertions.assertEquals(" Argument place or transition is null ! ", thrown2.getMessage());
		
		// normal use 
		pn.addEmptyingArc(p,t);
		assertEquals(1,pn.getArcsList().size());
		
		// arc already exist
		ExistantArcException thrown3 = Assertions.assertThrows(ExistantArcException.class, () -> {
	           pn.addEmptyingArc(p, t);
	    });
		Assertions.assertEquals("this arc is already existing!", thrown3.getMessage());
		
		assertEquals(1,pn.getArcsList().size());
	}

	@Test
	void testRemoveArc() throws NullObjectException, ExistantArcException  {
		
		NullObjectException thrown = Assertions.assertThrows(NullObjectException.class, () -> {
	           pn.removeArc(null);
	    });
	    Assertions.assertEquals(" Argument arc is null ! ", thrown.getMessage());
	    pn.addPlace(2);
	    pn.addTransition();
	    pn.addEnteringArc(1, pn.getPlacesList().get(0), pn.getTransitionsList().get(0));
	    Arc a1 = pn.getArcsList().get(0);
	    pn.addExitingArc(4, pn.getPlacesList().get(0), pn.getTransitionsList().get(0));
	    Arc a2 = pn.getArcsList().get(1);
	    assertEquals(2,pn.getArcsList().size());
	    pn.removeArc(a1);
	    assertFalse(pn.getArcsList().contains(a1));
	    assertEquals(1,pn.getArcsList().size());
	    pn.removeArc(a2);
	    assertFalse(pn.getArcsList().contains(a2));
	    assertEquals(0,pn.getArcsList().size());
	}

	@Test
	void testRemoveTransition() throws NullObjectException, ExistantArcException {
		
		NullObjectException thrown = Assertions.assertThrows(NullObjectException.class, () -> {
	           pn.removeTransition(null);
	    });
	    Assertions.assertEquals(" Argument transition is null ! ", thrown.getMessage());
	    pn.addTransition();
	    t = pn.getTransitionsList().get(0);
	    pn.addEnteringArc(4,p, t);
	    pn.addExitingArc(7, p, t);
	    pn.removeTransition(t);
	    assertFalse(pn.getTransitionsList().contains(t));
	}

	@Test
	void testRemovePlace() throws NullObjectException, ExistantArcException {
		
		NullObjectException thrown = Assertions.assertThrows(NullObjectException.class, () -> {
	           pn.removePlace(null);
	    });
	    Assertions.assertEquals(" Argument place is null ! ", thrown.getMessage());
	    pn.addPlace(1);
	    Place p1 = pn.getPlacesList().get(0);
	    pn.addEnteringArc(4,p1, t);
	    pn.removePlace(p1);
	    assertFalse(pn.getPlacesList().contains(p1));
	    
	}

	@Test
	void testFirableTransitions() throws NullObjectException,ExistantArcException {
		assertEquals(0,pn.firableTransitions().size()); // at the begining the list of firable transitions should be empty
		// we will add two firable transitions and one non firable transition 
		pn.addTransition();
		Transition t1Firable = pn.getTransitionsList().get(0);
		pn.addPlace(3);
		Place place1 = pn.getPlacesList().get(0);
		pn.addEnteringArc(2, place1, t1Firable);
		pn.addTransition();
		Transition t2Firable = pn.getTransitionsList().get(1);
		pn.addPlace(5);
		Place place2 = pn.getPlacesList().get(1);
		pn.addEnteringArc(5, place2, t2Firable);
		pn.addTransition();
		Transition t3NonFirable = pn.getTransitionsList().get(2);
		pn.addPlace(4);
		Place place3 = pn.getPlacesList().get(2);
		pn.addEnteringArc(7, place3, t3NonFirable);
		assertEquals(2,pn.firableTransitions().size()); 
	}

	@Test
	void testFire() throws NullObjectException , NotFirableTransitionException, ExistantArcException {
		
		t = null;
		NullObjectException thrown = Assertions.assertThrows(NullObjectException.class, () -> {
	           pn.fire(t);
	    });
	    Assertions.assertEquals("The transition doesn't have to be a null object !", thrown.getMessage());
	    pn.addTransition();
	    pn.addPlace(1);
	    t = pn.getTransitionsList().get(0);
	    pn.addEnteringArc(3, pn.getPlacesList().get(0),t );
	    NotFirableTransitionException thrown2 = Assertions.assertThrows(NotFirableTransitionException.class, () -> {
	           pn.fire(t);
	    });
	    Assertions.assertEquals("The given transition is not firable", thrown2.getMessage());
	    pn.addTransition();
	    t = pn.getTransitionsList().get(1);
	    pn.addEnteringArc(1, pn.getPlacesList().get(0),t );
	    pn.fire(t); // the methode fire was already tested in the class TransitionTest
	}

	@Test
	void testAddTokens() throws InexistantPlaceException, NullObjectException  {
		
		Place p = new Place(3);
		NullObjectException thrown = Assertions.assertThrows(NullObjectException.class, () -> {
	           pn.addTokens(null,1);
	    });
	    Assertions.assertEquals(" Argument place is null ! ", thrown.getMessage());
	    InexistantPlaceException thrown2 = Assertions.assertThrows(InexistantPlaceException.class, () -> {
	           pn.addTokens(p,1);
	    });
	    Assertions.assertEquals(" This place does not exist in the arc list ! ", thrown2.getMessage());
	    pn.addPlace(3);
	    pn.addTokens(pn.getPlacesList().get(0),1);
	    assertEquals(4,pn.getPlacesList().get(0).getTokensNumber());
	    // the method addTokens was tested in the class Place 
	    
	}

	@Test
	void testRemoveTokens() throws InexistantPlaceException, NullObjectException {
		
		Place p = new Place(3);
		NullObjectException thrown = Assertions.assertThrows(NullObjectException.class, () -> {
	           pn.removeTokens(null,1);
	    });
	    Assertions.assertEquals(" Argument place is null ! ", thrown.getMessage());
	    InexistantPlaceException thrown2 = Assertions.assertThrows(InexistantPlaceException.class, () -> {
	           pn.removeTokens(p,1);
	    });
	    Assertions.assertEquals(" This place does not exist in the arc list ! ", thrown2.getMessage());
	    pn.addPlace(3);
	    pn.removeTokens(pn.getPlacesList().get(0),1);
	    assertEquals(2,pn.getPlacesList().get(0).getTokensNumber());
	    // the method removeTokens was tested in the class Place 
		
	}

	@Test
	void testSetArcWeight() throws InexistantArcException,NullObjectException,NoAttributeWeightException, ExistantArcException {
		
		NullObjectException thrown = Assertions.assertThrows(NullObjectException.class, () -> {
	           pn.setArcWeight(null,1);
	    });
	    Assertions.assertEquals(" Argument arc is null !!! ", thrown.getMessage());
	    
	    t = new Transition();
	    pn.addPlace(2);
	    Arc a = new Arc(2, pn.getPlacesList().get(0), t);
	    
	    InexistantArcException thrown2 = Assertions.assertThrows(InexistantArcException.class, () -> {
	           pn.setArcWeight(a,1);
	    });
	    Assertions.assertEquals(" This arc does not exist in the arc list !!! ", thrown2.getMessage());
	    
	    pn.addZeroArc(pn.getPlacesList().get(0), t);
	    
	    NoAttributeWeightException thrown3 = Assertions.assertThrows(NoAttributeWeightException.class, () -> {
	           pn.setArcWeight(pn.getArcsList().get(0),1);
	    });
	    Assertions.assertEquals(" ZeroArc/EmtyingArc has no attribute weight ! ", thrown3.getMessage());
	    
	    Place p1 = new Place(7) ;
	    pn.addEmptyingArc(p1, t);
	    NoAttributeWeightException thrown4 = Assertions.assertThrows(NoAttributeWeightException.class, () -> {
	           pn.setArcWeight(pn.getArcsList().get(1),4);
	    });
	    Assertions.assertEquals(" ZeroArc/EmtyingArc has no attribute weight ! ", thrown4.getMessage());
	    
	    pn.addEnteringArc(2,p, t);
	    pn.setArcWeight(pn.getArcsList().get(2),1);
	    assertEquals(1,pn.getArcsList().get(2).getWeight());
	     
	}
	
	@Test
	void testToString() throws NullObjectException, ExistantArcException {
		pn.addPlace(1);
		Place p1 = pn.getPlacesList().get(0) ;
		pn.addPlace(2);
		Place p2 = pn.getPlacesList().get(1) ;
		pn.addPlace(0);
		Place p3 = pn.getPlacesList().get(2) ;
		pn.addPlace(3);
		Place p4 = pn.getPlacesList().get(3) ;
		pn.addTransition();
		Transition t0 = pn.getTransitionsList().get(0);
		pn.addTransition();
		Transition t1 = pn.getTransitionsList().get(1);
		pn.addEnteringArc(1,p1,t0);
		pn.addEnteringArc(5,p1,t1);
		pn.addEmptyingArc(p4, t1);
		pn.addZeroArc(p3, t0);
		pn.addExitingArc(7, p4, t0);
		pn.addExitingArc(4, p2, t1);
		System.out.println(pn.toString());
		String test = "Réseau de Petri \n"+"4 place(s) \n"+ "2 transition(s) \n"+ "6 arc(s) \n"+ "--------------------------------------- \n"+ "Liste des places : \n"+ "1 : place avec 1 jetons, 2 arc(s) entrant(s) dont 2 simple(s), 0 zéro arc(s), 0 arc(s) videur(s) et 0 arc(s) simple(s) sortant(s) \n"+"2 : place avec 2 jetons, 0 arc(s) entrant(s) dont 0 simple(s), 0 zéro arc(s), 0 arc(s) videur(s) et 1 arc(s) simple(s) sortant(s) \n"+ "3 : place avec 0 jetons, 1 arc(s) entrant(s) dont 0 simple(s), 1 zéro arc(s), 0 arc(s) videur(s) et 0 arc(s) simple(s) sortant(s) \n"+ "4 : place avec 3 jetons, 1 arc(s) entrant(s) dont 0 simple(s), 0 zéro arc(s), 1 arc(s) videur(s) et 1 arc(s) simple(s) sortant(s) \n" +"--------------------------------------- \n"+ "Liste des transitions : \n"+ "1 : transition, 2 arc(s) entrant(s) dont 1 simple(s), 1 zéro arc(s), 0 arc(s) videur(s) et 1 arc(s) sortant(s) \n"+"2 : transition, 2 arc(s) entrant(s) dont 1 simple(s), 0 zéro arc(s), 1 arc(s) videur(s) et 1 arc(s) sortant(s) \n" +"--------------------------------------- \n"+ "Liste des arcs : \n"+ "1 : arc simple entrant de poids 1 (place avec 1 jetons vers transition) \n"+ "2 : arc simple entrant de poids 5 (place avec 1 jetons vers transition) \n"+ "3 : arc videur (place avec 3 jetons vers transition) \n"+ "4 : zéro arc (place avec 0 jetons vers transition) \n"+ "5 : arc simple sortant de poids 7 (transition vers place avec 3 jetons) \n"+ "6 : arc simple sortant de poids 4 (transition vers place avec 2 jetons) \n";
		assertTrue(pn.toString().equals(test));
	}

}
