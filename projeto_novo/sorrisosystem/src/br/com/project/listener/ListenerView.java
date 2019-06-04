package br.com.project.listener;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "listenerView")
@ViewScoped
public class ListenerView {
	private boolean valor = false;
	private boolean desabilita = false;
	private String tipo= "";
	private boolean visivelAdulto = false;
	private boolean visivelCrianca = false;
	private boolean visivelMisto = false;
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean isVisivelAdulto() {
		return visivelAdulto;
	}

	public void setVisivelAdulto(boolean visivelAdulto) {
		this.visivelAdulto = visivelAdulto;
	}

	public boolean getValor() {
		return valor;
	}

	public void setValor(boolean valor) {
		this.valor = valor;
	}

	public boolean isDesabilita() {
		return desabilita;
	}

	public void setDesabilita(boolean desabilita) {
		this.desabilita = desabilita;
	}

	public boolean isVisivelCrianca() {
		return visivelCrianca;
	}

	public void setVisivelCrianca(boolean visivelCrianca) {
		this.visivelCrianca = visivelCrianca;
	}

	public boolean isVisivelMisto() {
		return visivelMisto;
	}

	public void setVisivelMisto(boolean visivelMisto) {
		this.visivelMisto = visivelMisto;
	}

	public void visivel() {
		System.out.println(this.tipo);
		if (this.tipo.equals("Adulto")) {
			this.visivelAdulto = true;
			this.visivelCrianca = false;
		}else if (this.tipo.equals("Crianca")) {
			this.visivelCrianca = true;
			this.visivelAdulto = false;
		}

	}

	/*
	 * public void handleKeyEvent() { if (this.valor.equals("Sim")) {
	 * 
	 * this.desabilita = true; } else if (this.valor.equals("Não")) {
	 * this.desabilita = false; } }
	 */

}
