DROP TABLE IF EXISTS empregado;

CREATE TABLE empregado (
    id_empregado SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    salario NUMERIC(10,2),
    funcao VARCHAR(255),
    data_admissao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

--Insira na tabela ‘empregados’ os dados da pessoa: Nome = Uhura, função = ‘Oficial de Comunicação’, salario = 9200.
INSERT INTO empregado (nome, funcao, salario) VALUES ('Nome 1','Função 1', 9000);
INSERT INTO empregado (nome, funcao, salario) VALUES ('Spy Pike','Função Pike', 9000);
INSERT INTO empregado (nome, funcao, salario) VALUES ('Spy 2 Pike','Função Pike', 9900);
INSERT INTO empregado (nome, funcao, salario) VALUES ('Uhura','Oficial de Comunicação', 9200);

--Insira na tabela ‘empregados’ os dados da pessoa: Nome = Pavel Checkov, função = ‘Navegador’.
INSERT INTO empregado (nome, funcao) VALUES ('Pavel Checkov','Navegador');

--Insira na tabela ‘empregados’ os dados da pessoa: Nome = Christopher Pike.
INSERT INTO empregado (nome) VALUES ('Christopher Pike');

--Insira na tabela ‘empregados’ os dados da pessoa: Nome = Sulu.
INSERT INTO empregado (nome) VALUES ('Sulu');

--Selecione/liste os dados de nome e função (somente estes dados) da empregada de nome Uhura.
SELECT nome, funcao FROM empregado WHERE nome = 'Uhura';

--Selecione/liste os dados de nome e salário (somente estes dados) de todos os empregados cujo salário está entre 9000 (inclusive) e 9500 (inclusive).
SELECT nome, salario FROM empregado WHERE salario BETWEEN 9000 AND 9500;
SELECT nome, salario FROM empregado WHERE salario >= 9000 AND salario <=  9500;

--Atualize o salário da emprega de nome Uhura para 9300.
UPDATE empregado SET salario = 9300 WHERE nome = 'Uhura';

--Atualize na tabela o nome do empregado de nome Sulu para ‘Hikary Sulu’.
UPDATE empregado SET nome = 'Hikary Sulu' WHERE nome = 'Sulu';

--Apague/remova o registro da tabela do funcionário cujo nome termine com ‘Pike’.
DELETE FROM empregado WHERE nome LIKE '%Pike';

--SUPER-DESAFIO: Atualize para maiúsculo o nome dos empregados que ganham exatamente 9000.  Vale usar o Google! :-)
UPDATE empregado SET nome = UPPER(nome) WHERE salario = 9000;
