SET TIME ZONE 'UTC';

CREATE TABLE client (
                        ID INT AUTO_INCREMENT PRIMARY KEY,
                        NAME VARCHAR(200) NOT NULL CHECK (LENGTH(NAME) >= 3)
);

CREATE TABLE planet (
                        ID VARCHAR(50) NOT NULL CHECK (ID = UPPER(ID) AND ID REGEXP '^[A-Z0-9]+$'),
    NAME VARCHAR(500) NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE ticket (
                        ID INT AUTO_INCREMENT PRIMARY KEY,
                        CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        CLIENT_ID INT,
                        FROM_PLANET_ID VARCHAR(50),
                        TO_PLANET_ID VARCHAR(50),
                        FOREIGN KEY (CLIENT_ID) REFERENCES client(ID),
                        FOREIGN KEY (FROM_PLANET_ID) REFERENCES planet(ID),
                        FOREIGN KEY (TO_PLANET_ID) REFERENCES planet(ID)
);
