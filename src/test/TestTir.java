package test;

import application.*;
import static libtest.Lanceur.*;
import static libtest.OutilTest.*;

public class TestTir {

	/**
	 * test initial pour verifier le bon appel des methodes
	 */
	public void test_initial() {
		Tir t = new Tir(5, 6);
		assertEquals("test X", 5, t.getX());
		assertEquals("test Y", 6, t.getY());
		t.evoluer();
		t.toString();
	}

	/**
	 * evoluer quand le tir reste dans l'arene
	 */
	public void test_Evoluer_ResteDansArene() {
		// preparation des donnees
		Tir t = new Tir(6, 5);

		// methode testee
		boolean res = t.evoluer();

		// verifie retour false
		assertEquals("tir devrait rester dans arene", false, res);
		// verifie position apres evolution
		assertEquals("tir devrait evoluer en X", 7, t.getX());
		assertEquals("tir devrait rester en Y", 5, t.getY());
	}

	/**
	 * evoluer quand le tir sort de l'arene
	 */
	public void test_Evoluer_SortirArene() {
		// preparation des donnees
		Tir t = new Tir(10, 5);

		// methode testee
		boolean res = t.evoluer();

		// verifie retour true car sortie de l arene
		assertEquals("tir devrait sortir de l'arene", true, res);
		// verifie position apres evolution
		assertEquals("tir devrait evoluer en X", 11, t.getX());
		assertEquals("tir devrait rester en Y", 5, t.getY());
	}

	/**
	 * retour des coordonnees du tir
	 */
	public void test_toString(){
		// preparation des donnees
		Tir t = new Tir(7,5);

		// methode testee
		String res = t.toString();

		// verifie que Tir est en (7,5)
		assertEquals("tir devrait etre T(7,5)", "T(7,5)", res);
	}

	/**
	 * methode de lancement des tests
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestTir(), args);
	}

}