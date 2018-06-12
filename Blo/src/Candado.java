import java.awt.*;
import javax.swing.*;
import javax.xml.bind.JAXBPermission;
import java.awt.*;
import java.awt.event.*;

public class Candado extends JPanel {



    public Candado() {

        this.setPreferredSize(new Dimension(800, 400));
    }


    protected void paintComponent(Graphics g) {


        g.setColor(Color.BLACK);
        g.fillArc(200, 120, 80, 100, 0, 180);


        g.setColor(Color.white);

        g.fillArc(210, 125, 60, 90, 0, 180);


        g.setColor(Color.BLACK);
        g.fillRect(190, 171, 100, 100);


    }

}

