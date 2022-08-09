package br.senai.sc.livros.model.dao;

import br.senai.sc.livros.model.entities.*;

import java.util.ArrayList;

public class LivrosDAO {

    private static ArrayList<Livros> listaLivros = new ArrayList<>();

    static {
        PessoaDAO pessoa = new PessoaDAO();
        Autor autor = (Autor) pessoa.selecionarPorCPF("a");
        Autor autor2 = (Autor) pessoa.selecionarPorCPF("d");
        listaLivros.add(new Livros("teste", 1, 150, Status.AGUARDANDO_REVISAO, autor));
        listaLivros.add(new Livros("teste2", 2, 250, Status.APROVADO, autor));
        listaLivros.add(new Livros("teste3", 3, 350, Status.AGUARDANDO_EDICAO, autor));
        listaLivros.add(new Livros("teste4", 4, 450, Status.EM_REVISAO, autor2));
        listaLivros.add(new Livros("teste5", 5, 550, Status.REPROVADO, autor2));
        listaLivros.add(new Livros("teste6", 6, 650, Status.PUBLICADO, autor2));
        listaLivros.add(new Livros("teste7", 7, 400, Status.EM_REVISAO, autor2));
    }

    public void inserir(Livros livro) {
        listaLivros.add(livro);
    }

    public void remover(Livros livro) {
        listaLivros.remove(livro);
    }

    public Livros selecionar(int isbn) {
        for (Livros livro : listaLivros) {
            if (livro.getIsbn() == isbn) {
                return livro;
            }
        }
        throw new RuntimeException();
    }

    public void atualizar(int isbn, Livros livroAtualizado) {
        for (int i = 0; i < listaLivros.size(); i++) {
            if (listaLivros.get(i).getIsbn() == isbn) {
                listaLivros.set(i, livroAtualizado);
            }
        }
    }

    public ArrayList<Livros> selecionarTodos(){
        return listaLivros;
    }

    public ArrayList<Livros> selecionarPorAutor(Pessoa pessoa){
        ArrayList<Livros> livrosAutor = new ArrayList<>();
        for (int i = 0; i < listaLivros.size(); i++) {
            if (listaLivros.get(i).getAutor().equals(pessoa)) {
                livrosAutor.add(listaLivros.get(i));
            }
        }
        return livrosAutor;
    }

    public ArrayList<Livros> selecionarPorStatus(Status status){
        System.out.println("Livros DAO: " + status);
        ArrayList<Livros> livrosStatus = new ArrayList<>();
        for (int i = 0; i < listaLivros.size(); i++) {
            if (listaLivros.get(i).getStatus().equals(status)) {
                livrosStatus.add(listaLivros.get(i));
            }
        }
        System.out.println("LivrosStatus: " + livrosStatus.size());
        return livrosStatus;
    }

    public ArrayList<Livros> selecionarAtividadesAutor(Pessoa pessoa){
        System.out.println("Livros DAO: " + pessoa);
        ArrayList<Livros> livrosAutor = new ArrayList<>();
        for (Livros livro : listaLivros) {
            System.out.println("livro(livros DAO): " + livro);
            if (livro.getAutor().equals(pessoa) && livro.getStatus().equals(Status.AGUARDANDO_EDICAO)) {
                livrosAutor.add(livro);
            }
        }
        System.out.println("Livros Autor(lista): " + livrosAutor.size());
        return livrosAutor;
    }
}
