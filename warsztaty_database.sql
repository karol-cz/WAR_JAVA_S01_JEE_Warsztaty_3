CREATE DATABASE warsztaty;
USE warsztaty;

CREATE TABLE user_group (
    id INT(11) AUTO_INCREMENT,
    name VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE users (
    id BIGINT(20) AUTO_INCREMENT,
    name VARCHAR(255),
    surname VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(245),
    person_group_id INT(11),
    PRIMARY KEY (id),
    FOREIGN KEY (person_group_id)
        REFERENCES user_group (id)
);

CREATE TABLE exercise (
    id INT(11) AUTO_INCREMENT,
    title VARCHAR(255),
    description TEXT,
    PRIMARY KEY (id)
);

CREATE TABLE solution (
    id INT(11) AUTO_INCREMENT,
    created DATETIME,
    updated DATETIME,
    description TEXT,
    exercise_id INT(11),
    users_id BIGINT(20),
    PRIMARY KEY (id),
    FOREIGN KEY (exercise_id)
        REFERENCES exercise (id),
    FOREIGN KEY (users_id)
        REFERENCES users (id)
);

INSERT INTO user_group (name) VALUES('Grupa zaawansowana');
INSERT INTO user_group (name) VALUES('Grupa srednio zaawansowana');
INSERT INTO user_group (name) VALUES('Grupa podstawowa');
INSERT INTO user_group (name) VALUES('Grupa bardzo podstawowa');

INSERT INTO exercise (title, description) VALUES('Zadanie 1', 'Latwe zadanie');
INSERT INTO exercise (title, description) VALUES('Zadanie 2', 'Nie takie latwe zadanie');
INSERT INTO exercise (title, description) VALUES('Zadanie 3', 'Trudne');
INSERT INTO exercise (title, description) VALUES('Zadanie 4', 'Nie do zrobienia');
INSERT INTO exercise (title, description) VALUES('Zadanie 5', 'Bardzo trudne');

INSERT INTO users (name, surname, email, password, person_group_id) VALUES('Kamil', 'Nowak', 'kamil@wp.pl', 'haslo1', 1);
INSERT INTO users (name, surname, email, password, person_group_id) VALUES('Jan', 'Kowalski', 'j.kowalksi@poczta.onet.pl', 'haslo2', 1);
INSERT INTO users (name, surname, email, password, person_group_id) VALUES('Zenon', 'Kwiatkowski', 'zenon@poczta.onet.pl', 'haslo3', 1);
INSERT INTO users (name, surname, email, password, person_group_id) VALUES('Ania', 'Wisniewska', 'wisniewska@gmail.com', 'haslo4', 2);
INSERT INTO users (name, surname, email, password, person_group_id) VALUES('Magda', 'Zielinska', 'zielinska@gmail.com', 'haslo5', 2);
INSERT INTO users (name, surname, email, password, person_group_id) VALUES('Piotr', 'Grabowski', 'p.grabowski@gmail.com', 'haslo6', 2);
INSERT INTO users (name, surname, email, password, person_group_id) VALUES('Tomasz', 'Pawlak', 't.pawlak@gmail.com', 'haslo7', 3);
INSERT INTO users (name, surname, email, password, person_group_id) VALUES('Marian', 'Malinowski', 'm.malinowski@gmail.com', 'haslo8', 3);
INSERT INTO users (name, surname, email, password, person_group_id) VALUES('Adam', 'Krol', 'a.krol@gmail.com', 'haslo9', 3);
INSERT INTO users (name, surname, email, password, person_group_id) VALUES('Kasia', 'Krol', 'k.krol@gmail.com', 'haslo10', 3);
INSERT INTO users (name, surname, email, password, person_group_id) VALUES('Pawel', 'Michalski', 'p.michalski@gmail.com', 'haslo11', 4);
INSERT INTO users (name, surname, email, password, person_group_id) VALUES('Kazimierz', 'Czarnecki', 'k.czarnecki@gmail.com', 'haslo12', 4);

INSERT INTO solution (created, updated, description, exercise_id, users_id) VALUES('2017-05-20', '2017-06-10', 'Trudniejsze niz sie wydawalo', 1, 1);
INSERT INTO solution (created, updated, description, exercise_id, users_id) VALUES('2017-05-22', '2017-06-11', 'Jednak latwe', 2, 2);
INSERT INTO solution (created, updated, description, exercise_id, users_id) VALUES('2017-05-13', '2017-05-14', 'Nie takie latwe', 3, 2);
INSERT INTO solution (created, updated, description, exercise_id, users_id) VALUES('2017-06-15', '2017-06-18', 'Dlugie', 4, 3);
INSERT INTO solution (created, updated, description, exercise_id, users_id) VALUES('2017-05-28', '2017-05-30', 'Krotkie', 5, 3);
INSERT INTO solution (created, updated, description, exercise_id, users_id) VALUES('2017-05-23', '2017-05-25', 'Za trudne', 1, 5);
INSERT INTO solution (created, updated, description, exercise_id, users_id) VALUES('2017-06-11', '2017-06-15', 'Nie rozumiem', 2, 5);
INSERT INTO solution (created, updated, description, exercise_id, users_id) VALUES('2017-05-25', '2017-05-30', 'Do powtorki', 3, 6);
INSERT INTO solution (created, updated, description, exercise_id, users_id) VALUES('2017-05-27', '2017-05-30', 'Byly prostrze', 4, 6);
INSERT INTO solution (created, updated, description, exercise_id, users_id) VALUES('2017-05-30', '2017-06-19', 'Nawet mi nie pokazuj', 5, 6);








