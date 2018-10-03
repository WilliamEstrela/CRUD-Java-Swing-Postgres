package com.company.model;
import com.company.model.Modelo;

import java.util.ArrayList;
import java.util.List;

public class Celular extends Modelo {
	private String imei;
	private String marca;
	private String modelo;
	private String cor;
	private String ano;


	public Celular(String imei, String marca, String modelo, String cor, String ano) {
		this.imei = imei;
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.ano = ano;
	}

	public Celular(){

	}
	
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}


	@Override
	public Object getCamposValor(String campoNome) {
		if(campoNome.equalsIgnoreCase("imei")){
			return this.getImei();
		}else if(campoNome.equalsIgnoreCase("marca")) {
			return this.getMarca();
		}else if(campoNome.equalsIgnoreCase("modelo")) {
			return this.getModelo();
		}else if (campoNome.equalsIgnoreCase("cor")){
			return this.getCor();
		}else if (campoNome.equalsIgnoreCase("ano")){
			return this.getAno();
		}

			throw new RuntimeException("Nao existe o campo" + campoNome + " na tabela");
	}

	@Override
	public List<String> getCamposObrigatorios() {
		List<String> lista = new ArrayList<>();
		lista.add("imei");
		lista.add("marca");
		lista.add("modelo");
		lista.add("cor");
		lista.add("ano");
		return lista;
	}

	@Override
	public String toString() {
		return "Celular{" +
				"imei='" + imei + '\'' +
				", marca='" + marca + '\'' +
				", modelo='" + modelo + '\'' +
				", cor='" + cor + '\'' +
				", ano='" + ano + '\'' +
				'}';
	}
}
