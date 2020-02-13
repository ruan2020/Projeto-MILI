package br.com.ifba.mili.fornecedor.dao;

import br.com.ifba.mili.fornecedor.model.Fornecedor;
import br.com.ifba.mili.infraestrutura.dao.IGenericDAO;

/**
 *
 * @author ruan
 */

public interface IFornecedorDAO extends IGenericDAO<Fornecedor>{
    
    /** Esse mmétodo é usado para procurar um fornecedor no banco de dados com base no parâmetro informado.
     * 
     * @param cnpj CNPJ do fornecedor usado na busca do banco de dados.
     * @return Se encontrar, retorna um objeto Fornecedor, se não encontrar retorna null.
     */
    public abstract Fornecedor findByCNPJ (String cnpj);
}