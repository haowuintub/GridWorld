package hausaufgabe;

import gridworld.framework.actor.Actor;
import gridworld.framework.actor.Flower;
import gridworld.framework.grid.Grid;
import gridworld.framework.grid.Location;

import java.awt.*;
import java.util.ArrayList;

import static hausaufgabe.FarmWorldRunner.countGoatNumber;
/**
 * @author: Hao Wu, Stefan Schulz
 */


public class Goat extends GoatKid {

//Attribute
    private int goatMilk;


//Konstruktoren
    public Goat(int age) {                 //used if Goatkid is growing up.
        this.setColor(Color.RED);
        this.age = age;
        this.goatMilk = 2;
        countGoatNumber++;
    }


    public Goat() {                        //used if Goat created by CreatorFarmer/ FarmWorldRunner
        this.setColor(Color.RED);
        this.goatMilk = 2;
        countGoatNumber++;
    }

//Klassenmethoden
    public void die() {            //Goat dies and is replaced by Flower
        Location loc = this.getLocation();
        Grid<Actor> gr = this.getGrid();
        this.removeSelfFromGrid();
        Flower flower = new Flower(getColor());
        flower.putSelfInGrid(gr, loc);
    }

    public int getMilkStatus(){
        return this.goatMilk;
    }

    public void removeMilk(){
        this.goatMilk = 0;
    }

//Override-Klassenmethoden
    @Override
    public void move() {

        Location loc = getLocation();
        Grid<Actor> gr = getGrid();
        if (gr == null) {
            return;
        }

        final double PROBABILITY_LOOKAROUND = 1./6;
        if (Math.random() <= PROBABILITY_LOOKAROUND) {
            ArrayList<Location> freeLocList = freeAdjacentLocation();
            int locListSize = freeLocList.size();
            int zufallszahl = (int) (Math.random()*locListSize);
            GoatKid kid = new GoatKid();
            kid.putSelfInGrid(getGrid(), freeLocList.get(zufallszahl));
        }

        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next)) {
            moveTo(next);
        }
        else{
            removeSelfFromGrid();
        }
    }

    @Override
    public void act() {
        age++ ;
        final double PROBABILITY_DIE = 1./5;
        if (Math.random() <= PROBABILITY_DIE && age > 15) {
            die();
            return;
        }
        if (canMove()) {
            move();
        }
        else if (canClimb()) {
            climb();
        }
        else {
            turn();
        }
        goatMilk++;
    }

    @Override
    public String toString(){
        return super.toString() + " [Milk: "+ getMilkStatus() + " ]";
    }

}