package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Item;

public class ItemRepository {
    private String INSERT = "INSERT INTO item (descricao, valor) VALUES(?, ?);";
    private String UPDATE = "UPDATE item SET descricao = ?, valor= ?  WHERE id = ?;";
    private String DELETE = "DELETE from item WHERE id = ?;";
    private String FIND_BY_ID = "SELECT id, descricao, valor FROM item WHERE id = ?;";
    private String FIND_ALL= "SELECT id, descricao, valor FROM item ";
    private String FIND_BY_VENDA = "select venda.id from venda, itemvenda where itemvenda.id_venda = venda.id and itemvenda.id_item = ?;";
    
    public void insert(Item item) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = new database.DatabaseConnection().getConnection();
            ps = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, item.getDescricao());
            ps.setDouble(2, item.getVlItem());
            ps.execute();
            
            ResultSet rs = ps.getGeneratedKeys();
            while(rs.next()){
                item.setId(rs.getInt("id"));
            }
        }finally{
            if(ps != null)
                ps.close();
            if(conn != null)
                conn.close();
        }
    }
    
    public ArrayList<Item> findAll() throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null; 
        ResultSet rs = null;
        ArrayList<Item> listaResultado = new ArrayList<>();
        try {
            conn = new database.DatabaseConnection().getConnection();
            ps = conn.prepareStatement(FIND_ALL);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Item item = new Item();
                item.setId(rs.getInt("id"));
                item.setDescricao(rs.getString("descricao"));
                item.setVlItem(rs.getDouble("valor"));
                
                listaResultado.add(item);
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
    
    public void delete(Item item) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = new database.DatabaseConnection().getConnection();
            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, item.getId());
            ps.execute();
        }finally{
            if(ps != null)
                ps.close();
            if(conn != null)
                conn.close();
        }
    }
    
    public void update(Item item) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
                
        try {

            conn = new database.DatabaseConnection().getConnection();
            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, item.getDescricao());
            ps.setDouble(2, item.getVlItem());
            ps.setInt(3, item.getId());
            ps.execute();
            
        } finally {
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }
    } 
    
    public Item findById(int id) throws SQLException {   

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Item resultado = new Item();
                
        try {
            conn = new database.DatabaseConnection().getConnection();

            ps = conn.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                resultado.setDescricao(rs.getString("descricao"));
                resultado.setId(rs.getInt("id"));
                resultado.setVlItem(rs.getDouble("valor"));
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
    
    public ArrayList<Integer> findByVenda(int idCliente) throws SQLException {   

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Integer> idVendasItem = new ArrayList<>();
                
        try {
//private String FIND_BY_VENDA = "select venda.id from venda, itemvenda where itemvenda.id_venda = venda.id and itemvenda.id_item = ?;";
            conn = new database.DatabaseConnection().getConnection();

            ps = conn.prepareStatement(FIND_BY_VENDA);
            ps.setInt(1, idCliente);
            rs = ps.executeQuery();
            
            while(rs.next()){
                idVendasItem.add(rs.getInt("id"));
            }

        } finally {
            if (rs != null)
                rs.close();
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }
        return idVendasItem;
    }
    
    public ArrayList<Item> findByRel(String where) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null; 
        ResultSet rs = null;
        ArrayList<Item> listaResultado = new ArrayList<>();
        try {
            conn = new database.DatabaseConnection().getConnection();
            ps = conn.prepareStatement(FIND_ALL + where);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Item item = new Item();
                item.setId(rs.getInt("id"));
                item.setDescricao(rs.getString("descricao"));
                item.setVlItem(rs.getDouble("valor"));
                
                listaResultado.add(item);
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
}
