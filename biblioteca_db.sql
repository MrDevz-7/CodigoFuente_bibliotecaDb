-- Script de creación de la base de datos biblioteca_db
-- Copia y ejecuta este script en MySQL antes de correr la aplicación.

CREATE DATABASE IF NOT EXISTS biblioteca_db;
USE biblioteca_db;

CREATE TABLE patrons (
    card_num     INT PRIMARY KEY,
    name         VARCHAR(100) NOT NULL,
    member_year  INT NOT NULL,
    total_fine   DECIMAL(6,2) NOT NULL DEFAULT 0.00
);

CREATE TABLE books (
    book_id        INT PRIMARY KEY,
    title          VARCHAR(200) NOT NULL,
    author         VARCHAR(100) NOT NULL,
    published_year INT NOT NULL,
    genre          VARCHAR(50) NOT NULL
);

CREATE TABLE checkouts (
    checkout_id   INT PRIMARY KEY,
    card_num      INT NOT NULL,
    book_id       INT NOT NULL,
    checkout_date DATE NOT NULL,
    due_date      DATE NOT NULL,
    returned_date DATE NULL,
    CONSTRAINT fk_checkouts_patrons
        FOREIGN KEY (card_num) REFERENCES patrons(card_num),
    CONSTRAINT fk_checkouts_books
        FOREIGN KEY (book_id) REFERENCES books(book_id)
);

CREATE TABLE employees (
    id         INT PRIMARY KEY,
    name       VARCHAR(100) NOT NULL,
    year_hired INT NOT NULL,
    dept_id    VARCHAR(10) NOT NULL
);

INSERT INTO patrons (card_num, name, member_year, total_fine) VALUES
(1001, 'Ana Rodríguez',     2020,  0.00),
(1002, 'Carlos Pérez',      2019,  2.50),
(1003, 'Luisa Gómez',       2021, 10.00),
(1004, 'Miguel Fernández',  2018,  6.75),
(1005, 'Sofía Martínez',    2022,  0.00);

INSERT INTO books (book_id, title, author, published_year, genre) VALUES
(1, 'Aprendiendo SQL',                  'J. Torres',        2015, 'Tecnología'),
(2, 'Algoritmos en Java',               'M. López',        2018, 'Tecnología'),
(3, 'Amor en tiempos de lluvia',        'L. Sánchez',      2012, 'Novela'),
(4, 'Análisis de Datos con Python',     'C. Rivas',        2020, 'Tecnología'),
(5, 'Cien años de soledad',             'G. García Márquez',1967,'Novela'),
(6, 'Arquitectura de Computadores',     'R. Gómez',        2005, 'Tecnología'),
(7, 'Administración de Bases de Datos', 'P. Herrera',      2010, 'Tecnología'),
(8, 'Aventuras en la Montaña',          'D. Ramírez',      2019, 'Novela'),
(9, 'Redes de Computadores',            'A. Núñez',        2011, 'Tecnología'),
(10,'Historia de la Literatura',        'F. Medina',       1998, 'Ensayo');

INSERT INTO employees (id, name, year_hired, dept_id) VALUES
(1, 'Laura Torres',   2017, 'ADM'),
(2, 'Jorge Ruiz',     2019, 'CAT'),
(3, 'María López',    2021, 'IT'),
(4, 'Pedro García',   2015, 'REF'),
(5, 'Andrea Castro',  2023, 'CAT');

INSERT INTO checkouts (checkout_id, card_num, book_id, checkout_date, due_date, returned_date) VALUES
(1, 1001, 1,  '2025-10-01', '2025-10-08', '2025-10-06'),
(2, 1002, 3,  '2025-10-02', '2025-10-09', NULL),
(3, 1003, 4,  '2025-10-05', '2025-10-12', '2025-10-11'),
(4, 1001, 5,  '2025-10-10', '2025-10-17', NULL),
(5, 1004, 2,  '2025-10-11', '2025-10-18', '2025-10-17'),
(6, 1005, 8,  '2025-10-15', '2025-10-22', '2025-10-21'),
(7, 1003, 7,  '2025-10-20', '2025-10-27', NULL),
(8, 1002, 1,  '2025-10-25', '2025-11-01', '2025-10-30');
