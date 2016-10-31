CREATE TABLE egresso
(
   id integer NOT NULL AUTO_INCREMENT, 
   nome varchar(300) NOT NULL, 
   nome_mae varchar(300) NOT NULL, 
   data_nascimento date NOT NULL, 
   foto_principal longblob, 
   foto_adicionais blob, 
   visibilidade varchar(11), 
   sexo varchar(9), 
  
   CONSTRAINT pk PRIMARY KEY (id), 
   CONSTRAINT chk_sexo CHECK (sexo = 'masculino' OR sexo = 'feminino'),
   CONSTRAINT chk_dados CHECK (visibilidade = 'publico' OR visibilidade = 'privado' OR visibilidade = 'so egressos')
);

CREATE TABLE residencia
(
  data_inicio date NOT NULL,
  data_fim date,
  endereco varchar(300) NOT NULL,
  
  CONSTRAINT pk_residencia PRIMARY KEY (data_inicio)
);

CREATE TABLE localizacao_geografica
(
  id integer NOT NULL AUTO_INCREMENT,
  nome_cidade varchar(300) NOT NULL,
  nome_unidade_federativa varchar(300) NOT NULL,
  nome_pais varchar(300) NOT NULL,
  sigla varchar(50) NOT NULL,
  latitude real,
  longitude real,
  
  CONSTRAINT pk_localizacao PRIMARY KEY (id)
);

CREATE TABLE AREA_DE_CONHECIMENTO
(
nome VARCHAR(300) NOT NULL,
CODIGO INTEGER PRIMARY KEY  NOT NULL AUTO_INCREMENT,
SUPER_AREA INTEGER REFERENCES AREA_DE_CONHECIMENTO (CODIGO)
);

CREATE TABLE UNIDADE_ACADEMICA
(
ID VARCHAR(40) PRIMARY KEY NOT NULL
);

CREATE TABLE CURSO_DA_UFG
(
NIVEL ENUM ( 'Bacharelado', 'Licenciatura', 'Aperfeicoamento', 'Especializacao', 'Mestrado', 'Doutorado') NOT NULL,
TIPO_DE_RESOLUCAO ENUM ('CEPEC', 'CONSUNI') NOT NULL,
NUMERO_DA_RESOLUCAO INTEGER PRIMARY KEY NOT NULL,
E_PRESENCIAL BOOLEAN NOT NULL,
TURNO ENUM ('Matutino', 'Vespertino', 'Integral') NOT NULL,
UNIDADE_ACADEMICA VARCHAR(40) REFERENCES UNIDADE_ACADEMICA (ID),
AREA_DE_CONHECIMENTO INTEGER REFERENCES AREA_DE_CONHECIMENTO (CODIGO)
);

CREATE TABLE HISTORICO_NA_UFG
(
NUMERO_MATRICULA_CURSO INTEGER PRIMARY KEY NOT NULL,
MES_DE_INICIO INTEGER NOT NULL,
ANO_DE_INICIO INTEGER NOT NULL,
MES_DE_FIM INTEGER NOT NULL,
ANO_DE_FIM INTEGER NOT NULL,  
TITULO_DO_TRABALHO_FINAL VARCHAR(500),
CURSO INTEGER REFERENCES CURSO_DA_UFG (NUMERO_DA_RESOLUCAO),
ID_EGRESSO INTEGER REFERENCES EGRESSO (ID) 
);

CREATE TABLE AVALIACAO_DO_CURSO_PELO_EGRESSO
(
HISTORICO INTEGER REFERENCES HISTORICO_NA_UFG (NUMERO_MATRICULA_CURSO),
DATA_AVALIACAO DATE NOT NULL,
MOTIVACAO_ESCOLHA ENUM ('Qualidade/Reputacao do Curso', 'Qualidade/Reputacao da IES', 'Gratuidade', 'Outra') NOT NULL,
SATISFACAO_CURSO INTEGER NOT NULL,
	CHECK (SATISFACAO_CURSO >= 0 AND SATISFACAO_CURSO <=10),
CONCEITO_GLOBAL_CURSO INTEGER NOT NULL,
	CHECK (CONCEITO_GLOBAL_CURSO >= 0 AND CONCEITO_GLOBAL_CURSO <=10),
PREPARACAO_PARA_MERCADO INTEGER NOT NULL,
	CHECK (PREPARACAO_PARA_MERCADO >= 0 AND PREPARACAO_PARA_MERCADO <=10),
MELHORIA_CAPACIDADE_COMUNICACAO INTEGER NOT NULL,
	CHECK (MELHORIA_CAPACIDADE_COMUNICACAO >= 0 AND MELHORIA_CAPACIDADE_COMUNICACAO <=10),
CAPACIDADE_ETICA_RESPONSABILIADE INTEGER NOT NULL,
	CHECK (CAPACIDADE_ETICA_RESPONSABILIADE >= 0 AND CAPACIDADE_ETICA_RESPONSABILIADE <=10),
CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO INTEGER NOT NULL,
	CHECK (CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO >= 0 AND CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO <=10),
COMENTARIO VARCHAR(300)
);

CREATE TABLE REALIZACAO_DE_PROGRAMA_ACADEMICO
(
HISTORICO INTEGER REFERENCES HISTORICO_NA_UFG (NUMERO_MATRICULA_CURSO),
TIPO ENUM ('Iniciacao_Cientifica', 'Monitoria', 'Extensao', 'Intercambio') NOT NULL,
DATA_INICIO DATE NOT NULL,
DATA_FIM  DATE NOT NULL,
DESCRICAO VARCHAR(300) NOT NULL
);
