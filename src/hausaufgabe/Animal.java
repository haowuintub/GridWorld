package hausaufgabe;

import gridworld.framework.actor.Actor;
import gridworld.framework.actor.Flower;
import gridworld.framework.grid.Grid;
import gridworld.framework.grid.Location;

import java.awt.*;

/**
 * @ Hao Wu
 */

public class Animal extends Actor {

//Attribute
    public int age ;

//    public int getAge() {
//        return age;
//    }


    /**
     * Constructs a red animal.
     */
    public Animal()
    {   age = 0 ;
        setColor(Color.RED);
    }

    /**
     * Constructs a animal of a given color.
     * @param animalColor the color for this animal
     */
    public Animal(Color animalColor)
    {
        setColor(animalColor);
    }




    /**
     * Moves if it can move, turns otherwise.
     */
    public void act()
    {
        if (canMove()){
            move();
            age++;
        }
        else
            turn();
    }


    /**
     * Turns the animal 45 degrees to the right without changing its location.
     */
    public void turn()
    {
        setDirection(getDirection() + Location.HALF_RIGHT);
    }


    /**
     * Moves the animal forward(, putting a flower into the location it previously
     * occupied.)
     */
    public void move()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
            moveTo(next);
        else
            removeSelfFromGrid();
        Flower flower = new Flower(getColor());
        flower.putSelfInGrid(gr, loc);
    }


    /**
     * Tests whether this animal can move forward into a location that is empty or
     * contains a flower.
     * @return true if this animal can move.
     */
    public boolean canMove()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (!gr.isValid(next))
            return false;
        Actor neighbor = gr.get(next);
        return (neighbor == null) /*|| (neighbor instanceof Flower)*/;
        // ok to move into empty location (or onto flower)
        // not ok to move onto any other actor
    }


//    Sorgt dafur, dass die graphische Oberfläche das Alter anzeigt, wenn man mit der Maus draufgeht.
    @Override
    public String toString() {
        return getClass().getName() + "[" + ",age=" + age + /*",location=" + location + ",direction="
                + direction + ",color=" + color +*/ "]";
    }

}
