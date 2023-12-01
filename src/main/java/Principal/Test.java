package Principal;

import Model.*;
import DAO.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Test {
    
    public static void main(String[] args) throws SQLException {
        // Inserir
        
//        Paciente paciente = new Paciente(0, null, null, null, null, null, null);
//        PacienteDAO pacienteDAO = new PacienteDAO();
//        
//        paciente.setNome_paciente(JOptionPane.showInputDialog("Nome do paciente: "));
//        paciente.setCpf_paciente(JOptionPane.showInputDialog("CPF: "));
//        paciente.setEndereco_paciente(JOptionPane.showInputDialog("Endereço: "));
//        paciente.setConvenio_paciente(JOptionPane.showInputDialog("Convênio médico: "));
//        paciente.setTel_paciente(JOptionPane.showInputDialog("Telefone: "));
//        paciente.setEmail_paciente(JOptionPane.showInputDialog("E-mail: "));
//        
//        pacienteDAO.inserir(paciente);
//        JOptionPane.showMessageDialog(null, "Cadastrado.");

        String diaStr, mesStr, anoStr;
        String horaStr, minutoStr, segundoStr;
        String data_str, hora_str; 
        
        Consulta consulta = new Consulta(0, null, null, null, null);
        Medico medico = new Medico();
        Paciente paciente = new Paciente();
        
        ConsultaDAO consultaDAO = new ConsultaDAO();
        
        // Pegando os dados do paciente e do médico
        paciente.setId_paciente(Integer.parseInt(JOptionPane.showInputDialog("ID do paciente: ")));
        medico.setCrm_medico(JOptionPane.showInputDialog("CRM do médico: "));
        
        consulta.setPaciente(paciente);
        consulta.setMedico(medico);
        // Inserir a data
        diaStr = JOptionPane.showInputDialog("Dia (dd): ");
        mesStr = JOptionPane.showInputDialog("Mês (mm): ");
        anoStr = JOptionPane.showInputDialog("Ano (aaaa): ");
        data_str = anoStr + "-" + mesStr + "-" + diaStr; 
        consulta.setData(data_str);
        // Inserir a hora
        horaStr = JOptionPane.showInputDialog("Hora (hh): ");
        minutoStr = JOptionPane.showInputDialog("Minuto (mm): ");
        segundoStr = JOptionPane.showInputDialog("Segundo (ss): ");
        hora_str = horaStr + ":" + minutoStr + ":" + segundoStr;
        consulta.setHora(hora_str);
        
        consultaDAO.inserir(consulta);
        JOptionPane.showMessageDialog(null, "Data: " + consulta.getData() + "\n" + "Hora: " + consulta.getHora() + "\n" + "ID gerado: " + consulta.getId_consulta());
          
    } 
}
