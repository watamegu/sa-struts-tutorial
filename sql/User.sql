CREATE TABLE user (
id IDENTITY NOT NULL PRIMARY KEY,
name VARCHAR(20) NOT NULL,
email VARCHAR(50) NOT NULL,
password VARCHAR(20) NOT NULL
);

INSERT INTO user (name,email,password) VALUES('test1','test1@seasar2.org','password');
INSERT INTO user (name,email,password) VALUES('test2','test2@seasar2.org','password');
INSERT INTO user (name,email,password) VALUES('test3','test3@seasar2.org','password');
INSERT INTO user (name,email,password) VALUES('test4','test4@seasar2.org','password');
INSERT INTO user (name,email,password) VALUES('test5','test5@seasar2.org','password');