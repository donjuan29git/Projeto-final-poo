CREATE TABLE tbprodutos
(
	id SERIAL NOT NULL,
	name VARCHAR(30) NOT NULL,
	price NUMERIC(10,2) NOT NULL,
	quantity INT NOT NULL DEFAULT 0,
	CONSTRAINT pk_tbprodutos PRIMARY KEY (id)
);
SELECT * FROM tbproducts;

CREATE TABLE tbvendas
(
	id SERIAL NOT NULL,
	name VARCHAR(30) NOT NULL,
	price NUMERIC(10,2) NOT NULL,
	quantity INT NOT NULL DEFAULT 0,
	CONSTRAINT pk_tbprodutos PRIMARY KEY (id)
);
SELECT * FROM tbvendas;

CREATE TABLE tbusers (
  id SERIAL PRIMARY KEY,
  username VARCHAR(100) UNIQUE NOT NULL,
  password VARCHAR(100) NOT NULL
);
SELECT * FROM tbusers;