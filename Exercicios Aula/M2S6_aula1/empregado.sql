CREATE TABLE empregado (
    id_empregado SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    salario NUMERIC(10,2) NOT NULL,
    funcao VARCHAR(255) NOT NULL,
    data_admissao TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

INSERT INTO empregado (nome, salario, funcao) VALUES ('João', 1000.00, 'Analista');
INSERT INTO empregado (nome, salario, funcao) VALUES ('Maria', 2000.00, 'Gerente');
INSERT INTO empregado (nome, salario, funcao) VALUES ('José', 1500.00, 'Analista');