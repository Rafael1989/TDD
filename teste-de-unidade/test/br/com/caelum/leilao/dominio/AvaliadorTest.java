package br.com.caelum.leilao.dominio;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.*;

public class AvaliadorTest {
	
	private Avaliador avaliador;
	private Usuario joao;
	private Usuario jose;
	private Usuario maria;

	@Before
	public void setUp() {
		this.avaliador = new Avaliador();
		this.joao = new Usuario("João");
		this.jose = new Usuario("José");
		this.maria = new Usuario("Maria");
		System.out.println("início");
	}
	
	@After
	public void finaliza() {
		System.out.println("fim");
	}
	
	@Test
	public void validaAvaliacaoDeLeilaoOrdemCrescente() {
		
		Leilao leilao = new CriadorDeLeilao()
				.para("Playstation")
				.lance(joao, 250)
				.lance(jose, 300)
				.lance(maria, 400)
				.constroi();
		
		avaliador.avalia(leilao);
		
		assertThat(avaliador.getMaiorLance(), equalTo(400.0));
		assertThat(avaliador.getMenorLance(), equalTo(250.0));
	}
	
	@Test
	public void validaValorMedio() {
		Leilao leilao = new Leilao("Uno preto");
		Lance lance = new Lance(joao, 400);
		Lance lance2 = new Lance(jose, 300);
		Lance lance3 = new Lance(maria, 200);
		leilao.propoe(lance);
		leilao.propoe(lance2);
		leilao.propoe(lance3);
		
		assertThat(avaliador.getValorMedio(leilao), equalTo(300.0));
	}
	
	@Test
	public void validaAvaliacaoComUmLance() {
		Leilao leilao = new CriadorDeLeilao()
				.para("video game")
				.lance(joao, 1000)
				.constroi();
		
		avaliador.avalia(leilao);
		
		assertEquals(1000, avaliador.getMaiorLance(),0.00001);
		assertEquals(1000, avaliador.getMenorLance(),0.00001);
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
		
		avaliador.avalia(leilao);
		
		assertEquals(400, avaliador.getMaiorLance(),0.00001);
		assertEquals(100, avaliador.getMenorLance(),0.00001);
	}
	
	@Test
	public void validaLeilaoComCincoLancesDeveEncontrarOsTresMaiores() {
		Leilao leilao = new CriadorDeLeilao()
				.para("Video game")
				.lance(joao, 100)
				.lance(maria, 200)
				.lance(jose, 300)
				.lance(maria, 400)
				.constroi();
		
		avaliador.avalia(leilao);
		
		List<Lance> tresMaiores = avaliador.getTresMaiores();
		assertEquals(3, tresMaiores.size());

		assertThat(tresMaiores, hasItems(
				new Lance(maria, 400),
				new Lance(jose, 300),
				new Lance(maria, 200)
		));
	}
	
	@Test
	public void validaLeilaoComDoisLancesDeveRetornarDoisLances() {
		Leilao leilao = new Leilao("Bolsa");
		
		leilao.propoe(new Lance(new Usuario("José"), 200));
		leilao.propoe(new Lance(new Usuario("João"), 300));
		
		avaliador.avalia(leilao);
		
		assertEquals(2, avaliador.getTresMaiores().size());
		assertEquals(300, avaliador.getTresMaiores().get(0).getValor(),0.00001);
		assertEquals(200, avaliador.getTresMaiores().get(1).getValor(),0.00001);
	}
	
	@Test(expected=RuntimeException.class)
	public void validaLeilaoSemLanceDeveRetornarListaVazia() {
		Leilao leilao = new Leilao("Açúcar");
		
		avaliador.avalia(leilao);
		
		assertEquals(0, avaliador.getTresMaiores().size());
	}
	
	@Test(expected=RuntimeException.class)
	public void leilaoSemLanceDeveSoltaException() {
		Avaliador avaliador = new Avaliador();
		avaliador.avalia(new Leilao("meia"));
	}

}
