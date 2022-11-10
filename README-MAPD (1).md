
# Réalisation d'un réseau de Petri

Notre projet permet de modéliser le réseau de Petri en utilisant le langage Java orienté objet qui se compose essentiellement des éléments suivants: les places et les jetons, les arcs et les transitions. Cette modélisation vient après un travail de conception (Diagrammes de classe et de séquence) et un travail de réalisation (Codage). Le projet se compose de trois paquets (packages) et d'un dossier diagrams :


## Paquet exceptions:
Il regroupe les éventuelles exceptions qui peuvent s’afficher pour un utilisateur lors de l’exécution du code. Les exceptions suivantes permettent de conserver les propriétés d’un réseau de Petri lors de sa création :

- ExistantArcException : Exception qui permet la gestion des arcs doublés.
- InexistantArcException : Exception qui permet de notifier l’utilisateur de la non existence d’un arc au sein du réseau de Petri créé. 
- InexistantPlaceException : Exception qui permet de notifier l’utilisateur de la non existence d’une place au sein du réseau de Petri créé. 
- NoAttributeWeightException : Exception qui se lève lorsque l’utilisateur tente d’attribuer un poids aux arcs zéros et aux arcs videurs. 
- NotFirableTransitionException : Exception qui se lève lorsque l’utilisateur tente de tirer une transition non tirable.
- NullObjectException : Exception qui se lève lorsqu’un objet nul (null) passe en paramètre.


## Paquet PetriNetwork:
C’est le paquet principal du projet, il regroupe toutes les classes essentielles à la création d’un réseau Petri (Arc, Place, Transition…) ainsi que la classe PetriNetwork qui implémente l’interface IPetriNetwork. Celle-ci permet de créer un réseau Petri, d’y ajouter les places, les arcs, les transitions et de tirer ces transitions. 

## Exemple

```javascript
//Création du réseau de Petri petriN
PetriNetwork petriN = new PetriNetwork(); 
//Ajouter une place contenant 5 jetons au réseau
petriN.addPlace(5); 
petrin.addPlace(3);
//Ajouter une transition
petriN.addTransition(); 
//Ajouter un arc entrant à la transition de poids 2
petriN.addEnteringArc(2, petriN.getPlacesList().get(0), petriN.getTransitionsList().get(0)); 
//Ajouter un arc sortant de la transition de poids 3
petriN.addEnteringArc(3, petriN.getPlacesList().get(1), petriN.getTransitionsList().get(0)); 
//tirer la transition
petriN.fire(petriN.getTransitionsList().get(0));
```


## Paquet test:
Ce paquet permet de tester l’intégralité du code (Il y a les tests de chaque classe du paquet PetriNework) en utilisant la technologie JUnit 5. L’utilisateur peut aussi mesurer la couverture des tests Java en utilisant la technologie EclEmma (Existe sur le market place pour l’installation). 
## Couverture des tests

- Clique droit sur le paquet test.
- Sélectionner Coverage As
- Sélectionner JUnit Test. 




## Exigence/JUnit 
Avoir Java 8+. 
## Dossier diagrams

Dossier réservé à la rétro-ingénierie (Pas encore résalisé) en utilisant ObjectAid 1.2.4 de Eclipse

Exigence : ObjectAid 1.2.4 ne marche pas pour les versions Eclpise > 4.19