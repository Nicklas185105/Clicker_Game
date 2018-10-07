package clickerGame;

//Importing different packages.
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * This is the class where I build the GUI for the game.
 *
 * @author Nicklas Lydersen
 * @version 1.0.1
 */
public class GUI
{
    //Starting out with importing my other classes
    public Clicker click;

    //This is where I import different things like: JFrame, JButton and etc.
    private JFrame frame;
    private JLabel clicks;

    //Here I'm making my variables
    public boolean frameRunning = false;
    public int totalClicks = 0;

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
    public GUI()
    {
        makeFrame();
        new Clicker();
    }

    /**
     * This is where I update the clicks label.
     */
    private void updateClicks()
    {
        totalClicks += click.playerClicks;
        clicks.setText(Integer.toString(totalClicks));
    }

    /**
     * This is where I build the GUI (Frame).
     */
    public void makeFrame()
    {
        frameRunning = true;
        frame = new JFrame("clickerGame.Clicker Game");
        JPanel contentPane = (JPanel)frame.getContentPane();
        contentPane.setBorder(new EmptyBorder(1, 60, 1, 60));

        contentPane.setLayout(new BorderLayout(12, 12));

        JPanel testPanel = new JPanel();
        testPanel.setLayout(new GridLayout(2, 1));

        clicks = new JLabel("0");
        Font titelFont = clicks.getFont().deriveFont(30f);
        clicks.setFont(titelFont);
        clicks.setHorizontalAlignment(JLabel.CENTER);
        clicks.setVerticalAlignment(JLabel.CENTER);
        testPanel.add(clicks);

        JButton clickerButton = new JButton("Player Click");
        clickerButton.addActionListener(e -> {updateClicks();});
        testPanel.add(clickerButton);

        contentPane.add(testPanel, BorderLayout.CENTER);

        frame.pack();

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setMinimumSize(new Dimension(200,300));
        frame.setLocation(d.width/2 - frame.getWidth()/2, d.height/2 - frame.getHeight()/2);
        frame.setVisible(true);


    }


}
