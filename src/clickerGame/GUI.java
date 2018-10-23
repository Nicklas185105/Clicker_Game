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
        makeFrame();
        new clickerGame.Clicker();
    }

    /**
     * This is where I update the clicks label.
     */
    private void updateClicks()
    {
        totalClicks += clickerGame.Clicker.playerClicks;
        clicks.setText(Integer.toString(totalClicks));
    }

    /**
     * This is where I build the GUI (Frame).
     */
    private void makeFrame()
    {
        JFrame frame = new JFrame("clickerGame.Clicker Game");
        JPanel contentPane = (JPanel)frame.getContentPane();
        contentPane.setBorder(new EmptyBorder(1, 60, 1, 60));

        contentPane.setLayout(new BorderLayout(12, 12));

        makeMenuBar(frame);

        //----- Main Panel -----
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1,3));
            //----- Test Panel(ændre navn) -----
                //Bliver indsættet ind i Main Panel, på første "row"
        JPanel testPanel = new JPanel();
        testPanel.setLayout(new GridLayout(2, 1));

            //Tilføjer en label og en button til Test Panel
        clicks = new JLabel("0");
        Font titelFont = clicks.getFont().deriveFont(30f);
        clicks.setFont(titelFont);
        clicks.setHorizontalAlignment(JLabel.CENTER);
        clicks.setVerticalAlignment(JLabel.CENTER);
        testPanel.add(clicks);

        JButton clickerButton = new JButton("Player Click");
        clickerButton.addActionListener(e -> {updateClicks();});
        testPanel.add(clickerButton);

        //Tilføjer Test Panel ind i Main Panel
        mainPanel.add(testPanel);

            //----- Second Panel -----
        JPanel secondPanel = new JPanel();
        secondPanel.setLayout(new GridLayout(1,1));
        //Tilføjer Second Panel ind i Main Panel
        mainPanel.add(secondPanel);

            //----- Third Panel -----
        JPanel thirdPanel = new JPanel();
        thirdPanel.setLayout(new GridLayout(1,1));
        //Tilføjer Third Panel ind i Main Panel
        mainPanel.add(thirdPanel);

        contentPane.add(mainPanel, BorderLayout.CENTER);

        frame.pack();

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setMinimumSize(new Dimension(1500,790));
        frame.setLocation(d.width/2 - frame.getWidth()/2, d.height/2 - frame.getHeight()/2);
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
