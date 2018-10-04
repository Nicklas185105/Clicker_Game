/**
 * This is where I make the core of the game.
 *
 * @author Nicklas Lydersen
 * @version 1.0.1
 */
public class Clicker
{
    //I will start by making variables.
    public int playerClick = 0;

    /**
     * This is where
     */
    public Clicker()
    {
        clicks();
        playerClick = 0;
    }

    /**
     * This is where I record the clicks that is made.
     */
    public void clicks()
    {
        playerClick++;
        System.out.println(playerClick);
    }


    /**
     * For testing
     */
    /*public static void main (String[] args)
    {
        new Clicker();
    }*/
}
