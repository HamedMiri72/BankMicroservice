CREATE TABLE card(
    card_id int NOT NULL AUTO_INCREMENT,
    mobile_number VARCHAR(100) NOT NULL,
    card_number VARCHAR(100) NOT NULL,
    card_type VARCHAR(100) NOT NULL,
    total_limit INT NOT NULL,
    amount_used INT NOT NULL,
    available_amount INT NOT NULL ,
    created_at DATE NOT NULL,
    created_by VARCHAR(30) NOT NULL ,
    updated_at DATE DEFAULT NULL,
    updated_by DATE DEFAULT NULL,
    CONSTRAINT pk_cards PRIMARY KEY (card_id)
);