package br.senai.sc.livros.controller;

import br.senai.sc.livros.model.entities.Genero;
import br.senai.sc.livros.model.entities.Pessoa;
import br.senai.sc.livros.model.service.PessoaService;

public class PessoaController {
    Pessoa model;

    public Pessoa validaLogin(String email, String senha) {
        PessoaService service = new PessoaService();
        model = service.selecionarPorEMAIL(email);
        return model.validaLogin(senha);
    }

    public void cadastrar(String nome, String sobrenome, String cpf, String senha, String email,
                          Object genero, String senhaConfirmada){
        Pessoa pessoa = Pessoa.cadastrar(nome, sobrenome, cpf, senha, email, (Genero) genero, senhaConfirmada);
        PessoaService service = new PessoaService();
        service.inserir(pessoa);
    }
}
