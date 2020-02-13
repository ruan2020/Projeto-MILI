package br.com.ifba.mili.fornecedor.service;

import br.com.ifba.mili.fornecedor.dao.FornecedorDAO;
import br.com.ifba.mili.fornecedor.dao.IFornecedorDAO;
import br.com.ifba.mili.fornecedor.model.Fornecedor;
import br.com.ifba.mili.infraestrutura.exception.BusinessException;
import br.com.ifba.mili.infraestrutura.suport.StringUtil;
import java.util.List;

/**
 *
 * @author ruan
 */

public class ServiceFornecedor implements IServiceFornecedor {
    public final static String FORNECEDOR_NULL = "O fornecedor é nulo!";
    public final static String FORNECEDOR_EXISTE = "O fornecedor já existe!";
    public final static String FORNECEDOR_NAO_EXISTE = "O fornecedor não existe!";
    public final static String FORNECEDOR_INVALIDO = "Fornecedor inválido!";
    
    private final IFornecedorDAO fornecedorDAO = new FornecedorDAO();
    
    /* Esse método é usado para procurar um fornecedor com base no id */
    
    @Override
    public Fornecedor findById(long id) {
        return fornecedorDAO.findById(id);
    }

    /* Esse método é usado para procurar um fornecedor com base no CNPJ */
    
    @Override
    public Fornecedor findByCNPJ(String cnpj) {
        return fornecedorDAO.findByCNPJ(cnpj);
    }
    
    /* Esse método é usado para listar todos os fornecedores do banco de dados */
    
    @Override
    public List<Fornecedor> findAll() {
        return fornecedorDAO.findAll();
    }

    /* Esse método é usado para salvar um fornecedor no banco de dados */
    
    @Override
    public Fornecedor save(Fornecedor fornecedor) {
        
        /* Verifica se o objeto é nulo */
        
        if (fornecedor == null) {
            return null;
        }
        
        /* Verifica se o CNPJ informado já foi cadastrado */
        
        else if (findByCNPJ(fornecedor.getCNPJ()) != null) {
            return null;
        }
        
        /* Verifica se os dados do fornecedor estão corretos */
        
        else if (!validarFornecedor(fornecedor)) {
            return null;
        }
        
        /* Salva o fornecedor no banco de dados */
        
        else {
            return fornecedorDAO.save(fornecedor);
        }
    }
    
    /* Esse método é usado para atualizar os dados do fornecedor no banco */
    
    @Override
    public Fornecedor update(Fornecedor fornecedor) {
        
        /* Verifica se o objeto é nulo */
        
        if (fornecedor == null) {
            return null;
        }
        
        /* Verifica se o fornecedor já ffoi cadastrado */
        
        else if (findById(fornecedor.getId()) == null) {
            return null;
        }
        
        /* Verifica se os dados do fornecedor estão corretos */
        
        else if (!validarFornecedor(fornecedor)) {
            return null;
        }
        
        /* Atualiza os dados do fornecedor no banco de dados */
        
        else {
            return fornecedorDAO.update(fornecedor);
        }
    }

    /* Esse método é usado para excluir um fornecedor do banco */
    
    @Override
    public void delete(Fornecedor fornecedor) {
        
        /* Verifica se o objeto é nulo */
        
        if (fornecedor == null) {
            throw new BusinessException (FORNECEDOR_NULL);
        }
        
        /* Verifica se o fornecedor já foi cadastrado */
        
        else if (fornecedorDAO.findById(fornecedor.getId()) == null) {
            throw new BusinessException (FORNECEDOR_NAO_EXISTE);
        }
        
        /* Exclui os dados do fornecedor do banco de dados */
        
        else {
            fornecedorDAO.delete(fornecedor);
        }
    }
    
    /* Esse método é usado para verificar se os dados do fornecedor estão corretos */
    
    private boolean validarFornecedor (Fornecedor fornecedor) {
        
        StringUtil util = new StringUtil();
        
        /* Verifica se o objeto é nulo */
        
        if (fornecedor == null) {
            return false;
        }
        
        /* Verifica a razão social do fornecedor */
        
        if (util.isNullOrEmpty(fornecedor.getRazaoSocial())) {
            return false;
        }
        
        /* Verifica o CNPJ do fornecedor */
        
        if (util.isNullOrEmpty(fornecedor.getCNPJ())) {
            return false;
        }
        
        return true;
    }
}