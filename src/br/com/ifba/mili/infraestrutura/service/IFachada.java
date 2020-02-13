package br.com.ifba.mili.infraestrutura.service;

import br.com.ifba.mili.cliente.model.Cliente;
import br.com.ifba.mili.fornecedor.model.Fornecedor;
import br.com.ifba.mili.funcionario.model.Funcionario;
import br.com.ifba.mili.produto.model.Produto;
import java.util.List;

/**
 *
 * @author ruan
 */

public interface IFachada {
    
    /* ********************************************
    *  ***************** CLIENTE ****************** 
    *  ********************************************/
    
    /** Esse método é usado para buscar um cliente no anco de dados com base no parâmetro informado.
     * 
     * @param id ID do cliente usado na busca do banco de dados.
     * @return Se encontrar, retorna um objeto Cliente com todos os seus dados. 
     */
    public abstract Cliente findByIdCliente (long id);
    
    /** Esse método é usado para buscar um cliente no banco de dadoscom base no parâmetro informado.
     * 
     * @param cpf CPF do cliente usado na busca do banco de dados.
     * @return Se encontrar, returna um objeto Cliente com todos os seus dados.
     */
    public abstract Cliente findByCPFCliente (String cpf);
    
    /** Esse método é usado para buscar todos os clientes salvos no banco de dados.
     * 
     * @return Retorna uma lista com todos os dados dos clientes salvos no banco de dados.
     */
    public abstract List<Cliente> findAllCliente ();
    
    /** Esse método é usado para salvar um cliente no banco de dados.
     * 
     * @param cliente Objeto salvo no banco de dados.
     * @return Retorna o objeto salvo no banco de dados.
     */
    public abstract Cliente saveCliente (Cliente cliente);
    
    /** Esse método é usado para atualizar os dados do cliente no banco de dados.
     * 
     * @param cliente Objeto comos dadosatualizados do cliente.
     * @return Retorna o objeto atualizado do banco de dados.
     */
    public abstract Cliente updateCliente (Cliente cliente);
    
    /** Esse método é usado para excluir um cliente do banco de dados.
     * 
     * @param cliente Objeto com os dados do cliente que serão excluídos.
     */
    public abstract void deleteCliente (Cliente cliente);
    
    /* ********************************************
    *  *************** FORNECEDOR ***************** 
    *  ********************************************/
    
    /** Esse método é usado para buscar um fornecedor no banco de dados com base no parâmetro informado.
     * 
     * @param id ID do fornecedor usado na busca no banco de dados.
     * @return Se encontrar, retorna um objeto Fornecedor, se não encontrar retorna null.
     */
    
    public abstract Fornecedor findByIdFornecedor (long id);
    
    /** Esse método é usado para buscar um fornecedor no banco de dados com base no parâmetro informado.
     * 
     * @param cnpj CNPJ do fornecedor usado na busca no banco de dados.
     * @return Se encontrar, retorna um objeto Fornecedor, se não encontrar retorna null.
     */
    
    public abstract Fornecedor findByCNPJFornecedor (String cnpj);
    
    /** Esse método é usado para buscar todos os fornecedores salos no banco de dados.
     * 
     * @return Retorna uma lista com todos os dados dos fornecedores salvos no banco de dados.
     */
    
    public abstract List<Fornecedor> findAllFornecedor ();
    
    /** Esse método é usado para salvar um fornecedor no banco de dados.
     * 
     * @param fornecedor Objeto salvo no banco de dados.
     * @return Retorna o objeto salvo no banco de dados.
     */
    public abstract Fornecedor saveFornecedor (Fornecedor fornecedor);
    
    /** Esse método é usado para atualizar os dados do fornecedor no banco de dados.
     * 
     * @param fornecedor Objeto com os dados atualizados do fornecedor. 
     * @return Retorna o objeto atualizado do banco de dados.
     */
    public abstract Fornecedor updateFornecedor (Fornecedor fornecedor);
    
    /** Esse método é usado para excluir um fornecedor do banco de dados.
     * 
     * @param fornecedor Objeto contendo os dados do fornecedor que serão excluídos.
     */
    public abstract void deleteFornecedor (Fornecedor fornecedor);
    
    /* ********************************************
    *  ************** FUNCIONÁRIO ***************** 
    *  ********************************************/
    
    /** Esse método é usado para buscar um funcionário no banco de dados com base no parâmetro informado.
     * 
     * @param id ID do funcionário usado na busca do banco de dados.
     * @return Se encontrado, retorna um objeto Funcionario, se não encontrar retorna null.
     */
    public abstract Funcionario findByIdFuncionario (long id);
    
    /** Esse método é usado para buscar um funcionário no banco de dados com base no parâmetro informado.
     * 
     * @param cpf CPF do funcionário usado na busca do banco de dados.
     * @return Se encontrado, retorna um objeto Funcionario, se não encontrar retorna null.
     */
    public abstract Funcionario findByCPFFuncionario (String cpf);
    
    /** Esse método é usado para buscar todos os funcionários salvos no banco de dados.
     * 
     * @return Retorna uma lista com todos os dados dos funcionários salvos no banco de dados.
     */
    public abstract List<Funcionario> findAllFuncionario ();
    
    /** Esse método é usado para salvar um funcionário no banco de dados.
     * 
     * @param funcionario Objeto salvo no banco de dados.
     * @return Retorna o objeto salvo do banco de dados.
     */
    public abstract Funcionario saveFuncionario (Funcionario funcionario);
    
    /** Esse método é usado para atualizar os dados de um funcionário no banco de dados.
     * 
     * @param funcionario Objeto com os dados atualizados do funcionário.
     * @return Retorna o objeto que foi atualizado no banco de dados.
     */
    public abstract Funcionario updateFuncionario (Funcionario funcionario);
    
    /** Esse método é usado para excluir um funcionário do banco de dados.
     * 
     * @param funcionario Objeto contendo os dados do funcionário que serão excluídos.
     */
    public abstract void deleteFuncionario (Funcionario funcionario);
    
    /** Esse método é usado para realizar login no sistema
     * 
     * @param funcionario Objeto contendo os dados de login do funcionário.
     * @return Retorna um inteiro informando o status do login. 
     * Se o CPF e senha informados não pertença a nenhum funcionário cadastrado, retorna 0.
     * Se o CPF e senha informados sejam do funcionário gerente, retorna 1.
     * Se o CPF e senha informados sejam de um funcionário cadastrado, retorna 2.
     */
    public abstract int loginFuncionario (Funcionario funcionario);
    
    /* ********************************************
    *  **************** PRODUTO ******************* 
    *  ********************************************/
    
    /** Esse método é usado para buscar um produto no banco de dados com base no parâmetro informado.
     * 
     * @param id ID do produto usado na busca no banco de dados.
     * @return Se encontrado, retorna um objeto Produto, se não encontrarretorna null.
     */
    
    public abstract Produto findByIdProduto (long id);
    
    /** Esse método é usado para buscar um produto no banco de dados com base no parâmetro informado.
     * 
     * @param codigo Código de barras do produto usado na busca no banco de dados.
     * @return Se encontrado, retorna um objeto Produto, se n~~ao encontrar retorna null.
     */
    
    public abstract Produto findByCodigoBarras (String codigo);
    
    /** Esse método é usado para buscar um produto no banco de dados com base no parâmetro informado.
     * 
     * @param name Nome do produto usado na busca no banco de dados.
     * @return Retorna uma lista com todos os dados dos produtos que possuirem um nome igual ao informado.
     */
    public abstract List<Produto> findByName (String name);
    
    /** Esse método é usado para buscar todos os produtos salvos no banco de dados.
     * 
     * @return Retorna uma lista com todos os dados dos produtos salvos no banco de dados.
     */
    public abstract List<Produto> findAllProduto ();
    
    /** Esse método é usado para salvar um produto no banco de dados.
     * 
     * @param produto Objeto salvo no banco de dados.
     * @return Retorna o objeto salvo no banco de dados.
     */
    public abstract Produto saveProduto (Produto produto);
    
    /** Esse método é usado para atualizar os dados do produto no banco de dados.
     * 
     * @param produto Objeto com os dados atuaizados do produto. 
     * @return Retorna o objeto atualizado no banco de dados.
     */
    public abstract Produto updateProduto (Produto produto);
    
    /** Esse método é usado para excluir um produto do banco de dados.
     * 
     * @param produto Objeto com os dados do produto que serão excluídos.
     */
    public abstract void deleteProduto (Produto produto);
}