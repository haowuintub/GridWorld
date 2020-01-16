package hausaufgabe;

import gridworld.framework.actor.Actor;

public class MilkStorage extends Actor {

//Attribute
    public int milk;

//Konstruktor
    public MilkStorage(){
        this.milk = 0;
    }

//Klassenmethoden
    public void addMilk(){
        this.milk =+ 1;
    }

    public void resetMilkStorage(){
        this.milk = 0;
    }

    public String toString(){
        return getClass().getName() + "milk=" + this.milk;
    }
}
