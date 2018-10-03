package com.company.view;

import com.company.model.Celular;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FormCelular extends JPanel{

    private JTextField imputImei, imputMarca, imputmodelo, imputcor, imputano;
    private JButton Cancelar, cadastrar, voltar,excluir;
    private JFrame janela;

    public FormCelular(){
        imputCelular();
    }

    private void imputCelular(){

        this.setLayout(new GridLayout(8,2));

        JLabel txtimei = new JLabel("IMEI");
        imputImei = new JTextField(20);

        JLabel txtmarca = new JLabel("MARCA");
        imputMarca = new JTextField(20);

        JLabel txtmodeo = new JLabel("MODELO");
        imputmodelo = new JTextField(20);

        JLabel txtcor = new JLabel("COR");
        imputcor = new JTextField(20);

        JLabel txtano = new JLabel("ANO");
        imputano = new JTextField(20);

        cadastrar = new JButton("Cadastrar");
        Cancelar = new JButton("Limpar");
        voltar = new JButton("Voltar");
        excluir = new JButton("Excluir");

        add(txtimei);
        add(imputImei);

        add(txtmarca);
        add(imputMarca);

        add(txtmodeo);
        add(imputmodelo);

        add(txtcor);
        add(imputcor);

        add(txtano);
        add(imputano);

        add(cadastrar);
        add(Cancelar);
        add(voltar);
        add(excluir);
    }

    public void addActionListenerCancelar(ActionListener acao){
        this.Cancelar.addActionListener(acao);
    }

    public void addActionListenerCadastrar(ActionListener acao){
        this.cadastrar.addActionListener(acao);
    }

    public void addActionListenerVoltar(ActionListener acao){
        this.voltar.addActionListener(acao);
    }

    public void addActionListenerExcluir(ActionListener acao){
        this.excluir.addActionListener(acao);
    }

    public void setImputs(Celular cell){

        setImputImei(cell.getImei());
        setImputMarca(cell.getMarca());
        setImputmodelo(cell.getModelo());
        setImputcor(cell.getCor());
        setImputano(cell.getAno());
    }

    public void limparCampos(){
        setImputano("");
        setImputcor("");
        setImputImei("");
        setImputmodelo("");
        setImputMarca("");
    }
    public JTextField getImputImeiObj() {
        return imputImei;
    }

    public String getImputImei() {
        return imputImei.getText();
    }

    public void setImputImei(String imei) {
        this.imputImei.setText(imei);
    }

    public String getImputMarca() {
        return imputMarca.getText();
    }

    public void setImputMarca(String marca) {
        this.imputMarca.setText(marca);
    }

    public String getImputmodelo() {
        return imputmodelo.getText();
    }

    public void setImputmodelo(String modelo) {
        this.imputmodelo.setText(modelo);
    }

    public String getImputcor() {
        return imputcor.getText();
    }

    public void setImputcor(String cor) {
        this.imputcor.setText(cor);
    }

    public String getImputano() {
        return imputano.getText();
    }

    public void setImputano(String ano) {
        this.imputano.setText(ano);
    }


}
