INSERT INTO book(date_written, num_favourites, artist_name, genre, id, name) VALUES (DATE '1952-06-01', 0, 'Isaac Asimov', 'SCIENCE_FICTION', 2, 'Foundation and Empire');
-- INSERT INTO book(date_written, num_favourites, artist_name, genre, id, name) VALUES ('1954-07-29', 0, 'J.R.R. Tolkien', 'FANTASY', 4, 'The Fellowship of the Ring');
-- INSERT INTO book(date_written, num_favourites, artist_name, genre, id, name) VALUES ('1812-10-01', 0, 'Ludwig van Beethoven', 'CLASSICAL', 6, 'Symphony No. 5');
-- INSERT INTO book(date_written, num_favourites, artist_name, genre, id, name) VALUES ('1939-02-15', 0, 'Kočo Racin', 'MACEDONIAN', 8, 'Lirika i proza');
-- INSERT INTO book(date_written, num_favourites, artist_name, genre, id, name) VALUES ('1865-11-26', 0, 'Lewis Carroll', 'FANTASY', 11, 'Alice\s Adventures in Wonderland');
-- INSERT INTO book(date_written, num_favourites, artist_name, genre, id, name) VALUES ('1811-10-30', 0, 'Jane Austen', 'ROMANCE', 14, 'Sense and Sensibility');
-- INSERT INTO book(date_written, num_favourites, artist_name, genre, id, name) VALUES ('1967-06-05', 0, 'Gabriel Garcia Marquez', 'ROMANCE', 17, 'One Hundred Years of Solitude');
-- INSERT INTO book(date_written, num_favourites, artist_name, genre, id, name) VALUES ('1932-08-18', 0, 'Aldous Huxley', 'SCIENCE_FICTION', 19, 'Brave New World');
-- INSERT INTO book(date_written, num_favourites, artist_name, genre, id, name) VALUES ('1897-05-26', 0, 'Bram Stoker', 'HORROR', 21, 'Dracula');
-- INSERT INTO book(date_written, num_favourites, artist_name, genre, id, name) VALUES ('1988-01-01', 0, 'Haruki Murakami', 'ROMANCE', 23, 'Norwegian Wood');
INSERT INTO client(registry_date, email, id, name, password) VALUES (DATE '1988-01-01', 'myemail@gmail.com', 0, 'Kristijan', 'Panchevski');
INSERT INTO client_book_list(book_list_id, client_id) VALUES (2, 0);
-- INSERT INTO client_book_list(book_list_id, client_id) VALUES (23, 0);
-- INSERT INTO client_book_list(book_list_id, client_id) VALUES (11, 0);