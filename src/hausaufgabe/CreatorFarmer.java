package hausaufgabe;

import gridworld.framework.actor.Critter;
import gridworld.framework.grid.Location;

import java.util.ArrayList;

import static hausaufgabe.FarmWorldRunner.countGoatNumber;

/**
 * @ Hao Wu, Stefan Schulz
 */

public class CreatorFarmer extends Critter {

//Attribute
    int height;

    public CreatorFarmer(){
        height = 180;
    }


    void checkGoatNumber(){
        if(countGoatNumber == 0) {
            ArrayList<Location> freeLocList = freeAdjacentLocation();
            int locListSize = freeLocList.size();
            Goat goat = new Goat();
            goat.putSelfInGrid(getGrid(), freeLocList.get(locListSize));
        }

    }



    public void act() {
        checkGoatNumber();
    }

}
