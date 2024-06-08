create database borrowbook;

use borrowbook;

create table book(book_id varchar(10), book_name varchar(10), book_author varchar(10), book_type varchar(10), primary key(book_id));
SELECT * FROM borrowbook.book;
drop table book;

create table student(student_id varchar(10), student_name varchar(30), student_email varchar(30), primary key(student_id));
SELECT * FROM borrowbook.student;
drop table student;

create table borrowbook (
    student_id VARCHAR(10) NOT NULL,
    book_id VARCHAR(10) NOT NULL,
    borrow_date DATE NOT NULL,
    return_date DATE NOT NULL,
    book_status int not null,
    book_name varchar(10), book_author varchar(10), book_type varchar(10),
    PRIMARY KEY (student_id, book_id),
    FOREIGN KEY (student_id) REFERENCES student(student_id),
    FOREIGN KEY (book_id) REFERENCES book(book_id)
);
SELECT * FROM borrowbook.borrowbook;
drop table borrowbook;


INSERT INTO book VALUES ('B1001', 'Doraemon', 'Fujiko', 'Comic');
INSERT INTO book VALUES ('B1002', 'Pokemon', 'Satoshi', 'Comic');
INSERT INTO book VALUES ('B1003', 'Conan', 'Aoyama', 'Comic');
INSERT INTO book VALUES ('B1004', 'Digimon', 'Yu', 'Comic');
INSERT INTO book VALUES ('B1005', '7Balls', 'Akira', 'Comic');
INSERT INTO student VALUES ('2131200037', 'Pham Le Gia Kiet', 'kiet.phamle.cit21@eiu.edu.vn');
INSERT INTO student VALUES ('2131200123', 'Le Vo Khanh Minh', 'minh.levo.cit21@eiu.edu.vn');
delete from student where student_id = "2231200017";
