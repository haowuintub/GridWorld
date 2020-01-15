package hausaufgabe;

import gridworld.framework.actor.Actor;



/**
 * @author Stefan Schulz
 */

public class GoatMilker extends Farmer {

//Attribute
    Actor milkstorage;

//Konstruktor
    public GoatMilker() {
        milkstorage = new MilkStorage();
    }

//Klassenmethoden
    boolean canMilkGoats(){
        //Umgebung prüfen
        return false;
    }
    void milkGoats(){
//        Goat.removeMilk();
//        MilkStorage.addMilk();
        //Ergebnisse verwenden, wirklich melken!!
    }
    public void act() {
        if (canMilkGoats()) {
            milkGoats();
        }
        super.act();
    }
}
