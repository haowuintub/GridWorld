package hausaufgabe;

import gridworld.framework.actor.Actor;
import gridworld.framework.actor.Flower;
import gridworld.framework.grid.Grid;
import gridworld.framework.grid.Location;

import java.awt.*;

import static hausaufgabe.FarmWorldRunner.countGoatNumber;

/**
 * @author: Hao Wu, Stefan Schulz
 */

public class Goat extends GoatKid {

//Attribute
    public int goatMilk;


//Konstruktoren
    Goat(int age) {
        this.setColor(Color.RED);
        this.age = age;
        this.goatMilk = 2;
        countGoatNumber++;
    }


    Goat() {
        this.setColor(Color.RED);
        this.goatMilk = 2;
        countGoatNumber++;
    }

//Klassenmethoden
    @Override
    public void act() {
//        super.act();
        if (Math.random() <= 1./5 && age > 15) {
            Location loc = this.getLocation();
            Grid<Actor> gr = this.getGrid();
            this.removeSelfFromGrid();
            countGoatNumber = countGoatNumber - 1;
            Flower flower = new Flower(getColor());
            flower.putSelfInGrid(gr, loc);
            return;
        }
        if (canMove()){
            move();
        }
        else if (canClimb(this.getLocation())){
            climb();
        }
        else{
            turn();
        }
        age++ ;
    }

}

// Muss noch GoatMilk-Status hinzufügen + removeMilkofGoat() mit Milk --> MilkStorage