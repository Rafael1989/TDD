package br.com.caelum.leilao.dominio;

import org.junit.Test;

public class LanceTest {

	@Test(expected=IllegalArgumentException.class)
	public void lanceZeradoDeveRetornarException() {
		Lance lance = new Lance(new Usuario("Feij�"), 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void lanceNegativoDeveRetornarException() {
		new Lance(new Usuario("D�do"), -10);
	}
}
