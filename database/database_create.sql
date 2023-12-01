CREATE DATABASE db_humancare;
USE db_humancare;

CREATE TABLE paciente (
	id_paciente INT NOT NULL AUTO_INCREMENT,
    nome_paciente VARCHAR(50) NOT NULL,
    cpf_paciente VARCHAR(15) NOT NULL,
    endereco_paciente VARCHAR(120) NOT NULL,
    convenio_paciente VARCHAR(20) NOT NULL,
    tel_paciente VARCHAR(20) NOT NULL,
    PRIMARY KEY (id_paciente)
);

CREATE TABLE medico (
	nome_medico VARCHAR(50) NOT NULL,
    crm_medico VARCHAR(10) NOT NULL,
    esp_medico VARCHAR(30) NOT NULL,
    email_medico VARCHAR(45) NOT NULL,
    tel_medico VARCHAR(20) NOT NULL,
    PRIMARY KEY(crm_medico)
);

CREATE TABLE consulta (
	id_paciente VARCHAR(15) NOT NULL,
    crm_medico VARCHAR(10) NOT NULL,
    data_consulta DATE NOT NULL,
    hora_consulta TIME NOT NULL
);
    
ALTER TABLE consulta
	ADD INDEX fk_id_paciente_idx (id_paciente ASC);

ALTER TABLE consulta
	MODIFY COLUMN id_paciente INT NOT NULL;
    
ALTER TABLE consulta
	ADD CONSTRAINT fk_id_paciente
    FOREIGN KEY (id_paciente)
    REFERENCES paciente (id_paciente)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;
    
ALTER TABLE consulta
	ADD INDEX fk_crm_medico_idx (crm_medico ASC);
    
ALTER TABLE consulta
	ADD CONSTRAINT fk_crm_medico
    FOREIGN KEY (crm_medico)
    REFERENCES medico (crm_medico)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;
    
ALTER TABLE paciente
	ADD email_paciente VARCHAR(45) NOT NULL;
    
ALTER TABLE db_humancare.paciente
	MODIFY COLUMN cpf_paciente VARCHAR(15);
    
ALTER TABLE consulta
	ADD id_consulta INT NOT NULL PRIMARY KEY AUTO_INCREMENT;
    
ALTER TABLE consulta
	CHANGE crm_medico fk_crm_medico VARCHAR(10) NOT NULL;
    
ALTER TABLE consulta
	MODIFY COLUMN data_consulta VARCHAR(10) NOT NULL;
    
ALTER TABLE consulta
	MODIFY COLUMN hora_consulta VARCHAR(8) NOT NULL;

ALTER TABLE consulta
	ADD CONSTRAINT fk_crm_medico
    FOREIGN KEY (fk_crm_medico)
    REFERENCES medico (crm_medico)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;
    
ALTER TABLE consulta
	CHANGE fk_crm_medico crm_medico VARCHAR(10) NOT NULL;