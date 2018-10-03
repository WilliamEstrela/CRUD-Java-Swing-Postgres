package com.company.controller;

import com.company.model.Celular;
import com.company.persistence.DAOCelular;
import com.company.util.Retorno;

import java.util.ArrayList;
import java.util.List;

public class ControleCelular {


    DAOCelular dao;

    public ControleCelular() {
        dao = new DAOCelular();
    }

    public void incluirCelular(Celular celular){
        dao.inserir(celular);
    }

    public void inserirCelular(Celular celular){
        dao.inserir(celular);
    }

    public void atualizar(Celular cell){
        dao.atualizar(cell);
    }

    public Retorno<List<Celular>> listarCelulares(){
         return dao.listar();
    }

//    public void removerCelular(Celular celular){
//        String imei = celular.getImei();
//        dao.remover(imei);
//    }
}
