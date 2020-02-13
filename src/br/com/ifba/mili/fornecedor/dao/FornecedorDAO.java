package br.com.ifba.mili.fornecedor.dao;

import br.com.ifba.mili.fornecedor.model.Fornecedor;
import br.com.ifba.mili.infraestrutura.dao.GenericDAO;
import javax.persistence.NoResultException;

/**
 *
 * @author ruan
 */

public class FornecedorDAO extends GenericDAO<Fornecedor> implements IFornecedorDAO {
    
    /*
        Procura no banco de dados um fornecedor com CNPJ igual ao informado. 
        Se encontrado, retorna um objeto Fornecedor, se não encontrar retorna null.
    */
    
    @Override
    public Fornecedor findByCNPJ(String cnpj) {
        String sql = "FROM Fornecedor WHERE cnpj = '" + cnpj + "'";
        
        try {
            return (Fornecedor) entityManager.createQuery(sql).getSingleResult();
        } catch (NoResultException ex) {}
        
        return null;
    }
}