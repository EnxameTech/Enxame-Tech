create database EnxameTech;
use EnxameTech;

create table usuario(
	id int primary key auto_increment,
    nome varchar (30) not null,
    sobrenome varchar (50) not null,
    CPF varchar(11) not null,
    data_nascimento date not null,
    email varchar(40) not null,
    senha char(6) not null,
    genero ENUM('feminino', 'masculino', 'não binário', 'outro', 'prefiro não responder'),
    telefone varchar (11),
    rua varchar (50),
    numero varchar(6),
    bairro varchar(30),
    cidade varchar (50),
    UF char(2),
    CEP varchar(8)
    );
    
    create table administrador (
        id int,
		foreign key (id) references usuario(id) 
	);
    
    create table voluntario(
        id int,
        foreign key (id) references usuario(id),
        area_deAfinidade ENUM('front-end', 'back-end', 'lógica de programação', 'banco de dados')
    );
    
    create table aluno (
        id int,
        grupo_familiar int,
        renda_familiar decimal,
        foreign key (id) references usuario(id)
    );
    
    create table fale_conosco(
		id_contato int primary key auto_increment,
        nome varchar(30) not null,
        sobrenome varchar (50) not null,
        CPF varchar(11),
        email varchar(40) not null,
		telefone varchar (11),
        mensagem text(250)
    );
    
    create table curso(
		id_curso int primary key auto_increment,
        titulo varchar (50),
        nome_empresa varchar(30),
        descricao text(250),
        dataFinal_incricao date
    );
    
    create table curso_favorito(
		id_aluno int,
        id_curso int,
        foreign key (id_aluno) references aluno(id),
        foreign key (id_curso) references curso(id_curso)
    );
    
    create table monitoria (
		id_monitoria int primary key auto_increment,
        id_voluntario int,
        id_aluno int,
        data_monitoria date,
        horario time,
        descricao_duvida text(250),
        foreign key (id_aluno) references aluno(id),
        foreign key (id_voluntario) references voluntario(id)
    );