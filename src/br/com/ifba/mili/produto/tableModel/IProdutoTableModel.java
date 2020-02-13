package br.com.ifba.mili.produto.tableModel;

import br.com.ifba.mili.produto.model.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ruan
 */

public interface IProdutoTableModel {
    
    /* Lista de funcionários que aparecerão na tabela */
    public List<Produto> produtos = new ArrayList<>();
    
    /* Colunas da tabela */
    public final String[] colunas = {"Produto", "Preço", "Seção", "Data de Validade", "Estoque"};
}