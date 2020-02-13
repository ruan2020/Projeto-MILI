package br.com.ifba.mili.funcionario.tableModel;

import br.com.ifba.mili.funcionario.model.Funcionario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ruan
 */

public interface IFuncionarioTableModel {
    
    /* Lista de funcionários que aparecerão na tabela */
    public List<Funcionario> funcionarios = new ArrayList<>();
    
    /* Colunas da tabela */
    public String[] colunas = {"Nome", "RG"};
}