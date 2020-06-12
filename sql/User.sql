CREATE TABLE user (
id IDENTITY NOT NULL PRIMARY KEY,
name VARCHAR(20) NOT NULL,
email VARCHAR(50) NOT NULL,
password VARCHAR(20) NOT NULL
admin BOOLEAN NOT NULL
);

INSERT INTO user (name,email,password,admin) VALUES('test1','test1@seasar2.org','password',true);
INSERT INTO user (name,email,password,admin) VALUES('test2','test2@seasar2.org','password',false);
INSERT INTO user (name,email,password,admin) VALUES('test3','test3@seasar2.org','password',false);
INSERT INTO user (name,email,password,admin) VALUES('test4','test4@seasar2.org','password',false);
INSERT INTO user (name,email,password,admin) VALUES('test5','test5@seasar2.org','password',false);