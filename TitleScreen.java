import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (Vincent) 
 * @version (version1 | 12/12/2022)
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("Hungry Elephant", 90);
    Label description = new Label("Press space to start", 50);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        addObject(titleLabel, getWidth()/2, (getHeight()/2) - (getHeight()/4));
        addObject(description, getWidth()/2, (getHeight()/4) + (getHeight()/2));
        prepare();
    }

    public void act()
    {
        // Starts the game user pressses space bar
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Elephant elephant = new Elephant();
        addObject(elephant,305,190);
        Label arrows = new Label("Use <- and -> to move", 40);
        addObject(arrows, getWidth()/2,350);
        elephant.setLocation(305,214);
    }
}
