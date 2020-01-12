package hausaufgabe;

import gridworld.framework.actor.Actor;
import gridworld.framework.actor.Flower;
import gridworld.framework.grid.Location;

import java.util.ArrayList;

import static hausaufgabe.FarmWorldRunner.countGoatNumber;

/**
 * @ Hao Wu
 */

public class CreatorFarmer extends Farmer {

/*    public static int countGoatNumber = 0 ;*/

    void checkGoatNumber(){

        if(countGoatNumber == 0) {
            Goat goat = new Goat();
            countGoatNumber++;

            Location loc = this.getLocation();
            Location next = loc.getAdjacentLocation(this.getDirection());
            goat.moveTo(next);
        }

    }


    @Override
    public void processActors(ArrayList<Actor> actors) {
        return;
    }

}
// muss funktion überprüfen