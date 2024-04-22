CREATE DATABASE imob;

DROP TABLE IF EXISTS imovel;

CREATE TABLE personagem (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255),
    data_cadastro Timestamp,
    referencia VARCHAR(255)
);