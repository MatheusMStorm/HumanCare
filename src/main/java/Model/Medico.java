package Model;

public class Medico {
    
    private String nome_medico;
    private String crm_medico;
    private String especialidade_medico;
    private String email_medico;
    private String tel_medico;

    public Medico(String nome_medico, String crm_medico, String especialidade_medico, String email_medico, String tel_medico) {
        this.nome_medico = nome_medico;
        this.crm_medico = crm_medico;
        this.especialidade_medico = especialidade_medico;
        this.email_medico = email_medico;
        this.tel_medico = tel_medico;
    }

    public Medico() {
    }

    public String getNome_medico() {
        return nome_medico;
    }

    public void setNome_medico(String nome_medico) {
        this.nome_medico = nome_medico;
    }

    public String getCrm_medico() {
        return crm_medico;
    }

    public void setCrm_medico(String crm_medico) {
        this.crm_medico = crm_medico;
    }

    public String getEspecialidade_medico() {
        return especialidade_medico;
    }

    public void setEspecialidade_medico(String especialidade_medico) {
        this.especialidade_medico = especialidade_medico;
    }

    public String getEmail_medico() {
        return email_medico;
    }

    public void setEmail_medico(String email_medico) {
        this.email_medico = email_medico;
    }

    public String getTel_medico() {
        return tel_medico;
    }

    public void setTel_medico(String tel_medico) {
        this.tel_medico = tel_medico;
    }
    
}
