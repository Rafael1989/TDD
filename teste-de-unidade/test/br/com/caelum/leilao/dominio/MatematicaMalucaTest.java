package br.com.caelum.leilao.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MatematicaMalucaTest {
	
	private MatematicaMaluca matematicaMaluca;

	@Before
	public void setUp() {
		this.matematicaMaluca = new MatematicaMaluca();
	}

	@Test
	public void testaValorMaiorQueTrinta() {
		assertEquals(160, matematicaMaluca.contaMaluca(40));
	}
	
	@Test
	public void testaValorMaiorQueDez() {
		assertEquals(60, matematicaMaluca.contaMaluca(20));
	}
	
	@Test
	public void testaValorMenorQueDez() {
		assertEquals(10, matematicaMaluca.contaMaluca(5));
	}
}
