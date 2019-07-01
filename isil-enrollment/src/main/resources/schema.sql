create table Supplier(
    ruc int primary key not null,
    name varchar(20) not null,
    contactEmail varchar(30) not null,
    contactMobilePhone varchar(20) not null
);
create table Product(
    sku int primary key,
    name varchar(20) not null,
    stock smallint not null,
    price double not null
);