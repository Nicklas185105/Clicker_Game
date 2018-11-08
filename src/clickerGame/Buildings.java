package clickerGame;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 *
 * This class is responsible for creating the buildings and upgrading them, while keeping track of the total per second.
 *
 * <p>Cursor Building: {@link #cursor()}</p>
 * <p>Grandma Building {@link #grandma()}</p>
 * <p></p>
 *
 * @author Nicklas Lydersen
 * @since 1.0.2
 */
public class Buildings {

    /**
     * This integer is holding the amount of auto clicks the player has.
     */
    public static BigDecimal totalCookiesPerSecond;
    public static BigDecimal buildingCostMultiplier;

    //----- Cursor -----
    /**
     * This defines the Cursor Power.
     */
    public static BigDecimal cursorPower;
    /**
     * This defines the amount the player has of Cursor.
     */
    public static int cursorAmount;
    /**
     * This defines the cost of the Cursor.
     */
    public static BigInteger cursorCost;

    //----- Grandma -----
    public static BigInteger grandmaPower;
    public static int grandmaAmount;
    public static BigInteger grandmaCost;

    /**
     *
     * @since 1.0.2
     */
    public Buildings()
    {
        totalCookiesPerSecond = new BigDecimal("0");
        buildingCostMultiplier = new BigDecimal("1.15");

        //----- Cursor -----
        cursorPower = new BigDecimal("0.1");
        cursorAmount = 0;
        cursorCost = new BigInteger("15");

        //----- Grandma -----
        grandmaPower = new BigInteger("1");
        grandmaAmount = 0;
        grandmaCost = new BigInteger("100");
    }

    /**
     * This is used for when I need the program to sleep different places.
     * @param n Is the integer for how long the program needs to sleep. n = 1000 <=> 1 second
     */
    private static void sleep(int n)
    {
        try
        {
            Thread.sleep(n);
        }
        catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }
    }

    /**
     * This is where the loop for the auto clickers are running all the auto clickers.
     * @since 1.0.1
     */
    public static void cookiesPerSecondLoop()
    {
        while (GUI.gameRunning)
        {
            sleep(1000);
            GUI.totalCookies = GUI.totalCookies.add(totalCookiesPerSecond);
            LabelUpdater.updateCookies(false);
        }
    }

    /**
     *
     * This is were we update the {@link #totalCookiesPerSecond}.
     *
     * <p>Using these towers:</p>
     * <p>  - {@link #cursor()}</p>
     * <p>  - {@link }</p>
     *
     * @since 1.0.2
     */
    public static void setTotalCookiesPerSecond()
    {
        //----- Cursor -----
        totalCookiesPerSecond = new BigDecimal(cursorAmount).multiply(cursorPower);
        System.out.println(totalCookiesPerSecond);

        //----- Grandma -----
        totalCookiesPerSecond = totalCookiesPerSecond.add(new BigDecimal(grandmaAmount)).multiply(new BigDecimal(grandmaPower));

        //----- Update cookiesPerSecond Label -----
        LabelUpdater.cookiesPerSecond.setText("per second: " + totalCookiesPerSecond);
    }

    /**
     *
     * This is were we change the variables of the Cursor building.
     *
     * <p>We are changing the Cursor amount the player has.             Start amount = 0</p>
     * <p>We are changing the cost of the Cursor.                       Start cost = 15</p>
     * <p>We will change the power of the Cursor in here as well.       Start power = 0.1</p>
     *
     * @since 1.0.2
     */
    public static void cursor()
    {
        cursorAmount++;
        cursorCost = new BigDecimal(cursorCost).multiply(buildingCostMultiplier).setScale(0, RoundingMode.HALF_EVEN).toBigInteger();
        setTotalCookiesPerSecond();
    }

    /**
     *
     */
    public static void grandma()
    {
        grandmaAmount++;
        grandmaCost = new BigDecimal(grandmaCost).multiply(buildingCostMultiplier).setScale(0,RoundingMode.HALF_EVEN).toBigInteger();
        setTotalCookiesPerSecond();
    }
}
