package DAO;

import Model.*;
import Conexao.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PacienteDAO {
    
    private Connection conn;
    
    public PacienteDAO() {
        this.conn = new Conexao().conectar();
    }
    
    public void inserir(Paciente paciente) throws SQLException {   
        
        String inserir = "INSERT INTO paciente (nome_paciente, cpf_paciente, endereco_paciente, convenio_paciente, tel_paciente, email_paciente) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pstm = conn.prepareStatement(inserir, Statement.RETURN_GENERATED_KEYS);
        
        pstm.setString(1, paciente.getNome_paciente());
        pstm.setString(2, paciente.getCpf_paciente());
        pstm.setString(3, paciente.getEndereco_paciente());
        pstm.setString(4, paciente.getConvenio_paciente());
        pstm.setString(5, paciente.getTel_paciente());
        pstm.setString(6, paciente.getEmail_paciente());
        
        pstm.execute();
        
        ResultSet tableKeys = pstm.getGeneratedKeys();
        tableKeys.next();
        int autoIncrement = tableKeys.getInt(1);
        
        pstm.close();
    }
    
    public List<Paciente> consultar() throws SQLException {
        List<Paciente> listaPacientes = new ArrayList<>();
            
            String consulta_sql = "SELECT * FROM paciente";
            
            PreparedStatement pstm = conn.prepareStatement(consulta_sql);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                Paciente paciente = new Paciente(0, null, null, null, null, null, null);
                
                paciente.setId_paciente(rs.getInt("id_paciente"));
                paciente.setNome_paciente(rs.getString("nome_paciente"));
                paciente.setCpf_paciente(rs.getString("cpf_paciente"));
                paciente.setEndereco_paciente(rs.getString("endereco_paciente"));
                paciente.setConvenio_paciente(rs.getString("convenio_paciente"));
                paciente.setTel_paciente(rs.getString("tel_paciente"));
                paciente.setEmail_paciente(rs.getString("email_paciente"));
                
                listaPacientes.add(paciente);
            }
        return listaPacientes;
    }
    
    public List<Paciente> consultarPorNome(String nomePaciente) throws SQLException {
        List<Paciente> listaPacientes = new ArrayList<>();
            
            String consulta_sql = "SELECT * FROM paciente WHERE nome_paciente LIKE '%" + nomePaciente + "%';";
            
            PreparedStatement pstm = conn.prepareStatement(consulta_sql);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                Paciente paciente = new Paciente(0, null, null, null, null, null, null);
                
                paciente.setId_paciente(rs.getInt("id_paciente"));
                paciente.setNome_paciente(rs.getString("nome_paciente"));
                paciente.setCpf_paciente(rs.getString("cpf_paciente"));
                paciente.setEndereco_paciente(rs.getString("endereco_paciente"));
                paciente.setConvenio_paciente(rs.getString("convenio_paciente"));
                paciente.setTel_paciente(rs.getString("tel_paciente"));
                paciente.setEmail_paciente(rs.getString("email_paciente"));
                
                listaPacientes.add(paciente);
            }
        return listaPacientes;
    }

    
    public void atualizar(Paciente paciente) throws SQLException {
        String update = "UPDATE paciente SET nome_paciente = ?, cpf_paciente = ?, endereco_paciente = ?, convenio_paciente = ?, tel_paciente = ?, email_paciente = ? WHERE id_paciente = ?;";

        try (PreparedStatement pstm = conn.prepareStatement(update)) {
            
            pstm.setString(1, paciente.getNome_paciente());
            pstm.setString(2, paciente.getCpf_paciente());
            pstm.setString(3, paciente.getEndereco_paciente());
            pstm.setString(4, paciente.getConvenio_paciente());
            pstm.setString(5, paciente.getTel_paciente());
            pstm.setString(6, paciente.getEmail_paciente());
            pstm.setInt(7, paciente.getId_paciente());
            
            pstm.execute();
        }
        
    }
    
    public void excluir(Paciente paciente) throws SQLException {
        String delete = "DELETE FROM paciente WHERE id_paciente = ?";
        
        try (PreparedStatement pstm = conn.prepareStatement(delete)) {
            
            pstm.setInt(1, paciente.getId_paciente());
            
            pstm.execute();
        }
    }
    
    public boolean verificarPaciente(Paciente paciente) throws SQLException {
        
        String sql = "SELECT id_paciente, nome_paciente FROM paciente WHERE nome_paciente = ?;";
        
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, paciente.getNome_paciente());
            ResultSet rs = pstm.executeQuery();
            
            if (rs.next()) {
                paciente.setId_paciente(rs.getInt("id_paciente"));
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Favor cadastrar paciente.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a consulta.");
        }
        
        return false;
    }
}
