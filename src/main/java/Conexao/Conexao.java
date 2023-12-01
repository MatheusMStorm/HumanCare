package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
    
    private Connection conn = null; // conexão no banco de dados
    private ResultSet rs = null; // percorre o banco de dados
    private Statement stm = null; // adiciona ou atualiza valores
    
    public Connection conectar() {
        try {
            String user = "admin";
            String password = "admin";
            String ipBanco = "localhost";
            String nomedoBanco = "db_humancare";
            String connectionStr = "jdbc:mysql://" + ipBanco + ":3306/" + nomedoBanco;
            
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = DriverManager.getConnection(connectionStr, user, password);
            System.out.println("Conectou-se no banco de dados.");
        }
        catch (SQLException ex){
            System.out.println("Não conseguiu conectar ao banco de dados.");
        }
        catch (ClassNotFoundException ex) {
            System.out.println("Erro: driver não encontrado.");
        }
        
        return conn;
    }
    
    public ResultSet executarConsulta(String consulta) {
        conn = conectar();
        
        try {
            stm = conn.createStatement();
            rs = stm.executeQuery(consulta);
        }
        catch (SQLException ex) {
            System.out.println("Não foi possível realizar a consulta\n" + consulta);
            desconectar();
        }
        
        return rs;
    }
    
    public boolean executarDML(String dml) {
        boolean ok = false;
        
        conn = conectar();
        
        try {
            stm = conn.createStatement();
            stm.execute(dml);
            ok = true;
        }
        catch (SQLException ex) {
            System.out.println("Não conseguiu executar o DML\n" + dml);
        }
        finally {
            desconectar();
        }
        
        return ok;
    }
    
    public void desconectar() {
        fecharConnection(this.conn);
        fecharResultSet(this.rs);
        fecharStatement(this.stm);
    }
    
    public void fecharConnection(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Desconectou do banco de dados");
            }
        }
        catch (SQLException ex) {
            System.out.println("Não conseguiu se desconectar do banco de dados");
        }
    }
    
    public void fecharResultSet (ResultSet rs) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
        }
        catch (SQLException ex){
            System.out.println("Erro ao fechar o resultado da consulta");
        }
    }
    
    public void fecharStatement(Statement stm) {
        try {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
        }
        catch (SQLException ex) {
            System.out.println("Erro ao fechar procedimento de consulta.");
        }
    }
}