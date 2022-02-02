CREATE TABLE presenca(
    id bigint not null auto_increment,
    aluno_id bigint,
    presenca boolean not null,
    primary key (id)
);

ALTER TABLE presenca ADD CONSTRAINT fk_id
FOREIGN KEY(aluno_id) REFERENCES aluno(id);

insert into presenca (aluno_id, presenca) values (1, TRUE);

