import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Apple here.
 * 
 * @author (Vincent) 
 * @version (version2 | 12/12/2022)
 */
public class Apple extends Actor
{
    int speed = 0;
    
    public Apple()
    {
        // Takes the apple.png file and scales it to appropriate proportions
        // Also sets the apple object to the image
        GreenfootImage apple = new GreenfootImage("images/apple.png");
        apple.scale(25, 25);
        setImage(apple);
    }
    
    /**
     * Act - do whatever the Apple wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setLocation(getX(), getY() + speed);
        
        // Removes apple and draws game over when apple gets to bottom
        MyWorld world = (MyWorld) getWorld();
        // If the apple touches the floor, the apple is removed from the game
        // and the game over label is displayed
        if(getY() >= world.getHeight())
        {
            world.gameOver();
            world.removeObject(this);
        }
    }
    
    public void setSpeed(int spd)
    {
        // Increases the speed of the apple falling
        speed = spd;
    }
}
