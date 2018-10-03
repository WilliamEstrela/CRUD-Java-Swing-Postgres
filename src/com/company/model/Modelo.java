package com.company.model;

import java.util.ArrayList;
import java.util.List;

import com.company.util.Retorno;

public abstract class Modelo {

	public Retorno<List<String>> camposObrigatoriosPreenchidos() {

		Retorno<List<String>> ret = new Retorno(true,"Campos Obrigatórios Preenchidos!!!");
		List<String> campos = new ArrayList<>();

		List<String> lista = this.getCamposObrigatorios();
		for (String campoNome : lista) {
			Object campoValor = this.getCamposValor(campoNome);
			if(  campoValor==null || (campoValor instanceof String && ( ((String)campoValor).isEmpty())   )) {
					campos.add("Campo "+campoNome + " não foi preenchido!!!");
			}
		}
		if(!campos.isEmpty()) {
			ret.setSucesso(false);
			ret.setDado(campos);
			ret.setMensagem(campos.toString());
		}
		return ret;
	}
	public abstract Object getCamposValor(String campoNome);
	public abstract List<String> getCamposObrigatorios();
}
