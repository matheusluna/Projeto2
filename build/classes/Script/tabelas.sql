CREATE TABLE usuario
(
  nome varchar(100) NOT NULL,
  email varchar(100) NOT NULL primary key,
  dataDeNascimento Date NOT NULL,
  sexo varchar (100) NOT NULL,
  senha varchar (100) NOT NULL,
  telefone varchar (100) NOT NULL,
  foto text not null
);

