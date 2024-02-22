import carModel.CarModel;
import carModel.Drawable;
import carModel.Vehicle;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class DrawPanel extends JPanel{

    public DrawPanel(int x, int y, namnetärintesåviktigt n) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.pink);
        this.model = new CarModel();
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(model.getVolvo240RepairShop().getImage(), model.getVolvo240RepairShop().getX(),
                model.getVolvo240RepairShop().getY(), null);

        for (Vehicle car: model.getCars()) {
            g.drawImage(car.getImage(), car.getXPosition(), car.getYPosition(), null); // see javadoc for more info on the parameters
        }
    }
}
