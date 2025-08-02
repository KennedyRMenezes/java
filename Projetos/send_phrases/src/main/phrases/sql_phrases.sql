CREATE DATABASE IF NOT EXISTS phrases_db
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;
USE phrases_db;

CREATE TABLE users (
    id_user INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE
) ENGINE=InnoDB;

CREATE TABLE origin (
    id_origin INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
) ENGINE=InnoDB;

CREATE TABLE author (
    id_author INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
) ENGINE=InnoDB;

CREATE TABLE phrases (
    id_phrase INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    phrase VARCHAR(5000),
    id_origin INT NOT NULL,
    id_author INT NOT NULL,
    id_user INT NOT NULL,
    FOREIGN KEY (id_origin) REFERENCES origin(id_origin)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,
    FOREIGN KEY (id_author) REFERENCES author(id_author)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,
    FOREIGN KEY (id_user) REFERENCES users(id_user)
        ON DELETE CASCADE
        ON UPDATE CASCADE
) ENGINE=InnoDB;

CREATE TABLE phrase_control (
    id_control INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_phrase INT NOT NULL,
    id_user INT NOT NULL,
    next_shipment DATE NOT NULL,
    last_shipment DATE,
    FOREIGN KEY (id_phrase) REFERENCES phrases(id_phrase)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (id_user) REFERENCES users(id_user)
        ON DELETE CASCADE
        ON UPDATE CASCADE
) ENGINE=InnoDB;
