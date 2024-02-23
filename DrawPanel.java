import carModel.Drawable;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class DrawPanel extends JPanel{

    private ArrayList<Drawable> drawables;

    public DrawPanel(int x, int y, ArrayList<Drawable> drawables) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.pink);
        this.drawables = drawables;
    }

    protected void updateDrawables(ArrayList<Drawable> newDrawables){
        drawables = newDrawables;
    }


    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Drawable drawable: drawables){
            g.drawImage(drawable.getImage(), drawable.getXPosition(),
                    drawable.getYPosition(), null);
        }
    }
}
