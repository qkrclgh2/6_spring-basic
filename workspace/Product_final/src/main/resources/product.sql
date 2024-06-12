CREATE TABLE product (
    id NUMBER PRIMARY KEY,
    name VARCHAR2(100) NOT NULL,
    price NUMBER NOT NULL,
    category VARCHAR2(50),
    description VARCHAR2(255)
);

select * from product;

drop sequence seq_product;

create sequence seq_product
increment by 1
start with 1
nocache;

insert INTO product (id, name, price, category, description) values (seq_product.nextval, 'Apple iPhone', 999.99, 'Electronics', 'Latest model of iPhone');
insert INTO product (id, name, price, category, description) values (seq_product.nextval, 'Samsung Galaxy', 899.99, 'Electronics', 'Newest Samsung Galaxy phone');
insert INTO product (id, name, price, category, description) values (seq_product.nextval, 'Sony Headphones', 199.99, 'Electronics', 'Noise cancelling headphones');
insert INTO product (id, name, price, category, description) values (seq_product.nextval, 'Nike Sneakers', 129.99, 'Apparel', 'Comfortable running shoes');
insert INTO product (id, name, price, category, description) values (seq_product.nextval, 'Adidas T-shirt', 29.99, 'Apparel', 'Breathable cotton t-shirt');
insert INTO product (id, name, price, category, description) values (seq_product.nextval, 'Organic Apple', 1.99, 'Groceries', 'Fresh organic apple');
insert INTO product (id, name, price, category, description) values (seq_product.nextval, 'Banana', 0.99, 'Groceries', 'Fresh bananas');
insert INTO product (id, name, price, category, description) values (seq_product.nextval, 'HP Laptop', 599.99, 'Electronics', 'Affordable laptop for everyday use');
insert INTO product (id, name, price, category, description) values (seq_product.nextval, 'MacBook Pro', 1299.99, 'Electronics', 'High performance laptop');
insert INTO product (id, name, price, category, description) values (seq_product.nextval, 'Sony TV', 499.99, 'Electronics', '4K UHD television');
insert INTO product (id, name, price, category, description) values (seq_product.nextval, 'Gucci Bag', 1999.99, 'Apparel', 'Luxury handbag from Gucci');
insert INTO product (id, name, price, category, description) values (seq_product.nextval, 'Dell Monitor', 299.99, 'Electronics', '27 inch monitor with high resolution');
insert INTO product (id, name, price, category, description) values (seq_product.nextval, 'Yoga Mat', 49.99, 'Fitness', 'Eco-friendly yoga mat');
insert INTO product (id, name, price, category, description) values (seq_product.nextval, 'Protein Powder', 39.99, 'Fitness', 'Whey protein powder for muscle growth');
insert INTO product (id, name, price, category, description) values (seq_product.nextval, 'Samsung Refrigerator', 799.99, 'Home Appliances', 'Energy efficient refrigerator');

