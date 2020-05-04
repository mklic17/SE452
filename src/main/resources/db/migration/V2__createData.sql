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
INSERT INTO Orders (ID, datePlaced, productID, productname, price)  VALUES ('000002', now(), 'ab', 'Baseball Bat', '50.00');
INSERT INTO Orders (ID, datePlaced, productID, productname, price)  VALUES ('000003', now(), 'cb', 'Golf Clubs', '399.99');
INSERT INTO Orders (ID, datePlaced, productID, productname, price)  VALUES ('000004', now(), 'db', 'Baseball Bat and Soccer Ball', '79.99');
INSERT INTO Orders (ID, datePlaced, productID, productname, price)  VALUES ('000005', now(), 'eb', 'Golf Clubs', '399.99');


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


--- Customer
-- INSERT INTO Customer (ID, firstName, lastName, email) VALUES ('aaaaa', 'Michael', 'Scott',  'mscott@dundermifflin.com');
-- INSERT INTO Customer (ID, firstName, lastName, email) VALUES ('aaaab', 'Dwight', 'Schrute',  'dschture@dundermifflin.com');
-- INSERT INTO Customer (ID, firstName, lastName, email) VALUES ('aaaac', 'Jim', 'Halpert',  'jhalpert@dundermifflin.com');
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
