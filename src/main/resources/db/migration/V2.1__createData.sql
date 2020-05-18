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
INSERT INTO Product(name, description, price) VALUES('Baseball Bat', 'This is a bat used in the game of baseball', '50.00');
INSERT INTO Product(name, description, price) VALUES('Soccer Ball', 'This is a ball used in the game of soccer', '29.99');
INSERT INTO Product(name, description, price) VALUES('Basketball Shooting Sleeve', 'Sleeve that goes on your arm to aid in the Basketball shooting form', '19.99');
INSERT INTO Product(name, description, price) VALUES('Golf Clubs', 'These are golf Clubs used to play golf', '399.99');


INSERT INTO Orders (ID, datePlaced, productID, productname, price)  VALUES ('1', now(), 'bb', 'Soccer Ball', '29.99');
INSERT INTO Orders (ID, datePlaced, productID, productname, price)  VALUES ('2345', now(), 'ab', 'Baseball Bat', '50.00');
INSERT INTO Orders (ID, datePlaced, productID, productname, price)  VALUES ('3546465', now(), 'cb', 'Golf Clubs', '399.99');
INSERT INTO Orders (ID, datePlaced, productID, productname, price)  VALUES ('4676', now(), 'db', 'Baseball Bat and Soccer Ball', '79.99');
INSERT INTO Orders (ID, datePlaced, productID, productname, price)  VALUES ('544324', now(), 'eb', 'Golf Clubs', '399.99');


-- INSERT INTO Product(Id, name, description, price, isActive) VALUES('111111', 'Baseball Bat', 'This is a bat used in the game of baseball', '50.00', true);
-- INSERT INTO Product(Id, name, description, price, isActive) VALUES('222222', 'Soccer Ball', 'This is a ball used in the game of soccer', '29.99', true);
-- INSERT INTO Product(Id, name, description, price, isActive) VALUES('333333', 'Basketball Shooting Sleeve', 'Sleeve that goes on your arm to aid in the Basketball shooting form', '19.99', true);
-- INSERT INTO Product(Id, name, description, price, isActive) VALUES('444444', 'Golf Clubs', 'These are golf Clubs used to play golf', '399.99', true);

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
INSERT INTO Customer (username, first_name, last_name, email) VALUES ('clax', 'Tom', 'Claxton', 'email@example.com');
INSERT INTO Customer (username, first_name, last_name, email) VALUES ('aaaaa', 'Michael', 'Scott',  'mscott@dundermifflin.com');
INSERT INTO Customer (username, first_name, last_name, email) VALUES ('aaaab', 'Dwight', 'Schrute',  'dschture@dundermifflin.com');
INSERT INTO Customer (username, first_name, last_name, email) VALUES ('aaaac', 'Jim', 'Halpert',  'jhalpert@dundermifflin.com');

-- Cart
INSERT INTO Cart (customer_ID, total_price) VALUES (1, '0');