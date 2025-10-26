CREATE TABLE Customer(
    customer_id int AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL ,
    email VARCHAR(100) NOT NULL ,
    mobileNumber VARCHAR(20) NOT NULL ,
    created_at DATE NOT NULL ,
    created_by VARCHAR(100) NOT NULL ,
    updated_at DATE DEFAULT NULL,
    updated_by VARCHAR(100) DEFAULT NULL
);


CREATE TABLE Account(
  account_number int AUTO_INCREMENT PRIMARY KEY,
  customer_id int NOT NULL ,
  account_type VARCHAR(100) NOT NULL,
  branch_address VARCHAR(200) NOT NULL,
  created_at DATE NOT NULL ,
  created_by VARCHAR(100) NOT NULL ,
  updated_at DATE DEFAULT NULL,
  updated_by VARCHAR(100) DEFAULT NULL,
  FOREIGN KEY (customer_id) REFERENCES Customer(customer_id)
);