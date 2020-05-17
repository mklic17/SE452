/*
DB Schema
Product(ID, name, description, price, isActive);
Category(ID, name);
ProductsInCategory(ID, name);
Customer(ID, firstName, lastName, email); -- Admin
Orders(ID, customerID, datePlaced);
OrderItems(Id, orderID, productID, productTotal);
*/

--- Product
INSERT INTO Product(name, description, summary, price, image) VALUES('Baseball Bat', 'This is a bat used in the game of baseball', 'Easton Baseball Bat', '50.00', 'https://images-na.ssl-images-amazon.com/images/I/71uXuqys2NL._AC_SX425_.jpg');
INSERT INTO Product(name, description, summary, price, image) VALUES('Soccer Ball', 'This is a ball used in the game of soccer', 'Size 5 soccer ball', '29.99', 'https://www.soccermaster.com/wp-content/uploads/sc3101_008_nike_pitch_training_ball_sm_01.jpg');
INSERT INTO Product(name, description, summary, price, image) VALUES('Basketball Shooting Sleeve', 'Sleeve that goes on your arm to aid in the Basketball shooting form', 'Womens basketball', '19.99', 'https://dks.scene7.com/is/image/GolfGalaxy/16WILUJTVLTNXXXXXBKB?qlt=70&wid=600&fmt=pjpeg');
INSERT INTO Product(name, description, summary, price, image) VALUES('Golf Clubs', 'These are golf Clubs used to play golf', '13 club set', '399.99', 'https://images-na.ssl-images-amazon.com/images/I/71uXuqys2NL._AC_SX425_.jpg');

--- Category
-- DECLARE @sportsID AS VARCHAR;

INSERT INTO Category(name) VALUES('Sports');
-- SET @sportsID = (SELECT ID FROM Category WHERE name = 'Sports');

INSERT INTO Category(name, parent) VALUES('Baseball', (SELECT ID FROM Category WHERE name = 'Sports'));
INSERT INTO Category(name, parent) VALUES('Soccer', (SELECT ID FROM Category WHERE name = 'Sports'));
INSERT INTO Category(name, parent) VALUES('Basketball', (SELECT ID FROM Category WHERE name = 'Sports'));
INSERT INTO Category(name, parent) VALUES('Golf', (SELECT ID FROM Category WHERE name = 'Sports'));


--- ProductsInCategory
INSERT INTO Products_In_Category(product_ID, category_ID) VALUES((SELECT ID FROM Product WHERE Name = 'Baseball Bat'), (SELECT ID FROM Category WHERE Name = 'Baseball'));
INSERT INTO Products_In_Category(product_ID, category_ID) VALUES((SELECT ID FROM Product WHERE Name = 'Soccer Ball'), (SELECT ID FROM Category WHERE Name = 'Soccer'));
INSERT INTO Products_In_Category(product_ID, category_ID) VALUES((SELECT ID FROM Product WHERE Name = 'Basketball Shooting Sleeve'), (SELECT ID FROM Category WHERE Name = 'Basketball'));
INSERT INTO Products_In_Category(product_ID, category_ID) VALUES((SELECT ID FROM Product WHERE Name = 'Golf Clubs'), (SELECT ID FROM Category WHERE Name = 'Golf'));


-- Customer
INSERT INTO Customer (ID, firstName, lastName, email) VALUES ('aaaaa', 'Michael', 'Scott',  'mscott@dundermifflin.com');
INSERT INTO Customer (ID, firstName, lastName, email) VALUES ('aaaab', 'Dwight', 'Schrute',  'dschture@dundermifflin.com');
INSERT INTO Customer (ID, firstName, lastName, email) VALUES ('aaaac', 'Jim', 'Halpert',  'jhalpert@dundermifflin.com');


-- Cart
INSERT INTO Cart (customer_ID, total_price) VALUES ('aaaaa', '0');



INSERT INTO Orders (ID, datePlaced, productID, productname, price)  VALUES ('1', now(), 'bb', 'Soccer Ball', '29.99');
INSERT INTO Orders (ID, datePlaced, productID, productname, price)  VALUES ('2345', now(), 'ab', 'Baseball Bat', '50.00');
INSERT INTO Orders (ID, datePlaced, productID, productname, price)  VALUES ('3546465', now(), 'cb', 'Golf Clubs', '399.99');
INSERT INTO Orders (ID, datePlaced, productID, productname, price)  VALUES ('4676', now(), 'db', 'Baseball Bat and Soccer Ball', '79.99');
INSERT INTO Orders (ID, datePlaced, productID, productname, price)  VALUES ('544324', now(), 'eb', 'Golf Clubs', '399.99');

--
--
-- -- Order and OrderItems
-- INSERT INTO Orders (ID, customerID, datePlaced)  VALUES ('000001', 'aaaaa', now());
-- INSERT INTO OrderItems (Id, orderID, productID, productTotal) VALUES ('aiodsfjsd', '000001', '000004', 399.99);
-- INSERT INTO OrderItems (Id, orderID, productID, productTotal) VALUES ('flkflasjf', '000001', '000002', 29.99);
-- INSERT INTO OrderItems (Id, orderID, productID, productTotal) VALUES ('gadsgd', '000001', '000001', 50.00);
--
-- INSERT INTO Orders (ID, customerID, datePlaced)  VALUES ('000002', 'aaaaa', now());
-- INSERT INTO OrderItems (Id, orderID, productID, productTotal) VALUES ('afhfdd', '000002', '000003', 19.99);
-- INSERT INTO OrderItems (Id, orderID, productID, productTotal) VALUES ('hererhe', '000002', '000004', 399.99);
--
-- INSERT INTO Orders (ID, customerID, datePlaced)  VALUES ('000003', 'aaaab', now());
-- INSERT INTO OrderItems (Id, orderID, productID, productTotal) VALUES ('gassgsd', '000003', '000003', 19.99);
-- INSERT INTO OrderItems (Id, orderID, productID, productTotal) VALUES ('hererhe', '000003', '000001', 50.00);
--
-- INSERT INTO Orders (ID, customerID, datePlaced)  VALUES ('000004', 'aaaac', now());
-- INSERT INTO OrderItems (Id, orderID, productID, productTotal) VALUES ('dsglkdsg', '000004', '000002', 29.99);

