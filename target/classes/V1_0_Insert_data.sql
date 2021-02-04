insert into account (first_name, last_name, login, password, email, type)
values ('user', 'user', 'user', '1234', 'user@user.com', 'user'),
       ('admin', 'admin', 'admin','1234','admin@admin', 'admin'),
       ('client', 'client', 'client','1234','client@client', 'client'),
       ('taxi', 'taxi', 'taxi','1234','taxi@taxi', 'taxi');

insert into address (name_street, number_street)
values ('Baghdad', 1),
        ('tunis',2);

insert into "order" (client_id, taxi_id, from_id, to_id, status, order_date)
values

(1, 2, 1, 2, 'DONE', '04-15-1998'),
(3 ,4 , 2 , 1, 'DONE', '10-27-2010');

insert into transaction(price, order_id, status,pay_date)
values
    (10.78, 1, 'SUCCESSFULLY','06-10-1988'),
    (99.78, 2, 'SUCCESSFULLY','07-10-1988');