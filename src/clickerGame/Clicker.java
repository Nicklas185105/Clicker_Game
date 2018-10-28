package clickerGame;

/**
 * This is where I make the core of the game.
 *
 * @author Nicklas Lydersen
 * @version 1.0.1
 */
public class Clicker
{
    //I will start by making variables.
    public static int playerClicks;
    public static int clickPowerCost;
    public static int clickPowerLevel;

    /**
     * This is where
     */
    public Clicker()
    {
        playerClicks = 1;
        clickPowerCost = 10;
        clickPowerLevel = 0;
    }

    /**
     * This is where the first upgrade is made.
     *This upgrade is for upgrading the click power.
     */
    public static void clickPower()
    {
        playerClicks = Math.toIntExact(Math.round((playerClicks + 1) * 1.05));
        clickPowerCost = Math.toIntExact(Math.round((clickPowerCost + 10)* 1.1));
        clickPowerLevel++;
    }


    /**
     * For testing
     */
    public static void main (String[] args)
    {
        for(int i = 0; i < 100; i++){
            clickPower();
            System.out.println("Player Clicks: " + playerClicks + " Player Clicks Cost: " + clickPowerCost);
        }
    }
}
