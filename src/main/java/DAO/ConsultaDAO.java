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


public class ConsultaDAO {
    
    private Connection conn;
    
    public ConsultaDAO() {
        this.conn = new Conexao().conectar();
    }
    
    public void inserir(Consulta consulta) throws SQLException {        
        String inserir = "INSERT INTO consulta (id_paciente, crm_medico, data_consulta, hora_consulta) VALUES (?,?,?,?)"; 
        
        PreparedStatement pstm = conn.prepareStatement(inserir, Statement.RETURN_GENERATED_KEYS);
        
        pstm.setInt(1, consulta.getPaciente().getId_paciente());
        pstm.setString(2, consulta.getMedico().getCrm_medico());
        pstm.setString(3, consulta.getData());
        pstm.setString(4, consulta.getHora());
        
        pstm.execute();
        
        ResultSet tableKeys = pstm.getGeneratedKeys();
        tableKeys.next();
        int autoIncrement = tableKeys.getInt(1);
        
        pstm.close();
    }
    
    public List<Consulta> consultar() throws SQLException {
        List<Consulta> listaConsultas = new ArrayList<>();
            
            String consulta_sql = "SELECT id_consulta, nome_paciente, nome_medico, m.crm_medico, esp_medico, DATE_FORMAT(data_consulta, '%d/%m/%Y') AS data_consulta, hora_consulta FROM consulta c"
                                  + " INNER JOIN paciente p ON c.id_paciente = p.id_paciente"
                                  + " INNER JOIN medico m ON c.crm_medico = m.crm_medico;";
            
            PreparedStatement pstm = conn.prepareStatement(consulta_sql);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                Consulta consulta = new Consulta();
                Paciente paciente = new Paciente();
                Medico medico = new Medico();
                
                paciente.setNome_paciente(rs.getString("nome_paciente"));
                medico.setNome_medico(rs.getString("nome_medico"));
                medico.setCrm_medico(rs.getString("m.crm_medico"));
                medico.setEspecialidade_medico(rs.getString("esp_medico"));
                
                consulta.setId_consulta(rs.getInt("id_consulta"));
                consulta.setPaciente(paciente);
                consulta.setMedico(medico);
                consulta.setData(rs.getString("data_consulta"));
                consulta.setHora(rs.getString("hora_consulta"));
                
                listaConsultas.add(consulta);
            }
        return listaConsultas;
    }
    
    public void atualizar(Consulta consulta) throws SQLException {
        String update = "UPDATE consulta SET id_paciente = ?, crm_medico = ?, data_consulta = ?, hora_consulta = ? WHERE id_consulta = ?'";
        
        try (PreparedStatement pstm = conn.prepareStatement(update)) {
            
            pstm.setInt(1, consulta.getPaciente().getId_paciente());
            pstm.setString(2, consulta.getMedico().getCrm_medico());
            pstm.setString(3, consulta.getData());
            pstm.setString(4, consulta.getHora());
            pstm.setInt(5, consulta.getId_consulta());
            
            pstm.execute();
        }
        
    }
    
    public void excluir(Consulta consulta) throws SQLException {
        String delete = "DELETE FROM consulta WHERE id_consulta = ?";
        
        try (PreparedStatement pstm = conn.prepareStatement(delete)) {
            
            pstm.setInt(1, consulta.getId_consulta());
            
            pstm.execute();
        }
    }
}
