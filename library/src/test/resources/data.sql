insert into genres (id, name) values (1, 'horror');
insert into genres (id, name) values (2, 'comedy');
insert into genres (id, name) values (3, 'tragedy');
insert into genres (id, name) values (4, 'thriller');
insert into genres (id, name) values (5, 'adventure');
insert into genres (id, name) values (6, 'drama');
insert into genres (id, name) values (7, 'circus');
insert into genres (id, name) values (8, 'detective');

insert into authors (id, fullname) values (1, 'duma');
insert into authors (id, fullname) values (2, 'pushkin');
insert into authors (id, fullname) values (3, 'lermontov');
insert into authors (id, fullname) values (4, 'gogol');

insert into books (id, title, author_id, genre_id) values (1, '3 musketeers', 1, 5);
insert into books (id, title, author_id, genre_id) values (2, 'evgeniy onegin', 2, 6);