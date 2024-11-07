CREATE TABLE especialidad(
id_especialidad int auto_increment primary key,
nombre varchar(40) not null,
descripcion varchar(150) not null
);

create table medico(
id_medico int auto_increment primary key,
nombre varchar(40) not null,
apellidos varchar(40) not null,
id_especialidad int,
constraint fk_id_especialidad foreign key(id_especialidad)
references especialidad(id_especialidad) on delete cascade
);

create table paciente(
id_paciente int auto_increment primary key,
nombre varchar(40) not null,
apellidos varchar(40) not null,
fecha_nacimiento date,
documento_identidad varchar(40) not null
);

create table cita(
id_cita int auto_increment primary key,
fecha_cita date not null,
hora_cita time not null,
motivo varchar(150) not null,
id_paciente int,
id_medico int,
constraint fk_id_medico foreign key(id_medico)
references medico(id_medico),
constraint fk_id_paciente foreign key(id_paciente)
references paciente(id_paciente)
);

SELECT * FROM cita 
INNER JOIN medico on cita.id_medico = medico.id_medico
inner JOIN paciente on cita.id_paciente = paciente.id_paciente
;

SELECT * FROM medico
inner join especialidad on medico.id_especialidad = especialidad.id_especialidad
WHERE id_medico = 0
;

create table avion(
id_avion int auto_increment primary key,
modelo varchar(40) not null,
capacidad int not null
);

create table vuelo(
id_vuelo int auto_increment primary key,
destino varchar(40) not null,
fecha_salida date not null,
hora_salida time not null,
id_avion int,
constraint fk_id_avion foreign key(id_avion)
references avion(id_avion) on delete cascade
);

create table pasajero(
id_pasajero int auto_increment primary key,
nombre varchar(40) not null,
apellido varchar(40) not null,
documento_identidad varchar(40) not null
);

create table reservacion(
id_reservacion int auto_increment primary key,
fecha_reservacion date not null,
asiento varchar(40) not null,
id_pasajero int,
id_vuelo int,
constraint fk_id_pasajero foreign key(id_pasajero)
references pasajero(id_pasajero) on delete cascade,
constraint fk_id_vuelo foreign key(id_vuelo)
references vuelo(id_vuelo) on delete cascade
);

ALTER TABLE medico ADD CONSTRAINT fk_id_especialidad foreign key(id_especialidad)
references especialidad(id_especialidad) on delete cascade;

drop table avion;
drop table vuelo;
drop table reservacion;
drop table pasajero;

alter table avion
add columnas int not null,
add filas int not null;

alter table reservacion
add column fila int not null;

alter table reservacion
change column asiento columna int not null;
