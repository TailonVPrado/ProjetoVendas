package service;

import Exception.DescricaoInvalidaException;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Item;
import repository.ItemRepository;

public class ItemService {
        private void valida(Item item) throws DescricaoInvalidaException, Exception{
        if (item.getDescricao()== null)
            throw new DescricaoInvalidaException();
        if (item.getDescricao().trim().length() == 0)
            throw new DescricaoInvalidaException();
        if (item.getDescricao().trim().length() >= 60)
            throw new DescricaoInvalidaException();
        if (item.getVlItem() <= 0)
            throw new Exception("Valor do item inválido!");
    }
    
    public void insert(Item item) throws Exception, SQLException{
        valida(item);
        ItemRepository itemRepository = new ItemRepository();
        itemRepository.insert(item);
    }
    
    public ArrayList<Item> findAll() throws SQLException{
        ItemRepository itemRepository = new ItemRepository();
        return itemRepository.findAll();
    }
   
    public void delete(Item item) throws DescricaoInvalidaException, SQLException, Exception{
        ItemRepository itemRepository = new ItemRepository();
        
        ArrayList<Integer> IdVendas = new ArrayList<>();
        IdVendas = itemRepository.findByVenda(item.getId());
        if(IdVendas.size() > 0){
            String listaIdVenda = "";
            for (Integer IdVenda : IdVendas) {
                listaIdVenda += ", " + IdVenda;
            }
            listaIdVenda = listaIdVenda.substring(2, listaIdVenda.length());
            throw new Exception("Não é posivel excluir o item porque ele possui vendas associadas. Id vendas: " + listaIdVenda);
        }
        
        itemRepository.delete(item);
    }
    
    public void update(Item item) throws SQLException, DescricaoInvalidaException, Exception {
        valida(item);
        ItemRepository itemRepository = new ItemRepository();
        itemRepository.update(item);
    }
    
    public Item findById(int id) throws SQLException {
        ItemRepository itemRepository = new ItemRepository();
        return itemRepository.findById(id);
    }
    
    public ArrayList<Item> findByRel(String where) throws SQLException {
        ItemRepository itemRepository = new ItemRepository();
        return itemRepository.findByRel(where);
    }
}
