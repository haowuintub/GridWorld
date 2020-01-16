package hausaufgabe;


import gridworld.framework.actor.Actor;
import gridworld.framework.actor.Rock;
import gridworld.framework.grid.Grid;
import gridworld.framework.grid.Location;

import java.awt.*;
/**
 * @author: Stefan Schulz
 */


class GoatKid extends Animal {

//Konstruktor
    public GoatKid() {
        this.setColor(Color.RED);
    }

//Klassenmethoden
    public void move() {

        Grid<Actor> gr = getGrid();
        if (gr == null) {
            return;
        }

        Location loc = getLocation();
        final double PROBABILITY_LOOKAROUND = 1./6;
        if (Math.random() <= PROBABILITY_LOOKAROUND) {

            loc.getAdjacentLocation(Location.EAST);
            loc.getAdjacentLocation(Location.SOUTHEAST);
            loc.getAdjacentLocation(Location.SOUTH);
            loc.getAdjacentLocation(Location.SOUTHWEST);
            loc.getAdjacentLocation(Location.WEST);
            loc.getAdjacentLocation(Location.NORTHWEST);
            loc.getAdjacentLocation(Location.NORTH);
            loc.getAdjacentLocation(Location.NORTHEAST);
        }

        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next)) {
            moveTo(next);
        }
        else{
            removeSelfFromGrid();
        }
    }

    public boolean canClimb() {
            Grid<Actor> gr = getGrid();
            if (gr == null) {
                return false;
            }
            Location loc = getLocation();
            int direction = getDirection();
            Location next = loc.getAdjacentLocation(direction);
            if (!gr.isValid(next)) {
                return false;
            }
            Actor neighbor = gr.get(next);
            if (!gr.isValid(next)) {
                return false;
            }
            if (neighbor instanceof Rock) {
                while (neighbor instanceof Rock) {
                    next = next.getAdjacentLocation(direction);
                    if (!gr.isValid(next)) {
                        return false;
                    }
                    neighbor = gr.get(next);
                }
                return (neighbor == null);
            }
    return false;
    }

    public void climb() {
        Grid<Actor> gr = getGrid();
        Location loc = getLocation();
        int direction = getDirection();
        Location next = loc.getAdjacentLocation(direction);
        Actor neighbor = gr.get(next);
        while (neighbor instanceof Rock) {
            next = next.getAdjacentLocation(direction);
            neighbor = gr.get(next);
        }
        moveTo(next);

    }

//    public void followGoats() {
//        //in Arbeit
//    }

//@Override-Klassenmethoden
    @Override
    public void act() {
        age++ ;
        if (age > 2) {
            Location loc = this.getLocation() ;
            Grid<Actor> gr = this.getGrid() ;
            this.removeSelfFromGrid();
            Goat goat = new Goat(age);
            goat.setDirection(getDirection());
            goat.putSelfInGrid(gr, loc);
            return;
        }
        if (canMove()) {
            move();
        }
        else if (canClimb()) {
            climb();
        }
        else {
            turn();
        }
    }

}