package br.com.caelum.leilao.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AvaliadorTest {
	
	@Test
	public void validaAvaliacaoDeLeilaoOrdemCrescente() {
		Leilao leilao = new Leilao("Uno preto");
		Usuario usuario = new Usuario("João");
		Lance lance3 = new Lance(new Usuario("Manuel"), 200);
		Lance lance2 = new Lance(new Usuario("José"), 300);
		Lance lance = new Lance(usuario, 400);
		leilao.propoe(lance3);
		leilao.propoe(lance2);
		leilao.propoe(lance);
		
		Avaliador avaliador = new Avaliador();
		avaliador.avalia(leilao);
		
		assertEquals(400, avaliador.getMaiorLance(),0.00001);
		assertEquals(200, avaliador.getMenorLance(),0.00001);
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
	
	@Test
	public void validaAvaliacaoComUmLance() {
		Leilao leilao = new Leilao("Bicicreta hehehe");
		
		leilao.propoe(new Lance(new Usuario("Penelope charmosa"), 430));
		
		Avaliador avaliador = new Avaliador();
		avaliador.avalia(leilao);
		
		assertEquals(430, avaliador.getMaiorLance(),0.00001);
		assertEquals(430, avaliador.getMenorLance(),0.00001);
	}
	
	@Test
	public void validaLeilaoComLancesAleatorios() {
		Leilao leilao = new Leilao("Maluco");
		
		leilao.propoe(new Lance(new Usuario("Roberto Carlos"), 200));
		leilao.propoe(new Lance(new Usuario("Oséias"), 450));
		leilao.propoe(new Lance(new Usuario("Paulo nunes"), 120));
		leilao.propoe(new Lance(new Usuario("Arce"), 700));
		leilao.propoe(new Lance(new Usuario("Djalminha"), 630));
		leilao.propoe(new Lance(new Usuario("Rivaldo"), 230));
		
		Avaliador avaliador = new Avaliador();
		avaliador.avalia(leilao);
		
		assertEquals(700, avaliador.getMaiorLance(),0.00001);
		assertEquals(120, avaliador.getMenorLance(),0.00001);
	}
	
	@Test
	public void validaLeilaoComLanceEmOrdemDescrescente() {
		Leilao leilao = new Leilao("Sabão crácrá");
		
		leilao.propoe(new Lance(new Usuario("Ursinho carinhoso vermelho"), 400));
		leilao.propoe(new Lance(new Usuario("Ursinho carinhoso azul"), 300));
		leilao.propoe(new Lance(new Usuario("Ursinho carinhoso verde"), 200));
		leilao.propoe(new Lance(new Usuario("Ursinho carinhoso amarelo"), 100));
		
		Avaliador avaliador = new Avaliador();
		avaliador.avalia(leilao);
		
		assertEquals(400, avaliador.getMaiorLance(),0.00001);
		assertEquals(100, avaliador.getMenorLance(),0.00001);
	}
	
	@Test
	public void validaLeilaoComCincoLancesDeveEncontrarOsTresMaiores() {
		Leilao leilao = new Leilao("Ferrari");
		
		leilao.propoe(new Lance(new Usuario("Neymar"), 300));
		leilao.propoe(new Lance(new Usuario("Pelé"), 400));
		leilao.propoe(new Lance(new Usuario("Rincon"), 200));
		leilao.propoe(new Lance(new Usuario("Jair"), 500));
		leilao.propoe(new Lance(new Usuario("Gilson"), 600));
		
		Avaliador avaliador = new Avaliador();
		avaliador.avalia(leilao);
		
		assertEquals(3, avaliador.getTresMaiores().size());
		assertEquals(avaliador.getTresMaiores().get(0).getValor(), 600,0.00001);
		assertEquals(avaliador.getTresMaiores().get(1).getValor(), 500,0.00001);
		assertEquals(avaliador.getTresMaiores().get(2).getValor(), 400,0.00001);
	}
	
	@Test
	public void validaLeilaoComDoisLancesDeveRetornarDoisLances() {
		Leilao leilao = new Leilao("Bolsa");
		
		leilao.propoe(new Lance(new Usuario("José"), 200));
		leilao.propoe(new Lance(new Usuario("João"), 300));
		
		Avaliador avaliador = new Avaliador();
		avaliador.avalia(leilao);
		
		assertEquals(2, avaliador.getTresMaiores().size());
		assertEquals(300, avaliador.getTresMaiores().get(0).getValor(),0.00001);
		assertEquals(200, avaliador.getTresMaiores().get(1).getValor(),0.00001);
	}
	
	@Test
	public void validaLeilaoSemLanceDeveRetornarListaVazia() {
		Leilao leilao = new Leilao("Açúcar");
		
		Avaliador avaliador = new Avaliador();
		avaliador.avalia(leilao);
		
		assertEquals(0, avaliador.getTresMaiores().size());
	}

}
