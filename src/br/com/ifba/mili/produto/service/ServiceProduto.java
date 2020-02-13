package br.com.ifba.mili.produto.service;

import br.com.ifba.mili.infraestrutura.exception.BusinessException;
import br.com.ifba.mili.infraestrutura.suport.StringUtil;
import br.com.ifba.mili.produto.dao.IProdutoDAO;
import br.com.ifba.mili.produto.dao.ProdutoDAO;
import br.com.ifba.mili.produto.model.Produto;
import java.util.List;

/**
 *
 * @author ruan
 */

public class ServiceProduto implements IServiceProduto {
    public final static String PRODUTO_NULL = "O produto é nulo!";
    public final static String PRODUTO_EXISTE = "O produto já existe!";
    public final static String PRODUTO_NAO_EXISTE = "O produto não existe!";
    public final static String PRODUTO_INVALIDO = "Produto inválido!";
    
    private final IProdutoDAO produtoDAO = new ProdutoDAO();

    /* Esse método é usado para buscar um produto com base no id */
    
    @Override
    public Produto findById(long id) {
        return produtoDAO.findById(id);
    }

    /* Esse método é usado para buscar um produto com base no código */
    
    @Override
    public Produto findByCodigoBarras(String codigo) {
        return produtoDAO.findByCodigoBarras(codigo);
    
    }
    
    /* Esse método é usado para listar todos os produtos com o nome igual ao informado */
    
    @Override
    public List<Produto> findByName(String name) {
        return produtoDAO.findByName(name);
    
    }
    /* Esse método é usado para listar todos os produtos do banco de dados */
    
    @Override
    public List<Produto> findAll() {
        return produtoDAO.findAll();
    }
    
    /* Esse método é usado para salvar um produto no banco de dados */
    
    @Override
    public Produto save(Produto produto) {
        
        /* Verifica se o objeto é nulo */
        
        if (produto == null) {
            return null;
        }
        
        /* Verifica se um produto já foi cadastrado com o mesmo código de barras no banco de dados */
        
        else if (findByCodigoBarras(produto.getCodigoBarras()) != null) {
            return null;
        }
        
        /* Verifica se os dados do produto estão corretos */
        
        else if (!validarProduto(produto)) {
            return null;
        }
        
        /* Salva o produto no banco de dados */
        
        else {
            return produtoDAO.save(produto);
        }
    }

    /* Esse método é usado para atualizar os dados de um produto no banco de dados */
    
    @Override
    public Produto update(Produto produto) {
        
        /* Verifica se o objeto é nulo */
        
        if (produto == null) {
            return null;
        }
        
        /* Verifica se o produto foi cadastrado no banco de dados */
        
        else if (findById(produto.getId()) == null) {
            return null;
        }
        
        /* Verifica se os dados do produto estão corretos */
        
        else if (!validarProduto(produto)) {
            return null;
        }
        
        /* Atualiza os dados do produto no banco de dados */
        
        else {
            return produtoDAO.update(produto);
        }
    }

    /* Esse método é usado para excluir um produto do banco de dados */
    
    @Override
    public void delete(Produto produto) {
        
        /* Verifica se o objeto é nulo */
        
        if (produto == null) {
            throw new BusinessException (PRODUTO_NULL);
        }
        
        /* Verifica se o produto está cadatsrado no banco de dados */
        
        else if (findById(produto.getId()) == null) {
            throw new BusinessException (PRODUTO_NAO_EXISTE);
        }
        
        /* Exclui os dados do produto do banco de dados */
        
        else {
            produtoDAO.delete(produto);
        }
    }
    
    /* Esse método é usado para verificar se os dados do produto estão corretos */
    
    private boolean validarProduto (Produto produto) {
        
        StringUtil util = new StringUtil();
        
        /* Verifica se o objeto é nulo */
        
        if (produto == null) {
            return false;
        }
        
        /* Verifica o nome do produto */
        
        if (util.isNullOrEmpty(produto.getNome())){
            return false;
        }
        
        /* Verifica o código de barras do produto */
        
        if (util.isNullOrEmpty(produto.getCodigoBarras())) {
            return false;
        }
        
        /* Verifica se o preço do produto é menor ou igual a zero */
        
        if (produto.getPreco() <= 0) {
            return false;
        }
        
        /* Verifica se o estoque do produto é menor que zero */
        
        if (produto.getEstoque() < 0) {
            return false;
        }
        
        return true;
    }
}