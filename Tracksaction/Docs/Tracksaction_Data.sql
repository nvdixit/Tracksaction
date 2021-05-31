USE Tracksaction_data;
SELECT * FROM Credit_Cards;
SELECT * FROM Transactions;

TRUNCATE TABLE Transactions;
TRUNCATE TABLE Credit_Cards;

SELECT MAX(id) from Credit_Cards;

DELETE FROM Credit_Cards WHERE id=6;
