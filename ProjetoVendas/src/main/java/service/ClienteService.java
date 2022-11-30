package service;

import Exception.DescricaoInvalidaException;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Cliente;
import repository.ClienteRepository;

public class ClienteService {
    private void valida(Cliente cliente) throws DescricaoInvalidaException, Exception{
        if (cliente.getNome()== null)
            throw new DescricaoInvalidaException();
        if (cliente.getNome().trim().length() == 0)
            throw new DescricaoInvalidaException();
        if (cliente.getNome().trim().length() >= 60)
            throw new DescricaoInvalidaException();
        if (cliente.getCpf().length() != 11)
            throw new Exception("CPF inválido");
    }
    
    public void insert(Cliente cliente) throws Exception, SQLException{
        valida(cliente);
        ClienteRepository clienteRepository = new ClienteRepository();
        clienteRepository.insert(cliente);
    }
    
    public ArrayList<Cliente> findAll() throws SQLException{
        ClienteRepository clienteRepository = new ClienteRepository();
        return clienteRepository.findAll();
    }
   
    public void delete(Cliente cliente) throws DescricaoInvalidaException, SQLException, Exception{
        ClienteRepository clienteRepository = new ClienteRepository();
        
        ArrayList<Integer> IdVendas = new ArrayList<>();
        IdVendas = clienteRepository.findByVenda(cliente.getId());
        if(IdVendas.size() > 0){
            String listaIdVenda = "";
            for (Integer IdVenda : IdVendas) {
                listaIdVenda += ", " + IdVenda;
            }
            listaIdVenda = listaIdVenda.substring(2, listaIdVenda.length());
            throw new Exception("Não é posivel excluir o cliente porque ele possui vendas associadas. Id vendas: " + listaIdVenda);
        }
        
        clienteRepository.delete(cliente);
    }
    
    public void update(Cliente cliente) throws SQLException, DescricaoInvalidaException, Exception {
        valida(cliente);
        ClienteRepository clienteRepository = new ClienteRepository();
        clienteRepository.update(cliente);
    }
    
    public Cliente findById(int id) throws SQLException {
        ClienteRepository clienteRepository = new ClienteRepository();
        return clienteRepository.findById(id);
    }
    
    public ArrayList<Cliente> findByRel(String where) throws SQLException{
        ClienteRepository clienteRepository = new ClienteRepository();
        return clienteRepository.findByRel(where);
    }
    
}