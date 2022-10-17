create table if not exists Ingredient (
id varchar(4) primary key,
name varchar(25) not null,
type varchar(10) not null
);

create table if not exists Taco (
id identity,
name varchar(16) not null,
created_At timestamp not null
);

create table if not exists Users (
id identity,
username varchar(32) not null,
password varchar(64) not null,
fullname varchar(32) not null,
street varchar(32) not null,
city varchar(32) not null,
state varchar(2) not null,
zip varchar(10) not null,
phone_number varchar(16) not null
);

create table if not exists Taco_Ingredient (
taco_id bigint not null,
ingredient_id varchar(4) not null
);

alter table Taco_Ingredient
    add foreign key (taco_id) references Taco(id);
alter table Taco_Ingredient
    add foreign key (ingredient_id) references Ingredient(id);

create table if not exists Taco_Order (
id identity,
delivery_Name varchar(32) not null,
delivery_Street varchar(32) not null,
delivery_City varchar(32) not null,
delivery_State varchar(2) not null,
delivery_Zip varchar(10) not null,
cc_Number varchar(16) not null,
cc_Expiration varchar(5) not null,
cc_CVV varchar(3) not null,
placed_At timestamp not null,
user_id bigint not null
);

create table if not exists Taco_Order_Tacos (
order_id bigint not null,
tacos_id bigint not null
);

alter table Taco_Order_Tacos
    add foreign key (order_id) references Taco_Order(id);
alter table Taco_Order_Tacos
    add foreign key (tacos_id) references Taco(id);
