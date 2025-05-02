alter table jogo
    add column engine_id bigint,
    add column estudio_id bigint,
    add constraint fk_engine_id foreign key(engine_id) references engine(id),
    add constraint fk_estudio_id foreign key(estudio_id) references estudio(id);