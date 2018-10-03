package com.company.teste;

import com.company.model.Celular;
import com.company.persistence.DAOCelular;
import com.company.util.Retorno;
import com.company.view.MenuIndex;

import java.util.ArrayList;

public class TesteDAOCelular {

    public static void main(String[] args) {

        System.out.println("Testando");

        DAOCelular dao = new DAOCelular();
        System.out.println(dao.listar().getDado());

//        ArrayList<Retorno<Celular>> ret = dao.listar();
//        System.out.println(ret);
    }
}
