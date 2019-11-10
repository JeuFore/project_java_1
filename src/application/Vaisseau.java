package application;

public class Vaisseau {

    /**
     * attributs x et y representant les coordonnees du vaisseau
     */
    private int x, y;

    /**
     * attribut representant tir effectue par le vaisseau
     */
    private Tir TirCourant = null;

    /**
     * constructeur avec parametre vide et position vaisseau en (5,5)
     */
    public Vaisseau() {
        this.x = 5;
        this.y = 5;
    }

    /**
     * constructeur qui initialise x et y avec 2 parametres
     * 
     * @param px absisse
     * @param py ordonnee
     */
    public Vaisseau(int px, int py) {
        if (px > 10 || py > 10) {
            this.x = 5;
            this.y = 5;
        } else {
            this.x = px;
            this.y = py;
        }
    }

    /**
     * retourne la valeur de TirCourant
     * 
     * @return TirCourant
     */
    public Tir getTirCourant() {
        return this.TirCourant;
    }

    /**
     * retourne la valeur de x
     * 
     * @return X
     */
    public int getX() {
        return this.x;
    }

    /**
     * retourne la valeur de y
     * 
     * @return Y
     */
    public int getY() {
        return this.y;
    }

    /**
     * methode permettant de deplacer vaisseau
     * 
     * @param dx
     * @param dy
     */
    private void deplacer(int dx, int dy) {
        if ((this.x + dx <= 10) && (this.x + dx) >= 0) {
            this.x = this.x + dx;
        }
        if ((this.y + dy <= 10) && (this.y + dy) >= 0) {
            this.y = this.y + dy;
        }
    }

    /**
     * methode qui cree un tir aux memes coordonnees du vaisseau
     */
    public void tirer() {
        if (this.TirCourant == null) {
            this.TirCourant = new Tir(this.x, this.y);
        }
    }

    /**
     * methode representant les commandes du joueur
     * 
     * @param commande 8|4|5|6|2|0
     */
    public void faireAction(int commande) {
        switch (commande) {
        case 4:
            deplacer(-1, 0);
            break;
        case 6:
            deplacer(1, 0);
            break;
        case 8:
            deplacer(0, -1);
            break;
        case 2:
            deplacer(0, 1);
            break;
        case 5:
            tirer();
            break;
        }
    }

    /**
     * methode permettant la destruction du tir
     */
    public void detruireTir() {
        this.TirCourant = null;
    }

    /**
     * methode faisant evoluer le tir du vaisseau
     */
    public void evoluerTir() {
        if (this.TirCourant != null && TirCourant.evoluer()) {
            detruireTir();
        }
    }

    /**
     * methode d'afficher la position du vaisseau et du tir
     */
    public String toString() {
        if (this.TirCourant == null) {
            return ("Vaisseau(" + this.x + "," + this.y + ")");
        }
        return ("Vaisseau(" + this.x + "," + this.y + ")-" + TirCourant.toString());
    }
}