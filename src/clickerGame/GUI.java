package clickerGame;

//Importing different packages.
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * This is the class where I build the GUI for the game.
 *
 * @author Nicklas Lydersen
 * @since 1.0.1
 */
public class GUI
{
    //This is where I import JLabels.
    //----- Clicks Labels -----
    private JLabel clicks;
    private JLabel perSecond;
    private JLabel clickPowerLabel;
    private JLabel clickPowerCostLabel;
    private JLabel clickPowerLevelLabel;

    //----- Arrow Clicker Labels -----
    private JLabel arrowClickerPowerLabel;
    private JLabel arrowClickerAmountLabel;
    private JLabel arrowClickerCostLabel;

    //Here I'm making my variables
    /**
     * This integer is holding the amount of clicks the player have.
     */
    private BigInteger totalClicks = new BigInteger("0");
    /**
     * Boolean for the Auto Clicker Loop, so it can run when the game is running.
     */
    private boolean gameRunning;

    /**
     * This is where I make the frame, and all the other important things.
     * @since 1.0.1
     * @
     */
    public GUI()
    {
        totalClicks = totalClicks.add(new BigInteger("999998"));
        new clickerGame.Clicker();
        //Clicker.playerClicks = 981911;
        makeFrame();
    }

    /**
     * This is used for when I need the program to sleep different places.
     * @param n Is the integer for how long the program needs to sleep. n = 1000 <=> 1 second
     */
    private void sleep(int n)
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
     * This is where I update the clicks label.
     * @param TF We are using this boolean to define if it's just for updating the label or if it's an actual player click.
     *           true for click and false for updating.
     * @since 1.0.1
     */
    private void updateClicks(boolean TF)
    {
        if (TF) {

            totalClicks = totalClicks.add(Clicker.playerClicks);
        }
        System.out.println(totalClicks);
        if(totalClicks.compareTo(new BigInteger("1000000")) < 0)
        {
            clicks.setText(totalClicks.toString());
        }
        else if (totalClicks.compareTo(new BigInteger("1000000")) >= 0 && totalClicks.compareTo(new BigInteger("1000000000")) < 0)
        {
            clicks.setText(new BigDecimal(totalClicks).divide(new BigDecimal("1000000"), 3, RoundingMode.HALF_EVEN) + " Million");
        }
        else if (totalClicks.compareTo(new BigInteger("1000000000")) >= 0 && totalClicks.compareTo(new BigInteger("1000000000000")) < 0)
        {
            clicks.setText(new BigDecimal(totalClicks).divide(new BigDecimal("1000000000"), 3, RoundingMode.HALF_EVEN) + " Billion");
        }
        else if (totalClicks.compareTo(new BigInteger("1000000000000")) >= 0 && totalClicks.compareTo(new BigInteger("1000000000000000")) < 0)
        {
            clicks.setText(new BigDecimal(totalClicks).divide(new BigDecimal("1000000000000"), 3, RoundingMode.HALF_EVEN) + " Trillion");
        }
        else if (totalClicks.compareTo(new BigInteger("1000000000000000")) >= 0 && totalClicks.compareTo(new BigInteger("1000000000000000000")) < 0)
        {
            clicks.setText(new BigDecimal(totalClicks).divide(new BigDecimal("1000000000000000"), 3, RoundingMode.HALF_EVEN) + "  Quadrillion");
        }
        else if (totalClicks.compareTo(new BigInteger("1000000000000000000")) >= 0 && totalClicks.compareTo(new BigInteger("1000000000000000000000")) < 0)
        {
            clicks.setText(new BigDecimal(totalClicks).divide(new BigDecimal("1000000000000000"), 3, RoundingMode.HALF_EVEN) + " Quintillion");
        }
    }

    /**
     * This is updating the Total Clicks variable and the Label to that variable. This is also where we are updating clickPower of the player,
     * while updating the labels for the different variables in clickPower.
     * @since 1.0.1
     */
    private void updateClickPowerLabel()
    {
        if(totalClicks.compareTo(BigInteger.valueOf(Clicker.clickPowerCost)) >= 0 && Clicker.clickPowerLevel <= 99)
        {
            totalClicks = totalClicks.add(BigInteger.valueOf(Clicker.clickPowerCost).negate());
            updateClicks(false);
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
    private void updateArrowClickerLabel()
    {
        if(totalClicks.compareTo(Clicker.arrowClickerCost) >= 0)
        {
            totalClicks = totalClicks.add(Clicker.arrowClickerCost.negate());
            updateClicks(false);
            Clicker.arrowClicker();
            arrowClickerPowerLabel.setText("AC Power = " + Clicker.arrowClickPower);
            arrowClickerAmountLabel.setText("AC Amount = " + Clicker.arrowClickerAmount);
            if(Clicker.arrowClickerCost.compareTo(new BigInteger("1000000")) < 0)
            {
                arrowClickerCostLabel.setText("AC Cost = " + Clicker.arrowClickerCost.toString());
            }
            else if (Clicker.arrowClickerCost.compareTo(new BigInteger("1000000")) >= 0 && Clicker.arrowClickerCost.compareTo(new BigInteger("1000000000")) < 0)
            {
                arrowClickerCostLabel.setText("AC Cost = " + new BigDecimal(Clicker.arrowClickerCost).divide(new BigDecimal("1000000"),3, RoundingMode.HALF_EVEN) + " Million");
            }
            else if (Clicker.arrowClickerCost.compareTo(new BigInteger("1000000000")) >= 0 && Clicker.arrowClickerCost.compareTo(new BigInteger("1000000000000")) < 0)
            {
                arrowClickerCostLabel.setText("AC Cost = " + new BigDecimal(Clicker.arrowClickerCost).divide(new BigDecimal("1000000000"),3, RoundingMode.HALF_EVEN) + " Billion");
            }
            else if (Clicker.arrowClickerCost.compareTo(new BigInteger("1000000000000")) >= 0 && Clicker.arrowClickerCost.compareTo(new BigInteger("1000000000000000")) < 0)
            {
                arrowClickerCostLabel.setText("AC Cost = " + new BigDecimal(Clicker.arrowClickerCost).divide(new BigDecimal("1000000000000"),3, RoundingMode.HALF_EVEN) + " Trillion");
            }
            else if (Clicker.arrowClickerCost.compareTo(new BigInteger("1000000000000000")) >= 0 && Clicker.arrowClickerCost.compareTo(new BigInteger("1000000000000000000")) < 0)
            {
                arrowClickerCostLabel.setText("AC Cost = " + new BigDecimal(Clicker.arrowClickerCost).divide(new BigDecimal("1000000000000000"),3, RoundingMode.HALF_EVEN) + "  Quadrillion");
            }
            else if (Clicker.arrowClickerCost.compareTo(new BigInteger("1000000000000000000")) >= 0 && Clicker.arrowClickerCost.compareTo(new BigInteger("1000000000000000000000")) < 0)
            {
                arrowClickerCostLabel.setText("AC Cost = " + new BigDecimal(Clicker.arrowClickerCost).divide(new BigDecimal("1000000000000000000"),3, RoundingMode.HALF_EVEN) + " Quintillion");
            }
        }
    }

    /**
     * This is where the loop for the auto clickers are running all the auto clickers.
     * @since 1.0.1
     */
    private void autoClickerLoop()
    {
        while (gameRunning)
        {
            sleep(1000);
            if(Clicker.arrowClickerAmount != 0)
            {
                totalClicks = totalClicks.add(BigInteger.valueOf(Clicker.arrowClickPower).multiply(BigInteger.valueOf(Clicker.arrowClickerAmount)));
                updateClicks(false);
            }
        }
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
            firstPanel.setLayout(new GridLayout(2, 1));

            //Tilføjer en label og en button til First Panel
            clicks = new JLabel("0");
            Font titelFont = clicks.getFont().deriveFont(30f);
            clicks.setFont(titelFont);
            clicks.setHorizontalAlignment(JLabel.CENTER);
            clicks.setVerticalAlignment(JLabel.CENTER);
            firstPanel.add(clicks);

                //----- Button Panel -----
                JPanel buttonPanel = new JPanel();
                buttonPanel.setLayout(new GridLayout(3,3));

                //Tilføjer Clicker Button ind i Button Panel, så den står et pænere sted
                JButton clickerButton = new JButton();
                loadImage(clickerButton,"resources/cookie.png");
                clickerButton.addActionListener(e -> updateClicks(true));
                firstPanel.add(clickerButton);

        //Tilføjer First Panel ind i Main Panel
        mainPanel.add(firstPanel);

            //----- Second Panel -----
            JPanel secondPanel = new JPanel();
            secondPanel.setLayout(new GridLayout(1,1));

        //Tilføjer Second Panel ind i Main Panel
        mainPanel.add(secondPanel);

            //----- Third Panel -----
            JPanel thirdPanel = new JPanel();
            thirdPanel.setLayout(new GridLayout(2,1));

                //----- Click Power Panel -----
                JPanel clickPowerPanel = new JPanel();
                clickPowerPanel.setLayout(new GridLayout(1,3));

                JButton clickPowerButton = new JButton();
                loadImage(clickPowerButton, "resources/click_power_upgrade.png");
                clickPowerButton.addActionListener(e -> updateClickPowerLabel());
                clickPowerPanel.add(clickPowerButton);

                    //----- Click Power Labels Panel -----
                    JPanel clickPowerLabelsPanel = new JPanel();
                    clickPowerLabelsPanel.setLayout(new GridLayout(2,1));

                    clickPowerLabel = new JLabel("Click Power = " + Clicker.playerClicks);
                    clickPowerLabel.setHorizontalAlignment(JLabel.CENTER);
                    clickPowerLabel.setVerticalAlignment(JLabel.CENTER);
                    clickPowerLabelsPanel.add(clickPowerLabel);

                    clickPowerLevelLabel = new JLabel("Level = " + Clicker.clickPowerLevel + " / 100");
                    clickPowerLevelLabel.setHorizontalAlignment(JLabel.CENTER);
                    clickPowerLevelLabel.setVerticalAlignment(JLabel.CENTER);
                    clickPowerLabelsPanel.add(clickPowerLevelLabel);

                    //Tilføjer Click Power Labels Panel ind i Click Power Panel
                    clickPowerPanel.add(clickPowerLabelsPanel);

                clickPowerCostLabel = new JLabel("Click Power Cost = " + Clicker.clickPowerCost);
                clickPowerCostLabel.setHorizontalAlignment(JLabel.CENTER);
                clickPowerCostLabel.setVerticalAlignment(JLabel.CENTER);
                clickPowerPanel.add(clickPowerCostLabel);

                //Tilføjer Click Power Panel ind i Third Panel
                thirdPanel.add(clickPowerPanel);

                //----- Arrow Clicker Panel -----
                JPanel arrowClickerPanel = new JPanel();
                arrowClickerPanel.setLayout(new GridLayout(1,3));

                JButton arrowClickerButton = new JButton();
                loadImage(arrowClickerButton,"resources/arrow_clicker.png");
                arrowClickerButton.addActionListener(e -> updateArrowClickerLabel());
                arrowClickerPanel.add(arrowClickerButton);

                    //----- Arrow Clicker Labels Panel -----
                    JPanel arrowClickerLabelsPanel = new JPanel();
                    arrowClickerLabelsPanel.setLayout(new GridLayout(2,1));

                    arrowClickerPowerLabel = new JLabel("AC Power = " + Clicker.arrowClickPower);
                    arrowClickerPowerLabel.setHorizontalAlignment(JLabel.CENTER);
                    arrowClickerPowerLabel.setVerticalAlignment(JLabel.CENTER);
                    arrowClickerLabelsPanel.add(arrowClickerPowerLabel);

                    arrowClickerAmountLabel = new JLabel("AC Amount = " + Clicker.arrowClickerAmount);
                    arrowClickerAmountLabel.setHorizontalAlignment(JLabel.CENTER);
                    arrowClickerAmountLabel.setVerticalAlignment(JLabel.CENTER);
                    arrowClickerLabelsPanel.add(arrowClickerAmountLabel);

                    //Tilføjer Arrow Clicker Labels Panel ind i Arrow Clicker Panel
                    arrowClickerPanel.add(arrowClickerLabelsPanel);

                arrowClickerCostLabel = new JLabel("AC Cost = " + Clicker.arrowClickerCost);
                arrowClickerCostLabel.setHorizontalAlignment(JLabel.CENTER);
                arrowClickerCostLabel.setVerticalAlignment(JLabel.CENTER);
                arrowClickerPanel.add(arrowClickerCostLabel);

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

        autoClickerLoop();
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
