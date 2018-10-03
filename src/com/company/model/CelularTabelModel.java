package com.company.model;



import com.company.controller.ControleCelular;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class CelularTabelModel extends AbstractTableModel {

    private List<Celular> linhas;
    private String[] colunas = {"IMEI","MARCA","MODELO","COR","ANO"};

    public CelularTabelModel(List<Celular> listaCelulares){
        linhas = listaCelulares;


        System.out.println("CELULAR TABLE MODEL");
        for(int i = 0; i < linhas.size(); i++){
            System.out.println(linhas.get(i).getMarca());
        }
    }

    public Celular getCelular(int linha){
        Celular objCelular = linhas.get(linha);
        return objCelular;
    }

    @Override
    public String getColumnName(int column) {
        return this.colunas[column];
    }

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna){
            case 0:
                return linhas.get(linha).getImei();
            case 1:
                return linhas.get(linha).getMarca();
            case 2:
                return linhas.get(linha).getModelo();
            case 3:
                return linhas.get(linha).getCor();
            case 4:
                return linhas.get(linha).getAno();

        }
        return null;
    }

}
