package hausaufgabe;

import gridworld.framework.actor.Actor;



/**
 * @author Stefan Schulz
 */

public class GoatMilker extends Farmer {

//Attribute
    MilkStorage milkStorage;

//Konstruktor
    public GoatMilker() {
         milkStorage = new MilkStorage();
    }

//Klassenmethoden
    boolean canMilkGoats(){
        //Umgebung prüfen
        return false;
    }
    void milkGoats(Goat goat){
        goat.removeMilk();
        milkStorage.addMilk();
        //beide Funktionsaufrufe funktionieren noch nicht.
    }
    public void act() {
        if (canMilkGoats()) {
            milkGoats();
        }
        super.act();
    }
}
