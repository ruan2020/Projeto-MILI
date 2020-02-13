package br.com.ifba.mili.produto.service;

import br.com.ifba.mili.produto.model.Produto;
import java.util.List;

/**
 *
 * @author edson
 */

public interface IServiceProduto {
    
    /** Esse método é usado para buscar um produto no banco de dados.
     * 
     * @param id ID do produto usado na busca do banco de dados.
     * @return Se encontrado, retorna um objeto Produto, se não encontrar retorna null.
     */
    public abstract Produto findById (long id);
    
    /** Esse método é usado para buscar um produto no banco de dados com base no parâmetro informado.
     * 
     * @param codigo Código de barras do produto usado na busca no banco de dados.
     * @return Se encontrado, retorna um objeto Produto, se não encontrar retorna null.
     */
    public abstract Produto findByCodigoBarras (String codigo);
    
    /** Esse método é usado para buscar um produto no banco de dados com base no parâmetro informado.
     * 
     * @param name Nome do produto usado na busca no banco de dados.
     * @return Se o nome for igual ao informado, retorna uma lista com todos os dados dos produtos.
     */
    public abstract List<Produto> findByName (String name);
    
    /** Esse método é usado para buscar todos osprodutos salvos no banco de dados.
     * 
     * @return Retorna uma lista com todos os dados dos produtos salvos no banco de dados.
     */
    public abstract List<Produto> findAll ();
    
    /** Esse método é usado para salvar um produto no banco de dados.
     * 
     * @param produto Objeto salvo no banco de dados.
     * @return Retorna o objeto salvo no banco de dados.
     */
    public abstract Produto save (Produto produto);
    
    /** Esse método é usado para atualizar os dados de um produto no banco de dados.
     * 
     * @param produto Objeto com os dados atualizados do produto. 
     * @return Retorna o objeto atualizado salvo no banco de dados.
     */
    public abstract Produto update (Produto produto);
    
    /** Esse método é usado para excluir um produto do banco de dados.
     * 
     * @param produto Objeto com os dados do produto que serão excluídos.
     */
    public abstract void delete (Produto produto);
}