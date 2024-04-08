DROP TABLE IF EXISTS empregado;

CREATE TABLE empregado (
    id_empregado SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    salario NUMERIC(10,2),
    funcao VARCHAR(255),
    data_admissao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Dados de nome e salário dos empregados que ganham acima da média de salários?
SELECT AVG(salario) FROM empregado;

