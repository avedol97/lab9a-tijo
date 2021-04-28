DROP TABLE IF EXISTS films;

CREATE TABLE films (
	id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	title VARCHAR(100)
);

INSERT INTO films VALUES (1, 'System');
INSERT INTO films VALUES (2, 'Piraci z Krzemowej Doliny');
INSERT INTO films VALUES (3, 'Kontrola absolutna');
INSERT INTO films VALUES (4, 'Kod nieśmiertelności');
INSERT INTO films VALUES (5, 'Ex Machina');
INSERT INTO films VALUES (6, 'Hakerzy');
INSERT INTO films VALUES (7, 'Tron');
INSERT INTO films VALUES (8, 'Tron: Dziedzictwo');
INSERT INTO films VALUES (9, 'Ja, robot');
