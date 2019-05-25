CREATE DATABASE OdinPizzaria
GO
USE OdinPizzaria
GO
CREATE TABLE Cargo
	(
		Codigo INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
		Descricao VARCHAR(30) NOT NULL
	)

CREATE TABLE Usuario
	(
		Codigo INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
		Nome VARCHAR(100) NOT NULL,
		Login VARCHAR(30) NOT NULL UNIQUE,
		Senha VARCHAR(30) NOT NULL,
		Ativo BIT NOT NULL DEFAULT 0,
		CodigoCargo INT NOT NULL,
		CaminhoImagem VARCHAR(MAX)
		
		CONSTRAINT FK_Usuario_Cargo FOREIGN KEY (CodigoCargo) REFERENCES Cargo(Codigo)
	)

INSERT INTO Cargo VALUES ('Atendente'),('Gerente')
INSERT INTO Usuario VALUES ('Felipe Venancio de Sena','felipe.sena','admin',1,2,NULL),('Chirley Nunes Pereira Santos','chirley.santos','admin',1,2,NULL)