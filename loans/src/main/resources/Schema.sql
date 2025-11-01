CREATE TABLE Loans(
    loan_id int NOT NULL AUTO_INCREMENT,
    mobile_number VARCHAR(15) NOT NULL,
    loan_number VARCHAR(15) NOT NULL,
    loan_type  VARCHAR(50) NOT NULL ,
    total_loan int NOT NULL ,
    amount_paid int NOT NULL ,
    outstanding_amount int NOT NULL,
    created_at DATE NOT NULL,
    created_by VARCHAR(100) NOT NULL ,
    updated_at DATE DEFAULT NULL,
    updated_by VARCHAR(100) DEFAULT NULL,
    CONSTRAINT pk_loans PRIMARY KEY (loan_id)
);

