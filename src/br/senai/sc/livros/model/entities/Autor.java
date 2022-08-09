package br.senai.sc.livros.model.entities;

public class Autor extends Pessoa{

    public Autor(String nome, String sobrenome, String cpf, String senha, String email, Genero genero) {
        super(nome, sobrenome, cpf, senha, email, genero);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
