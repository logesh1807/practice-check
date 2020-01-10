-- Include table data insertion, updation, deletion and select scripts

-- -------------------------------------------------------------------
-- Adding Menu Items in  MenuItem Table
-- -------------------------------------------------------------------

insert into menu_item
values
(1, 'Sandwich', 99.0, 'Yes', '2017-03-15','Main Course', 'Yes'),
(2, 'Burger', 129.0, 'Yes', '2017-12-23','Main Course', 'No'),
(3, 'Pizza', 149.0, 'Yes','2018-08-21', 'Main Course', 'No'),
(4, 'French Fries', 57.0, 'No', '2017-07-02','Main Course', 'Yes'),
(5, 'Chocolate Brownie', 32.0, 'Yes', '2022-11-02','Main Course', 'Yes');

-- -------------------------------------------------------------------
-- Insert Values in user
-- -------------------------------------------------------------------

INSERT INTO user(us_name) VALUES('Jhon'),('Jack'); 

-- -------------------------------------------------------------------
-- Display all Data from user
-- -------------------------------------------------------------------

select*from user;

-- -------------------------------------------------------------------
-- customer menu item list
-- -------------------------------------------------------------------

select me_name, me_free_delivery, me_price, me_category from menu_item
where me_active ='yes' and me_date_of_launch <= (select(curdate()));


-- -------------------------------------------------------------------
-- Insert Values in cart
-- -------------------------------------------------------------------

insert into cart(ct_us_id,ct_pr_id) values (1,1);
insert into cart(ct_us_id,ct_pr_id) values (1,3);
insert into cart(ct_us_id,ct_pr_id) values (1,3);
insert into cart(ct_us_id,ct_pr_id) values (1,3);


-- -------------------------------------------------------------------
-- View cart items
-- -------------------------------------------------------------------

select me_name,me_free_delivery, me_price  from menu_item
inner join cart on ct_pr_id=me_id
where ct_us_id=1;

-- -------------------------------------------------------------------
-- View cart total
-- -------------------------------------------------------------------

select sum(me_price) as Total from menu_item
inner join cart on ct_pr_id=me_id
where ct_us_id=1;


-- ------------------------------------------------------------------
-- Remove Item From cart
-- ------------------------------------------------------------------

delete from cart where ct_us_id=1 and ct_id=3;


select sum(me_price) as Total from menu_item
inner join cart on ct_pr_id=me_id
where ct_us_id=1;

delete from cart;

select * from cart;
