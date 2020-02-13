package br.com.ifba.mili.cliente.dao;

import br.com.ifba.mili.cliente.model.Cliente;
import br.com.ifba.mili.infraestrutura.dao.GenericDAO;
import javax.persistence.NoResultException;

/**
 *
 * @author ruan
 */

public class ClienteDAO extends GenericDAO<Cliente> implements IClienteDAO {
    
    /*
        Procura, no banco de dados, um cliente com CPF igual ao informado.
        Se encontrado, retorna um objeto Cliente, se não encontrar retorna null.
    */
    
    @Override
    public Cliente findByCPF(String cpf) {
        String sql = "FROM Cliente WHERE cpf = '" + cpf + "'";
        
        try {
            return (Cliente) entityManager.createQuery(sql).getSingleResult();
        } catch (NoResultException ex) {}
        
        return null;
    }
}