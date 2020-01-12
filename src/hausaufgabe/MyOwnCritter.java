package hausaufgabe;

import apple.laf.JRSUIConstants;
import gridworld.framework.actor.Actor;
import gridworld.framework.actor.Critter;
import gridworld.framework.actor.Flower;
import gridworld.framework.grid.Grid;
import gridworld.framework.grid.Location;

import java.util.ArrayList;
import java.util.List;

public class MyOwnCritter extends Critter {

    public ArrayList<Location> getNextLocations() {
        ArrayList<Location> nextLocation = new ArrayList<>();

        /*Grid<Actor> gr = getGrid();
        if (gr == null)
            return neighboringLocation ;*/

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

        return nextLocation ;
    }

    @Override
    public ArrayList<Actor> getActors() {

        ArrayList<Actor> neighboringActors = this.getActors();

              /*  Location loc = getLocation();
        Location nextEAST = loc.getAdjacentLocation(Location.EAST);
        Location nextSOUTHEAST = loc.getAdjacentLocation(Location.SOUTHEAST);
        Location nextSOUTH = loc.getAdjacentLocation(Location.SOUTH);
        Location nextSOUTHWEST = loc.getAdjacentLocation(Location.SOUTHWEST);
        Location nextWEST = loc.getAdjacentLocation(Location.WEST);
        Location nextNORTHWEST = loc.getAdjacentLocation(Location.NORTHWEST);
        Location nextNORTH = loc.getAdjacentLocation(Location.NORTH);
        Location nextNORTHEAST = loc.getAdjacentLocation(Location.NORTHEAST);*/
        ArrayList<Location> nextLocation = this.getNextLocations();

        Grid<Actor> gr = getGrid();
        if (gr == null){
            return neighboringActors ;
        }

        Actor neighborEAST = gr.get(nextLocation.get(0));
        Actor neighborSOUTHEAST = gr.get(nextLocation.get(1));
        Actor neighborSOUTH = gr.get(nextLocation.get(2));
        Actor neighborSOUTHWEST = gr.get(nextLocation.get(3));
        Actor neighborWEST = gr.get(nextLocation.get(4));
        Actor neighborNORTHWEST = gr.get(nextLocation.get(5));
        Actor neighborNORTH = gr.get(nextLocation.get(6));
        Actor neighborNORTHEAST = gr.get(nextLocation.get(7));

        neighboringActors.add(neighborEAST);
        neighboringActors.add(neighborSOUTHEAST);
        neighboringActors.add(neighborSOUTH);
        neighboringActors.add(neighborSOUTHWEST);
        neighboringActors.add(neighborWEST);
        neighboringActors.add(neighborNORTHWEST);
        neighboringActors.add(neighborNORTH);
        neighboringActors.add(neighborNORTHEAST);

        return neighboringActors ;
/*        return super.getActors();*/
    }

    @Override
    public void processActors(ArrayList<Actor> actors) {
        int n = actors.size();
        if (n == 0) {
            return;
        }

        for (Actor a : actors) {
            if (a instanceof Flower) {
                a.removeSelfFromGrid();
            }
        }
    }

    @Override
    public ArrayList<Location> getMoveLocations() {

        ArrayList<Location> neighboringLocation = this.getNextLocations();

        Grid<Actor> gr = getGrid();
        if (gr == null)
            return neighboringLocation ;

        for (Location location : neighboringLocation) {
            if(!gr.isValid(location)) {
                neighboringLocation.remove(location);
            }
        }

         return neighboringLocation ;
/*        return super.getMoveLocations();*/
    }


    private Location compare(Location theShorterOne, Location comparedLocation, double difference_TheShorterOne_Before){

        Location here = getLocation() ;
        int row = here.getRow() ;
        int col = here.getCol() ;

        int row_difference = Math.abs(comparedLocation.getRow()-row) ;
        int col_difference = Math.abs(comparedLocation.getCol()-col) ;
        double r = (Math.sqrt(row_difference * row_difference + col_difference * col_difference));

        if(r < difference_TheShorterOne_Before){
            difference_TheShorterOne_Before = r ;
            theShorterOne = comparedLocation ;
            return theShorterOne ;
        }else{
            return theShorterOne ;
        }
    }

    @Override
    public Location selectMoveLocation(ArrayList<Location> locs) {
        Location theShorterOne = getLocation() ;
        double difference_TheShorterOne_Before = 1000000000 ;

        int n = locs.size();
        if (n == 0)
            return getLocation();

        for (Location location : locs) {
            theShorterOne = compare(theShorterOne, location, difference_TheShorterOne_Before);
        }
/*        int r = (int) (Math.random() * n);*/

        return theShorterOne ;
/*        return super.selectMoveLocation(locs);*/
    }

    @Override
    public void makeMove(Location loc) {
        if (loc == null) {
            if (Math.random() <= 1/2) {
                setDirection(getDirection() + Location.HALF_RIGHT);
            }else{
            this.setDirection(this.getDirection() - 180);
            Location lastLocation = loc.getAdjacentLocation(getDirection());
            moveTo(lastLocation);
            }
        } else {
            moveTo(loc);
        }
    }

}
