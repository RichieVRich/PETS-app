BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "vertebrate" (
	"PetID"	INTEGER UNIQUE,
	"Name"	TEXT NOT NULL,
	"Fixed"	TEXT NOT NULL,
	"Sex"	TEXT NOT NULL,
	"DOB"	TEXT,
	"Age"	INTEGER,
	"Species"	TEXT,
	PRIMARY KEY("PetID" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "Species" (
	"Mammal"	TEXT DEFAULT 'mammal',
	"Fish"	TEXT DEFAULT 'fish',
	"Amphibian"	TEXT DEFAULT 'amphibian',
	"Reptile"	TEXT DEFAULT 'reptile',
	"Avian"	TEXT DEFAULT 'avian'
);
COMMIT;
