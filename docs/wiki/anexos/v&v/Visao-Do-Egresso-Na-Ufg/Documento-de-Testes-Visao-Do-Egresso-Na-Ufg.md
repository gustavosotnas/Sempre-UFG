# Documento de Procedimentos - (Vis�o do Egresso na UFG)
 
 ## 1. Descri��o do Artefato
 |Artefato Avaliado| Descri��o do Artefato |
 |-----------------|-----------------------|
 |DDl Visao do Egresso na UFG|Implementa��o da DDL que integra os RD's: PessoaEgres e CursUfgEgres, que formam a vis�o de Egresso na UFG|
 
 ## 2. Crit�rios de Coberturas dos Testes
 - Os testes implementados devem garantir que a DDL que implementa o requisito de dados est� correta.
 - Todas as implementa��es devem ser testadas.
 - Os testes devem ser aprovados independentemente do banco de dados utilziado (MariaDb e Postgres).
 - O artefato testado deve conter todos os dados necess�rios para a execu��o dos testes, bem como corresponder a especifica��o de requisitos.
 
 ## 3. Especifica��o dos Testes
 Nesta parte do documento devem ser descritos os procedimentos e os casos de teste a serem aplicados. Dar um identificador para o conjunto de testes
 
 ### 3.1 Recursos
 |Codigo|Descri��o|Localiza��o|Aplicabilidade|
 |------|---------|-----------|--------------|
 |RC1|Kleudson|Time de desenvolvimento|Respons�vel por executar os testes.|
 |RC2|Script DML com todos os comandos utilizados nos testes para testar a DDL que integra a vis�o do egresso no sistema SempreUFG.|.\Sempre-UFG\db\|Testes manuais de banco de dados.|
 
 ### 3.2 Procedimentos
 - O diagrama de entidade e relacionamento definido no documento de Requisitos do Software SempreUFG � a base de cria��o dos casos de testes.
 - O casos de testes foram aplicados na DDL que integra a vis�o do egresso na ufg disponibilizada no resposit�rio do projeto, realizando a execu��o dos testes e coletando seus resultados.
 - Os resultados coletados e analisados foram descritos no relatorio que descreve os resultados dos procedimentos.
 - Os testes foram executados manualmente.
 
 ### 3.3 Casos de Testes
 #### 3.3.1 CheckList de Qualidade
 Padr�es simples que v�o deixar a base de dados organizada e de f�cil entendimento. Focando em melhorar a qualidade das estruturas de dados de uma maneira simples e eficiente.
 - N�o usar espa�o em branco;
 - N�o usar h�fen, acentos e caracteres especiais;
 - N�o usar palavras reservadas como: INSERT, DELETE, SELECT e etc.;
 - N�o usar mais que 30(trinta) caracteres;
 - N�o usar verbos;
 - Escrever em mai�sculo ou min�sculo;
 - N�o utilizar palavras no plural;
 - N�o usar preposi��es;
 - N�o usar n�meros;
 - N�o usar nomes pr�prios;
 - Separe os nomes com underline;
 - Crie nomes sucintos e objetivos;
 - O nome n�o pode ter v�rias interpreta��es;
 
 #### 3.3.2 Entradas V�lidas
 **CT-1 . Conjunto de testes para verificar se as tabelas est�o criadas no Banco de dados**
 
 |Caso de Teste|Pr�-condi��es|Descri��o|Entrada|Resultado Esperado|
 |-------------|-------------|------------|-------|---------|
 |CT-1.1|Banco de dados funcionando corretamente.|Verifica se a tabela referente aos dados do egresso de PessoaEgres.|SELECT * FROM EGRESSO| true|
 |CT-1.2| * | Verifica se a tabela referente A PessoaEgres existe.|SELECT * FROM RESIDENCIA| true|
 |CT-1.3| * | Verifica se a tabela referente a localiza��o geogr�fica existe.|SELECT * FROM LOCALIZACAO_GEOGRAFICA | true|
 |CT-1.4|* |Verifica se a tabela referente a �rea de conhecimento existe.|SELECT * FROM AREA_DE_CONHECIMENTO| true|
 |CT-1.5| * | Verifica se a tabela referente a unidade acad�mica existe.|SELECT * FROM UNIDADE_ACADEMICA| true|
 |CT-1.6| * | Verifica se a tabela referente ao curso da ufg existe.| SELECT * FROM CURSO_DA_UFG|true|
 |CT-1.7| * | Verifica se a tabela referente hist�rico na ufg existe.|SELECT * FROM HISTORICO_NA_UFG| true|
 |CT-1.8| *| Verifica se a tabela referente a a avalia��o do cursos por parte do egresso existe.|SELECT * FROM AVALIACAO_DO_CURSO_PELO_EGRESSO|true|
 |CT-1.9|*|Verifica se a tabela referente a realiza��o de programas acad�micos existe.|SELECT * FROM REALIZACAO_DE_PROGRAMA_ACADEMICO|true|
 
 **CT-2. Conjunto de testes para verificar se as tabelas est�o aceitando os dados validos corretamente, e com entradas com todos os campos obrigatorios e opcionais**
 
 |Caso de Teste|Pr�-condi��es|Descri��o|Entrada|Resultado Esperado|
 |-------------|-------------|------------|-------|---------|
 |CT-2.1|Tabela EGRESSO existente.|Realiza a inser��o de dados de egresso com todos os dados validos e campos obrigatorios.| INSERT INTO EGRESSO (ID, NOME, NOME_MAE, DATA_NASCIMENTO, FOTO_PRINCIPAL, FOTO_ADICIONAIS, VISIBILIDADE, SEXO) VALUES (2, 'Kleudson Rodrigues de Souza', 'Aparecida Pereira de Souza', '24-01-2010', E'\\xDEADCEEF', null, 'publico', 'masculino')|true|
|CT-2.2|Tabela RESIDENCIA existente.|Realiza inser��o de dados de uma residencia com todos os dados validos, campos obrigatorios e campos opcionais|INSERT INTO RESIDENCIA (DATA_INICIO, DATA_FIM, ENDERECO) VALUES ('14-12-2016', '15-12-2016', 'Av. Floresta, Qd. 15 Lt. 16')|true|
 |CT-2.3|Tabela LOCALIZACAO_GEOGRAFICA existente.|Realiza inser��o de dados em na tabela localizacao_geografica com todos os dados validos, campos obrigatorios e campos opcionais.|INSERT INTO LOCALIZACAO_GEOGRAFICA (ID, NOME_CIDADE, NOME_UNIDADE_FEDERATIVA, NOME_PAIS, SIGLA, LATITUDE, LONGITUDE) VALUES ('1', 'Goi�nia', 'Goi�s', 'Brasil', 'BR', '-16.603402', '-49.266637')|true|
 |CT-2.4|Tabela AREA_DE_CONHECIMENTO existente.|Realiza a inser��o de dados na ta tabela area_de_conhecimento com todos os dados validos, campos obrigatorios e campos opcionais.|INSERT INTO AREA_DE_CONHECIMENTO (NOME, CODIGO, SUPER_AREA) VALUES ('Inform�tica', 1, 1)|true|
 |CT-2.5|Tabela UNIDADE_ACADEMICA existente.|Realiza a inser��o de dados com todos os dados validos, campos obrigatorios e campos opcionais.|INSERT INTO UNIDADE_ACADEMICA (ID) VALUES (1)|true|
 |CT-2.6|Tabela CURSO_DA_UFG existente.|Realiza a inser��o de dados dos cursos da ufg, com todos os dados validos, campos obrigatorios e campos opcionais.|INSERT INTO CURSO_DA_UFG (NIVEL, TIPO_DE_RESOLUCAO, NUMERO_DA_RESOLUCAO, E_PRESENCIAL, TURNO, UNIDADE_ACADEMICA, AREA_DE_CONHECIMENTO) VALUES ('Bacharelado', 'CONSUNI', 1, TRUE, 'Matutino', 1, 1)|true|
 |CT-2.7|Tabela HISTORICO_NA_UFG existente.|Realiza a inser��o de dados na tabela hist�rico na ufg, campos obrigatorios e campos opcionais.|INSERT INTO HISTORICO_NA_UFG (NUMERO_MATRICULA_CURSO, MES_DE_INICIO, ANO_DE_INICIO, MES_DE_FIM, ANO_DE_FIM, TITULO_DO_TRABALHO_FINAL, CURSO, ID_EGRESSO) VALUES (201392248, 01, 2011, 12, 2016, 'A Engenharia de Software no Dia-a-Dia', 1, 1)|true|
 |CT-2.8|Tabela AVALIACAO_DO_CURSO_PELO_EGRESSO existente.|Realiza inser��o de dados da avalia��o do curso pelo egresso de todos os dados validos, campos obrigatorios e campos opcionais.|INSERT INTO AVALIACAO_DO_CURSO_PELO_EGRESSO (HISTORICO, DATA_AVALIACAO, MOTIVACAO_ESCOLHA, SATISFACAO_CURSO, CONCEITO_GLOBAL_CURSO, PREPARACAO_PARA_MERCADO, MELHORIA_CAPACIDADE_COMUNICACAO, CAPACIDADE_ETICA_RESPONSABILIADE, CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO, COMENTARIO) VALUES (201392248, '01-12-2016', 'Qualidade/Reputacao do Curso', 10, 10, 10, 10, 10, 10, 'Coment�rio sobre o curso de Engenharia de Software')|true|
 |CT-2.9|Tabela REALIZACAO_DE_PROGRAMA_ACADEMICO existente.|Realiza inser��o de dados da realiza��o do programa acad�mico com todos os dados validos, campos obrigatorios e campos opcionais.|INSERT INTO REALIZACAO_DE_PROGRAMA_ACADEMICO (HISTORICO, TIPO, DATA_INICIO, DATA_FIM, DESCRICAO) VALUES (201392248, 'Iniciacao_Cientifica', '02-12-2016', '02-01-2017', 'Descri��o do Programa Acad�mico')|true|

#### 3.3.3 Entradas Inv�lidas
 
 **CT-3. Conjunto de testes para verificar se as tabelas est�o sendo tratadas para n�o receber dados faltantes.**
 
 |Caso de Teste|Pr�-condi��es|Descri��o|Entrada|Resultado Esperado|
 |-------------|-------------|------------|-------|---------|
 |CT-3.1|Tabela EGRESSO existente.|Realiza a inser��o de dados de um EGRESSO com id faltando.| INSERT INTO EGRESSO (NOME, NOME_MAE, DATA_NASCIMENTO, FOTO_PRINCIPAL, FOTO_ADICIONAIS, VISIBILIDADE, SEXO) VALUES ('Kleudson Rodrigues de Souza', 'Aparecida Pereira de Souza', '24-01-2010', E'\\xDEADCEEF', null, 'publico', 'masculino')|true|
 |CT-3.2|Tabela EGRESSO existente.|Realiza a inser��o de dados de um usu�rio com nome faltando.| INSERT INTO EGRESSO (ID, NOME_MAE, DATA_NASCIMENTO, FOTO_PRINCIPAL, FOTO_ADICIONAIS, VISIBILIDADE, SEXO) VALUES (10, 'Aparecida Pereira de Souza', '24-01-2010', E'\\xDEADCEEF', null, 'publico', 'masculino')|true|
 |CT-3.3|Tabela EGRESSO existente.|Realiza a inser��o de dados de um usu�rio com nome da m�e faltando.| INSERT INTO EGRESSO (ID, NOME, DATA_NASCIMENTO, FOTO_PRINCIPAL, FOTO_ADICIONAIS, VISIBILIDADE, SEXO) VALUES (2, 'Kleudson Rodrigues de Souza', '24-01-2010', E'\\xDEADCEEF', null, 'publico', 'masculino')|true|
 |CT-3.4|Tabela EGRESSO existente.|Realiza a inser��o de dados de um usu�rio com data de nascimento faltando..|INSERT INTO EGRESSO (ID, NOME, NOME_MAE, FOTO_PRINCIPAL, FOTO_ADICIONAIS, VISIBILIDADE, SEXO) VALUES (2, 'Kleudson Rodrigues de Souza', 'Aparecida Pereira de Souza', E'\\xDEADCEEF', null, 'publico', 'masculino')|true|
 |CT-3.5|Tabela RESIDENCIA existente.|Realiza inser��o de dados de resid�ncia com data de in�cio faltando.|INSERT INTO RESIDENCIA (DATA_FIM, ENDERECO) VALUES ('15-12-2016', 'Av. Floresta, Qd. 15 Lt. 16')|true|
 |CT-3.6|Tabela RESIDENCIA existente.|Realiza inser��o de dados de resid�ncia com endere�o faltando.|INSERT INTO RESIDENCIA (DATA_INICIO, DATA_FIM) VALUES ('14-12-2016', '15-12-2016')|true|
 |CT-3.7|Tabela LOCALIZACAO_GEOGRAFICA existente.|Realiza a inser��o de dados de localiza��o geogr�fica com id faltando.|INSERT INTO LOCALIZACAO_GEOGRAFICA (NOME_CIDADE, NOME_UNIDADE_FEDERATIVA, NOME_PAIS, SIGLA, LATITUDE, LONGITUDE) VALUES ('Goi�nia', 'Goi�s', 'Brasil', 'BR', '-16.603402', '-49.266637')|true|
 |CT-3.8|Tabela LOCALIZACAO_GEOGRAFICA existente.|Realiza a inser��o de dados de localiza��o geogr�fica com nome da cidade faltando.|INSERT INTO LOCALIZACAO_GEOGRAFICA (ID, NOME_UNIDADE_FEDERATIVA, NOME_PAIS, SIGLA, LATITUDE, LONGITUDE) VALUES (1, 'Goi�s', 'Brasil', 'BR', '-16.603402', '-49.266637')|true|
 |CT-3.9|Tabela LOCALIZACAO_GEOGRAFICA existente.|Realiza a inser��o de dados de localiza��o geogr�fica com nome da unidade federativa faltando.|INSERT INTO LOCALIZACAO_GEOGRAFICA (ID, NOME_CIDADE, NOME_PAIS, SIGLA, LATITUDE, LONGITUDE) VALUES (1, 'Goi�nia', 'Brasil', 'BR', '-16.603402', '-49.266637')|true|
 |CT-3.10|Tabela LOCALIZACAO_GEOGRAFICA existente.|Realiza a inser��o de dados de localiza��o geogr�fica com nome do pa�s faltando.|INSERT INTO LOCALIZACAO_GEOGRAFICA (ID, NOME_CIDADE, NOME_UNIDADE_FEDERATIVA, SIGLA, LATITUDE, LONGITUDE) VALUES (1, 'Goi�nia', 'Goi�s', 'BR', '-16.603402', '-49.266637')|true|
 |CT-3.11|Tabela LOCALIZACAO_GEOGRAFICA existente.|Realiza a inser��o de dados de localiza��o geogr�fica com sigla faltando.|INSERT INTO LOCALIZACAO_GEOGRAFICA (ID, NOME_CIDADE, NOME_UNIDADE_FEDERATIVA, NOME_PAIS, LATITUDE, LONGITUDE) VALUES (1, 'Goi�nia', 'Goi�s', 'Brasil', '-16.603402', '-49.266637')|true|
 |CT-3.12|Tabela AREA_DE_CONHECIMENTO existente.|Realiza a inser��o de dados de uma �rea de conhecimento com nome faltando.|INSERT INTO AREA_DE_CONHECIMENTO (CODIGO, SUPER_AREA) VALUES (1, 1)|true|
 |CT-3.13|Tabela AREA_DE_CONHECIMENTO existente.|Realiza a inser��o de dados de uma �rea de conhecimento com c�digo faltando.|INSERT INTO AREA_DE_CONHECIMENTO (NOME, SUPER_AREA) VALUES ('Inform�tica', 1)|true|
 |CT-3.14|Tabela CURSO_DA_UFG existente.|Realiza inser��o de curso da ufg com nivel faltando.|INSERT INTO CURSO_DA_UFG (TIPO_DE_RESOLUCAO, NUMERO_DA_RESOLUCAO, E_PRESENCIAL, TURNO, UNIDADE_ACADEMICA, AREA_DE_CONHECIMENTO) VALUES ('CONSUNI', 1, TRUE, 'Matutino', 1, 1)|true|
 |CT-3.15|Tabela CURSO_DA_UFG existente.|Realiza inser��o de curso da ufg com tipo de resolu��o faltando.|INSERT INTO CURSO_DA_UFG (NIVEL,  NUMERO_DA_RESOLUCAO, E_PRESENCIAL, TURNO, UNIDADE_ACADEMICA, AREA_DE_CONHECIMENTO) VALUES ('Bacharelado', 1, TRUE, 'Matutino', 1, 1)|true|
 |CT-3.16|Tabela CURSO_DA_UFG existente.|Realiza inser��o de curso da ufg com numero da resolu��o faltando.|INSERT INTO CURSO_DA_UFG (NIVEL, TIPO_DE_RESOLUCAO, E_PRESENCIAL, TURNO, UNIDADE_ACADEMICA, AREA_DE_CONHECIMENTO) VALUES ('Bacharelado', 'CONSUNI', TRUE, 'Matutino', 1, 1)|true|
 |CT-3.17|Tabela CURSO_DA_UFG existente.|Realiza inser��o de curso da ufg com a verifica��o se � presencial faltando.|INSERT INTO CURSO_DA_UFG (NIVEL, TIPO_DE_RESOLUCAO, NUMERO_DA_RESOLUCAO, TURNO, UNIDADE_ACADEMICA, AREA_DE_CONHECIMENTO) VALUES ('Bacharelado', 'CONSUNI', 1, 'Matutino', 1, 1)|true|
 |CT-3.18|Tabela CURSO_DA_UFG existente.|Realiza inser��o de curso da ufg com turno faltando.|INSERT INTO CURSO_DA_UFG (NIVEL, TIPO_DE_RESOLUCAO, NUMERO_DA_RESOLUCAO, E_PRESENCIAL, UNIDADE_ACADEMICA, AREA_DE_CONHECIMENTO) VALUES ('Bacharelado', 'CONSUNI', 1, TRUE, 1, 1)|true|
 |CT-3.19|Tabela CURSO_DA_UFG existente.|Realiza inser��o de curso da ufg com unidade acad�mica faltando.|INSERT INTO CURSO_DA_UFG (NIVEL, TIPO_DE_RESOLUCAO, NUMERO_DA_RESOLUCAO, E_PRESENCIAL, TURNO, AREA_DE_CONHECIMENTO) VALUES ('Bacharelado', 'CONSUNI', 1, TRUE, 'Matutino', 1)|true|
 |CT-3.20|Tabela CURSO_DA_UFG existente.|Realiza inser��o de curso da ufg com �rea de conhecimento faltando.|INSERT INTO CURSO_DA_UFG (NIVEL, TIPO_DE_RESOLUCAO, NUMERO_DA_RESOLUCAO, E_PRESENCIAL, TURNO, UNIDADE_ACADEMICA) VALUES ('Bacharelado', 'CONSUNI', 1, TRUE, 'Matutino', 1)|true|
 |CT-3.21|Tabela HISTORICO_NA_UFG existente.|Realiza inser��o de dados de hist�rico com n�mero da matr�cula do curso faltando.|INSERT INTO HISTORICO_NA_UFG (MES_DE_INICIO, ANO_DE_INICIO, MES_DE_FIM, ANO_DE_FIM, TITULO_DO_TRABALHO_FINAL, CURSO, ID_EGRESSO) VALUES (01, 2011, 12, 2016, 'A Engenharia de Software no Dia-a-Dia', 1, 1)|true|
 |CT-3.22|Tabela HISTORICO_NA_UFG existente.|Realiza inser��o de dados de hist�rico com m�s de in�cio faltando.|INSERT INTO HISTORICO_NA_UFG (NUMERO_MATRICULA_CURSO, ANO_DE_INICIO, MES_DE_FIM, ANO_DE_FIM, TITULO_DO_TRABALHO_FINAL, CURSO, ID_EGRESSO) VALUES (201392248, 2011, 12, 2016, 'A Engenharia de Software no Dia-a-Dia', 1, 1)|true|
 |CT-3.23|Tabela HISTORICO_NA_UFG existente.|Realiza inser��o de dados de hist�rico com ano de in�cio faltando.|INSERT INTO HISTORICO_NA_UFG (NUMERO_MATRICULA_CURSO, MES_DE_INICIO, MES_DE_FIM, ANO_DE_FIM, TITULO_DO_TRABALHO_FINAL, CURSO, ID_EGRESSO) VALUES (201392248, 01, 12, 2016, 'A Engenharia de Software no Dia-a-Dia', 1, 1)|true|
 |CT-3.24|Tabela HISTORICO_NA_UFG existente.|Realiza inser��o de dados de hist�rico com m�s de fim faltando.|INSERT INTO HISTORICO_NA_UFG (NUMERO_MATRICULA_CURSO, MES_DE_INICIO, ANO_DE_INICIO, ANO_DE_FIM, TITULO_DO_TRABALHO_FINAL, CURSO, ID_EGRESSO) VALUES (201392248, 01, 2011, 2016, 'A Engenharia de Software no Dia-a-Dia', 1, 1)|true|
 |CT-3.25|Tabela HISTORICO_NA_UFG existente.|Realiza inser��o de dados de hist�rico com ano de fim faltando.|INSERT INTO HISTORICO_NA_UFG (NUMERO_MATRICULA_CURSO, MES_DE_INICIO, ANO_DE_INICIO, MES_DE_FIM, TITULO_DO_TRABALHO_FINAL, CURSO, ID_EGRESSO) VALUES (201392248, 01, 2011, 12, 'A Engenharia de Software no Dia-a-Dia', 1, 1)|true|
 |CT-3.26|Tabela HISTORICO_NA_UFG existente.|Realiza inser��o de dados de hist�rico com t�tulo do trabalho final faltando.|INSERT INTO HISTORICO_NA_UFG (NUMERO_MATRICULA_CURSO, MES_DE_INICIO, ANO_DE_INICIO, MES_DE_FIM, ANO_DE_FIM, CURSO, ID_EGRESSO) VALUES (201392248, 01, 2011, 12, 2016, 1, 1)|true|
  |CT-3.27|Tabela HISTORICO_NA_UFG existente.|Realiza inser��o de dados de hist�rico com curso faltando.|INSERT INTO HISTORICO_NA_UFG (NUMERO_MATRICULA_CURSO, MES_DE_INICIO, ANO_DE_INICIO, MES_DE_FIM, ANO_DE_FIM, TITULO_DO_TRABALHO_FINAL, ID_EGRESSO) VALUES (201392248, 01, 2011, 12, 2016, 'A Engenharia de Software no Dia-a-Dia', 1)|true|
   |CT-3.28|Tabela HISTORICO_NA_UFG existente.|Realiza inser��o de dados de hist�rico com id do egresso faltando.|INSERT INTO HISTORICO_NA_UFG (NUMERO_MATRICULA_CURSO, MES_DE_INICIO, ANO_DE_INICIO, MES_DE_FIM, ANO_DE_FIM, TITULO_DO_TRABALHO_FINAL, CURSO) VALUES (201392248, 01, 2011, 12, 2016, 'A Engenharia de Software no Dia-a-Dia', 1)|true|
   |CT-3.29|Tabela AVALIACAO_DO_CURSO_PELO_EGRESSO existente.|Realiza inser��o de dados de avalia��o do curso pelo egresso com id do egresso faltando.|INSERT INTO AVALIACAO_DO_CURSO_PELO_EGRESSO (HISTORICO, DATA_AVALIACAO, MOTIVACAO_ESCOLHA, SATISFACAO_CURSO, CONCEITO_GLOBAL_CURSO, PREPARACAO_PARA_MERCADO, MELHORIA_CAPACIDADE_COMUNICACAO, CAPACIDADE_ETICA_RESPONSABILIADE, CAPACIDADE_HABILIDADES_AREA_CONHECIMENTO, COMENTARIO) VALUES (201392248, '01-12-2016', 'Qualidade/Reputacao do Curso', 10, 10, 10, 10, 10, 10, 'Coment�rio sobre o curso de Engenharia de Software')|true|
 
 **CT-4. Conjunto de testes para verificar se as tabelas est�o sendo tratadas para n�o receber dados incorretos.**
 
 |Caso de Teste|Pr�-condi��es|Descri��o|Entrada|Resultado Esperado|
 |-------------|-------------|------------|-------|---------|
 |CT-4.1|Tabela USUARIO existente.|Realiza a inser��o de dados de um usu�rio com campos incorretos.| INSERT INTO USUARIO VALUES email_principal = 'julianny@inf.ufg.br', senha = 3A56S3DA4S5AF6A5S5D4, nome_social = 'Julianny Alves', cpf = '1234567890', foto_pessoal = E'\\xDEADBEEF, recebe_divulgacao = 'semanal', timestamp_cadastro = '2013-03-04 14:03:11', timestamp_ultima_atualizacao = 2016-07-12 10:39:23, timestamp_exclusao_logica = 2016-12-23|true|
 |CT-4.2|Tabela IMPORTACAO_EGRESSO existente.|Realiza inser��o de dados de uma importa��o de egressos com campos incorretos.|INSERT INTO IMPORTACAO_EGRESSO VALUES timestamp_execucao = '2016-12-06 09:45:01', inicio_periodo = 2016-12-06 09:57:03, fim_periodo = 2016-12-06 10:05:43, qtde_egresso_recebido = 45, qtde_importado_sucesso = 45, qtde_egresso_incorreto = 45, qtde_egresso_replicado = '45', id_usuario_autorizador = 'julianny@inf.ufg.br'|true|
 |CT-4.3|Tabela INSTANCIA_ADMINISTRATIVA_UFG existente.|Realiza inser��o de dados de uma instancia administrativa da UFG com campos incorretos.|INSERT INTO INSTANCIA_ADMINISTRATIVA_UFG VALUES sigla_instancia = INF, nome_instancia = 'Instituto de Informatica', tipo_instancia = Unidade, data_criacao = 2015-12-07, data_encerramento = 2016-12-07, email_institucional = 'inf@inf.ufg,br', url_institucional = 'http://wwww.inf.ufg.br', id_usuario_responsavel = 'julianny@inf.ufg.br'|true|
 |CT-4.4|Tabela IMPORTACAO_RESTRITA_EGRESSO existente.|Realiza a inser��o de dados de uma importados de dados de egressos restrito a um egresso com dados incorretos.|INSERT INTO IMPORTACAO_RESTRITA_EGRESSO VALUES id_egresso = '1', id_IMPORTACAO_EGRESSO = '2016-12-06 09:45:01'|true|
 |CT-4.5|Tabela IMPORTACAO_RESTRITA_INSTANCIA existente.|Realiza a inser��o de dados de uma importados de dados de egressos restrito a uma instancia administrativa com dados incorretos.|INSERT INTO IMPORTACAO_RESTRITA_INSTANCIA VALUES id_instancia = INF, id_IMPORTACAO_EGRESSO = 2016-12-06 09:45:01|true|
 |CT-4.6|Tabela BACKUP_SISTEMA existente.|Realiza a inser��o de dados de um backup do sistema com dados incorretos.|INSERT INTO BACKUP_SISTEMA VALUES id_backup_sistema = 'backup do sistema 001', timestamp_inicio_backup = '2016-12-07 15:00:00', timestamp_fim_backup = 2016-12-07 16:00:00, local_armazenamento = 'c:/Backup/SempreUFG/', timestamp_RESTAURACAOcao_sistema = 20160423, id_usuario_copia = 'julianny@inf.ufg.br'|true|
 |CT-4.7|Tabela RESTAURACAO_SISTEMA existente.|Realiza a inser��o de dados de uma restaura��o do sistema com dados incorretos.|INSERT INTO RESTAURACAO_SISTEMA VALUES timestamp_restauracao = '2016-12-15 13:43:11', motivo_restauracao = 'instalado software infectuoso.', id_backup_sistema = 'backup do sistema 001', id_usuario_restaura = 'julianny@inf.ufg.br'|true|
 |CT-4.8|Tabela PAPEL_USUARIO existente.|Realiza inser��o de dados de um papel que o usuario exerce no sistema com dados incorretos.|INSERT INTO PAPEL_USUARIO VALUES sigla_papel = ADM, nome_papel = 'Administrador'|true|
 |CT-4.9|Tabela RECURSO_SISTEMA existente.|Realiza inser��o de dados de um recurso do sistema com dados incorretos.|INSERT INTO RECURSO_SISTEMA VALUES sigla_recurso = LOGIN, descricao_recurso = 'Usuario realiza o acesso ao sistema.'|true|
 |CT-4.10|Tabela USUARIO_EXERCE_PAPEL existente.|Realiza inser��o de dados de usuario que exerce algum papel dentro do sistema com dados incorretos.|INSERT INTO USUARIO_EXERCE_PAPEL VALUES id_usuario = 'julianny@inf.ufg.br', id_papel_sistema = ADM|true|
 |CT-4.11|Tabela PAPEL_ACESSA_RECURSO existente.|Realiza inser��o de dados de um papel de usario que acessa uma funcionalidade do sistema com dados incorretos..|INSERT INTO PAPEL_ACESSA_RECURSO VALUES id_papel_sistema = 'ADM', id_recurso_sistema = LOGIN|true|
 |CT-4.12|Tabela SEMPREUFG existente.|Realiza inser��o de dados de um sistema com dados incorretos.|INSERT INTO SEMPREUFG VALUES nome_sistema = 'SempreUFG', timestamp_instalacao = '2016-01-01 12:43:11', id_usuario_gestor = 'julianny@inf.ufg.br|true|
 |CT-4.13|Tabela PARAMETRO existente.|Realiza inser��o de dados dos paramentros de sistema com dados incorretos.|INSERT INTO PARAMETRO VALUES sigla_parametro = 'BACKUP_SEMANAL', tipo = 'Backup', descricao_parametro = 'Fazer backup do sistema por preven��o.', valor_parametro = backup123, id_sistema = SempreUFG|true|