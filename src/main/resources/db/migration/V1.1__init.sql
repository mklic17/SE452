/*
DB Schema
Product(ID, name, description, price, isActive);
Category(ID, name);
ProductsInCategory(ID, name);
Customer(ID, firstName, lastName, email); -- Admin
Orders(ID, customerID, datePlaced);
OrderItems(Id, orderID, productID, productTotal);
*/

CREATE TABLE Product (
    ID SERIAL,
    name VARCHAR(40) NOT NULL,
    price VARCHAR(18),
    summary Varchar(200),
    description VARCHAR(10000),
    image varchar(200),
    -- isActive BOOLEAN DEFAULT true,

    PRIMARY KEY (Id)
);


CREATE TABLE Category (
    ID SERIAL,
    name VARCHAR(40) NOT NULL,
    parent VARCHAR(20), -- parent or child?

    PRIMARY KEY (Id)
);

CREATE TABLE Products_In_Category (
    ID SERIAL, -- Is this needed?
    product_ID SERIAL, -- productID
    category_ID SERIAL,

    PRIMARY KEY (Id),
    FOREIGN KEY (product_ID) REFERENCES Product(ID),
    FOREIGN KEY (category_ID) REFERENCES Category(ID)
);

 CREATE TABLE Orders (
     ID serial,
     datePlaced TIMESTAMP NOT NULL,
     productID VARCHAR(18) NOT NULL,
     productname VARCHAR(30),
     price VARCHAR(30),

     PRIMARY KEY (Id)
 );

 CREATE TABLE Refund (
 	RefundID SERIAL,
 	ordernumber VARCHAR(18),
 	ProductName VARChAR(30),

 	PRIMARY KEY (RefundID)
 	);


 CREATE TABLE Review (

 	ID serial,
 	productid VARCHAR(18),
 	userid varchar(18),
 	comment varchar(50),

 	primary key (id)
 	);


 CREATE TABLE Customer (

 	ID VARCHAR(18),
	firstName VARCHAR(20) NOT NULL,
	lastName VARCHAR(20) NOT NULL,
	email VARCHAR(50),

	CONSTRAINT uniqueEmail UNIQUE(email),
	PRIMARY KEY (Id)
);


 CREATE TABLE Cart (
    cart_ID serial,
    customer_ID VARCHAR(18),
    total_price VARCHAR(18),

    PRIMARY KEY (cart_ID),
    FOREIGN KEY (customer_ID) REFERENCES customer(ID)
);

 CREATE TABLE Cart_Products (
    cart_ID serial,
    product_ID serial,

    FOREIGN KEY (cart_ID) REFERENCES Cart(cart_ID),
    FOREIGN KEY (product_ID) REFERENCES Product(ID)
);


-- CREATE TABLE Customer (
--     ID VARCHAR(18),
--     firstName VARCHAR(20) NOT NULL,
--     lastName VARCHAR(20) NOT NULL,
--     email VARCHAR(50),
--
--     CONSTRAINT uniqueEmail UNIQUE(email),
--     PRIMARY KEY (Id)
-- );
--
-- CREATE TABLE Orders (
--     ID VARCHAR(18),
--     customerID VARCHAR(18) NOT NULL,
--     datePlaced TIMESTAMP NOT NULL,
--     status varchar(20),
--
--     FOREIGN KEY (customerID) REFERENCES Customer(ID),
--     PRIMARY KEY (Id)
-- );
--
-- CREATE TABLE OrderItems (
--     ID varchar(18),
--     orderId varchar(18) NOT NULL,
--     productID varchar(18) NOT NULL,
--     productTotal money,
--
--     FOREIGN KEY (orderID) REFERENCES Orders(ID),
--     FOREIGN KEY (productID) REFERENCES Product(ID),
--     PRIMARY KEY (ID)
-- );

