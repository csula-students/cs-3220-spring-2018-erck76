CREATE TABLE users(
id INTEGER AUTO_INCREMENT PRIMARY KEY,
username varchar(255) not null,
password varchar(255) not null
);

insert into users values
(null,'admin', 'cs3220password'),
(null, 'me', 'notapassword');

CREATE TABLE generators(
id INTEGER AUTO_INCREMENT PRIMARY KEY,
name varchar(255) not null,
description text null,
rate int(11) null,
base_cost int(11) null,
unlock_at int(11) null,
created_by int(11),
foreign key(created_by)references generators(id) 
);

insert into generators values
(null, 'Grandma', 'Grandma likes to make cookies', '5', '10', '10', '1'),
(null, 'Factory', 'Factory to produce cookies', '10', '50', '50', '1'),
(null, 'Mine', 'Mining cookies', '20', '200', '200', '2');

CREATE TABLE events(
id INTEGER AUTO_INCREMENT PRIMARY KEY,
name varchar(255) not null,
description text null,
trigger_at int(11),
created_by int(11),
foreign key(created_by) references events(id)
);

insert into events values
(null, 'Grandma shows up', 'You always know grandma likes to make cookies', '10', '1'),
(null, 'You can construct factory now!', 'Factory to produce cookies', '50', '1'),
(null, 'We\'ve found cookies in deep mountain ... in the mine?', 'Mining cookies', '200', '2'),
(null, 'sample event', 'This is a sample event. Please delete me', '99999', '2');
 
 
 CREATE TABLE quantities(
generator_id int(11) not null,
token varchar(255) null,
quantity int(11) default 0,
unique key(generator_id, quantity)
);

insert into quantities values
('1', 'c7a69d44e0b9b415b2d9956cb26b944a', '2'),
('2', 'c7a69d44e0b9b415b2d9956cb26b944a', '1'),
('1', '80516ce4663c3bd0c8385309a2fe226e', '20'),
('2', '80516ce4663c3bd0c8385309a2fe226e', '30');