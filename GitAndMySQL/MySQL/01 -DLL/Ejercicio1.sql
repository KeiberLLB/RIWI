CREATE TABLE unidades_residenciales(
	nit_conjunto VARCHAR(11) PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL CHECK(nombre NOT IN("Santana","Montes","Altos")),
    estrato INT NOT NULL);
    
CREATE TABLE vigilantes(
	ced_vigilante varchar(10) primary key,
    nombre varchar(30) not null,
    fecha_nac date,
    genero varchar(4) check(genero in ("M","F","Otro")) # in se usa para condicionar que esos son solo los valores permitidos
    );

CREATE TABLE edificios(
	id_edificio int primary key auto_increment,
    nro_de_pisos int check(nro_de_pisos between 5 and 8), #check se usa para condicionar between para generar un rango
    ubicacion varchar(40)
    #id_conjunto varchar(11),
    #constraint fk_id_conjunto foreign key(id_conjunto)
    #references conjuntos(nit_conjunto)
    );

alter table edificios
add column id_conjunto varchar(11);

#agregando restricciones y fk
alter table edificios
add constraint fk_id_conjunto foreign key(id_conjunto)
references unidades_residenciales(nit_conjunto);
 
DROP TABLE unidades_residenciales;#eliminar table existentes 

SELECT version();

#ALTER TABLE unidades_residenciales MODIFY COLUMN  nombre VARCHAR(30) NOT NULL CHECK(nombre NOT IN("Santana","Montes","Altos"));
#la sintaxis esta correcta pero el error que se presenta solo aparece aca, en otros pcs funciono correctamente

create table novedades(
	id int auto_increment primary key,
    id_edificio int,
    id_vigilante varchar(10),
    constraint fk_id_edificio foreign key(id_edificio)
    references edificios(id_edificio),
    constraint fk_id_vigilante foreign key(id_vigilante)
    references vigilantes(ced_vigilante)
);

create table apartamentos(
	num_apartamento int primary key auto_increment,
    piso int not null,
    valor double check(valor between 10000 and 100000),
    id_edificio int,
    constraint fk_id_edificio2 foreign key(id_edificio)
    references edificios(id_edificio)
);

alter table edificios
add column sector varchar(30) check(sector in("Piscina","Alameda","Cancha"));

#insertando en conjunto
insert into unidades_residenciales value ("125","MiraFlorez",2);

select * from edificios;

insert into edificios(nro_de_pisos,sector) value(1,"Belen");

insert into vigilantes values("1234","Martha","1984-05-05","f");
