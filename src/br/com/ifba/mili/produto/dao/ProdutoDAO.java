package br.com.ifba.mili.produto.dao;

import br.com.ifba.mili.infraestrutura.dao.GenericDAO;
import br.com.ifba.mili.produto.model.Produto;
import java.util.List;
import javax.persistence.NoResultException;

/**
 *
 * @author ruan
 */

public class ProdutoDAO extends GenericDAO<Produto> implements IProdutoDAO {
    
    /*
        Procura no banco um produto que possui o código de barras igual ao informado na consulta.
        Se encontrar, retorna um objeto Produto, se não encontrar retorna null.
    */
    
    @Override
    public Produto findByCodigoBarras(String codigo) {
        String sql = "FROM Produto WHERE codigoBarras = '" + codigo + "'";
        
        try {
            return (Produto) entityManager.createQuery(sql).getSingleResult();
        } catch (NoResultException ex) {}
        
        return null;
    }
    
    /*
        Procura no banco produtos com nome igual ao informado na consulta.
        Retorna uma lista com os produtos.
    */
    
    @Override
    public List<Produto> findByName(String name) {
        String sql = "FROM Produto WHERE nome LIKE '%" + name + "%'";
        
        try {
            return entityManager.createQuery(sql).getResultList();
        } catch (NoResultException ex) {}
        
        return null;
    }
}