create table admin(
	id_user serial,
	sen_user varchar(40),
	nome_user varchar(60),
	constraint pk_admin primary key (id_user)
);
insert into admin values ('admin2101','Adriana');
insert into admin values ('admin2102','Bruno');
select * from admin;
drop table admin; 


create table produto(
 	id_produto serial,
	cod_produto int,
	desc_produto varchar(40),
	sen_produto varchar(40),
	id_user int,
	constraint pk_produto primary key (id_produto),
	constraint fk_admin foreign key (id_user) references admin (id_user)
);
insert into produto values ( 432798, 'produto1', '1', 1);
insert into produto values ( 164987, 'produto2', '2', 2);
select * from produto;
drop table produto; 


create table assistencia(
	id_assist serial,
	status varchar(40),
	dathor_ent date,
	obs_assist varchar(180),
	id_produto int,
	id_cliente int, 
	constraint pk_assistencia primary key (id_assist),
	constraint fk_produto foreign key (id_produto) references produto (id_produto),
	constraint fk_cliente foreign key (id_cliente) references cliente (id_cliente)
);
insert into assistencia values ( 'efetuado o envio', '01/07/2021','123', 1, 1);
insert into assistencia values ( 'em conserto', '04/08/2021','321', 2, 2 );
select * from assistencia;
drop table assistencia; 


 create table cliente(
    id_cliente serial,
	tel_cliente varchar(14),
	email_cliente varchar(40),
	rg_cliente varchar(20),
	constraint pk_cliente primary key (id_cliente)
);
insert into cliente values ( 17997124876, 'cliente1@hotmail.com', '124563987');
insert into cliente values ( 17991743258, 'cliente2@gmail.com', '459871230');
select * from cliente;
drop table cliente; 