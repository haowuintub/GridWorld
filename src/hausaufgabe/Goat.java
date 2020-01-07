package hausaufgabe;

import gridworld.framework.actor.Actor;
import gridworld.framework.actor.Flower;
import gridworld.framework.grid.Grid;
import gridworld.framework.grid.Location;

import java.awt.*;

/**
 * @ Hao Wu
 */

public class Goat extends Animal {

    private int steps = 1 ;

    public Goat() {
        this.setColor(Color.RED);
    }

    public void move() {
        if (Math.random() <= 1/6) {


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

/*        List<Location> surroundingLocation = new ArrayList<>();

        surroundingLocation.add(nextEAST);
        surroundingLocation.add(nextSOUTHEAST);
        surroundingLocation.add(nextSOUTH);
        surroundingLocation.add(nextSOUTHWEST);
        surroundingLocation.add(nextWEST);
        surroundingLocation.add(nextNORTHWEST);
        surroundingLocation.add(nextNORTH);
        surroundingLocation.add(nextNORTHEAST);

        for (Location location : surroundingLocation) {
            if (gr.isValid(location))
                moveTo(location);
            else
                removeSelfFromGrid();
//            Flower flower = new Flower(getColor());
//            flower.putSelfInGrid(gr, loc);
        }*/

            if (gr.isValid(nextEAST))
                moveTo(nextEAST);
            else if (gr.isValid(nextSOUTHEAST)) {
                moveTo(nextSOUTHEAST);
            } else if (gr.isValid(nextSOUTH))
                moveTo(nextSOUTH);
            else if (gr.isValid(nextSOUTHWEST)) {
                moveTo(nextSOUTHWEST);
            } else if (gr.isValid(nextWEST))
                moveTo(nextWEST);
            else if (gr.isValid(nextNORTHWEST)) {
                moveTo(nextNORTHWEST);
            } else if (gr.isValid(nextNORTH))
                moveTo(nextNORTH);
            else if (gr.isValid(nextNORTHEAST)) {
                moveTo(nextNORTHEAST);
            }
            removeSelfFromGrid();
//            Flower flower = new Flower(getColor());
//            flower.putSelfInGrid(gr, loc);
        }

    }

    @Override
    public void act() {

        super.act();

        if (Math.random() <= 1/5 && steps > 15) {
/*            this.removeSelfFromGrid();

            Grid<Actor> gr = getGrid();
            if (gr == null)
                return;
            Location loc = getLocation();
            Flower flower = new Flower(getColor());
            flower.putSelfInGrid(gr, loc);*/

            Location loc = this.getLocation() ;
            Grid<Actor> gr = this.getGrid() ;
            this.removeSelfFromGrid();
            Flower flower = new Flower(getColor());
            flower.putSelfInGrid(gr,loc) ;
        }

        steps ++ ;
    }

}


