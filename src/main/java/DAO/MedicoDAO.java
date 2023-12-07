package DAO;

import Model.*;
import Conexao.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;

public class MedicoDAO {
    
    private Connection conn;
    
    public MedicoDAO() {
        this.conn = new Conexao().conectar();
    }
    
    public void inserir(Medico medico) throws SQLException {        
        String inserir = "INSERT INTO db_humancare.medico VALUES (?,?,?,?,?)"; 
        
        PreparedStatement pstm = conn.prepareStatement(inserir);
        
        pstm.setString(1, medico.getNome_medico());
        pstm.setString(2, medico.getCrm_medico());
        pstm.setString(3, medico.getEspecialidade_medico());
        pstm.setString(4, medico.getEmail_medico());
        pstm.setString(5, medico.getTel_medico());
        
        pstm.execute();  
        pstm.close();
    }
    
    public List<Medico> consultar() throws SQLException {
        List<Medico> listaMedicos = new ArrayList<>();
            
            String consulta_sql = "SELECT * FROM medico";
            
            PreparedStatement pstm = conn.prepareStatement(consulta_sql);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                Medico medico = new Medico();

                medico.setNome_medico(rs.getString("nome_medico"));
                medico.setCrm_medico(rs.getString("crm_medico"));
                medico.setEspecialidade_medico(rs.getString("esp_medico"));
                medico.setEmail_medico(rs.getString("email_medico"));
                medico.setTel_medico(rs.getString("tel_medico"));
                
                listaMedicos.add(medico);
            }
        return listaMedicos;
    }
    
    public List<Medico> consultarPorNome(String nomeMedico) throws SQLException {
        List<Medico> listaMedicos = new ArrayList<>();
            
            String consulta_sql = "SELECT * FROM medico WHERE nome_medico LIKE '%" + nomeMedico + "%';";
            
            PreparedStatement pstm = conn.prepareStatement(consulta_sql);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                Medico medico = new Medico();

                medico.setNome_medico(rs.getString("nome_medico"));
                medico.setCrm_medico(rs.getString("crm_medico"));
                medico.setEspecialidade_medico(rs.getString("esp_medico"));
                medico.setEmail_medico(rs.getString("email_medico"));
                medico.setTel_medico(rs.getString("tel_medico"));
                
                listaMedicos.add(medico);
            }
        return listaMedicos;
    }
    
    public void atualizar(Medico medico) throws SQLException {
        String update = "UPDATE medico SET nome_medico = ?, crm_medico = ?, esp_medico = ?, email_medico = ?, tel_medico = ? WHERE crm_medico = ?";
        
        try (PreparedStatement pstm = conn.prepareStatement(update)) {
            
            pstm.setString(1, medico.getNome_medico());
            pstm.setString(2, medico.getCrm_medico());
            pstm.setString(3, medico.getEspecialidade_medico());
            pstm.setString(4, medico.getEmail_medico());
            pstm.setString(5, medico.getTel_medico());
            pstm.setString(6, medico.getCrm_medico());
            
            pstm.execute();
        }
        
    }
    
    public void excluir(Medico medico) throws SQLException {
        String delete = "DELETE FROM medico WHERE crm_medico = ?";
        
        try (PreparedStatement pstm = conn.prepareStatement(delete)) {
            
            pstm.setString(1, medico.getCrm_medico());
            
            pstm.execute();
        }
    }
    
    public boolean verificarMedico(Medico medico) throws SQLException {
        
        String sql = "SELECT crm_medico, nome_medico, esp_medico FROM medico WHERE nome_medico = ?;";
        
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, medico.getNome_medico());
            ResultSet rs = pstm.executeQuery();
            
            if (rs.next()) {
                medico.setCrm_medico(rs.getString("crm_medico"));
                medico.setEspecialidade_medico(rs.getString("esp_medico"));
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Favor cadastrar médico.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a consulta.");
        }
        
        return false;
    }
}
