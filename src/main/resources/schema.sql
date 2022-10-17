create table if not exists Ingredient (
id varchar(4) primary key,
name varchar(25) not null,
type varchar(10) not null
);

create table if not exists Taco (
id identity,
name varchar(50) not null,
created_At timestamp not null
);

create table if not exists Users (
id identity,
username varchar(50),
password varchar(512),
fullname varchar(50),
street varchar(50),
city varchar(50),
state varchar(2),
zip varchar(10),
phone_number varchar(16)
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
delivery_Name varchar(50) not null,
delivery_Street varchar(50) not null,
delivery_City varchar(50) not null,
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
