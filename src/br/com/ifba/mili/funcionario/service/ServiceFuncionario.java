package br.com.ifba.mili.funcionario.service;

import br.com.ifba.mili.funcionario.dao.FuncionarioDAO;
import br.com.ifba.mili.funcionario.dao.IFuncionarioDAO;
import br.com.ifba.mili.funcionario.model.Funcionario;
import br.com.ifba.mili.infraestrutura.exception.BusinessException;
import br.com.ifba.mili.infraestrutura.suport.StringUtil;
import java.util.List;

/**
 *
 * @author ruan
 */

public class ServiceFuncionario implements IServiceFuncionario {
    public final static String FUNCIONARIO_NULL = "O funcionário é nulo!";
    public final static String FUNCIONARIO_EXISTE = "O funcionário já existe!";
    public final static String FUNCIONARIO_NAO_EXISTE = "O funcionário não existe!";
    public final static String FUNCIONARIO_INVALIDO = "Funcionário inválido!";
    
    private final IFuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    
    /* Esse método é usado para procurar um funcionário com base no id */
    
    @Override
    public Funcionario findById(long id) {
        return funcionarioDAO.findById(id);
    }

    /* Esse método é usado para procurar um funcionário com base no CPF */
    
    @Override
    public Funcionario findByCPF(String cpf) {
        return funcionarioDAO.findByCPF(cpf);
    }
    
    /* Esse método é usado para listar todos os funcionários do banco de dados */
    
    @Override
    public List<Funcionario> findAll() {
        return funcionarioDAO.findAll();
    }
    
    /* Esse método é usado para salvar um funcionário no banco de dados */
    
    @Override
    public Funcionario save(Funcionario funcionario) {
        
        /* Verifica se o objeto é nulo */
        
        if (funcionario == null) {
            return null;
        }
        
        /* Verifica se o CPF do funcionário já está cadastrado no banco de dados */
        
        else if (findByCPF(funcionario.getCPF()) != null) {
            return null;            
        }
        
        /* Verifica se os dados do funcionário estão corretos */
        
        else if (!validarFuncionario(funcionario)) {
            return null;
        }
        
        /* Salva o funcionário no banco de dados */
        
        else {
            return funcionarioDAO.save(funcionario);
        }
    }

    /* Esse método é usado para atualizar os dados do funcionário no banco */
    
    @Override
    public Funcionario update(Funcionario funcionario) {
        
        /* Verifica se o objeto é nulo */
        
        if (funcionario == null) {
            return null;
        }
        
        /* Verifica se o funcionário está cadatsrado no banco */
        
        else if (findById(funcionario.getId()) == null) {
            return null;
        }
        
        /* Verifica se os dados do funcionário estão corretos */
        
        else if (!validarFuncionario(funcionario)) {
            return null;
        }
        
        /* Atualiza os dados do funcionário no banco */
        
        else {
            return funcionarioDAO.update(funcionario);
        }
    }

    /* Esse método é usado para excluir um funcionário do banco */
    
    @Override
    public void delete(Funcionario funcionario) {
        
        /* Verifica se o objeto é nulo */
        
        if (funcionario == null) {
            throw new BusinessException (FUNCIONARIO_NULL);
        }
        
        /* Verifica se o funcionário está cadastrado no banco */
        
        else if (funcionarioDAO.findById(funcionario.getId()) == null) {
            throw new BusinessException (FUNCIONARIO_NAO_EXISTE);
        }
        
        /* Exclui os dados do funcionário do banco */
        
        else {
            funcionarioDAO.delete(funcionario);
        }
    }
    
    /* 
    *  Esse método é usado para verifica os dados de login.
    *  Se não encontrar, retorna 0.
    *  Se o funcionário for gerente, retorna 1.
    *  Se for apenas funcionário, retorna 2.
    */
    
    @Override
    public int login(Funcionario funcionario) {
        
        /* Verifica se o objeto é nulo */
        
        if (funcionario == null) {
            throw new BusinessException (FUNCIONARIO_NULL);
        }
        
        /* Verifica se os dados informados são do funcionário gerente */
        
        else if(funcionario.getCPF().equals("12345678911") && funcionario.getSenha().equals("1221")){
            return 1;
        }
        
        /* Verifica se os dados informados pertencem a um funcionário cadastrado */
        
        else {
            return funcionarioDAO.login(funcionario);
        }
    }
    
    /* Esse método é usado para verificar se os dados do funcionário estão corretos */
    
    public boolean validarFuncionario (Funcionario funcionario) {
        
        StringUtil util = StringUtil.getInstance();
        
        /* Verifica se o objeto é nulo */
        
        if (funcionario == null) {
            return false;
        }
        
        /* Verifica o nome do funcionário */
        
        if (util.isNullOrEmpty(funcionario.getNome())){
            return false;
        }
        
        /* Verifica o sexo do funcionário */
        
        if (util.isNullOrEmpty(funcionario.getSexo())){
            return false;
        }
        
        /* Verifica o CPF do funcionário */
        
        if (util.isNullOrEmpty(funcionario.getCPF())) {
            return false;
        }
        
        /* Verifica a senha do funcionário */
        
        if (util.isNullOrEmpty(funcionario.getSenha())){
            return false;
        }
        
        return true;
    }
}