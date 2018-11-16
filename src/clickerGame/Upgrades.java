package clickerGame;

import javax.swing.*;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * This class is responsible for creating the upgrades for the click ang building power.
 *
 * @author Nicklas Lydersen
 * @since 1.0.1
 */
class Upgrades {

    //----- Clicker & Cursor Upgrades -----
    static int rifQuantityNeeded;
    static BigInteger rifPrice;
    static  boolean rifVisible;
    static JButton rifButton;

    //----- Grandma Upgrades -----

    //----- Farm Upgrades -----

    //----- Mine Upgrades -----

    //----- Factory Upgrades -----

    //----- Bank Upgrades -----

    //----- Temple Upgrades -----

    //----- Wizard Tower Upgrades -----

    //----- Shipment Upgrades -----

    //----- Alchemy Lab Upgrades -----

    //----- Portal Upgrades -----

    //----- Antimatter Condenser Upgrades -----

    //----- Prism Upgrades -----

    //----- Chancemaker Upgrades -----

    //----- Fractal Engine Upgrades -----

    /**
     *
     * @since 1.0.1
     */
    Upgrades() {
        rifQuantityNeeded = 1;
        rifPrice = new BigInteger("100");
        rifVisible = true;

    }

    static void rif()
    {
        if(rifVisible)
        {
            Buildings.cursorPower = Buildings.cursorPower.multiply(new BigDecimal("2"));
            Buildings.playerClicks = Buildings.playerClicks.multiply(new BigInteger("2"));
            Buildings.setTotalCookiesPerSecond();
            GUI.loadImage(rifButton, "resources/Upgrades/Cursor/Reinforced index finger dark.png");
            rifButton.setToolTipText(null);
            GUI.totalCookies = GUI.totalCookies.add(new BigDecimal(Upgrades.rifPrice).negate());
            Upgrades.rifVisible = false;
        }
    }

}
