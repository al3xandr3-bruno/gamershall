create table gamer(
	id bigint primary key auto_increment,
    nome varchar(100) not null,
    nomeUsuario varchar(20) not null unique,
    email varchar(100)not null unique
)engine=InnoDB;