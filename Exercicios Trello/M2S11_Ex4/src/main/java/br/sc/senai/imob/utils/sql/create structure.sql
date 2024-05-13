DROP DATABASE imob;
CREATE DATABASE imob;

DROP TABLE IF EXISTS imovel;
DROP TABLE IF EXISTS users_roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;


CREATE TABLE imovel (
    id UUID PRIMARY KEY,
    descricao VARCHAR(255),
    tipo VARCHAR(255),
    endereco VARCHAR(255),
    bairro VARCHAR(255),
    cidade VARCHAR(255),
    valor DECIMAL(10,2),
    data_cadastro Timestamp
);

CREATE TABLE roles (
    id UUID PRIMARY KEY,
    name VARCHAR(20) NOT NULL
);

CREATE TABLE users (
    id UUID PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    enabled BOOLEAN DEFAULT TRUE,
    locked BOOLEAN DEFAULT FALSE,
    account_date_expire Timestamp,
    credential_date_expire Timestamp,
    FOREIGN KEY (id) REFERENCES roles(id)
);


CREATE TABLE users_roles (
    user_id UUID NOT NULL,
    role_id UUID NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (role_id) REFERENCES roles(id)
);

INSERT INTO roles (id, name) VALUES (
	'0b581629-3c80-4af9-9bcd-b6f79a095736',
	'ADMIN');
INSERT INTO users (id, username, password) 
VALUES (
		'0b581629-3c80-4af9-9bcd-b6f79a095736',
		'admin',
		'$2a$10$rJV1yLaC5lYEiZCMMfdCpOafv1apFJPAyJ.svpTJFMQdoabusQhDa');
INSERT INTO users_roles (user_id, role_id) VALUES (
	'0b581629-3c80-4af9-9bcd-b6f79a095736',
	'0b581629-3c80-4af9-9bcd-b6f79a095736');
	
INSERT INTO roles (id, name) VALUES (
	'bc655bd7-fb35-44aa-8787-6ab3edc01bd7',
	'READ');
INSERT INTO users (id, username, password) 
VALUES (
		'bc655bd7-fb35-44aa-8787-6ab3edc01bd7',
		'nathalia',
		'$2a$10$rJV1yLaC5lYEiZCMMfdCpOafv1apFJPAyJ.svpTJFMQdoabusQhDa');
INSERT INTO users_roles (user_id, role_id) VALUES (
	'bc655bd7-fb35-44aa-8787-6ab3edc01bd7',
	'bc655bd7-fb35-44aa-8787-6ab3edc01bd7');
	
	SELECT * FROM users;
	SELECT * FROM roles;
	SELECT * FROM users_roles;
