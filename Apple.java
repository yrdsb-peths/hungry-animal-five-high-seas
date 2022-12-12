import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Apple here.
 * 
 * @author (Vincent) 
 * @version (version2 | 12/12/2022)
 */
public class Apple extends Actor
{
    public Apple()
    {
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
        setLocation(getX(), getY() + 1);
        
        // Removes apple and draws game over when apple gets to bottom
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight())
        {
            world.gameOver();
            world.removeObject(this);
        }
    }
}
