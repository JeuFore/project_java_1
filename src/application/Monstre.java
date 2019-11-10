package application;

public class Monstre {

    /**
     * attributs x et y representant les coordonnees du monstre
     */
    private int x, y;

    /**
     * attribut deplacerHaut representant le deplacement du monstre
     */
    private boolean deplacerHaut;

    /**
     * attribut etreMort representant l'etat du monstre
     */
    private boolean etreMort;

    /**
     * constructeur qui cree un monstre
     * 
     * @param px abscisse
     * @param py ordonnee
     */
    public Monstre(int px, int py) {
        if (px <= 10 || py <= 10) {
            this.x = px;
            this.y = py;
        } else {
            this.x = 10;
            this.y = 5;
        }
        this.deplacerHaut = true;
        this.etreMort = false;
    }

    /**
     * retourne la valeur d'etreMort
     * 
     * @return etreMort
     */
    public boolean getEtreMort() {
        return this.etreMort;
    }

    /**
     * retourne la valeur de x
     * 
     * @return x
     */
    public int getX() {
        return this.x;
    }

    /**
     * retourne la valeur de y
     * 
     * @return y
     */
    public int getY() {
        return this.y;
    }

    /**
     * methode qui fait evoluer la position du monstre
     */
    public void evoluer() {
        if (!this.etreMort) {
            if (this.deplacerHaut) {
                this.y--;
            } else {
                this.y++;
            }
            if (this.y < 0) {
                this.x--;
                this.y = 0;
                this.deplacerHaut = false;
            } else if (this.y > 10) {
                this.x--;
                this.y = 10;
                this.deplacerHaut = true;
            }
        }
    }

    /**
     * verifie si monstre en (0,0)
     * 
     * @return boolean
     */
    public boolean avoirTraverse() {
        if ((this.x == 0) && (this.y == 0)) {
            return true;
        }
        return false;
    }

    /**
     * methode verifiant que le tir touche le monstre
     * 
     * @param t type Tir
     * @return boolean
     */
    public boolean avoirCollision(Tir t) {
        if ((t != null) && ((t.getX() == this.x) && (t.getY() == this.y))) {
            this.etreMort = true;
            return true;
        }
        return false;
    }

    /**
     * methode permettant d'afficher la position du monstre
     */
    public String toString() {
        return "Monstre(" + this.x + "," + this.y + ")";
    }
}