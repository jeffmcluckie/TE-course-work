-- TODO drop tables before added
DROP TABLE purchase;
DROP TABLE artwork;
DROP TABLE person;

-- IF EXISTS is not "standard" but Postgres supports it
DROP TABLE IF EXISTS person;

-- Start a transaction so that everything is created or nothing is
BEGIN TRANSACTION;

-- creates a new table w/ columns
CREATE TABLE person (
        id SERIAL,
        first_name VARCHAR(80) NOT NULL,
        last_name VARCHAR(80) NOT NULL,
        phone VARCHAR(11) NULL,
        address VARCHAR(200) NULL,
        
        -- Adding constraint for primary key
        CONSTRAINT pk_person PRIMARY KEY (id)
);

CREATE TABLE artwork (
        id SERIAL,
        title VARCHAR(80) NOT NULL,
        artist_id int NOT NULL,
        
        -- Adding constraint for primary key
        CONSTRAINT pk_artwork PRIMARY KEY (id),
        -- Adding constraint for foreign key
        CONSTRAINT fk_artwork_person FOREIGN KEY (artist_id) REFERENCES person (id)
);

CREATE TABLE purchase (
        -- Another option for primary key (not standard but Postgres supports this)
        id SERIAL PRIMARY KEY,
        -- Another option for foreign keys (not standard but Postgres supports this)
        buyer_id int REFERENCES person (id) NOT NULL,
        seller_id int REFERENCES person (id) NOT NULL,
        artwork_id int REFERENCES artwork (id) NOT NULL,
        purchase_date TIMESTAMP NOT NULL,
        price MONEY NOT NULL
);

COMMIT TRANSACTION;


-- Can also change tables after creation using ALTER TABLE
-- Some examples:
-- ALTER TABLE table_name
-- ADD CONSTRAINT pk_constraint_name PRIMARY KEY (column_name(s));

-- ALTER TABLE table_name
-- ADD CONSTRAINT fk_constraint_name FOREIGN KEY (column_name) REFERENCES table(column_name);

-- ALTER TABLE table_name
-- ADD CONSTRAINT chk_constraint_name CHECK (column_name = 'value' OR column_name IN (values));