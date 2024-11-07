#crear base de datos 
CREATE DATABASE ejercicio_1;

#usar base de datos
use ejercicio_1;

create table centros_educativos(
	id int primary key auto_increment,
    nombre varchar(40) not null,
    direccion varchar(40) unique not null);
    
create table estudiantes(
	id int primary key auto_increment,
    nombre varchar(40) not null,
    apellido varchar(40) not null,
    fecha_nacimiento date,
    id_centro_educativo int,
    constraint fk_centro_educativo foreign key(id_centro_educativo) references centros_educativos(id)
    );

#Creando tabla con atributos
CREATE TABLE coders(
	id INT PRIMARY KEY auto_increment,
    nombre varchar(40),
    email varchar(40) unique not null);

#mostrar la tabla
SHOW TABLES;

#descripcion tabla
DESC coders;

DROP TABLE  edificios;#eliminar table existentes 

#insertar datos en la tabla
INSERT INTO coders (nombre,email) VALUES ("Juan","juan@gmail.com"),("WW","ww.gmail.com");
#en values, si se colocan dos parentesis separados por comas agrega dos campos, pueden ser mas

#mostrar toda la informacion de la tabla
SELECT * FROM coders;

ALTER TABLE coders ADD COLUMN fecha_nacimiento DATE;
ALTER TABLE coders MODIFY COLUMN fecha_nacimiento DATE NOT NULL;

DELETE FROM coders WHERE coders.id=6;

ALTER TABLE coders change column fecha_nacimiento fecha_ingreso DATE;




