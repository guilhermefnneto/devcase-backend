DEVCASE TEST - BACKENND


Observação: Para o objeto cliente, modelei considerando apenas pessoas físicas.

Observação: Deixei para que o JPA-Hibernate cuidasse da criação das tabelas.

Observação: Para as vendas, simplifiquei em apenas uma classe de negócio, colocando um valor para a venda.
            No cenário real, criaria a solução completa com os objetos de negócio produto e itens de produto, onde estes compunham uma venda.



Comandos para criar e usar o banco no MySql: 

  CREATE DATABASE devcase;

  USE devcase;



Observação: Suba o SpringBoot para que o JPA-Hibernate crie as tabelas. 


Segue alguns inserts para alimentação inicial do banco e para que os testes sejam realizados com maior coerência:


INSERT INTO cliente (nome, data_nascimento, sexo, telefone_residencial, telefone_celular, email, estado_civil, pontos) VALUES ('Guilherme Francisco Nuno Neto', '1983-05-17', 'MASCULINO', null, 14991193518, 'guilherme.fn.neto@outlook.com', 'SOLTEIRO', 0);
INSERT INTO cliente (nome, data_nascimento, sexo, telefone_residencial, telefone_celular, email, estado_civil, pontos) VALUES ('Fabiano Alonso Pascoaletto', '1982-11-28', 'MASCULINO', null, 14988886666, 'fabiano.pascoaletto@yahoo.com', 'SOLTEIRO', 0);
INSERT INTO cliente (nome, data_nascimento, sexo, telefone_residencial, telefone_celular, email, estado_civil, pontos) VALUES ('Leopoldo Gutierrez', '1974-02-02', 'MASCULINO', null, 14976554433, 'leopoldo.gutierrez@yahoo.com', 'CASADO', 0);
INSERT INTO cliente (nome, data_nascimento, sexo, telefone_residencial, telefone_celular, email, estado_civil, pontos) VALUES ('Maria Ferreira Pietro', '1986-06-20', 'FEMININO', null, 14998787896, 'maria.pietro@gmail.com', 'SOLTEIRO', 0);
INSERT INTO cliente (nome, data_nascimento, sexo, telefone_residencial, telefone_celular, email, estado_civil, pontos) VALUES ('Júlia Tertulliano', '1979-09-30', 'FEMININO', null, 14996322105, 'julia.tertulliano@gmail.com', 'CASADO', 0);
INSERT INTO cliente (nome, data_nascimento, sexo, telefone_residencial, telefone_celular, email, estado_civil, pontos) VALUES ('Pérola da Glória', '1960-01-10', 'FEMININO', null, 14997766544, 'perola.gloria@outlook.com', 'VIUVO', 0);

INSERT INTO pontuacao (pontos, valor_inicial, valor_final) VALUES (5, 1.0, 50.0);
INSERT INTO pontuacao (pontos, valor_inicial, valor_final) VALUES (10, 50.00, 100.0);
INSERT INTO pontuacao (pontos, valor_inicial, valor_final) VALUES (15, 100.01, 150.0);
INSERT INTO pontuacao (pontos, valor_inicial, valor_final) VALUES (20, 150.01, 200.0);
