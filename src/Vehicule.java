public class Vehicule {
    protected int voie;
    protected double x;
    protected double vitesse;
    protected final double vLimite;
    protected Autoroute route;

    public Vehicule(int voie, double x, double vLimite, Autoroute route) {
        this.voie = voie;
        this.x = x;
        this.vitesse = vLimite;
        this.vLimite = vLimite;
        this.route = route;
    }

    public int getVoie() {
        return this.voie;
    }

    public double getX() {
        return this.x;
    }

    static Vehicule vehiculeAleatoire(Autoroute route) {
        int voieAleatoire = (int) (Math.random() * route.nVoies());
        double vitesseAleatoire = 0.5 + 0.3*Math.random();
        if (Math.random() > 0.5) {
            return new VehiculeAttentif(voieAleatoire, 0, vitesseAleatoire, route);
        } else {
            return new VehiculeRapide(voieAleatoire, 0, vitesseAleatoire, route);
        }

    }

    public void avance() {
        this.route.enleveVehicule(this);
        this.x += this.vitesse;
        this.route.ajouteVehicule(this);
    }

    @Override
    public String toString() {
        return "Voiture en (" + this.voie + ", " + this.x + ")";
    }
}
