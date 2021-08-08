create table myadresses
(
    id          bigint primary key AUTO_INCREMENT not null,
    city        varchar(40) not null,
    street      varchar(40) not null,
    postal_code varchar(7)  not null
);

create table usersadreses
(
    user_id   bigint not null,
    adress_id bigint not null,
    foreign key (user_id) references myusers (id),
    foreign key (adress_id) references myadresses (id)
);