package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Cliente;
import models.Venda;
import service.ClienteService;

public class VendaRepository {
    
    private String INSERT = "INSERT INTO venda (id_cliente, vl_total) VALUES(?, ?);";
    private String UPDATE = "UPDATE venda SET id_cliente = ?, vl_venda = ? WHERE id = ?;";
    private String DELETE = "DELETE from venda WHERE id = ?;";
    private String FIND_BY_ID = "SELECT id, id_cliente, vl_total FROM venda WHERE id = ?;";
    private String FIND_ALL = "SELECT id, id_cliente, vl_venda FROM venda;";
    
    private String FIND_REL = "select cliente.id id_cliente, cliente.cpf cpf_cliente, cliente.nome nome_cliente, venda.id id_venda, venda.vl_total valor_venda from cliente,  venda where venda.id_cliente = cliente.id ";
    
    public void insert(Venda venda) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //private String INSERT = "INSERT INTO venda (id_cliente, vl_total) VALUES(?, ?);";
            conn = new database.DatabaseConnection().getConnection();
            ps = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, venda.getCliente().getId());
            ps.setDouble(2, venda.getVlTotal());
            ps.execute();
            
            ResultSet rs = ps.getGeneratedKeys();
            while(rs.next()){
                venda.setId(rs.getInt("id"));
            }
        }finally{
            if(ps != null)
                ps.close();
            if(conn != null)
                conn.close();
        }
    }
    
    public ArrayList<Venda> findAll() throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null; 
        ResultSet rs = null;
        ArrayList<Venda> listaResultado = new ArrayList<>();
        try {
            conn = new database.DatabaseConnection().getConnection();
            ps = conn.prepareStatement(FIND_ALL);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Venda venda = new Venda();
                venda.setId(rs.getInt("id"));
                venda.setVlTotal(rs.getDouble("vl_total"));
                
                Cliente cliente = new Cliente();
                ClienteService clienteService = new ClienteService();
                cliente = clienteService.findById(rs.getInt("id_cliente"));
                
                venda.setCliente(cliente);
                
                listaResultado.add(venda);
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
    
    public void delete(Venda venda) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = new database.DatabaseConnection().getConnection();
            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, venda.getId());
            ps.execute();
        }finally{
            if(ps != null)
                ps.close();
            if(conn != null)
                conn.close();
        }
    }
    
    public void update(Venda venda) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
                
        try {

            conn = new database.DatabaseConnection().getConnection();
//private String UPDATE = "UPDATE venda SET id_cliente = ?, vl_venda = ? WHERE id = ?;";
            ps = conn.prepareStatement(UPDATE);
            ps.setInt(1, venda.getCliente().getId());
            ps.setDouble(2, venda.getVlTotal());
            ps.setInt(3, venda.getId());
            ps.execute();
            
        } finally {
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }
    } 
    
    public Venda findById(int id) throws SQLException {   

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Venda resultado = new Venda();
                
        try {
        //private String FIND_BY_ID = "SELECT id, id_cliente, vl_total FROM venda WHERE id = ?;";
            conn = new database.DatabaseConnection().getConnection();

            ps = conn.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                resultado.setId(rs.getInt("id"));
                resultado.setVlTotal(rs.getDouble("vl_total"));
                
                Cliente cliente = new Cliente();
                ClienteService clienteService = new ClienteService();
                cliente = clienteService.findById(rs.getInt("id_cliente"));
                
                resultado.setCliente(cliente);
                
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
    
    
    
    
    
    
    
    
    
    
    
    public ArrayList<Venda> findRel(String where, String orderBy) throws SQLException {   

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Venda> vendas = new ArrayList<>();
                System.out.println(FIND_REL);
        try {
            conn = new database.DatabaseConnection().getConnection();

            ps = conn.prepareStatement(FIND_REL + where + orderBy);
            rs = ps.executeQuery();
            
            while(rs.next()){
                ClienteService clienteService = new ClienteService();
                Venda venda = new Venda();
                Cliente cliente = new Cliente();
                cliente = clienteService.findById(rs.getInt("id_cliente"));
                
                venda.setId(rs.getInt("id_venda"));
                venda.setVlTotal(rs.getDouble("valor_venda"));
                venda.setCliente(cliente);
                
                vendas.add(venda);
            } 

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            if (rs != null)
                rs.close();
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }
        return vendas;
    }
    
}
