create table engine(
	id bigint primary key auto_increment,
    nome varchar(100),
    versao varchar(50),
    empresa_desenvolvedora varchar(100)
)engine = InnoDB;

create table jogo(
	id bigint primary key auto_increment,
    titulo varchar(100),
    genero varchar(50),
    n_jogadores bigint,
    data_de_lancamento varchar(50),
    sinopse_descricao text
)engine = InnoDB;