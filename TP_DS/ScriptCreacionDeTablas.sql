CREATE SCHEMA dsi20203c;

CREATE TABLE dsi20203c.Competencia(
	id_competencia serial primary key,
	id_usuario integer references dsi20203c.Usuario(id_usuario),
	id_fixture integer references dsi20203c.Fixture(id_fixture),
	nombre varchar(60),
	cant_sets integer,
	reglamento varchar(300),
	estado ENUM('CREADA','PLANIFICADA','EN DISPUTA','FINALIZADA'),
	modalidad ENUM('LIGA','ELIMINACION DOBLE', 'ELIMINACION DIRECTA'),
	puntuacion ENUM('SETS','PUNTUACION','PUNTUACION FINAL'),
	tantosXAusencia double,
	id_deporte integer references dsi20203c.Deporte(id_deporte)
);

CREATE TABLE dsi20203c.Competencia_Eliminacion_Directa (
	id_competencia integer references dsi20203c.Competencia(id_competencia),
	primary key(id_competencia)
);

CREATE TABLE dsi20203c.Competencia_Eliminacion_Doble (
	id_competencia integer references dsi20203c.Competencia(id_competencia),
	primary key(id_competencia)
);

CREATE TABLE dsi20203c.Competencia_Liga (
	id_competencia integer references dsi20203c.Competencia(id_competencia),
	empate boolean,
	puntos_por_ganar double,
	puntos_por_empate double,
	puntos_por_presentarse double,
	primary key(id_competencia)
);


CREATE TABLE dsi20203c.Usuario(
	id_usuario serial primary key,
	id_localidad integer,
	correoElectronico varchar(100),
	nombre varchar(24),
	apellido varchar(24),
	contrasenia varchar(24),
	tipoDni ENUM('DNI','LI','LC'),
	dni double precision
);

CREATE TABLE dsi20203c.Localidad (
	id_localidad integer primary key,
	id_provincia integer references dsi20203c.Provincia(id_provincia),
	nombre varchar(40)
);

CREATE TABLE dsi20203c.Provincia (
	id_provincia integer primary key,
	id_pais integer references dsi20203c.Pais(id_pais),
	nombre varchar(40)
);

CREATE TABLE dsi20203c.Pais (
	id_pais integer primary key,
	nombre varchar(40)
);

CREATE TABLE dsi20203c.Fixture (
	id_fixture serial primary key
);

CREATE TABLE dsi20203c.Deporte (
	id_deporte serial primary key,
	nombre varchar(20)
);
CREATE TABLE dsi20203c.Lugar (
	codigo integer primary key,
	nombre varchar(70),
	descripcion varchar(300)
);

CREATE TABLE dsi20203c.Relacion_Lugar_Deporte(
	id_deporte integer references dsi20203c.Deporte(id_deporte),
	codigo integer references dsi20203c.Lugar(codigo),
	primary key(id_deporte,codigo)
);

CREATE TABLE dsi20203c.Relacion_Lugar_Usuario(
	id_usuario integer references dsi20203c.Usuario(id_usuario),
	codigo integer references dsi20203c.Lugar(codigo),
	primary key(id_usuario,codigo)
);