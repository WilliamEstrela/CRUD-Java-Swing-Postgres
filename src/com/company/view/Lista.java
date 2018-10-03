package com.company.view;

import com.company.controller.ControleCelular;
import com.company.model.Celular;
import com.company.model.CelularTabelModel;
import com.company.persistence.DAOCelular;
import com.company.util.Retorno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class Lista extends JFrame {

    private JTable tabela;
    CelularTabelModel tabelModel;
    DAOCelular celularBD;

    public Lista(){


    	ControleCelular controle = new ControleCelular();
    	
    	Retorno<List<Celular>> retorno = controle.listarCelulares();

        celularBD = new DAOCelular();

        tabelModel = new CelularTabelModel(retorno.getDado());

        JPanel painelFundo = new JPanel();
        painelFundo.setLayout(new GridLayout(2, 1));

        tabela = new JTable();
        tabela.setModel(tabelModel);

        /**
         * Ao clicar 2x na linha ele abre a opcao de editar
         */
        tabela.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                int linha = tabela.getSelectedRow();

                if (e.getClickCount() >= 2 && linha != -1){
                    setVisible(false);

                    Celular celular = tabelModel.getCelular(linha);
                    CadastroCelular cadastro = new CadastroCelular("editar");
                    cadastro.preencher(celular);

                    cadastro.setVisible(true);

                }
            }
        });



        JScrollPane barraRolagem = new JScrollPane(tabela);
        painelFundo.add(barraRolagem);

        JButton voltar = new JButton("Voltar");


        painelFundo.add(voltar);


        getContentPane().add(painelFundo);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);



        System.out.println("Criando tabela...");

        voltar.addActionListener(e->{
                    setVisible(false);
                    MenuIndex m = new MenuIndex();
                    m.exibir();
                }
        );

    }


    public void exibir() {
        setVisible(true);
    }
}
