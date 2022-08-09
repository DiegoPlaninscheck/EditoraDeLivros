package br.senai.sc.livros.model.entities;

public class Livros {
    private Autor autor;
    private Editora editora;
    private String titulo;
    private int isbn, qtdPaginas;
    private Status status;

    public Livros(String titulo, int isbn, int qtdPaginas, Status status, Autor pessoa) {
        this.autor = pessoa;
        this.titulo = titulo;
        this.isbn = isbn;
        this. qtdPaginas = qtdPaginas;
        this.status = status;
    }

    public static Livros cadastrar(String titulo, int isbn, int qtdPaginas, Autor pessoa) {
        return new Livros(titulo, isbn, qtdPaginas, Status.AGUARDANDO_REVISAO, pessoa);
    }

    @Override
    public String toString() {
        return "Livros{" +
                "autor=" + autor +
                ", editora=" + editora +
                ", titulo='" + titulo + '\'' +
                ", isbn=" + isbn +
                ", qtdPaginas=" + qtdPaginas +
                ", status=" + status +
                '}';
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getQtdPaginas() {
        return qtdPaginas;
    }

    public void setQtdPaginas(int qtdPaginas) {
        this.qtdPaginas = qtdPaginas;
    }
}
