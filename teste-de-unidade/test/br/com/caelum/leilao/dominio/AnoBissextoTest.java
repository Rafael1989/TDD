package br.com.caelum.leilao.dominio;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AnoBissextoTest {

	@Test
	public void validarSeEhBissexto() {
		AnoBissexto anoBissexto = new AnoBissexto();
		
		boolean ehBissexto = anoBissexto.ehBissexto(2016);
		
		assertTrue(ehBissexto);
		
		boolean ehBissexto2 = anoBissexto.ehBissexto(1004);
		
		assertTrue(ehBissexto2);
		
		boolean ehBissexto3 = anoBissexto.ehBissexto(1280);
		
		assertTrue(ehBissexto3);
		
		boolean ehBissexto4 = anoBissexto.ehBissexto(1632);
		
		assertTrue(ehBissexto4);
		
		boolean ehBissexto5 = anoBissexto.ehBissexto(2000);
		
		assertTrue(ehBissexto5);
		
		boolean ehBissexto6 = anoBissexto.ehBissexto(2001);
		
		assertFalse(ehBissexto6);
		
		boolean ehBissexto7 = anoBissexto.ehBissexto(2002);
		
		assertFalse(ehBissexto7);
		
		boolean ehBissexto8 = anoBissexto.ehBissexto(2003);
		
		assertFalse(ehBissexto8);
		
		boolean ehBissexto9 = anoBissexto.ehBissexto(2009);
		
		assertFalse(ehBissexto9);
		
		boolean ehBissexto10 = anoBissexto.ehBissexto(2010);
		
		assertFalse(ehBissexto10);
	}

}
