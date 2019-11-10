package test;

import libtest.*;
import application.*;
import static libtest.Lanceur.*;
import static libtest.OutilTest.*;

public class TestJeuShoot {

	/**
	 * test initial A NE PAS MODIFIER
	 */
	public void test_initial() {
		JeuShoot j = new JeuShoot();
		Monstre monstre = j.getEnnemi();
		Vaisseau v = j.getJoueur();
		int s = j.getScore();
		boolean b = j.getPerdu();
		j.evoluer(0);
		j.setEnnemi(new Monstre(2, 2));
		j.setJoueur(new Vaisseau(2, 2));
		assertEquals("score nul au depart", s, 0);
	}

	/**
	 * creation du jeu avec les differentes classes
	 */
	public void test_CreationJeu() {
		// preparation des donnees
		JeuShoot j = new JeuShoot();

		// methode testee
		Vaisseau v = j.getJoueur();
		Monstre m = j.getEnnemi();
		int s = j.getScore();
		boolean p = j.getPerdu();

		// verifie valeurs des attributs
		assertEquals("vaisseau devrait etre en (0,5)", "Vaisseau(0,5)", v.toString());
		assertEquals("monstre devrait etre en (10,5)", "Monstre(10,5)", m.toString());
		assertEquals("score nul au depart", 0, s);
		assertEquals("perdu est a false", false, p);
	}

	/**
	 * evoluer commande avec creation tir
	 */
	public void test_EvoluerCommande_SansTir() {
		// preparation des donnes
		JeuShoot j = new JeuShoot();

		// methode testee
		j.evoluer(0);
		Vaisseau v = j.getJoueur();
		Monstre m = j.getEnnemi();
		boolean p = j.getPerdu();

		// verifie position vaisseau et tir
		assertEquals("vaisseau devrait etre en (0,5)", "Vaisseau(0,5)", v.toString());

		// verifie position monstre
		assertEquals("monstre devrait etre en (10,4)", "Monstre(10,4)", m.toString());

		// verifie perdu a false
		assertEquals("perdu devrait etre a false", false, p);
	}

	/**
	 * evoluer commande avec creation tir
	 */
	public void test_EvoluerCommande_Tir() {
		// preparation des donnes
		JeuShoot j = new JeuShoot();

		// methode testee
		j.evoluer(5);
		Vaisseau v = j.getJoueur();
		Monstre m = j.getEnnemi();
		boolean p = j.getPerdu();

		// verifie position vaisseau et tir
		assertEquals("vaisseau devrait etre en (0,5) et tir en (1,5)", "Vaisseau(0,5)-T(1,5)", v.toString());

		// verifie position monstre
		assertEquals("monstre devrait etre en (10,4)", "Monstre(10,4)", m.toString());

		// verifie perdu a false
		assertEquals("perdu devrait etre a false", false, p);
	}

	/**
	 * evoluer tir et collision entre tir et monstre
	 */
	public void test_Collision() {
		// preparation des donnes
		JeuShoot j = new JeuShoot();

		// methode testee
		j.setJoueur(new Vaisseau(7, 3));
		j.setEnnemi(new Monstre(8, 4));
		j.evoluer(5);
		Vaisseau v = j.getJoueur();
		Monstre m = j.getEnnemi();
		int s = j.getScore();

		// verifie position vaisseau
		assertEquals("vaisseau devrait etre en (7,3)", "Vaisseau(7,3)", v.toString());

		// verifie position monstre
		assertEquals("monstre devrait etre en (10,5)", "Monstre(10,5)", m.toString());

		// verifie score a 1
		assertEquals("score devrait etre de 1", 1, s);
	}

	/**
	 * evoluer et monstre traverse jeu
	 */
	public void test_Monstre_Traverser() {
		// preparation des donnees
		JeuShoot j = new JeuShoot();

		// methode testee
		j.setJoueur(new Vaisseau(4, 1));
		j.setEnnemi(new Monstre(0, 1));
		j.evoluer(0);
		Vaisseau v = j.getJoueur();
		Monstre m = j.getEnnemi();
		boolean p = j.getPerdu();

		// verifie position vaisseau
		assertEquals("vaisseau devrait etre en (4,1)", "Vaisseau(4,1)", v.toString());

		// verifie position monstre
		assertEquals("monstre devrait etre en (0,0)", "Monstre(0,0)", m.toString());

		// verifie que perdu a true
		assertEquals("perdu devrait etre true", true, p);
	}

	/**
	 * methode de lancement des tests
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestJeuShoot(), args);
	}

}