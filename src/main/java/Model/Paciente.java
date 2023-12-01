package Model;

public class Paciente {
    
    private int id_paciente;
    private String nome_paciente;
    private String cpf_paciente;
    private String endereco_paciente;
    private String convenio_paciente;
    private String tel_paciente;
    private String email_paciente;

    public Paciente(int id_paciente, String nome_paciente, String cpf_paciente, String endereco_paciente, String convenio_paciente, String tel_paciente, String email_paciente) {
        this.id_paciente = id_paciente;
        this.nome_paciente = nome_paciente;
        this.cpf_paciente = cpf_paciente;
        this.endereco_paciente = endereco_paciente;
        this.convenio_paciente = convenio_paciente;
        this.tel_paciente = tel_paciente;
        this.email_paciente = email_paciente;
    }

    public Paciente() {
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getNome_paciente() {
        return nome_paciente;
    }

    public void setNome_paciente(String nome_paciente) {
        this.nome_paciente = nome_paciente;
    }

    public String getCpf_paciente() {
        return cpf_paciente;
    }

    public void setCpf_paciente(String cpf_paciente) {
        this.cpf_paciente = cpf_paciente;
    }

    public String getEndereco_paciente() {
        return endereco_paciente;
    }

    public void setEndereco_paciente(String endereco_paciente) {
        this.endereco_paciente = endereco_paciente;
    }

    public String getConvenio_paciente() {
        return convenio_paciente;
    }

    public void setConvenio_paciente(String convenio_paciente) {
        this.convenio_paciente = convenio_paciente;
    }

    public String getTel_paciente() {
        return tel_paciente;
    }

    public void setTel_paciente(String tel_paciente) {
        this.tel_paciente = tel_paciente;
    }

    public String getEmail_paciente() {
        return email_paciente;
    }

    public void setEmail_paciente(String email_paciente) {
        this.email_paciente = email_paciente;
    }
    
}
