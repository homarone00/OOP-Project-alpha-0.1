package Project_take1.graphics;

import javax.swing.*;
import java.awt.*;

public class TransparentPanel extends JPanel {
    public TransparentPanel(Dimension preferredSize) {
        super();
        setOpaque(false);
        setPreferredSize(preferredSize);
    }
}
