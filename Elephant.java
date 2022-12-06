import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elephant here.
 * 
 * @author (Vincent) 
 * @version (version2 | 11/30/2022)
 */
public class Elephant extends Actor
{
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Arrow keys to move elephant left and right
        if(Greenfoot.isKeyDown("left")) {
            move(-2);
        }
        if(Greenfoot.isKeyDown("right")) {
            move(2);
        }
        
        // AD keys to move elephant left and right
        if(Greenfoot.isKeyDown("a")) {
            move(-2);
        }
        if(Greenfoot.isKeyDown("d")) {
            move(2);
        }
        
        // Removes apple if elephant eats it
        eat();
    }
    
    public void eat()
    {
        if(isTouching(Apple.class)) {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.spawnApple();
            world.increaseScore();
            
            elephantSound.play();
        }
    }
}
