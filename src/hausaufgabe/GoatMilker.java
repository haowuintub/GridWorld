package hausaufgabe;

import gridworld.framework.actor.Actor;
import gridworld.framework.grid.Grid;
import gridworld.framework.grid.Location;

import java.util.ArrayList;

/**
 * @author Stefan Schulz
 */

public class GoatMilker extends Farmer {

//Attribute
    MilkStorage milkStorage;

//Konstruktor
    public GoatMilker(MilkStorage storage) {
         this.milkStorage = storage;

    }

//Klassenmethoden
    public ArrayList<Location> adjacentLocation(){

        Location loc = getLocation();
        Location nextEAST = loc.getAdjacentLocation(Location.EAST);
        Location nextSOUTHEAST = loc.getAdjacentLocation(Location.SOUTHEAST);
        Location nextSOUTH = loc.getAdjacentLocation(Location.SOUTH);
        Location nextSOUTHWEST = loc.getAdjacentLocation(Location.SOUTHWEST);
        Location nextWEST = loc.getAdjacentLocation(Location.WEST);
        Location nextNORTHWEST = loc.getAdjacentLocation(Location.NORTHWEST);
        Location nextNORTH = loc.getAdjacentLocation(Location.NORTH);
        Location nextNORTHEAST = loc.getAdjacentLocation(Location.NORTHEAST);

        ArrayList<Location> locList = new ArrayList<>();
        locList.add(nextEAST);
        locList.add(nextSOUTHEAST);
        locList.add(nextSOUTH);
        locList.add(nextSOUTHWEST);
        locList.add(nextWEST);
        locList.add(nextNORTHWEST);
        locList.add(nextNORTH);
        locList.add(nextNORTHEAST);
        return locList;
    }




    public boolean canMilkGoats(){

        Grid<Actor> gr = getGrid();
        if (gr == null) {
            return false;
        }
        ArrayList<Location> locList = adjacentLocation();

        for (Location l: locList ){
            if (!gr.isValid(l)) {
                return false;
            }
            Actor neighbor = gr.get(l);
            if (neighbor instanceof Goat) {
                if (((Goat) neighbor).getMilkStatus() > 1) {
                    return true;
                }
            }
        }
        return false;
    }
    public void milkGoats(){

        Grid<Actor> gr = getGrid();
        if (gr == null) {
            return;
        }
        ArrayList<Location> locList = adjacentLocation();

        for (Location l: locList ){
            if (!gr.isValid(l)) {
                break;
            }
            Actor neighbor = gr.get(l);
            if (neighbor instanceof Goat) {
                if (((Goat) neighbor).getMilkStatus() > 1) {
                    ((Goat) neighbor).removeMilk();
                    milkStorage.addMilk();
                }
            }
        }
        return;
    }

    public void act() {
        if (canMilkGoats()) {
            milkGoats();
        }
        super.act();
    }
}
