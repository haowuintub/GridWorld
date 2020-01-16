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

    Farmer() {
        height = 300;
    }

    Farmer(int height) {
        this.height = height;
    }


    //    die Anzahl der Blumenwirte variieren
    void farmerRemoveSelfFromGrid(Farmer farmer) {
        if (farmer == null) {
            System.out.println("This ist not such farmer!");
        } else {
            farmer.removeSelfFromGrid();
        }
    }


    public ArrayList<Location> getNextLocations() {
        ArrayList<Location> nextLocation = new ArrayList<>();

        Location loc = getLocation();

        Location nextEAST = loc.getAdjacentLocation(Location.EAST);
        Location nextSOUTHEAST = loc.getAdjacentLocation(Location.SOUTHEAST);
        Location nextSOUTH = loc.getAdjacentLocation(Location.SOUTH);
        Location nextSOUTHWEST = loc.getAdjacentLocation(Location.SOUTHWEST);
        Location nextWEST = loc.getAdjacentLocation(Location.WEST);
        Location nextNORTHWEST = loc.getAdjacentLocation(Location.NORTHWEST);
        Location nextNORTH = loc.getAdjacentLocation(Location.NORTH);
        Location nextNORTHEAST = loc.getAdjacentLocation(Location.NORTHEAST);

        nextLocation.add(nextEAST);
        nextLocation.add(nextSOUTHEAST);
        nextLocation.add(nextSOUTH);
        nextLocation.add(nextSOUTHWEST);
        nextLocation.add(nextWEST);
        nextLocation.add(nextNORTHWEST);
        nextLocation.add(nextNORTH);
        nextLocation.add(nextNORTHEAST);

        return nextLocation;
    }


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
        ArrayList<Location> nextLocation = this.getNextLocations();

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
        int n = actors.size();
        if (n == 0) {
            return;
        } else {
            for (Actor a : actors) {
                if (a instanceof Flower) {
                    a.removeSelfFromGrid();
                }
            }
        }
    }

    @Override
    public ArrayList<Location> getMoveLocations() {

        ArrayList<Location> neighboringLocation = this.getNextLocations();
        ArrayList<Location> neighboringCanMoveLocation = new ArrayList<>();

        for (Location location : neighboringLocation) {
            if (canMove(location)) {
                neighboringCanMoveLocation.add(location);
            }
        }
        return neighboringCanMoveLocation;
    }

    @Override
    public Location selectMoveLocation(ArrayList<Location> locs) {
        Location theShorterOne = getLocation();
        double difference_TheShorterOne_Before = 1000000000;

        int n = locs.size();
        if (n == 0) {
            return getLocation();
        } else {
            for (Location location : locs) {
                theShorterOne = compare(theShorterOne, location, difference_TheShorterOne_Before);
            }
            return theShorterOne;
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
