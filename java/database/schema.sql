BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS family_account;
DROP TABLE IF EXISTS family_member;
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS reading_activity;
DROP TABLE IF EXISTS prize;
DROP TABLE IF EXISTS prize_winner;


CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE family_account (
    family_id SERIAL,
    family_name varchar(30) NOT NULL,
    created_by int NOT NULL,
    created_date date NOT NULL,
    CONSTRAINT pk_family_account PRIMARY KEY (family_id)
    );

 CREATE TABLE family_member (
    family_id int NOT NULL,
    user_id int NOT NULL,
    member_type varchar(10) NOT NULL,
    CONSTRAINT pk_family_member PRIMARY KEY (family_id, user_id),
    CONSTRAINT fk_family_member_family FOREIGN KEY (family_id) REFERENCES family_account (family_id),
    CONSTRAINT fk_family_member_user FOREIGN KEY (user_id) REFERENCES users (user_id)
    );

CREATE TABLE books (
    book_id SERIAL,
    isbn int NOT NULL UNIQUE,
    title varchar(40) NOT NULL,
    author varchar(40) NOT NULL,
    cover_image varchar(100) NOT NULL,
    description varchar(200),

    CONSTRAINT pk_books PRIMARY KEY (book_id),
    CONSTRAINT uq_books UNIQUE (isbn)
    );

CREATE TABLE reading_activity (
    reading_activity_id SERIAL,
    user_id int NOT NULL,
    book_id int NOT NULL,
    format varchar(15),
    reading_time int NOT NULL,
    notes varchar(120),
    reading_partner_id int,
    is_completed boolean NOT NULL,
    is_favorite boolean NOT NULL,
    bookmark_page_number int,
    CONSTRAINT pk_reading_activity PRIMARY KEY (reading_activity_id),
    CONSTRAINT fk_reading_activity_user FOREIGN KEY (user_id) REFERENCES users (user_id),
    CONSTRAINT fk_reading_activity_book FOREIGN KEY (book_id) REFERENCES books (book_id),
    CONSTRAINT fk_reading_activity_partner FOREIGN KEY (reading_partner_id) REFERENCES users (user_id)
    );

CREATE TABLE prize (
    prize_id SERIAL,
    description varchar(150) NOT NULL,
    milestone int NOT NULL,
    family_id int NOT NULL,
    max_prizes int NOT NULL,
    start_date date NOT NULL,
    end_date date NOT NULL
    CONSTRAINT pk_prize PRIMARY KEY (prize_id),
    CONSTRAINT fk_prize_family FOREIGN KEY (family_id) REFERENCES family_account (family_id)
    );

CREATE TABLE prize_winner (
    prize_winner_id SERIAL,
    user_id int NOT NULL,
    prize_id int NOT NULL
    CONSTRAINT pk_prize_winner PRIMARY KEY (prize_winner_id),
    CONSTRAINT fk_prize_winner_user FOREIGN KEY (user_id) REFERENCES users (user_id),
    CONSTRAINT fk_prize_winner_prize FOREIGN KEY (prize_id) REFERENCES prize (prize_id)
    );

COMMIT TRANSACTION;


