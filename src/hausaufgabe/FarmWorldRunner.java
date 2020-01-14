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


    //main
    public static void main(String[] args) {

        FarmWorldRunner farmWorldRunner = new FarmWorldRunner() ;
        ActorWorld world = farmWorldRunner.createNewWorldWithGridSize(20, 20);


//        farmWorldRunner.addAnimalIfFieldEmpty(9,2);
        Actor goat = farmWorldRunner.addGoatIfFieldEmpty(5,5);
//        Actor farmer = farmWorldRunner.addFarmerIfFieldEmpty(3,8);
/*        farmWorldRunner.addFarmerIfFieldEmpty(9,14);
        farmWorldRunner.addMilkStorageIfFieldEmpty(3,5);
        farmWorldRunner.addGoatMilkerIfFieldEmpty(7,8);
*/        Actor rock = farmWorldRunner.addRockIfFieldEmpty(1,5);
        farmWorldRunner.addRockIfFieldEmpty(2,5);
//        farmWorldRunner.addRockIfFieldEmpty(3,5);


// In jedem Zeitschritt muss CratorFarmer GoatNumber prüfen. Einfach in class creatorFarmer auslagern?
        CreatorFarmer creatorFarmer = farmWorldRunner.addCreatorFarmerIfFieldEmpty(15,19);
        /*if(goat.getCountGoatNumber() == 0){
            creatorFarmer.checkGoatNumber();
        }*/
//        creatorFarmer.checkGoatNumber();



// bitte erklären!
       /* Thread thread = new Thread(new FarmWorldRunner());
        thread.start();
        try {
            Thread.sleep(50L);
        } catch (InterruptedException e) {
            System.out.println("catch exception");
            e.printStackTrace();
        }
        thread.interrupt();
    }*/

    }


// hmmmmm... bei @override stellt sich mir die Frage, ob jedes Mal eine neue new ActorWorld erstellt werden muss, wenn addXXXIFFieldIsEmpty() läuft.

    @Override
    public ActorWorld createNewWorldWithGridSize(int x, int y) {

        ActorWorld world = new ActorWorld(new BoundedGrid<Actor>(x, y));

          BoundedGrid<Actor> boundedGrid = new BoundedGrid<Actor>(x, y);


/*        Grid<T> gr;
        int DEFAULT_ROWS ;
        int DEFAULT_COLS ;

        this(new BoundedGrid<T>(DEFAULT_ROWS, DEFAULT_COLS));
        message = null;*/

        return world;
    }

    @Override
    public Animal addAnimalIfFieldEmpty(int x, int y) {

        if(canAddActorIfFieldEmpty(x,y)){
            ActorWorld world = new ActorWorld();

            Animal animal = new Animal();
            world.add(animal);
            world.show();

            return animal;
        }else{
            return null ;
        }

    }

    @Override
    public Goat addGoatIfFieldEmpty(int x, int y) {

        if(canAddActorIfFieldEmpty(x,y)){
            ActorWorld world = new ActorWorld();

            Goat goat = new Goat();
            world.add(goat);
            world.show();

            return goat;
        }else{
            return null ;
        }

    }

    @Override
    public GoatKid addGoatKidIfFieldEmpty(int x, int y) {

        if(canAddActorIfFieldEmpty(x,y)){
            ActorWorld world = new ActorWorld();

            GoatKid goatKid = new GoatKid();
            world.add(goatKid);
            world.show();

            return goatKid;
        }else{
            return null ;
        }

    }

    @Override
    public Farmer addFarmerIfFieldEmpty(int x, int y) {

        if(canAddActorIfFieldEmpty(x,y)){
            ActorWorld world = new ActorWorld();

            Farmer farmer = new Farmer();
            world.add(farmer);
            world.show();

            return farmer;
        }else{
            return null ;
        }

    }

    @Override
    public CreatorFarmer addCreatorFarmerIfFieldEmpty(int x, int y) {

        if(canAddActorIfFieldEmpty(x,y)){
            ActorWorld world = new ActorWorld();

            CreatorFarmer creatorFarmer = new CreatorFarmer();
            world.add(creatorFarmer);
            world.show();

            return creatorFarmer;
        }else{
            return null ;
        }

    }

    @Override
    public MilkStorage addMilkStorageIfFieldEmpty(int x, int y) {

        if(canAddActorIfFieldEmpty(x,y)){
            ActorWorld world = new ActorWorld();

            MilkStorage milkStorage = new MilkStorage();
            world.add(milkStorage);
            world.show();

            return milkStorage;
        }else{
            return null ;
        }

    }

    @Override
    public GoatMilker addGoatMilkerIfFieldEmpty(int x, int y) {

        if(canAddActorIfFieldEmpty(x,y)){
            ActorWorld world = new ActorWorld();

            GoatMilker goatMilker = new GoatMilker();
            world.add(goatMilker);
            world.show();

            return goatMilker;
        }else{
            return null ;
        }

    }

    @Override
    public Flower addFlowerIfFieldEmpty(int x, int y) {

        if(canAddActorIfFieldEmpty(x,y)){
            ActorWorld world = new ActorWorld();

            Flower flower = new Flower();
            world.add(flower);
            world.show();

            return flower;
        }else{
            return null ;
        }

    }

    @Override
    public Rock addRockIfFieldEmpty(int x, int y) {

        if(canAddActorIfFieldEmpty(x,y)){
            ActorWorld world = new ActorWorld();

            Rock rock = new Rock();
            world.add(rock);
            world.show();

            return rock;
        }else{
            return null ;
        }

    }

    public boolean canAddActorIfFieldEmpty(int x, int y)
    {
        ActorWorld actorWorld = new ActorWorld();
        Grid<Actor> gr = actorWorld.getGrid();

        if (gr == null)
            return false;
        Location loc = new Location(x,y);
        if (!gr.isValid(loc))
            return false;
        Actor neighbor = gr.get(loc);
        return (neighbor == null);/*|| (neighbor instanceof Flower)*/
    }

    public boolean canGetToStringOfActorInField(int x, int y)
    {
        ActorWorld actorWorld = new ActorWorld();
        Grid<Actor> gr = actorWorld.getGrid();

        if (gr == null)
            return false;
        Location loc = new Location(x,y);
        if (!gr.isValid(loc))
            return false;
        Actor neighbor = gr.get(loc);
        if(neighbor == null/*|| (neighbor instanceof Flower)*/){
            return false;
        }else{
            return true;
        }
    }


    @Override
    public String getToStringOfActorInField(int x, int y) {

        if(canGetToStringOfActorInField(x,y)){

        ActorWorld actorWorld = new ActorWorld();

        Grid<Actor> gr = actorWorld.getGrid();
/*        if (gr == null)
            return false;*/
        Location loc = new Location(x,y);
        Actor actor = gr.get(loc);
        return actor.toString() ;

        }else{
            return null ;
        }

//        return null;
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

