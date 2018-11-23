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
        //totalCookies = totalCookies.add(new BigDecimal("1400000"));
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
        //button.setContentAreaFilled(false);
        button.setBackground(Color.white);
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
        contentPane.setBorder(new EmptyBorder(1, 1, 1, 1));
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
        clickerButton.setContentAreaFilled(false);
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
        thirdPanel.setLayout(new FlowLayout());

        //----- Buildings Scroll Pane -----
        JScrollPane buildingsScrollPane = new JScrollPane();

        //----- Buildings Panel -----
        JPanel buildingsPanel = new JPanel();
        buildingsPanel.setLayout(new GridLayout(16,1));

        //----- Cursor Building -----
        LabelUpdater.cursorButton = new JButtonAllign(Integer.toString(Buildings.cursorAmount));
        LabelUpdater.cursorButton.setHorizontalAlignment(SwingConstants.LEADING);
        LabelUpdater.cursorButton.setFont(LabelUpdater.cursorButton.getFont().deriveFont(30f));
        loadImage(LabelUpdater.cursorButton, "resources/cursor1.png");
        LabelUpdater.cursorButton.addActionListener(e -> LabelUpdater.updateCursorLabel());
        LabelUpdater.cursorButton.setToolTipText("<html>Cursor<br>amount: " + Buildings.cursorAmount + "<br>cost: " + Buildings.cursorCost + "<br>power: " + Buildings.cursorPower + "<br>Autoclicks once every 10 seconds.</html>");
        buildingsPanel.add(LabelUpdater.cursorButton);

        //----- Grandma Building -----
        LabelUpdater.grandmaButton = new JButtonAllign(Integer.toString(Buildings.grandmaAmount));
        LabelUpdater.grandmaButton.setHorizontalAlignment(SwingConstants.LEADING);
        LabelUpdater.grandmaButton.setFont(LabelUpdater.grandmaButton.getFont().deriveFont(30f));
        loadImage(LabelUpdater.grandmaButton, "resources/grandma.png");
        LabelUpdater.grandmaButton.addActionListener(e -> LabelUpdater.updateGrandmaLabel());
        LabelUpdater.grandmaButton.setToolTipText("<html>Grandma<br>amount: " + Buildings.grandmaAmount + "<br>cost: " + Buildings.grandmaCost + "<br>power: " + Buildings.grandmaPower + "<br>A nice grandma to bake more cookies.</html>");
        buildingsPanel.add(LabelUpdater.grandmaButton);

        //----- Farm Building -----
        LabelUpdater.farmButton = new JButtonAllign(Integer.toString(Buildings.farmAmount));
        LabelUpdater.farmButton.setHorizontalAlignment(SwingConstants.LEADING);
        LabelUpdater.farmButton.setFont(LabelUpdater.farmButton.getFont().deriveFont(30f));
        loadImage(LabelUpdater.farmButton, "resources/farm.png");
        LabelUpdater.farmButton.addActionListener(e -> LabelUpdater.updateFarmLabel());
        LabelUpdater.farmButton.setToolTipText("<html>Farm<br>amount: " + Buildings.farmAmount + "<br>cost: " + Buildings.farmCost + "<br>power: " + Buildings.farmPower + "<br>Grows cookie plants from cookie seeds.</html>");
        buildingsPanel.add(LabelUpdater.farmButton);

        //----- Mine Building -----
        LabelUpdater.mineButton = new JButtonAllign(Integer.toString(Buildings.mineAmount));
        LabelUpdater.mineButton.setHorizontalAlignment(SwingConstants.LEADING);
        LabelUpdater.mineButton.setFont(LabelUpdater.mineButton.getFont().deriveFont(30f));
        loadImage(LabelUpdater.mineButton, "resources/mine.png");
        LabelUpdater.mineButton.addActionListener(e -> LabelUpdater.updateMineLabel());
        LabelUpdater.mineButton.setToolTipText("<html>Mine<br>amount: " + Buildings.mineAmount + "<br>cost: " + Buildings.mineCost + "<br>power: " + Buildings.minePower + "<br>Mines out cookie dough and chocolate chips.</html>");
        buildingsPanel.add(LabelUpdater.mineButton);

        //----- Factory Building -----
        LabelUpdater.factoryButton = new JButtonAllign(Integer.toString(Buildings.factoryAmount));
        LabelUpdater.factoryButton.setHorizontalAlignment(SwingConstants.LEADING);
        LabelUpdater.factoryButton.setFont(LabelUpdater.factoryButton.getFont().deriveFont(30f));
        loadImage(LabelUpdater.factoryButton, "resources/factory.png");
        LabelUpdater.factoryButton.addActionListener(e -> LabelUpdater.updateFactoryLabel());
        LabelUpdater.factoryButton.setToolTipText("<html>Factory<br>amount: " + Buildings.factoryAmount + "<br>cost: " + Buildings.factoryCost + "<br>power: " + Buildings.factoryPower + "<br>Produces large quantities of cookies.</html>");
        buildingsPanel.add(LabelUpdater.factoryButton);

        //----- Bank Building -----
        LabelUpdater.bankButton = new JButtonAllign(Integer.toString(Buildings.bankAmount));
        LabelUpdater.bankButton.setHorizontalAlignment(SwingConstants.LEADING);
        LabelUpdater.bankButton.setFont(LabelUpdater.bankButton.getFont().deriveFont(30f));
        loadImage(LabelUpdater.bankButton, "resources/bank.png");
        LabelUpdater.bankButton.addActionListener(e -> LabelUpdater.updateBankLabel());
        LabelUpdater.bankButton.setToolTipText("<html>Bank<br>amount: " + Buildings.bankAmount + "<br>cost: " + Buildings.bankCost + "<br>power: " + Buildings.bankPower + "<br>Generates cookies from interest.</html>");
        buildingsPanel.add(LabelUpdater.bankButton);

        //----- Temple Building -----
        LabelUpdater.templeButton = new JButtonAllign(Integer.toString(Buildings.templeAmount));
        LabelUpdater.templeButton.setHorizontalAlignment(SwingConstants.LEADING);
        LabelUpdater.templeButton.setFont(LabelUpdater.templeButton.getFont().deriveFont(30f));
        loadImage(LabelUpdater.templeButton, "resources/temple.png");
        LabelUpdater.templeButton.addActionListener(e -> LabelUpdater.updateTempleLabel());
        LabelUpdater.templeButton.setToolTipText("<html>Temple<br>amount: " + Buildings.templeAmount + "<br>cost: " + Buildings.templeCost + "<br>power: " + Buildings.templePower + "<br>Full of precious, ancient chocolate.</html>");
        buildingsPanel.add(LabelUpdater.templeButton);

        //----- Wizard Tower Building -----
        LabelUpdater.wizardTowerButton = new JButtonAllign(Integer.toString(Buildings.wizardTowerAmount));
        LabelUpdater.wizardTowerButton.setHorizontalAlignment(SwingConstants.LEADING);
        LabelUpdater.wizardTowerButton.setFont(LabelUpdater.wizardTowerButton.getFont().deriveFont(30f));
        loadImage(LabelUpdater.wizardTowerButton, "resources/wizardTower.png");
        LabelUpdater.wizardTowerButton.addActionListener(e -> LabelUpdater.updateWizardTowerLabel());
        LabelUpdater.wizardTowerButton.setToolTipText("<html>Wizard Tower<br>amount: " + Buildings.wizardTowerAmount + "<br>cost: " + Buildings.wizardTowerCost + "<br>power: " + Buildings.wizardTowerPower + "<br>Summons cookies with magic spells.</html>");
        buildingsPanel.add(LabelUpdater.wizardTowerButton);

        //----- Shipment Building -----
        LabelUpdater.shipmentButton = new JButtonAllign(Integer.toString(Buildings.shipmentAmount));
        LabelUpdater.shipmentButton.setHorizontalAlignment(SwingConstants.LEADING);
        LabelUpdater.shipmentButton.setFont(LabelUpdater.shipmentButton.getFont().deriveFont(30f));
        loadImage(LabelUpdater.shipmentButton, "resources/shipment.png");
        LabelUpdater.shipmentButton.addActionListener(e -> LabelUpdater.updateShipmentLabel());
        LabelUpdater.shipmentButton.setToolTipText("<html>Shipment<br>amount: " + Buildings.shipmentAmount + "<br>cost: " + Buildings.shipmentCost + "<br>power: " + Buildings.shipmentPower + "<br>Brings in fresh cookies from the cookie planet.</html>");
        buildingsPanel.add(LabelUpdater.shipmentButton);

        //----- Alchemy Lab Building -----
        LabelUpdater.alchemyLabButton = new JButtonAllign(Integer.toString(Buildings.alchemyLabAmount));
        LabelUpdater.alchemyLabButton.setHorizontalAlignment(SwingConstants.LEADING);
        LabelUpdater.alchemyLabButton.setFont(LabelUpdater.alchemyLabButton.getFont().deriveFont(30f));
        loadImage(LabelUpdater.alchemyLabButton, "resources/alchemyLab.png");
        LabelUpdater.alchemyLabButton.addActionListener(e -> LabelUpdater.updateAlchemyLabLabel());
        LabelUpdater.alchemyLabButton.setToolTipText("<html>Alchemy Lab<br>amount: " + Buildings.alchemyLabAmount + "<br>cost: " + Buildings.alchemyLabCost + "<br>power: " + Buildings.alchemyLabPower + "<br>Turns gold into cookies!</html>");
        buildingsPanel.add(LabelUpdater.alchemyLabButton);

        //----- Portal Building -----
        LabelUpdater.portalButton = new JButtonAllign(Integer.toString(Buildings.portalAmount));
        LabelUpdater.portalButton.setHorizontalAlignment(SwingConstants.LEADING);
        LabelUpdater.portalButton.setFont(LabelUpdater.portalButton.getFont().deriveFont(30f));
        loadImage(LabelUpdater.portalButton, "resources/portal.png");
        LabelUpdater.portalButton.addActionListener(e -> LabelUpdater.updatePortalLabel());
        LabelUpdater.portalButton.setToolTipText("<html>Portal<br>amount: " + Buildings.portalAmount + "<br>cost: " + Buildings.portalCost + "<br>power: " + Buildings.portalPower + "<br>Opens the door to the Cookieverse.</html>");
        buildingsPanel.add(LabelUpdater.portalButton);

        //----- Time Machine Building -----
        LabelUpdater.timeMachineButton = new JButtonAllign(Integer.toString(Buildings.timeMachineAmount));
        LabelUpdater.timeMachineButton.setHorizontalAlignment(SwingConstants.LEADING);
        LabelUpdater.timeMachineButton.setFont(LabelUpdater.timeMachineButton.getFont().deriveFont(30f));
        loadImage(LabelUpdater.timeMachineButton, "resources/timeMachine.png");
        LabelUpdater.timeMachineButton.addActionListener(e -> LabelUpdater.updateTimeMachineLabel());
        LabelUpdater.timeMachineButton.setToolTipText("<html>Time Machine<br>amount: " + Buildings.timeMachineAmount + "<br>cost: " + Buildings.timeMachineCost + "<br>power: " + Buildings.timeMachinePower + "<br>Brings cookies from the past, before they were even eaten.</html>");
        buildingsPanel.add(LabelUpdater.timeMachineButton);

        //----- Antimatter Condenser Building -----
        LabelUpdater.antimatterCondenserButton = new JButtonAllign(Integer.toString(Buildings.antimatterCondenserAmount));
        LabelUpdater.antimatterCondenserButton.setHorizontalAlignment(SwingConstants.LEADING);
        LabelUpdater.antimatterCondenserButton.setFont(LabelUpdater.antimatterCondenserButton.getFont().deriveFont(30f));
        loadImage(LabelUpdater.antimatterCondenserButton, "resources/antimatterCondenser.png");
        LabelUpdater.antimatterCondenserButton.addActionListener(e -> LabelUpdater.updateAntimatterCondeserLabel());
        LabelUpdater.antimatterCondenserButton.setToolTipText("<html>Antimatter Condenser<br>amount: " + Buildings.antimatterCondenserAmount + "<br>cost: " + Buildings.antimatterCondenserCost + "<br>power: " + Buildings.antimatterCondenserPower + "<br>Condenses the antimatter in the universe into cookies.</html>");
        buildingsPanel.add(LabelUpdater.antimatterCondenserButton);

        //----- Prism Building -----
        LabelUpdater.prismButton = new JButtonAllign(Integer.toString(Buildings.prismAmount));
        LabelUpdater.prismButton.setHorizontalAlignment(SwingConstants.LEADING);
        LabelUpdater.prismButton.setFont(LabelUpdater.prismButton.getFont().deriveFont(30f));
        loadImage(LabelUpdater.prismButton, "resources/prism.png");
        LabelUpdater.prismButton.addActionListener(e -> LabelUpdater.updatePrismLabel());
        LabelUpdater.prismButton.setToolTipText("<html>Prism<br>amount: " + Buildings.prismAmount + "<br>cost: " + Buildings.prismCost + "<br>power: " + Buildings.prismPower + "<br>Converts light itself into cookies.</html>");
        buildingsPanel.add(LabelUpdater.prismButton);

        //----- Chancemaker Building -----
        LabelUpdater.chancemakerButton = new JButtonAllign(Integer.toString(Buildings.chancemakerAmount));
        LabelUpdater.chancemakerButton.setHorizontalAlignment(SwingConstants.LEADING);
        LabelUpdater.chancemakerButton.setFont(LabelUpdater.chancemakerButton.getFont().deriveFont(30f));
        loadImage(LabelUpdater.chancemakerButton, "resources/chancemaker.png");
        LabelUpdater.chancemakerButton.addActionListener(e -> LabelUpdater.updateChancemakerLabel());
        LabelUpdater.chancemakerButton.setToolTipText("<html>Chancemaker<br>amount: " + Buildings.chancemakerAmount + "<br>cost: " + Buildings.chancemakerCost + "<br>power: " + Buildings.chancemakerPower + "<br>Generates cookies out of thin air through sheer luck.</html>");
        buildingsPanel.add(LabelUpdater.chancemakerButton);

        //----- Fractal Engine Building -----
        LabelUpdater.fractalEngineButton = new JButtonAllign(Integer.toString(Buildings.fractalEngineAmount));
        LabelUpdater.fractalEngineButton.setHorizontalAlignment(SwingConstants.LEADING);
        LabelUpdater.fractalEngineButton.setFont(LabelUpdater.fractalEngineButton.getFont().deriveFont(30f));
        loadImage(LabelUpdater.fractalEngineButton, "resources/fractalEngine.png");
        LabelUpdater.fractalEngineButton.addActionListener(e -> LabelUpdater.updateFractalEngineLabel());
        LabelUpdater.fractalEngineButton.setToolTipText("<html>Fractal Engine<br>amount: " + Buildings.fractalEngineAmount + "<br>cost: " + Buildings.fractalEngineCost + "<br>power: " + Buildings.fractalEnginePower + "<br>Turns cookies into even more cookies.</html>");
        buildingsPanel.add(LabelUpdater.fractalEngineButton);

        //
        buildingsScrollPane.setViewport(buildingsPanel);

        //
        thirdPanel.add(buildingsScrollPane);

        //Tilføjer Third Panel ind i Main Panel
        mainPanel.add(thirdPanel);

        //tilføjer Main Panel ind i Border Panel
        borderPanel.add(mainPanel);

        contentPane.add(mainPanel, BorderLayout.CENTER);

        frame.pack();

        frame.setSize(1920,1080);
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
