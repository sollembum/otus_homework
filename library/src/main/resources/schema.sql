DROP TABLE IF EXISTS AUTHORS;
CREATE TABLE AUTHORS(ID long not null generated by default as identity PRIMARY KEY,
                    FULLNAME VARCHAR(255));

DROP TABLE IF EXISTS GENRES;
CREATE TABLE GENRES(ID long not null generated by default as identity PRIMARY KEY,
                    NAME VARCHAR(255));

DROP TABLE IF EXISTS BOOKS;
CREATE TABLE BOOKS(ID long not null generated by default as identity PRIMARY KEY ,
                   TITLE VARCHAR(255),
                   AUTHOR_ID long not null,
                   GENRE_ID long not null,
                   FOREIGN KEY (AUTHOR_ID) references AUTHORS (ID),
                   FOREIGN KEY (GENRE_ID) references GENRES (ID));

DROP TABLE IF EXISTS BOOK_COMMENTS;
CREATE TABLE BOOK_COMMENTS (ID long not null generated by default as identity PRIMARY KEY,
                            BOOK_ID long not null,
                            COMMENT VARCHAR(855),
                            FOREIGN KEY (BOOK_ID) references BOOKS (ID));




