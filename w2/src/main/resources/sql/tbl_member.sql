show tables;

create table tbl_member (
    mid varchar(50) primary key ,
    mpw varchar(50) not null ,
    mname varchar(100) not null
);

INSERT INTO tbl_member (mid, mpw, mname) VALUES ('user00', '1111', '사용자0');
INSERT INTO tbl_member (mid, mpw, mname) VALUES ('user01', '1111', '사용자1');
INSERT INTO tbl_member (mid, mpw, mname) VALUES ('user02', '1111', '사용자2');

SELECT * FROM tbl_member where mid='user00' and mpw = '1111';

SELECT * FROM tbl_member;