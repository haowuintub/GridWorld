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
    GoatKid() {
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

    boolean canClimb() {
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
                return gr.isValid(next);
            }
    return false;
    }

    void climb() {
        Grid<Actor> gr = getGrid();
        if (gr == null) {
            return;
        }
        Location loc = getLocation();
        int direction = getDirection();
        Location next = loc.getAdjacentLocation(direction);
        Actor neighbor = gr.get(next);
        if (neighbor instanceof Rock) {
            while (neighbor instanceof Rock) {
                next = next.getAdjacentLocation(direction);
                neighbor = gr.get(next);
            }
            moveTo(next);
        }
    }

//@Override-Klassenmethoden
    @Override
    public void act() {
        if (age > 2) {
            Location loc = this.getLocation() ;
            Grid<Actor> gr = this.getGrid() ;
            this.removeSelfFromGrid();
            Goat goat = new Goat(age+1);
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
        age++ ;
    }

}
/**  WICHTIG FÜR HERDENTRIEB

        if (gr.isValid(nextEAST)) {
                GoatKid kid = new GoatKid();
                kid.putSelfInGrid(getGrid(), nextEAST);
//                    moveTo(nextEAST);
            }
            else if (gr.isValid(nextSOUTHEAST)) {
                GoatKid kid = new GoatKid();
                kid.putSelfInGrid(getGrid(), nextEAST);

                //                  moveTo(nextSOUTHEAST);
            }
            else if (gr.isValid(nextSOUTH)){
                GoatKid kid = new GoatKid();
                kid.putSelfInGrid(getGrid(), nextEAST);
//                    moveTo(nextSOUTH);
            }
            else if (gr.isValid(nextSOUTHWEST)) {
                GoatKid kid = new GoatKid();
                kid.putSelfInGrid(getGrid(), nextEAST);
//                    moveTo(nextSOUTHWEST);
            }
            else if (gr.isValid(nextWEST)) {
                GoatKid kid = new GoatKid();
                kid.putSelfInGrid(getGrid(), nextEAST);
//                    moveTo(nextWEST);
            }
            else if (gr.isValid(nextNORTHWEST)) {
                GoatKid kid = new GoatKid();
                kid.putSelfInGrid(getGrid(), nextEAST);
//                    moveTo(nextNORTHWEST);
            }
            else if (gr.isValid(nextNORTH)) {
                GoatKid kid = new GoatKid();
                kid.putSelfInGrid(getGrid(), nextEAST);
//                    moveTo(nextNORTH);
            }
            else if (gr.isValid(nextNORTHEAST)) {
                GoatKid kid = new GoatKid();
                kid.putSelfInGrid(getGrid(), nextEAST);
//                moveTo(nextNORTHEAST);
            }
            else {
                removeSelfFromGrid();
            }
        }

    }
 */