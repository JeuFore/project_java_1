package test;

import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import application.*;

public class TestMonstre {

	/**
	 * test initial A NE PAS MODIFIER
	 */
	public void test_initial() {
		Monstre m = new Monstre(2, 3);
		boolean b = m.avoirCollision(new Tir(2, 2));
		b = m.avoirTraverse();
		m.evoluer();
		b = m.getEtreMort();
		int x = m.getX();
		int y = m.getY();
	}

	/**
	 * evoluer le monstre et verifie reste dans arene
	 */
	public void test_Evoluer_ResteDansArene() {
		// preparation des donnees
		Monstre m = new Monstre(10, 5);

		// methode testee
		m.evoluer();

		// verifie position du monstre
		assertEquals("Le monstre doit rester dans l'arene", "Monstre(10,4)", m.toString());
	}

	/**
	 * evoluer le monstre et verifie reste de l'arene
	 */
	public void test_Evoluer_HautDeArene() {
		// preparation des donnees
		Monstre m = new Monstre(10, 0);

		// methode testee
		m.evoluer();

		// verifie position du monstre
		assertEquals("Le monstre doit rester dans l'arene", "Monstre(9,0)", m.toString());

		// methode testee
		m.evoluer();

		// verifie que monstre descend
		assertEquals("Le monstre doit rester dans l'arene", "Monstre(9,1)", m.toString());
	}

	/**
	 * evoluer le monstre et verifie reste de l'arene
	 */
	public void test_Evoluer_BasDeArene() {
		// preparation des donnees
		Monstre m = new Monstre(10, 0);

		// methode testee
		for (int i = 0; i < 12; i++) {
			m.evoluer();
		}

		// verifie position du monstre
		assertEquals("Le monstre doit rester dans l'arene", "Monstre(8,10)", m.toString());

		// methode testee
		m.evoluer();

		// verifie que monstre remonte
		assertEquals("Le monstre doit rester dans l'arene", "Monstre(8,9)", m.toString());
	}

	/**
	 * collision avec tir meme cordonnee que monstre
	 */
	public void test_ToucherCollision_AvecTir() {
		// preparation des donnees
		Monstre m = new Monstre(7, 6);

		// methode testee
		boolean res = m.avoirCollision(new Tir(7, 6));

		// verifie collision a true
		assertEquals("La collision doit etre a true", true, res);
	}

	/**
	 * collision avec tir pas meme cordonnee que monstre
	 */
	public void test_Non_ToucherCollision_AvecTir() {
		// preparation des donnees
		Monstre m = new Monstre(5, 2);

		// methode testee
		boolean res = m.avoirCollision(new Tir(2, 2));

		// verifie collision a false
		assertEquals("La collision doit etre a false", false, res);
	}

	/**
	 * collision avec tir null
	 */
	public void test_Collision_SansTir() {
		// preparation des donnees
		Monstre m = new Monstre(6, 5);

		// methode testee
		boolean res = m.avoirCollision(null);

		// verifie collision a false
		assertEquals("La collision doit etre a false", false, res);
	}

	/**
	 * evoluer et monstre pas gagner
	 */
	public void test_Non_AvoirTraverser() {
		// preparation des donnees
		Monstre m = new Monstre(5, 5);

		// methode testee
		boolean res = m.avoirTraverse();

		// verifie que monstre est encore dans arene
		assertEquals("La colision doit etre a false", false, res);
	}

	/**
	 * evoluer et monstre gagne
	 */
	public void test_AvoirTraverser() {
		// preparation des donnees
		Monstre m = new Monstre(0, 1);
		m.evoluer();

		// methode testee
		boolean res = m.avoirTraverse();

		// verifie que monstre est arrive en haut a gauche
		assertEquals("La colision doit etre a false", true, res);
	}

	public void test_toString() {
		// preparation des donnees
		Monstre m = new Monstre(3, 7);

		// methode testee
		String res = m.toString();

		// verifie retour de monstre
		assertEquals("monstre doit retourner Monstre(3,7)", "Monstre(3,7)", res);
	}

	/**
	 * methode de lancement des tests
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestMonstre(), args);
	}

}
