create table account
(
    id         bigserial primary key,
    first_name varchar(50),
    last_name  varchar(50),
    login      varchar(255),
    password   varchar(255),
    email      varchar(50),
    type       varchar(50)
);

create table address
(
    id            bigserial primary key,
    name_street   varchar(50),
    number_street varchar(50)
);

create table "order"
(
    id         bigserial primary key,
    order_date varchar(55),
    client_id  int,
    taxi_id    int,
    from_id    int,
    to_id      int,
    status     varchar(20),
    foreign key (from_id) references address (id) ON DELETE CASCADE,
    foreign key (to_id) references address (id) ON DELETE CASCADE,
    foreign key (client_id) references account (id) ON DELETE CASCADE,
    foreign key (taxi_id) references account (id) ON DELETE CASCADE
);

create table transaction
(
    id       bigserial primary key,
    pay_date varchar(55),
    price    decimal(5, 2),
    order_id int,
    status   varchar(20),
    foreign key (order_id) references "order" (id) ON DELETE CASCADE
);