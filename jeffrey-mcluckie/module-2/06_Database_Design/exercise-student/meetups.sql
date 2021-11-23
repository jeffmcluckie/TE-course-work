
BEGIN TRANSACTION;

CREATE TABLE interest_group (
        id SERIAL,
        name varchar(200) NOT NULL UNIQUE,
        CONSTRAINT pk_interest_group_id PRIMARY KEY (id)
);

CREATE TABLE member (
        id SERIAL,
        first_name VARCHAR(80) NOT NULL,
        last_name VARCHAR(80) NOT NULL,
        phone VARCHAR(11),
        address VARCHAR(200) NOT NULL,
        email VARCHAR(200) NOT NULL,
        wants_reminders BOOLEAN NOT NULL,
        interest_group_id int NOT NULL,
        CONSTRAINT pk_member_id PRIMARY KEY (id),
        CONSTRAINT fk_interest_group_id FOREIGN KEY (interest_group_id) REFERENCES interest_group(id)
      
);

CREATE TABLE event(
        id SERIAL,
        interest_group_id int NOT NULL,
        name varchar(200) NOT NULL,
        description varchar(200) NOT NULL,
        start_date varchar(10) NOT NULL,
        start_time varchar(8) NOT NULL,
        duration varchar(4) NOT NULL,
        CONSTRAINT pk_event_id PRIMARY KEY (id),
        CONSTRAINT fk_interest_group_id FOREIGN KEY (interest_group_id) REFERENCES interest_group(id)
);



INSERT INTO interest_group (name) VALUES ('Basketball');
INSERT INTO interest_group (name) VALUES ('Baseball'); 
INSERT INTO interest_group (name) VALUES ('Football');

INSERT INTO member (first_name,last_name,phone,address,email,wants_reminders,interest_group_id) VALUES ('Jeff','McLuckie','6315602682','10 Ashford Ln','jeffmcluckie1@gmail.com',true,1);
INSERT INTO member (first_name,last_name,phone,address,email,wants_reminders,interest_group_id) VALUES ('Jefff','McLuckie','6315602681','10 Ashford Ln','jeffmcluckie2@gmail.com',true,2);
INSERT INTO member (first_name,last_name,phone,address,email,wants_reminders,interest_group_id) VALUES ('Jeffff','McLuckie','6315602683','10 Ashford Ln','jeffmcluckie3@gmail.com',true,1);
INSERT INTO member (first_name,last_name,phone,address,email,wants_reminders,interest_group_id) VALUES ('Jefffff','McLuckie','6315602684','10 Ashford Ln','jeffmcluckie4@gmail.com',true,1);
INSERT INTO member (first_name,last_name,phone,address,email,wants_reminders,interest_group_id) VALUES ('Jeffffff','McLuckie','6315602687','10 Ashford Ln','jeffmcluckie5@gmail.com',true,2);
INSERT INTO member (first_name,last_name,phone,address,email,wants_reminders,interest_group_id) VALUES ('Jefffffff','McLuckie','6315602686','10 Ashford Ln','jeffmcluckie6@gmail.com',true,3);
INSERT INTO member (first_name,last_name,phone,address,email,wants_reminders,interest_group_id) VALUES ('Jeffffffff','McLuckie','6315602688','10 Ashford Ln','jeffmcluckie7@gmail.com',false,3);
INSERT INTO member (first_name,last_name,phone,address,email,wants_reminders,interest_group_id) VALUES ('Jefffffffff','McLuckie','6315602689','10 Ashford Ln','jeffmcluckie8@gmail.com',true,3);


INSERT INTO event (name,description,start_date,start_time,duration,interest_group_id) VALUES ('Bucks Game', 'Go Bucks', '10-10-2021', '10:10 PM', 90, 1);
INSERT INTO event (name,description,start_date,start_time,duration,interest_group_id) VALUES ('Browns Game', 'Go Browns', '10-10-2021', '10:10 PM', 90, 3);
INSERT INTO event (name,description,start_date,start_time,duration,interest_group_id) VALUES ('Bucks Game Again', 'Go Bucks AGAIN', '10-20-2021', '10:10 PM', 90, 1);
INSERT INTO event (name,description,start_date,start_time,duration,interest_group_id) VALUES ('Mets Game', 'Go Mets', '10-10-2021', '10:10 PM', 90, 2);


SELECT * FROM member;
SELECT * FROM interest_group;
SELECT * FROM event;

ALTER TABLE event
ADD CONSTRAINT duration CHECK (duration > '30');
ROLLBACK;

COMMIT;
