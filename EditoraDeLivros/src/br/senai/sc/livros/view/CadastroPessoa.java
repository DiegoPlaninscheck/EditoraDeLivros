package br.senai.sc.livros.view;

import br.senai.sc.livros.controller.PessoaController;
import br.senai.sc.livros.model.entities.Genero;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroPessoa extends JFrame {
    private JButton voltarButton;
    private JButton cadastrarButton;
    private JTextField nome;
    private JTextField sobrenome;
    private JTextField email;
    private JTextField cpf;
    private JComboBox genero;
    private JPasswordField senha;
    private JPasswordField confimarSenha;
    private JPanel cadastroPessoa;

    public CadastroPessoa() {
        criarComponentes();
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nome.getText().isEmpty() || sobrenome.getText().isEmpty() || cpf.getText().isEmpty() || senha.getText().isEmpty()
                        || email.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Há campos vazios!\nPreencha e tente novamente");
                } else {
                    PessoaController controller = new PessoaController();
                    try {
                        controller.cadastrar(nome.getText(), sobrenome.getText(), cpf.getText(), senha.getText(),
                                email.getText(), genero.getSelectedItem(), confimarSenha.getText());
                        dispose();
                        JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
                        voltar();
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, exception.getMessage());
                    }
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
        if(Menu.getUsuario() == null){
            Login login = new Login();
            login.run();
        } else {
            Menu menu = new Menu(Menu.getUsuario());
            menu.setVisible(true);
        }
    }

    private void criarComponentes() {
        genero.setModel(new DefaultComboBoxModel(Genero.values()));
        setContentPane(cadastroPessoa);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
    }
}
