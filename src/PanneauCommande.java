import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

class PanneauCommande extends JPanel {
    PanneauCommande() {
        super();
        JButton boutonClear = new JButton("Clear");
        boutonClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Mettre le code a executer ici
                Fenetre.route.clear();
            }
        });
        add(boutonClear);

        JButton boutonQuitter = new JButton("Quitter");
        boutonQuitter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Mettre le code a executer ici
                System.exit(1);
            }
        });
        add(boutonQuitter);

        JSlider sliderDebit = new JSlider();
        sliderDebit.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int valueSlider = (int) ((JSlider)e.getSource()).getValue();
                Fenetre.debit = (double) valueSlider / 1000.0;
                System.out.println(Fenetre.debit);
            }
        });
        add(sliderDebit);
    }

    private void close() {

    }

}
