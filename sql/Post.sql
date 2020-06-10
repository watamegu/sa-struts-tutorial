CREATE TABLE post (
id IDENTITY NOT NULL PRIMARY KEY,
title VARCHAR(50),
content TEXT,
user_id BIGINT
);

INSERT INTO post (title,content,user_id) VALUES('テストメモ１','Hello, Seasar2!','1');
INSERT INTO post (title,content,user_id) VALUES('テストメモ２','おはようございます。','1');
INSERT INTO post (title,content,user_id) VALUES('テストメモ３','こんばんは。','2');