DROP TABLE IF EXISTS AUTHORS;
CREATE TABLE AUTHORS(ID BIGINT not null auto_increment PRIMARY KEY,
                    FULLNAME VARCHAR(255));

DROP TABLE IF EXISTS GENRES;
CREATE TABLE GENRES(ID BIGINT not null auto_increment PRIMARY KEY,
                    NAME VARCHAR(255));

DROP TABLE IF EXISTS BOOKS;
CREATE TABLE BOOKS(ID BIGINT not null auto_increment PRIMARY KEY ,
                TITLE VARCHAR(255),
                COMMENT_ID BIGINT,
                AUTHOR_ID BIGINT not null,
                GENRE_ID BIGINT not null,
                FOREIGN KEY (AUTHOR_ID) references AUTHORS (ID),
                FOREIGN KEY (GENRE_ID) references GENRES (ID));

DROP TABLE IF EXISTS BOOK_COMMENTS;
CREATE TABLE BOOK_COMMENTS (ID BIGINT PRIMARY KEY,
                            COMMENT VARCHAR(855))
