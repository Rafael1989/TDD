package br.com.caelum.leilao.dominio;

public class Avaliador {
	
	private double maiorValor = Double.NEGATIVE_INFINITY;
	private double menorValor = Double.POSITIVE_INFINITY;
	private double valorTotal = 0;

	public void avalia(Leilao leilao) {
		for(Lance lance : leilao.getLances()) {
			if(lance.getValor() > maiorValor)maiorValor = lance.getValor();
			if(lance.getValor() < menorValor)menorValor = lance.getValor();
		}
	}
	
	public double getValorMedio(Leilao leilao) {
		for(Lance lance : leilao.getLances()) {
			valorTotal  += lance.getValor();
		}
		return valorTotal / leilao.getLances().size();
	}
	
	public double getMaiorValor() {
		return maiorValor;
	}
	
	public double getMenorValor() {
		return menorValor;
	}

}
