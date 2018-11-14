package clickerGame;

//Importing different packages.
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;

/**
 * This is the class where I build the GUI for the game.
 *
 * @author Nicklas Lydersen
 * @since 1.0.1
 */
class GUI
{
    //Here I'm making my variables
    /**
     * This integer is holding the amount of Cookies the player have.
     */
    static BigDecimal totalCookies = new BigDecimal("0");
    /**
     * Boolean for the Auto Clicker Loop, so it can run when the game is running.
     */
    static boolean gameRunning;

    /**
     * This is where I make the frame, and all the other important things.
     * @since 1.0.1
     * @
     */
    GUI()
    {
        //totalCookies = totalCookies.add(new BigDecimal("999998"));
        new Clicker();
        new Buildings();
        //Clicker.playerClicks = 981911;
        makeFrame();
    }

    /**
     * This is where I load in the icons for the buttons. I'm using this as a shortcut, instead of writing this multiple times.
     * @param button Is the desired button that needs an icon.
     * @param path Is the path directory of the image, that is the desired icon for the button.
     * @since 1.0.1
     */
    private void loadImage(JButton button, String path)
    {
        try
        {
            button.setIcon(new ImageIcon(path));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(false);
    }

    /**
     * This is where I build the GUI (Frame).
     * @since 1.0.1
     */
    private void makeFrame()
    {
        gameRunning = true;

        JFrame frame = new JFrame("Clicker Game");
        frame.setUndecorated(true);
        JPanel contentPane = (JPanel)frame.getContentPane();
        contentPane.setBorder(new EmptyBorder(1, 60, 1, 60));
        contentPane.setLayout(new BorderLayout(12, 12));

        makeMenuBar(frame);

        //----- Border Panel -----
        JPanel borderPanel = new JPanel();
        borderPanel.setLayout(new FlowLayout());

        //----- Main Panel -----
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1,3));
            //----- First Panel -----
            //Bliver indsættet ind i Main Panel, på første "row"
            JPanel firstPanel = new JPanel();
            firstPanel.setBorder(new LineBorder(Color.black,1,false));
            firstPanel.setLayout(new GridLayout(2, 1));

                //----- Label Panel -----
                JPanel labelPanel = new JPanel();
                labelPanel.setLayout(new GridLayout(2,1));

                LabelUpdater.cookies = new JLabel("0 Cookies");
                Font titelFont = LabelUpdater.cookies.getFont().deriveFont(30f);
                LabelUpdater.cookies.setFont(titelFont);
                LabelUpdater.cookies.setHorizontalAlignment(JLabel.CENTER);
                LabelUpdater.cookies.setVerticalAlignment(JLabel.BOTTOM);
                labelPanel.add(LabelUpdater.cookies);

                LabelUpdater.cookiesPerSecond = new JLabel("per second: 0");
                LabelUpdater.cookiesPerSecond.setHorizontalAlignment(JLabel.CENTER);
                LabelUpdater.cookiesPerSecond.setVerticalAlignment(JLabel.TOP);
                labelPanel.add(LabelUpdater.cookiesPerSecond);

            firstPanel.add(labelPanel);

            JButton clickerButton = new JButton();
            loadImage(clickerButton,"resources/cookie.png");
            clickerButton.addActionListener(e -> LabelUpdater.updateCookies(true));
            firstPanel.add(clickerButton);

        //Tilføjer First Panel ind i Main Panel
        mainPanel.add(firstPanel);

            //----- Second Panel -----
            JPanel secondPanel = new JPanel();
            secondPanel.setBorder(new LineBorder(Color.black,1,false));
            secondPanel.setLayout(new GridLayout(1,1));

        //Tilføjer Second Panel ind i Main Panel
        mainPanel.add(secondPanel);

            //----- Third Panel -----
            JPanel thirdPanel = new JPanel();
            thirdPanel.setBorder(new LineBorder(Color.black,1,false));
            thirdPanel.setLayout(new GridLayout(16,1));

                /*//----- Click Power Panel -----
                JPanel clickPowerPanel = new JPanel();
                clickPowerPanel.setLayout(new GridLayout(1,3));

                JButton clickPowerButton = new JButton();
                loadImage(clickPowerButton, "resources/click_power_upgrade.png");
                clickPowerButton.addActionListener(e -> LabelUpdater.updateClickPowerLabel());
                clickPowerPanel.add(clickPowerButton);

                    //----- Click Power Labels Panel -----
                    JPanel clickPowerLabelsPanel = new JPanel();
                    clickPowerLabelsPanel.setLayout(new GridLayout(2,1));

                    LabelUpdater.clickPowerLabel = new JLabel("Click Power = " + Clicker.playerClicks);
                    LabelUpdater.clickPowerLabel.setHorizontalAlignment(JLabel.LEFT);
                    LabelUpdater.clickPowerLabel.setVerticalAlignment(JLabel.BOTTOM);
                    clickPowerLabelsPanel.add(LabelUpdater.clickPowerLabel);

                    LabelUpdater.clickPowerLevelLabel = new JLabel("Level = " + Clicker.clickPowerLevel + " / 100");
                    LabelUpdater.clickPowerLevelLabel.setHorizontalAlignment(JLabel.LEFT);
                    LabelUpdater.clickPowerLevelLabel.setVerticalAlignment(JLabel.TOP);
                    clickPowerLabelsPanel.add(LabelUpdater.clickPowerLevelLabel);

                    //Tilføjer Click Power Labels Panel ind i Click Power Panel
                    clickPowerPanel.add(clickPowerLabelsPanel);

                LabelUpdater.clickPowerCostLabel = new JLabel("Click Power Cost = " + Clicker.clickPowerCost);
                LabelUpdater.clickPowerCostLabel.setHorizontalAlignment(JLabel.LEFT);
                LabelUpdater.clickPowerCostLabel.setVerticalAlignment(JLabel.CENTER);
                clickPowerPanel.add(LabelUpdater.clickPowerCostLabel);

                //Tilføjer Click Power Panel ind i Third Panel
                thirdPanel.add(clickPowerPanel);*/

                //----- Cursor Panel -----
                JPanel cursorPanel = new JPanel();
                cursorPanel.setLayout(new GridLayout(1,3));

                JButton cursorButton = new JButton();
                loadImage(cursorButton,"resources/cursor.png");
                cursorButton.addActionListener(e -> LabelUpdater.updateCursorLabel());
                cursorPanel.add(cursorButton);

                    //----- Cursor Labels Panel -----
                    JPanel cursorLabelsPanel = new JPanel();
                    cursorLabelsPanel.setLayout(new GridLayout(2,1));

                    LabelUpdater.cursorPowerLabel = new JLabel("Cursor Power = " + Buildings.cursorPower);
                    LabelUpdater.cursorPowerLabel.setHorizontalAlignment(JLabel.LEFT);
                    LabelUpdater.cursorPowerLabel.setVerticalAlignment(JLabel.BOTTOM);
                    cursorLabelsPanel.add(LabelUpdater.cursorPowerLabel);

                    LabelUpdater.cursorAmountLabel = new JLabel("Cursor Amount = " + Buildings.cursorAmount);
                    LabelUpdater.cursorAmountLabel.setHorizontalAlignment(JLabel.LEFT);
                    LabelUpdater.cursorAmountLabel.setVerticalAlignment(JLabel.TOP);
                    cursorLabelsPanel.add(LabelUpdater.cursorAmountLabel);

                    //Tilføjer Cursor Labels Panel ind i Cursor Panel
                    cursorPanel.add(cursorLabelsPanel);

                LabelUpdater.cursorCostLabel = new JLabel("Cursor Cost = " + Buildings.cursorCost);
                LabelUpdater.cursorCostLabel.setHorizontalAlignment(JLabel.LEFT);
                LabelUpdater.cursorCostLabel.setVerticalAlignment(JLabel.CENTER);
                cursorPanel.add(LabelUpdater.cursorCostLabel);

                //Tilføjer Cursor Panel ind i Third Panel
                thirdPanel.add(cursorPanel);

                //----- Grandma Panel -----
                JPanel grandmaPanel = new JPanel();
                grandmaPanel.setLayout(new GridLayout(1,3));

                JButton grandmaButton = new JButton();
                loadImage(grandmaButton,"resources/grandma.png");
                grandmaButton.addActionListener(e -> LabelUpdater.updateGrandmaLabel());
                grandmaPanel.add(grandmaButton);

                    //----- Grandma Labels Panel -----
                    JPanel grandmaLabelsPanel = new JPanel();
                    grandmaLabelsPanel.setLayout(new GridLayout(2,1));

                    LabelUpdater.grandmaPowerLabel = new JLabel("Grandma Power = " + Buildings.grandmaPower);
                    LabelUpdater.grandmaPowerLabel.setHorizontalAlignment(JLabel.LEFT);
                    LabelUpdater.grandmaPowerLabel.setVerticalAlignment(JLabel.BOTTOM);
                    grandmaLabelsPanel.add(LabelUpdater.grandmaPowerLabel);

                    LabelUpdater.grandmaAmountLabel = new JLabel("Grandma Amount = " + Buildings.grandmaAmount);
                    LabelUpdater.grandmaAmountLabel.setHorizontalAlignment(JLabel.LEFT);
                    LabelUpdater.grandmaAmountLabel.setVerticalAlignment(JLabel.TOP);
                    grandmaLabelsPanel.add(LabelUpdater.grandmaAmountLabel);

                //Tilføjer Grandma Labels Panel ind i Grandma Panel
                grandmaPanel.add(grandmaLabelsPanel);

                LabelUpdater.grandmaCostLabel = new JLabel("Grandma Cost = " + Buildings.grandmaCost);
                LabelUpdater.grandmaCostLabel.setHorizontalAlignment(JLabel.LEFT);
                LabelUpdater.grandmaCostLabel.setVerticalAlignment(JLabel.CENTER);
                grandmaPanel.add(LabelUpdater.grandmaCostLabel);

                //Tilføjer Grandma Panel ind i Third Panel
                thirdPanel.add(grandmaPanel);

                    //----- Farm Panel -----
                    JPanel farmPanel = new JPanel();
                    farmPanel.setLayout(new GridLayout(1,3));

                    JButton farmButton = new JButton();
                    loadImage(farmButton,"resources/farm.png");
                    farmButton.addActionListener(e -> LabelUpdater.updateFarmLabel());
                    farmPanel.add(farmButton);

                        //----- Farm Labels Panel -----
                        JPanel farmLabelsPanel = new JPanel();
                        farmLabelsPanel.setLayout(new GridLayout(2,1));

                        LabelUpdater.farmPowerLabel = new JLabel("Farm Power = " + Buildings.farmPower);
                        LabelUpdater.farmPowerLabel.setHorizontalAlignment(JLabel.LEFT);
                        LabelUpdater.farmPowerLabel.setVerticalAlignment(JLabel.BOTTOM);
                        farmLabelsPanel.add(LabelUpdater.farmPowerLabel);

                        LabelUpdater.farmAmountLabel = new JLabel("Farm Amount = " + Buildings.farmAmount);
                        LabelUpdater.farmAmountLabel.setHorizontalAlignment(JLabel.LEFT);
                        LabelUpdater.farmAmountLabel.setVerticalAlignment(JLabel.TOP);
                        farmLabelsPanel.add(LabelUpdater.farmAmountLabel);

                    //Tilføjer Farm Labels Panel ind i Farm Panel
                    farmPanel.add(farmLabelsPanel);

                    LabelUpdater.farmCostLabel = new JLabel("Farm Cost = " + Buildings.farmCost);
                    LabelUpdater.farmCostLabel.setHorizontalAlignment(JLabel.LEFT);
                    LabelUpdater.farmCostLabel.setVerticalAlignment(JLabel.CENTER);
                    farmPanel.add(LabelUpdater.farmCostLabel);

                //Tilføjer Farm Panel ind i Third Panel
                thirdPanel.add(farmPanel);

                    //----- Mine Panel -----
                    JPanel minePanel = new JPanel();
                    minePanel.setLayout(new GridLayout(1,3));

                    JButton mineButton = new JButton();
                    loadImage(mineButton, "resources/mine.png");
                    mineButton.addActionListener(e -> LabelUpdater.updateMineLabel());
                    minePanel.add(mineButton);

                        //----- Mine Labels Panel -----
                        JPanel mineLabelsPanel = new JPanel();
                        mineLabelsPanel.setLayout(new GridLayout(2,1));

                        LabelUpdater.minePowerLabel = new JLabel("Mine Power = " + Buildings.minePower);
                        LabelUpdater.minePowerLabel.setHorizontalAlignment(JLabel.LEFT);
                        LabelUpdater.minePowerLabel.setVerticalAlignment(JLabel.BOTTOM);
                        mineLabelsPanel.add(LabelUpdater.minePowerLabel);

                        LabelUpdater.mineAmountLabel = new JLabel("Mine Amount = " + Buildings.mineAmount);
                        LabelUpdater.mineAmountLabel.setHorizontalAlignment(JLabel.LEFT);
                        LabelUpdater.mineAmountLabel.setVerticalAlignment(JLabel.TOP);
                        mineLabelsPanel.add(LabelUpdater.mineAmountLabel);

                    //Tilføjer Mine Labels Panel ind i Mine Panel
                    minePanel.add(mineLabelsPanel);

                    LabelUpdater.mineCostLabel = new JLabel("Mine Cost = " + Buildings.mineCost);
                    LabelUpdater.mineCostLabel.setHorizontalAlignment(JLabel.LEFT);
                    LabelUpdater.mineCostLabel.setVerticalAlignment(JLabel.CENTER);
                    minePanel.add(LabelUpdater.mineCostLabel);

                //Tilføjer Mine Panel ind i Third Panel
                thirdPanel.add(minePanel);

                    //----- Factory Panel -----
                    JPanel factoryPanel = new JPanel();
                    factoryPanel.setLayout(new GridLayout(1,3));

                    JButton factoryButton = new JButton();
                    loadImage(factoryButton, "resources/factory.png");
                    factoryButton.addActionListener(e -> LabelUpdater.updateFactoryLabel());
                    factoryPanel.add(factoryButton);

                        //----- Factory Labels Panel -----
                        JPanel factoryLabelsPanel = new JPanel();
                        factoryLabelsPanel.setLayout(new GridLayout(2,1));

                        LabelUpdater.factoryPowerLabel = new JLabel("Factory Power = " + Buildings.factoryPower);
                        LabelUpdater.factoryPowerLabel.setHorizontalAlignment(JLabel.LEFT);
                        LabelUpdater.factoryPowerLabel.setVerticalAlignment(JLabel.BOTTOM);
                        factoryLabelsPanel.add(LabelUpdater.factoryPowerLabel);

                        LabelUpdater.factoryAmountLabel = new JLabel("Factory Amount = " + Buildings.factoryAmount);
                        LabelUpdater.factoryAmountLabel.setHorizontalAlignment(JLabel.LEFT);
                        LabelUpdater.factoryAmountLabel.setVerticalAlignment(JLabel.TOP);
                        factoryLabelsPanel.add(LabelUpdater.factoryAmountLabel);

                    //Tilføjer Factory Labels Panel ind i Factory Panel
                    factoryPanel.add(factoryLabelsPanel);

                    LabelUpdater.factoryCostLabel = new JLabel("Factory Cost = " + Buildings.factoryCost);
                    LabelUpdater.factoryCostLabel.setHorizontalAlignment(JLabel.LEFT);
                    LabelUpdater.factoryCostLabel.setVerticalAlignment(JLabel.CENTER);
                    factoryPanel.add(LabelUpdater.factoryCostLabel);

                //Tilføjer Factory Panel ind i Third Panel
                thirdPanel.add(factoryPanel);

                    //----- Bank Panel -----
                    JPanel bankPanel = new JPanel();
                    bankPanel.setLayout(new GridLayout(1,3));

                    JButton bankButton = new JButton();
                    loadImage(bankButton, "resources/bank.png");
                    bankButton.addActionListener(e -> LabelUpdater.updateBankLabel());
                    bankPanel.add(bankButton);

                        //----- Bank Labels Panel -----
                        JPanel bankLabelsPanel = new JPanel();
                        bankLabelsPanel.setLayout(new GridLayout(2,1));

                        LabelUpdater.bankPowerLabel = new JLabel("Bank Power = " + Buildings.bankPower);
                        LabelUpdater.bankPowerLabel.setHorizontalAlignment(JLabel.LEFT);
                        LabelUpdater.bankPowerLabel.setVerticalAlignment(JLabel.BOTTOM);
                        bankLabelsPanel.add(LabelUpdater.bankPowerLabel);

                        LabelUpdater.bankAmountLabel = new JLabel("Bank Amount = " + Buildings.bankAmount);
                        LabelUpdater.bankAmountLabel.setHorizontalAlignment(JLabel.LEFT);
                        LabelUpdater.bankAmountLabel.setVerticalAlignment(JLabel.TOP);
                        bankLabelsPanel.add(LabelUpdater.bankAmountLabel);

                    //Tilføjer Bank Labels Panel ind i Bank Panel
                    bankPanel.add(bankLabelsPanel);

                    LabelUpdater.bankCostLabel = new JLabel("Bank Cost = 1.4 Million");
                    LabelUpdater.bankCostLabel.setHorizontalAlignment(JLabel.LEFT);
                    LabelUpdater.bankPowerLabel.setVerticalAlignment(JLabel.CENTER);
                    bankPanel.add(LabelUpdater.bankCostLabel);

                //Tilføjer Bank Panel ind i Third Panel
                thirdPanel.add(bankPanel);

                    //----- Temple Panel -----
                    JPanel templePanel = new JPanel();
                    templePanel.setLayout(new GridLayout(1,3));

                    JButton templeButton = new JButton();
                    loadImage(templeButton, "resources/temple.png");
                    templeButton.addActionListener(e -> LabelUpdater.updateTempleLabel());
                    templePanel.add(templeButton);

                    //----- Temple Labels Panel -----
                    JPanel templeLabelsPanel = new JPanel();
                    templeLabelsPanel.setLayout(new GridLayout(2,1));

                    LabelUpdater.templePowerLabel = new JLabel("Temple Power = " + Buildings.templePower);
                    LabelUpdater.templePowerLabel.setHorizontalAlignment(JLabel.LEFT);
                    LabelUpdater.templePowerLabel.setVerticalAlignment(JLabel.BOTTOM);
                    templeLabelsPanel.add(LabelUpdater.templePowerLabel);

                    LabelUpdater.templeAmountLabel = new JLabel("Temple Amount = " + Buildings.templeAmount);
                    LabelUpdater.templeAmountLabel.setHorizontalAlignment(JLabel.LEFT);
                    LabelUpdater.templeAmountLabel.setVerticalAlignment(JLabel.TOP);
                    templeLabelsPanel.add(LabelUpdater.templeAmountLabel);

                    //Tilføjer Temple Labels Panel ind i Temple Panel
                    templePanel.add(templeLabelsPanel);

                    LabelUpdater.templeCostLabel = new JLabel("Temple Cost = 20 million");
                    LabelUpdater.templeCostLabel.setHorizontalAlignment(JLabel.LEFT);
                    LabelUpdater.templeCostLabel.setVerticalAlignment(JLabel.CENTER);
                    templePanel.add(LabelUpdater.templeCostLabel);

                //Tilføjer Temple Panel ind i Third Panel
                thirdPanel.add(templePanel);

                    //----- Wizard Tower Panel -----
                    JPanel wizardTowerPanel = new JPanel();
                    wizardTowerPanel.setLayout(new GridLayout(1,3));

                    JButton wizardTowerButton = new JButton();
                    loadImage(wizardTowerButton, "resources/wizardTower.png");
                    wizardTowerButton.addActionListener(e -> LabelUpdater.updateWizardTowerLabel());
                    wizardTowerPanel.add(wizardTowerButton);

                        //----- Wizard Tower Labels Panel -----
                        JPanel wizardTowerLabelsPanel = new JPanel();
                        wizardTowerLabelsPanel.setLayout(new GridLayout(2,1));

                        LabelUpdater.wizardTowerPowerLabel = new JLabel("WT Power = " + Buildings.wizardTowerPower);
                        LabelUpdater.wizardTowerPowerLabel.setHorizontalAlignment(JLabel.LEFT);
                        LabelUpdater.wizardTowerPowerLabel.setVerticalAlignment(JLabel.BOTTOM);
                        wizardTowerLabelsPanel.add(LabelUpdater.wizardTowerPowerLabel);

                        LabelUpdater.wizardTowerAmountLabel = new JLabel("WT Amount = " + Buildings.wizardTowerAmount);
                        LabelUpdater.wizardTowerAmountLabel.setHorizontalAlignment(JLabel.LEFT);
                        LabelUpdater.wizardTowerAmountLabel.setVerticalAlignment(JLabel.TOP);
                        wizardTowerLabelsPanel.add(LabelUpdater.wizardTowerAmountLabel);

                    //Tiløjer Wizard Tower Labels Panel ind i Wizard Tower Panel
                    wizardTowerPanel.add(wizardTowerLabelsPanel);

                    LabelUpdater.wizardTowerCostLabel = new JLabel("WT Cost = 330 Million");
                    LabelUpdater.wizardTowerCostLabel.setHorizontalAlignment(JLabel.LEFT);
                    LabelUpdater.wizardTowerCostLabel.setVerticalAlignment(JLabel.CENTER);
                    wizardTowerPanel.add(LabelUpdater.wizardTowerCostLabel);

                //Tilføjer Wizard Tower Panel ind i Third Panel
                thirdPanel.add(wizardTowerPanel);

                    //----- Shipment Panel -----
                    JPanel shipmentPanel = new JPanel();
                    shipmentPanel.setLayout(new GridLayout(1,3));

                    JButton shipmentButton = new JButton();
                    loadImage(shipmentButton, "resources/shipment.png");
                    shipmentButton.addActionListener(e -> LabelUpdater.updateShipmentLabel());
                    shipmentPanel.add(shipmentButton);

                        //----- Shipment Labels Panel -----
                        JPanel shipmentLabelsPanel = new JPanel();
                        shipmentLabelsPanel.setLayout(new GridLayout(2,1));

                        LabelUpdater.shipmentPowerLabel = new JLabel("Shipment Power = " + Buildings.shipmentPower);
                        LabelUpdater.shipmentPowerLabel.setHorizontalAlignment(JLabel.LEFT);
                        LabelUpdater.shipmentPowerLabel.setVerticalAlignment(JLabel.BOTTOM);
                        shipmentLabelsPanel.add(LabelUpdater.shipmentPowerLabel);

                        LabelUpdater.shipmentAmountLabel = new JLabel("Shipment Amount = " + Buildings.shipmentAmount);
                        LabelUpdater.shipmentAmountLabel.setHorizontalAlignment(JLabel.LEFT);
                        LabelUpdater.shipmentAmountLabel.setVerticalAlignment(JLabel.TOP);
                        shipmentLabelsPanel.add(LabelUpdater.shipmentAmountLabel);

                    //Tilføjer Shipment Labels Panel ind i Shipment Panel
                    shipmentPanel.add(shipmentLabelsPanel);

                    LabelUpdater.shipmentCostLabel = new JLabel("Shipment Cost = 5.1 Billion");
                    LabelUpdater.shipmentCostLabel.setHorizontalAlignment(JLabel.LEFT);
                    LabelUpdater.shipmentCostLabel.setVerticalAlignment(JLabel.CENTER);
                    shipmentPanel.add(LabelUpdater.shipmentCostLabel);

                //Tilføjer Shipment Panel ind i Third Panel
                thirdPanel.add(shipmentPanel);

                    //----- Alchemy Lab Panel -----
                    JPanel alchemyLabPanel = new JPanel();
                    alchemyLabPanel.setLayout(new GridLayout(1,3));

                    JButton alchemyLabButton = new JButton();
                    loadImage(alchemyLabButton, "resources/alchemyLab.png");
                    alchemyLabButton.addActionListener(e -> LabelUpdater.updateAlchemyLabLabel());
                    alchemyLabPanel.add(alchemyLabButton);

                        //----- Alchemy Lab Labels Panel -----
                        JPanel alchemyLabLabelsPanel = new JPanel();
                        alchemyLabLabelsPanel.setLayout(new GridLayout(2,1));

                        LabelUpdater.alchemyLabPowerLabel = new JLabel("AL Power = 1.6 Million");
                        LabelUpdater.alchemyLabPowerLabel.setHorizontalAlignment(JLabel.LEFT);
                        LabelUpdater.alchemyLabPowerLabel.setVerticalAlignment(JLabel.BOTTOM);
                        alchemyLabLabelsPanel.add(LabelUpdater.alchemyLabPowerLabel);

                        LabelUpdater.alchemyLabAmountLabel = new JLabel("AL Amount = " + Buildings.alchemyLabAmount);
                        LabelUpdater.alchemyLabAmountLabel.setHorizontalAlignment(JLabel.LEFT);
                        LabelUpdater.alchemyLabAmountLabel.setVerticalAlignment(JLabel.TOP);
                        alchemyLabLabelsPanel.add(LabelUpdater.alchemyLabAmountLabel);

                    //Tilføjer Alchemy Lab Labels Panel ind i Alchemy Lab Panel
                    alchemyLabPanel.add(alchemyLabLabelsPanel);

                    LabelUpdater.alchemyLabCostLabel = new JLabel("AL Cost = 75 Billion");
                    LabelUpdater.alchemyLabCostLabel.setHorizontalAlignment(JLabel.LEFT);
                    LabelUpdater.alchemyLabCostLabel.setVerticalAlignment(JLabel.CENTER);
                    alchemyLabPanel.add(LabelUpdater.alchemyLabCostLabel);

                //Tilføjer Alchemy Lab Panel ind i Third Panel
                thirdPanel.add(alchemyLabPanel);

                    //----- Portal Panel -----
                    JPanel portalPanel = new JPanel();
                    portalPanel.setLayout(new GridLayout(1,3));

                    JButton portalButton = new JButton();
                    loadImage(portalButton, "resources/portal.png");
                    portalButton.addActionListener(e -> LabelUpdater.updatePortalLabel());
                    portalPanel.add(portalButton);

                        //----- Portal Labels Panel -----
                        JPanel portalLabelsPanel = new JPanel();
                        portalLabelsPanel.setLayout(new GridLayout(2,1));

                        LabelUpdater.portalPowerLabel = new JLabel("Portal Power = 10 Million");
                        LabelUpdater.portalPowerLabel.setHorizontalAlignment(JLabel.LEFT);
                        LabelUpdater.portalPowerLabel.setVerticalAlignment(JLabel.BOTTOM);
                        portalLabelsPanel.add(LabelUpdater.portalPowerLabel);

                        LabelUpdater.portalAmountLabel = new JLabel("Portal Amount = " + Buildings.portalAmount);
                        LabelUpdater.portalAmountLabel.setHorizontalAlignment(JLabel.LEFT);
                        LabelUpdater.portalAmountLabel.setVerticalAlignment(JLabel.TOP);
                        portalLabelsPanel.add(LabelUpdater.portalAmountLabel);

                    //Tilføjer Portal Labels Panel ind i Portal Panel
                    portalPanel.add(portalLabelsPanel);

                    LabelUpdater.portalCostLabel = new JLabel("Portal Cost = 1 Trillion");
                    LabelUpdater.portalCostLabel.setHorizontalAlignment(JLabel.LEFT);
                    LabelUpdater.portalCostLabel.setVerticalAlignment(JLabel.CENTER);
                    portalPanel.add(LabelUpdater.portalCostLabel);

                //Tilføjer Portal Panel ind i Third Panel
                thirdPanel.add(portalPanel);

                    //----- Time Machine Panel -----
                    JPanel timeMachinePanel = new JPanel();
                    timeMachinePanel.setLayout(new GridLayout(1,3));

                    JButton timeMachineButton = new JButton();
                    loadImage(timeMachineButton, "resources/timeMachine.png");
                    timeMachineButton.addActionListener(e -> LabelUpdater.updateTimeMachineLabel());
                    timeMachinePanel.add(timeMachineButton);

                        //----- Time Machine Labels Panel -----
                        JPanel timeMachineLabelsPanel = new JPanel();
                        timeMachineLabelsPanel.setLayout(new GridLayout(2,1));

                        LabelUpdater.timeMachinePowerLabel = new JLabel("TM Power = 65 Million");
                        LabelUpdater.timeMachinePowerLabel.setHorizontalAlignment(JLabel.LEFT);
                        LabelUpdater.timeMachinePowerLabel.setVerticalAlignment(JLabel.BOTTOM);
                        timeMachineLabelsPanel.add(LabelUpdater.timeMachinePowerLabel);

                        LabelUpdater.timeMachineAmountLabel = new JLabel("TM Amount = " + Buildings.timeMachineAmount);
                        LabelUpdater.timeMachineAmountLabel.setHorizontalAlignment(JLabel.LEFT);
                        LabelUpdater.timeMachineAmountLabel.setVerticalAlignment(JLabel.TOP);
                        timeMachineLabelsPanel.add(LabelUpdater.timeMachineAmountLabel);

                    //Tilføjer Time Machine Labels Panel ind i Time Machine Panel
                    timeMachinePanel.add(timeMachineLabelsPanel);

                    LabelUpdater.timeMachineCostLabel = new JLabel("TM Cost = 14 Trillion");
                    LabelUpdater.timeMachineCostLabel.setHorizontalAlignment(JLabel.LEFT);
                    LabelUpdater.timeMachineCostLabel.setVerticalAlignment(JLabel.CENTER);
                    timeMachinePanel.add(LabelUpdater.timeMachineCostLabel);

                //Tilføjer Time Machine Panel ind i Third Panel
                thirdPanel.add(timeMachinePanel);

                    //----- Antimatter Condenser Panel -----
                    JPanel antimatterCondenserPanel = new JPanel();
                    antimatterCondenserPanel.setLayout(new GridLayout(1,3));

                    JButton antimatterCondenserButton = new JButton();
                    loadImage(antimatterCondenserButton, "resources/antimatterCondenser.png");
                    antimatterCondenserButton.addActionListener(e -> LabelUpdater.updateAntimatterCondeserLabel());
                    antimatterCondenserPanel.add(antimatterCondenserButton);

                        //----- Antimatter Condenser Labels Panel -----
                        JPanel antimatterCondenserLabelsPanel = new JPanel();
                        antimatterCondenserLabelsPanel.setLayout(new GridLayout(2,1));

                        LabelUpdater.antimatterCondenserPowerLabel = new JLabel("AC Power = 430 Million");
                        LabelUpdater.antimatterCondenserPowerLabel.setHorizontalAlignment(JLabel.LEFT);
                        LabelUpdater.antimatterCondenserPowerLabel.setVerticalAlignment(JLabel.BOTTOM);
                        antimatterCondenserLabelsPanel.add(LabelUpdater.antimatterCondenserPowerLabel);

                        LabelUpdater.antimatterCondenserAmountLabel = new JLabel("AC Amount = " + Buildings.antimatterCondenserAmount);
                        LabelUpdater.antimatterCondenserAmountLabel.setHorizontalAlignment(JLabel.LEFT);
                        LabelUpdater.antimatterCondenserAmountLabel.setVerticalAlignment(JLabel.TOP);
                        antimatterCondenserLabelsPanel.add(LabelUpdater.antimatterCondenserAmountLabel);

                    //Tilføjer Antimatter Condenser Labels Panel ind i Antimatter Condenser Panel
                    antimatterCondenserPanel.add(antimatterCondenserLabelsPanel);

                    LabelUpdater.antimatterCondenserCostLabel = new JLabel("AC Cost = 170 Trillion");
                    LabelUpdater.antimatterCondenserCostLabel.setHorizontalAlignment(JLabel.LEFT);
                    LabelUpdater.antimatterCondenserCostLabel.setVerticalAlignment(JLabel.CENTER);
                    antimatterCondenserPanel.add(LabelUpdater.antimatterCondenserCostLabel);

                //Tilføjer Shipment Panel ind i Third Panel
                thirdPanel.add(antimatterCondenserPanel);

                    //----- Prism Panel -----
                    JPanel prismPanel = new JPanel();
                    prismPanel.setLayout(new GridLayout(1,3));

                    JButton prismButton = new JButton();
                    loadImage(prismButton, "resources/prism.png");
                    prismButton.addActionListener(e -> LabelUpdater.updatePrismLabel());
                    prismPanel.add(prismButton);

                        //----- Prism Labels Panel -----
                        JPanel prismLabelsPanel = new JPanel();
                        prismLabelsPanel.setLayout(new GridLayout(2,1));

                        LabelUpdater.prismPowerLabel = new JLabel("Prism Power = 2.9 Billion");
                        LabelUpdater.prismPowerLabel.setHorizontalAlignment(JLabel.LEFT);
                        LabelUpdater.prismPowerLabel.setVerticalAlignment(JLabel.BOTTOM);
                        prismLabelsPanel.add(LabelUpdater.prismPowerLabel);

                        LabelUpdater.prismAmountLabel = new JLabel("Prism Amount = " + Buildings.prismAmount);
                        LabelUpdater.prismAmountLabel.setHorizontalAlignment(JLabel.LEFT);
                        LabelUpdater.prismAmountLabel.setVerticalAlignment(JLabel.TOP);
                        prismLabelsPanel.add(LabelUpdater.prismAmountLabel);

                    //Tilføjer Prism Labels Panel ind i Prism Panel
                    prismPanel.add(prismLabelsPanel);

                    LabelUpdater.prismCostLabeL = new JLabel("Prism Cost = 2.1 Quadrillion");
                    LabelUpdater.prismCostLabeL.setHorizontalAlignment(JLabel.LEFT);
                    LabelUpdater.prismCostLabeL.setVerticalAlignment(JLabel.CENTER);
                    prismPanel.add(LabelUpdater.prismCostLabeL);

                //Tilføjer Prism Panel ind i Third Panel
                thirdPanel.add(prismPanel);

                    //----- Chancemaker Panel -----
                    JPanel chancemakerPanel = new JPanel();
                    chancemakerPanel.setLayout(new GridLayout(1,3));

                    JButton chancemakerButton = new JButton();
                    loadImage(chancemakerButton, "resources/chancemaker.png");
                    chancemakerButton.addActionListener(e -> LabelUpdater.updateChancemakerLabel());
                    chancemakerPanel.add(chancemakerButton);

                        //----- Chancemaker Labels Panel -----
                        JPanel chancemakerLabelsPanel = new JPanel();
                        chancemakerLabelsPanel.setLayout(new GridLayout(2,1));

                        LabelUpdater.chancemakerPowerLabel = new JLabel("CM Power = 21 Billion");
                        LabelUpdater.chancemakerPowerLabel.setHorizontalAlignment(JLabel.LEFT);
                        LabelUpdater.chancemakerPowerLabel.setVerticalAlignment(JLabel.BOTTOM);
                        chancemakerLabelsPanel.add(LabelUpdater.chancemakerPowerLabel);

                        LabelUpdater.chancemakerAmountLabel = new JLabel("CM Amount = " + Buildings.chancemakerAmount);
                        LabelUpdater.chancemakerAmountLabel.setHorizontalAlignment(JLabel.LEFT);
                        LabelUpdater.chancemakerAmountLabel.setVerticalAlignment(JLabel.TOP);
                        chancemakerLabelsPanel.add(LabelUpdater.chancemakerAmountLabel);

                    //Tilføjer Chancemaker Labels Panel ind i Chancemaker Panel
                    chancemakerPanel.add(chancemakerLabelsPanel);

                    LabelUpdater.chancemakeCostLabel = new JLabel("CM Cost = 26 Quadrillion");
                    LabelUpdater.chancemakeCostLabel.setHorizontalAlignment(JLabel.LEFT);
                    LabelUpdater.chancemakeCostLabel.setVerticalAlignment(JLabel.CENTER);
                    chancemakerPanel.add(LabelUpdater.chancemakeCostLabel);

                //Tilføjer Chancemaker Panel ind i Third Panel
                thirdPanel.add(chancemakerPanel);

                    //----- Fractal Engine Panel -----
                    JPanel fractalEnginePanel = new JPanel();
                    fractalEnginePanel.setLayout(new GridLayout(1,3));

                    JButton fractalEngineButton = new JButton();
                    loadImage(fractalEngineButton, "resources/fractalEngine.png");
                    fractalEngineButton.addActionListener(e -> LabelUpdater.updateFractalEngineLabel());
                    fractalEnginePanel.add(fractalEngineButton);

                        //----- Fractal Engine Labels Panel -----
                        JPanel fractalEngineLabelsPanel = new JPanel();
                        fractalEngineLabelsPanel.setLayout(new GridLayout(2,1));

                        LabelUpdater.fractalEnginePowerLabel = new JLabel("FE Power = 150 Billion");
                        LabelUpdater.fractalEnginePowerLabel.setHorizontalAlignment(JLabel.LEFT);
                        LabelUpdater.fractalEnginePowerLabel.setVerticalAlignment(JLabel.BOTTOM);
                        fractalEngineLabelsPanel.add(LabelUpdater.fractalEnginePowerLabel);

                        LabelUpdater.fractalEngineAmountLabel = new JLabel("FE Amount = " + Buildings.fractalEngineAmount);
                        LabelUpdater.fractalEngineAmountLabel.setHorizontalAlignment(JLabel.LEFT);
                        LabelUpdater.fractalEngineAmountLabel.setVerticalAlignment(JLabel.TOP);
                        fractalEngineLabelsPanel.add(LabelUpdater.fractalEngineAmountLabel);

                    //Tilføjer Fractal Engine Labels Panel ind i Fractal Engine Panel
                    fractalEnginePanel.add(fractalEngineLabelsPanel);

                    LabelUpdater.fractalEngineCostLabel = new JLabel("FE Cost = 310 Quadrillion");
                    LabelUpdater.fractalEngineCostLabel.setHorizontalAlignment(JLabel.LEFT);
                    LabelUpdater.fractalEngineCostLabel.setVerticalAlignment(JLabel.CENTER);
                    fractalEnginePanel.add(LabelUpdater.fractalEngineCostLabel);

                //Tilføjer Shipment Panel ind i Third Panel
                thirdPanel.add(fractalEnginePanel);

            //Tilføjer Third Panel ind i Main Panel
            mainPanel.add(thirdPanel);

        //tilføjer Main Panel ind i Border Panel
        borderPanel.add(mainPanel);

        contentPane.add(mainPanel, BorderLayout.CENTER);

        frame.pack();

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);

        Buildings.cookiesPerSecondLoop();
    }

    /**
     * Quit function: quit the application.
     * @since 1.0.1
     */
    private void quit()
    {
        System.exit(0);
    }

    /**
     * Here we make a menu bar, that uses the quit function we made earlier to quit the program.
     * @param frame is used to tell the menu bar when it's called, which frame it's should be on.
     * @since 1.0.1
     */
    private void makeMenuBar(JFrame frame)
    {
        final int SHORTCUT_MASK = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu file;
        JMenuItem quit;

        file = new JMenu("File");
        menuBar.add(file);

        quit = new JMenuItem("Quit");
        quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, SHORTCUT_MASK));
        quit.addActionListener(e -> quit());
        file.add(quit);
    }


}
