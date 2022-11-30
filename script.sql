/*TABELA item*/
CREATE TABLE item (
id int NOT NULL,
descricao varchar(60) NOT NULL,
valor numeric(10,2) NOT NULL
);
alter table item
add constraint pk_item primary key (id);

/*TABELA cliente*/
CREATE TABLE cliente(
id int  NOT NULL,
nome varchar(60) NOT NULL,
cpf varchar(11) NOT NULL
);
alter table cliente
add constraint pk_cliente primary key (id);

/*TABELA venda*/
CREATE TABLE venda(
id int NOT NULL,
id_cliente int NOT NULL,
vl_total numeric(10,2) NOT NULL
);
alter table venda
add constraint pk_venda primary key (id);
alter table venda
add constraint fk_cliente_venda foreign key (id_cliente)
references cliente (id);

/*TABELA itemvenda*/
CREATE TABLE itemvenda(
id int NOT NULL,
id_venda int NOT NULL,
id_item int NOT NULL,
qtde int NOT NULL
);
alter table itemvenda
add constraint pk_itemvenda primary key (id);
alter table itemvenda
add constraint fk_venda_itemvenda foreign key (id_venda)
references venda (id);
alter table itemvenda
add constraint fk_item_itemvenda foreign key (id_item)
references item (id);

/*SEQUENCIAIS*/

CREATE SEQUENCE id_item_sequence
INCREMENT 1
MINVALUE 1
MAXVALUE 9999999999999
START 1
CACHE 1;

CREATE SEQUENCE id_cliente_sequence
INCREMENT 1
MINVALUE 1
MAXVALUE 9999999999999
START 1
CACHE 1;

CREATE SEQUENCE id_venda_sequence
INCREMENT 1
MINVALUE 1
MAXVALUE 9999999999999
START 1
CACHE 1;

CREATE SEQUENCE id_itemvenda_sequence
INCREMENT 1
MINVALUE 1
MAXVALUE 9999999999999
START 1
CACHE 1;

ALTER TABLE item ALTER COLUMN id SET DEFAULT NEXTVAL('id_item_sequence'::regclass);
ALTER TABLE cliente ALTER COLUMN id SET DEFAULT NEXTVAL('id_cliente_sequence'::regclass);
ALTER TABLE venda ALTER COLUMN id SET DEFAULT NEXTVAL('id_venda_sequence'::regclass);
ALTER TABLE itemvenda ALTER COLUMN id SET DEFAULT NEXTVAL('id_itemvenda_sequence'::regclass);