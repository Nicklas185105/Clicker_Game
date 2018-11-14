package clickerGame;

//Importing different packages.

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;

/**
 * This is the class where I build the GUI for the game.
 *
 * @author Nicklas Lydersen
 * @since 1.0.1
 */
class GUI {
    static BigDecimal totalCookies = new BigDecimal("0");
    static boolean gameRunning;

    /**
     * This is where I make the frame, and all the other important things.
     *
     * @since 1.0.1
     */
    GUI() {
        //totalCookies = totalCookies.add(new BigDecimal("999998"));
        new Upgrades();
        new Buildings();
        makeFrame();
    }

    /**
     * This is where I load in the icons for the buttons. I'm using this as a shortcut, instead of writing this multiple times.
     *
     * @param button Is the desired button that needs an icon.
     * @param path   Is the path directory of the image, that is the desired icon for the button.
     * @since 1.0.1
     */
    private void loadImage(JButton button, String path) {
        try {
            button.setIcon(new ImageIcon(path));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(false);
    }

    /**
     * This is where I build the GUI (Frame).
     *
     * @since 1.0.1
     */
    private void makeFrame() {
        UIManager.put("ToolTip.font", new FontUIResource("SansSerif", Font.BOLD, 20));
        UIManager.put("ToolTip.background", new ColorUIResource(255, 142, 50));
        Border border = BorderFactory.createLineBorder(new Color(0,0,0));
        UIManager.put("ToolTip.border", border);
        ToolTipManager.sharedInstance().setDismissDelay(604800000);

        gameRunning = true;

        JFrame frame = new JFrame("Upgrades Game");
        frame.setUndecorated(true);
        JPanel contentPane = (JPanel) frame.getContentPane();
        contentPane.setBorder(new EmptyBorder(1, 60, 1, 60));
        contentPane.setLayout(new BorderLayout(12, 12));

        makeMenuBar(frame);

        //----- Border Panel -----
        JPanel borderPanel = new JPanel();
        borderPanel.setLayout(new FlowLayout());

        //----- Main Panel -----
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1, 3));
        //----- First Panel -----
        JPanel firstPanel = new JPanel();
        firstPanel.setBorder(new LineBorder(Color.black, 1, false));
        firstPanel.setLayout(new GridLayout(2, 1));

        //----- Label Panel -----
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(2, 1));

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
        loadImage(clickerButton, "resources/cookie.png");
        clickerButton.addActionListener(e -> LabelUpdater.updateCookies(true));
        firstPanel.add(clickerButton);

        //Tilføjer First Panel ind i Main Panel
        mainPanel.add(firstPanel);

        //----- Second Panel -----
        JPanel secondPanel = new JPanel();
        secondPanel.setBorder(new LineBorder(Color.black, 1, false));
        secondPanel.setLayout(new GridLayout(1, 1));

        //Tilføjer Second Panel ind i Main Panel
        mainPanel.add(secondPanel);

        //----- Third Panel -----
        JPanel thirdPanel = new JPanel();
        thirdPanel.setBorder(new LineBorder(Color.black, 1, false));
        thirdPanel.setLayout(new GridLayout(16, 1));

        //----- Cursor Panel -----
        JPanel cursorPanel = new JPanel();
        cursorPanel.setLayout(new GridLayout(1, 3));

        LabelUpdater.cursorButton = new JButton();
        loadImage(LabelUpdater.cursorButton, "resources/cursor.png");
        LabelUpdater.cursorButton.addActionListener(e -> LabelUpdater.updateCursorLabel());
        LabelUpdater.cursorButton.setToolTipText("<html>Cursor<br>amount: " + Buildings.cursorAmount + "<br>cost: " + Buildings.cursorCost + "<br>power: " + Buildings.cursorPower + "<br>Autoclicks once every 10 seconds.</html>");
        cursorPanel.add(LabelUpdater.cursorButton);

        //----- Cursor Labels Panel -----
        JPanel cursorLabelsPanel = new JPanel();
        cursorLabelsPanel.setLayout(new GridLayout(2, 1));

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
        grandmaPanel.setLayout(new GridLayout(1, 3));

        LabelUpdater.grandmaButton = new JButton();
        loadImage(LabelUpdater.grandmaButton, "resources/grandma.png");
        LabelUpdater.grandmaButton.addActionListener(e -> LabelUpdater.updateGrandmaLabel());
        LabelUpdater.grandmaButton.setToolTipText("<html>Grandma<br>amount: " + Buildings.grandmaAmount + "<br>cost: " + Buildings.grandmaCost + "<br>power: " + Buildings.grandmaPower + "<br>A nice grandma to bake more cookies.</html>");
        grandmaPanel.add(LabelUpdater.grandmaButton);

        //----- Grandma Labels Panel -----
        JPanel grandmaLabelsPanel = new JPanel();
        grandmaLabelsPanel.setLayout(new GridLayout(2, 1));

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
        farmPanel.setLayout(new GridLayout(1, 3));

        LabelUpdater.farmButton = new JButton();
        loadImage(LabelUpdater.farmButton, "resources/farm.png");
        LabelUpdater.farmButton.addActionListener(e -> LabelUpdater.updateFarmLabel());
        LabelUpdater.farmButton.setToolTipText("<html>Farm<br>amount: " + Buildings.farmAmount + "<br>cost: " + Buildings.farmCost + "<br>power: " + Buildings.farmPower + "<br>Grows cookie plants from cookie seeds.</html>");
        farmPanel.add(LabelUpdater.farmButton);

        //----- Farm Labels Panel -----
        JPanel farmLabelsPanel = new JPanel();
        farmLabelsPanel.setLayout(new GridLayout(2, 1));

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
        minePanel.setLayout(new GridLayout(1, 3));

        LabelUpdater.mineButton = new JButton();
        loadImage(LabelUpdater.mineButton, "resources/mine.png");
        LabelUpdater.mineButton.addActionListener(e -> LabelUpdater.updateMineLabel());
        LabelUpdater.mineButton.setToolTipText("<html>Mine<br>amount: " + Buildings.mineAmount + "<br>cost: " + Buildings.mineCost + "<br>power: " + Buildings.minePower + "<br>Mines out cookie dough and chocolate chips.</html>");
        minePanel.add(LabelUpdater.mineButton);

        //----- Mine Labels Panel -----
        JPanel mineLabelsPanel = new JPanel();
        mineLabelsPanel.setLayout(new GridLayout(2, 1));

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
        factoryPanel.setLayout(new GridLayout(1, 3));

        LabelUpdater.factoryButton = new JButton();
        loadImage(LabelUpdater.factoryButton, "resources/factory.png");
        LabelUpdater.factoryButton.addActionListener(e -> LabelUpdater.updateFactoryLabel());
        LabelUpdater.factoryButton.setToolTipText("<html>Factory<br>amount: " + Buildings.factoryAmount + "<br>cost: " + Buildings.factoryCost + "<br>power: " + Buildings.factoryPower + "<br>Produces large quantities of cookies.</html>");
        factoryPanel.add(LabelUpdater.factoryButton);

        //----- Factory Labels Panel -----
        JPanel factoryLabelsPanel = new JPanel();
        factoryLabelsPanel.setLayout(new GridLayout(2, 1));

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
        bankPanel.setLayout(new GridLayout(1, 3));

        LabelUpdater.bankButton = new JButton();
        loadImage(LabelUpdater.bankButton, "resources/bank.png");
        LabelUpdater.bankButton.addActionListener(e -> LabelUpdater.updateBankLabel());
        LabelUpdater.bankButton.setToolTipText("<html>Bank<br>amount: " + Buildings.bankAmount + "<br>cost: " + Buildings.bankCost + "<br>power: " + Buildings.bankPower + "<br>Generates cookies from interest.</html>");
        bankPanel.add(LabelUpdater.bankButton);

        //----- Bank Labels Panel -----
        JPanel bankLabelsPanel = new JPanel();
        bankLabelsPanel.setLayout(new GridLayout(2, 1));

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
        templePanel.setLayout(new GridLayout(1, 3));

        LabelUpdater.templeButton = new JButton();
        loadImage(LabelUpdater.templeButton, "resources/temple.png");
        LabelUpdater.templeButton.addActionListener(e -> LabelUpdater.updateTempleLabel());
        LabelUpdater.templeButton.setToolTipText("<html>Temple<br>amount: " + Buildings.templeAmount + "<br>cost: " + Buildings.templeCost + "<br>power: " + Buildings.templePower + "<br>Full of precious, ancient chocolate.</html>");
        templePanel.add(LabelUpdater.templeButton);

        //----- Temple Labels Panel -----
        JPanel templeLabelsPanel = new JPanel();
        templeLabelsPanel.setLayout(new GridLayout(2, 1));

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
        wizardTowerPanel.setLayout(new GridLayout(1, 3));

        LabelUpdater.wizardTowerButton = new JButton();
        loadImage(LabelUpdater.wizardTowerButton, "resources/wizardTower.png");
        LabelUpdater.wizardTowerButton.addActionListener(e -> LabelUpdater.updateWizardTowerLabel());
        LabelUpdater.wizardTowerButton.setToolTipText("<html>Wizard Tower<br>amount: " + Buildings.wizardTowerAmount + "<br>cost: " + Buildings.wizardTowerCost + "<br>power: " + Buildings.wizardTowerPower + "<br>Summons cookies with magic spells.</html>");
        wizardTowerPanel.add(LabelUpdater.wizardTowerButton);

        //----- Wizard Tower Labels Panel -----
        JPanel wizardTowerLabelsPanel = new JPanel();
        wizardTowerLabelsPanel.setLayout(new GridLayout(2, 1));

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
        shipmentPanel.setLayout(new GridLayout(1, 3));

        LabelUpdater.shipmentButton = new JButton();
        loadImage(LabelUpdater.shipmentButton, "resources/shipment.png");
        LabelUpdater.shipmentButton.addActionListener(e -> LabelUpdater.updateShipmentLabel());
        LabelUpdater.shipmentButton.setToolTipText("<html>Shipment<br>amount: " + Buildings.shipmentAmount + "<br>cost: " + Buildings.shipmentCost + "<br>power: " + Buildings.shipmentPower + "<br>Brings in fresh cookies from the cookie planet.</html>");
        shipmentPanel.add(LabelUpdater.shipmentButton);

        //----- Shipment Labels Panel -----
        JPanel shipmentLabelsPanel = new JPanel();
        shipmentLabelsPanel.setLayout(new GridLayout(2, 1));

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
        alchemyLabPanel.setLayout(new GridLayout(1, 3));

        LabelUpdater.alchemyLabButton = new JButton();
        loadImage(LabelUpdater.alchemyLabButton, "resources/alchemyLab.png");
        LabelUpdater.alchemyLabButton.addActionListener(e -> LabelUpdater.updateAlchemyLabLabel());
        LabelUpdater.alchemyLabButton.setToolTipText("<html>Alchemy Lab<br>amount: " + Buildings.alchemyLabAmount + "<br>cost: " + Buildings.alchemyLabCost + "<br>power: " + Buildings.alchemyLabPower + "<br>Turns gold into cookies!</html>");
        alchemyLabPanel.add(LabelUpdater.alchemyLabButton);

        //----- Alchemy Lab Labels Panel -----
        JPanel alchemyLabLabelsPanel = new JPanel();
        alchemyLabLabelsPanel.setLayout(new GridLayout(2, 1));

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
        portalPanel.setLayout(new GridLayout(1, 3));

        LabelUpdater.portalButton = new JButton();
        loadImage(LabelUpdater.portalButton, "resources/portal.png");
        LabelUpdater.portalButton.addActionListener(e -> LabelUpdater.updatePortalLabel());
        LabelUpdater.portalButton.setToolTipText("<html>Portal<br>amount: " + Buildings.portalAmount + "<br>cost: " + Buildings.portalCost + "<br>power: " + Buildings.portalPower + "<br>Opens the door to the Cookieverse.</html>");
        portalPanel.add(LabelUpdater.portalButton);

        //----- Portal Labels Panel -----
        JPanel portalLabelsPanel = new JPanel();
        portalLabelsPanel.setLayout(new GridLayout(2, 1));

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
        timeMachinePanel.setLayout(new GridLayout(1, 3));

        LabelUpdater.timeMachineButton = new JButton();
        loadImage(LabelUpdater.timeMachineButton, "resources/timeMachine.png");
        LabelUpdater.timeMachineButton.addActionListener(e -> LabelUpdater.updateTimeMachineLabel());
        LabelUpdater.timeMachineButton.setToolTipText("<html>Time Machine<br>amount: " + Buildings.timeMachineAmount + "<br>cost: " + Buildings.timeMachineCost + "<br>power: " + Buildings.timeMachinePower + "<br>Brings cookies from the past, before they were even eaten.</html>");
        timeMachinePanel.add(LabelUpdater.timeMachineButton);

        //----- Time Machine Labels Panel -----
        JPanel timeMachineLabelsPanel = new JPanel();
        timeMachineLabelsPanel.setLayout(new GridLayout(2, 1));

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
        antimatterCondenserPanel.setLayout(new GridLayout(1, 3));

        LabelUpdater.antimatterCondenserButton = new JButton();
        loadImage(LabelUpdater.antimatterCondenserButton, "resources/antimatterCondenser.png");
        LabelUpdater.antimatterCondenserButton.addActionListener(e -> LabelUpdater.updateAntimatterCondeserLabel());
        LabelUpdater.antimatterCondenserButton.setToolTipText("<html>Antimatter Condenser<br>amount: " + Buildings.antimatterCondenserAmount + "<br>cost: " + Buildings.antimatterCondenserCost + "<br>power: " + Buildings.antimatterCondenserPower + "<br>Condenses the antimatter in the universe into cookies.</html>");
        antimatterCondenserPanel.add(LabelUpdater.antimatterCondenserButton);

        //----- Antimatter Condenser Labels Panel -----
        JPanel antimatterCondenserLabelsPanel = new JPanel();
        antimatterCondenserLabelsPanel.setLayout(new GridLayout(2, 1));

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
        prismPanel.setLayout(new GridLayout(1, 3));

        LabelUpdater.prismButton = new JButton();
        loadImage(LabelUpdater.prismButton, "resources/prism.png");
        LabelUpdater.prismButton.addActionListener(e -> LabelUpdater.updatePrismLabel());
        LabelUpdater.prismButton.setToolTipText("<html>Prism<br>amount: " + Buildings.prismAmount + "<br>cost: " + Buildings.prismCost + "<br>power: " + Buildings.prismPower + "<br>Converts light itself into cookies.</html>");
        prismPanel.add(LabelUpdater.prismButton);

        //----- Prism Labels Panel -----
        JPanel prismLabelsPanel = new JPanel();
        prismLabelsPanel.setLayout(new GridLayout(2, 1));

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

        LabelUpdater.prismCostLabel = new JLabel("Prism Cost = 2.1 Quadrillion");
        LabelUpdater.prismCostLabel.setHorizontalAlignment(JLabel.LEFT);
        LabelUpdater.prismCostLabel.setVerticalAlignment(JLabel.CENTER);
        prismPanel.add(LabelUpdater.prismCostLabel);

        //Tilføjer Prism Panel ind i Third Panel
        thirdPanel.add(prismPanel);

        //----- Chancemaker Panel -----
        JPanel chancemakerPanel = new JPanel();
        chancemakerPanel.setLayout(new GridLayout(1, 3));

        LabelUpdater.chancemakerButton = new JButton();
        loadImage(LabelUpdater.chancemakerButton, "resources/chancemaker.png");
        LabelUpdater.chancemakerButton.addActionListener(e -> LabelUpdater.updateChancemakerLabel());
        LabelUpdater.chancemakerButton.setToolTipText("<html>Chancemaker<br>amount: " + Buildings.chancemakerAmount + "<br>cost: " + Buildings.chancemakerCost + "<br>power: " + Buildings.chancemakerPower + "<br>Generates cookies out of thin air through sheer luck.</html>");
        chancemakerPanel.add(LabelUpdater.chancemakerButton);

        //----- Chancemaker Labels Panel -----
        JPanel chancemakerLabelsPanel = new JPanel();
        chancemakerLabelsPanel.setLayout(new GridLayout(2, 1));

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

        LabelUpdater.chancemakerCostLabel = new JLabel("CM Cost = 26 Quadrillion");
        LabelUpdater.chancemakerCostLabel.setHorizontalAlignment(JLabel.LEFT);
        LabelUpdater.chancemakerCostLabel.setVerticalAlignment(JLabel.CENTER);
        chancemakerPanel.add(LabelUpdater.chancemakerCostLabel);

        //Tilføjer Chancemaker Panel ind i Third Panel
        thirdPanel.add(chancemakerPanel);

        //----- Fractal Engine Panel -----
        JPanel fractalEnginePanel = new JPanel();
        fractalEnginePanel.setLayout(new GridLayout(1, 3));

        LabelUpdater.fractalEngineButton = new JButton();
        loadImage(LabelUpdater.fractalEngineButton, "resources/fractalEngine.png");
        LabelUpdater.fractalEngineButton.addActionListener(e -> LabelUpdater.updateFractalEngineLabel());
        LabelUpdater.fractalEngineButton.setToolTipText("<html>Fractal Engine<br>amount: " + Buildings.fractalEngineAmount + "<br>cost: " + Buildings.fractalEngineCost + "<br>power: " + Buildings.fractalEnginePower + "<br>Turns cookies into even more cookies.</html>");
        fractalEnginePanel.add(LabelUpdater.fractalEngineButton);

        //----- Fractal Engine Labels Panel -----
        JPanel fractalEngineLabelsPanel = new JPanel();
        fractalEngineLabelsPanel.setLayout(new GridLayout(2, 1));

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
     *
     * @since 1.0.1
     */
    private void quit() {
        System.exit(0);
    }

    /**
     * Here we make a menu bar, that uses the quit function we made earlier to quit the program.
     *
     * @param frame is used to tell the menu bar when it's called, which frame it's should be on.
     * @since 1.0.1
     */
    private void makeMenuBar(JFrame frame) {
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
