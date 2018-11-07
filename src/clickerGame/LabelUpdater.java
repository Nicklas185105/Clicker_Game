package clickerGame;

import javax.swing.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * This class is responsible for creating and updating the labels for the GUI class.
 *
 * @author Nicklas Lydersen
 * @since 1.0.2
 */
public class LabelUpdater {

    //----- Clicks Labels -----
    public static JLabel cookies;
    public static JLabel cookiesPerSecond;
    public static JLabel clickPowerLabel;
    public static JLabel clickPowerCostLabel;
    public static JLabel clickPowerLevelLabel;

    //----- Cursor Labels -----
    public static JLabel cursorPowerLabel;
    public static JLabel cursorAmountLabel;
    public static JLabel cursorCostLabel;

    public LabelUpdater()
    {

    }

    /**
     * This is where I update the clicks label.
     * @param TF We are using this boolean to define if it's just for updating the label or if it's an actual player click. <p>true for click and false for updating.</p>
     * @since 1.0.1
     */
    public static void updateCookies(boolean TF)
    {
        if (TF) {

            GUI.totalCookies = GUI.totalCookies.add(new BigDecimal(Clicker.playerClicks));
        }
        System.out.println(GUI.totalCookies);
        if(GUI.totalCookies.compareTo(new BigDecimal("1000000")) < 0)
        {
            cookies.setText(GUI.totalCookies.setScale(0, RoundingMode.DOWN).toString());
        }
        else if (GUI.totalCookies.compareTo(new BigDecimal("1000000")) >= 0 && GUI.totalCookies.compareTo(new BigDecimal("1000000000")) < 0)
        {
            cookies.setText(GUI.totalCookies.divide(new BigDecimal("1000000"), 3, RoundingMode.HALF_EVEN) + " Million");
        }
        else if (GUI.totalCookies.compareTo(new BigDecimal("1000000000")) >= 0 && GUI.totalCookies.compareTo(new BigDecimal("1000000000000")) < 0)
        {
            cookies.setText(GUI.totalCookies.divide(new BigDecimal("1000000000"), 3, RoundingMode.HALF_EVEN) + " Billion");
        }
        else if (GUI.totalCookies.compareTo(new BigDecimal("1000000000000")) >= 0 && GUI.totalCookies.compareTo(new BigDecimal("1000000000000000")) < 0)
        {
            cookies.setText(GUI.totalCookies.divide(new BigDecimal("1000000000000"), 3, RoundingMode.HALF_EVEN) + " Trillion");
        }
        else if (GUI.totalCookies.compareTo(new BigDecimal("1000000000000000")) >= 0 && GUI.totalCookies.compareTo(new BigDecimal("1000000000000000000")) < 0)
        {
            cookies.setText(GUI.totalCookies.divide(new BigDecimal("1000000000000000"), 3, RoundingMode.HALF_EVEN) + "  Quadrillion");
        }
        else if (GUI.totalCookies.compareTo(new BigDecimal("1000000000000000000")) >= 0 && GUI.totalCookies.compareTo(new BigDecimal("1000000000000000000000")) < 0)
        {
            cookies.setText(GUI.totalCookies.divide(new BigDecimal("1000000000000000"), 3, RoundingMode.HALF_EVEN) + " Quintillion");
        }
    }

    /**
     * This is updating the Total Clicks variable and the Label to that variable. This is also where we are updating clickPower of the player,
     * while updating the labels for the different variables in clickPower.
     * @since 1.0.1
     */
    public static void updateClickPowerLabel()
    {
        if(GUI.totalCookies.compareTo(BigDecimal.valueOf(Clicker.clickPowerCost)) >= 0 && Clicker.clickPowerLevel <= 99)
        {
            GUI.totalCookies = GUI.totalCookies.add(BigDecimal.valueOf(Clicker.clickPowerCost).negate());
            updateCookies(false);
            Clicker.clickPower();
            clickPowerLabel.setText("Click Power = " + Clicker.playerClicks);
            clickPowerLevelLabel.setText("Level = " + Clicker.clickPowerLevel + " / 100");
            if(Clicker.clickPowerCost < 1000000)
            {
                clickPowerCostLabel.setText("Click Power Cost = " + Integer.toString(Math.toIntExact(Clicker.clickPowerCost)));
            }
            else if (Clicker.clickPowerCost > 1000000 && Clicker.clickPowerCost < 1653669)
            {
                clickPowerCostLabel.setText("Click Power Cost = " + Double.toString((double) Math.round((Clicker.clickPowerCost / 1000000d) * 1000d) / 1000d) + " Million");
            }
            else
            {
                clickPowerCostLabel.setText(" Click Power Cost = Level Maxed");
            }
        }
    }

    /**
     * This is where the labels for Arrow Clicker is updated.
     * @since 1.0.1
     */
    public static void updateCursorLabel()
    {
        if(GUI.totalCookies.compareTo(new BigDecimal(Buildings.cursorCost)) >= 0)
        {
            GUI.totalCookies = GUI.totalCookies.add(new BigDecimal(Buildings.cursorCost.negate()));
            updateCookies(false);
            Buildings.cursor();
            cursorPowerLabel.setText("Cursor Power = " + Buildings.cursorPower);
            cursorAmountLabel.setText("Cursor Amount = " + Buildings.cursorAmount);
            if(Buildings.cursorCost.compareTo(new BigInteger("1000000")) < 0)
            {
                cursorCostLabel.setText("Cursor Cost = " + Buildings.cursorCost.toString());
            }
            else if (Buildings.cursorCost.compareTo(new BigInteger("1000000")) >= 0 && Buildings.cursorCost.compareTo(new BigInteger("1000000000")) < 0)
            {
                cursorCostLabel.setText("Cursor Cost = " + new BigDecimal(Buildings.cursorCost).divide(new BigDecimal("1000000"),3, RoundingMode.HALF_EVEN) + " Million");
            }
            else if (Buildings.cursorCost.compareTo(new BigInteger("1000000000")) >= 0 && Buildings.cursorCost.compareTo(new BigInteger("1000000000000")) < 0)
            {
                cursorCostLabel.setText("Cursor Cost = " + new BigDecimal(Buildings.cursorCost).divide(new BigDecimal("1000000000"),3, RoundingMode.HALF_EVEN) + " Billion");
            }
            else if (Buildings.cursorCost.compareTo(new BigInteger("1000000000000")) >= 0 && Buildings.cursorCost.compareTo(new BigInteger("1000000000000000")) < 0)
            {
                cursorCostLabel.setText("Cursor Cost = " + new BigDecimal(Buildings.cursorCost).divide(new BigDecimal("1000000000000"),3, RoundingMode.HALF_EVEN) + " Trillion");
            }
            else if (Buildings.cursorCost.compareTo(new BigInteger("1000000000000000")) >= 0 && Buildings.cursorCost.compareTo(new BigInteger("1000000000000000000")) < 0)
            {
                cursorCostLabel.setText("Cursor Cost = " + new BigDecimal(Buildings.cursorCost).divide(new BigDecimal("1000000000000000"),3, RoundingMode.HALF_EVEN) + "  Quadrillion");
            }
            else if (Buildings.cursorCost.compareTo(new BigInteger("1000000000000000000")) >= 0 && Buildings.cursorCost.compareTo(new BigInteger("1000000000000000000000")) < 0)
            {
                cursorCostLabel.setText("Cursor Cost = " + new BigDecimal(Buildings.cursorCost).divide(new BigDecimal("1000000000000000000"),3, RoundingMode.HALF_EVEN) + " Quintillion");
            }
        }
    }
}
