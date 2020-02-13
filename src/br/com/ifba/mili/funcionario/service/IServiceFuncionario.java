package br.com.ifba.mili.funcionario.service;

import br.com.ifba.mili.funcionario.model.Funcionario;
import java.util.List;

/**
 *
 * @author ruan
 */

public interface IServiceFuncionario {
    
    /** Esse método é usado para procurar um funcionário no banco de dados com base no parâmetro informado.
     * 
     * @param id ID do funcionário usado na busca do banco de dados.
     * @return Se encontrado, retorna um objeto Funcionario, se não encontrar retorna null.
     */
    public abstract Funcionario findById (long id);
    
    /** Esse método é usado para procurar um funcionário no banco de dados com base no parâmetro informado.
     * 
     * @param cpf CPF do funcionário usado na busca do banco de dados.
     * @return Se encontrado, retorna um objeto Funcionario, se não encontrar retorna null.
     */
    public abstract Funcionario findByCPF (String cpf);
    
    /** Esse método é usado para procurar todos os funcionários salvos no banco.
     * 
     * @return Retorna uma lista com os dados de todos os funcionários salvos.
     */
    public abstract List<Funcionario> findAll ();
    
    /** Esse método é usado para salvarum funcionário no banco de dados.
     * 
     * @param funcionario Objeto salvo no banco de dados.
     * @return Retorna o objeto salvo no banco.
     */
    public abstract Funcionario save (Funcionario funcionario);
    
    /** Esse método e usado para atualizar os daddos do funcionário no banco de dados.
     * 
     * @param funcionario Objeto com os dados atualizados. 
     * @return Retorna o objeto salvo no banco.
     */
    public abstract Funcionario update (Funcionario funcionario);
    
    /** Esse método é usado para excluir um funcionário do banco de dados.
     * 
     * @param funcionario Objeto funcionário que terá os dados excluídos.
     */
    public abstract void delete (Funcionario funcionario);
    
    /** Esse método é usado para fazer login no sistema.
     * 
     * @param funcionario Objeto com os dados de login do funcionário.
     * @return Retorna um inteiro informando o status do login. 
     * Retorna Se o CPF e senha informados não pertencer a nenhum funcionário cadastrado, retornará 0.
     * Retorna Se o CPF e senha informadospertencer ao gerente, retornará 1.
     * Retorna Se o CPF e senha informados pertencer a algum funcionário cadastrado, retornará 2.
     */
    public abstract int login (Funcionario funcionario);
}