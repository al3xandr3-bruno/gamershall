create table jogo_jogado(
	id bigint primary key auto_increment,
    usuario_id bigint not null,
    jogo_id bigint not null,
    data_cadastro date not null,
    data_ultima_jogatina datetime
)engine=InnoDB;

alter table jogo_jogado
	add constraint fk_usuario_id foreign key(usuario_id) references usuario(id),
    add constraint fk_jogo_id foreign key(jogo_id) references jogo(id);