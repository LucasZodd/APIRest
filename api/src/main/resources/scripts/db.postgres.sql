CREATE DATABASE zoddVoltApi
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;

---------------------------------------------------------------------------------------------------------
CREATE SEQUENCE tab_medicos_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

CREATE TABLE TAB_MEDICOS (
    COD_ID integer DEFAULT nextval('tab_medicos_seq') NOT NULL,
    NOME varchar(100) NOT NULL,
    EMAIL varchar(100) NOT NULL unique,
    TELEFONE VARCHAR(20) NOT NULL;
    ATIVO BOOLEAN NOT NULL;
    CRM varchar(6) NOT NULL unique,
    especialidade varchar(100) NOT NULL,
    logradouro varchar(100) NOT NULL,
    bairro varchar(100) NOT NULL,
    cep varchar(9) NOT NULL,
    numero varchar(20),
    complemento varchar(100),
    cidade varchar(100) NOT NULL,
    uf char(2) NOT NULL,
    CONSTRAINT PK_COD_ID PRIMARY KEY (COD_ID)
);
