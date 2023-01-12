import javax.swing.*;
import java.awt.*;

class PanneauDessin extends JComponent {

    PanneauDessin() {
        super();
        setOpaque(true);
        setBackground(Color.white);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.green);
        g.fillRect(0,0,getWidth(),70);
        g.fillRect(0,110,getWidth(),getHeight()-20*Fenetre.route.nVoies());
        g.setColor(Color.black);
        g.fillRect(0,70,getWidth(),20*Fenetre.route.nVoies());
        g.setColor(Color.white);
        for (int i = 0; i < Fenetre.route.nVoies()-1; i++)
            g.fillRect(0,90+20*i,getWidth(),5);

        g.setColor(Color.red);

        for (int voie = 0; voie < Fenetre.route.nVoies(); voie++)
            for (int i = 0; i < Fenetre.route.longueur(); i++)
                if (Fenetre.route.existeVehicule(voie,i) != null)
                    g.fillRect(i*getWidth()/Fenetre.route.longueur(),80+20*voie,10,6);
    }

}
