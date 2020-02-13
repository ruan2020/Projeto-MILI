package br.com.ifba.mili.infraestrutura.service;

import br.com.ifba.mili.cliente.model.Cliente;
import br.com.ifba.mili.cliente.service.IServiceCliente;
import br.com.ifba.mili.cliente.service.ServiceCliente;
import br.com.ifba.mili.fornecedor.model.Fornecedor;
import br.com.ifba.mili.fornecedor.service.IServiceFornecedor;
import br.com.ifba.mili.fornecedor.service.ServiceFornecedor;
import br.com.ifba.mili.funcionario.model.Funcionario;
import br.com.ifba.mili.funcionario.service.IServiceFuncionario;
import br.com.ifba.mili.funcionario.service.ServiceFuncionario;
import br.com.ifba.mili.produto.model.Produto;
import br.com.ifba.mili.produto.service.IServiceProduto;
import br.com.ifba.mili.produto.service.ServiceProduto;
import java.util.List;

/**
 *
 * @author ruan
 */

public class Fachada implements IFachada {
    private volatile static Fachada instance; 
    
    /* Padrão Singleton */
    
    public static Fachada getInstance() {
        if (instance == null) {
            synchronized (Fachada.class) {
                if (instance == null) {
                    instance = new Fachada();
                }
            }
        }
        
        return instance;
    }
    
    /* ********************************************
    *  ***************** CLIENTE ****************** 
    *  ********************************************/

    private final IServiceCliente serviceCliente = new ServiceCliente();
    
    /* Esse método é usado para buscar e retornar todos os dados de um cliente com base no seu id */
    
    @Override
    public Cliente findByIdCliente(long id) {
        return serviceCliente.findById(id);
    }

    /* Esse método é usado para buscar e retornar todos os dados de um cliente com base no seu CPF */
    
    @Override
    public Cliente findByCPFCliente(String cpf) {
        return serviceCliente.findByCPF(cpf);
    
    }
    
    /* Esse método é usado para buscar e retornar todos os dados de todos os clientes salvos no banco de dados */
    
    @Override
    public List<Cliente> findAllCliente() {
        return serviceCliente.findAll();
    }
    
    /* Esse método é usado para salvar um cliente no banco de dados */
    
    @Override
    public Cliente saveCliente(Cliente cliente) {
        return serviceCliente.save(cliente);
    }

    /* Esse método é  usado para atualizar os dados do cliente no banco de dados */
    
    @Override
    public Cliente updateCliente(Cliente cliente) {
        return serviceCliente.update(cliente);
    }
    
    /* Esse método é usado para excluir um cliente do banco de dados */
    
    @Override
    public void deleteCliente(Cliente cliente) {
        serviceCliente.delete(cliente);
    }
    
    /* ********************************************
    *  *************** FORNECEDOR ***************** 
    *  ********************************************/
    
    private final IServiceFornecedor serviceFornecedor = new ServiceFornecedor();
    
    /* Esse método é usado para buscar e retornar todos os dados de um fornecedor com base no seu id */
    
    @Override
    public Fornecedor findByIdFornecedor(long id) {
        return serviceFornecedor.findById(id);
    }

    /* Esse método é usado para buscar e retornar todos os dados de um fornecedor com base no seu CNPJ */
    
    @Override
    public Fornecedor findByCNPJFornecedor(String cnpj) {
        return serviceFornecedor.findByCNPJ(cnpj);
    }
    
    /* Esse método é usado para buscar e retornar todos os dados dos fornecedores salvos no banco de dados  */
    
    @Override
    public List<Fornecedor> findAllFornecedor() {
        return serviceFornecedor.findAll();
    }

    /* Esse método é usado para salva um fornecedor no banco de dados */
    
    @Override
    public Fornecedor saveFornecedor(Fornecedor fornecedor) {
        return serviceFornecedor.save(fornecedor);
    }

    /* Esse método é usado para atualizar os dados de um fornecedor no banco de dados */
    
    @Override
    public Fornecedor updateFornecedor(Fornecedor fornecedor) {
        return serviceFornecedor.update(fornecedor);
    }
    
    /* Esse método é usado para excluir um fornecedor do banco de dados */
    
    @Override
    public void deleteFornecedor(Fornecedor fornecedor) {
        serviceFornecedor.delete(fornecedor);
    }
    
    /* ********************************************
    *  *************** FUNCIONÁRIO **************** 
    *  ********************************************/
    
    private final IServiceFuncionario serviceFuncionario = new ServiceFuncionario();
   
    /* Esse método é usado para buscar e retornar todos os dados de um funcionário com base no seu id */
    
    @Override
    public Funcionario findByIdFuncionario (long id) {
        return serviceFuncionario.findById(id);
    }

    /* Esse método é usado para buscar e retornar todos os dados de um funcionário com base no seu CPF */
    
    @Override
    public Funcionario findByCPFFuncionario(String cpf) {
        return serviceFuncionario.findByCPF(cpf);
    }
    
    /* Esse método é usado para buscar e retornar todos os dados dos funcionários salvos no banco de dados  */
    
    @Override
    public List<Funcionario> findAllFuncionario () {
        return serviceFuncionario.findAll();
    }
    
    /* Esse método é usado para salvar um funcionário no banco de dados */
    
    @Override
    public Funcionario saveFuncionario (Funcionario funcionario) {
        return serviceFuncionario.save(funcionario);
    }
    
    /* Esse método é usado para atualizar os dados de um funcionário no banco de dados */
    
    @Override
    public Funcionario updateFuncionario (Funcionario funcionario) {
        return serviceFuncionario.update(funcionario);
    }
    
    /* Esse método é usado para excluir um funcionário do banco de dados */
    
    @Override
    public void deleteFuncionario (Funcionario funcionario) {
        serviceFuncionario.delete(funcionario);
    }

    /* Esse método é usado No login do funcionário no sistema com CPF e senha informados */
    
    @Override
    public int loginFuncionario(Funcionario funcionario) {
        return serviceFuncionario.login(funcionario);
    }
    
    /* ********************************************
    *  ***************** PRODUTO ****************** 
    *  ********************************************/
    
    private final IServiceProduto serviceProduto = new ServiceProduto();
    
    /* Esse método é usado para Pprocurar e retornar todos os dados de um produto com base no seu id */
    
    @Override
    public Produto findByIdProduto(long id) {
        return serviceProduto.findById(id);
    }

    /* Esse método é usado para buscar e retornar todos os dados de um produto com base no seu código de barras */
    
    @Override
    public Produto findByCodigoBarras(String codigo) {
        return serviceProduto.findByCodigoBarras(codigo);
    }

    /* Esse método é usado para buscar e retornar todos os dados de um produto com base no seu nome */
    
    @Override
    public List<Produto> findByName(String nome) {
        return serviceProduto.findByName(nome);
    }
    
    /* Esse método é usado para buscar e retornar todos os dados de todos os produtos salvos no banco de dados  */
    
    @Override
    public List<Produto> findAllProduto() {
        return serviceProduto.findAll();
    }
    
    /* Esse método é usado para salvar um produto no banco de dados */
    
    @Override
    public Produto saveProduto (Produto produto){
        return serviceProduto.save(produto);
    }

    /* Esse método é usado para atualizar os dados de um produto no banco de dados */
    
    @Override
    public Produto updateProduto(Produto produto) {
        return serviceProduto.update(produto);
    }

    /* Esse método é usado para excluir um produto do banco de dados */
    
    @Override
    public void deleteProduto(Produto produto) {
        serviceProduto.delete(produto);
    }
}