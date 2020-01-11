package hausaufgabe;

import gridworld.framework.actor.Actor;
import gridworld.framework.actor.Critter;
import gridworld.framework.actor.Flower;
import gridworld.framework.grid.Grid;
import gridworld.framework.grid.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Hao Wu
 */

public class Farmer extends Critter {

// Größe von Farmer
/*    int height ;

    Farmer(){
        height = 180 ;
    }

    Farmer(int height){
        this.height = height ;
    }*/

    void eatFlowerAround() {
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

        List<Location> surroundingLocation = new ArrayList<>();

        surroundingLocation.add(nextEAST);
        surroundingLocation.add(nextSOUTHEAST);
        surroundingLocation.add(nextSOUTH);
        surroundingLocation.add(nextSOUTHWEST);
        surroundingLocation.add(nextWEST);
        surroundingLocation.add(nextNORTHWEST);
        surroundingLocation.add(nextNORTH);
        surroundingLocation.add(nextNORTHEAST);

        for (Location location : surroundingLocation) {
            if (!gr.isValid(location))
                return;

            Actor neighbor = gr.get(location);
            if (neighbor instanceof Flower) {
                neighbor.removeSelfFromGrid();
//            flowersEaten++;
            }
        }

    }


//    die Anzahl der Blumenwirte variieren
    void farmerRemoveSelfFromGrid(Farmer farmer){
        if(farmer == null){System.out.println("This ist not such farmer!");}else{farmer.removeSelfFromGrid();}
    }

}

// Größe von Farmer und Auswirkung herausfinden