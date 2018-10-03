package com.company.util;


public class Retorno<TIPO> {

	private boolean sucesso;
	private String mensagem;
	private TIPO dado;
	private String mensagemDetalhada;
	
	
	public Retorno(boolean sucesso, String mensagem) {
		super();
		this.sucesso = sucesso;
		this.mensagem = mensagem;
	}
	public Retorno(Retorno<?> ret ) {
		this.setSucesso(ret.isSucesso());
		this.setDado(null);
		this.setMensagem(ret.getMensagem());
		this.setMensagemDetalhada(ret.getMensagemDetalhada());
	}
	public boolean isSucesso() {
		return sucesso;
	}
	public void setSucesso(boolean sucesso) {
		this.sucesso = sucesso;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public TIPO getDado() {
		return dado;
	}
	public void setDado(TIPO dado) {
		this.dado = dado;
	}
	public String getMensagemDetalhada() {
		return mensagemDetalhada;
	}
	public void setMensagemDetalhada(String mensagemDetalhada) {
		this.mensagemDetalhada = mensagemDetalhada;
	}
	@Override
	public String toString() {
		return "Retorno [sucesso=" + sucesso + ", mensagem=" + mensagem + "]";
	}
}
