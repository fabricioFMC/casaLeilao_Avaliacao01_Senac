/*	ATIVIDADE: 01
	# Projetista: Fabricio Ramos Malvar Cabral CPF 025.885.415-42
		Versão: 1.0 
		Data: 18/11/2025

    # Objetivo: 
		1. Criar um banco de dados para a empresa: Casa de Leilões.
		2. Comunicar a tabela SQL com o software.
		3. Criar versionamento usando o metodo GITBash e GITHub.
*/
CREATE DATABASE casaLeilao;
USE casaLeilao;

CREATE TABLE produtos (
	id 		bigint(20) UNSIGNED NOT NULL auto_increment,
	nome 	text DEFAULT NULL,
	valor 	int(11) DEFAULT NULL,
	status	 text DEFAULT NULL,
    primary key (id)
); 

INSERT INTO produtos 
	(id, 	nome, 			valor, 	status) VALUES
	(1, 	null, 			null, 	null), 
	(2, 	'PS4', 			1500, 	'Vendido'),
	(3, 	'Xbox 360', 	800, 	'Vendido'),
	(4, 	'Iphone 12', 	4800, 	'Vendido'),
	(5, 	'PS2', 			400, 	'A Venda');

SELECT * FROM produtos;
