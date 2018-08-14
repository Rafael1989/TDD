package br.com.caelum.leilao.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PalindromoTest {
	
	@Test
	public void eUmPalindromo() {
		assertTrue(new Palindromo().ehPalindromo("Anotaram a data da maratona"));
		assertTrue(new Palindromo().ehPalindromo("Socorram-me subi no onibus em Marrocos"));
		assertTrue(new Palindromo().ehPalindromo("ovo"));
		assertTrue(new Palindromo().ehPalindromo("Após a sopa"));
		assertTrue(new Palindromo().ehPalindromo("Ana"));
		assertTrue(new Palindromo().ehPalindromo("Luz azul"));
		assertTrue(new Palindromo().ehPalindromo("Ame o poema"));
		assertTrue(new Palindromo().ehPalindromo("Arara"));
		assertTrue(new Palindromo().ehPalindromo("A sacada da casa"));
		assertTrue(new Palindromo().ehPalindromo("Reviver"));
		assertFalse(new Palindromo().ehPalindromo("Rafael"));
	}

}
