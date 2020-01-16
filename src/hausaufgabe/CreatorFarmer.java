package hausaufgabe;


import gridworld.framework.actor.Critter;
import gridworld.framework.grid.Location;

import java.util.ArrayList;

import static hausaufgabe.FarmWorldRunner.countGoatNumber;

/**
 * @ Hao Wu, Stefan Schulz
 */

public class CreatorFarmer extends Critter {


//Konstruktor
    public CreatorFarmer(){}

//Klassenmethoden

    private void checkGoatNumber(){
        if(countGoatNumber == 0) {
            ArrayList<Location> freeLocList = new ArrayList<>();
            if(freeAdjacentLocation().size() == 0) {
                freeLocList.add(getLocation().getAdjacentLocation(Location.NORTH));
            }
            else {
                freeLocList = freeAdjacentLocation();
            }
            int locListSize = freeLocList.size();
            int zufallszahl = (int) (Math.random()*locListSize);
            Goat goat = new Goat();
            goat.putSelfInGrid(getGrid(), freeLocList.get(zufallszahl));
        }

    }

//@Override-Klassenmethoden

@Override
    public void act() {
        checkGoatNumber();
    }

}
