CREATE TABLE patients(

    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    identity_card VARCHAR(14) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    street VARCHAR(100) NOT NULL,
    district VARCHAR(100) NOT NULL,
    city VARCHAR(100) NOT NULL,
    number VARCHAR(20),
    complement VARCHAR(100),
    PRIMARY KEY (id)

)ENGINE=InnoDB;