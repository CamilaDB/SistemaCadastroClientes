create database sistemaCadastro;
use sistemaCadastro;
create user camilaB identified by 'trabalho';
grant all privileges on sistemaCadastro.* to 'camilaB';
flush privileges;

create table login(
usuario varchar(12) not null primary key,
senha varchar(100) not null
);

create table cliente(
cpf varchar(14) not null primary key,
nome varchar(100) not null,
genero char(1),
dataNascimento varchar(10) not null,
profissao varchar(60),
endereco varchar(100) not null,
email varchar(30),
telefone varchar(15) not null
);

insert into login values("teste", "1234");

select * from cliente; 

