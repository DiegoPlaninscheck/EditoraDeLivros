package br.senai.sc.livros.model.entities;

public enum Status {
    AGUARDANDO_REVISAO("Aguardando Revisão"),
    EM_REVISAO("Em Revisão"),
    REPROVADO("Reprovado"),
    AGUARDANDO_EDICAO("Aguardando Edição"),
    APROVADO("Aprovado"),
    PUBLICADO("Publicado");

    String nome;

    // fazer funcao para verificar o status para cada pessoa

    Status(String nome){
        this.nome = nome;
    }
}
