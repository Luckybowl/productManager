-- 初始化category表
INSERT INTO category (category_id, category_name, category_parent_id) VALUES (1, 'manhat', 0);
INSERT INTO category (category_id, category_name, category_parent_id) VALUES (2, 'anhat', 0);
INSERT INTO category (category_id, category_name, category_parent_id) VALUES (3, 'mahat', 0);
INSERT INTO category (category_id, category_name, category_parent_id) VALUES (4, 'dsmanhat', 0);

--  初始化product 表
INSERT INTO product (product_id, product_click_counts, product_desc, product_name, product_picture_path, product_price, product_rebate, product_rest, product_total, category_id) 
VALUES (1, 100, 'shenghuoyongpin', 'pingguo', '/user/path/picture', 50.5, 0.5, 500, 1000, 1);

INSERT INTO product (product_id, product_click_counts, product_desc, product_name, product_picture_path, product_price, product_rebate, product_rest, product_total, category_id) 
VALUES (2, 50, 'xuexiyongpin', 'qianbi', '/user/path/picture', 30.5, 0.6, 300, 1000, 2);

INSERT INTO product (product_id, product_click_counts, product_desc, product_name, product_picture_path, product_price, product_rebate, product_rest, product_total, category_id) 
VALUES (3, 40, 'xuexiyongpin', 'bijiben', '/user/path/picture', 30.5, 0.6, 300, 1000, 2);