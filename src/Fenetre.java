import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

class Fenetre extends JFrame {
    static double debit = 0.05;
    static Autoroute route;

    Fenetre(Autoroute r) {
        super("Simulation d'autoroute");
        setSize(800,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        route = r;
        getContentPane().add(new PanneauDessin());
        getContentPane().add("South",new PanneauCommande());
        setVisible(true);
    }

}