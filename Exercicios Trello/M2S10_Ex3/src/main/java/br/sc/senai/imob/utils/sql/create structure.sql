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

CREATE TABLE role (
    id UUID PRIMARY KEY,
    name VARCHAR(20) NOT NULL
);

CREATE TABLE user (
    id UUID PRIMARY KEY,
    role_id INT NOT NULL,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    FOREIGN KEY (id) REFERENCES role(id)
);


CREATE TABLE user_role (
    user_id UUID NOT NULL,
    role_id UUID NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user(id),
    FOREIGN KEY (role_id) REFERENCES role(id)
);