import java.util.Arrays;
import java.util.Vector;

public class Autoroute {
    private Vehicule[][] route;

    public Autoroute(int nVoies, int longueur) {
        this.route = new Vehicule[nVoies][longueur];
        }

    public int nVoies() {
        return route.length;
    }
    public int longueur() {
        return route[0].length;
    }

    public boolean coordonneesValide(int nVoie, int x) {
        return (0 <= nVoie && nVoie < this.nVoies()) && (0 <= x && x < this.longueur());
    }

    public Vehicule existeVehicule(int nVoie, int x) {
        if (!(coordonneesValide(nVoie, x))) {
            return null;
        }
        return this.route[nVoie][x];
    }

    public void enleveVehicule(Vehicule auto) {
        int nVoie = auto.getVoie();
        int x = (int) auto.getX();
        if (this.existeVehicule(nVoie, x) != null) {
            this.route[nVoie][x] = null;
        }
    }

    public void ajouteVehicule(Vehicule auto) {
        int nVoie = auto.getVoie();
        int x = (int) auto.getX();
        if (coordonneesValide(nVoie, x)) {
            this.route[nVoie][x] = auto;
        }
    }
    public Vector<Vehicule> listeVehicules() {
        Vector<Vehicule> listeVehicules = new Vector<>();;
        for (int i = 0; i < this.nVoies(); i++) {
            for (int j = 0; j < this.longueur(); j++) {
                Vehicule vehiculeExistant = this.existeVehicule(i, j);
                if (vehiculeExistant != null) {
                    listeVehicules.addElement(vehiculeExistant);
                }
            }
        }
        return listeVehicules;
    }

    public void clear() {
        int nVoies = this.nVoies();
        int longueur = this.longueur();
        this.route = new Vehicule[nVoies][longueur];
    }
}