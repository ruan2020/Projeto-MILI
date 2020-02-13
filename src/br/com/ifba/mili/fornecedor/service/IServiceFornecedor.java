package br.com.ifba.mili.fornecedor.service;

import br.com.ifba.mili.fornecedor.model.Fornecedor;
import java.util.List;

/**
 *
 * @author ruan
 */

public interface IServiceFornecedor {
    
    /** Esse método é usado para procurar um fornecedor no banco de dados com base no parâmetro informado.
     * 
     * @param id ID do fornecedor usado na busca do banco de dados.
     * @return Se encontrado, retorna um objeto Fornecedor, se não encontrar retorna null.
     */
    public abstract Fornecedor findById (long id);
    
    /** Esse método é usado para procurar um fornecedor no banco de dados com base no parâmetro informado.
     * 
     * @param cnpj CNPJ do fornecedor usado na busca do banco de dados.
     * @return Se encontrado, retorna um objeto Fornecedor, se não encontrar retorna null.
     */
    public abstract Fornecedor findByCNPJ (String cnpj);
    
    /** Esse método é usado para procurar todos os fornecedores salvosno banco.
     * 
     * @return Retorna uma lista com todos os dados dos fornecedores salvos.
     */
    public abstract List<Fornecedor> findAll ();
    
    /** Esse método é usado para salvar um fornecedor no banco de dados.
     * 
     * @param fornecedor Objeto salvo no banco de dados.
     * @return Retorna o objeto salvo do banco de dados.
     */
    public abstract Fornecedor save (Fornecedor fornecedor);
    
    /** Esse método é usado para atualizar os dados dosfornecedores no banco de dados.
     * 
     * @param fornecedor Objeto com os novos dados do fornecedor. 
     * @return Retorna o objeto atualizado do banco de dados.
     */
    public abstract Fornecedor update (Fornecedor fornecedor);
    
    /** Esse método é usado para excluir um fornecedor do banco de dados.
     * 
     * @param fornecedor Objeto que terá os dados ecluídos.
     */
    public abstract void delete (Fornecedor fornecedor);
}