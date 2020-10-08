CREATE SCHEMA dsi20203c;

CREATE TABLE dsi20203c.Pais (
	id_pais integer primary key,
	nombre varchar(40)
);

CREATE TABLE dsi20203c.Provincia (
	id_provincia integer primary key,
	id_pais integer ,
	nombre varchar(40),
	FOREIGN KEY (id_pais) REFERENCES Pais(id_pais) on delete cascade on update cascade
);

CREATE TABLE dsi20203c.Localidad (
	id_localidad integer primary key,
	id_provincia integer ,
	nombre varchar(40),
	FOREIGN KEY (id_provincia) REFERENCES Provincia(id_provincia) on delete cascade on update cascade
);

CREATE TABLE dsi20203c.Usuario(
	id_usuario integer primary key,
	id_localidad integer,
	correoElectronico varchar(100),
	nombre varchar(24),
	apellido varchar(24),
	contrasenia varchar(24),
	tipoDni ENUM('DNI','LI','LC'),
	dni double precision,
	FOREIGN KEY (id_localidad) REFERENCES Localidad(id_localidad) on delete cascade on update cascade
);

CREATE TABLE dsi20203c.Fixture (
	id_fixture integer primary key
);

CREATE TABLE dsi20203c.Deporte (
	id_deporte integer primary key,
	nombre varchar(20)
);

CREATE TABLE dsi20203c.Competencia(
	id_competencia integer primary key,
	id_usuario integer ,
	id_fixture integer ,
	nombre varchar(60),
	cant_sets integer,
	reglamento varchar(300),
	estado ENUM('CREADA','PLANIFICADA','EN DISPUTA','FINALIZADA'),
	modalidad ENUM('LIGA','ELIMINACION DOBLE', 'ELIMINACION DIRECTA'),
	puntuacion ENUM('SETS','PUNTUACION','PUNTUACION FINAL'),
	tantosXAusencia double,
	id_deporte integer ,
	FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario) on delete cascade on update cascade,
	FOREIGN KEY (id_fixture) REFERENCES Fixture(id_fixture) on delete cascade on update cascade,
	FOREIGN KEY (id_deporte) REFERENCES Deporte(id_deporte) on delete cascade on update cascade
);


CREATE TABLE dsi20203c.Competencia_Eliminacion_Directa (
	id_competencia integer ,
	primary key(id_competencia),
	FOREIGN KEY (id_competencia) REFERENCES Competencia(id_competencia) on delete cascade on update cascade
);

CREATE TABLE dsi20203c.Competencia_Eliminacion_Doble (
	id_competencia integer,
	primary key(id_competencia),
	FOREIGN KEY (id_competencia) REFERENCES Competencia(id_competencia) on delete cascade on update cascade
);

CREATE TABLE dsi20203c.Competencia_Liga (
	id_competencia integer ,
	empate boolean,
	puntos_por_ganar double,
	puntos_por_empate double,
	puntos_por_presentarse double,
	primary key(id_competencia),
	FOREIGN KEY (id_competencia) REFERENCES Competencia(id_competencia) on delete cascade on update cascade
);


CREATE TABLE dsi20203c.Lugar (
	codigo integer primary key,
	nombre varchar(70),
	descripcion varchar(300)
);

CREATE TABLE dsi20203c.Relacion_Lugar_Deporte(
	id_deporte integer,
	codigo integer,
	FOREIGN KEY (id_deporte) REFERENCES Deporte(id_deporte) on delete cascade on update cascade,
	FOREIGN KEY (codigo) REFERENCES Lugar(codigo) on delete cascade on update cascade,
	primary key(id_deporte,codigo)
);

CREATE TABLE dsi20203c.Relacion_Lugar_Usuario(
	id_usuario integer ,
	codigo integer ,
	primary key(id_usuario,codigo),
	FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario) on delete cascade on update cascade,
	FOREIGN KEY (codigo) REFERENCES Lugar(codigo) on delete cascade on update cascade
);


