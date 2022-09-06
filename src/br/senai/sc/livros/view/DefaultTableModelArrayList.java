package br.senai.sc.livros.view;

import br.senai.sc.livros.model.entities.Livros;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class DefaultTableModelArrayList extends AbstractTableModel {

    ArrayList<Livros> dados;
    String[] colunas;

    public DefaultTableModelArrayList(ArrayList<Livros> lista) {
        this.dados = lista;
        colunas = new String[]{"ISBN", "Título", "Qtd Pág", "Autor", "Editora", "Status"};
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    public Livros getLivro(int rowIndex){
        return dados.get(rowIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Livros livros = dados.get(rowIndex);
        switch (columnIndex) {
            case 0 -> {
                return livros.getIsbn();
            }
            case 1 -> {
                return livros.getTitulo();
            }
            case 2 -> {
                return livros.getQtdPaginas();
            }
            case 3 -> {
                return livros.getAutor();
            }
            case 4 -> {
                return livros.getEditora();
            }
            default -> {
                return livros.getStatus();
            }
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }
}
