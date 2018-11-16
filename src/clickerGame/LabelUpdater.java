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

    //----- Cookies Labels -----
    static JLabel cookies;
    static JLabel cookiesPerSecond;

    //----- Cursor Labels -----
    static JLabel cursorPowerLabel;
    static JLabel cursorAmountLabel;
    static JLabel cursorCostLabel;
    static JButton cursorButton;

    //----- Grandma Labels -----
    static JLabel grandmaPowerLabel;
    static JLabel grandmaAmountLabel;
    static JLabel grandmaCostLabel;
    static JButton grandmaButton;

    //----- Farm Labels -----
    static JLabel farmPowerLabel;
    static JLabel farmAmountLabel;
    static JLabel farmCostLabel;
    static JButton farmButton;

    //----- Mine Labels -----
    static JLabel minePowerLabel;
    static JLabel mineAmountLabel;
    static JLabel mineCostLabel;
    static JButton mineButton;

    //----- Factory Labels -----
    static JLabel factoryPowerLabel;
    static JLabel factoryAmountLabel;
    static JLabel factoryCostLabel;
    static JButton factoryButton;

    //----- Bank Labels -----
    static JLabel bankPowerLabel;
    static JLabel bankAmountLabel;
    static JLabel bankCostLabel;
    static JButton bankButton;

    //----- Temple Labels -----
    static JLabel templePowerLabel;
    static JLabel templeAmountLabel;
    static JLabel templeCostLabel;
    static JButton templeButton;

    //----- Wizard Tower Labels -----
    static JLabel wizardTowerPowerLabel;
    static JLabel wizardTowerAmountLabel;
    static JLabel wizardTowerCostLabel;
    static JButton wizardTowerButton;

    //----- Shipment Labels -----
    static JLabel shipmentPowerLabel;
    static JLabel shipmentAmountLabel;
    static JLabel shipmentCostLabel;
    static JButton shipmentButton;

    //----- Alchemy Lab Labels -----
    static JLabel alchemyLabPowerLabel;
    static JLabel alchemyLabAmountLabel;
    static JLabel alchemyLabCostLabel;
    static JButton alchemyLabButton;

    //----- Portal Labels -----
    static JLabel portalPowerLabel;
    static JLabel portalAmountLabel;
    static JLabel portalCostLabel;
    static JButton portalButton;

    //----- Time Machine Labels -----
    static JLabel timeMachinePowerLabel;
    static JLabel timeMachineAmountLabel;
    static JLabel timeMachineCostLabel;
    static JButton timeMachineButton;

    //----- Antimatter Condenser Labels -----
    static JLabel antimatterCondenserPowerLabel;
    static JLabel antimatterCondenserAmountLabel;
    static JLabel antimatterCondenserCostLabel;
    static JButton antimatterCondenserButton;

    //----- Prism Labels -----
    static JLabel prismPowerLabel;
    static JLabel prismAmountLabel;
    static JLabel prismCostLabel;
    static JButton prismButton;

    //----- Chancemaker Labels -----
    static JLabel chancemakerPowerLabel;
    static JLabel chancemakerAmountLabel;
    static JLabel chancemakerCostLabel;
    static JButton chancemakerButton;

    //----- Fractal Engine Labels -----
    static JLabel fractalEnginePowerLabel;
    static JLabel fractalEngineAmountLabel;
    static JLabel fractalEngineCostLabel;
    static JButton fractalEngineButton;

    public LabelUpdater() {

    }

    /**
     * This is where I update the clicks label.
     *
     * @param TF We are using this boolean to define if it's just for updating the label or if it's an actual player click. <p>true for click and false for updating.</p>
     * @since 1.0.1
     */
    static void updateCookies(boolean TF) {
        if (TF) {

            GUI.totalCookies = GUI.totalCookies.add(new BigDecimal(Buildings.playerClicks));
        }
        if (GUI.totalCookies.compareTo(new BigDecimal("1000000")) < 0) {
            cookies.setText(GUI.totalCookies.setScale(0, RoundingMode.DOWN).toString() + " Cookies");
        } else if (GUI.totalCookies.compareTo(new BigDecimal("1000000")) >= 0 && GUI.totalCookies.compareTo(new BigDecimal("1000000000")) < 0) {
            cookies.setText(GUI.totalCookies.divide(new BigDecimal("1000000"), 3, RoundingMode.HALF_EVEN) + " Million Cookies");
        } else if (GUI.totalCookies.compareTo(new BigDecimal("1000000000")) >= 0 && GUI.totalCookies.compareTo(new BigDecimal("1000000000000")) < 0) {
            cookies.setText(GUI.totalCookies.divide(new BigDecimal("1000000000"), 3, RoundingMode.HALF_EVEN) + " Billion Cookies");
        } else if (GUI.totalCookies.compareTo(new BigDecimal("1000000000000")) >= 0 && GUI.totalCookies.compareTo(new BigDecimal("1000000000000000")) < 0) {
            cookies.setText(GUI.totalCookies.divide(new BigDecimal("1000000000000"), 3, RoundingMode.HALF_EVEN) + " Trillion Cookies");
        } else if (GUI.totalCookies.compareTo(new BigDecimal("1000000000000000")) >= 0 && GUI.totalCookies.compareTo(new BigDecimal("1000000000000000000")) < 0) {
            cookies.setText(GUI.totalCookies.divide(new BigDecimal("1000000000000000"), 3, RoundingMode.HALF_EVEN) + "  Quadrillion Cookies");
        } else if (GUI.totalCookies.compareTo(new BigDecimal("1000000000000000000")) >= 0 && GUI.totalCookies.compareTo(new BigDecimal("1000000000000000000000")) < 0) {
            cookies.setText(GUI.totalCookies.divide(new BigDecimal("1000000000000000"), 3, RoundingMode.HALF_EVEN) + " Quintillion Cookies");
        }
    }

    /**
     * We are using this method for defining when the cost needs to be switch to 1 million etc, instead of 1,000,000.
     *
     * @param costLabel    The buildings cost label that needs to be updated.
     * @param costBuilding The buildings cost value.
     * @param string       The buildings name.
     */
    private static void updateLabel(JLabel costLabel, BigInteger costBuilding, String string) {
        if (costBuilding.compareTo(new BigInteger("1000000")) < 0) {
            costLabel.setText(string + " Cost = " + costBuilding.toString());
        } else if (costBuilding.compareTo(new BigInteger("1000000")) >= 0 && costBuilding.compareTo(new BigInteger("1000000000")) < 0) {
            costLabel.setText(string + " Cost = " + new BigDecimal(costBuilding).divide(new BigDecimal("1000000"), 3, RoundingMode.HALF_EVEN) + " Million");
        } else if (costBuilding.compareTo(new BigInteger("1000000000")) >= 0 && costBuilding.compareTo(new BigInteger("1000000000000")) < 0) {
            costLabel.setText(string + " Cost = " + new BigDecimal(costBuilding).divide(new BigDecimal("1000000000"), 3, RoundingMode.HALF_EVEN) + " Billion");
        } else if (costBuilding.compareTo(new BigInteger("1000000000000")) >= 0 && costBuilding.compareTo(new BigInteger("1000000000000000")) < 0) {
            costLabel.setText(string + " Cost = " + new BigDecimal(costBuilding).divide(new BigDecimal("1000000000000"), 3, RoundingMode.HALF_EVEN) + " Trillion");
        } else if (costBuilding.compareTo(new BigInteger("1000000000000000")) >= 0 && costBuilding.compareTo(new BigInteger("1000000000000000000")) < 0) {
            costLabel.setText(string + " Cost = " + new BigDecimal(costBuilding).divide(new BigDecimal("1000000000000000"), 3, RoundingMode.HALF_EVEN) + "  Quadrillion");
        } else if (costBuilding.compareTo(new BigInteger("1000000000000000000")) >= 0 && costBuilding.compareTo(new BigInteger("1000000000000000000000")) < 0) {
            costLabel.setText(string + " Cost = " + new BigDecimal(costBuilding).divide(new BigDecimal("1000000000000000000"), 3, RoundingMode.HALF_EVEN) + " Quintillion");
        }

    }

    /**
     * This is where the labels for Arrow Upgrades is updated.
     *
     * @since 1.0.1
     */
    static void updateCursorLabel() {
        if (GUI.totalCookies.compareTo(new BigDecimal(Buildings.cursorCost)) >= 0) {
            GUI.totalCookies = GUI.totalCookies.add(new BigDecimal(Buildings.cursorCost.negate()));
            updateCookies(false);
            Buildings.cursor();
            cursorPowerLabel.setText("Cursor Power = " + Buildings.cursorPower);
            cursorAmountLabel.setText("Cursor Amount = " + Buildings.cursorAmount);
            updateLabel(cursorCostLabel, Buildings.cursorCost, "Cursor");
            cursorButton.setToolTipText("<html>Cursor<br>amount: " + Buildings.cursorAmount + "<br>cost: " + Buildings.cursorCost + "<br>power: " + Buildings.cursorPower + "<br>Autoclicks once every 10 seconds.</html>");
        }
    }

    /**
     * @since 1.0.2
     */
    static void updateGrandmaLabel() {
        if (GUI.totalCookies.compareTo(new BigDecimal(Buildings.grandmaCost)) >= 0) {
            GUI.totalCookies = GUI.totalCookies.add(new BigDecimal(Buildings.grandmaCost.negate()));
            updateCookies(false);
            Buildings.grandma();
            grandmaPowerLabel.setText("Grandma Power = " + Buildings.grandmaPower);
            grandmaAmountLabel.setText("Grandma Amount = " + Buildings.grandmaAmount);
            updateLabel(grandmaCostLabel, Buildings.grandmaCost, "Grandma");
            grandmaButton.setToolTipText("<html>Grandma<br>amount: " + Buildings.grandmaAmount + "<br>cost: " + Buildings.grandmaCost + "<br>power: " + Buildings.grandmaPower + "<br>A nice grandma to bake more cookies.</html>");
        }
    }

    /**
     * @since 1.0.2
     */
    static void updateFarmLabel() {
        if (GUI.totalCookies.compareTo(new BigDecimal(Buildings.farmCost)) >= 0) {
            GUI.totalCookies = GUI.totalCookies.add(new BigDecimal(Buildings.farmCost.negate()));
            updateCookies(false);
            Buildings.farm();
            farmPowerLabel.setText("Farm Power = " + Buildings.farmPower);
            farmAmountLabel.setText("Farm Amount = " + Buildings.farmAmount);
            updateLabel(farmCostLabel, Buildings.farmCost, "Farm");
            farmButton.setToolTipText("<html>Farm<br>amount: " + Buildings.farmAmount + "<br>cost: " + Buildings.farmCost + "<br>power: " + Buildings.farmPower + "<br>Grows cookie plants from cookie seeds.</html>");
        }
    }

    /**
     * @since 1.0.2
     */
    static void updateMineLabel() {
        if (GUI.totalCookies.compareTo(new BigDecimal(Buildings.mineCost)) >= 0) {
            GUI.totalCookies = GUI.totalCookies.add(new BigDecimal(Buildings.mineCost.negate()));
            updateCookies(false);
            Buildings.mine();
            minePowerLabel.setText("Mine Power = " + Buildings.minePower);
            mineAmountLabel.setText("Mine Amount = " + Buildings.mineAmount);
            updateLabel(mineCostLabel, Buildings.mineCost, "Mine");
            mineButton.setToolTipText("<html>Mine<br>amount: " + Buildings.mineAmount + "<br>cost: " + Buildings.mineCost + "<br>power: " + Buildings.minePower + "<br>Mines out cookie dough and chocolate chips.</html>");
        }
    }

    static void updateFactoryLabel() {
        if (GUI.totalCookies.compareTo(new BigDecimal(Buildings.factoryCost)) >= 0) {
            GUI.totalCookies = GUI.totalCookies.add(new BigDecimal(Buildings.factoryCost.negate()));
            updateCookies(false);
            Buildings.factory();
            factoryPowerLabel.setText("Factory Power = " + Buildings.factoryPower);
            factoryAmountLabel.setText("Factory Amount = " + Buildings.factoryAmount);
            updateLabel(factoryCostLabel, Buildings.factoryCost, "Factory");
            factoryButton.setToolTipText("<html>Factory<br>amount: " + Buildings.factoryAmount + "<br>cost: " + Buildings.factoryCost + "<br>power: " + Buildings.factoryPower + "<br>Produces large quantities of cookies.</html>");
        }
    }

    static void updateBankLabel() {
        if (GUI.totalCookies.compareTo(new BigDecimal(Buildings.bankCost)) >= 0) {
            GUI.totalCookies = GUI.totalCookies.add(new BigDecimal(Buildings.bankCost.negate()));
            updateCookies(false);
            Buildings.bank();
            bankPowerLabel.setText("Bank Power = " + Buildings.bankPower);
            bankAmountLabel.setText("Bank Amount = " + Buildings.bankAmount);
            updateLabel(bankCostLabel, Buildings.bankCost, "Bank");
            bankButton.setToolTipText("<html>Bank<br>amount: " + Buildings.bankAmount + "<br>cost: " + Buildings.bankCost + "<br>power: " + Buildings.bankPower + "<br>Generates cookies from interest.</html>");
        }
    }

    static void updateTempleLabel() {
        if (GUI.totalCookies.compareTo(new BigDecimal(Buildings.templeCost)) >= 0) {
            GUI.totalCookies = GUI.totalCookies.add(new BigDecimal(Buildings.templeCost.negate()));
            updateCookies(false);
            Buildings.temple();
            templePowerLabel.setText("Temple Power = " + Buildings.templePower);
            templeAmountLabel.setText("Temple Amount = " + Buildings.templeAmount);
            updateLabel(templeCostLabel, Buildings.templeCost, "Temple");
            templeButton.setToolTipText("<html>Temple<br>amount: " + Buildings.templeAmount + "<br>cost: " + Buildings.templeCost + "<br>power: " + Buildings.templePower + "<br>Full of precious, ancient chocolate.</html>");
        }
    }

    static void updateWizardTowerLabel() {
        if (GUI.totalCookies.compareTo(new BigDecimal(Buildings.wizardTowerCost)) >= 0) {
            GUI.totalCookies = GUI.totalCookies.add(new BigDecimal(Buildings.wizardTowerCost.negate()));
            updateCookies(false);
            Buildings.wizardTower();
            wizardTowerPowerLabel.setText("WT Power = " + Buildings.wizardTowerPower);
            wizardTowerAmountLabel.setText("WT Amount = " + Buildings.wizardTowerAmount);
            updateLabel(wizardTowerCostLabel, Buildings.wizardTowerCost, "WT");
            wizardTowerButton.setToolTipText("<html>Wizard Tower<br>amount: " + Buildings.wizardTowerAmount + "<br>cost: " + Buildings.wizardTowerCost + "<br>power: " + Buildings.wizardTowerPower + "<br>Summons cookies with magic spells.</html>");
        }
    }

    static void updateShipmentLabel() {
        if (GUI.totalCookies.compareTo(new BigDecimal(Buildings.shipmentCost)) >= 0) {
            GUI.totalCookies = GUI.totalCookies.add(new BigDecimal(Buildings.shipmentCost.negate()));
            updateCookies(false);
            Buildings.shipment();
            shipmentPowerLabel.setText("Shipment Power = " + Buildings.shipmentPower);
            shipmentAmountLabel.setText("Shipment Amount = " + Buildings.shipmentAmount);
            updateLabel(shipmentCostLabel, Buildings.shipmentCost, "Shipment");
            shipmentButton.setToolTipText("<html>Shipment<br>amount: " + Buildings.shipmentAmount + "<br>cost: " + Buildings.shipmentCost + "<br>power: " + Buildings.shipmentPower + "<br>Brings in fresh cookies from the cookie planet.</html>");
        }
    }

    static void updateAlchemyLabLabel() {
        if (GUI.totalCookies.compareTo(new BigDecimal(Buildings.alchemyLabCost)) >= 0) {
            GUI.totalCookies = GUI.totalCookies.add(new BigDecimal(Buildings.alchemyLabCost.negate()));
            updateCookies(false);
            Buildings.alchemyLab();
            alchemyLabPowerLabel.setText("AL Power = " + Buildings.alchemyLabPower.divide(new BigDecimal("1000000"), 3, RoundingMode.HALF_EVEN) + " Million");
            alchemyLabAmountLabel.setText("AL Amount = " + Buildings.alchemyLabAmount);
            updateLabel(alchemyLabCostLabel, Buildings.alchemyLabCost, "AL");
            alchemyLabButton.setToolTipText("<html>Alchemy Lab<br>amount: " + Buildings.alchemyLabAmount + "<br>cost: " + Buildings.alchemyLabCost + "<br>power: " + Buildings.alchemyLabPower + "<br>Turns gold into cookies!</html>");
        }
    }

    static void updatePortalLabel() {
        if (GUI.totalCookies.compareTo(new BigDecimal(Buildings.portalCost)) >= 0) {
            GUI.totalCookies = GUI.totalCookies.add(new BigDecimal(Buildings.portalCost.negate()));
            updateCookies(false);
            Buildings.portal();
            portalPowerLabel.setText("Portal Power = " + Buildings.portalPower.divide(new BigDecimal("1000000"), 3, RoundingMode.HALF_EVEN) + " Million");
            portalAmountLabel.setText("Portal Amount = " + Buildings.portalAmount);
            updateLabel(portalCostLabel, Buildings.portalCost, "Portal");
            portalButton.setToolTipText("<html>Portal<br>amount: " + Buildings.portalAmount + "<br>cost: " + Buildings.portalCost + "<br>power: " + Buildings.portalPower + "<br>Opens the door to the Cookieverse.</html>");
        }
    }

    static void updateTimeMachineLabel() {
        if (GUI.totalCookies.compareTo(new BigDecimal(Buildings.timeMachineCost)) >= 0) {
            GUI.totalCookies = GUI.totalCookies.add(new BigDecimal(Buildings.timeMachineCost.negate()));
            updateCookies(false);
            Buildings.timeMachine();
            timeMachinePowerLabel.setText("TM Power = " + Buildings.timeMachinePower.divide(new BigDecimal("1000000"), 3, RoundingMode.HALF_EVEN) + " Million");
            timeMachineAmountLabel.setText("TM Amount = " + Buildings.timeMachineAmount);
            updateLabel(timeMachineCostLabel, Buildings.timeMachineCost, "TM");
            timeMachineButton.setToolTipText("<html>Time Machine<br>amount: " + Buildings.timeMachineAmount + "<br>cost: " + Buildings.timeMachineCost + "<br>power: " + Buildings.timeMachinePower + "<br>Brings cookies from the past, before they were even eaten.</html>");
        }
    }

    static void updateAntimatterCondeserLabel() {
        if (GUI.totalCookies.compareTo(new BigDecimal(Buildings.antimatterCondenserCost)) >= 0) {
            GUI.totalCookies = GUI.totalCookies.add(new BigDecimal(Buildings.antimatterCondenserCost.negate()));
            updateCookies(false);
            Buildings.antimatterCondenser();
            antimatterCondenserPowerLabel.setText("AC Power = " + Buildings.antimatterCondenserPower.divide(new BigDecimal("1000000"), 3, RoundingMode.HALF_EVEN) + " Million");
            antimatterCondenserAmountLabel.setText("AC Amount = " + Buildings.antimatterCondenserAmount);
            updateLabel(antimatterCondenserCostLabel, Buildings.antimatterCondenserCost, "AC");
            antimatterCondenserButton.setToolTipText("<html>Antimatter Condenser<br>amount: " + Buildings.antimatterCondenserAmount + "<br>cost: " + Buildings.antimatterCondenserCost + "<br>power: " + Buildings.antimatterCondenserPower + "<br>Condenses the antimatter in the universe into cookies.</html>");
        }
    }

    static void updatePrismLabel() {
        if (GUI.totalCookies.compareTo(new BigDecimal(Buildings.prismCost)) >= 0) {
            GUI.totalCookies = GUI.totalCookies.add(new BigDecimal(Buildings.prismCost.negate()));
            updateCookies(false);
            Buildings.prism();
            prismPowerLabel.setText("Prism Power = " + Buildings.prismPower.divide(new BigDecimal("1000000000"), 3, RoundingMode.HALF_EVEN) + " Billion");
            prismAmountLabel.setText("Prism Amount = " + Buildings.prismAmount);
            updateLabel(prismCostLabel, Buildings.prismCost, "Prism");
            prismButton.setToolTipText("<html>Prism<br>amount: " + Buildings.prismAmount + "<br>cost: " + Buildings.prismCost + "<br>power: " + Buildings.prismPower + "<br>Converts light itself into cookies.</html>");
        }
    }

    static void updateChancemakerLabel() {
        if (GUI.totalCookies.compareTo(new BigDecimal(Buildings.chancemakerCost)) >= 0) {
            GUI.totalCookies = GUI.totalCookies.add(new BigDecimal(Buildings.chancemakerCost.negate()));
            updateCookies(false);
            Buildings.chancemaker();
            chancemakerPowerLabel.setText("CM Power = " + Buildings.chancemakerPower.divide(new BigDecimal("1000000000"), 3, RoundingMode.HALF_EVEN) + " Billion");
            chancemakerAmountLabel.setText("CM Amount = " + Buildings.chancemakerAmount);
            updateLabel(chancemakerCostLabel, Buildings.chancemakerCost, "CM");
            chancemakerButton.setToolTipText("<html>Chancemaker<br>amount: " + Buildings.chancemakerAmount + "<br>cost: " + Buildings.chancemakerCost + "<br>power: " + Buildings.chancemakerPower + "<br>Generates cookies out of thin air through sheer luck.</html>");
        }
    }

    static void updateFractalEngineLabel() {
        if (GUI.totalCookies.compareTo(new BigDecimal(Buildings.fractalEngineCost)) >= 0) {
            GUI.totalCookies = GUI.totalCookies.add(new BigDecimal(Buildings.fractalEngineCost.negate()));
            updateCookies(false);
            Buildings.fractalEngine();
            fractalEnginePowerLabel.setText("FE Power = " + Buildings.fractalEnginePower.divide(new BigDecimal("1000000000"), 3, RoundingMode.HALF_EVEN) + " Billion");
            fractalEngineAmountLabel.setText("FE Amount = " + Buildings.fractalEngineAmount);
            updateLabel(fractalEngineCostLabel, Buildings.fractalEngineCost, "FE");
            fractalEngineButton.setToolTipText("<html>Fractal Engine<br>amount: " + Buildings.fractalEngineAmount + "<br>cost: " + Buildings.fractalEngineCost + "<br>power: " + Buildings.fractalEnginePower + "<br>Turns cookies into even more cookies.</html>");
        }
    }

}
