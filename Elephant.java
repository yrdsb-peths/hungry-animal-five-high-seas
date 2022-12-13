import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elephant here.
 * 
 * @author (Vincent) 
 * @version (version3 | 12/12/2022)
 */
public class Elephant extends Actor
{
    int speed = 2;
    // Creates the elephant sound that will play when elephant eats an apple
    // Creates arrays for the # of frames of animation the game will cycle
    // through depending if the elephant is facing right or left
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[14];
    GreenfootImage[] idleLeft = new GreenfootImage[14];
    
    // String for when user presses 'A' or '->' to be used in "IF" loops
    // Creating a Timer to control elephant animation speed
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    public Elephant()
    {
        // Takes the image file name and puts it into the game
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i
            + ".png");
            idleRight[i].scale(50, 50);
        }
        // Takes the image and flips it so the elephant faces LEFT
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i
            + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(50, 50);
        }
        
        animationTimer.mark();
        // Sets image to the first image
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
            move(-(speed));
            facing = "left";
        }
        if(Greenfoot.isKeyDown("right")) {
            move(speed);
            facing = "right";
        }
        
        // AD keys to move elephant left and right
        if(Greenfoot.isKeyDown("a")) {
            move(-(speed));
            facing = "left";
        }
        if(Greenfoot.isKeyDown("d")) {
            move(speed);
            facing = "right";
        }
        
        // Removes apple if elephant eats it
        eat();
        
        // Animates the elephant
        animateElephant();
    }
    
    public void eat()
    {
        // If the elephant touches the apple, it increases apple, spawns
        // another and removes the existing apple, the elephant sound will
        // also play!
        if(isTouching(Apple.class)) {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.spawnApple();
            world.increaseScore();
            
            elephantSound.play();
        }
    }
    
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
