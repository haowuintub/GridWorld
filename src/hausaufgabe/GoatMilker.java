package hausaufgabe;

import gridworld.framework.actor.Actor;
import gridworld.framework.actor.Flower;
import gridworld.framework.grid.Grid;
import gridworld.framework.grid.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stefan Schulz
 */

public class GoatMilker extends Farmer {

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
            if (neighbor instanceof Goat) {
                neighbor.removeMilkofGoat(); // herausfinden ob sinnvoll
            }
        }

    }


}