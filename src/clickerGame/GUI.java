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
public class GUI
{
    //Here I'm making my variables
    /**
     * This integer is holding the amount of clicks the player have.
     */
    public static BigDecimal totalCookies = new BigDecimal("0");
    /**
     * Boolean for the Auto Clicker Loop, so it can run when the game is running.
     */
    public static boolean gameRunning;

    /**
     * This is where I make the frame, and all the other important things.
     * @since 1.0.1
     * @
     */
    public GUI()
    {
        //totalClicks = totalClicks.add(new BigDecimal("999998"));
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
            thirdPanel.setLayout(new GridLayout(2,1));

                //----- Click Power Panel -----
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
                    LabelUpdater.clickPowerLabel.setHorizontalAlignment(JLabel.CENTER);
                    LabelUpdater.clickPowerLabel.setVerticalAlignment(JLabel.CENTER);
                    clickPowerLabelsPanel.add(LabelUpdater.clickPowerLabel);

                    LabelUpdater.clickPowerLevelLabel = new JLabel("Level = " + Clicker.clickPowerLevel + " / 100");
                    LabelUpdater.clickPowerLevelLabel.setHorizontalAlignment(JLabel.CENTER);
                    LabelUpdater.clickPowerLevelLabel.setVerticalAlignment(JLabel.CENTER);
                    clickPowerLabelsPanel.add(LabelUpdater.clickPowerLevelLabel);

                    //Tilføjer Click Power Labels Panel ind i Click Power Panel
                    clickPowerPanel.add(clickPowerLabelsPanel);

                LabelUpdater.clickPowerCostLabel = new JLabel("Click Power Cost = " + Clicker.clickPowerCost);
                LabelUpdater.clickPowerCostLabel.setHorizontalAlignment(JLabel.CENTER);
                LabelUpdater.clickPowerCostLabel.setVerticalAlignment(JLabel.CENTER);
                clickPowerPanel.add(LabelUpdater.clickPowerCostLabel);

                //Tilføjer Click Power Panel ind i Third Panel
                thirdPanel.add(clickPowerPanel);

                //----- Arrow Clicker Panel -----
                JPanel arrowClickerPanel = new JPanel();
                arrowClickerPanel.setLayout(new GridLayout(1,3));

                JButton arrowClickerButton = new JButton();
                loadImage(arrowClickerButton,"resources/cursor.png");
                arrowClickerButton.addActionListener(e -> LabelUpdater.updateCursorLabel());
                arrowClickerPanel.add(arrowClickerButton);

                    //----- Arrow Clicker Labels Panel -----
                    JPanel arrowClickerLabelsPanel = new JPanel();
                    arrowClickerLabelsPanel.setLayout(new GridLayout(2,1));

                    LabelUpdater.cursorPowerLabel = new JLabel("AC Power = " + Buildings.cursorPower);
                    LabelUpdater.cursorPowerLabel.setHorizontalAlignment(JLabel.CENTER);
                    LabelUpdater.cursorPowerLabel.setVerticalAlignment(JLabel.CENTER);
                    arrowClickerLabelsPanel.add(LabelUpdater.cursorPowerLabel);

                    LabelUpdater.cursorAmountLabel = new JLabel("AC Amount = " + Buildings.cursorAmount);
                    LabelUpdater.cursorAmountLabel.setHorizontalAlignment(JLabel.CENTER);
                    LabelUpdater.cursorAmountLabel.setVerticalAlignment(JLabel.CENTER);
                    arrowClickerLabelsPanel.add(LabelUpdater.cursorAmountLabel);

                    //Tilføjer Arrow Clicker Labels Panel ind i Arrow Clicker Panel
                    arrowClickerPanel.add(arrowClickerLabelsPanel);

                LabelUpdater.cursorCostLabel = new JLabel("AC Cost = " + Buildings.cursorCost);
                LabelUpdater.cursorCostLabel.setHorizontalAlignment(JLabel.CENTER);
                LabelUpdater.cursorCostLabel.setVerticalAlignment(JLabel.CENTER);
                arrowClickerPanel.add(LabelUpdater.cursorCostLabel);

                //Tilføjer Arrow Clicker Panel ind i Third Panel
                thirdPanel.add(arrowClickerPanel);

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
