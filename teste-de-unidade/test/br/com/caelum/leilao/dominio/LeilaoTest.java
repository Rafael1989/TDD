package br.com.caelum.leilao.dominio;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.Matchers.*;
import static br.com.caelum.leilao.dominio.LeilaoMatcher.temUmLance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LeilaoTest {
	
	private Usuario steveJobs;
	private Usuario billGates;
	
	@Before
	public void setUp() {
		System.out.println("before");
		this.steveJobs = new Usuario("Steve Jobs");
		this.billGates = new Usuario("Bill Gates");
	}
	
	@After
	public void depois() {
		System.out.println("after");
	}
	
	@BeforeClass
	public static void testandoBeforeClass() {
		System.out.println("Before class");
	}
	
	@AfterClass
	public static void testandoAfterClass() {
		System.out.println("after class");
	}

	@Test
	public void naoDeveAceitarDoisLancesEmSequenciaDadosPeloMesmoUsuario() {
		Leilao leilao = new CriadorDeLeilao().para("TV")
				.lance(new Usuario("Steve Jobs"), 200)
				.lance(new Usuario("Steve Jobs"), 300)
				.constroi();
		
		assertEquals(1, leilao.getLances().size());
		assertEquals(200, leilao.getLances().get(0).getValor(),0.00001);
	}
	
	@Test
	public void oMesmoUsuarioNaoPodeDarMaisDoQueCincoLances() {
		Leilao leilao = new CriadorDeLeilao().para("TV")
				.lance(steveJobs, 200)
				.lance(billGates, 300)
				.lance(steveJobs, 400)
                .lance(billGates, 500)
                .lance(steveJobs, 600)
                .lance(billGates, 700)
                .lance(steveJobs, 800)
                .lance(billGates, 900)
                .lance(steveJobs, 1000)
                .lance(billGates, 1100)
                .lance(steveJobs, 1200)
                .constroi();
		
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
		
		leilao.dobraLance(steveJobs);
		
		assertEquals(0, leilao.getLances().size());
		
		leilao.propoe(new Lance(steveJobs, 200));
		leilao.propoe(new Lance(billGates, 300));
		leilao.dobraLance(steveJobs);
		leilao.propoe(new Lance(billGates, 500));
		leilao.propoe(new Lance(steveJobs, 600));
		leilao.propoe(new Lance(billGates, 700));
		leilao.propoe(new Lance(steveJobs, 800));
		leilao.propoe(new Lance(billGates, 900));
		leilao.propoe(new Lance(steveJobs, 1000));
		leilao.propoe(new Lance(billGates, 1100));
		leilao.propoe(new Lance(steveJobs, 1200));
		
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
    public void deveReceberUmLance() {
        Leilao leilao = new CriadorDeLeilao().para("Macbook Pro 15").constroi();
        assertEquals(0, leilao.getLances().size());

        Lance lance = new Lance(new Usuario("Steve Jobs"), 2000);
        leilao.propoe(lance);

        assertThat(leilao.getLances().size(), equalTo(1));
        assertThat(leilao, temUmLance(lance));
    }

}
