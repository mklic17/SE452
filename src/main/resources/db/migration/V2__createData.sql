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

-- INSERT INTO Product(Id, name, description, price, isActive) VALUES('111111', 'Baseball Bat', 'This is a bat used in the game of baseball', '50.00', true);
-- INSERT INTO Product(Id, name, description, price, isActive) VALUES('222222', 'Soccer Ball', 'This is a ball used in the game of soccer', '29.99', true);
-- INSERT INTO Product(Id, name, description, price, isActive) VALUES('333333', 'Basketball Shooting Sleeve', 'Sleeve that goes on your arm to aid in the Basketball shooting form', '19.99', true);
-- INSERT INTO Product(Id, name, description, price, isActive) VALUES('444444', 'Golf Clubs', 'These are golf Clubs used to play golf', '399.99', true);


--- Category
INSERT INTO Category(name) VALUES('Sports');
INSERT INTO Category(name) VALUES('Baseball');
INSERT INTO Category(name) VALUES('Soccer');
INSERT INTO Category(name) VALUES('Basketball');
INSERT INTO Category(name) VALUES('Golf');


--- ProductsInCategory
-- INSERT INTO ProductsInCategory(ID, productID, categoryID) VALUES('1a1a1a', '111111', 'aaaaa');
-- INSERT INTO ProductsInCategory(ID, productID, categoryID) VALUES('1a1a1b', '111111', 'aaaab');
-- INSERT INTO ProductsInCategory(ID, productID, categoryID) VALUES('1a1a1c', '222222', 'aaaaa');
-- INSERT INTO ProductsInCategory(ID, productID, categoryID) VALUES('1a1a1d', '222222', 'aaaac');
-- INSERT INTO ProductsInCategory(ID, productID, categoryID) VALUES('1a1a1e', '333333', 'aaaaa');
-- INSERT INTO ProductsInCategory(ID, productID, categoryID) VALUES('1a1a1f', '333333', 'aaaad');
-- INSERT INTO ProductsInCategory(ID, productID, categoryID) VALUES('1a1a1g', '444444', 'aaaaa');
-- INSERT INTO ProductsInCategory(ID, productID, categoryID) VALUES('1a1a1h', '444444', 'aaaae');

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
