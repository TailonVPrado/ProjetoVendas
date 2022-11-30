package service;

import Exception.DescricaoInvalidaException;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Venda;
import repository.VendaRepository;

public class VendaService {
    
    private void valida(Venda venda) throws Exception{
        if (venda.getVlTotal()<= 0)
            throw new Exception("Valor da venda inválida!");
        if (venda.getCliente() == null)
            throw new Exception("É necessario que seja informado um cliente para a venda.");
    }
    
    
    public void insert(Venda venda) throws SQLException, Exception{
        valida(venda);
        VendaRepository vendaRepository = new VendaRepository();
        vendaRepository.insert(venda);
    }
    
    public ArrayList<Venda> findAll() throws SQLException{
        VendaRepository vendaRepository = new VendaRepository();
        return vendaRepository.findAll();
    }
    
    public void delete(Venda venda) throws DescricaoInvalidaException, SQLException{
        VendaRepository vendaRepository = new VendaRepository();
        vendaRepository.delete(venda);
    }
    
    public void update(Venda venda) throws SQLException, Exception {
        valida(venda);
        
        VendaRepository vendaRepository = new VendaRepository();
        vendaRepository.update(venda);
    }   
    
    public Venda findById(int id) throws SQLException {
        VendaRepository vendaRepository = new VendaRepository();
        return vendaRepository.findById(id);
    }
    
    public ArrayList<Venda> findRel(String where, String orderBy) throws SQLException {
        VendaRepository vendaRepository = new VendaRepository();
        return vendaRepository.findRel(where, orderBy);
    }
}
