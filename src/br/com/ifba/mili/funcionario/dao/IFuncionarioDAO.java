package br.com.ifba.mili.funcionario.dao;

import br.com.ifba.mili.funcionario.model.Funcionario;
import br.com.ifba.mili.infraestrutura.dao.IGenericDAO;

/**
 *
 * @author ruan
 */

public interface IFuncionarioDAO extends IGenericDAO<Funcionario>{
    
    /** Esse método é usado para entrar no sistema.
     * 
     * @param funcionario Objeto contendo o login do funcionário.
     * @return Retorna um inteiro informando o status do login. 
     * Retorna Se o CPF informmado não pertencer a nenhum funcionário cadastrado, retorna 0.
     * Retorna Se o CPF e senha informado pertencer a algum funcionário cadastrado retorna 2.
     */
    public abstract int login (Funcionario funcionario);
    
    /** Esse método é usado para procurar um funcionário no banco  de dados com base nos parâmtros apresentados.
     * 
     * @param cpf CPF do funcionário usado na consulta do banco de dados.
     * @return Se encontrar, retorna um objeto Funcionario, se não encontrar retorna null.
     */
    public abstract Funcionario findByCPF (String cpf);
}