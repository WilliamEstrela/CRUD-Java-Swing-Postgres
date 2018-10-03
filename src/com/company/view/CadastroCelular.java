package com.company.view;

import com.company.controller.ControleCelular;
import com.company.model.Celular;
import com.company.persistence.DAOCelular;

import javax.swing.*;

public class CadastroCelular extends JFrame {

    FormCelular form;
    String imei, marca, modelo, cor, ano;

    /*
    Recebe o modo no qual ira criar a tela de cadastro
     */
    public CadastroCelular(String modo) {
        confTipoCadastro(modo);
    }

    Celular getCelular(){
        this.imei = form.getImputImei();
        this.marca = form.getImputMarca();
        this.modelo = form.getImputmodelo();
        this.cor = form.getImputcor();
        this.ano = form.getImputano();
        return new Celular(imei,marca,modelo,cor,ano);
    }

    void confTipoCadastro(String modo){
        switch (modo){
            case "cadastrar":
                setTitle("Cadastro de celular");
                setSize(300,300);
                getViewCadastro();
                getContentPane().add(form);
                break;
            case "editar":
                setTitle("Editando celular");
                setSize(300,300);
                getViewEditCadastro();
                getContentPane().add(form);
                break;
        }

    }

    /*
    Classe para atualizar um celular
     */
    private void getViewEditCadastro() {
        form = new FormCelular();
        form.getImputImeiObj().setEditable(false);

        form.addActionListenerCancelar(
                e->{
                    limpar();
                }
        );

        form.addActionListenerCadastrar(
                e->{
                    /*
                    Atualiza o celular
                     */
                    DAOCelular celularBD = new DAOCelular();
                    celularBD.atualizar(getCelular());
                }
        );


        form.addActionListenerVoltar(e->{
            MenuIndex menu = new MenuIndex();
            menu.exibir();
            dispose();
        });

        form.addActionListenerExcluir(e->{
//            DAOCelular celular = new DAOCelular();
//            controle.removerCelular(getCelular());
        });

    }

    private void getViewCadastro() {

        form = new FormCelular();


        form.addActionListenerCancelar(
                e->{
                limpar();
                }
        );

        form.addActionListenerCadastrar(e->{
            ControleCelular controle = new ControleCelular();
            controle.incluirCelular(getCelular());

        });

        form.addActionListenerVoltar(e->{
            MenuIndex menu = new MenuIndex();
            menu.exibir();
            dispose();
        });

    }

    public void limpar(){
        form.limparCampos();
    }

    public void preencher(Celular cell){
        form.setImputs(cell);
    }
}
