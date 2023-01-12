import java.util.Vector;

class Test {
    static Autoroute route;

    public static void main(String args[]) {
        route = new Autoroute(3,1000);
        Fenetre f = new Fenetre(route);

        while (true) {
            // On ajoute de temps en temps des vehicules au debut de la route
            if (Math.random() < Fenetre.debit * route.nVoies()) {
                Vehicule auto = Vehicule.vehiculeAleatoire(route);
                route.ajouteVehicule(Vehicule.vehiculeAleatoire(route));
            }
            // On fait bouger ces vehicules
            Vector<Vehicule> listeAuto = route.listeVehicules();
            for (Vehicule auto:listeAuto)
                auto.avance();
            // On dessine la fenetre
            f.repaint();
            // On attend un peu
            try {
                Thread.sleep(50);
            } catch (Exception e) {};
        }
    }
}