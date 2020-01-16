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
    void milkGoats(Goat goat){//übergebe besser keine Goat
        //hier Goats mit Location suchen, dann jede Goat einzeln melken!
        goat.removeMilk();
        milkStorage.addMilk();
    }
    public void act() {
        if (canMilkGoats()) {
            Goat goat = new Goat();     //Bullshit
            milkGoats(goat);
        }
        super.act();
    }
}
