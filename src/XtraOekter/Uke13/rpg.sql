-- Opprett databasen
DROP DATABASE IF EXISTS rpg;
CREATE DATABASE rpg;

-- Bruk databasen
USE rpg;

-- Opprett tabellen
CREATE TABLE RPGcharacter (
    character_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    strength INT NULL,
    health INT NULL,
    xp INT NULL,
    mp INT NULL
);

-- Setter inn 5 rader med data
INSERT INTO RPGcharacter (name, type, strength, health, xp, mp) VALUES
("Borirmir","Warrior",8,5,3, null),
("Snaga", "Ork", null, null, null, null),
("Gandalf", "Wizard", 5, 3, 8, 9),
("Saruman", "Wizard", 3, 2, 4, 5),
("Aragon","Warrior",10,10,6, null),
("Snirk", "Ork", null, null, null, null),
("Legolas", "Wizard", 6, 5, 6, 3),
("Sauron", "Wizard", 10, 10, 9, 10);


SELECT * FROM rpg.RPGcharacter;