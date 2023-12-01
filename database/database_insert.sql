USE db_humancare;

INSERT INTO paciente (nome_paciente, cpf_paciente, endereco_paciente, convenio_paciente, tel_paciente, email_paciente) VALUES
	('Ana Silva Santos', '123.456.789-00', 'Rua Flores, 123', 'Unimed', '(11) 98765-4321', 'ana.silva@email.com'),
    ('Carlos Oliveira Lima', '987.654.321-00', 'Avenida Montanha, 456', 'Amil', '(22) 34567-8901', 'carlos.lima@email.com'),
    ('Lucia Pereira Costa', '111.222.333-44', 'Rua do Sol, 789', 'SulAmérica', '(33) 87654-3210', 'lucia.costa@email.com'),
    ('Rafael Oliveira Santos', '555.666.777-88', 'Avenida Primavera, 987', 'Unimed', '(44) 23456-7890', 'rafael.santos@email.com'),
    ('Mariana Almeida Lima', '999.888.777-66', 'Rua do Bosque, 543', 'Amil', '(55) 87654-3210', 'mariana.lima@email.com'),
    ('Pedro Silva Rocha', '444.333.222-11', 'Avenida das Árvores, 876', 'SulAmérica', '(66) 12345-6789', 'pedro.rocha@email.com'),
    ('Camila Oliveira Costa', '777.888.999-00', 'Rua da Lua, 234', 'Unimed', '(77) 54321-0987', 'camila.costa@email.com'),
    ('Fernando Pereira Lima', '222.111.444-55', 'Avenida do Mar, 765', 'Amil', '(88) 23456-7890', 'fernando.lima@email.com'),
    ('Juliana Santos Rocha', '666.555.444-33', 'Rua dos Ventos, 321', 'SulAmérica', '(99) 98765-4321', 'juliana.rocha@email.com'),
    ('Gabriel Oliveira Costa', '333.444.555-66', 'Avenida do Sol, 876', 'Unimed', '(00) 54321-0987', 'gabriel.costa@email.com');
    
INSERT INTO medico VALUES
	('Dr. Marcos Oliveira', '12345-BA', 'Cardiologia', 'marcos.oliveira@email.com', '(11) 98765-4321'),
    ('Dra. Juliana Santos', '54321-BA', 'Dermatologia', 'juliana.santos@email.com', '(22) 34567-8901'),
    ('Dr. Carlos Lima', '98765-PE', 'Ortopedia', 'carlos.lima@email.com', '(33) 87654-3210'),
    ('Dra. Fernanda Costa', '23456-RJ', 'Ginecologia', 'fernanda.costa@email.com', '(44) 23456-7890'),
    ('Dr. Gustavo Rocha', '87654-SP', 'Pediatria', 'gustavo.rocha@email.com', '(55) 87654-3210'),
    ('Dra. Camila Oliveira', '32109-RJ', 'Oftalmologia', 'camila.oliveira@email.com', '(66) 12345-6789'),
    ('Dr. Rodrigo Lima', '98765-SP', 'Urologia', 'rodrigo.lima@email.com', '(77) 54321-0987'),
    ('Dra. Vanessa Rocha', '54321-RJ', 'Neurologia', 'vanessa.rocha@email.com', '(88) 23456-7890'),
    ('Dr. Pedro Santos', '10987-SP', 'Endocrinologia', 'pedro.santos@email.com', '(99) 98765-4321'),
    ('Dra. Luana Oliveira', '76543-RJ', 'Psiquiatria', 'luana.oliveira@email.com', '(00) 54321-0987');
    
INSERT INTO consulta VALUES
	(1, '10987-SP', '2023-01-01', '09:30:00'),
    (2, '12345-BA', '2023-02-15', '14:45:00'),
    (3, '32109-RJ', '2023-03-20', '11:00:00'),
    (4, '10987-SP', '2023-04-10', '10:15:00'),
    (5, '12345-BA', '2023-05-05', '16:30:00');

SELECT * FROM paciente;
SELECT * FROM medico;
SELECT * FROM consulta;
	
    