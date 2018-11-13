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
    static JLabel cookies;
    static JLabel cookiesPerSecond;
    static JLabel clickPowerLabel;
    static JLabel clickPowerCostLabel;
    static JLabel clickPowerLevelLabel;

    //----- Cursor Labels -----
    static JLabel cursorPowerLabel;
    static JLabel cursorAmountLabel;
    static JLabel cursorCostLabel;

    //----- Grandma Labels -----
    static JLabel grandmaPowerLabel;
    static JLabel grandmaAmountLabel;
    static JLabel grandmaCostLabel;

    //----- Farm Labels -----
    static JLabel farmPowerLabel;
    static JLabel farmAmountLabel;
    static JLabel farmCostLabel;

    //----- Mine Labels -----
    static JLabel minePowerLabel;
    static JLabel mineAmountLabel;
    static JLabel mineCostLabel;

    //----- Factory Labels -----
    static JLabel factoryPowerLabel;
    static JLabel factoryAmountLabel;
    static JLabel factoryCostLabel;

    //----- Bank Labels -----
    static JLabel bankPowerLabel;
    static JLabel bankAmountLabel;
    static JLabel bankCostLabel;

    //----- Temple Labels -----
    static JLabel templePowerLabel;
    static JLabel templeAmountLabel;
    static JLabel templeCostLabel;

    //----- Wizard Tower Labels -----
    static JLabel wizardTowerPowerLabel;
    static JLabel wizardTowerAmountLabel;
    static JLabel wizardTowerCostLabel;

    //----- Shipment Labels -----
    static JLabel shipmentPowerLabel;
    static JLabel shipmentAmountLabel;
    static JLabel shipmentCostLabel;

    //----- Alchemy Lab Labels -----
    static JLabel alchemyLabPowerLabel;
    static JLabel alchemyLabAmountLabel;
    static JLabel alchemyLabCostLabel;

    //----- Portal Labels -----
    static JLabel portalPowerLabel;
    static JLabel portalAmountLabel;
    static JLabel portalCostLabel;

    //----- Time Machine Labels -----
    static JLabel timeMachinePowerLabel;
    static JLabel timeMachineAmountLabel;
    static JLabel timeMachineCostLabel;

    //----- Antimatter Condenser Labels -----
    static JLabel antimatterCondenserPowerLabel;
    static JLabel antimatterCondenserAmountLabel;
    static JLabel antimatterCondenserCostLabel;

    //----- Prism Labels -----
    static JLabel prismPowerLabel;
    static JLabel prismAmountLabel;
    static JLabel prismCostLabeL;

    //----- Chancemaker Labels -----
    static JLabel chancemakerPowerLabel;
    static JLabel chancemakerAmountLabel;
    static JLabel chancemakeCostLabel;

    //----- Fractal Engine Labels -----
    static JLabel fractalEnginePowerLabel;
    static JLabel fractalEngineAmountLabel;
    static JLabel fractalEngineCostLabel;

    public LabelUpdater()
    {

    }

    /**
     * This is where I update the clicks label.
     * @param TF We are using this boolean to define if it's just for updating the label or if it's an actual player click. <p>true for click and false for updating.</p>
     * @since 1.0.1
     */
    static void updateCookies(boolean TF)
    {
        if (TF) {

            GUI.totalCookies = GUI.totalCookies.add(new BigDecimal(Clicker.playerClicks));
        }
        System.out.println(GUI.totalCookies);
        if(GUI.totalCookies.compareTo(new BigDecimal("1000000")) < 0)
        {
            cookies.setText(GUI.totalCookies.setScale(0, RoundingMode.DOWN).toString() + " Cookies");
        }
        else if (GUI.totalCookies.compareTo(new BigDecimal("1000000")) >= 0 && GUI.totalCookies.compareTo(new BigDecimal("1000000000")) < 0)
        {
            cookies.setText(GUI.totalCookies.divide(new BigDecimal("1000000"), 3, RoundingMode.HALF_EVEN) + " Million Cookies");
        }
        else if (GUI.totalCookies.compareTo(new BigDecimal("1000000000")) >= 0 && GUI.totalCookies.compareTo(new BigDecimal("1000000000000")) < 0)
        {
            cookies.setText(GUI.totalCookies.divide(new BigDecimal("1000000000"), 3, RoundingMode.HALF_EVEN) + " Billion Cookies");
        }
        else if (GUI.totalCookies.compareTo(new BigDecimal("1000000000000")) >= 0 && GUI.totalCookies.compareTo(new BigDecimal("1000000000000000")) < 0)
        {
            cookies.setText(GUI.totalCookies.divide(new BigDecimal("1000000000000"), 3, RoundingMode.HALF_EVEN) + " Trillion Cookies");
        }
        else if (GUI.totalCookies.compareTo(new BigDecimal("1000000000000000")) >= 0 && GUI.totalCookies.compareTo(new BigDecimal("1000000000000000000")) < 0)
        {
            cookies.setText(GUI.totalCookies.divide(new BigDecimal("1000000000000000"), 3, RoundingMode.HALF_EVEN) + "  Quadrillion Cookies");
        }
        else if (GUI.totalCookies.compareTo(new BigDecimal("1000000000000000000")) >= 0 && GUI.totalCookies.compareTo(new BigDecimal("1000000000000000000000")) < 0)
        {
            cookies.setText(GUI.totalCookies.divide(new BigDecimal("1000000000000000"), 3, RoundingMode.HALF_EVEN) + " Quintillion Cookies");
        }
    }

    /**
     * This is updating the Total Clicks variable and the Label to that variable. This is also where we are updating clickPower of the player,
     * while updating the labels for the different variables in clickPower.
     * @since 1.0.1
     */
    static void updateClickPowerLabel()
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
     * We are using this method for defining when the cost needs to be switch to 1 million etc, instead of 1,000,000.
     * @param costLabel The buildings cost label that needs to be updated.
     * @param costBuilding The buildings cost value.
     * @param string The buildings name.
     */
    private static void updateLabel(JLabel costLabel, BigInteger costBuilding, String string) {
        if (costBuilding.compareTo(new BigInteger("1000000")) < 0)
        {
            costLabel.setText(string + " Cost = " + costBuilding.toString());
        }
        else if (costBuilding.compareTo(new BigInteger("1000000")) >= 0 && costBuilding.compareTo(new BigInteger("1000000000")) < 0)
        {
            costLabel.setText(string + " Cost = " + new BigDecimal(costBuilding).divide(new BigDecimal("1000000"), 3, RoundingMode.HALF_EVEN) + " Million");
        }
        else if (costBuilding.compareTo(new BigInteger("1000000000")) >= 0 && costBuilding.compareTo(new BigInteger("1000000000000")) < 0)
        {
            costLabel.setText(string + " Cost = " + new BigDecimal(costBuilding).divide(new BigDecimal("1000000000"), 3, RoundingMode.HALF_EVEN) + " Billion");
        }
        else if (costBuilding.compareTo(new BigInteger("1000000000000")) >= 0 && costBuilding.compareTo(new BigInteger("1000000000000000")) < 0)
        {
            costLabel.setText(string + " Cost = " + new BigDecimal(costBuilding).divide(new BigDecimal("1000000000000"), 3, RoundingMode.HALF_EVEN) + " Trillion");
        }
        else if (costBuilding.compareTo(new BigInteger("1000000000000000")) >= 0 && costBuilding.compareTo(new BigInteger("1000000000000000000")) < 0)
        {
            costLabel.setText(string + " Cost = " + new BigDecimal(costBuilding).divide(new BigDecimal("1000000000000000"), 3, RoundingMode.HALF_EVEN) + "  Quadrillion");
        }
        else if (costBuilding.compareTo(new BigInteger("1000000000000000000")) >= 0 && costBuilding.compareTo(new BigInteger("1000000000000000000000")) < 0)
        {
            costLabel.setText(string + " Cost = " + new BigDecimal(costBuilding).divide(new BigDecimal("1000000000000000000"), 3, RoundingMode.HALF_EVEN) + " Quintillion");
        }

    }

    /**
     * This is where the labels for Arrow Clicker is updated.
     * @since 1.0.1
     */
    static void updateCursorLabel()
    {
        if(GUI.totalCookies.compareTo(new BigDecimal(Buildings.cursorCost)) >= 0)
        {
            GUI.totalCookies = GUI.totalCookies.add(new BigDecimal(Buildings.cursorCost.negate()));
            updateCookies(false);
            Buildings.cursor();
            cursorPowerLabel.setText("Cursor Power = " + Buildings.cursorPower);
            cursorAmountLabel.setText("Cursor Amount = " + Buildings.cursorAmount);
            updateLabel(cursorCostLabel,Buildings.cursorCost,"Cursor");
        }
    }

    /**
     * @since 1.0.2
     */
    static void updateGrandmaLabel()
    {
        if(GUI.totalCookies.compareTo(new BigDecimal(Buildings.grandmaCost)) >= 0)
        {
            GUI.totalCookies = GUI.totalCookies.add(new BigDecimal(Buildings.grandmaCost.negate()));
            updateCookies(false);
            Buildings.grandma();
            grandmaPowerLabel.setText("Grandma Power = " + Buildings.grandmaPower);
            grandmaAmountLabel.setText("Grandma Amount = " + Buildings.grandmaAmount);
            updateLabel(grandmaCostLabel,Buildings.grandmaCost,"Grandma");
        }
    }

    /**
     * @since 1.0.2
     */
    static void updateFarmLabel()
    {
        if(GUI.totalCookies.compareTo(new BigDecimal(Buildings.farmCost)) >= 0)
        {
            GUI.totalCookies = GUI.totalCookies.add(new BigDecimal(Buildings.farmCost.negate()));
            updateCookies(false);
            Buildings.farm();
            farmPowerLabel.setText("Farm Power = " + Buildings.farmPower);
            farmAmountLabel.setText("Farm Amount = " + Buildings.farmAmount);
            updateLabel(farmCostLabel,Buildings.farmCost, "Farm");
        }
    }

    /**
     * @since 1.0.2
     */
    static void updateMineLabel()
    {
        if(GUI.totalCookies.compareTo(new BigDecimal(Buildings.mineCost)) >= 0)
        {
            GUI.totalCookies = GUI.totalCookies.add(new BigDecimal(Buildings.mineCost.negate()));
            updateCookies(false);
            Buildings.mine();
            minePowerLabel.setText("Mine Power = " + Buildings.minePower);
            mineAmountLabel.setText("Mine Amount = " + Buildings.mineAmount);
            updateLabel(mineCostLabel,Buildings.mineCost,"Mine");
        }
    }

    static void updateFactoryLabel()
    {

    }

    static void updateBankLabel()
    {

    }

    static void updateTempleLabel()
    {

    }

    static void updateWizardTowerLabel()
    {

    }

    static void updateShipmentLabel()
    {

    }

    static void updateAlchemyLabLabel()
    {

    }

    static void updatePortalLabel()
    {

    }

    static void updateTimeMachineLabel()
    {

    }

    static void updateAntimatterCondeserLabel()
    {

    }

    static void updatePrismLabel()
    {

    }

    static void updateChancemakerLabel()
    {

    }

    static void updateFractalEngineLabel()
    {

    }

}
