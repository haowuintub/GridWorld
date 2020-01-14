package hausaufgabe;

import gridworld.framework.actor.*;
import gridworld.framework.grid.BoundedGrid;
import gridworld.framework.grid.Grid;
import gridworld.framework.grid.Location;

/**
 * @ Stefan Schulz, Hao Wu
 */

/**
 * This class runs a world that contains a bug and a rock, added at random
 * locations. Click on empty locations to add additional actors. Click on
 * populated locations to invoke methods on their occupants. <br />
 * To build your own worlds, define your own actors and a runner class. See the
 * BoxBugRunner (in the boxBug folder) for an example. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class FarmWorldRunner implements FarmWorldRunnerInterface {

//Attribute
    public static int countGoatNumber = 0 ;
    ActorWorld world;

    //main
    public static void main(String[] args) {

        FarmWorldRunner farmWorldRunner = new FarmWorldRunner() ;
        ActorWorld world = farmWorldRunner.createNewWorldWithGridSize(20, 20);


        Actor goat = farmWorldRunner.addGoatIfFieldEmpty(5,5);
        Actor farmer = farmWorldRunner.addFarmerIfFieldEmpty(3,8);
        farmWorldRunner.addFarmerIfFieldEmpty(9,14);
        farmWorldRunner.addMilkStorageIfFieldEmpty(3,5);
        farmWorldRunner.addGoatMilkerIfFieldEmpty(7,8);
        Actor rock = farmWorldRunner.addRockIfFieldEmpty(1,5);
        farmWorldRunner.addRockIfFieldEmpty(2,5);
        farmWorldRunner.addRockIfFieldEmpty(3,5);


// In jedem Zeitschritt muss CratorFarmer GoatNumber prüfen. Einfach in class creatorFarmer auslagern?
        CreatorFarmer creatorFarmer = farmWorldRunner.addCreatorFarmerIfFieldEmpty(15,19);
        /*if(goat.getCountGoatNumber() == 0){
            creatorFarmer.checkGoatNumber();
        }*/
//        creatorFarmer.checkGoatNumber();

    }

    @Override
    public ActorWorld createNewWorldWithGridSize(int x, int y) {

        world = new ActorWorld(new BoundedGrid<>(x, y));
        return world;
    }

    @Override
    public Animal addAnimalIfFieldEmpty(int x, int y) {

        if(canAddActorIfFieldEmpty(x,y)) {

            Animal animal = new Animal();
            world.add(animal);
            world.show();
            return animal;
        }
        else {
            return null ;
        }

    }

    @Override
    public Goat addGoatIfFieldEmpty(int x, int y) {

        if(canAddActorIfFieldEmpty(x,y)){

            Goat goat = new Goat();
            world.add(goat);
            world.show();
            return goat;
        }
        else{
            return null ;
        }

    }

    @Override
    public GoatKid addGoatKidIfFieldEmpty(int x, int y) {

        if(canAddActorIfFieldEmpty(x,y)){

            GoatKid goatKid = new GoatKid();
            world.add(goatKid);
            world.show();
            return goatKid;
        }
        else{
            return null ;
        }

    }

    @Override
    public Farmer addFarmerIfFieldEmpty(int x, int y) {

        if(canAddActorIfFieldEmpty(x,y)){

            Farmer farmer = new Farmer();
            world.add(farmer);
            world.show();
            return farmer;
        }
        else{
            return null ;
        }

    }

    @Override
    public CreatorFarmer addCreatorFarmerIfFieldEmpty(int x, int y) {

        if(canAddActorIfFieldEmpty(x,y)){

            CreatorFarmer creatorFarmer = new CreatorFarmer();
            world.add(creatorFarmer);
            world.show();
            return creatorFarmer;
        }
        else{
            return null ;
        }

    }

    @Override
    public MilkStorage addMilkStorageIfFieldEmpty(int x, int y) {

        if(canAddActorIfFieldEmpty(x,y)){

            MilkStorage milkStorage = new MilkStorage();
            world.add(milkStorage);
            world.show();
            return milkStorage;
        }
        else{
            return null ;
        }

    }

    @Override
    public GoatMilker addGoatMilkerIfFieldEmpty(int x, int y) {

        if(canAddActorIfFieldEmpty(x,y)){

            GoatMilker goatMilker = new GoatMilker();
            world.add(goatMilker);
            world.show();
            return goatMilker;
        }
        else{
            return null ;
        }

    }

    @Override
    public Flower addFlowerIfFieldEmpty(int x, int y) {

        if(canAddActorIfFieldEmpty(x,y)){

            Flower flower = new Flower();
            world.add(flower);
            world.show();
            return flower;
        }
        else{
            return null ;
        }

    }

    @Override
    public Rock addRockIfFieldEmpty(int x, int y) {

        if(canAddActorIfFieldEmpty(x,y)){

            Rock rock = new Rock();
            world.add(rock);
            world.show();
            return rock;
        }
        else{
            return null ;
        }

    }

    public boolean canAddActorIfFieldEmpty(int x, int y)
    {
        Grid<Actor> gr = world.getGrid();

        if (gr == null)
            return false;
        Location loc = new Location(x,y);
        if (!gr.isValid(loc))
            return false;
        Actor neighbor = gr.get(loc);
        return (neighbor == null);
    }

    public boolean canGetToStringOfActorInField(int x, int y)
    {
        Grid<Actor> gr = world.getGrid();

        if (gr == null)
            return false;
        Location loc = new Location(x,y);
        if (!gr.isValid(loc))
            return false;
        Actor neighbor = gr.get(loc);
        return neighbor != null;
    }


    @Override
    public String getToStringOfActorInField(int x, int y) {

        if(canGetToStringOfActorInField(x,y)){

            Grid<Actor> gr = world.getGrid();
            Location loc = new Location(x,y);
            Actor actor = gr.get(loc);
            return actor.toString() ;
        }
        else{
            return null ;
        }
    }


    @Override
    public void runNSteps(int n) {

/*        while(step <= n){

        }*/


/*        System.exit(n);*/


/*        int num = 0;
        while (num < n && !Thread.interrupted()) {
            if ((num % 1000) == 0){
                System.out.println("--------------" + num);
            }
            num++;
        }*/

    }

}

