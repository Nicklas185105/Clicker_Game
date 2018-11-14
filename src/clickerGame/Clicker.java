package clickerGame;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * This class is responsible for keeping track of the players click power, as well as all the upgrades.
 *
 * @author Nicklas Lydersen
 * @since 1.0.1
 */
public class Clicker {
    //I will start by making variables.
    //----- Player Clicks and Upgrades -----
    /**
     * This defines the worth of the player click.
     */
    static BigInteger playerClicks;
    /**
     * This defines the cost of the Click Power upgrade.
     */
    private static int clickPowerCost;
    /**
     * This defines the level of the Click Power upgrade.
     */
    private static int clickPowerLevel;

    /**
     * This is where we begin by giving our integer variables a value.
     *
     * @since 1.0.1
     */
    Clicker() {
        playerClicks = new BigInteger("1");
        clickPowerCost = 10;
        clickPowerLevel = 0;
    }

    /**
     * This upgrade is for upgrading the click power.
     *
     * @since 1.0.1
     */
    private static void clickPower() {
        BigInteger n = playerClicks.add(new BigInteger("1"));
        playerClicks = new BigDecimal(n).multiply(new BigDecimal("1.05")).setScale(0, RoundingMode.HALF_UP).toBigInteger();
        //playerClicks = Math.toIntExact(Math.round((playerClicks + 1L) * 1.05));
        clickPowerCost = Math.toIntExact(Math.round((clickPowerCost + 10) * 1.1));
        clickPowerLevel++;
    }

    /**
     * For testing the new things we implement in this class.
     *
     * @since 1.0.1
     */
    public static void main(String[] args) {
        new Clicker();
        for (int i = 0; i < 100; i++) {
            clickPower();
            System.out.println("Click Power Level " + clickPowerLevel + " Click Power Cost " + clickPowerCost);
        }
    }
}
