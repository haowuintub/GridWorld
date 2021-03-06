package hausaufgabe;

import gridworld.framework.actor.Actor;
import gridworld.framework.actor.Critter;
import gridworld.framework.actor.Flower;
import gridworld.framework.grid.Grid;
import gridworld.framework.grid.Location;

import java.util.ArrayList;


/**
 * @ Hao Wu
 */

public class Farmer extends Critter {

// Attribute
    int height;


//Konstruktoren
    Farmer() {
        height = 180;
    }


    Farmer(int height) {
        this.height = height;
    }


//Klassenmethoden

    public boolean canMove(Location location) {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        if (!gr.isValid(location))
            return false;
        Actor neighbor = gr.get(location);
        return (neighbor == null);
    }


    private Location compare(Location theShorterOne, Location comparedLocation, double difference_TheShorterOne_Before) {

        Location here = getLocation();
        int row = here.getRow();
        int col = here.getCol();

        int row_difference = Math.abs(comparedLocation.getRow() - row);
        int col_difference = Math.abs(comparedLocation.getCol() - col);
        double r = (Math.sqrt(row_difference * row_difference + col_difference * col_difference));

        if (r < difference_TheShorterOne_Before) {
            difference_TheShorterOne_Before = r;
            theShorterOne = comparedLocation;
            return theShorterOne;
        } else {
            return theShorterOne;
        }
    }


    public void turn() {
        setDirection(getDirection() + Location.HALF_RIGHT);
    }


    @Override
    public ArrayList<Actor> getActors() {

        ArrayList<Actor> neighboringActors = new ArrayList<>();
        ArrayList<Location> nextLocation = adjacentLocation();

        Grid<Actor> gr = getGrid();
        if (gr == null) {
            return neighboringActors;
        }
        else {

            for (Location location : nextLocation) {
                if (gr.isValid(location)) {
                    Actor neighbor = gr.get(location);
                    neighboringActors.add(neighbor);
                }
            }
            return neighboringActors;
        }
    }

    @Override
    public void processActors(ArrayList<Actor> actors) {
        for (Actor a : actors) {
            if (a instanceof Flower) {
               a.removeSelfFromGrid();
            }
        }
    }

    @Override
    public void makeMove(Location loc) {
        if (loc == null) {

            if (Math.random() <= 1 / 2) {
                setDirection(getDirection() + Location.HALF_RIGHT);
            }
            else {
                this.setDirection(this.getDirection() - 180);
                Location lastLocation = loc.getAdjacentLocation(getDirection());
                moveTo(lastLocation);
            }

        }
        else {
            moveTo(loc);
        }
    }
}
