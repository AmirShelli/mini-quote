DROP TABLE IF EXISTS "QUOTE";
DROP TABLE IF EXISTS "USERS";
CREATE TABLE "USERS" (
                         user_Id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(50) NOT NULL,
                         email VARCHAR(100) NOT NULL,
                         password VARCHAR(50) NOT NULL,
                         created_At DATE NOT NULL DEFAULT CURRENT_TIMESTAMP,
                         logged_In BOOLEAN DEFAULT false
);
CREATE TABLE "QUOTE" (
                        quote_Id INT AUTO_INCREMENT  PRIMARY KEY,
                        user_Id INT NOT NULL,
                        text VARCHAR(50) NOT NULL,
                        votes INT NOT NULL,
                        foreign key (user_Id) references USERS(user_Id)

);
