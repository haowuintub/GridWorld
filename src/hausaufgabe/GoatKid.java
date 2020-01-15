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
        if (gr == null)
            return;
//simplifizieren!!!!
        if (Math.random() <= 1./6 ) {

            Location loc = getLocation();
            Location nextEAST = loc.getAdjacentLocation(Location.EAST);
            Location nextSOUTHEAST = loc.getAdjacentLocation(Location.SOUTHEAST);
            Location nextSOUTH = loc.getAdjacentLocation(Location.SOUTH);
            Location nextSOUTHWEST = loc.getAdjacentLocation(Location.SOUTHWEST);
            Location nextWEST = loc.getAdjacentLocation(Location.WEST);
            Location nextNORTHWEST = loc.getAdjacentLocation(Location.NORTHWEST);
            Location nextNORTH = loc.getAdjacentLocation(Location.NORTH);
            Location nextNORTHEAST = loc.getAdjacentLocation(Location.NORTHEAST);

            if(statusAdjacentLocation(gr)) {
                int zufallszahl = (int) (Math.random()*8);
                GoatKid kid = new GoatKid();
                switch(zufallszahl) {
                    case 0:
                        kid.putSelfInGrid(getGrid(), nextEAST);
                        break;
                    case 1:
                        kid.putSelfInGrid(getGrid(), nextSOUTHEAST);
                        break;
                    case 2:
                        kid.putSelfInGrid(getGrid(), nextSOUTH);
                        break;
                    case 3:
                        kid.putSelfInGrid(getGrid(), nextSOUTHWEST);
                        break;
                    case 4:
                        kid.putSelfInGrid(getGrid(), nextWEST);
                        break;
                    case 5:
                        kid.putSelfInGrid(getGrid(), nextNORTHWEST);
                        break;
                    case 6:
                        kid.putSelfInGrid(getGrid(), nextNORTH);
                        break;
                    case 7:
                        kid.putSelfInGrid(getGrid(), nextNORTHEAST);
                        break;
                    default:
                        break;
                }
            }
        }

        Location loc1 = getLocation();
        Location next = loc1.getAdjacentLocation(getDirection());
        if (gr.isValid(next)) {
            moveTo(next);
        }
        else{
            removeSelfFromGrid();
        }
    }


    public boolean canClimb(Location loc) {
            Grid<Actor> gr = getGrid();
            if (gr == null) {
                return false;
            }
            Location next = loc.getAdjacentLocation(getDirection());
            Actor neighbor = gr.get(next);
            if (neighbor instanceof Rock) {
                return true;
            }
            else {
                return false;
            }
    }


    public void climb() {
        turn();
        turn();
        turn();
    }


    @Override
    public void act() {
        if (age > 2) {
            Location loc = this.getLocation() ;
            Grid<Actor> gr = this.getGrid() ;
            this.removeSelfFromGrid();
            Goat goat = new Goat(age);
            goat.putSelfInGrid(gr, loc);
            return;
        }
        if (canMove()) {
            move();
        }
        else if (canClimb(this.getLocation())) {
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