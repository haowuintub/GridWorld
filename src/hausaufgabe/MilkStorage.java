package hausaufgabe;

import gridworld.framework.actor.Actor;

public class MilkStorage extends Actor {

//Attribute
    private int milk;

//Konstruktor
    public MilkStorage(){
        resetMilkStorage();
    }

//Klassenmethoden
    public void addMilk(){
        milk = milk +1;
    }

    public void resetMilkStorage(){
        milk = 0;
    }

    public String toString(){
        return ""+milk;
    }
}
