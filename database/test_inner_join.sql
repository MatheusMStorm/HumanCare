USE db_humancare;

SELECT id_consulta, nome_paciente, nome_medico, m.crm_medico, esp_medico, DATE_FORMAT(data_consulta, '%d/%m/%Y') AS data_consulta, hora_consulta FROM consulta c
	INNER JOIN paciente p ON c.id_paciente = p.id_paciente
    INNER JOIN medico m ON c.crm_medico = m.crm_medico;