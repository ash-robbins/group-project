BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

COMMIT TRANSACTION;

--TEST DATA FOR READING ACTIVITY TABLE
--INSERT INTO reading_activity (user_id, book_id, format, reading_time, notes, reading_partner_id, is_completed, is_favorite, bookmark_page_number)
--VALUES (22, 1, 'paper', 10, 'solo reading', null, false, true, 15);
--
--INSERT INTO reading_activity (user_id, book_id, format, reading_time, notes, reading_partner_id, is_completed, is_favorite, bookmark_page_number)
--VALUES (22, 1, 'paper', 15, 'solo reading', null, false, true, 30);
--
--INSERT INTO reading_activity (user_id, book_id, format, reading_time, notes, reading_partner_id, is_completed, is_favorite, bookmark_page_number)
--VALUES (22, 1, 'paper', 15, 'solo reading', null, false, true, 30);


--TEST SQL STATEMENTS

--Rank by Reading Time
SELECT * FROM reading_activity
ORDER BY reading_time DESC;

--Prize Winner Top 2 Reading Time
SELECT * FROM reading_activity
ORDER BY reading_time DESC LIMIT 2;

--Total Completed Books
SELECT COUNT(*) FROM reading_activity
WHERE is_completed = true;

--Total Reading Time
SELECT SUM(reading_time) FROM reading_activity
WHERE user_id = ?;

--Returns User Id, total Reading time, total Completed books
SELECT user_id, SUM(reading_time) as total_reading_time, COUNT(is_completed = true) as completed_books, COUNT(is_completed = false) as readings_in_progress
FROM reading_activity
GROUP BY user_id;





