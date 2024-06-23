CREATE TABLE topicos (
  id BIGINT AUTO_INCREMENT NOT NULL,
   titulo VARCHAR(255) NULL,
   mensagem VARCHAR(255) NULL,
   data_de_criacao datetime NULL,
   estado_do_topico SMALLINT NULL,
   nome VARCHAR(255) NULL,
   nome_curso VARCHAR(255) NULL,

   PRIMARY KEY (id)
);