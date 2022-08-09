package br.senai.sc.livros.controller;

import br.senai.sc.livros.model.entities.*;
import br.senai.sc.livros.model.service.LivrosService;
import br.senai.sc.livros.view.Menu;

import java.util.ArrayList;

public class LivrosController {

    Livros model;

    public void cadastrar(String titulo, Pessoa pessoa, String isbn, String qtdPaginas) {
        Livros livro;
        livro = Livros.cadastrar(titulo, Integer.parseInt(isbn), Integer.parseInt(qtdPaginas), (Autor) pessoa);
        LivrosService service = new LivrosService();
        service.inserir(livro);
    }

    public ArrayList<Livros> buscarLista(int lista) {
        LivrosService service = new LivrosService();
        Pessoa usuario = Menu.getUsuario();
        System.out.println("Livros Controller: " + usuario);
        if (usuario instanceof Autor) {
            if (lista == 1) {
                return service.selecionarPorAutor(usuario);
            } else {
                return service.selecionarAtividadesAutor(usuario);
            }
        } else if (usuario instanceof Revisor) {
            if (lista == 1) {
                return service.selcionarPorStatus(Status.AGUARDANDO_REVISAO);
            } else {
                return service.selcionarPorStatus(Status.EM_REVISAO);
            }
        } else {
            if (lista == 1) {
                return service.selecionarTodos();
            } else {
                return service.selcionarPorStatus(Status.APROVADO);
            }
        }
    }

    public void editarLivro(String isbn) {
        LivrosService service = new LivrosService();
        Livros livroAtualizado = service.selecionar(Integer.parseInt(isbn));
        if (Menu.getUsuario() instanceof Autor) {
            livroAtualizado.setStatus(Status.AGUARDANDO_REVISAO);
        } else if (Menu.getUsuario() instanceof Revisor) {
            livroAtualizado.setStatus(Status.APROVADO);
        } else if(Menu.getUsuario() instanceof Diretor){
            livroAtualizado.setStatus(Status.PUBLICADO);
        }
        service.atualizar(Integer.parseInt(isbn), livroAtualizado);
    }

    public Autor getAutor() {
        return model.getAutor();
    }

    public void setAutor(Autor autor) {
        model.setAutor(autor);
    }

    public Editora getEditora() {
        return model.getEditora();
    }

    public void setEditora(Editora editora) {
        model.setEditora(editora);
    }

    public String getTitulo() {
        return model.getTitulo();
    }

    public void setTitulo(String titulo) {
        model.setTitulo(titulo);
    }

    public Status getStatus() {
        return model.getStatus();
    }

    public void setStatus(Status status) {
        model.setStatus(status);
    }

    public int getIsbn() {
        return model.getIsbn();
    }

    public void setIsbn(int isbn) {
        model.setIsbn(isbn);
    }

    public int getQtdPaginas() {
        return model.getQtdPaginas();
    }

    public void setQtdPaginas(int qtdPaginas) {
        model.setQtdPaginas(qtdPaginas);
    }
}
