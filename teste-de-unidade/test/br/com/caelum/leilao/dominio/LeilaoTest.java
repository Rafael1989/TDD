package br.com.caelum.leilao.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeilaoTest {
	
	@Test
	public void naoDeveAceitarDoisLancesEmSequenciaDadosPeloMesmoUsuario() {
		Leilao leilao = new Leilao("TV");
		
		leilao.propoe(new Lance(new Usuario("Bill gates"), 200));
		leilao.propoe(new Lance(new Usuario("Bill gates"), 300));
		
		assertEquals(1, leilao.getLances().size());
		assertEquals(200, leilao.getLances().get(0).getValor(),0.00001);
	}
	
	@Test
	public void oMesmoUsuarioNaoPodeDarMaisDoQueCincoLances() {
		Leilao leilao = new Leilao("Bola");
		
		leilao.propoe(new Lance(new Usuario("B1"),200));
		leilao.propoe(new Lance(new Usuario("B2"),300));
		leilao.propoe(new Lance(new Usuario("B1"),400));
		leilao.propoe(new Lance(new Usuario("B2"),500));
		leilao.propoe(new Lance(new Usuario("B1"),600));
		leilao.propoe(new Lance(new Usuario("B2"),700));
		leilao.propoe(new Lance(new Usuario("B1"),800));
		leilao.propoe(new Lance(new Usuario("B2"),900));
		leilao.propoe(new Lance(new Usuario("B1"),1000));
		leilao.propoe(new Lance(new Usuario("B2"),1100));
		leilao.propoe(new Lance(new Usuario("B1"),1200));
		
		assertEquals(10, leilao.getLances().size());
		assertEquals(200, leilao.getLances().get(0).getValor(),0.00001);
		assertEquals(300, leilao.getLances().get(1).getValor(),0.00001);
		assertEquals(400, leilao.getLances().get(2).getValor(),0.00001);
		assertEquals(500, leilao.getLances().get(3).getValor(),0.00001);
		assertEquals(600, leilao.getLances().get(4).getValor(),0.00001);
		assertEquals(700, leilao.getLances().get(5).getValor(),0.00001);
		assertEquals(800, leilao.getLances().get(6).getValor(),0.00001);
		assertEquals(900, leilao.getLances().get(7).getValor(),0.00001);
		assertEquals(1000, leilao.getLances().get(8).getValor(),0.00001);
		assertEquals(1100, leilao.getLances().get(9).getValor(),0.00001);
	}
	
	@Test
	public void deveDobrarOLance() {
		Leilao leilao = new Leilao("TV");
		
		leilao.dobraLance(new Usuario("José"));
		
		assertEquals(0, leilao.getLances().size());
		
		leilao.propoe(new Lance(new Usuario("José"), 200));
		leilao.propoe(new Lance(new Usuario("João"), 300));
		leilao.dobraLance(new Usuario("José"));
		leilao.propoe(new Lance(new Usuario("João"), 500));
		leilao.propoe(new Lance(new Usuario("José"), 600));
		leilao.propoe(new Lance(new Usuario("João"), 700));
		leilao.propoe(new Lance(new Usuario("José"), 800));
		leilao.propoe(new Lance(new Usuario("João"), 900));
		leilao.propoe(new Lance(new Usuario("José"), 1000));
		leilao.propoe(new Lance(new Usuario("João"), 1100));
		leilao.propoe(new Lance(new Usuario("José"), 1200));
		
		assertEquals(10, leilao.getLances().size());
		assertEquals(200, leilao.getLances().get(0).getValor(),0.00001);
		assertEquals(300, leilao.getLances().get(1).getValor(),0.00001);
		assertEquals(400, leilao.getLances().get(2).getValor(),0.00001);
		assertEquals(500, leilao.getLances().get(3).getValor(),0.00001);
		assertEquals(600, leilao.getLances().get(4).getValor(),0.00001);
		assertEquals(700, leilao.getLances().get(5).getValor(),0.00001);
		assertEquals(800, leilao.getLances().get(6).getValor(),0.00001);
		assertEquals(900, leilao.getLances().get(7).getValor(),0.00001);
		assertEquals(1000, leilao.getLances().get(8).getValor(),0.00001);
		assertEquals(1100, leilao.getLances().get(9).getValor(),0.00001);
	}

}
