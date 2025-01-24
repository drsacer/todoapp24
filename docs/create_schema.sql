 create table app_user (id integer not null, email varchar(255), first_name varchar(255), last_name varchar(255), oib varchar(255), password varchar(255), type integer not null, primary key (id))
 create table todo (id integer not null, date date, note varchar(255), title varchar(255), user_id integer, primary key (id))

