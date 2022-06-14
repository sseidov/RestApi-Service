create table hibernate_sequence (
    next_val bigint
) engine=MyISAM;

insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );

CREATE TABLE customer (
    id BIGINT NOT NULL AUTO_INCREMENT,
    username varchar(64) NOT NULL UNIQUE,
    password varchar(64) NOT NULL,
    phoneNumber varchar(100),
    email varchar(64) NOT NULL,
    address varchar(200),
    details varchar(250),
    PRIMARY KEY (id)
)engine=MyISAM;

CREATE TABLE dishes (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name varchar(64) NOT NULL,
    ingredients varchar(200) NOT NULL,
    weight numeric(4),
    PRIMARY KEY (id)
)engine=MyISAM;

CREATE TABLE dishes_price (
    id BIGINT NOT NULL AUTO_INCREMENT,
    dishes_id BIGINT NOT NULL,
    date_from DATETIME  NOT NULL,
    price numeric(6,2) NOT NULL,
    FOREIGN KEY (dishes_id)  REFERENCES dishes (id),
    PRIMARY KEY (id)
)engine=MyISAM;

CREATE TABLE orders (
    id BIGINT NOT NULL,
    customer_id BIGINT NOT NULL,
    deliveryDate DATETIME  NOT NULL,
    totalPrice numeric(8,2) NOT NULL,
    paymentMethod varchar(50),
    comments varchar(200),
    FOREIGN KEY (customer_id)  REFERENCES customer (id),
    PRIMARY KEY (id)
)engine=MyISAM;

CREATE TABLE order_dishes (
    order_id BIGINT NOT NULL,
    dishes_id BIGINT NOT NULL,
    quantity BIGINT NOT NULL,
    comment varchar(150),
    FOREIGN KEY (order_id)  REFERENCES orders (id),
    FOREIGN KEY (dishes_id)  REFERENCES dishes (id)
)engine=MyISAM;

# ALTER table customers DROP COLUMN phoneNumber;


