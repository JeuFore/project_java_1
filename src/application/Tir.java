package application;

public class Tir {

    /**
     * attributs x et y representant les coordonnees du tir
     */
    private int x, y;

    /**
     * initialisation des coordonnees du tir
     * 
     * @param px abscisse
     * @param py ordonnee
     */
    public Tir(int px, int py) {
        this.x = px;
        this.y = py;
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
     * methode permettant d'avancer le tir et de verifier s'il sort de l'arene
     * 
     * @return boolean
     */
    public boolean evoluer() {
        this.x++;
        if (this.x > 10) {
            return true;
        }
        return false;
    }

    /**
     * methode permettant de retourner la position du tir
     * 
     * @return T(x,y)
     */
    public String toString() {
        return ("T(" + this.x + "," + this.y + ")");
    }
}