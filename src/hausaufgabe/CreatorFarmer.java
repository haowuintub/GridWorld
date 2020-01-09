package hausaufgabe;


import gridworld.framework.grid.Location;

/**
 * @ Hao Wu
 */

public class CreatorFarmer extends Farmer {

    void checkGoatNumber(){
        Location location1 = this.getLocation() ;
        Goat goat = new Goat() ;
        goat.moveTo(location1);

    }


    @Override
    void eatFlowerAround() {
    }

}
// muss funktion überprüfen