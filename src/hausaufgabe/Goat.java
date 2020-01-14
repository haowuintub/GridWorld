package hausaufgabe;

//import apple.laf.JRSUIConstants;
import gridworld.framework.actor.Actor;
import gridworld.framework.actor.Flower;
import gridworld.framework.actor.Rock;
import gridworld.framework.grid.Grid;
import gridworld.framework.grid.Location;

import java.awt.*;

import static hausaufgabe.FarmWorldRunner.countGoatNumber;


/**
 * @ Hao Wu, Stefan Schulz
 */

public class Goat extends Animal {

//Konstruktor
    public Goat() {
        this.setColor(Color.RED);
        countGoatNumber++;
    }

//Klassenmethoden
    public void move() {

        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc1 = getLocation();
        Location next = loc1.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
            moveTo(next);
        else{
            removeSelfFromGrid();
            countGoatNumber -= 1;
        }


        if (Math.random() <= 1/6) {

            Location loc = getLocation();

            Location nextEAST = loc.getAdjacentLocation(Location.EAST);
            Location nextSOUTHEAST = loc.getAdjacentLocation(Location.SOUTHEAST);
            Location nextSOUTH = loc.getAdjacentLocation(Location.SOUTH);
            Location nextSOUTHWEST = loc.getAdjacentLocation(Location.SOUTHWEST);
            Location nextWEST = loc.getAdjacentLocation(Location.WEST);
            Location nextNORTHWEST = loc.getAdjacentLocation(Location.NORTHWEST);
            Location nextNORTH = loc.getAdjacentLocation(Location.NORTH);
            Location nextNORTHEAST = loc.getAdjacentLocation(Location.NORTHEAST);

/*        List<Location> surroundingLocation = new ArrayList<>();

        surroundingLocation.add(nextEAST);
        surroundingLocation.add(nextSOUTHEAST);
        surroundingLocation.add(nextSOUTH);
        surroundingLocation.add(nextSOUTHWEST);
        surroundingLocation.add(nextWEST);
        surroundingLocation.add(nextNORTHWEST);
        surroundingLocation.add(nextNORTH);
        surroundingLocation.add(nextNORTHEAST);

        for (Location location : surroundingLocation) {
            if (gr.isValid(location))
                moveTo(location);
            else
                removeSelfFromGrid();
                countGoatNumber = countGoatNumber - 1;
//            Flower flower = new Flower(getColor());
//            flower.putSelfInGrid(gr, loc);
        }*/

            if (gr.isValid(nextEAST))
                moveTo(nextEAST);
            else if (gr.isValid(nextSOUTHEAST)) {
                moveTo(nextSOUTHEAST);
            } else if (gr.isValid(nextSOUTH))
                moveTo(nextSOUTH);
            else if (gr.isValid(nextSOUTHWEST)) {
                moveTo(nextSOUTHWEST);
            } else if (gr.isValid(nextWEST))
                moveTo(nextWEST);
            else if (gr.isValid(nextNORTHWEST)) {
                moveTo(nextNORTHWEST);
            } else if (gr.isValid(nextNORTH))
                moveTo(nextNORTH);
            else if (gr.isValid(nextNORTHEAST)) {
                moveTo(nextNORTHEAST);
            }else{
                removeSelfFromGrid();
                countGoatNumber -= 1;
            }
        }

    }


    private void climb() {

        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;

        Location loc = getLocation();

        Location nextEAST = loc.getAdjacentLocation(Location.EAST);
        Location nextSOUTHEAST = loc.getAdjacentLocation(Location.SOUTHEAST);
        Location nextSOUTH = loc.getAdjacentLocation(Location.SOUTH);
        Location nextSOUTHWEST = loc.getAdjacentLocation(Location.SOUTHWEST);
        Location nextWEST = loc.getAdjacentLocation(Location.WEST);
        Location nextNORTHWEST = loc.getAdjacentLocation(Location.NORTHWEST);
        Location nextNORTH = loc.getAdjacentLocation(Location.NORTH);
        Location nextNORTHEAST = loc.getAdjacentLocation(Location.NORTHEAST);

        Actor neighborEAST = gr.get(nextEAST);
        Actor neighborSOUTHEAST = gr.get(nextSOUTHEAST);
        Actor neighborSOUTH = gr.get(nextSOUTH);
        Actor neighborSOUTHWEST = gr.get(nextSOUTHWEST);
        Actor neighborWEST = gr.get(nextWEST);
        Actor neighborNORTHWEST = gr.get(nextNORTHWEST);
        Actor neighborNORTH = gr.get(nextNORTH);
        Actor neighborNORTHEAST = gr.get(nextNORTHEAST);

        if (neighborEAST instanceof Rock)
            setDirection(Location.EAST);
        else if (neighborSOUTHEAST instanceof Rock) {
            setDirection(Location.SOUTHEAST);
        } else if (neighborSOUTH instanceof Rock)
            setDirection(Location.SOUTH);
        else if (neighborSOUTHWEST instanceof Rock) {
            setDirection(Location.SOUTHWEST);
        } else if (neighborWEST instanceof Rock)
            setDirection(Location.WEST);
        else if (neighborNORTHWEST instanceof Rock) {
            setDirection(Location.NORTHWEST);
        } else if (neighborNORTH instanceof Rock)
            setDirection(Location.NORTH);
        else if (neighborNORTHEAST instanceof Rock) {
            setDirection(Location.NORTHEAST);
        }else{
            return;
        }

        int changedDirection = getDirection() ;


        int r = Math.abs(20-loc.getRow());
        int c = Math.abs(20-loc.getCol());
        int g = Math.abs(20-loc.getCol());
        if(r>c){g=r;}else{g=c;}

        Location next = loc.getAdjacentLocation(getDirection());
        for (int i=0;i<g;i++){
            moveOnTheRock();
        }


/*        Location next1steps = loc.getAdjacentLocation(changedDirection);
        Location next2steps = next1steps.getAdjacentLocation(changedDirection);
        Location next3steps = next2steps.getAdjacentLocation(changedDirection);
        Location next4steps = next3steps.getAdjacentLocation(changedDirection);
        Location next5steps = next4steps.getAdjacentLocation(changedDirection);
        Location next6steps = next5steps.getAdjacentLocation(changedDirection);
        Location next7steps = next6steps.getAdjacentLocation(changedDirection);
        Location next8steps = next7steps.getAdjacentLocation(changedDirection);
        Location next9steps = next8steps.getAdjacentLocation(changedDirection);
        Location next10steps = next9steps.getAdjacentLocation(changedDirection);
        Location next11steps = next10steps.getAdjacentLocation(changedDirection);
        Location next12steps = next11steps.getAdjacentLocation(changedDirection);
        Location next13steps = next12steps.getAdjacentLocation(changedDirection);
        Location next14steps = next13steps.getAdjacentLocation(changedDirection);
        Location next15steps = next14steps.getAdjacentLocation(changedDirection);
        Location next16steps = next15steps.getAdjacentLocation(changedDirection);
        Location next17steps = next16steps.getAdjacentLocation(changedDirection);
        Location next18steps = next17steps.getAdjacentLocation(changedDirection);
        Location next19steps = next18steps.getAdjacentLocation(changedDirection);

        Actor neighbor1steps = gr.get(next1steps);
        Actor neighbor2steps = gr.get(next2steps);
        Actor neighbor3steps = gr.get(next3steps);
        Actor neighbor4steps = gr.get(next4steps);
        Actor neighbor5steps = gr.get(next5steps);
        Actor neighbor6steps = gr.get(next6steps);
        Actor neighbor7steps = gr.get(next7steps);
        Actor neighbor8steps = gr.get(next8steps);
        Actor neighbor9steps = gr.get(next9steps);
        Actor neighbor10steps = gr.get(next10steps);
        Actor neighbor11steps = gr.get(next11steps);
        Actor neighbor12steps = gr.get(next12steps);
        Actor neighbor13steps = gr.get(next13steps);
        Actor neighbor14steps = gr.get(next14steps);
        Actor neighbor15steps = gr.get(next15steps);
        Actor neighbor16steps = gr.get(next16steps);
        Actor neighbor17steps = gr.get(next17steps);
        Actor neighbor18steps = gr.get(next18steps);
        Actor neighbor19steps = gr.get(next19steps);


        if (neighbor1steps instanceof Rock){
            moveTo(next1steps) ;
        } else if (neighbor2steps instanceof Rock) {
            moveTo(next2steps) ;
        } else if (neighbor3steps instanceof Rock) {
            moveTo(next3steps) ;
        } else if (neighbor4steps instanceof Rock) {
            moveTo(next4steps) ;
        } else if (neighbor5steps instanceof Rock) {
            moveTo(next5steps) ;
        } else if (neighbor6steps instanceof Rock) {
            moveTo(next6steps) ;
        } else if (neighbor7steps instanceof Rock) {
            moveTo(next7steps) ;
        } else if (neighbor8steps instanceof Rock) {
            moveTo(next8steps) ;
        } else if (neighbor9steps instanceof Rock) {
            moveTo(next9steps) ;
        } else if (neighbor10steps instanceof Rock) {
            moveTo(next10steps) ;
        } else if (neighbor11steps instanceof Rock) {
            moveTo(next11steps) ;
        } else if (neighbor12steps instanceof Rock) {
            moveTo(next12steps) ;
        } else if (neighbor13steps instanceof Rock) {
            moveTo(next13steps) ;
        } else if (neighbor14steps instanceof Rock) {
            moveTo(next14steps) ;
        } else if (neighbor15steps instanceof Rock) {
            moveTo(next15steps) ;
        } else if (neighbor16steps instanceof Rock) {
            moveTo(next16steps) ;
        } else if (neighbor17steps instanceof Rock) {
            moveTo(next17steps) ;
        } else if (neighbor18steps instanceof Rock) {
            moveTo(next18steps) ;
        } else if (neighbor19steps instanceof Rock) {
            moveTo(next19steps) ;
        }else{
        }


        if(canClimb ){
            moveTo();
        }*/

    }


    private void moveOnTheRock() {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        Actor neighbor = gr.get(next);
        if (neighbor instanceof Rock) {
            moveTo(next);
//        }else if (gr.isValid(next)){
//            return;
        }else {
            removeSelfFromGrid();
            countGoatNumber = countGoatNumber - 1;
        }

        Rock rock = new Rock();
        rock.putSelfInGrid(gr, loc);
    }

    /*    public boolean canClimb()
        {
            Grid<Actor> gr = getGrid();
            if (gr == null)
                return false;
            Location loc = getLocation();
            Location next = loc.getAdjacentLocation(getDirection());
            if (!gr.isValid(next))
                return false;
            Actor neighbor = gr.get(next);
            return (neighbor == null)

        }*/


    @Override
    public void act() {

//        super.act();

        if (canMove()){
            move();

            if (Math.random() <= 1/5 && age > 15) {
/*            this.removeSelfFromGrid();
            countGoatNumber = countGoatNumber - 1;

            Grid<Actor> gr = getGrid();
            if (gr == null)
                return;
            Location loc = getLocation();
            Flower flower = new Flower(getColor());
            flower.putSelfInGrid(gr, loc);*/

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