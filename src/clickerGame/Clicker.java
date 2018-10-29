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
    /**
     * This is the variable that defines the worth of the player click.
     */
    public static int playerClicks;
    /**
     * This is the variable that defines the cost of the Click Power upgrade.
     */
    public static int clickPowerCost;
    /**
     * This is the variable that defines the level of the Click Power upgrade.
     */
    public static int clickPowerLevel;

    /**
     * This is where we begin by giving our integer variables a value.
     */
    public Clicker()
    {
        playerClicks = 1;
        clickPowerCost = 10;
        clickPowerLevel = 0;
    }

    /**
     * This is where the first upgrade is made.
     * This upgrade is for upgrading the click power.
     */
    public static void clickPower()
    {
        playerClicks = Math.toIntExact(Math.round((playerClicks + 1) * 1.05));
        clickPowerCost = Math.toIntExact(Math.round((clickPowerCost + 10)* 1.1));
        clickPowerLevel++;
    }


    /**
     * For testing the new things we implement in this class.
     */
    public static void main (String[] args)
    {
        for(int i = 0; i < 100; i++){
            clickPower();
            System.out.println("Player Clicks: " + playerClicks + " Player Clicks Cost: " + clickPowerCost);
        }
    }
}
