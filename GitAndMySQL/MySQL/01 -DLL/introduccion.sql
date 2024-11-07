-- Entrar al mysql local por consola
-- mysql -u root -p

--listar las bases de datos creadas en mysql
SHOW DATABASES;

--crear una base de datos

CREATE DATABASE nombre_base_datos;

--Comando para usar una base de datos

USE nombre_base_datos;

-- Crear una tabla 

CREATE TABLE nombre_tabla (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)

--ejemplo 
CREATE TABLE coders(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nombre varchar(40),
    email varchar(40) unique not null);

-- comando para ver la lista de tablas

SHOW TABLES;

--Contenido de una tabla 

DESC nombre_tabla;

--Comando para agregar registros

INSERT INTO nombre_tabla (atritubo1,atributo2) VALUES (valor1,valor2);
-- los valores tipo varchar (string) deben ir entre comillas ""

--comando para ver la informacion de la tabla

SELECT * FROM nombre_tabla;

--agregar nuevo atributo despues de que la tabla ya este creada

ALTER TABLE nombre_tabla ADD COLUMN nombre_nuevo_atributo tipo_ dato;
--ejemplo
ALTER TABLE coders ADD COLUMN direccion varchar(40) unique not null;

--Comando para modificar el tipo de dato o restricciones de un atributo ya creado

ALTER TABLE nombre_tabla MODIFY COLUMN nombre_atributo tipo reglas;

--Comando para modificar el nombre de un atributo

ALERT TABLE nombre_tabla
CHANGE COLUMN nombre_atributo_actual nuevo_nombre_atributo tipo_dato restricciones --opcional;