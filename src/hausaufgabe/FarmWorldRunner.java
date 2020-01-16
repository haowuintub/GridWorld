package hausaufgabe;

import gridworld.framework.actor.*;
import gridworld.framework.grid.BoundedGrid;
import gridworld.framework.grid.Grid;
import gridworld.framework.grid.Location;

/**
 * @ author: Stefan Schulz, Hao Wu
 *
 *
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
    private ActorWorld world;

    //main
    public static void main(String[] args) {

        FarmWorldRunner farmWorldRunner = new FarmWorldRunner() ;
        farmWorldRunner.createNewWorldWithGridSize(20, 20);

        farmWorldRunner.addGoatIfFieldEmpty(5,5);
        farmWorldRunner.addGoatIfFieldEmpty(5,7);
        farmWorldRunner.addFlowerIfFieldEmpty(5,4);
        farmWorldRunner.addFlowerIfFieldEmpty(6,4);
        farmWorldRunner.addFlowerIfFieldEmpty(7,4);
        farmWorldRunner.addFlowerIfFieldEmpty(8,4);
        farmWorldRunner.addFlowerIfFieldEmpty(5,6);
        farmWorldRunner.addFlowerIfFieldEmpty(6,6);
        farmWorldRunner.addFlowerIfFieldEmpty(7,6);
        farmWorldRunner.addFlowerIfFieldEmpty(5,8);
        farmWorldRunner.addFlowerIfFieldEmpty(5,6);
        farmWorldRunner.addFlowerIfFieldEmpty(9,8);
        farmWorldRunner.addFlowerIfFieldEmpty(4,8);
        farmWorldRunner.addFlowerIfFieldEmpty(6,9);
        farmWorldRunner.addFlowerIfFieldEmpty(5,9);
        farmWorldRunner.addFlowerIfFieldEmpty(6,9);
        farmWorldRunner.addFarmerIfFieldEmpty(4,9);
        farmWorldRunner.addFarmerIfFieldEmpty(14,14);
        farmWorldRunner.addGoatMilkerIfFieldEmpty(12,8);
        farmWorldRunner.addCreatorFarmerIfFieldEmpty(6,5);
        farmWorldRunner.addRockIfFieldEmpty(2,5);
        farmWorldRunner.addRockIfFieldEmpty(0,5);
        farmWorldRunner.addRockIfFieldEmpty(3,5);
        farmWorldRunner.addRockIfFieldEmpty(8,8);
        farmWorldRunner.addRockIfFieldEmpty(9,8);
//        farmWorldRunner.runNSteps(50);


    }

    @Override
    public ActorWorld createNewWorldWithGridSize(int x, int y) {

        world = new ActorWorld(new BoundedGrid<>(x, y));
        world.show();
        return world;
    }

    @Override
    public Animal addAnimalIfFieldEmpty(int x, int y) {

        if(canAddActorIfFieldEmpty(x,y)) {

            Animal animal = new Animal();
            animal.putSelfInGrid(world.getGrid(), new Location(x,y));
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
            goat.putSelfInGrid(world.getGrid(), new Location(x,y));
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
            goatKid.putSelfInGrid(world.getGrid(),new Location(x,y));
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
            farmer.putSelfInGrid(world.getGrid(), new Location(x,y));
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
            creatorFarmer.putSelfInGrid(world.getGrid(), new Location(x,y));
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
            milkStorage.putSelfInGrid(world.getGrid(), new Location(x,y));
            return milkStorage;
        }
        else{
            return null ;
        }

    }

    @Override
    public GoatMilker addGoatMilkerIfFieldEmpty(int x, int y) {

        if(canAddActorIfFieldEmpty(x,y)){
            MilkStorage storage = addMilkStorageIfFieldEmpty(2,2);
            GoatMilker goatMilker = new GoatMilker(storage);
            goatMilker.putSelfInGrid(world.getGrid(), new Location(x,y));
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
            flower.putSelfInGrid(world.getGrid(), new Location(x,y));
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
            rock.putSelfInGrid(world.getGrid(), new Location(x,y));
            return rock;
        }
        else{
            return null ;
        }

    }

    private boolean canAddActorIfFieldEmpty(int x, int y)
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

    private boolean canGetToStringOfActorInField(int x, int y)
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
        for (int i=0; i<n; i++) {
            world.step();
        }
    }

}

