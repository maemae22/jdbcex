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

-- 자동 로그인 구현 위해서, 임의의 문자열을 보관하기 위한 uuid 컬럼 추가
ALTER TABLE tbl_member add column uuid varchar(50);