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

    /**
     * Constructs a red animal.
     */
//Konstruktoren
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


//Klassenmethoden

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
        return (neighbor == null);
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


//@Override-Klassenmethoden
    @Override
    public void act()
    {
        if (canMove()){
            move();
            age++;
        }
        else
            turn();
    }




    @Override
    public String toString() {
        return getClass().getName() + "[" + ",age=" + age + /*",location=" + location + ",direction="
                + direction + ",color=" + color +*/ "]";
    }

}
