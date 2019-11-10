package application;

import java.util.Scanner;

public class JeuShoot {
    /**
     * attribut vaisseau representant la class Vaisseau
     */
    private Vaisseau joueur;

    /**
     * attribut monstre representant les class Monstre
     */
    private Monstre ennemi;

    /**
     * attribut score representant le score du joueur
     */
    private int score;

    /**
     * attribut perdu representant la fin de partie
     */
    private boolean perdu;

    /**
     * constructeur qui cree un vaisseau et un monstre
     */
    public JeuShoot() {
        this.joueur = new Vaisseau(0, 5);
        this.ennemi = new Monstre(10, 5);
        this.score = 0;
        this.perdu = false;
    }

    /**
     * retourne la valeur de joueur
     * 
     * @return joueur
     */
    public Vaisseau getJoueur() {
        return this.joueur;
    }

    /**
     * retourne la valeur d'ennemi
     * 
     * @return ennemi
     */
    public Monstre getEnnemi() {
        return this.ennemi;
    }

    /**
     * retourne la valeur de perdu
     * 
     * @return perdu
     */
    public boolean getPerdu() {
        return this.perdu;
    }

    /**
     * retourne la valeur du score
     * 
     * @return score
     */
    public int getScore() {
        return this.score;
    }

    /**
     * methode permettant de modifier les attributs du monstre
     * 
     * @param m type Monstre
     */
    public void setEnnemi(Monstre m) {
        this.ennemi = new Monstre(m.getX(), m.getY());
    }

    /**
     * methode permettant de modifier les attributs du vaisseau
     * 
     * @param v type Vaisseau
     */
    public void setJoueur(Vaisseau v) {
        this.joueur = new Vaisseau(v.getX(), v.getY());
    }

    /**
     * methode permettant de verifier si le tir a touche monstre
     */
    public void gererCollision() {
        if (ennemi.avoirCollision(joueur.getTirCourant())) {
            this.score++;
            this.ennemi = new Monstre(10, 5);
            joueur.detruireTir();
        }
    }

    /**
     * methode permettant les commandes du joueur et evolue le jeu
     * 
     * @param commmande 8|4|5|6|2|0
     */
    public void evoluer(int commmande) {
        joueur.faireAction(commmande);
        joueur.evoluerTir();
        gererCollision();
        ennemi.evoluer();
        gererCollision();
        this.perdu = ennemi.avoirTraverse();
    }

    /**
     * methode permettant de demander au joueur un chiffre
     * 
     * @return entier
     */
    public int demanderJoueur() {
        Scanner sc = new Scanner(System.in);
        while(!sc.hasNextInt()){
            System.out.println("Veuillez entrer un entier");
            sc.next();
        }
        return (sc.nextInt());
    }

    /**
     * methode permettant de demander une commande et de faire evoluer jeu
     */
    public void poursuivre() {
        evoluer(demanderJoueur());
        System.out.println(toString());
    }

    /**
     * methode permettant d'afficher l'etat du jeu
     */
    public String toString() {
        return (this.joueur.toString() + "\n" + this.ennemi.toString() + "\n" + this.score);
    }

    public static void main(String[] args) {
        JeuShoot j = new JeuShoot();
        while (!j.perdu) {
            j.poursuivre();
        }
        System.out.println("Vous avez perdu !");
    }
}