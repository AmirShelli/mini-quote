DROP TABLE IF EXISTS "VOTE";
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
                        text VARCHAR(3000) NOT NULL,
                        created_At DATE DEFAULT CURRENT_TIMESTAMP,
                        votes INT,
                        foreign key (user_Id) references USERS(user_Id) ON DELETE CASCADE

);
CREATE TABLE VOTE (
                      vote_id INT AUTO_INCREMENT PRIMARY KEY,
                      user_id INT NOT NULL,
                      quote_id INT NOT NULL,
                      val INT DEFAULT 0,
                      created_At DATE NOT NULL DEFAULT CURRENT_TIMESTAMP,
                      FOREIGN KEY (user_id) REFERENCES USERS (user_id),
                      FOREIGN KEY (quote_id) REFERENCES QUOTE (quote_id),
                      UNIQUE (user_id, quote_id)
);

