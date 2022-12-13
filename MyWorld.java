import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (Vincent) 
 * @version (version4 | 11/12/2022)
 */
public class MyWorld extends World
{
    // Sets the score to be zero, declares scoreLabel variable and sets
    // level to 1
    public int score = 0;
    Label scoreLabel;
    int level = 1;
    int eleSpeed = 2;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        
        // Creates elephant in game
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 300);
        
        // Makes counter for # of apples eaten
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
        
        // Spawns apples indefinately
        spawnApple();
        
    }
    
    /**
     * End the game and draw 'GameOver'
     */
    public void gameOver()
    {
        // Creates "Game Over" label
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
    }
    
    public void increaseScore()
    {
        // Increases score by 1 and displays on screen
        score++;
        scoreLabel.setValue(score);
        
        // If 10 apples reached, level will increase by 1 and apples fall
        // faster!
        if(score % 10 == 0)
        {
            level += 1;
        }
    }
    
    public void spawnApple()
    {
        Apple apple = new Apple();
        apple.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x, y);
    }
}
