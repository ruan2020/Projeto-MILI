package br.com.ifba.mili.funcionario.dao;

import br.com.ifba.mili.funcionario.model.Funcionario;
import br.com.ifba.mili.infraestrutura.dao.GenericDAO;
import javax.persistence.NoResultException;

/**
 *
 * @author ruan
 */

public class FuncionarioDAO extends GenericDAO<Funcionario> implements IFuncionarioDAO {
    
    /* 
        Procura um funcionário no banco com CPF e Senha iguais aos informados. 
        Se encontrar, retorna um inteiro, se não encontrar retorna 0.
        retorna 2 caso exista.
    */
    
    @Override
    public int login(Funcionario funcionario) {
        String sql = "FROM Funcionario WHERE cpf = '" + funcionario.getCPF() + "' AND senha = '" + funcionario.getSenha() + "'";
        
        try {
            return  entityManager.createQuery(sql).getSingleResult() != null ? 2 : 0;
        } catch (NoResultException ex) {}
        
        return 0;
    }

    /*
        Procura um funcionário no banco com CPF igual ao informado. 
        Se encontrar, retorna um objeto Funcionario, se não encontrar retorna null. 
    */
    
    @Override
    public Funcionario findByCPF(String cpf) {
        String sql = "FROM Funcionario WHERE cpf = '" + cpf + "'";
        
        try {
            return (Funcionario) entityManager.createQuery(sql).getSingleResult();
        } catch (NoResultException ex) {}
         
        return null;
    }
}