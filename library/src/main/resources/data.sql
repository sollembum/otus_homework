insert into genres (name) values ('horror');
insert into genres (name) values ('comedy');
insert into genres (name) values ('tragedy');
insert into genres (name) values ('thriller');
insert into genres (name) values ('adventure');
insert into genres (name) values ('drama');
insert into genres (name) values ('circus');
insert into genres (name) values ('detective');

insert into authors (fullname) values ('duma');
insert into authors (fullname) values ('pushkin');
insert into authors (fullname) values ('lermontov');
insert into authors (fullname) values ('gogol');


insert into books (title, author_id, genre_id) values ('3 musketeers', 1, 5);
insert into books (title, author_id, genre_id) values ('evgeniy onegin', 2, 6);
insert into books (title, author_id, genre_id) values ('harry potter', 3, 4);
insert into books (title, author_id, genre_id) values ('dead souls', 4, 1);
insert into books (title, author_id, genre_id) values ('graf monte christo', 1, 7);
insert into books (title, author_id, genre_id) values ('harry potter and chamber of secrets', 3, 4);

insert into book_comments (comment, book_id) values ('very good', 1);
insert into book_comments (comment, book_id) values ('very bad', 2);
insert into book_comments (comment, book_id) values ('very reead', 3);
