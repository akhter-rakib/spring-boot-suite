CREATE TABLE REGISTRATION_USERS (
                                    id SERIAL PRIMARY KEY,
                                    username VARCHAR(100) NOT NULL,
                                    first_name VARCHAR(50) NOT NULL,
                                    last_name VARCHAR(50),
                                    email VARCHAR(50) NOT NULL,
                                    CONSTRAINT UK_username UNIQUE (username)
);
