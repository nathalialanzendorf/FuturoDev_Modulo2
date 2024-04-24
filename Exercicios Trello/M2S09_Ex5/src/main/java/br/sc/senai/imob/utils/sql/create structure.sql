CREATE DATABASE imob;

DROP TABLE IF EXISTS imovel;

CREATE TABLE imovel (
    codigo SERIAL PRIMARY KEY,
    descricao VARCHAR(255),
    tipo VARCHAR(255),
    endereco VARCHAR(255),
    bairro VARCHAR(255),
    cidade VARCHAR(255),
    valor DECIMAL(10,2),
    data_cadastro Timestamp
);