package hausaufgabe;

import gridworld.framework.grid.Location;
/*import static hausaufgabe.FarmWorldRunner.countGoatNumber;*/

/**
 * @ Hao Wu
 */

public class CreatorFarmer extends Farmer {

    public static int countGoatNumber = 0 ;

    void checkGoatNumber(){

        if(countGoatNumber == 0) {
            Location loc = this.getLocation();
            Location next = loc.getAdjacentLocation(this.getDirection());
            Goat goat = new Goat();
            goat.moveTo(next);
        }

    }


/*    @Override
    void eatFlowerAround() {
    }*/

}
// muss funktion überprüfen