package clickerGame;

import javax.swing.*;

public class JButtonAllign extends JButton {
        JButtonAllign(String param) { super(param); }

        @Override
        public void doLayout()
        {
            super.doLayout();

            int preferredWidth = getPreferredSize().width;
            int actualWidth = getSize().width;

            if (actualWidth != preferredWidth)
            {
                int gap = getIconTextGap() + actualWidth - preferredWidth;
                gap = Math.max(gap, UIManager.getInt("Button.iconTextGap"));
                setIconTextGap(gap);
            }
        }

}
