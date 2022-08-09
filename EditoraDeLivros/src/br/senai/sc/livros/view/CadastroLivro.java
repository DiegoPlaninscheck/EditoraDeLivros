package br.senai.sc.livros.view;

import br.senai.sc.livros.controller.LivrosController;
import br.senai.sc.livros.model.entities.Diretor;
import br.senai.sc.livros.model.entities.Pessoa;
import br.senai.sc.livros.model.entities.Revisor;
import br.senai.sc.livros.model.entities.Status;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroLivro extends JFrame {
    private JButton cadastrarButton;
    private JButton voltarButton;
    private JTextField titulo;
    private JTextField isbn;
    private JTextField qtdPagina;
    private JPanel cadastroLivro;
    private JComboBox status;

    CadastroLivro(Pessoa pessoa) {
        criarComponentes();
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (titulo.getText().isEmpty() || isbn.getText().isEmpty() || qtdPagina.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Há campos vazios!\nPreencha e tente novamente");
                } else {
                    dispose();
                    voltar();
                    LivrosController controller = new LivrosController();
                    controller.cadastrar(titulo.getText(), pessoa, isbn.getText(), qtdPagina.getText());
                }
            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                voltar();
            }
        });
    }

    private void voltar() {
        if(Menu.getUsuario() instanceof Revisor || Menu.getUsuario() instanceof Diretor){
            Estante estante = new Estante(2);
            estante.setVisible(true);
        } else {
            Menu menu = new Menu(Menu.getUsuario());
            menu.setVisible(true);
        }
    }

    public void setarValorDosCampos(String t, String i, String qtd){
        titulo.setText(t);
        isbn.setText(i);
        qtdPagina.setText(qtd);
        titulo.disable();
        isbn.disable();
        qtdPagina.disable();
    }

    private void criarComponentes() {
        setContentPane(cadastroLivro);
        if(Menu.getUsuario() instanceof Revisor || Menu.getUsuario() instanceof Diretor){
            status.setModel(new DefaultComboBoxModel(Status.values()));
        } else {
            status.setVisible(false);
        }
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
    }


}
