package br.com.ifba.mili.produto.dao;

import br.com.ifba.mili.infraestrutura.dao.IGenericDAO;
import br.com.ifba.mili.produto.model.Produto;
import java.util.List;

/**
 *
 * @author ruan
 */

public interface IProdutoDAO extends IGenericDAO<Produto>{
    
    /** Esse método é usado para buscar um produto no banco de dados com base no parâmetro informado.
     * 
     * @param codigo Código de barras do produto usado na busca no banco de dados.
     * @return Se encontrado, retorna um objeto Produto, se não encontrar retorna null.
     */
    public abstract Produto findByCodigoBarras (String codigo);
    
    /** Esse método é usado para buscar um produto no banco de dados com base no parâmetro informado.
     * 
     * @param name Nome do produto usado na busca no banco de dados.
     * @return Retorna uma lista com todos os dados dos produtos com um nome igual ao informado.
     */
    public abstract List<Produto> findByName (String name);
}