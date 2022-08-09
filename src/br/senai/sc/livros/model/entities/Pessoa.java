package br.senai.sc.livros.model.entities;

import br.senai.sc.livros.view.Menu;

public class Pessoa {
    private String nome, sobrenome, email, senha, cpf;
    private Genero genero;

    public Pessoa(String nome, String sobrenome, String cpf, String senha, String email, Genero genero) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.senha = senha;
        this.email = email;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return nome + " " + sobrenome;
    }

    public Pessoa validaLogin(String senha){
        if(this.getSenha().equals(senha)) return this;
        throw new RuntimeException("Senha incorreta!");
    }

    public static Pessoa cadastrar(String nome, String sobrenome, String cpf,
                                   String senha, String email, Genero genero, String senhaConfirmada){
        if(senha.equals(senhaConfirmada)){
            if(email.contains("@")){
                if(Menu.getUsuario() instanceof Diretor){
                    return new Revisor(nome, sobrenome, cpf, senha, email, genero);
                } else {
                    return new Autor(nome, sobrenome, cpf, senha, email, genero);
                }
            }
            throw new RuntimeException("Email inválido!");
        }
        throw new RuntimeException("Senhas não conferem!");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
