
INSERT INTO dsi20203c.Deporte VALUES 
(20,'Basquet'),
(30,'Futbol');

INSERT INTO dsi20203c.Usuario VALUES
(1,NULL, NULL, 'Juan', 'Perez','1234','DNI',42561190),
(6,NULL,NULL, 'Mateo','Toniolo','utn','DNI',42561194);

INSERT INTO dsi20203c.Lugar VALUES
(1,'Cancha Norte',''),
(2,'Cancha Sur',''),
(40,'Cancha Centro','');

INSERT INTO dsi20203c.Relacion_Lugar_Usuario VALUES
(6,1),
(6,2),
(1,40);

INSERT INTO dsi20203c.Relacion_Lugar_Deporte VALUES
(20,1),
(30,1),
(20,2),
(20,40),
(30,40);



