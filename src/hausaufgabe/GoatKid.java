package hausaufgabe;


import gridworld.framework.actor.Actor;
import gridworld.framework.actor.Rock;
import gridworld.framework.grid.Grid;
import gridworld.framework.grid.Location;

import java.awt.*;

/**
 * @ Hao Wu, Stefan Schulz
 */

public class GoatKid extends Animal {

//Konstruktor
    public GoatKid() {
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

            if(statusAdjacentLocation(gr)){
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
            //climb() inkl. canclimb()
            removeSelfFromGrid();
        }


    }


    public void climb() {

        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;

        Location loc = getLocation();

        Location nextEAST = loc.getAdjacentLocation(Location.EAST);
        Location nextSOUTHEAST = loc.getAdjacentLocation(Location.SOUTHEAST);
        Location nextSOUTH = loc.getAdjacentLocation(Location.SOUTH);
        Location nextSOUTHWEST = loc.getAdjacentLocation(Location.SOUTHWEST);
        Location nextWEST = loc.getAdjacentLocation(Location.WEST);
        Location nextNORTHWEST = loc.getAdjacentLocation(Location.NORTHWEST);
        Location nextNORTH = loc.getAdjacentLocation(Location.NORTH);
        Location nextNORTHEAST = loc.getAdjacentLocation(Location.NORTHEAST);

        Actor neighborEAST = gr.get(nextEAST);
        Actor neighborSOUTHEAST = gr.get(nextSOUTHEAST);
        Actor neighborSOUTH = gr.get(nextSOUTH);
        Actor neighborSOUTHWEST = gr.get(nextSOUTHWEST);
        Actor neighborWEST = gr.get(nextWEST);
        Actor neighborNORTHWEST = gr.get(nextNORTHWEST);
        Actor neighborNORTH = gr.get(nextNORTH);
        Actor neighborNORTHEAST = gr.get(nextNORTHEAST);

        if (neighborEAST instanceof Rock)
            setDirection(Location.EAST);
        else if (neighborSOUTHEAST instanceof Rock) {
            setDirection(Location.SOUTHEAST);
        } else if (neighborSOUTH instanceof Rock)
            setDirection(Location.SOUTH);
        else if (neighborSOUTHWEST instanceof Rock) {
            setDirection(Location.SOUTHWEST);
        } else if (neighborWEST instanceof Rock)
            setDirection(Location.WEST);
        else if (neighborNORTHWEST instanceof Rock) {
            setDirection(Location.NORTHWEST);
        } else if (neighborNORTH instanceof Rock)
            setDirection(Location.NORTH);
        else if (neighborNORTHEAST instanceof Rock) {
            setDirection(Location.NORTHEAST);
        }else{
            return;
        }

        int changedDirection = getDirection() ; // ???????????????????????


        int r = Math.abs(20-loc.getRow());
        int c = Math.abs(20-loc.getCol());
        int g;
        if(r>c){g=r;}else{g=c;}

        Location next = loc.getAdjacentLocation(getDirection()); // ???????????
        for (int i=0;i<g;i++){
            moveOnTheRock();
        }


    }


    public void moveOnTheRock() {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        Actor neighbor = gr.get(next);
        if (neighbor instanceof Rock) {
            moveTo(next);
        }
        else {
            removeSelfFromGrid();
        }
    }

    /*    public boolean canClimb()
        {
            Grid<Actor> gr = getGrid();
            if (gr == null)
                return false;
            Location loc = getLocation();
            Location next = loc.getAdjacentLocation(getDirection());
            if (!gr.isValid(next))
                return false;
            Actor neighbor = gr.get(next);
            return (neighbor == null)

        }*/


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
            climb();
        }
        else {
            turn();
        }
        age++ ;
    }

}



/*  WICHTIG FÜR HERDENTRIEB

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