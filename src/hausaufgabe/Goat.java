package hausaufgabe;

//import apple.laf.JRSUIConstants; ???????????????????? <----
import gridworld.framework.actor.Actor;
import gridworld.framework.actor.Flower;
import gridworld.framework.grid.Grid;
import gridworld.framework.grid.Location;

import java.awt.*;

import static hausaufgabe.FarmWorldRunner.countGoatNumber;

/**
 * @ Hao Wu, Stefan Schulz
 */

public class Goat extends GoatKid {

//Attribute
    public int goatMilk;


//Konstruktoren
    public Goat(int age) {
        this.setColor(Color.RED);
        this.age = age;
        this.goatMilk = 2;
        countGoatNumber++;
    }


    public Goat() {
        this.setColor(Color.RED);
        this.goatMilk = 2;
        countGoatNumber++;
    }

//Klassenmethoden
    public void move() {
        super.move();
    }


    public void climb(){
        super.climb();
    }


    public void moveOnTheRock() {
        super.moveOnTheRock();
    }

    /*    public boolean canClimb()
        {
           super.canClimb();
        }*/


    @Override
    public void act() {

//        super.act();

        if (canMove()){
            move();

            if (Math.random() <= 1/5 && age > 15) {
                Location loc = this.getLocation() ;
                Grid<Actor> gr = this.getGrid() ;
                this.removeSelfFromGrid();
                countGoatNumber = countGoatNumber - 1;
                Flower flower = new Flower(getColor()) ;
                flower.putSelfInGrid(gr,loc) ;
                return;
            }

            climb();
        } else{
            turn();
        }
        age++ ;
    }

}

// Muss noch den Fakt, dass ein Goat über Steine springt hinzufügen.

// Muss noch GoatMilk-Status hinzufügen + removeMilkofGoat() mit Milk --> MilkStorage