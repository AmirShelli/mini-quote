DROP TABLE IF EXISTS "USER";
CREATE TABLE "USER" (
                      userId INT AUTO_INCREMENT  PRIMARY KEY,
                      login VARCHAR(50) NOT NULL,
                      password VARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS "QUOTE";
CREATE TABLE "QUOTE" (
                        quoteId INT AUTO_INCREMENT  PRIMARY KEY,
                        text VARCHAR(50) NOT NULL,
                        author VARCHAR(50) NOT NULL,
                        votes INT NOT NULL
);