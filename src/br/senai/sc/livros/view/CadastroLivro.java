package br.senai.sc.livros.view;

import br.senai.sc.livros.controller.LivrosController;
import br.senai.sc.livros.model.entities.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CadastroLivro extends JFrame {
    private JButton cadastrarButton;
    private JButton voltarButton;
    private JTextField titulo;
    private JTextField isbn;
    private JTextField qtdPagina;
    private JPanel cadastroLivro;
    private JComboBox status;
    private JLabel TituloPagina;

    public CadastroLivro(Pessoa pessoa) {
        if (pessoa instanceof Revisor || pessoa instanceof Diretor) {
            TituloPagina.setText("Editar Livro");
        }
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
        if (Menu.getUsuario() instanceof Revisor || Menu.getUsuario() instanceof Diretor) {
            Estante estante = new Estante(2);
            estante.setVisible(true);
        } else {
            Menu menu = new Menu(Menu.getUsuario());
            menu.setVisible(true);
        }
    }

    public void setarValorDosCampos(String t, String i, String qtd) {
        titulo.setText(t);
        isbn.setText(i);
        qtdPagina.setText(qtd);
        titulo.disable();
        isbn.disable();
        qtdPagina.disable();
    }

//    static ArrayList<Status> listaStatus = new ArrayList<>();
//
//    static {
//        listaStatus.add(Status.AGUARDANDO_REVISAO);
//        listaStatus.add(Status.APROVADO);
//        listaStatus.add(Status.EM_REVISAO);
//        listaStatus.add(Status.PUBLICADO);
//        listaStatus.add(Status.AGUARDANDO_EDICAO);
//        listaStatus.add(Status.REPROVADO);
//    }

//    public static Status retornaStatus(){
//        if(Menu.getUsuario() instanceof Revisor){
//            listaStatus.get(4);
//            listaStatus.get(5);
//            listaStatus.get(2);
//            listaStatus.get(3);
//        }
//        return null;
//    }

    public Status teste() {
        return (Status) status.getSelectedItem();
    }

    private void criarComponentes() {
        setContentPane(cadastroLivro);
        if (Menu.getUsuario() instanceof Revisor) {
            Status[] statusFiltrados = new Status[4];
            statusFiltrados[0] = Status.AGUARDANDO_EDICAO;
            statusFiltrados[1] = Status.REPROVADO;
            statusFiltrados[2] = Status.APROVADO;
            statusFiltrados[3] = Status.EM_REVISAO;
            status.setModel(new DefaultComboBoxModel(statusFiltrados));
        } else if (Menu.getUsuario() instanceof Diretor) {
            Status[] statusFiltrados = new Status[2];
            statusFiltrados[0] = Status.PUBLICADO;
            statusFiltrados[1] = Status.REPROVADO;
            status.setModel(new DefaultComboBoxModel(statusFiltrados));
        } else {
            status.setVisible(false);
        }
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
    }


}
