package com.company.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class MenuIndex  extends JFrame {


    public MenuIndex(){
        getMenu();
    }

    private void getMenu() {

        this.setTitle("Cadastro de celular");

        this.getContentPane().setLayout(new GridLayout(1,3,5,5));


        this.setSize(200,300);


        JButton cadastrar = new JButton("Cadastrar");
        JButton listar = new JButton("Listar");

        setDefaultCloseOperation(EXIT_ON_CLOSE);


        cadastrar.addActionListener(
                e -> {
                    System.out.println("Cadastrando...");
                    this.ocultar();
                    CadastroCelular cadastro = new CadastroCelular("cadastrar");
                    cadastro.setVisible(true);
                }
        );

        listar.addActionListener(
                e ->{
                    System.out.println("Listando...");
                    this.ocultar();
                    Lista l = new Lista();
                    l.exibir();
                }
        );

        this.add(cadastrar);
        this.add(listar);
        this.pack();
    }

    public void exibir(){
        System.out.println("Exibindo...");
        this.setVisible(true);
    }
    public void ocultar(){
        System.out.println("Ocultando...");
        this.setVisible(false);
    }

}
