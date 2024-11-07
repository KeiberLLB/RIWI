create table tienda(
id_tienda int auto_increment primary key,
nombre varchar(255) not null,
ubicacion varchar(255) not null
);

create table producto(
id_producto int auto_increment primary key,
nombre_producto varchar(255) not null,
precio double not null,
id_tienda int,
constraint fk_id_tienda foreign key(id_tienda)
references tienda(id_tienda) on delete cascade
);

create table cliente(
id_cliente int auto_increment primary key,
nombre_cliente varchar(255) not null,
apellido_cliente varchar(255) not null,
email varchar(255) not null
);

create table compra(
id_compra int auto_increment primary key,
fecha_compra Date not null,
cantidad int not null,
id_cliente int,
id_producto int,
constraint fk_id_cliente foreign key(id_cliente)
references cliente(id_cliente) on delete cascade,
constraint fk_id_producto foreign key(id_producto)
references producto(id_producto) on delete cascade
);

alter table producto
add column stock int not null;

alter table cliente
add column cedula_cliente varchar(40) not null;

alter table compra
add column id_tienda int;

alter table compra
add constraint fk_id_tiendaC foreign key (id_tienda)
references tienda(id_tienda) on delete cascade;

insert into tienda(nombre,ubicacion) value("Piña Madura","Calle 38 #90-8 esquina");
insert into tienda(nombre,ubicacion) value("CleanHome","Kr 98 #36-45");
insert into tienda(nombre,ubicacion) value("DistLicores","Kr 98 #36-50");




