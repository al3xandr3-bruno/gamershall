create table estudio(
	id bigint primary key auto_increment,
    nome varchar(100) not null,
    empresa_dona varchar(100) not null
)engine = InnoDB;

create table engine(
	id bigint primary key auto_increment,
    nome varchar(100) not null unique,
    versao varchar(50) not null,
    empresa_desenvolvedora varchar(100) not null
)engine = InnoDB;

create table jogo(
	id bigint primary key auto_increment,
    titulo varchar(100) not null,
    genero varchar(50) not null,
    n_jogadores bigint not null,
    data_lancamento varchar(50) not null,
    sinopse_descricao text not null
)engine = InnoDB;

alter table jogo
    add column engine_id bigint,
    add column estudio_id bigint,
    add constraint fk_engine_id foreign key(engine_id) references engine(id),
    add constraint fk_estudio_id foreign key(estudio_id) references estudio(id);
