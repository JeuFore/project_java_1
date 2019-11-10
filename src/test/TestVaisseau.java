package test;

import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import application.*;

public class TestVaisseau {

	/**
	 * test initial A NE PAS MODIFIER
	 */
	public void test_initial() {
		Vaisseau v = new Vaisseau();
		v = new Vaisseau(1, 2);
		v.evoluerTir();
		v.faireAction(0);
		Tir t = v.getTirCourant();
		v.getX();
		v.getY();
		v.tirer();
	}

	/**
	 * vaisseau initialise dans l'arene
	 */
	public void test_Vaisseau_Creation_Dans_Arene() {
		// preparation des donnees
		Vaisseau v = new Vaisseau(5, 4);

		// verifie position du vaiseau
		assertEquals("vaisseau devrait rester dans arene", 5, v.getX());
		assertEquals("vaisseau devrait rester dans arene", 4, v.getY());
	}

	/**
	 * vaisseau initialise hors de l'arene
	 */
	public void test_Vaisseau_Creation_Hors_Arene() {
		// preparation des donnees
		Vaisseau v = new Vaisseau(2, 12);

		// verifie position du vaiseau
		assertEquals("vaisseau devrait rester dans arene", 5, v.getX());
		assertEquals("vaisseau devrait rester dans arene", 5, v.getY());
	}

	/**
	 * retour du tir vaisseau
	 */
	public void test_Tir_Vaisseau() {
		// preparation des donnees
		Vaisseau v = new Vaisseau(3, 8);

		// methode testee
		v.tirer();

		// verifie valeur de tirCourant
		assertEquals("tirCourant doit etre (3,8)", "T(3,8)", v.getTirCourant().toString());
	}

	/**
	 * detruire le tir actuel
	 */
	public void test_DetruireTir() {
		// preparation des donnees
		Vaisseau v = new Vaisseau();
		v.tirer();

		// methode testee
		v.detruireTir();

		// verifie que TirCourant est null
		assertEquals("tirCourant doit etre null", null, v.getTirCourant());
	}

	/**
	 * evoluer quand le tir est dans l'arene
	 */
	public void test_EvoluerTirResteArene() {
		// preparation des donnees
		Vaisseau v = new Vaisseau();
		v.tirer();

		// methode testee
		v.evoluerTir();

		// verifie que le tir est au coordonne voulus
		assertEquals("le tir doit etre en (6,5)", "T(6,5)", v.getTirCourant().toString());
	}

	/**
	 * evoluer quand le tir sort de l'arene
	 */
	public void test_EvoluerTirSortArene() {
		// preparation des donnees
		Vaisseau v = new Vaisseau(9, 5);
		v.tirer();

		// methode testee
		v.evoluerTir();
		v.evoluerTir();

		// verifie que le TirCourant est null
		assertEquals("le TirCourant doit etre null", null, v.getTirCourant());
	}

	/**
	 * cree un tir alors que deja existant
	 */
	public void test_Creation_Tir_Existant() {
		// preparation des données
		Vaisseau v = new Vaisseau(4, 6);
		v.tirer();
		v.evoluerTir();
		v.evoluerTir();

		// methode testee
		v.tirer();

		// verifie que le tir actuel a garder ses coordonnees
		assertEquals("le tir doit etre en (6,6)", "T(6,6)", v.getTirCourant().toString());

	}

	/**
	 * effectue la commande haut
	 */
	public void test_Commande_Haut() {
		// preparation des donnees
		Vaisseau v = new Vaisseau();

		// methode testee
		v.faireAction(8);

		// verifie position monstre
		assertEquals("le vaisseau doit etre en (5,4)", "Vaisseau(5,4)", v.toString());
	}

	/**
	 * effectue la commande haut
	 */
	public void test_Commande_Bas() {
		// preparation des donnees
		Vaisseau v = new Vaisseau();

		// methode testee
		v.faireAction(2);

		// verifie position monstre
		assertEquals("le vaisseau doit etre en (5,6)", "Vaisseau(5,6)", v.toString());
	}

	/**
	 * effectue la commande haut
	 */
	public void test_Commande_Gauche() {
		// preparation des donnees
		Vaisseau v = new Vaisseau();

		// methode testee
		v.faireAction(4);

		// verifie position monstre
		assertEquals("le vaisseau doit etre en (4,5)", "Vaisseau(4,5)", v.toString());
	}

	/**
	 * effectue la commande haut
	 */
	public void test_Commande_Droite() {
		// preparation des donnees
		Vaisseau v = new Vaisseau();

		// methode testee
		v.faireAction(6);

		// verifie position monstre
		assertEquals("le vaisseau doit etre en (6,5)", "Vaisseau(6,5)", v.toString());
	}

	/**
	 * effectue la commande haut
	 */
	public void test_Commande_Rien() {
		// preparation des donnees
		Vaisseau v = new Vaisseau();

		// methode testee
		v.faireAction(0);

		// verifie position monstre
		assertEquals("le vaisseau doit etre en (5,5)", "Vaisseau(5,5)", v.toString());
	}

	/**
	 * effectue la commande haut
	 */
	public void test_Commande_Tir() {
		// preparation des donnees
		Vaisseau v = new Vaisseau();

		// methode testee
		v.faireAction(5);

		// verifie position monstre
		assertEquals("le vaisseau et tir doivent etre en (5,5)", "Vaisseau(5,5)-T(5,5)", v.toString());
	}

	/**
	 * commande du vaisseau sort de l'arene
	 */
	public void test_Commande_VaisseauSortArene() {
		// preparation des donnees
		Vaisseau v = new Vaisseau(0, 0);

		// methode testee
		v.faireAction(4);

		// verifie coordonnee du vaisseau
		assertEquals("le vaisseau doit etre en (0,0)", "Vaisseau(0,0)", v.toString());
	}

	/**
	 * verifie bon fonctionnement du toString sans tir
	 */
	public void test_toString_sansTir() {
		// preparation des donnees
		Vaisseau v = new Vaisseau();

		// methode testee
		String res = v.toString();

		// verifie coordonnee de vaisseau
		assertEquals("le vaisseau doit etre en (5,5)", "Vaisseau(5,5)", res);
	}

	/**
	 * verifie bon fonctionnement du toString sans tir
	 */
	public void test_toString_avecTir() {
		// preparation des donnees
		Vaisseau v = new Vaisseau();
		v.tirer();

		// methode testee
		String res = v.toString();

		// verifie que vaisseau et tir existe
		assertEquals("vaisseau et tir doivent etre en (5,5)", "Vaisseau(5,5)-T(5,5)", res);
	}

	/**
	 * methode de lancement des tests
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestVaisseau(), args);
	}

}