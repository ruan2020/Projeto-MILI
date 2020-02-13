package br.com.ifba.mili.cliente.service;

import br.com.ifba.mili.cliente.model.Cliente;
import java.util.List;

/**
 *
 * @author ruan
 */

public interface IServiceCliente {
    
    /** Esse método é usado para procurar um cliente, no banco de dados, com base no parâmetro informado.
     * 
     * @param id ID do cliente que será usado na busca.
     * @return Se encontrado, retorna um objeto Cliente e seus dados.
     */
    public abstract Cliente findById (long id);
    
    /** Esse método é usado para procurar um cliente, no banco de dados, com base no parâmetro informado.
     * 
     * @param cpf CPF do cliente utilizado durante a consulta no banco de dados.
     * @return Caso seja encontrado, retorno um objeto Cliente contendo todos os dados cadastrados.
     */
    public abstract Cliente findByCPF (String cpf);
    
    /** Esse método é usado para procurar todos os clientes savos no banco de dados.
     * 
     * @return Retorna uma lista contendo todos os dados dos clientes salvos.
     */
    public abstract List<Cliente> findAll ();
    
    /** Esse método é usado para salvar um cliente no banco de dados.
     * 
     * @param cliente Objeto salvo no banco de dados.
     * @return Retorna o objeto que foi salvo no banco de dados.
     */
    public abstract Cliente save (Cliente cliente);
    
    /** Esse método atualiza os dados de um cliente, no banco de dados.
     * 
     * @param cliente Objeto com os dados atualizados do cliente.
     * @return Retorna o objeto atuaizado do banco de dados.
     */
    public abstract Cliente update (Cliente cliente);
    
    /** Esse método exclui um cliente do banco de dados.
     * 
     * @param cliente Objeto que terá seus serão excluídos.
     */
    public abstract void delete (Cliente cliente);
}