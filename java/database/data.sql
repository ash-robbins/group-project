BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


--TEST DATA FOR READING ACTIVITY TABLE
INSERT INTO reading_activity (user_id, book_id, format, reading_time, notes, reading_partner_id, is_completed, is_favorite, bookmark_page_number)
VALUES ('22', '1', 'paper', 10, 'solo reading', null, false, true, 15);

INSERT INTO reading_activity (user_id, book_id, format, reading_time, notes, reading_partner_id, is_completed, is_favorite, bookmark_page_number)
VALUES ('22', '1', 'paper', 15, 'solo reading', null, false, true, 30);
COMMIT TRANSACTION;



