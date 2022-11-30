package service;

import Exception.DescricaoInvalidaException;
import java.sql.SQLException;
import java.util.ArrayList;
import models.ItemVenda;
import repository.ItemVendaRepository;

public class ItemVendaService {

    
    private void valida(ItemVenda itemVenda) throws Exception{
        if (itemVenda.getQtde()<= 0)
            throw new Exception("Valor qunatidade do item da venda inválido!");
        if (itemVenda.getItem()== null)
            throw new Exception("É necessario que seja informado um item para a venda.");
    }
    
    
    public void insert(ItemVenda itemVenda) throws SQLException, Exception{
        valida(itemVenda);
        ItemVendaRepository itemVendaRepository = new ItemVendaRepository();
        itemVendaRepository.insert(itemVenda);
    }
    
    public ArrayList<ItemVenda> findAll() throws SQLException{
        ItemVendaRepository itemVendaRepository = new ItemVendaRepository();
        return itemVendaRepository.findAll();
    }
    
    public void delete(ItemVenda itemVenda) throws DescricaoInvalidaException, SQLException{
        ItemVendaRepository itemVendaRepository = new ItemVendaRepository();
        itemVendaRepository.delete(itemVenda);
    }
    
    public void update(ItemVenda itemVenda) throws SQLException, Exception {
        valida(itemVenda);
        
        ItemVendaRepository itemVendaRepository = new ItemVendaRepository();
        itemVendaRepository.update(itemVenda);
    }   
    
    public ItemVenda findById(int id) throws SQLException {
        ItemVendaRepository itemVendaRepository = new ItemVendaRepository();
        return itemVendaRepository.findById(id);
    }
    
    public ArrayList<ItemVenda> findByVenda(int idVenda) throws SQLException {
        ItemVendaRepository itemVendaRepository = new ItemVendaRepository();
        return itemVendaRepository.findByVenda(idVenda);
    }  
    
    public void deleteByVenda(int idVenda) throws DescricaoInvalidaException, SQLException{
        ItemVendaRepository itemVendaRepository = new ItemVendaRepository();
        itemVendaRepository.deleteByVenda(idVenda);
    }
}
