DROP TABLE IF EXISTS "USERS";
CREATE TABLE "USERS" (
                      user_Id INT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(50) NOT NULL,
                      email VARCHAR(100) NOT NULL,
                      password VARCHAR(50) NOT NULL,
                      created_At DATE NOT NULL DEFAULT CURRENT_TIMESTAMP,
                      logged_In BOOLEAN DEFAULT false
);

DROP TABLE IF EXISTS "QUOTE";
CREATE TABLE "QUOTE" (
                        quote_Id INT AUTO_INCREMENT  PRIMARY KEY,
                        text VARCHAR(50) NOT NULL,
                        author VARCHAR(50) NOT NULL,
                        votes INT NOT NULL
);