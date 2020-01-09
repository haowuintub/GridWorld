package hausaufgabe;

import gridworld.framework.actor.Actor;
import gridworld.framework.actor.ActorWorld;
import gridworld.framework.actor.Bug;
import gridworld.framework.actor.Rock;
import gridworld.framework.grid.Grid;
import gridworld.framework.grid.Location;

import java.util.ArrayList;

/**
 * @ Stefan Schulz, Hao Wu
 */

/**
 * This class runs a world that contains a bug and a rock, added at random
 * locations. Click on empty locations to add additional actors. Click on
 * populated locations to invoke methods on their occupants. <br />
 * To build your own worlds, define your own actors and a runner class. See the
 * BoxBugRunner (in the boxBug folder) for an example. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class FarmWorldRunner  {

    public static int goatNumber = 0;

    public static void main(String[] args) {

        Grid<Actor> grid = new Grid<Actor>() {
            @Override
            public int getNumRows() {
                return 20;
            }

            @Override
            public int getNumCols() {
                return 20;
            }

            @Override
            public boolean isValid(Location loc) {
                return false;
            }

            @Override
            public Actor put(Location loc, Actor obj) {
                return null;
            }

            @Override
            public Actor remove(Location loc) {
                return null;
            }

            @Override
            public Actor get(Location loc) {
                return null;
            }

            @Override
            public ArrayList<Location> getOccupiedLocations() {
                return null;
            }

            @Override
            public ArrayList<Location> getValidAdjacentLocations(Location loc) {
                return null;
            }

            @Override
            public ArrayList<Location> getEmptyAdjacentLocations(Location loc) {
                return null;
            }

            @Override
            public ArrayList<Location> getOccupiedAdjacentLocations(Location loc) {
                return null;
            }

            @Override
            public ArrayList<Actor> getNeighbors(Location loc) {
                return null;
            }
        };
        ActorWorld bauernhof = new ActorWorld(grid);

/*        ActorWorld bauernhof = new ActorWorld();
        bauernhof.createNewWorldWithGridSize(20, 20);*/


        bauernhof.add(new Goat());
        goatNumber++;
        //hier sinnvoll???
        bauernhof.add(new GoatKid());
        bauernhof.add(new Farmer());
        bauernhof.add(new Farmer());
        bauernhof.add(new MilkStorage());
        bauernhof.add(new GoatMilker());
        bauernhof.show();

// hier sinnvoll??
        CreatorFarmer creatorFarmer = new CreatorFarmer() ;
        if(goatNumber == 0){
            creatorFarmer.checkGoatNumber();
        }


    }

}

