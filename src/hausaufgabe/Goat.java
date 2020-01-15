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
    public void move() {

        Grid<Actor> gr = getGrid();
        if (gr == null) {
            return;
        }

        Location loc = getLocation();

        if (Math.random() <= 1./6 && statusAdjacentLocation(gr)) {

            Location nextEAST = loc.getAdjacentLocation(Location.EAST);
            Location nextSOUTHEAST = loc.getAdjacentLocation(Location.SOUTHEAST);
            Location nextSOUTH = loc.getAdjacentLocation(Location.SOUTH);
            Location nextSOUTHWEST = loc.getAdjacentLocation(Location.SOUTHWEST);
            Location nextWEST = loc.getAdjacentLocation(Location.WEST);
            Location nextNORTHWEST = loc.getAdjacentLocation(Location.NORTHWEST);
            Location nextNORTH = loc.getAdjacentLocation(Location.NORTH);
            Location nextNORTHEAST = loc.getAdjacentLocation(Location.NORTHEAST);

            int zufallszahl = (int) (Math.random()*8);
            GoatKid kid = new GoatKid();
            switch(zufallszahl) {
                case 0:
                    kid.putSelfInGrid(getGrid(), nextEAST);
                    break;
                case 1:
                    kid.putSelfInGrid(getGrid(), nextSOUTHEAST);
                    break;
                case 2:
                    kid.putSelfInGrid(getGrid(), nextSOUTH);
                    break;
                case 3:
                    kid.putSelfInGrid(getGrid(), nextSOUTHWEST);
                    break;
                case 4:
                    kid.putSelfInGrid(getGrid(), nextWEST);
                    break;
                case 5:
                    kid.putSelfInGrid(getGrid(), nextNORTHWEST);
                    break;
                case 6:
                    kid.putSelfInGrid(getGrid(), nextNORTH);
                    break;
                case 7:
                    kid.putSelfInGrid(getGrid(), nextNORTHEAST);
                    break;
                default:
                    break;
            }
        }

        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next)) {
            moveTo(next);
        }
        else{
            removeSelfFromGrid();
        }
    }

    public int getMilkStatus(){
        return this.goatMilk;
    }

    public void removeMilk(){
        this.goatMilk = 0;
    }

    @Override
    public void act() {
        if (Math.random() <= 1./5 && age > 15) {
            Location loc = this.getLocation();
            Grid<Actor> gr = this.getGrid();
            this.removeSelfFromGrid();
            countGoatNumber = countGoatNumber - 1;
            Flower flower = new Flower(getColor());
            flower.putSelfInGrid(gr, loc);
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
        age++ ;
        goatMilk++;
    }

    public String toString(){
        return super.toString() + "Milk: "+ getMilkStatus();
    }

}