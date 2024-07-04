--CREATE TABLE prices (brand_id INT,start_date VARCHAR(255),end_date VARCHAR(255),price_list INT,product_id INT,priority INT,price DECIMAL(10,2),curr VARCHAR(255));
INSERT INTO prices (brand_id, start_date, end_date, price_list, product_id, priority, price, curr) VALUES (1, TO_TIMESTAMP('2020-06-14-00.00.00','YYYY-MM-DD-HH24.MI.SS'), TO_TIMESTAMP('2020-12-31-23.59.59','YYYY-MM-DD-HH24.MI.SS'),1,35455, 0, 35.50, 'EUR');
INSERT INTO prices (brand_id, start_date, end_date, price_list, product_id, priority, price, curr) VALUES (1, TO_TIMESTAMP('2020-06-14-15.00.00','YYYY-MM-DD-HH24.MI.SS'), TO_TIMESTAMP('2020-06-14-18.30.00','YYYY-MM-DD-HH24.MI.SS'),2,35455, 1, 25.45, 'EUR');
INSERT INTO prices (brand_id, start_date, end_date, price_list, product_id, priority, price, curr) VALUES (1, TO_TIMESTAMP('2020-06-15-00.00.00','YYYY-MM-DD-HH24.MI.SS'), TO_TIMESTAMP('2020-06-15-11.00.00','YYYY-MM-DD-HH24.MI.SS'),3,35455, 1, 30.50, 'EUR');
INSERT INTO prices (brand_id, start_date, end_date, price_list, product_id, priority, price, curr) VALUES (1, TO_TIMESTAMP('2020-06-15-16.00.00','YYYY-MM-DD-HH24.MI.SS'), TO_TIMESTAMP('2020-12-31-23.59.59','YYYY-MM-DD-HH24.MI.SS'),4,35455, 1, 38.95, 'EUR');