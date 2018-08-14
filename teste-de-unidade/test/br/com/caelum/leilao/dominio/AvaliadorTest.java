package br.com.caelum.leilao.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AvaliadorTest {
	
	@Test
	public void validaAvaliacaoDeLeilao() {
		Leilao leilao = new Leilao("Uno preto");
		Usuario usuario = new Usuario("João");
		Lance lance = new Lance(usuario, 400);
		Lance lance2 = new Lance(new Usuario("José"), 300);
		Lance lance3 = new Lance(new Usuario("Manuel"), 200);
		leilao.propoe(lance);
		leilao.propoe(lance2);
		leilao.propoe(lance3);
		
		Avaliador avaliador = new Avaliador();
		avaliador.avalia(leilao);
		
		assertEquals(400, avaliador.getMaiorValor(),0.00001);
		assertEquals(200, avaliador.getMenorValor(),0.00001);
	}
	
	@Test
	public void validaValorMedio() {
		Leilao leilao = new Leilao("Uno preto");
		Usuario usuario = new Usuario("João");
		Lance lance = new Lance(usuario, 400);
		Lance lance2 = new Lance(new Usuario("José"), 300);
		Lance lance3 = new Lance(new Usuario("Manuel"), 200);
		leilao.propoe(lance);
		leilao.propoe(lance2);
		leilao.propoe(lance3);
		
		Avaliador avaliador = new Avaliador();
		
		assertEquals(300, avaliador.getValorMedio(leilao),0.00001);
	}

}
