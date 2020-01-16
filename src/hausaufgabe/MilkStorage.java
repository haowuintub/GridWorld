package hausaufgabe;

import gridworld.framework.actor.Actor;

public class MilkStorage extends Actor {

//Attribute
    public int milk;

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
        System.out.println("RESET");
    }

    public String toString(){
        return ""+milk;
    }
}
