class VehiculeRapide extends VehiculeAttentif {
    VehiculeRapide(int voie,double x, double vLimite,Autoroute route) {
        super(voie, x, vLimite, route);
    }

    public void pasSiVite() {
        if (this.voie < this.route.nVoies() - 1) {
            if (this.route.existeVehicule(this.voie + 1, (int) this.x) == null) {
                this.route.enleveVehicule(this);
                this.voie++;
                this.route.ajouteVehicule(this);
            }
        }

        if (this.voie > 0) {
            if (this.route.existeVehicule(this.voie - 1, (int) this.x) == null) {
                this.route.enleveVehicule(this);
                this.voie--;
                this.route.ajouteVehicule(this);
            }
        }
        super.pasSiVite();
    }
}