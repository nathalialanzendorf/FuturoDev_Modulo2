DROP TABLE IF EXISTS empregado;

CREATE TABLE empregado (
    id_empregado SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    salario NUMERIC(10,2),
    funcao VARCHAR(255),
    data_admissao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Quantidade total de registros da tabela de empregados (dica: count(*) ???)
SELECT COUNT(*) FROM empregado;

-- Quantidade de empregados que ganham mais de 9000 reais (dica: e se usar a cláusula where…)
SELECT COUNT(*) FROM empregado WHERE salario > 9000;

-- A média aritmética dos salários cadastrados na tabela.
SELECT AVG(salario) FROM empregado;

-- A média aritmética dos salários dos empregados que ganham mais de 9000 reais.
SELECT AVG(salario) FROM empregado WHERE salario > 9000;

-- O menor salário cadastrado na tabela.
SELECT MIN(salario) FROM empregado;

-- O maior salário cadastrado na tabela.
SELECT MAX(salario) FROM empregado;

-- A soma de todos os salários dos empregados.
SELECT SUM(salario) FROM empregado;
