package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import models.Cliente;

public class ClienteRepository {
    private String INSERT = "INSERT INTO cliente (nome, cpf) VALUES(?, ?);";
    private String UPDATE = "UPDATE cliente SET nome = ?, cpf = ?  WHERE id = ?;";
    private String DELETE = "DELETE from cliente WHERE id = ?;";
    private String FIND_BY_ID = "SELECT id, nome, cpf FROM cliente WHERE id = ?;";
    private String FIND_ALL= "SELECT id, nome, cpf FROM cliente ";
    private String FIND_BY_VENDA = "SELECT id from venda where venda.id_cliente = ?;";
    
            
    public void insert(Cliente cliente) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = new database.DatabaseConnection().getConnection();
            ps = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.execute();
            
            ResultSet rs = ps.getGeneratedKeys();
            while(rs.next()){
                cliente.setId(rs.getInt("id"));
            }
        }finally{
            if(ps != null)
                ps.close();
            if(conn != null)
                conn.close();
        }
    }
    
    public ArrayList<Cliente> findAll() throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null; 
        ResultSet rs = null;
        ArrayList<Cliente> listaResultado = new ArrayList<>();
        try {
            conn = new database.DatabaseConnection().getConnection();
            ps = conn.prepareStatement(FIND_ALL);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf")); 
                
                listaResultado.add(cliente);
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
    
    public void delete(Cliente cliente) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = new database.DatabaseConnection().getConnection();
            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, cliente.getId());
            ps.execute();
        }finally{
            if(ps != null)
                ps.close();
            if(conn != null)
                conn.close();
        }
    }
    
    public void update(Cliente cliente) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null;
                
        try {

            conn = new database.DatabaseConnection().getConnection();
            ps = conn.prepareStatement(UPDATE, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setInt(3, cliente.getId());
            ps.execute();
            
            ResultSet rs = ps.getGeneratedKeys();
            while(rs.next()){
                cliente.setId(rs.getInt("id"));
            }
        } finally {
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }
    } 
    
    public Cliente findById(int id) throws SQLException {   

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Cliente resultado = new Cliente();
                
        try {
            conn = new database.DatabaseConnection().getConnection();

            ps = conn.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                resultado.setNome(rs.getString("nome"));
                resultado.setId(rs.getInt("id"));
                resultado.setCpf(rs.getString("cpf"));
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
        ArrayList<Integer> idVendasCliente = new ArrayList<>();
                
        try {

            conn = new database.DatabaseConnection().getConnection();

            ps = conn.prepareStatement(FIND_BY_VENDA);
            ps.setInt(1, idCliente);
            rs = ps.executeQuery();
            
            while(rs.next()){
                idVendasCliente.add(rs.getInt("id"));
            }

        } finally {
            if (rs != null)
                rs.close();
            if (ps != null)
                ps.close();
            if (conn != null)
                conn.close();
        }
        return idVendasCliente;
    }
    
    public ArrayList<Cliente> findByRel(String where) throws SQLException{
        Connection conn = null;
        PreparedStatement ps = null; 
        ResultSet rs = null;
        ArrayList<Cliente> listaResultado = new ArrayList<>();
        try {
            conn = new database.DatabaseConnection().getConnection();
            ps = conn.prepareStatement(FIND_ALL + where);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf")); 
                
                listaResultado.add(cliente);
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
