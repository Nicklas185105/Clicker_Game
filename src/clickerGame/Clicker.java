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
    //----- Player Clicks and Upgrades -----
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

    //----- Arrow Clicker -----
    public static int arrowClickPower;
    public static int arrowClickerAmount;
    public static int arrowClickerCost;

    /**
     * This is where we begin by giving our integer variables a value.
     * @since 1.0.1
     */
    public Clicker()
    {
        playerClicks = 1;
        clickPowerCost = 10;
        clickPowerLevel = 0;
        arrowClickPower = 1;
        arrowClickerAmount = 0;
        arrowClickerCost = 15;
    }

    /**
     * This upgrade is for upgrading the click power.
     * @since 1.0.1
     */
    public static void clickPower()
    {
        playerClicks = Math.toIntExact(Math.round((playerClicks + 1) * 1.05));
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
        arrowClickerCost = Math.toIntExact(Math.round(arrowClickerCost * 1.1));
    }

    /**
     * For testing the new things we implement in this class.
     * @since 1.0.1
     */
    public static void main (String[] args)
    {
        new Clicker();
        for(int i = 0; i < 100; i++){
            arrowClicker();
            System.out.println("Arrow Clicker Amount: " + arrowClickerAmount + " Arrow Clicker Cost: " + arrowClickerCost);
        }
    }
}
