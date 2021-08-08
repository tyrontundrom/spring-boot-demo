create table MyUsers
(
    id         bigint primary key AUTO_INCREMENT not null,
    first_name varchar(30) not null,
    last_name  varchar(50) not null,
    login      varchar(30) not null,
    password   varchar(100),
    is_activ   tinyint(1) not null default 1
);