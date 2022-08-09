package br.senai.sc.livros.model.dao;

import br.senai.sc.livros.model.entities.*;

import java.util.ArrayList;

public class PessoaDAO {
    private static ArrayList<Pessoa> listaPessoas = new ArrayList<>();


    static {
        listaPessoas.add(new Autor("a", "a", "a", "a", "a@", Genero.MASCULINO));
        listaPessoas.add(new Revisor("b", "b", "b", "b", "b@", Genero.MASCULINO));
        listaPessoas.add(new Diretor("c", "c", "c", "c", "c@", Genero.MASCULINO));
        listaPessoas.add(new Autor("d", "d", "d", "d", "d@", Genero.MASCULINO));
    }

    public void inserir(Pessoa pessoa) {
        listaPessoas.add(pessoa);
    }

    public void remover(Pessoa pessoa) {
        listaPessoas.remove(pessoa);
    }

    public Pessoa selecionarPorCPF(String cpf) {
        for (Pessoa pessoa : listaPessoas) {
            if (pessoa.getCpf().equals(cpf)) {
                return pessoa;
            }
        }
        throw new RuntimeException("Pessoa não encontrada!");
    }

    public Pessoa selecionarPorEMAIL(String email) {
        for (Pessoa pessoa : listaPessoas) {
            if (pessoa.getEmail().equals(email)) {
                return pessoa;
            }
        }
        throw new RuntimeException("Email não encontrado!");
    }

    public void atualizar(String cpf, Pessoa pessoaAtualizada) {
        for (int i = 0; i < listaPessoas.size(); i++) {
            if (listaPessoas.get(i).getCpf().equals(cpf)) {
                listaPessoas.set(i, pessoaAtualizada);
            }
        }
    }
}
