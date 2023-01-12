class VehiculeAttentif extends Vehicule {
    VehiculeAttentif(int voie,double x, double vLimite,Autoroute route) {
        super(voie, x, vLimite, route);
    }
    
    public boolean dangerDevant() {
        for (int i = (int) this.x + 1; i < (int) this.x + 20; i++) {
            if (this.route.existeVehicule(this.voie, i) != null) {
                return true;
            }
        }
        return false;
    }
    public void aFondAFond() {
        this.vitesse *= 1.1;
        if (this.vitesse < 0.05) {
            this.vitesse = 0.05;
        } else if (this.vitesse > vLimite) {
            this.vitesse = vLimite;
        }
    }
    public void pasSiVite() {
        this.vitesse *= 0.9;
    }
    public void avance() {
        if (this.dangerDevant()) {
            this.pasSiVite();
        } else {
            aFondAFond();
        }
        super.avance();
    }
}