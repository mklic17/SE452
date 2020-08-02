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
    Id SERIAL,
    name VARCHAR(40) NOT NULL,
    price VARCHAR(18),
    summary VARCHAR(200),
    description VARCHAR(10000),
    image VARCHAR(200),
    -- isActive BOOLEAN DEFAULT true,

    PRIMARY KEY (Id)
);


CREATE TABLE Category (
    Id SERIAL,
    name VARCHAR(40) NOT NULL,
    parent VARCHAR(20), -- parent or child?

    PRIMARY KEY (Id)
);

CREATE TABLE Products_In_Category (
    -- ID SERIAL, -- Is this needed?
    product_ID SERIAL, -- productID
    category_ID SERIAL,

    -- PRIMARY KEY (Id),
    FOREIGN KEY (product_ID) REFERENCES Product(ID),
    FOREIGN KEY (category_ID) REFERENCES Category(ID)
);

 CREATE TABLE Orders (
     Id SERIAL,
     datePlaced TIMESTAMP NOT NULL,
     productID VARCHAR(18) NOT NULL,
     productName VARCHAR(30),
     price VARCHAR(30),

     PRIMARY KEY (Id)
 );

 CREATE TABLE Refund (
 	refundId SERIAL,
 	orderNumber VARCHAR(18),
 	productName VARCHAR(30),
 	reason VARCHAR(500),

 	PRIMARY KEY (RefundID)
 	);


 CREATE TABLE Review (
 	Id SERIAL,
 	productId VARCHAR(18),
 	--userId varchar(18),
  rating varchar(1),
 	comment varchar(1000),

 	primary key (ID)
 	);

 CREATE TABLE Customer (
 	ID SERIAL,
 	username VARCHAR(20) NOT NULL,
	first_name VARCHAR(20) NOT NULL,
	last_name VARCHAR(20) NOT NULL,
	email VARCHAR(50),

	CONSTRAINT uniqueEmail UNIQUE(email),
	PRIMARY KEY (ID)
);


 CREATE TABLE Cart (
    cart_ID SERIAL,
    customer_ID SERIAL,
    total_price VARCHAR(18),

    PRIMARY KEY (cart_ID),
    FOREIGN KEY (customer_ID) REFERENCES Customer(ID)
);

 CREATE TABLE Cart_Products (
    cart_ID SERIAL,
    product_ID SERIAL,

    FOREIGN KEY (cart_ID) REFERENCES Cart(cart_ID),
    FOREIGN KEY (product_ID) REFERENCES Product(ID)
);
