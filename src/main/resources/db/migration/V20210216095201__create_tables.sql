

create table products(
    id int not null primary key,
    name text not null,
    price float not null,
    unit text not null,
    available bool not null default false,
    on_sale bool not null default false,
    discount float null,
    comments text null,
    owner text not null,
    remaining_quantity int not null default 0
);
