DROP TABLE IF EXISTS AUTHORS;
CREATE TABLE AUTHORS(ID BIGINT not null auto_increment PRIMARY KEY,
                    FULLNAME VARCHAR(255));

DROP TABLE IF EXISTS GENRES;
CREATE TABLE GENRES(ID BIGINT not null auto_increment PRIMARY KEY,
                    NAME VARCHAR(255));

DROP TABLE IF EXISTS BOOKS;
CREATE TABLE BOOKS(ID BIGINT not null auto_increment PRIMARY KEY ,
                TITLE VARCHAR(255),
                AUTHOR_ID BIGINT not null,
                GENRE_ID BIGINT,
                FOREIGN KEY (AUTHOR_ID) references AUTHORS (ID),
                FOREIGN KEY (GENRE_ID) references GENRES (ID));
