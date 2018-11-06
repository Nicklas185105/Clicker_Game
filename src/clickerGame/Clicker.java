package clickerGame;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * This is where I make the core of the game, like upgrades and Auto Clicker Towers.
 *
 * @author Nicklas Lydersen
 * @since 1.0.1
 */
public class Clicker
{
    //I will start by making variables.
    //----- Player Clicks and Upgrades -----
    /**
     * This defines the worth of the player click.
     */
    public static BigInteger playerClicks;
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
    public static BigInteger arrowClickerCost;

    /**
     * This is where we begin by giving our integer variables a value.
     * @since 1.0.1
     */
    public Clicker()
    {
        playerClicks = new BigInteger("1");
        clickPowerCost = 10;
        clickPowerLevel = 0;
        arrowClickPower = 1;
        arrowClickerAmount = 0;
        arrowClickerCost = new BigInteger("15");
    }

    /**
     * This upgrade is for upgrading the click power.
     * @since 1.0.1
     */
    public static void clickPower()
    {
        BigInteger n = playerClicks.add(new BigInteger("1"));
        playerClicks = new BigDecimal(n).multiply(new BigDecimal("1.05")).setScale(0 , RoundingMode.HALF_UP).toBigInteger();
        //playerClicks = Math.toIntExact(Math.round((playerClicks + 1L) * 1.05));
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
        arrowClickerCost = new BigDecimal(arrowClickerCost).multiply(new BigDecimal("1.25")).setScale(0, RoundingMode.HALF_UP).toBigInteger();
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
