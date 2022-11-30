package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Item;
import models.ItemVenda;
import models.Venda;
import service.ItemService;
import service.VendaService;

public class ItemVendaRepository {
    private String INSERT = "INSERT INTO itemvenda (id_venda, id_item, qtde) VALUES(?, ?, ?);";
    private String UPDATE = "UPDATE itemvenda SET id_venda = ?, id_item = ?, qtde = ? WHERE id = ?;";
    private String DELETE = "DELETE from itemvenda WHERE id = ?;";
    private String DELETE_BY_VENDA = "DELETE from itemvenda WHERE id_venda = ?;";
    private String FIND_BY_ID = "SELECT id, id_venda, id_item, qtde FROM itemvenda WHERE id = ?;";
    private String FIND_ALL = "SELECT id, id_venda, id_item, qtde FROM itemvenda;";
    private String FIND_BY_VENDA = "select itemvenda.id, itemvenda.id_item, item.descricao, itemvenda.qtde from itemvenda, item  where itemvenda.id_item = item.id and itemvenda.id_venda = ? order by itemvenda.id;";
    
    public void insert(ItemVenda itemVenda) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //private String INSERT = "INSERT INTO itemvenda (id_venda, id_item, qtde) VALUES(?, ?, ?);";
            conn = new database.DatabaseConnection().getConnection();
            ps = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, itemVenda.getVenda().getId());
            ps.setInt(2, itemVenda.getItem().getId());
            ps.setDouble(3, itemVenda.getQtde());
            ps.execute();
            
            ResultSet rs = ps.getGeneratedKeys();
            while(rs.next()){
                itemVenda.setId(rs.getInt("id"));
            }
        }finally{
            if(ps != null)
                ps.close();
            if(conn != null)
                conn.close();
        }
    }
    
    public ArrayList<ItemVenda> findAll() throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null; 
        ResultSet rs = null;
        ArrayList<ItemVenda> listaResultado = new ArrayList<>();
        try {
            conn = new database.DatabaseConnection().getConnection();
            ps = conn.prepareStatement(FIND_ALL);
            rs = ps.executeQuery();
            
            while(rs.next()){
                //private String FIND_ALL = "SELECT id, id_venda, id_item, qtde FROM itemvenda;";
                ItemVenda itemVenda = new ItemVenda();
                itemVenda.setId(rs.getInt("id"));
                itemVenda.setQtde(rs.getDouble("qtde"));
                
                Venda venda = new Venda();
                VendaService vendaService = new VendaService();
                venda = vendaService.findById(rs.getInt("id_venda"));
                itemVenda.setVenda(venda);
                
                Item item = new Item();
                ItemService itemService = new ItemService();
                item = itemService.findById(rs.getInt("id_item"));
                itemVenda.setItem(item);
                
                listaResultado.add(itemVenda);
            }
        }finally{
            if(rs != null)
                rs.close();
            if(ps != null)
                ps.close();
            if(conn != null)
                conn.close();
        }
        return listaResultado;
    }
    
    public void delete(ItemVenda itemVenda) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = new database.DatabaseConnection().getConnection();
            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, itemVenda.getId());
            ps.execute();
        }finally{
            if(ps != null)
                ps.close();
            if(conn != null)
                conn.close();
        }
    }
    
    public void update(ItemVenda itemVenda) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
                
        try {

            conn = new database.DatabaseConnection().getConnection();
//private String UPDATE = "UPDATE itemvenda SET id_venda = ?, id_item = ?, qtde = ? WHERE id = ?;";
            ps = conn.prepareStatement(UPDATE);
            ps.setInt(1, itemVenda.getVenda().getId());
            ps.setInt(2, itemVenda.getItem().getId());
            ps.setDouble(3, itemVenda.getQtde());
            ps.setInt(4, itemVenda.getId());
            ps.execute();
            
        } finally {
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }
    } 
    
    public ItemVenda findById(int id) throws SQLException {   

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ItemVenda resultado = new ItemVenda();
                
        try {
        //private String FIND_BY_ID = "SELECT id, id_venda, id_item, qtde FROM itemvenda WHERE id = ?;";
            conn = new database.DatabaseConnection().getConnection();

            ps = conn.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                //private String FIND_ALL = "SELECT id, id_venda, id_item, qtde FROM itemvenda;";
                
                resultado.setId(rs.getInt("id"));
                resultado.setQtde(rs.getDouble("qtde"));
                
                Item item = new Item();
                ItemService itemService = new ItemService();
                item = itemService.findById(rs.getInt("id_item"));
                resultado.setItem(item);
                
                Venda venda = new Venda();
                VendaService vendaService = new VendaService();
                venda = vendaService.findById(rs.getInt("id_venda"));
                resultado.setVenda(venda);
                
            }

        } finally {
            if (rs != null)
                rs.close();
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }
        return resultado;
    }
    
    public ArrayList<ItemVenda> findByVenda(int idVenda) throws SQLException {   
    
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<ItemVenda> resultado = new ArrayList<>();
                
        try {
        
            conn = new database.DatabaseConnection().getConnection();

            ps = conn.prepareStatement(FIND_BY_VENDA);
            ps.setInt(1, idVenda);
            rs = ps.executeQuery();
            
            while(rs.next()){
                ItemService itemService = new  ItemService();
                Item item = new Item();
                item = itemService.findById(rs.getInt("id_item"));
                
                ItemVenda itemVenda =  new ItemVenda();
                
                itemVenda.setId(rs.getInt("id"));
                itemVenda.setItem(item);
                itemVenda.setQtde(rs.getDouble("qtde"));
                resultado.add(itemVenda);
            }

        } finally {
            if (rs != null)
                rs.close();
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }
        return resultado;
    }
    
    public void deleteByVenda(int idVenda) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = new database.DatabaseConnection().getConnection();
            ps = conn.prepareStatement(DELETE_BY_VENDA);
            ps.setInt(1, idVenda);
            ps.execute();
        }finally{
            if(ps != null)
                ps.close();
            if(conn != null)
                conn.close();
        }
    }    
}
