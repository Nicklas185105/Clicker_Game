package clickerGame;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * This class is responsible for creating the buildings and upgrading them, while keeping track of the total per second.
 *
 * <p>Cursor Building: {@link #cursor()}</p>
 * <p>Grandma Building {@link #grandma()}</p>
 * <p>Farm Building {@link #farm()}</p>
 *
 * @author Nicklas Lydersen
 * @since 1.0.2
 */
class Buildings {

    /**
     * This integer is holding the amount of auto clicks the player has.
     */
    private static BigDecimal totalCookiesPerSecond;
    private static BigDecimal buildingCostMultiplier;

    //----- Cursor -----
    /**
     * This defines the Cursor Power.
     */
    static BigDecimal cursorPower;
    /**
     * This defines the amount the player has of Cursor.
     */
    static int cursorAmount;
    /**
     * This defines the cost of the Cursor.
     */
    static BigInteger cursorCost;

    //----- Grandma -----
    static BigDecimal grandmaPower;
    static int grandmaAmount;
    static BigInteger grandmaCost;

    //----- Farm -----
    static BigDecimal farmPower;
    static int farmAmount;
    static BigInteger farmCost;

    //----- Mine -----
    static BigDecimal minePower;
    static int mineAmount;
    static BigInteger mineCost;

    //----- Factory -----
    static BigDecimal factoryPower;
    static int factoryAmount;
    static BigInteger factoryCost;

    //----- Bank -----
    static BigDecimal bankPower;
    static int bankAmount;
    static BigInteger bankCost;

    //----- Temple -----
    static BigDecimal templePower;
    static int templeAmount;
    static BigInteger templeCost;

    //----- Wizard Tower -----
    static BigDecimal wizardTowerPower;
    static int wizardTowerAmount;
    static BigInteger wizardTowerCost;

    //----- Shipment -----
    static BigDecimal shipmentPower;
    static int shipmentAmount;
    static BigInteger shipmentCost;

    //----- Alchemy Lab -----
    static BigDecimal alchemyLabPower;
    static int alchemyLabAmount;
    static BigInteger alchemyLabCost;

    //----- Portal -----
    static BigDecimal portalPower;
    static int portalAmount;
    static BigInteger portalCost;

    //----- Time Machine -----
    static BigDecimal timeMachinePower;
    static int timeMachineAmount;
    static BigInteger timeMachineCost;

    //----- Antimatter Condenser -----
    static BigDecimal antimatterCondenserPower;
    static int antimatterCondenserAmount;
    static BigInteger antimatterCondenserCost;

    //----- Prism -----
    static BigDecimal prismPower;
    static int prismAmount;
    static BigInteger prismCost;

    //----- Chancemaker -----
    static BigDecimal chancemakerPower;
    static int chancemakerAmount;
    static BigInteger chancemakerCost;

    //----- Fractal Engine -----
    static BigDecimal fractalEnginePower;
    static int fractalEngineAmount;
    static BigInteger fractalEngineCost;

    /**
     * Setting all the varibales to their start values.
     *
     * @since 1.0.2
     */
    Buildings() {
        totalCookiesPerSecond = new BigDecimal("0");
        buildingCostMultiplier = new BigDecimal("1.15");

        //----- Cursor -----
        cursorPower = new BigDecimal("0.1");
        cursorAmount = 0;
        cursorCost = new BigInteger("15");

        //----- Grandma -----
        grandmaPower = new BigDecimal("1");
        grandmaAmount = 0;
        grandmaCost = new BigInteger("100");

        //----- Farm -----
        farmPower = new BigDecimal("8");
        farmAmount = 0;
        farmCost = new BigInteger("1100");

        //----- Mine -----
        minePower = new BigDecimal("47");
        mineAmount = 0;
        mineCost = new BigInteger("12000");

        //----- Factory -----
        factoryPower = new BigDecimal("260");
        factoryAmount = 0;
        factoryCost = new BigInteger("130000");

        //----- Bank -----
        bankPower = new BigDecimal("1400");
        bankAmount = 0;
        bankCost = new BigInteger("1400000");

        //----- Temple -----
        templePower = new BigDecimal("7800");
        templeAmount = 0;
        templeCost = new BigInteger("20000000");

        //----- Wizard Tower -----
        wizardTowerPower = new BigDecimal("44000");
        wizardTowerAmount = 0;
        wizardTowerCost = new BigInteger("330000000");

        //----- Shipment -----
        shipmentPower = new BigDecimal("260000");
        shipmentAmount = 0;
        shipmentCost = new BigInteger("5100000000");

        //----- Alchemy Lab -----
        alchemyLabPower = new BigDecimal("1600000");
        alchemyLabAmount = 0;
        alchemyLabCost = new BigInteger("75000000000");

        //----- Portal -----
        portalPower = new BigDecimal("10000000");
        portalAmount = 0;
        portalCost = new BigInteger("1000000000000");

        //----- Time Machine -----
        timeMachinePower = new BigDecimal("65000000");
        timeMachineAmount = 0;
        timeMachineCost = new BigInteger("14000000000000");

        //----- Antimatter Condenser -----
        antimatterCondenserPower = new BigDecimal("430000000");
        antimatterCondenserAmount = 0;
        antimatterCondenserCost = new BigInteger("170000000000000");

        //----- Prism -----
        prismPower = new BigDecimal("2900000000");
        prismAmount = 0;
        prismCost = new BigInteger("2100000000000000");

        //----- Chancemaker -----
        chancemakerPower = new BigDecimal("21000000000");
        chancemakerAmount = 0;
        chancemakerCost = new BigInteger("26000000000000000");

        //----- Fractal Engine -----
        fractalEnginePower = new BigDecimal("150000000000");
        fractalEngineAmount = 0;
        fractalEngineCost = new BigInteger("310000000000000000");

    }

    /**
     * This is used for when I need the program to sleep different places.
     */
    private static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * This is where the loop for the auto clickers are running all the auto clickers.
     *
     * @since 1.0.1
     */
    static void cookiesPerSecondLoop() {
        while (GUI.gameRunning) {
            sleep();
            GUI.totalCookies = GUI.totalCookies.add(totalCookiesPerSecond);
            LabelUpdater.updateCookies(false);
        }
    }

    /**
     * This is were we update the {@link #totalCookiesPerSecond}.
     *
     * <p>Using these towers:</p>
     * <p>  - {@link #cursor()}</p>
     * <p>  - {@link }</p>
     *
     * @since 1.0.2
     */
    private static void setTotalCookiesPerSecond() {
        //----- Cursor -----
        totalCookiesPerSecond = new BigDecimal(cursorAmount).multiply(cursorPower);
        System.out.println(totalCookiesPerSecond);

        //----- Grandma -----
        totalCookiesPerSecond = totalCookiesPerSecond.add(new BigDecimal(grandmaAmount).multiply(grandmaPower));

        //----- Farm -----
        totalCookiesPerSecond = totalCookiesPerSecond.add(new BigDecimal(farmAmount).multiply(farmPower));

        //----- Mine -----
        totalCookiesPerSecond = totalCookiesPerSecond.add(new BigDecimal(mineAmount).multiply(minePower));

        //----- Factory -----
        totalCookiesPerSecond = totalCookiesPerSecond.add(new BigDecimal(factoryAmount).multiply(factoryPower));

        //----- Bank -----
        totalCookiesPerSecond = totalCookiesPerSecond.add(new BigDecimal(bankAmount).multiply(bankPower));

        //----- Temple -----
        totalCookiesPerSecond = totalCookiesPerSecond.add(new BigDecimal(templeAmount).multiply(templePower));

        //----- Wizard Tower -----
        totalCookiesPerSecond = totalCookiesPerSecond.add(new BigDecimal(wizardTowerAmount).multiply(wizardTowerPower));

        //----- Shipment -----
        totalCookiesPerSecond = totalCookiesPerSecond.add(new BigDecimal(shipmentAmount).multiply(shipmentPower));

        //----- Alchemy Lab -----
        totalCookiesPerSecond = totalCookiesPerSecond.add(new BigDecimal(alchemyLabAmount).multiply(alchemyLabPower));

        //----- Portal -----
        totalCookiesPerSecond = totalCookiesPerSecond.add(new BigDecimal(portalAmount).multiply(portalPower));

        //----- Time Machine -----
        totalCookiesPerSecond = totalCookiesPerSecond.add(new BigDecimal(timeMachineAmount).multiply(timeMachinePower));

        //----- Antimatter Condenser -----
        totalCookiesPerSecond = totalCookiesPerSecond.add(new BigDecimal(antimatterCondenserAmount).multiply(antimatterCondenserPower));

        //----- Prism -----
        totalCookiesPerSecond = totalCookiesPerSecond.add(new BigDecimal(prismAmount).multiply(prismPower));

        //----- Chancemaker -----
        totalCookiesPerSecond = totalCookiesPerSecond.add(new BigDecimal(chancemakerAmount).multiply(chancemakerPower));

        //----- Fractal Engine -----
        totalCookiesPerSecond = totalCookiesPerSecond.add(new BigDecimal(fractalEngineAmount).multiply(fractalEnginePower));


        //----- Update cookiesPerSecond Label -----
        LabelUpdater.cookiesPerSecond.setText("per second: " + totalCookiesPerSecond);
    }

    /**
     * This is were we change the variables of the Cursor building.
     *
     * @since 1.0.2
     */
    static void cursor() {
        cursorAmount++;
        cursorCost = new BigDecimal(cursorCost).multiply(buildingCostMultiplier).setScale(0, RoundingMode.HALF_EVEN).toBigInteger();
        setTotalCookiesPerSecond();
    }

    /**
     * This is were we change the variables of the Grandma building.
     *
     * @since 1.0.2
     */
    static void grandma() {
        grandmaAmount++;
        grandmaCost = new BigDecimal(grandmaCost).multiply(buildingCostMultiplier).setScale(0, RoundingMode.HALF_EVEN).toBigInteger();
        setTotalCookiesPerSecond();
    }

    /**
     * This is were we change the variables of the Farm building.
     *
     * @since 1.0.2
     */
    static void farm() {
        farmAmount++;
        farmCost = new BigDecimal(farmCost).multiply(buildingCostMultiplier).setScale(0, RoundingMode.HALF_EVEN).toBigInteger();
        setTotalCookiesPerSecond();
    }

    static void mine() {
        mineAmount++;
        mineCost = new BigDecimal(mineCost).multiply(buildingCostMultiplier).setScale(0, RoundingMode.HALF_EVEN).toBigInteger();
        setTotalCookiesPerSecond();
    }

    static void factory() {
        factoryAmount++;
        factoryCost = new BigDecimal(factoryCost).multiply(buildingCostMultiplier).setScale(0, RoundingMode.HALF_EVEN).toBigInteger();
        setTotalCookiesPerSecond();
    }

    static void bank() {
        bankAmount++;
        bankCost = new BigDecimal(bankCost).multiply(buildingCostMultiplier).setScale(0, RoundingMode.HALF_EVEN).toBigInteger();
        setTotalCookiesPerSecond();
    }

    static void temple() {
        templeAmount++;
        templeCost = new BigDecimal(templeCost).multiply(buildingCostMultiplier).setScale(0, RoundingMode.HALF_EVEN).toBigInteger();
        setTotalCookiesPerSecond();
    }

    static void wizardTower() {
        wizardTowerAmount++;
        wizardTowerCost = new BigDecimal(wizardTowerCost).multiply(buildingCostMultiplier).setScale(0, RoundingMode.HALF_EVEN).toBigInteger();
        setTotalCookiesPerSecond();
    }

    static void shipment() {
        shipmentAmount++;
        shipmentCost = new BigDecimal(shipmentCost).multiply(buildingCostMultiplier).setScale(0, RoundingMode.HALF_EVEN).toBigInteger();
        setTotalCookiesPerSecond();
    }

    static void alchemyLab() {
        alchemyLabAmount++;
        alchemyLabCost = new BigDecimal(alchemyLabCost).multiply(buildingCostMultiplier).setScale(0, RoundingMode.HALF_EVEN).toBigInteger();
        setTotalCookiesPerSecond();
    }

    static void portal() {
        portalAmount++;
        portalCost = new BigDecimal(portalCost).multiply(buildingCostMultiplier).setScale(0, RoundingMode.HALF_EVEN).toBigInteger();
        setTotalCookiesPerSecond();
    }

    static void timeMachine() {
        timeMachineAmount++;
        timeMachineCost = new BigDecimal(timeMachineCost).multiply(buildingCostMultiplier).setScale(0, RoundingMode.HALF_EVEN).toBigInteger();
        setTotalCookiesPerSecond();
    }

    static void antimatterCondenser() {
        antimatterCondenserAmount++;
        antimatterCondenserCost = new BigDecimal(antimatterCondenserCost).multiply(buildingCostMultiplier).setScale(0, RoundingMode.HALF_EVEN).toBigInteger();
        setTotalCookiesPerSecond();
    }

    static void prism() {
        prismAmount++;
        prismCost = new BigDecimal(prismCost).multiply(buildingCostMultiplier).setScale(0, RoundingMode.HALF_EVEN).toBigInteger();
        setTotalCookiesPerSecond();
    }

    static void chancemaker() {
        chancemakerAmount++;
        chancemakerCost = new BigDecimal(chancemakerCost).multiply(buildingCostMultiplier).setScale(0, RoundingMode.HALF_EVEN).toBigInteger();
        setTotalCookiesPerSecond();
    }

    static void fractalEngine() {
        fractalEngineAmount++;
        fractalEngineCost = new BigDecimal(fractalEngineCost).multiply(buildingCostMultiplier).setScale(0, RoundingMode.HALF_EVEN).toBigInteger();
        setTotalCookiesPerSecond();
    }

}
