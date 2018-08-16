package br.com.caelum.leilao.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {

	private String descricao;
	private List<Lance> lances;
	private int total;
	
	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}
	
	public void propoe(Lance lance) {
		total = 0;
		for(Lance l : this.lances) {
			if(lance.getUsuario().equals(l.getUsuario())) {
				total++;
			}
		}
		if(listaVazia() || (!doisLancesDadosEmSequenciaPeloMesmoUsuario(lance.getUsuario()) && total < 5)) {
			lances.add(lance);
		}
	}

	private boolean doisLancesDadosEmSequenciaPeloMesmoUsuario(Usuario usuario) {
		return this.lances.get(lances.size()-1).getUsuario().equals(usuario);
	}

	private boolean listaVazia() {
		return this.lances.isEmpty();
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}

	public void dobraLance(Usuario usuario) {
		boolean flag = false;
		double valor = 0;
		if(!this.lances.isEmpty()) {
			verificaSeJaFoiDadoLanceParaDobrarValor(usuario, flag, valor);
		}
	}

	private void verificaSeJaFoiDadoLanceParaDobrarValor(Usuario usuario, boolean flag, double valor) {
		for(int i = this.lances.size()-1;i>=0;i--) {
			if(this.lances.get(i).getUsuario().equals(usuario)) {
				flag = true;
				valor = this.lances.get(i).getValor();
				break;
			}
		}
		if(flag) {
			this.propoe(new Lance(usuario, valor*2));
		}
	}

	
	
}
