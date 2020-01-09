package hausaufgabe;

import gridworld.framework.actor.ActorWorld;
import gridworld.framework.actor.Flower;

/**
 * @ Stefan Schulz, Hao Wu
 */

public interface FarmWorldRunnerInterface {

    /*
     * Tipp: Erstellt zuerst alle hier genannten Klassen (erstmal leer), damit
     * vermeidet ihr Compiler-Fehler. Das geht z.B. mit Alt+Enter.
     */

    /*
     * Erstellt eine neue ActorWorld mit einem Grid der Größe x*y (x Felder
     * horizontal, y Felder vertikal).
     */
    public ActorWorld createNewWorldWithGridSize(int x, int y);

    /*
     * Setzt ein Animal auf das mit x (horizontale Position) und y (vertikale
     * Position) bestimmte Feld, falls das Feld im Grid existiert und leer ist.
     */
    public Animal addAnimalIfFieldEmpty(int x, int y);

    /*
     * Setzt eine Goat auf das mit x (horizontale Position) und y (vertikale
     * Position) bestimmte Feld, falls das Feld im Grid existiert und leer ist.
     */
    public Goat addGoatIfFieldEmpty(int x, int y);

    /*
     * Setzt ein GoatKid auf das mit x (horizontale Position) und y (vertikale
     * Position) bestimmte Feld, falls das Feld im Grid existiert und leer ist.
     */
    public GoatKid addGoatKidIfFieldEmpty(int x, int y);

    /*
     * Setzt einen Farmer auf das mit x (horizontale Position) und y (vertikale
     * Position) bestimmte Feld, falls das Feld im Grid existiert und leer ist.
     */
    public Farmer addFarmerIfFieldEmpty(int x, int y);

    /*
     * Setzt einen CreatorFarmer auf das mit x (horizontale Position) und y
     * (vertikale Position) bestimmte Feld, falls das Feld im Grid existiert und
     * leer ist.
     */
    public CreatorFarmer addCreatorFarmerIfFieldEmpty(int x, int y);

    /*
     * Setzt ein MilkStorage auf das mit x (horizontale Position) und y (vertikale
     * Position) bestimmte Feld, falls das Feld im Grid existiert und leer ist und
     * noch kein MilkStorage existiert.
     */
    public MilkStorage addMilkStorageIfFieldEmpty(int x, int y);

    /*
     * Setzt einen GoatMilker auf das mit x (horizontale Position) und y
     * (vertikale Position) bestimmte Feld, falls das Feld im Grid existiert und
     * leer ist.
     */
    public GoatMilker addGoatMilkerIfFieldEmpty(int x, int y);

    /*
     * Setzt eine Flower auf das mit x (horizontale Position) und y (vertikale
     * Position) bestimmte Feld, falls das Feld im Grid existiert und leer ist.
     */
    public Flower addFlowerIfFieldEmpty(int x, int y);

    /*
     * Setzt einen Rock auf das mit x (horizontale Position) und y (vertikale
     * Position) bestimmte Feld, falls das Feld im Grid existiert und leer ist.
     */
    public Rock addRockIfFieldEmpty(int x, int y);

    /*
     * Gibt die toString()-Methode des Actors zurück, der sich auf dem mit x
     * (horizontale Position) und y (vertikale Position) bestimmten Feld befindet.
     * Gibt null zurück, falls das Feld im Grid nicht existiert oder leer ist.
     */
    public String getToStringOfActorInField(int x, int y);

    /* Laesst die Simulation n Steps weiterlaufen. */
    public void runNSteps(int n);
}
