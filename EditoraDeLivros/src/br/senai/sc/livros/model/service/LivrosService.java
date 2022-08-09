package br.senai.sc.livros.model.service;

import br.senai.sc.livros.model.dao.LivrosDAO;
import br.senai.sc.livros.model.entities.Livros;
import br.senai.sc.livros.model.entities.Pessoa;
import br.senai.sc.livros.model.entities.Status;

import java.util.ArrayList;

public class LivrosService {

    LivrosDAO acesso = new LivrosDAO();

    public ArrayList<Livros> selecionarPorAutor(Pessoa pessoa){
        return acesso.selecionarPorAutor(pessoa);
    }

    public ArrayList<Livros> selcionarPorStatus(Status status){
        System.out.println("Livros service: " + status);
        return acesso.selecionarPorStatus(status);
    }

    public ArrayList<Livros> selecionarAtividadesAutor(Pessoa pessoa) {
        System.out.println("Livros service: " + pessoa);
        return acesso.selecionarAtividadesAutor(pessoa);
    }

    public void inserir(Livros livro) {
        acesso.inserir(livro);
    }

    public void remover(Livros livro) {
        acesso.remover(livro);
    }

    public Livros selecionar(int isbn) {
        return acesso.selecionar(isbn);
    }

    public void atualizar(int isbn, Livros livroAtualizado) {
        acesso.atualizar(isbn, livroAtualizado);
    }

    public ArrayList<Livros> selecionarTodos() {
        return acesso.selecionarTodos();
    }
}
