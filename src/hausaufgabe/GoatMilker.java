package hausaufgabe;

import gridworld.framework.actor.Actor;
import gridworld.framework.actor.Flower;
import gridworld.framework.grid.Grid;
import gridworld.framework.grid.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stefan Schulz
 */

public class GoatMilker extends Farmer {

//Attribute
    public Actor milkstorage;

    public GoatMilker() {
        this.milkstorage = new MilkStorage();
    }

    void eatFlowerAround() {
        super.eatFlowerAround();
    }

    void canMilkGoats(){
        //Umgebung prüfen
    }
    void milkGoats(){
        //Ergebnisse verwenden, wirklich melken!!
    }
}
