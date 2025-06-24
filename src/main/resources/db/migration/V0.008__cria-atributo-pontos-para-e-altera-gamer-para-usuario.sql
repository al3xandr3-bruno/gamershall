drop table gamer;

create table usuario(
	id bigint primary key auto_increment,
    nome varchar(100) not null,
    nome_usuario varchar(20) not null unique,
    email varchar(100)not null unique,
    pontos bigint not null default 0
)engine=InnoDB;