package hausaufgabe;

import gridworld.framework.actor.Critter;
import gridworld.framework.grid.Location;
import static hausaufgabe.FarmWorldRunner.countGoatNumber;

/**
 * @ Hao Wu, Stefan Schulz
 */

public class CreatorFarmer extends Farmer {

//Attribute
    int height;

    public CreatorFarmer(){
        height = 180;
    }



    void checkGoatNumber(){
        if(countGoatNumber == 0) {
            Location loc = getLocation();
            Location next = loc.getAdjacentLocation(getDirection());
            Goat goat = new Goat();
            goat.putSelfInGrid(getGrid(),next);
        }

    }


    @Override
    public void act() {
        checkGoatNumber();
 //       if (canMove()) {
 //           move();
 //       }
    }

}
