package br.com.ifba.mili.cliente.dao;

import br.com.ifba.mili.cliente.model.Cliente;
import br.com.ifba.mili.infraestrutura.dao.IGenericDAO;

/**
 *
 * @author ruan
 */

public interface IClienteDAO extends IGenericDAO<Cliente>{
    
    /** Esse método é usado para procurar um cliente, no banco de dados, com base no parâmetro informado.
     * 
     * @param cpf CPF do cliente usado durante a sua busca.
     * @return Se encontrado, retorna um objeto Cliente, se não encontrar retorna null. 
     */
    public abstract Cliente findByCPF (String cpf);
}