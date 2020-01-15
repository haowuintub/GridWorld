package hausaufgabe;

import gridworld.framework.actor.Actor;

/**
 * @author Stefan Schulz
 */

public class GoatMilker extends Farmer {

//Attribute
    public Actor milkstorage;

//Konstruktor
    public GoatMilker() {
        this.milkstorage = new MilkStorage();
    }

//Klassenmethoden
    boolean canMilkGoats(){
        //Umgebung prüfen
        return false;
    }
    void milkGoats(){

        //Ergebnisse verwenden, wirklich melken!!
    }
    public void act() {
        if (canMilkGoats()) {
            milkGoats();
        }
        super.act();
    }
}
