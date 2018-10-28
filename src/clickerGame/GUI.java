package clickerGame;

//Importing different packages.
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * This is the class where I build the GUI for the game.
 *
 * @author Nicklas Lydersen
 * @version 1.0.1
 */
public class GUI
{
    //This is where I import JLabels.
    private JLabel clicks;
    private JLabel clickPowerLabel;
    private JLabel clickPowerCostLabel;
    private JLabel clickPowerLevelLabel;

    //Here I'm making my variables
    private int totalClicks = 0;

    /**
     * This is running everything.
     */
    public static void main (String[] args)
    {
        new GUI();
    }

    /**
     * This is where I make the frame, and all the other important things.
     */
    private GUI()
    {
        totalClicks = 999999999;
        new clickerGame.Clicker();
        makeFrame();
    }

    /**
     * This is where I update the clicks label.
     */
    private void updateClicks()
    {
        totalClicks += Clicker.playerClicks;
        clicks.setText(Integer.toString(totalClicks));
    }

    private void updateClickPowerLabel()
    {
        if(totalClicks >= Clicker.clickPowerCost && Clicker.clickPowerLevel <= 99)
        {
            totalClicks = totalClicks - Clicker.clickPowerCost;
            clicks.setText(Integer.toString(totalClicks));
            Clicker.clickPower();
            clickPowerLabel.setText("Click Power = " + Clicker.playerClicks);
            clickPowerCostLabel.setText("Click Power Cost = " + Clicker.clickPowerCost);
            clickPowerLevelLabel.setText("Level = " + Clicker.clickPowerLevel + " / 100");
        }
    }

    /**
     * This is where I build the GUI (Frame).
     */
    private void makeFrame()
    {
        JFrame frame = new JFrame("Clicker Game");
        frame.setUndecorated(true);
        JPanel contentPane = (JPanel)frame.getContentPane();
        contentPane.setBorder(new EmptyBorder(1, 60, 1, 60));

        contentPane.setLayout(new BorderLayout(12, 12));

        makeMenuBar(frame);

        //----- Main Panel -----
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1,3));
            //----- Test Panel(ændre navn) -----
            //Bliver indsættet ind i Main Panel, på første "row"
            JPanel firstPanel = new JPanel();
            firstPanel.setLayout(new GridLayout(2, 1));

            //Tilføjer en label og en button til Test Panel
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
                JButton clickerButton = new JButton("Player Click");
                clickerButton.addActionListener(e -> {updateClicks();});
                firstPanel.add(clickerButton);

        //Tilføjer Test Panel ind i Main Panel
        mainPanel.add(firstPanel);

            //----- Second Panel -----
            JPanel secondPanel = new JPanel();
            secondPanel.setLayout(new GridLayout(1,1));

        //Tilføjer Second Panel ind i Main Panel
        mainPanel.add(secondPanel);

            //----- Third Panel -----
            JPanel thirdPanel = new JPanel();
            thirdPanel.setLayout(new GridLayout(1,1));

                //----- Click Power Panel -----
                JPanel clickPowerPanel = new JPanel();
                clickPowerPanel.setLayout(new GridLayout(1,3));

                JButton clickPowerButton = new JButton("Upgrade Click Power");
                clickPowerButton.addActionListener(e -> {updateClickPowerLabel();});
                clickPowerPanel.add(clickPowerButton);

                    //----- Click Power Labels -----
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

            //Tilføjer Third Panel ind i Main Panel
        mainPanel.add(thirdPanel);

        contentPane.add(mainPanel, BorderLayout.CENTER);

        frame.pack();

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    /**
     * Quit function: quit the application.
     */
    private void quit()
    {
        System.exit(0);
    }

    /**
     * Here we make a menu bar, that uses the quit function we made earlier to quit the program.
     * @param frame is used to tell the menu bar when it's called, which frame it's should be on.
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
