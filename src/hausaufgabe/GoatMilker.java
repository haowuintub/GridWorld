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
    private MilkStorage milkStorage;

//Konstruktor
    GoatMilker(MilkStorage storage) {
         this.milkStorage = storage;

    }

//Klassenmethoden

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
