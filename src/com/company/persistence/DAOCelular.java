package com.company.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.company.model.Celular;
import com.company.util.Retorno;


public class DAOCelular {
	
	public DAOCelular() {
		
	}
	public Retorno<?> inserir(Celular celular) {


		Retorno<?> retValidos = celular.camposObrigatoriosPreenchidos();

		if(retValidos.isSucesso()==false) { return retValidos; }
		
		String sql = "INSERT INTO celulares (imei, marca, modelo, cor, ano) VALUES (?,?,?,?,?)";
		Retorno<PreparedStatement> retSQL = obterSQLPreparada(sql);

		if(retSQL.isSucesso()==false) {return retSQL;}
		
		Retorno<?> ret2 = preencherSQLPreparada(retSQL.getDado(),celular);
		if(ret2.isSucesso()==false) {return ret2;}
		
		return executarSQLPreparadaAlteracao(retSQL.getDado());
	}
	
	public Retorno<List<Celular>> listar(){
		Retorno<List<Celular>> retornoLista = new Retorno<List<Celular>>(true,"OK");

		String sql = "select * from celulares";
		
		Retorno<PreparedStatement> retSQL = obterSQLPreparada(sql);
		if(retSQL.isSucesso()==false) {	return new Retorno<List<Celular>>(retSQL);
		}
		
		Retorno<ResultSet> retResultado = executarSQLPreparadaConsulta(retSQL.getDado());
		if(retResultado.isSucesso()==false) {return new Retorno<List<Celular>>(retResultado); }
		
		ResultSet rs = retResultado.getDado();
		List<Celular> lista = new ArrayList<>();
		try {
			while(rs.next()) {
				Celular celular = new Celular();

				celular.setImei(rs.getString("imei"));
				celular.setMarca(rs.getString("marca"));
				celular.setModelo(rs.getString("modelo"));
				celular.setCor(rs.getString("cor"));
				celular.setAno(rs.getString("ano"));

				lista.add(celular);
			}
		}catch(SQLException e) {
			retornoLista.setSucesso(false);
			//TODO: tratar erro de banco melhor
			retornoLista.setMensagem(e.getMessage());
		}
		retornoLista.setDado(lista);
		return retornoLista;
		
	}



	/*
	Atualiza os celulares na tabela
	 */
	public Retorno<?> atualizar(Celular celular){

			String sql = "UPDATE celulares SET imei=?, marca=?, modelo=?, cor=?, ano=? WHERE imei=?";
			Retorno<PreparedStatement> retSQL = obterSQLPreparada(sql);

			//retorna um erro ou nao da sql
			if(retSQL.isSucesso()==false) {return retSQL;}


			try {

				retSQL.getDado().setString(1,celular.getImei());

				retSQL.getDado().setString(2,celular.getMarca());
				retSQL.getDado().setString(3,celular.getModelo());
				retSQL.getDado().setString(4,celular.getCor());
				retSQL.getDado().setString(5,celular.getAno());

				retSQL.getDado().setString(6,celular.getImei());

			} catch (SQLException e) {
				System.out.println("ERRRRROU");
				return (Retorno<?>) retSQL.getDado();
			}



			return executarSQLPreparadaAlteracao(retSQL.getDado());

	}


	/**
	 * Atualiza o celular no banco de dados "Insert update delete"
	 * @param pst
	 * @return Retorna um objeto retorno com Ststus a mensagem e a quantidade de linhas aeftadas
	 */
	private Retorno<Integer> executarSQLPreparadaAlteracao(PreparedStatement pst) {
		Retorno<Integer> ret = new Retorno<>(true,"Alteracao Executada com Sucesso!");
		try{
			int linhasAlteracao = pst.executeUpdate();
			pst.close();
			ret.setDado(linhasAlteracao);
		} catch (SQLException e) {
			ret = tratarErroSQLPreparadaAlteracao(e);
		}
		return ret;
	}
	
	private Retorno<ResultSet> executarSQLPreparadaConsulta(PreparedStatement pst) {
		Retorno<ResultSet> ret = new Retorno<>(true,"Consulta Executada com Sucesso!");
		try {
			ResultSet rs = pst.executeQuery();	
			ret.setDado(rs);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		return ret;
	}

	private Retorno<Integer> tratarErroSQLPreparadaAlteracao(SQLException e) {
		e.printStackTrace();
		Retorno<Integer> ret = new Retorno<>(false,"Erro desconhecido ao executar Altera��o: "+e.getMessage());
		ret.setDado(0);
		
		if(e.getMessage().contains("amigo_nome_unico")) {
			ret.setMensagem("J� existe um amigo com esse nome!");
		}
		
		return ret;
	}

	private Retorno preencherSQLPreparada(PreparedStatement pst, Celular celular) {
		Retorno<?> ret = new Retorno<>(true, "OK");
		try {
			pst.setString(1, celular.getImei());
			pst.setString(2, celular.getCor());
			pst.setString(3, celular.getModelo());
			pst.setString(4, celular.getAno());
			pst.setString(5, celular.getMarca());
		} catch (SQLException e) {
			ret.setSucesso(false);
			ret.setMensagem("Erro desconhecido 2:"+e.getMessage());
		}
		return ret;
	}

	private Retorno<PreparedStatement> obterSQLPreparada(String sql) {

		Retorno<PreparedStatement> ret = new Retorno<>(true,"OK");

		PreparedStatement pst = null;

		try {
			 pst = Conexao.obterConexao().obterSQLPreparada(sql);
			 ret.setDado(pst);
		}catch (SQLException e) {
			ret.setSucesso(false);
			if(e.getCause().getClass().getSimpleName().equals("ConnectException")) {
				ret.setMensagem("Erro de Conexao com Banco!");
			}else {
				ret.setMensagem("Erro desconhcido:"+e.getMessage());
			}
		}

		return ret;
	}
}
