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
    description VARCHAR(1000),
    price VARCHAR(18),
    isActive BOOLEAN DEFAULT true,

    PRIMARY KEY (Id)
);


CREATE TABLE Category (
    ID SERIAL,
    name VARCHAR(40) NOT NULL,
    parent VARCHAR(20),

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
