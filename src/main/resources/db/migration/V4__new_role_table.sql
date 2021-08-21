create table roles (
    id bigint not null auto_increment primary key,
    name varchar (30) not null,
    descripton varchar (100)
);

alter table myusers add column id_role bigint;
alter table myusers add foreign key (id_role) references roles (id);
