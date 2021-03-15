DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id bigserial PRIMARY KEY, title VARCHAR(255), cost NUMERIC(6,2));
INSERT INTO products (title, cost) VALUES
('Product1', 10.11),
('Product2', 20.22),
('Product3', 30.33),
('Product4', 40.44),
('Product5', 50.55),
('Product6', 60.66);

DROP TABLE IF EXISTS customers CASCADE;
CREATE TABLE customers (id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO customers (name) VALUES
('Dmitry'),
('Alex');

DROP TABLE IF EXISTS products_customers CASCADE;
CREATE TABLE products_customers (product_id bigint, customer_id bigint, cost NUMERIC(6,2), FOREIGN KEY (product_id) REFERENCES products (id), FOREIGN KEY (customer_id) REFERENCES customers (id));
INSERT INTO products_customers (product_id, customer_id, cost) VALUES
(1, 1, 11.11),
(2, 1, 21.21),
(3, 1, 31.31),
(4, 1, 41.41),
(5, 1, 51.51),
(6, 1, 61.61),
(1, 2, 12.12),
(2, 2, 22.22);