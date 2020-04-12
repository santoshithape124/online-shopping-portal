CREATE TABLE category (

   id IDENTITY,
   name VARCHAR(50),
   description VARCHAR(255),
   image_url VARCHAR(50),
   is_active BOOLEAN,
   
   CONSTRAINT pk_category_id PRIMARY KEY (id)
);

INSERT INTO category(name,description,image_url,is_active) VALUES('Laptop','This is description for Laptop category','CAT_1.png',true);
INSERT INTO category(name,description,image_url,is_active) VALUES('Television','This is description for Television category','CAT_2.png',true);
INSERT INTO category(name,description,image_url,is_active) VALUES('Mobile','This is description for Mobile category','CAT_3.png',true);

CREATE TABLE user_detail (
     id IDENTITY,
     first_name VARCHAR(50),
     last_name VARCHAR(50),
     role VARCHAR(50),
     enabled BOOLEAN,
     password VARCHAR(50),
     email VARCHAR(80),
     contact_number VARCHAR(15),
     CONSTRAINT pk_user_id PRIMARY KEY(id)
);

INSERT INTO user_detail
(first_name, last_name, role, enabled, password, email, contact_number)
VALUES('Santosh','Ithape', 'ADMIN',true,'admin','santoshithape@gmail.com','8983008124');

INSERT INTO user_detail
(first_name, last_name, role, enabled, password, email, contact_number)
VALUES('Radha','Ithape', 'SUPPLIER',true,'12345','radhaithape@gmail.com','7276715100');

INSERT INTO user_detail
(first_name, last_name, role, enabled, password, email, contact_number)
VALUES('Geeta','Ithape', 'SUPPLIER',true,'12345','geetaithape@gmail.com','8983008122');


CREATE TABLE product (
    id IDENTITY,
    code VARCHAR(20),
    name VARCHAR(50),
    brand VARCHAR(50),
    description VARCHAR(250),
    unit_price DECIMAL(10,2),
    quantity INT,
    is_active BOOLEAN,
    category_id INT,
    supplier_id INT,
    purchases INT DEFAULT 0,
    views INT DEFAULT 0,
    CONSTRAINT pk_product_id PRIMARY KEY (id),
    CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category (id),
    CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail (id)
);

INSERT INTO product (code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id)
VALUES('PRDABC123DEFX','I phone 6S','apple','This is one of the best mobile handset in the Market',70000 ,5,true,3,2);

INSERT INTO product (code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id)
VALUES('PRDDEF123DEFX','I phone 7S','samsung','A smart phone by Samsung',23000,2,true ,3,3);

INSERT INTO product (code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id)
VALUES('PRDPQR123WGTX','Google Pixel','google','This is one of the best Android mobile handset in the Market',59000,4,true,3,2);

INSERT INTO product (code,name,brand, description,unit_price,quantity,is_active,category_id,supplier_id)
VALUES('PRDMNO123PQRX','MacBook Pro','apple','This is one of the best Laptopin the Market',75000,3,true,1,2);

INSERT INTO product (code,name,brand,description,unit_price,quantity,is_active,category_id,supplier_id)
VALUES('PRDABCXYZDEFX','Dell Latitude E6510','dell','This is one of the best Television in the Market',49000,2,true,1,3);



