package clickerGame;

/**
 * This is where I make the core of the game, like upgrades and Auto Clicker Towers.
 *
 * @author Nicklas Lydersen
 * @version 1.0.1
 */
public class Clicker
{
    //I will start by making variables.
    //----- Player Clicks and Upgrades -----
    /**
     * This defines the worth of the player click.
     */
    public static long playerClicks;
    /**
     * This defines the cost of the Click Power upgrade.
     */
    public static int clickPowerCost;
    /**
     * This defines the level of the Click Power upgrade.
     */
    public static int clickPowerLevel;

    //----- Arrow Clicker -----
    /**
     * This defines the Arrow Clickers Power.
     */
    public static int arrowClickPower;
    /**
     * This defines the amount the player has of Arrow Clicker.
     */
    public static int arrowClickerAmount;
    /**
     * This defines the cost of the Arrow Clicker.
     */
    public static long arrowClickerCost;

    /**
     * This is where we begin by giving our integer variables a value.
     * @since 1.0.1
     */
    public Clicker()
    {
        playerClicks = 1L;
        clickPowerCost = 10;
        clickPowerLevel = 0;
        arrowClickPower = 1;
        arrowClickerAmount = 0;
        arrowClickerCost = 15L;
    }

    /**
     * This upgrade is for upgrading the click power.
     * @since 1.0.1
     */
    public static void clickPower()
    {
        playerClicks = Math.toIntExact(Math.round((playerClicks + 1L) * 1.05));
        clickPowerCost = Math.toIntExact(Math.round((clickPowerCost + 10)* 1.1));
        clickPowerLevel++;
    }

    /**
     * This is where we update the amount of Arrow Clickers, the player has.
     * The cost of the Arrow Clicker is updated as well.
     * @since 1.0.1
     */
    public static void arrowClicker()
    {
        arrowClickerAmount++;
        arrowClickerCost = Math.round(arrowClickerCost * 1.1);
    }

    /**
     * For testing the new things we implement in this class.
     * @since 1.0.1
     */
    public static void main (String[] args)
    {
        new Clicker();
        for(int i = 0; i < 100; i++){
            clickPower();
            System.out.println("Click Power Level " + clickPowerLevel + " Click Power Cost " + clickPowerCost);
        }
    }
}
