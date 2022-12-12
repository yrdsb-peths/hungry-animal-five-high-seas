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
    GreenfootImage[] idleRight = new GreenfootImage[14];
    GreenfootImage[] idleLeft = new GreenfootImage[14];
    
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    public Elephant()
    {
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i
            + ".png");
            idleRight[i].scale(50, 50);
        }
        
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i
            + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(50, 50);
        }
        
        animationTimer.mark();
        
        setImage(idleRight[0]);
        
    }
    
    int imageIndex = 0;
    public void animateElephant()
    {
        if(animationTimer.millisElapsed() < 42)
        {
            return;
        }
        animationTimer.mark();
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
    
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Arrow keys to move elephant left and right
        if(Greenfoot.isKeyDown("left")) {
            move(-2);
            facing = "left";
        }
        if(Greenfoot.isKeyDown("right")) {
            move(2);
            facing = "right";
        }
        
        // AD keys to move elephant left and right
        if(Greenfoot.isKeyDown("a")) {
            move(-2);
            facing = "left";
        }
        if(Greenfoot.isKeyDown("d")) {
            move(2);
            facing = "right";
        }
        
        // Removes apple if elephant eats it
        eat();
        
        // Animate the elephant
        animateElephant();
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
