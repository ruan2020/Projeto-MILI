package br.com.ifba.mili.cliente.service;

import br.com.ifba.mili.cliente.dao.ClienteDAO;
import br.com.ifba.mili.cliente.dao.IClienteDAO;
import br.com.ifba.mili.cliente.model.Cliente;
import br.com.ifba.mili.infraestrutura.exception.BusinessException;
import br.com.ifba.mili.infraestrutura.suport.StringUtil;
import java.util.List;

/**
 *
 * @author ruan
 */

public class ServiceCliente implements IServiceCliente {
    public final static String CLIENTE_NULL = "O cliente é nulo!";
    public final static String CLIENTE_EXISTE = "O cliente já existe!";
    public final static String CLIENTE_NAO_EXISTE = "O cliente não existe!";
    public final static String CLIENTE_INVALIDO = "Cliente inválido!";
    
    private final IClienteDAO clienteDAO = new ClienteDAO();
    
    /* Esse método é usado para procurar um cliente no banco de dados com base no id */
    
    @Override
    public Cliente findById(long id) {
        return clienteDAO.findById(id);
    }
    
    /* Esse método é usado para procurar um cliente no banco de dados com base no CPF */
    
    @Override
    public Cliente findByCPF(String cpf) {
        return clienteDAO.findByCPF(cpf);
    }
    
    /* Esse método é usado para listar todos os cliente do banco */
    
    @Override
    public List<Cliente> findAll() {
        return clienteDAO.findAll();
    }
    
    /* Esse método é usado para salvar um cliente no banco */
    
    @Override
    public Cliente save(Cliente cliente) {
        
        /* Verifica se o objeto é nulo */
        
        if (cliente == null) {
            return null;
        }
        
        /* Verifica se o CPF informado já existe */
        
        else if (findByCPF(cliente.getCPF()) != null) {
            return null;
        }
        
        /* Verifica se os dados do cliente estão corretos */
        
        else if (!validarCliente(cliente)) {
            return null;
        }
        
        /* Salva o cliente no banco */
        
        else {
            return clienteDAO.save(cliente);
        }
    }

    /* Esse método é usado para atualizar os dados de um cliente no banco de dados */
    
    @Override
    public Cliente update(Cliente cliente) {
        
        /* Verifica se o objeto é nulo */
        
        if (cliente == null) {
            return null;
        }
        
        /* Verifica se o cliente já foi codastrado */
        
        else if (findById(cliente.getId()) == null) {
            return null;
        }
        
        /* Verifica se os dados do cliente estão corretos */
        
        else if (!validarCliente(cliente)){
            return null;
        }
        
        /* Atualiza os dados do cliente */
        
        else {
            return clienteDAO.update(cliente);
        }
    }

    /* Esse método é usado para excluir um cliente do banco de dados */
    
    @Override
    public void delete(Cliente cliente) {
        
        /* Verifica se o objeto é nulo */
        
        if (cliente == null) {
            throw new BusinessException (CLIENTE_NULL);
        }
        
        /* Verifica se o cliente já foi cadastrado */
        
        else if (clienteDAO.findById(cliente.getId()) == null) {
            throw new BusinessException (CLIENTE_NAO_EXISTE);
        }
        
        /* Exclui os dados do cliente */
        
        else {
            clienteDAO.delete(cliente);
        }
    }
    
    /* Esse método é usado para verificar se os dados do cliente estão corretos */
    
    private boolean validarCliente (Cliente cliente) {
        
        StringUtil util = new StringUtil();
        
        /* Verifica se o objeto é nulo */
        
        if (cliente == null) {
            return false;
        }
        
        /* Verifica o nome do cliente */
        
        if (util.isNullOrEmpty(cliente.getNome())){
            return false;
        }
        
        /* Verifica o sexo do cliente */
        
        if (util.isNullOrEmpty(cliente.getSexo())) {
            return false;
        }
        
        /* Verifica o CPF do cliente */
        
        if (util.isNullOrEmpty(cliente.getCPF())) {
            return false;
        }
        
        return true;
    }
}