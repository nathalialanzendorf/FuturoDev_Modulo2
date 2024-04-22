CREATE DATABASE personagem;

DROP TABLE IF EXISTS personagem;

CREATE TABLE personagem (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255),
    data_cadastro Timestamp,
    referencia VARCHAR(255)
);