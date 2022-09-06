package br.senai.sc.livros.view;

import br.senai.sc.livros.controller.LivrosController;
import br.senai.sc.livros.model.entities.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Estante extends JFrame {
    private JPanel estante;
    private JTable tabelaLivros;
    private JButton voltarButton;
    private JButton editarButton;
    private static int lista;

    public Estante(int botao) {
        lista = botao;
        criarComponentes();
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                voltar();
            }
        });
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pessoa usuario = Menu.getUsuario();
                LivrosController controller = new LivrosController();
                if (usuario instanceof Autor) {
                    String isbn = tabelaLivros.getValueAt(tabelaLivros.getSelectedRow(), 0).toString();
                    if(isbn != null){
                        controller.editarLivro(isbn);
                        JOptionPane.showMessageDialog(null, "Livro atualizado!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Livro inexistente!");
                    }
                } else if (usuario instanceof Revisor || usuario instanceof Diretor) {
                    if(tabelaLivros.getSelectedRow() < 0){
                        JOptionPane.showMessageDialog(null, "Nenhum livro foi selecionado!");
                    } else {
                        CadastroLivro cadastroLivro = new CadastroLivro(usuario);
                        dispose();
                        cadastroLivro.setVisible(true);
                        String isbn = tabelaLivros.getValueAt(tabelaLivros.getSelectedRow(), 0).toString();
                        String titulo = tabelaLivros.getValueAt(tabelaLivros.getSelectedRow(), 1).toString();
                        String qtdPagina = tabelaLivros.getValueAt(tabelaLivros.getSelectedRow(), 2).toString();
                        cadastroLivro.setarValorDosCampos(titulo, isbn, qtdPagina);
                        controller.editarLivro(isbn);
                    }
                }
            }
        });
    }

    private void voltar() {
        Menu menu = new Menu(Menu.getUsuario());
        menu.setVisible(true);
    }

    private void criarComponentes() {
        LivrosController livrosController = new LivrosController();
        tabelaLivros.setModel(new DefaultTableModelArrayList(livrosController.buscarLista(lista)));
        tabelaLivros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        if (lista == 1) {
            editarButton.setVisible(false);
        } else {
//            System.out.println("Estante" + tabelaLivros.getSelectedRow());
//            try{
//            String isbn = (String) tabelaLivros.getValueAt(tabelaLivros.getSelectedRow(), 0);
//            livrosController.editarLivro(isbn);
//            }catch (Exception e){
//                System.out.println(e.getMessage());
//            }
        }
        setContentPane(estante);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
    }
}
